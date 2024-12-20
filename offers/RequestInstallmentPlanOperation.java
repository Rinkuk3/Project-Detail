package com.td.mbna.msec.midtier.offers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.td.api.mbcca.response.account.featureview.FeatureView;
import com.td.api.mbofp.response.installmentplan.AddTargetPromotionAgreementFinancialEventResponse;
import com.td.mbna.msec.midtier.disclosure.GetDisclosureOperation;
import com.td.mbna.msec.midtier.disclosure.payload.getdisclosure.GetDisclosureRequest;
import com.td.mbna.msec.midtier.disclosure.payload.getdisclosure.GetDisclosureResponse;
import com.td.mbna.msec.midtier.disclosure.payload.getdisclosure.RequestPayload;
import com.td.mbna.msec.midtier.framework.MsecVlangValidator;
import com.td.mbna.msec.midtier.mbalert.MbnaAlert;
import com.td.mbna.msec.midtier.mbcca.MbnaCCA;
import com.td.mbna.msec.midtier.mbofp.MbnaOFP;
import com.td.mbna.msec.midtier.offers.payload.requestInstallmentPlan.RequestInstallmentPlanRequest;
import com.td.mbna.msec.midtier.offers.payload.requestInstallmentPlan.RequestInstallmentPlanResponse;
import com.td.mbna.msec.midtier.offers.payload.requestInstallmentPlan.ResponsePayload;
import com.td.mbna.msec.midtier.service.EmailInfo;
import com.td.mbna.msec.midtier.service.MsecMidtierCommonOperations;
import com.td.mbna.msec.midtier.service.MsecValidator;
import com.td.mbna.msec.midtier.services.EmailInfoImpl;
import com.td.mbna.msec.midtier.services.IMBNAConstants;
import com.td.mbna.msec.midtier.types.common.*;
import com.td.mbna.msec.midtier.util.ConfigUtil;
import com.td.mbna.msec.midtier.util.CustomerNotesUtil;
import com.td.mbna.msec.midtier.util.ExceptionUtil;
import com.td.mbna.msec.midtier.util.MbnaLogger;
import com.td.mbna.msec.midtier.util.XMLGregorianCalendarConverter;
import com.td.mbna.msec.midtier.util.services.MidtierUtilHelper;
import com.td.mbna.msec.midtier.util.services.TDRestServiceUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springmodules.validation.valang.ValangValidator;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import javax.xml.datatype.XMLGregorianCalendar;

import static java.time.format.DateTimeFormatter.ISO_DATE;

@Service
public class RequestInstallmentPlanOperation implements MsecMidtierCommonOperations<RequestInstallmentPlanRequest, RequestInstallmentPlanResponse> {

    private static final MbnaLogger logger = new MbnaLogger(RequestInstallmentPlanOperation.class);

    @Autowired
    private MbnaCCA mbnaCCA;

    @Autowired
    private MbnaOFP mbnaOFP;

    @Autowired
    private static MbnaAlert mbnaAlert;

    @Autowired
    private ValangValidator requestIpPlanValidator;

    @Autowired
    private GetDisclosureOperation getDisclosureOperation;

    private List<String> profanityList = null;

    private static final String PROFANITY_LIST_FILE = "ipNickNameProfanityList.json";

    private static final String CONSENT_CAPTURE_FAILURE = "MS542";

    private static final String DUPLICATE_NICKNAME = "MS901";
    private static final String INVALID_NICKNAME = "MS902";
    private static final String NICKNAME_FIELD = "nickName";
    private static final String IP_CREATION_ERROR = "MS603";

    private static final String IP_FIRST_NAME = "firstName";
    private static final String IP_APP_DATE = "appDate";
    private static final String IP_LAST_FOUR_DIGIT = "cardLastFourDigit";
    private static final String IP_NICK_NAME = "planNickname";
    private static final String IP_TERM = "planTerm";
    private static final String IP_AIR = "air";
    private static final String IP_FEE_RATE = "feeRate";
    private static final String IP_EFFECTIVE_DATE = "effctvDate";
    private static final String IP_PURCHASE_AMT = "purchAmt";
    private static final String IP_BORROW_COST = "borrowCost";
    private static final String IP_FEE_AMT = "feeAmt";
    private static final String IP_TOTAL_INTEREST = "totalInterest";
    private static final String IP_TOTAL_PLAN_AMT = "totalPlanAmt";
    private static final String IP_MONTHLY_PLAN_AMT = "monthlyPlanAmt";
    private static final String IP_MIN_PAYMENT = "minPmt";

    private static final ThreadLocal<DecimalFormat> DECIMAL_FORMAT_THREAD_LOCAL = ThreadLocal.withInitial(() -> new DecimalFormat("#0.00"));

    private final static String IP_MPPD_DISCLOSURE = "MPPD";

    private final static String IP_MPPT_DISCLOSURE = "MPPT";
    private static final String DATE_FORMAT_SLASH = "MM/dd/yyyy";

    @Override
    public RequestInstallmentPlanResponse invokeService(RequestInstallmentPlanRequest request, String... token) {

        RequestInstallmentPlanResponse response = null;

        //only need to validate
        if (validateOnly(request)) {
            return validateInstallmentPlanRequest(request, token);
        }

        //update offer disposition
        Map<String, Object> updateParameters = new HashMap<>();

        updateParameters.put("roleCD", "PRIMARY-ACCOUNT-HOLDER");
        updateParameters.put("acctId", request.getAcctNum());
        updateParameters.put("subProductId", request.getRequestPayload().getProductId());

        try {

            mbnaOFP.updateOfferDisposition(updateParameters, token[0]);

            //full-fillment
            AddTargetPromotionAgreementFinancialEventResponse responseIP = mbnaOFP.requestInstallmentPlan(request, token[0]);
            response = new RequestInstallmentPlanResponse();
            response.setResponsePayload(new ResponsePayload());
            response.getResponsePayload().setEventId(responseIP.getPromotionAgreementFinancialEventId());

        } catch (Exception e) {
            logger.error("RequestInstallmentPlanOperation:invokeService", "Error in Installment Plan creation", e);
            throw MidtierUtilHelper.prepareBusinessException(IP_CREATION_ERROR, "Error in creating IP");
        }


        return response;
    }

    private boolean validateOnly(RequestInstallmentPlanRequest request) {
        return request.getRequestPayload().getConfirmed() == null || !request.getRequestPayload().getConfirmed();
    }

    private RequestInstallmentPlanResponse validateInstallmentPlanRequest(RequestInstallmentPlanRequest request, String... token) {

        RequestInstallmentPlanResponse requestInstallmentPlanResponse = new RequestInstallmentPlanResponse();
        requestInstallmentPlanResponse.setResponsePayload(new ResponsePayload());

        FeatureView featureView = mbnaCCA.retrieveFeatureView(request.getSessionInfo().getConnectId(), request.getAcctNum(), token[0]);

        request.getRequestPayload().getInstallmentPlanDetails().setMinPayOptionSetID(featureView.getMinimumPaymentFeatureId());

        //this ensures, it is loaded only once, application, and not for every request
        if (profanityList == null) {
            try {
				Gson gson = new GsonBuilder()
						.serializeNulls()
						.setPrettyPrinting()
						.registerTypeAdapter(XMLGregorianCalendar.class,
								new XMLGregorianCalendarConverter.Serializer())
						.create();
                String filePath = ConfigUtil.getConfigDirectory() + PROFANITY_LIST_FILE;
                String jsonStr = TDRestServiceUtil.readLineByLineJava8(filePath);
                profanityList = gson.fromJson(jsonStr, new TypeToken<List<String>>(){}.getType()); 
            } catch (Exception e) {
                logger.error("RequestInstallmentPlanOperation:invokeService ", "Error in loading Profanity List from file", e);
                throw ExceptionUtil.genRuntimeException(e);
            }
        }

        //check if nickname is duplicate
        if (mbnaCCA.isDuplicateNickName(request.getSessionInfo().getConnectId(), request.getAcctNum(), request.getRequestPayload().getNickName(), token[0])) {
            logger.error("Duplicate nick name =" + request.getRequestPayload().getNickName() + " accountId=" + request.getAcctNum());
            throw MidtierUtilHelper.prepareValidationException(NICKNAME_FIELD, DUPLICATE_NICKNAME, "duplicate nickname");
        }

        //check if nickname is in the profanity list
        if (profanityList != null && profanityList.stream().anyMatch(request.getRequestPayload().getNickName()::equalsIgnoreCase)) {
            logger.error("Nickname " + request.getRequestPayload().getNickName() + " is in the profanity list ");
            throw MidtierUtilHelper.prepareValidationException(NICKNAME_FIELD, INVALID_NICKNAME, "inappropriate nickname");
        }

        requestInstallmentPlanResponse.getResponsePayload().setDisclosureInfo(new ArrayList<>());

        //retrieve mppt
        StaticDisclosureCacheCmd staticDisclosureCacheCmd = new StaticDisclosureCacheCmd(getDisclosureOperation, request.getLanguagePref(), IP_MPPT_DISCLOSURE);

        boolean executeFromCache = false;

        try {

            //executeFromCache = staticDisclosureCacheCmd.executeFromCache();

            if (!executeFromCache) {
                logger.debug("RequestInstallmentPlanOperation", " retrieving MPPT from live service.");
                //staticDisclosureCacheCmd.execute();
            }

            requestInstallmentPlanResponse.getResponsePayload().setStaticDisclosureContent(staticDisclosureCacheCmd.getDisclosureText());
            requestInstallmentPlanResponse.getResponsePayload().getDisclosureInfo().add(staticDisclosureCacheCmd.getDisclosureInfoType());

        } catch (Exception e) {
            logger.error("RequestInstallmentPlanOperation", " error in retriving MPPT", e);
            throw ExceptionUtil.genRuntimeException(e);
        }

        //retrieve mppd
        GetDisclosureRequest getMppdDisclosureRequest = new GetDisclosureRequest();
        getMppdDisclosureRequest.setSessionInfo(request.getSessionInfo());
        getMppdDisclosureRequest.setRequestPayload(new RequestPayload());


        DisclosureInputType disclosureInputType = new DisclosureInputType();
        disclosureInputType.setInstallmentPlanDetails(request.getRequestPayload().getInstallmentPlanDetails());
        getMppdDisclosureRequest.getRequestPayload().setDisclosureInput(disclosureInputType);
        getMppdDisclosureRequest.getRequestPayload().setDisclosureType(IP_MPPD_DISCLOSURE);
        getMppdDisclosureRequest.setLanguagePref(request.getLanguagePref());

        GetDisclosureResponse mppdDisclosure = getDisclosureOperation.invokeService(getMppdDisclosureRequest);

        requestInstallmentPlanResponse.getResponsePayload().setDynamicDisclosureContent(mppdDisclosure.getResponsePayload().getContent());
        requestInstallmentPlanResponse.getResponsePayload().getDisclosureInfo().add(mppdDisclosure.getResponsePayload().getDisclosureInfo());
        requestInstallmentPlanResponse.getResponsePayload().setInstallmentPlanDetails(request.getRequestPayload().getInstallmentPlanDetails());

        return requestInstallmentPlanResponse;
    }


    @Override
    public boolean requiresDisclosureConsent() {
        return true;
    }

    @Override
    public String getConsentDisclosureFailedMsgCode() {
        return CONSENT_CAPTURE_FAILURE;
    }

    @Override
    public boolean generateAutoComment() {
        return true;
    }

    @Override
    public List<String> createAutoComment(BaseRequest request, BaseResponse response) {

        List<String> comments = new ArrayList<String>();
        RequestInstallmentPlanRequest req = (RequestInstallmentPlanRequest) request;

        //customer notes to be created only when IP is created. if request is to validate, no need to create customer notes
        if (!validateOnly(req)) {

            com.td.mbna.msec.midtier.offers.payload.requestInstallmentPlan.RequestPayload payload = req.getRequestPayload();
            String header = CustomerNotesUtil.getHeaderContent(request, "Submit IP");

            StringBuilder strBuffer = new StringBuilder();
            strBuffer.append(header);

            SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_SLASH);
            NumberFormat moneyFormatter = NumberFormat.getCurrencyInstance();

            if (payload != null) {
                strBuffer.append("Transaction: ").append(payload.getReferenceNumber());
                strBuffer.append(CustomerNotesUtil.SPACE_SEPARATOR);
                strBuffer.append("Amount: ").append(moneyFormatter.format(payload.getInstallmentPlanDetails().getPurchaseAmt()));
                strBuffer.append(CustomerNotesUtil.SPACE_SEPARATOR);
                strBuffer.append("Fee: ").append(payload.getInstallmentPlanDetails().getPercentageFee()).append("%");
                strBuffer.append(CustomerNotesUtil.SPACE_SEPARATOR);
                strBuffer.append("Nickname: ").append(payload.getNickName());
                strBuffer.append(CustomerNotesUtil.SPACE_SEPARATOR);
                strBuffer.append("Term: ").append(payload.getInstallmentPlanDetails().getPromotionFeatureDuration().shortValue()).append(CustomerNotesUtil.SPACE_SEPARATOR).append(payload.getInstallmentPlanDetails().getPromotionFeatureDurationTypeCd());
                strBuffer.append(CustomerNotesUtil.SPACE_SEPARATOR);
                strBuffer.append("Interest Rate: ").append(payload.getInstallmentPlanDetails().getPromotionFeatureAnnualInterestRate()).append("%");
                strBuffer.append(CustomerNotesUtil.SPACE_SEPARATOR);
                strBuffer.append("Creation Date: ").append(dateFormat.format(new Date()));
            }
            comments.add(strBuffer.toString());
            logger.info("creating auto comment for Submit IP");
        }

        return comments;
    }

    private static int IP_RETRY_INTERVAL = Integer.parseInt(ConfigUtil.getProperty("IP.email.retry.interval", "11"));
    private static int IP_RETRY_COUNT = Integer.parseInt(ConfigUtil.getProperty("IP.email.retry.count", "2"));
    private static final Consumer<EmailInfo> EMAIL_RETRY_LOGIC = emailInfo -> {
        int retry = 0;
        boolean sent = false;
        while (retry < IP_RETRY_COUNT) {
            retry++;
            try {
                sent = mbnaAlert.addAlertEvent(emailInfo);
                if (sent){
                	break;
                }
            } catch (Exception e) {
                logger.error("callEmailNotification", "sendIPEmail failed:" + retry, e);
                if (retry < IP_RETRY_COUNT) {
                    delay(IP_RETRY_INTERVAL);
                }
            }
        }
        if (!sent) { //
            logIPEmailInfo(emailInfo);
        }
    };

    @Override
    public EmailInfo getEmailInfoBean(BaseRequest request, BaseResponse response) {
        RequestInstallmentPlanRequest requestInstallmentPlanRequest = ((RequestInstallmentPlanRequest) request);
        if (validateOnly(requestInstallmentPlanRequest)) {
            return null;
        }
        EmailNotificationInfoType emailNotificationInfoType = requestInstallmentPlanRequest.getRequestPayload().getEmailNotificationInfo();
        final EmailInfoImpl emailInfoBean = new EmailInfoImpl(emailNotificationInfoType, request.getSessionInfo().getLoginId(), IMBNAConstants.ALERT_TYPE_CD_IPENROLLMENT, request.getIsPrimaryUser() == null ? false : request.getIsPrimaryUser().booleanValue());
        emailInfoBean.setConnectId(request.getSessionInfo().getConnectId());
        if (emailNotificationInfoType == null) {
        	return null;
        }

        /* IP Email has to be send out to all the customers regardless of optin/optout setting according to https://track.td.com/browse/MBNA-14636 */
        emailInfoBean.setTriggerEmailNotification(true);
        emailInfoBean.setAcctNum(request.getAcctNum());
        
        InstallmentPlanDetails details = requestInstallmentPlanRequest.getRequestPayload().getInstallmentPlanDetails();
        LocalDate now = LocalDate.now();
        emailInfoBean.addAttribute(IP_FIRST_NAME, emailNotificationInfoType.getPrimaryUserFirstName());
        emailInfoBean.addAttribute(IP_APP_DATE, ISO_DATE.format(now));
        emailInfoBean.addAttribute(IP_LAST_FOUR_DIGIT, emailNotificationInfoType.getPrimaryUserCardEnding());        
        emailInfoBean.addAttribute(IP_NICK_NAME, details.getNickName());
        emailInfoBean.addAttribute(IP_TERM, details.getPromotionFeatureDuration());
        emailInfoBean.addAttribute(IP_AIR, DECIMAL_FORMAT_THREAD_LOCAL.get().format(details.getPromotionFeatureAnnualInterestRate()));
        emailInfoBean.addAttribute(IP_FEE_RATE, DECIMAL_FORMAT_THREAD_LOCAL.get().format(details.getPercentageFee()));
        emailInfoBean.addAttribute(IP_EFFECTIVE_DATE, ISO_DATE.format(now));
        emailInfoBean.addAttribute(IP_PURCHASE_AMT, DECIMAL_FORMAT_THREAD_LOCAL.get().format(details.getPurchaseAmt()));
        emailInfoBean.addAttribute(IP_BORROW_COST, DECIMAL_FORMAT_THREAD_LOCAL.get().format(details.getCostOfBorrowingAmt()));
        emailInfoBean.addAttribute(IP_FEE_AMT, DECIMAL_FORMAT_THREAD_LOCAL.get().format(details.getFixedAmtFee()));
        emailInfoBean.addAttribute(IP_TOTAL_INTEREST, DECIMAL_FORMAT_THREAD_LOCAL.get().format(details.getTotalEstimatedInterestAmt()));
        emailInfoBean.addAttribute(IP_TOTAL_PLAN_AMT, DECIMAL_FORMAT_THREAD_LOCAL.get().format(details.getTotalPaymentPlanAmt()));
        emailInfoBean.addAttribute(IP_MONTHLY_PLAN_AMT, DECIMAL_FORMAT_THREAD_LOCAL.get().format(details.getMonthlyPaymentAmt()));
        emailInfoBean.addAttribute(IP_MIN_PAYMENT, details.getMinPayOptionSetID());
        logger.debug("attributes:" + emailInfoBean.getAttributes());

        emailInfoBean.setRetryLogic(EMAIL_RETRY_LOGIC);
        return emailInfoBean;
    }

    @Override
    public MsecValidator getValidator() {
        return new MsecVlangValidator(requestIpPlanValidator);
    }

    private static void delay(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            logger.warn("Thread interrupted");
        }
    }

    private static final String IP_EMAIL_INFO_LOG_FORMAT = "%n==SEND IP EMAIL FAILED INFO START(%s)==%ntsysAccountId=%s%nlanguagePreference=%s%nbusinessEventId=%s%nchannel=Secure Site%nemailAddress=%s%nfirstName=%s%nAppDate=%s%ncardLastFourDigit=%s%nPlanNickname=%s%nPlanTerm=%s%nAIR=%s%nFeeRate=%s%nEffctvDate=%s%nPurchAmt=%s%nBorrowCost=%s%nFeeAmt=%s%nTotalInterest=%s%nTotalPlanAmt=%s%nMonthlyPlanAmt=%s%nMinPmt=%s%nEventId=SEND IP EMAIL FAILED INFO%n==SEND IP EMAIL FAILED INFO END==";

    private static void logIPEmailInfo(EmailInfo emailInfo) {
        logger.mandatory(String.format(IP_EMAIL_INFO_LOG_FORMAT, UUID.randomUUID().toString(), emailInfo.getAcctNum(),emailInfo.getPrimaryLanguagePref(), emailInfo.getBusinessEventID(), emailInfo.getPrimaryEmailAddress(), emailInfo.getPrimaryUserInfo().getFirstName(),
                emailInfo.getAttribute(IP_APP_DATE), emailInfo.getCardEnding(), emailInfo.getAttribute(IP_NICK_NAME), emailInfo.getAttribute(IP_TERM), emailInfo.getAttribute(IP_AIR), emailInfo.getAttribute(IP_FEE_RATE),
                emailInfo.getAttribute(IP_EFFECTIVE_DATE), emailInfo.getAttribute(IP_PURCHASE_AMT), emailInfo.getAttribute(IP_BORROW_COST), emailInfo.getAttribute(IP_FEE_AMT),
                emailInfo.getAttribute(IP_TOTAL_INTEREST), emailInfo.getAttribute(IP_TOTAL_PLAN_AMT), emailInfo.getAttribute(IP_MONTHLY_PLAN_AMT), emailInfo.getAttribute(IP_MIN_PAYMENT)));
    }

}
