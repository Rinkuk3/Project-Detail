package com.td.mbna.msec.midtier.creditcard;

import static java.time.format.DateTimeFormatter.ISO_DATE;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.remoting.jaxws.JaxWsSoapFaultException;
import org.springframework.stereotype.Component;
import org.springmodules.validation.valang.ValangValidator;

import com.mbnaweb.xsd.msgs.customerprofile.CustomerAcctProfileType;
import com.mbnaweb.xsd.msgs.customerprofile.CustomerInfoType;
import com.td.mbna.msec.midtier.creditcard.payload.increasecardlimit.IncreaseCardLimitRequest;
import com.td.mbna.msec.midtier.creditcard.payload.increasecardlimit.IncreaseCardLimitResponse;
import com.td.mbna.msec.midtier.creditcard.payload.increasecardlimit.RequestPayload;
import com.td.mbna.msec.midtier.framework.MsecVlangValidator;
import com.td.mbna.msec.midtier.mbcca.MbnaCCA;
import com.td.mbna.msec.midtier.mbcca.adaptor.TdCreditCardAdaptor;
import com.td.mbna.msec.midtier.mbofp.MbnaOFP;
import com.td.mbna.msec.midtier.persistance.entity.CreditLimitIncEvent;
//import com.td.mbna.msec.midtier.persistance.hibernate.DBService;
import com.td.mbna.msec.midtier.persistance.mybatis.DBMybatisService;
import com.td.mbna.msec.midtier.service.EmailInfo;
import com.td.mbna.msec.midtier.service.MsecMidtierCommonOperations;
import com.td.mbna.msec.midtier.service.MsecValidator;
import com.td.mbna.msec.midtier.services.EmailInfoImpl;
import com.td.mbna.msec.midtier.services.IMBNAConstants;
import com.td.mbna.msec.midtier.tdwsservices.RcpFilter;
import com.td.mbna.msec.midtier.tdwsservices.TdOdsCustomerProfileService;
import com.td.mbna.msec.midtier.types.common.BaseRequest;
import com.td.mbna.msec.midtier.types.common.BaseResponse;
import com.td.mbna.msec.midtier.types.common.CustomerIncomeInfoType;
import com.td.mbna.msec.midtier.types.common.EmailNotificationInfoType;
import com.td.mbna.msec.midtier.util.BackEndSrvcUtil;
import com.td.mbna.msec.midtier.util.CustomerNotesUtil;
import com.td.mbna.msec.midtier.util.CustomerProfileUtil;
import com.td.mbna.msec.midtier.util.JaxbUtil;
import com.td.mbna.msec.midtier.util.MBNAPropertiesUtil;
import com.td.mbna.msec.midtier.util.MbnaLogger;
import com.td.mbna.msec.midtier.util.UuidUtil;
import com.td.mbna.msec.midtier.util.ods.OdsHelper;
import com.td.mbna.msec.midtier.util.services.MidtierUtilHelper;
import com.td.mbna.msec.midtier.util.services.TDRestServiceUtil;
import com.td.mbna.msec.midtier.util.tsys.TsysHelper;
import com.td.mbna.msec.midtier.util.tsys.TsysRequest;

@Component
public class IncreaseCardLimitOperation implements MsecMidtierCommonOperations<IncreaseCardLimitRequest, IncreaseCardLimitResponse> {
    private static MbnaLogger logger = new MbnaLogger(IncreaseCardLimitOperation.class);

    /**
     * Name of the request template for updating customer profile information
     */

    private final static String UPDATE_CLI_CUSTOMER_PROFILE = "odsCliUpdateCustomer";
    private final static String UPDATE_CLI_CUSTOMER_PROFILE_RS = "odsCliUpdateCustomerRs";
    private final static String ErrorCode = "MS607";
    private final static String CREDIT_LIMIT_CHANGE_ACT = "INCR";
    
    private static final String CONTENT_CD = "contentCd";
	private static final String INCR_FIRST_NAME = "firstName";
	private static final String INCR_DATE = "appDate";
	private static final String INCR_PRODUCT_NAME = "productName";
	private static final String INCR_FOUR_DIGIT = "cardLastFourDigit";
	
    @Autowired
    private ValangValidator increaseCardLimitRequestValidator;

    @Autowired
    private MbnaOFP mbnaOFP;

    private MsecValidator msecValidator;

    @Autowired
    private MbnaCCA mbnaCCA;

    @PostConstruct
    private void init() {
        msecValidator = new MsecVlangValidator(increaseCardLimitRequestValidator);
    }

    @Override
    public IncreaseCardLimitResponse invokeService(IncreaseCardLimitRequest request, String... token) {
    	
    	String methodName = "IncreaseCardLimitOperation:invokeService";
        IncreaseCardLimitResponse resposne = new IncreaseCardLimitResponse();
        if(request == null || request.getRequestPayload() ==  null ){
        	String desc = "CLI/ACLI 1::0 - request is null" ;
			logger.error(methodName,desc);
			throw MidtierUtilHelper.prepareBusinessException(GENERAL_ERROR,desc);
        }
        if (request.getRequestPayload().getConfirmed() == null || !request.getRequestPayload().getConfirmed()) {   // only run through the validator test
            return resposne;
        }

        boolean isLongForm = request.getRequestPayload().getLongForm() == null ? false : request.getRequestPayload().getLongForm().booleanValue();

        if (isLongForm) { //cli
        	
        	// 1updateCustomerProfile
            boolean rc = updateProfileODS(request);

            if (!rc) {
            	String desc = "CLI 1::1 - updateProfile call failed" ;
            	logger.error(methodName,desc);
            	throw MidtierUtilHelper.prepareBusinessException(GENERAL_ERROR,desc);
            }

            // 2 update disposition
            String offerId = request.getRequestPayload().getPromotionOfferId();
            if (offerId != null && offerId.length() > 0) {
                updateOfferDisposition(request, token);
            }
            // 3 update database
            rc = writeToDB(request);
            if (!rc) {
            	String desc = "CLI 3 - writeToDB call failed" ;
            	logger.error(methodName,desc);
            	throw MidtierUtilHelper.prepareBusinessException(GENERAL_ERROR,desc);
            }


            //If long form is allowed to update, enable the update operation and remove fake response

            resposne.setStatus("Success");
            resposne.getResponsePayload().setConfirmationNumber("");
            resposne.getResponsePayload().setStatus(true);
        } else {   // short form used :: acli
            String offerId = request.getRequestPayload().getPromotionOfferId();
            if (offerId != null && offerId.length() > 0) {
                updateOfferDisposition(request, token);
            }
            resposne = updateCardLimit(request, token);

            if (null == resposne) {
            	String desc = "ACLI 1::3 - updateCardLimit call failed" ;
            	logger.error(methodName,desc);
            	throw MidtierUtilHelper.prepareBusinessException(GENERAL_ERROR,desc);
            } 
            resposne.getResponsePayload().setStatus(true);
        }

        return resposne;
    }

    /**
     * update Offer Disposition.
     *
     * @param request
     * @return - update status
     */
    private void updateOfferDisposition(final IncreaseCardLimitRequest request, String... token) {
    	String methodName = "IncreaseCardLimitOperation:updateOfferDisposition";
    	String acctNum = request.getAcctNum();
    	
    	Map<String, Object> paramValues = new HashMap<>();
    	paramValues.put("msgId1", UuidUtil.genUuid());
    	paramValues.put("msgId2", UuidUtil.genUuid());
    	paramValues.put("offerId", request.getRequestPayload().getPromotionOfferId());
    	paramValues.put("acctId", acctNum);
    	paramValues.put("roleCD", request.getRequestPayload().getRoleCD());
    	paramValues.put("subProductId", request.getRequestPayload().getPromotionOfferId());
    	
    	if (request.isMultiCard()) {
    		paramValues.put("allCards", false);
    		paramValues.put("cardNum", request.getCardNum());
    	}
    	
        try {
            this.mbnaOFP.updateOfferDisposition(paramValues, token[0]);

        } catch (Exception e) {

			String errorCode = GENERAL_ERROR;
			if (e instanceof JaxWsSoapFaultException) {
              errorCode = TDRestServiceUtil.getSoapErrorMessage(methodName,((JaxWsSoapFaultException) e).getFault(),GENERAL_ERROR);
			}
			String desc = "CLI/ACLI 2 - call mbnaOFP.updateOfferDisposition failed"+e.getLocalizedMessage() ;
			logger.error(methodName,desc);
			throw MidtierUtilHelper.prepareBusinessException(errorCode,desc);
        }
    }


    /**
     * Record CLI fields to DB.
     *
     * @param request
     * @return - update status
     */
    private boolean writeToDB(final IncreaseCardLimitRequest request) {
        String offerId = request.getRequestPayload().getPromotionOfferId();

        CreditLimitIncEvent cliEvent = new CreditLimitIncEvent();
        cliEvent.setAliasCustId(request.getAliasCustId());
        cliEvent.setCustId(request.getCustId());
        cliEvent.setCurrentCreditLimit(request.getRequestPayload().getCurrentCreditLimit());
        cliEvent.setReqCreditLimit(request.getRequestPayload().getCreditLimit());
        cliEvent.setHousingStatus(request.getRequestPayload().getCustomerInfo().getHousingStatus());
        cliEvent.setHousingPayment(request.getRequestPayload().getCustomerInfo().getHousingPayment());
        cliEvent.setAccountNumber(request.getAcctNum());

        if (request.getRequestPayload().getLengthOfService() != null && request.getRequestPayload().getLengthOfService().trim().length() > 0){
        	cliEvent.setLengthOfService(request.getRequestPayload().getLengthOfService());
        }

        if (offerId != null && offerId.trim().length() > 0) {
            cliEvent.setOfferId(offerId);
            cliEvent.setPreApprovalLimit(request.getRequestPayload().getPromotionOfferAmount());
            double incper = 100.0 * (request.getRequestPayload().getPromotionOfferAmount().doubleValue() - request.getRequestPayload().getCurrentCreditLimit().doubleValue()) / request.getRequestPayload().getCurrentCreditLimit().doubleValue();
            cliEvent.setPreApprovalPercent(BigDecimal.valueOf(incper));
        } else {
            cliEvent.setPreApprovalLimit(new BigDecimal(0.0));
            cliEvent.setPreApprovalPercent(new BigDecimal(0.0));
        }

        DBMybatisService.saveCLIEvent(cliEvent);
//        DBService.saveCLIEvent(cliEvent);
        return true;
    }

    /**
     * update the credit card limit
     *
     * @param request
     * @return - update status
     */
    private IncreaseCardLimitResponse updateCardLimit(final IncreaseCardLimitRequest request, String... token) {
        try {

            // Generate updateCardLimit request for the backend web service operation
            Map<String, Object> paramValues = TsysHelper.genStandardParams(TsysRequest.updateCardLimit, request);
            paramValues.put(TdCreditCardAdaptor.NEW_LIMIT, request.getRequestPayload().getCreditLimit());

            paramValues.put(TdCreditCardAdaptor.CUR_LIMIT, request.getRequestPayload().getCurrentCreditLimit());

            paramValues.put(TdCreditCardAdaptor.CREDIT_LIMIT_CHANGE_ACTION, CREDIT_LIMIT_CHANGE_ACT);
            if (request.isMultiCard()) {
                paramValues.put("allCards", false);
                paramValues.put("cardNum", request.getCardNum());
            }


            return mbnaCCA.increaseCreditLmt(request.getAcctNum(), request.isMultiCard(),
            		request.getCardNum(), paramValues, token[0]);


        } catch (Exception e) {
        	String desc = "ACLI 2- mbnaCCA.increaseCreditLmt failed" +e.getLocalizedMessage();
			logger.error("IncreaseCardLimitOperation:updateCardLimit",desc);
			throw MidtierUtilHelper.prepareBusinessException(GENERAL_ERROR,desc);
//            throw ExceptionUtil.genRuntimeException(e);
        }
    }


    /**
     * Updates customer profile given the customer and account number information.
     *
     * @param request
     * @return - update status
     */
    private boolean updateProfileODS(final IncreaseCardLimitRequest request) {
    	String methodName ="IncreaseCardLimitOperation::updateProfileODS";
        boolean invokeUpdate = false;
        boolean grossIncomeChanged = false;
        RequestPayload reqPL = request.getRequestPayload();

        CustomerAcctProfileType cp = null;
		try {
			cp = OdsHelper.getCustAcctProfile(request.getCustId(), request.getAcctNum(), RcpFilter.PROFILE);
		} catch (Exception e) {
			String desc = "CLI 1::2 - updateProfile call failed" +e.getLocalizedMessage();
			logger.error(methodName,desc);
			return false;
//			throw MidtierUtilHelper.prepareBusinessException(GENERAL_ERROR,desc);
		}
        
        CustomerInfoType custInfo = cp.getCustInfo();
        XMLGregorianCalendar partyAgreementLatUpdatedTs = cp.getAcctInfo().getPartyAgreementLastUpdatedTS();
        
        
        if (!CustomerProfileUtil.compareUpdateTS(reqPL.getEmploymentLastUpdatedTS(), custInfo.getEmploymentLastUpdatedTS()) ||
        		!CustomerProfileUtil.compareUpdateTS(reqPL.getPrimIncomeLastUpdatedTS(), custInfo.getPrimIncomeLastUpdatedTS()) ||
        		!CustomerProfileUtil.compareUpdateTS(reqPL.getOtherIncomeLastUpdatedTS(), custInfo.getOtherIncomeLastUpdatedTS()) ||
        		!CustomerProfileUtil.compareUpdateTS(reqPL.getPartyAgreementLastUpdatedTS(), cp.getAcctInfo().getPartyAgreementLastUpdatedTS())) {
        	
        	com.td.mbna.msec.midtier.types.common.BusinessException faultInfo = new com.td.mbna.msec.midtier.types.common.BusinessException();
        	faultInfo.setErrorCode(ErrorCode);
        	faultInfo.setErrorDescription("timestamp mismatch");
        	String desc = "CLI 1::3 - IncreaseCardLimit timestamp mismatch";
        	logger.error(methodName,desc);
        	throw new com.td.mbna.msec.midtier.exceptions.BusinessException(desc, faultInfo);
        }
        
        Map<String, Object> updParamValues = new HashMap<String, Object>();
        
        SimpleDateFormat dateFmt = new SimpleDateFormat(CustomerProfileUtil.DATE_FMT);
        updParamValues.put(CustomerProfileUtil.ACCOUNT_NUMBER, request.getAcctNum());
        updParamValues.put(CustomerProfileUtil.PARTY_ID, request.getCustId());
        updParamValues.put(CustomerProfileUtil.USER_ROLE, CustomerProfileUtil.XSL_ROLE_CODE_PRIMARY);
        updParamValues.put(CustomerProfileUtil.ALIAS_CUSTOMER_ID, request.getAliasCustId());
        updParamValues.put("trackId", UuidUtil.genUuid());
        updParamValues.put(CustomerProfileUtil.XSL_PERSON_LASTUPDATEDTS, custInfo.getPersonLastUpdatedTS());
        updParamValues.put(CustomerProfileUtil.XSL_BOOK_OF_BUSINESS_LASTUPDATEDTS, custInfo.getBookOfBusLastUpdatedTS());
        updParamValues.put(CustomerProfileUtil.XSL_PARTYAGREEMENT_LASTUPDATEDTS, partyAgreementLatUpdatedTs);
        CustomerIncomeInfoType custIncomeInfo = reqPL.getCustomerInfo();
        
        // Employment
        if (!CustomerProfileUtil.compareField(reqPL.getEmployerName(), custInfo.getEmployerName()) ||
        		!CustomerProfileUtil.compareField(reqPL.getEmployerAddress(), custInfo.getEmployerAddress()) ||
        		!CustomerProfileUtil.compareField(reqPL.getEmployerCity(), custInfo.getEmployerCity()) ||
        		!CustomerProfileUtil.compareField(reqPL.getEmployerProvince(), custInfo.getEmployerProvince()) ||
        		!CustomerProfileUtil.compareField(reqPL.getEmployerPostalCode(), custInfo.getEmployerPostalCode()) ||
        		!CustomerProfileUtil.compareField(reqPL.getEmployerPhone(), custInfo.getEmployerPhone()) ||
        		!CustomerProfileUtil.compareField(reqPL.getNatureOfBusiness(), custInfo.getNatureOfBusiness()) ||
        		!CustomerProfileUtil.compareField(reqPL.getEmploymentStatus(), custInfo.getEmploymentStatus()) ||
        		!CustomerProfileUtil.compareField(reqPL.getPosition(), custInfo.getPosition()) ||
        		!CustomerProfileUtil.compareField(custIncomeInfo.getOccupation(), custInfo.getOccupation())) {
        	invokeUpdate = true;
        	updParamValues.put(CustomerProfileUtil.XSL_IS_EMPLOYMENT_CHANGED, "true");
        	if (custInfo.getEmploymentLastUpdatedTS() != null) {
        		updParamValues.put(CustomerProfileUtil.XSL_IS_EMPLOYMENT_PRESENT, "true");
        		updParamValues.put(CustomerProfileUtil.XSL_IS_EMPLOYMENT_PRESENT, "true");
        		updParamValues.put(CustomerProfileUtil.XSL_EMPLOYMENT_LASTUPDATEDTS, custInfo.getEmploymentLastUpdatedTS());
        	} else {
        		updParamValues.put(CustomerProfileUtil.XSL_IS_EMPLOYMENT_PRESENT, "false");
        	}
        	updParamValues.put(CustomerProfileUtil.XSL_EMPLOYMENT_POSITION, reqPL.getPosition() == null ? "" : reqPL.getPosition());
        	updParamValues.put(CustomerProfileUtil.XSL_EMPLOYMENT_OCCUPATION, custIncomeInfo.getOccupation() == null ? "" : custIncomeInfo.getOccupation());
        	updParamValues.put(CustomerProfileUtil.XSL_EMPLOYMENT_EMPLOYERNAME, reqPL.getEmployerName() == null ? "" : reqPL.getEmployerName());
        	updParamValues.put(CustomerProfileUtil.XSL_EMPLOYMENT_ADDRESS_LINEONE, reqPL.getEmployerAddress() == null ? "" : reqPL.getEmployerAddress());
        	updParamValues.put(CustomerProfileUtil.XSL_EMPLOYMENT_ADDRESS_LOCALITY, reqPL.getEmployerCity() == null ? "" : reqPL.getEmployerCity());
        	updParamValues.put(CustomerProfileUtil.XSL_EMPLOYMENT_ADDRESS_AREA, reqPL.getEmployerProvince() == null ? "" : reqPL.getEmployerProvince());
        	//Passing country code only if the address is updated
        	if (reqPL.getEmployerAddress() == null || reqPL.getEmployerAddress().equals("")) {
        		updParamValues.put(CustomerProfileUtil.XSL_EMPLOYMENT_ADDRESS_COUNTRY, "");
        	} else {
        		updParamValues.put(CustomerProfileUtil.XSL_EMPLOYMENT_ADDRESS_COUNTRY, "CA");// It has to be a Canada address
        	}
        	updParamValues.put(CustomerProfileUtil.XSL_EMPLOYMENT_ADDRESS_POSTALCODE, reqPL.getEmployerPostalCode() == null ? "" : reqPL.getEmployerPostalCode());
        	
        	if (!CustomerProfileUtil.compareField(reqPL.getEmployerPhone(), custInfo.getEmployerPhone())) {
        		updParamValues.put(CustomerProfileUtil.XSL_EMPLOYMENT_PHONE, reqPL.getEmployerPhone() == null ? "" : reqPL.getEmployerPhone());
        		updParamValues.put(CustomerProfileUtil.XSL_EMPLOYMENT_PHONE_CHANGED, "true");
        	} else {
        		updParamValues.put(CustomerProfileUtil.XSL_EMPLOYMENT_PHONE_CHANGED, "false");
        	}
        	
        	updParamValues.put(CustomerProfileUtil.XSL_EMPLOYMENT_NATUREOFBUSINESS, reqPL.getNatureOfBusiness() == null ? "" : reqPL.getNatureOfBusiness());
        	updParamValues.put(CustomerProfileUtil.XSL_EMPLOYMENT_STATUS, reqPL.getEmploymentStatus() == null ? "" : reqPL.getEmploymentStatus());
        } else {
        	updParamValues.put(CustomerProfileUtil.XSL_IS_EMPLOYMENT_CHANGED, "false");
        }
        
        
        // Primary Income
        BigDecimal income = CustomerProfileUtil.getYearlyIncome(request.getRequestPayload().getCustomerInfo().getIncome(),
        		request.getRequestPayload().getCustomerInfo().getIncomeFrequency());
        BigDecimal oriIncome = CustomerProfileUtil.getYearlyIncome(custInfo.getIncome(), custInfo.getIncomeFrequency());
        
        if (!CustomerProfileUtil.compareField(income, oriIncome)) {
        	invokeUpdate = true;
        	grossIncomeChanged = true;
        	updParamValues.put(CustomerProfileUtil.XSL_IS_PRIMARYINCOME_CHANGED, "true");
        	if (custInfo.getPrimIncomeLastUpdatedTS() != null) {
        		updParamValues.put(CustomerProfileUtil.XSL_IS_PRIMARYINCOME_PRESENT, "true");
        		updParamValues.put(CustomerProfileUtil.XSL_EMPLOYMENT_PRIMARYINCOME_LASTUPDATEDTS, custInfo.getPrimIncomeLastUpdatedTS());
        	} else {
        		updParamValues.put(CustomerProfileUtil.XSL_IS_PRIMARYINCOME_PRESENT, "false");
        	}
        	updParamValues.put(CustomerProfileUtil.XSL_EMPLOYMENT_PRIMARYINCOME, income);
        } else {
        	updParamValues.put(CustomerProfileUtil.XSL_IS_PRIMARYINCOME_CHANGED, "false");
        }
        
        // Additional Income
        BigDecimal additionalIncome = CustomerProfileUtil.getYearlyIncome(request.getRequestPayload().getCustomerInfo().getAdditionalIncome(),
        		request.getRequestPayload().getCustomerInfo().getAdditionalIncomeFrequency());
        BigDecimal oriAdditionalIncome = CustomerProfileUtil.getYearlyIncome(custInfo.getOtherIncome(), custInfo.getOtherIncomeFrequency());
        
        if (!CustomerProfileUtil.compareField(additionalIncome, oriAdditionalIncome) ||
        		!CustomerProfileUtil.compareField(request.getRequestPayload().getCustomerInfo().getAdditionalIncomeSource(), custInfo.getOtherIncomeSource())) {
        	invokeUpdate = true;
        	grossIncomeChanged = true;
        	updParamValues.put(CustomerProfileUtil.XSL_IS_OTHERINCOME_CHANGED, "true");
        	if (custInfo.getOtherIncomeLastUpdatedTS() != null) {
        		updParamValues.put(CustomerProfileUtil.XSL_IS_OTHERINCOME_PRESENT, "true");
        		updParamValues.put(CustomerProfileUtil.XSL_OTHERINCOME_LASTUPDATEDTS, custInfo.getOtherIncomeLastUpdatedTS());
        	} else {
        		updParamValues.put(CustomerProfileUtil.XSL_IS_OTHERINCOME_PRESENT, "false");
        	}
        	
        	if (additionalIncome.floatValue() == 0.0) {
        		updParamValues.put(CustomerProfileUtil.XSL_OTHERINCOME_ENDTS, dateFmt.format(new Date()));
        	} else {
        		updParamValues.put(CustomerProfileUtil.XSL_OTHERINCOME_ENDTS, "");
        	}
        	updParamValues.put(CustomerProfileUtil.XSL_OTHERINCOME_VALUE, additionalIncome);
        	updParamValues.put(CustomerProfileUtil.XSL_OTHERINCOME_SOURCE, request.getRequestPayload().getCustomerInfo().getAdditionalIncomeSource());
        } else {
        	updParamValues.put(CustomerProfileUtil.XSL_IS_OTHERINCOME_CHANGED, "false");
        }
        
        if (grossIncomeChanged) {
        	updParamValues.put(CustomerProfileUtil.XSL_IS_GROSSINCOME_CHANGED, "true");
        	BigDecimal grossIncome = income;
        	grossIncome = grossIncome.add(additionalIncome);
        	grossIncome = grossIncome.setScale(2, RoundingMode.DOWN);
        	
        	if (custInfo.getGrossIncomeLastUpdatedTS() != null) {
        		updParamValues.put(CustomerProfileUtil.XSL_IS_GROSSINCOME_PRESENT, "true");
        		updParamValues.put(CustomerProfileUtil.XSL_GROSSINCOME_LASTUPDATEDTS, custInfo.getGrossIncomeLastUpdatedTS());
        	} else {
        		updParamValues.put(CustomerProfileUtil.XSL_IS_GROSSINCOME_PRESENT, "false");
        	}
        	updParamValues.put(CustomerProfileUtil.XSL_GROSSINCOME_VALUE, grossIncome);
        } else {
        	updParamValues.put(CustomerProfileUtil.XSL_IS_GROSSINCOME_CHANGED, "false");
        }
        
        if (!invokeUpdate) {
        	return true;
        }
        
        JAXBContext mtJaxBContext = null;
		try {
			mtJaxBContext = JaxbUtil.getJaxbContext("com.mbnaweb.xsd.msgs.customerprofile");
		} catch (JAXBException e) {
			String desc = "CLI 1::4 - prepare SOAP service call has failed: " +e.getLocalizedMessage();
			logger.error(methodName,desc);
			throw MidtierUtilHelper.prepareBusinessException(GENERAL_ERROR,desc);
		}
        
        try {
			BackEndSrvcUtil.invokeService(
					(String) null,
					UPDATE_CLI_CUSTOMER_PROFILE,
					UPDATE_CLI_CUSTOMER_PROFILE_RS,
					TdOdsCustomerProfileService.TdOp_odsRetrieveCustomerProfile,
					request.getSessionInfo().getLoginId(),
					null,
					null,
					updParamValues,
					null,
					BackEndSrvcUtil.TDOperation.TdOdsCustomerProfileService_updateCustomerProfile,
					mtJaxBContext);
		} catch (Exception e) {
			String desc = "CLI 1::4 - CODS SOAP service call updateCustomerProfile has failed: " +e.getLocalizedMessage();
			logger.error(methodName,desc);
			throw MidtierUtilHelper.prepareBusinessException(GENERAL_ERROR,desc);
		}

        return true;
    }


//    private SOAPFaultException createSOAPFaultException() throws SOAPException {
//        SOAPFault fault = SOAPFactory.newInstance().createFault();
//        fault.setFaultString(SystemError.class.getSimpleName());
//        Detail detail = fault.addDetail();
//        QName entryName = new QName("http://mbnaweb/", "errorCode", "mbna");
//        DetailEntry entry = detail.addDetailEntry(entryName);
//        entry.addTextNode("MS161");
//        entryName = new QName("http://mbnaweb/", "severity", "mbna");
//        entry = detail.addDetailEntry(entryName);
//        entry.addTextNode(ErrorType.ERROR.toString());
//        entryName = new QName("http://mbnaweb/", "errorDescription", "mbna");
//        entry = detail.addDetailEntry(entryName);
//        entry.addTextNode("MS161");
//
//        return new SOAPFaultException(fault);
//    }

    @Override
    public boolean requiresDisclosureConsent() {
        return true;
    }

    @Override
    public String getConsentDisclosureFailedMsgCode() {
        return null;
    }

    @Override
    public boolean generateAutoComment() {
        return true;
    }

    @Override
    public List<String> createAutoComment(BaseRequest request, BaseResponse response) {

        IncreaseCardLimitRequest increaseCardLimitReq = (IncreaseCardLimitRequest) request;
        List<String> comments = new ArrayList<String>();
        if (increaseCardLimitReq.getRequestPayload().getConfirmed() == null || !increaseCardLimitReq.getRequestPayload().getConfirmed()) {
            return comments;
        }
        StringBuilder sb = new StringBuilder();
        String header = CustomerNotesUtil.getHeaderContent(request, "CLI");
        sb.append(header);
        sb.append("Increase credit limit to: $").append(increaseCardLimitReq.getRequestPayload().getCreditLimit().toString());
        if (increaseCardLimitReq.getRequestPayload().getLongForm() != null && increaseCardLimitReq.getRequestPayload().getLongForm()) {
            sb.append("  Employment Status: ").append(increaseCardLimitReq.getRequestPayload().getEmploymentStatus());

            sb.append("  Length of Service: ");
            if (increaseCardLimitReq.getRequestPayload().getLengthOfService() != null && increaseCardLimitReq.getRequestPayload().getLengthOfService().trim().length() > 0)
                sb.append(increaseCardLimitReq.getRequestPayload().getLengthOfService());

            String occupationDescription = MBNAPropertiesUtil.getMBNADescriptionForMDMKey(increaseCardLimitReq.getRequestPayload().getCustomerInfo().getOccupation(), "occupation.", ".key");
            sb.append("  Occupation: ");
            if (occupationDescription != null) {
                sb.append(occupationDescription);
            }
            sb.append("  Nature of Business: ");
            if ((increaseCardLimitReq.getRequestPayload().getNatureOfBusiness() != null) && (!"".equals(increaseCardLimitReq.getRequestPayload().getNatureOfBusiness()))) {
                sb.append(increaseCardLimitReq.getRequestPayload().getNatureOfBusiness());
            }
            sb.append("  Job Description: ").append(increaseCardLimitReq.getRequestPayload().getPosition());


            sb.append("  Salary Income: $");
            BigDecimal salaryIncome = new BigDecimal(0.0);
            if (null != increaseCardLimitReq.getRequestPayload().getCustomerInfo().getIncome()) {
                salaryIncome = increaseCardLimitReq.getRequestPayload().getCustomerInfo().getIncome();
            }

            if (salaryIncome.compareTo(new BigDecimal(0)) == 0) {
                sb.append(salaryIncome);
            } else {
                sb.append(salaryIncome);
                if ((increaseCardLimitReq.getRequestPayload().getCustomerInfo().getIncomeFrequency() != null) && (!"".equals(increaseCardLimitReq.getRequestPayload().getCustomerInfo().getIncomeFrequency()))) {
                    sb.append(CustomerNotesUtil.SPACE_SEPARATOR).append(MBNAPropertiesUtil.getMBNADescriptionForMDMKey(increaseCardLimitReq.getRequestPayload().getCustomerInfo().getIncomeFrequency(), "personalInfo.", ".key"));
                }
            }


            sb.append("  Housing Status: ").append(increaseCardLimitReq.getRequestPayload().getCustomerInfo().getHousingStatus());
            sb.append("  Monthly Housing Payment: $").append(increaseCardLimitReq.getRequestPayload().getCustomerInfo().getHousingPayment());
            sb.append("  Additional Income: $");


            BigDecimal additionalIncome = new BigDecimal(0.0);
            if (null != increaseCardLimitReq.getRequestPayload().getCustomerInfo().getAdditionalIncome()) {
                additionalIncome = increaseCardLimitReq.getRequestPayload().getCustomerInfo().getAdditionalIncome();
            }

            if (additionalIncome.compareTo(new BigDecimal(0)) == 0) {
                sb.append(additionalIncome);
            } else {
                sb.append(additionalIncome);
                if ((increaseCardLimitReq.getRequestPayload().getCustomerInfo().getAdditionalIncomeFrequency() != null) && (!"".equals(increaseCardLimitReq.getRequestPayload().getCustomerInfo().getAdditionalIncomeFrequency()))) {
                    sb.append(CustomerNotesUtil.SPACE_SEPARATOR).append(MBNAPropertiesUtil.getMBNADescriptionForMDMKey(increaseCardLimitReq.getRequestPayload().getCustomerInfo().getAdditionalIncomeFrequency(), "personalInfo.", ".key"));
                }
            }

            sb.append("  Source of Additional Income: ");
            if ((increaseCardLimitReq.getRequestPayload().getCustomerInfo().getAdditionalIncomeSource() != null) && (!"".equals(increaseCardLimitReq.getRequestPayload().getCustomerInfo().getAdditionalIncomeSource()))) {
                sb.append(increaseCardLimitReq.getRequestPayload().getCustomerInfo().getAdditionalIncomeSource());
            }

            if (increaseCardLimitReq.getRequestPayload().getPromotionOfferId() != null && increaseCardLimitReq.getRequestPayload().getPromotionOfferId().trim().length() > 0 &&
                    increaseCardLimitReq.getRequestPayload().getPromotionOfferAmount() != null && increaseCardLimitReq.getRequestPayload().getPromotionOfferAmount().longValue() > 0) {
                sb.append("  Additional comment: Partially pre-approved");
            } else {
                sb.append("  Additional comment: Not pre-approved");
            }
        }
        sb.append(CustomerNotesUtil.SPACE_SEPARATOR);
        sb.append("Disclosure Checked");
        comments.add(sb.toString());

        return comments;
    }

    @Override
    public EmailInfo getEmailInfoBean(BaseRequest baseRequest, BaseResponse response) {
    	
    	EmailInfoImpl emailInfoBean = new EmailInfoImpl();
		emailInfoBean.setLogonId(baseRequest.getSessionInfo().getLoginId());
		
		IncreaseCardLimitRequest request = ((IncreaseCardLimitRequest) baseRequest);
		EmailNotificationInfoType notificationInfo = request.getRequestPayload().getEmailNotificationInfo();
		
		if (request.getRequestPayload().getConfirmed() == null || !request.getRequestPayload().getConfirmed() ) {
			emailInfoBean.setTriggerEmailNotification(false);
			return emailInfoBean;
		}
    	
		emailInfoBean = new EmailInfoImpl(notificationInfo, baseRequest.getSessionInfo().getLoginId(), IMBNAConstants.ALERT_TYPE_CD_SECUREGENERIC, request.getIsPrimaryUser() == null ? false : request.getIsPrimaryUser().booleanValue());
		emailInfoBean.setConnectId(baseRequest.getSessionInfo().getConnectId());
		if (notificationInfo == null){
			return null;
		}
		
	    if (request.getRequestPayload().getLongForm()) {
	    	emailInfoBean.addAttribute(CONTENT_CD, IMBNAConstants.BUSINESSEVENT_ID_INCREASECARDLIMITREQUEST);
	    } else {
	    	emailInfoBean.addAttribute(CONTENT_CD, IMBNAConstants.BUSINESSEVENT_ID_INCREASECARDLIMITREQUEST_OFFER);
	    }
	    
		emailInfoBean.setAcctNum(request.getAcctNum());
		
		emailInfoBean.addAttribute(INCR_FIRST_NAME, notificationInfo.getPrimaryUserFirstName());
		emailInfoBean.addAttribute(INCR_DATE, ISO_DATE.format(LocalDate.now()));
		emailInfoBean.addAttribute(INCR_PRODUCT_NAME, notificationInfo.getCardName());
		emailInfoBean.addAttribute(INCR_FOUR_DIGIT, notificationInfo.getPrimaryUserCardEnding());  
		
		return emailInfoBean;
		    	
    }

    @Override
    public MsecValidator getValidator() {
        return msecValidator;
    }

}