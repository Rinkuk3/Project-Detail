package com.td.mbna.msec.midtier.offers;

import com.td.api.mbcca.response.cancelip.AddCreditCardAgreementPostedAdjustmentEventResponse;
import com.td.api.mbcca.response.cancelip.PartialUpdateCreditCardAgreementRetailEventGracePeriodEndDateResponse;
import com.td.mbna.msec.midtier.framework.MsecVlangValidator;
import com.td.mbna.msec.midtier.mbcca.MbnaCCA;
import com.td.mbna.msec.midtier.offers.payload.cancelInstallmentPlan.CancelInstallmentPlanRequest;
import com.td.mbna.msec.midtier.offers.payload.cancelInstallmentPlan.CancelInstallmentPlanResponse;
import com.td.mbna.msec.midtier.offers.payload.cancelInstallmentPlan.RequestPayload;
import com.td.mbna.msec.midtier.offers.payload.cancelInstallmentPlan.ResponsePayload;
import com.td.mbna.msec.midtier.service.EmailInfo;
import com.td.mbna.msec.midtier.service.MsecMidtierCommonOperations;
import com.td.mbna.msec.midtier.service.MsecValidator;
import com.td.mbna.msec.midtier.types.common.BaseRequest;
import com.td.mbna.msec.midtier.types.common.BaseResponse;
import com.td.mbna.msec.midtier.util.CustomerNotesUtil;
import com.td.mbna.msec.midtier.util.MbnaLogger;
import com.td.mbna.msec.midtier.util.services.JAXBJsonConverter;
import com.td.mbna.msec.midtier.util.services.MidtierUtilHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springmodules.validation.valang.ValangValidator;

import java.util.*;

@Service
public class CancelInstallmentPlanOperation implements MsecMidtierCommonOperations<CancelInstallmentPlanRequest, CancelInstallmentPlanResponse> {

    private static MbnaLogger logger = new MbnaLogger(CancelInstallmentPlanOperation.class);

    private static final String GENERAL_ERROR = "MS601";
    private static final String DATE_FORMAT_DASH = "yyyy-MM-dd";

    private static final String IP_REFUND_INFO_LOG_FORMAT = "%n==REFUND IP FEE FAILED INFO START(%s)==%nACCTID=%s%neventId=%s%nstatementDataDt=%s%ncancelDate=%s%namount=%s%nEventId=REFUND IP FEE FAILED INFO%n==REFUND IP FEE FAILED INFO END==";


    @Autowired
    private MbnaCCA mbnaCCA;

    @Autowired
    private ValangValidator cancelIpValidator;

    @Override
    public CancelInstallmentPlanResponse invokeService(CancelInstallmentPlanRequest request, String... token) {

        try {

            com.td.mbna.msec.midtier.offers.payload.cancelInstallmentPlan.RequestPayload requestPayload =  request.getRequestPayload();

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.add(Calendar.DATE,2);

            PartialUpdateCreditCardAgreementRetailEventGracePeriodEndDateResponse cancelRs = mbnaCCA.cancelIp(request.getCardNum(),requestPayload.getEventId(), calendar.getTime(),JAXBJsonConverter.convertFromStringToDate(requestPayload.getIpPaymentOptionFeatureDate(),DATE_FORMAT_DASH),token[0]);

            CancelInstallmentPlanResponse cancelInstallmentPlanResponse = new CancelInstallmentPlanResponse();
            if(cancelRs == null){
            	return cancelInstallmentPlanResponse;
            }
            cancelInstallmentPlanResponse.setResponsePayload(new ResponsePayload());
            cancelInstallmentPlanResponse.getResponsePayload().setCancelStatus(true);

            try {
                //if eligible for refund, process refund
                if (cancelRs.getInstalmentPlanFeeRefundInd() != null && cancelRs.getInstalmentPlanFeeRefundInd()) {
                    AddCreditCardAgreementPostedAdjustmentEventResponse refundRs = mbnaCCA.refundIpFee(request.getSessionInfo().getConnectId(), request.getAcctNum(), request.getCardNum(), requestPayload.getStatementDataDt(), requestPayload.getPostedDate(), requestPayload.getPostedTime(), requestPayload.getTxLevelProcessingFeatureId(), requestPayload.getFee(), requestPayload.getCardType(),token[0]);


                    boolean refundStatus = (refundRs.getStatus() != null && refundRs.getStatus().getServerStatusCode().equalsIgnoreCase(String.valueOf(HttpStatus.CONFLICT.value()))) ? false : true;
                    cancelInstallmentPlanResponse.getResponsePayload().setRefundStatus(refundStatus ? ResponsePayload.RefundStatus.PASSED : ResponsePayload.RefundStatus.FAILED);

                    //log it using specific format
                    if (!refundStatus) {
                        logger.mandatory(String.format(IP_REFUND_INFO_LOG_FORMAT, UUID.randomUUID().toString(),request.getAcctNum(), requestPayload.getEventId(), requestPayload.getPostedDate(), JAXBJsonConverter.convertDateToString(new Date(), DATE_FORMAT_DASH), requestPayload.getFee()));
                    }

                }
            } catch (Exception e) {
                //if refund fails, no need to throw the exception, but need to log it. thus setting the response object.
                logger.error("CancelInstallmentPlanOperation:invokeService","",e);
                cancelInstallmentPlanResponse.getResponsePayload().setRefundStatus(ResponsePayload.RefundStatus.FAILED);
            }


            return cancelInstallmentPlanResponse;

        } catch (Exception e) {
            logger.error("CancelInstallmentPlanOperation:invokeService","IP cancellation failed for accountId="+request.getAcctNum(),e);
            throw MidtierUtilHelper.prepareBusinessException(GENERAL_ERROR,"IP cancellation failed");
        }

    }

    @Override
    public boolean requiresDisclosureConsent() {
        return false;
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

        CancelInstallmentPlanRequest cancelInstallmentPlanRequest = (CancelInstallmentPlanRequest) request ;
        RequestPayload requestPayload = cancelInstallmentPlanRequest.getRequestPayload();

        CancelInstallmentPlanResponse cancelInstallmentPlanResponse = (CancelInstallmentPlanResponse) response;
        ResponsePayload responsePayload = cancelInstallmentPlanResponse.getResponsePayload();


        List<String> comment = new ArrayList<String>();

        if (responsePayload != null && responsePayload.getCancelStatus() != null && responsePayload.getCancelStatus() && requestPayload != null) {

            StringBuilder strBuffer = new StringBuilder();

            String header = CustomerNotesUtil.getHeaderContent(request,
                    "Cancel Installment Plan");
            strBuffer.append(header);


            strBuffer.append("NickName: ");
            strBuffer.append(requestPayload.getNickName());
            strBuffer.append(CustomerNotesUtil.SPACE_SEPARATOR);

            strBuffer.append("IP Cancellation Date: ");
            strBuffer.append(JAXBJsonConverter.convertDateToString(new Date(),DATE_FORMAT_DASH));
            strBuffer.append(CustomerNotesUtil.SPACE_SEPARATOR);

            strBuffer.append("Amount: ");
            strBuffer.append(requestPayload.getAmount());
            strBuffer.append(CustomerNotesUtil.SPACE_SEPARATOR);

            strBuffer.append("Interest Rate: ");
            strBuffer.append(requestPayload.getInterestRate()).append("%");;
            strBuffer.append(CustomerNotesUtil.SPACE_SEPARATOR);

            strBuffer.append("Fee: ");
            strBuffer.append(requestPayload.getFee());
            strBuffer.append(CustomerNotesUtil.SPACE_SEPARATOR);

            strBuffer.append("Payment Plan balance at time of closure: ");
            strBuffer.append(requestPayload.getBalanceOfIp());


            //check if refund is eligible and failed
            if (responsePayload.getRefundStatus() == ResponsePayload.RefundStatus.FAILED) {
                strBuffer.append(CustomerNotesUtil.SPACE_SEPARATOR);
                strBuffer.append("Refund: Failed");

            }
            //check if refund is eligible and passed
            else if (responsePayload.getRefundStatus() == ResponsePayload.RefundStatus.PASSED) {
                strBuffer.append(CustomerNotesUtil.SPACE_SEPARATOR);
                strBuffer.append("Refund: ");
                strBuffer.append(requestPayload.getFee());
            } else {
                strBuffer.append(CustomerNotesUtil.SPACE_SEPARATOR);
                strBuffer.append("Refund: Not-Eligible");
            }

            comment.add(strBuffer.toString());
        }



        return comment;
    }

    @Override
    public EmailInfo getEmailInfoBean(BaseRequest request, BaseResponse response) {
        return null;
    }

    @Override
    public MsecValidator getValidator() {
        return new MsecVlangValidator(cancelIpValidator);
    }


}
