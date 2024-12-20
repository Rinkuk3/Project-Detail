package com.td.api.mbcca.response.account;

import java.util.Date;

import com.td.api.mbcca.shared.Cccyamt;
import com.td.api.mbcca.shared.MerchantInfo;
import com.td.api.mbcca.shared.TsysExtensionCurrencyNumericCd;

public class AuthorizationEventDetail {

    private Date eventDttm;
    private String sourceTransactionId;
    private String activityTypeCd;
    private String activityTypeDesc;
    private String approvalCd;
    private String authorizationRequestCd;
    private String authorizationRequestTypeDesc;
    private String authorizationResponseCd;
    private String declineStatusReasonCd;
    private String standInProcessingReasonCd;
    private String cardSecurityCodeVerificationVal;
    private String cardVerificationMismatchStatusReasonCd;
    private Boolean chipCardVerificationIndicatorVerifiedInd;
    private String cardVerificationIndicatorVerificationVal;
    private String virtualCardNum;
    private String virtualCardDeclineReferralStatusReasonCd;
    private String virtualCardDeclineReferralStatusReasonDesc;
    private String massCompromisedCd;
    private Cccyamt transactionCccyamt;
    private String authorizationFeatureId;
    private String originatingAgreementTypeCd;
    private String originalCardNum;
    private String cardTypeCd;
    private String partyAgreementRoleCd;
    private String cardExpirationYm;
    private String convenienceCheckNum;
    private String pointOfServiceTerminalEntryCd;
    private String pointOfServiceTerminalEntryDesc;
    private Boolean recurringInd;
    private String authorizationMessageTypeCd;
    private String authorizationMessageTypeDesc;
    private String cardholderAuthenticationVerificationValueResultCd;
    private String accountHolderAuthenticationValueResultCd;
    private Cccyamt cashBackCccyamt;
    private Cccyamt beforeTransactionCreditAvailableCccyamt;
    private Cccyamt beforeTransactionCashAvailableCccyamt;
    private MerchantInfo merchantInfo;
    private ElectricTransactionInfo electricTransactionInfo;
    private TsysExtensionCurrencyNumericCd tsysExtension;
    private String paymentTokenId;
    private String paymentTokenRequesterId;
    private ChipCard chipCard;
    private String transactionCurrencyCd;

    public Date getEventDttm() {
        return eventDttm;
    }

    public void setEventDttm(Date eventDttm) {
        this.eventDttm = eventDttm;
    }

    public String getSourceTransactionId() {
        return sourceTransactionId;
    }

    public void setSourceTransactionId(String sourceTransactionId) {
        this.sourceTransactionId = sourceTransactionId;
    }

    public String getActivityTypeCd() {
        return activityTypeCd;
    }

    public void setActivityTypeCd(String activityTypeCd) {
        this.activityTypeCd = activityTypeCd;
    }

    public String getActivityTypeDesc() {
        return activityTypeDesc;
    }

    public void setActivityTypeDesc(String activityTypeDesc) {
        this.activityTypeDesc = activityTypeDesc;
    }

    public String getApprovalCd() {
        return approvalCd;
    }

    public void setApprovalCd(String approvalCd) {
        this.approvalCd = approvalCd;
    }

    public String getAuthorizationRequestCd() {
        return authorizationRequestCd;
    }

    public void setAuthorizationRequestCd(String authorizationRequestCd) {
        this.authorizationRequestCd = authorizationRequestCd;
    }

    public String getAuthorizationRequestTypeDesc() {
        return authorizationRequestTypeDesc;
    }

    public void setAuthorizationRequestTypeDesc(String authorizationRequestTypeDesc) {
        this.authorizationRequestTypeDesc = authorizationRequestTypeDesc;
    }

    public String getAuthorizationResponseCd() {
        return authorizationResponseCd;
    }

    public void setAuthorizationResponseCd(String authorizationResponseCd) {
        this.authorizationResponseCd = authorizationResponseCd;
    }

    public String getDeclineStatusReasonCd() {
        return declineStatusReasonCd;
    }

    public void setDeclineStatusReasonCd(String declineStatusReasonCd) {
        this.declineStatusReasonCd = declineStatusReasonCd;
    }

    public String getStandInProcessingReasonCd() {
        return standInProcessingReasonCd;
    }

    public void setStandInProcessingReasonCd(String standInProcessingReasonCd) {
        this.standInProcessingReasonCd = standInProcessingReasonCd;
    }

    public String getCardSecurityCodeVerificationVal() {
        return cardSecurityCodeVerificationVal;
    }

    public void setCardSecurityCodeVerificationVal(String cardSecurityCodeVerificationVal) {
        this.cardSecurityCodeVerificationVal = cardSecurityCodeVerificationVal;
    }

    public String getCardVerificationMismatchStatusReasonCd() {
        return cardVerificationMismatchStatusReasonCd;
    }

    public void setCardVerificationMismatchStatusReasonCd(String cardVerificationMismatchStatusReasonCd) {
        this.cardVerificationMismatchStatusReasonCd = cardVerificationMismatchStatusReasonCd;
    }

    public Boolean getChipCardVerificationIndicatorVerifiedInd() {
        return chipCardVerificationIndicatorVerifiedInd;
    }

    public void setChipCardVerificationIndicatorVerifiedInd(Boolean chipCardVerificationIndicatorVerifiedInd) {
        this.chipCardVerificationIndicatorVerifiedInd = chipCardVerificationIndicatorVerifiedInd;
    }

    public String getCardVerificationIndicatorVerificationVal() {
        return cardVerificationIndicatorVerificationVal;
    }

    public void setCardVerificationIndicatorVerificationVal(String cardVerificationIndicatorVerificationVal) {
        this.cardVerificationIndicatorVerificationVal = cardVerificationIndicatorVerificationVal;
    }

    public String getVirtualCardNum() {
        return virtualCardNum;
    }

    public void setVirtualCardNum(String virtualCardNum) {
        this.virtualCardNum = virtualCardNum;
    }

    public String getVirtualCardDeclineReferralStatusReasonCd() {
        return virtualCardDeclineReferralStatusReasonCd;
    }

    public void setVirtualCardDeclineReferralStatusReasonCd(String virtualCardDeclineReferralStatusReasonCd) {
        this.virtualCardDeclineReferralStatusReasonCd = virtualCardDeclineReferralStatusReasonCd;
    }

    public String getVirtualCardDeclineReferralStatusReasonDesc() {
        return virtualCardDeclineReferralStatusReasonDesc;
    }

    public void setVirtualCardDeclineReferralStatusReasonDesc(String virtualCardDeclineReferralStatusReasonDesc) {
        this.virtualCardDeclineReferralStatusReasonDesc = virtualCardDeclineReferralStatusReasonDesc;
    }

    public String getMassCompromisedCd() {
        return massCompromisedCd;
    }

    public void setMassCompromisedCd(String massCompromisedCd) {
        this.massCompromisedCd = massCompromisedCd;
    }

    public Cccyamt getTransactionCccyamt() {
        return transactionCccyamt;
    }

    public void setTransactionCccyamt(Cccyamt transactionCccyamt) {
        this.transactionCccyamt = transactionCccyamt;
    }

    public String getAuthorizationFeatureId() {
        return authorizationFeatureId;
    }

    public void setAuthorizationFeatureId(String authorizationFeatureId) {
        this.authorizationFeatureId = authorizationFeatureId;
    }

    public String getOriginatingAgreementTypeCd() {
        return originatingAgreementTypeCd;
    }

    public void setOriginatingAgreementTypeCd(String originatingAgreementTypeCd) {
        this.originatingAgreementTypeCd = originatingAgreementTypeCd;
    }

    public String getOriginalCardNum() {
        return originalCardNum;
    }

    public void setOriginalCardNum(String originalCardNum) {
        this.originalCardNum = originalCardNum;
    }

    public String getCardTypeCd() {
        return cardTypeCd;
    }

    public void setCardTypeCd(String cardTypeCd) {
        this.cardTypeCd = cardTypeCd;
    }

    public String getPartyAgreementRoleCd() {
        return partyAgreementRoleCd;
    }

    public void setPartyAgreementRoleCd(String partyAgreementRoleCd) {
        this.partyAgreementRoleCd = partyAgreementRoleCd;
    }

    public String getCardExpirationYm() {
        return cardExpirationYm;
    }

    public void setCardExpirationYm(String cardExpirationYm) {
        this.cardExpirationYm = cardExpirationYm;
    }

    public String getConvenienceCheckNum() {
        return convenienceCheckNum;
    }

    public void setConvenienceCheckNum(String convenienceCheckNum) {
        this.convenienceCheckNum = convenienceCheckNum;
    }

    public String getPointOfServiceTerminalEntryCd() {
        return pointOfServiceTerminalEntryCd;
    }

    public void setPointOfServiceTerminalEntryCd(String pointOfServiceTerminalEntryCd) {
        this.pointOfServiceTerminalEntryCd = pointOfServiceTerminalEntryCd;
    }

    public String getPointOfServiceTerminalEntryDesc() {
        return pointOfServiceTerminalEntryDesc;
    }

    public void setPointOfServiceTerminalEntryDesc(String pointOfServiceTerminalEntryDesc) {
        this.pointOfServiceTerminalEntryDesc = pointOfServiceTerminalEntryDesc;
    }

    public Boolean getRecurringInd() {
        return recurringInd;
    }

    public void setRecurringInd(Boolean recurringInd) {
        this.recurringInd = recurringInd;
    }

    public String getAuthorizationMessageTypeCd() {
        return authorizationMessageTypeCd;
    }

    public void setAuthorizationMessageTypeCd(String authorizationMessageTypeCd) {
        this.authorizationMessageTypeCd = authorizationMessageTypeCd;
    }

    public String getAuthorizationMessageTypeDesc() {
        return authorizationMessageTypeDesc;
    }

    public void setAuthorizationMessageTypeDesc(String authorizationMessageTypeDesc) {
        this.authorizationMessageTypeDesc = authorizationMessageTypeDesc;
    }

    public String getCardholderAuthenticationVerificationValueResultCd() {
        return cardholderAuthenticationVerificationValueResultCd;
    }

    public void setCardholderAuthenticationVerificationValueResultCd(String cardholderAuthenticationVerificationValueResultCd) {
        this.cardholderAuthenticationVerificationValueResultCd = cardholderAuthenticationVerificationValueResultCd;
    }

    public String getAccountHolderAuthenticationValueResultCd() {
        return accountHolderAuthenticationValueResultCd;
    }

    public void setAccountHolderAuthenticationValueResultCd(String accountHolderAuthenticationValueResultCd) {
        this.accountHolderAuthenticationValueResultCd = accountHolderAuthenticationValueResultCd;
    }

    public Cccyamt getCashBackCccyamt() {
        return cashBackCccyamt;
    }

    public void setCashBackCccyamt(Cccyamt cashBackCccyamt) {
        this.cashBackCccyamt = cashBackCccyamt;
    }

    public Cccyamt getBeforeTransactionCreditAvailableCccyamt() {
        return beforeTransactionCreditAvailableCccyamt;
    }

    public void setBeforeTransactionCreditAvailableCccyamt(Cccyamt beforeTransactionCreditAvailableCccyamt) {
        this.beforeTransactionCreditAvailableCccyamt = beforeTransactionCreditAvailableCccyamt;
    }

    public Cccyamt getBeforeTransactionCashAvailableCccyamt() {
        return beforeTransactionCashAvailableCccyamt;
    }

    public void setBeforeTransactionCashAvailableCccyamt(Cccyamt beforeTransactionCashAvailableCccyamt) {
        this.beforeTransactionCashAvailableCccyamt = beforeTransactionCashAvailableCccyamt;
    }

    public MerchantInfo getMerchantInfo() {
        return merchantInfo;
    }

    public void setMerchantInfo(MerchantInfo merchantInfo) {
        this.merchantInfo = merchantInfo;
    }

    public ElectricTransactionInfo getElectricTransactionInfo() {
        return electricTransactionInfo;
    }

    public void setElectricTransactionInfo(ElectricTransactionInfo electricTransactionInfo) {
        this.electricTransactionInfo = electricTransactionInfo;
    }

    public TsysExtensionCurrencyNumericCd getTsysExtension() {
        return tsysExtension;
    }

    public void setTsysExtension(TsysExtensionCurrencyNumericCd tsysExtension) {
        this.tsysExtension = tsysExtension;
    }

    public String getPaymentTokenId() {
        return paymentTokenId;
    }

    public void setPaymentTokenId(String paymentTokenId) {
        this.paymentTokenId = paymentTokenId;
    }

    public String getPaymentTokenRequesterId() {
        return paymentTokenRequesterId;
    }

    public void setPaymentTokenRequesterId(String paymentTokenRequesterId) {
        this.paymentTokenRequesterId = paymentTokenRequesterId;
    }

    public ChipCard getChipCard() {
        return chipCard;
    }

    public void setChipCard(ChipCard chipCard) {
        this.chipCard = chipCard;
    }

    public String getTransactionCurrencyCd() {
        return transactionCurrencyCd;
    }

    public void setTransactionCurrencyCd(String transactionCurrencyCd) {
        this.transactionCurrencyCd = transactionCurrencyCd;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AuthorizationEventDetail.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("eventDttm");
        sb.append('=');
        sb.append(((this.eventDttm == null)?"<null>":this.eventDttm));
        sb.append(',');
        sb.append("sourceTransactionId");
        sb.append('=');
        sb.append(((this.sourceTransactionId == null)?"<null>":this.sourceTransactionId));
        sb.append(',');
        sb.append("activityTypeCd");
        sb.append('=');
        sb.append(((this.activityTypeCd == null)?"<null>":this.activityTypeCd));
        sb.append(',');
        sb.append("activityTypeDesc");
        sb.append('=');
        sb.append(((this.activityTypeDesc == null)?"<null>":this.activityTypeDesc));
        sb.append(',');
        sb.append("approvalCd");
        sb.append('=');
        sb.append(((this.approvalCd == null)?"<null>":this.approvalCd));
        sb.append(',');
        sb.append("authorizationRequestCd");
        sb.append('=');
        sb.append(((this.authorizationRequestCd == null)?"<null>":this.authorizationRequestCd));
        sb.append(',');
        sb.append("authorizationRequestTypeDesc");
        sb.append('=');
        sb.append(((this.authorizationRequestTypeDesc == null)?"<null>":this.authorizationRequestTypeDesc));
        sb.append(',');
        sb.append("authorizationResponseCd");
        sb.append('=');
        sb.append(((this.authorizationResponseCd == null)?"<null>":this.authorizationResponseCd));
        sb.append(',');
        sb.append("declineStatusReasonCd");
        sb.append('=');
        sb.append(((this.declineStatusReasonCd == null)?"<null>":this.declineStatusReasonCd));
        sb.append(',');
        sb.append("standInProcessingReasonCd");
        sb.append('=');
        sb.append(((this.standInProcessingReasonCd == null)?"<null>":this.standInProcessingReasonCd));
        sb.append(',');
        sb.append("cardSecurityCodeVerificationVal");
        sb.append('=');
        sb.append(((this.cardSecurityCodeVerificationVal == null)?"<null>":this.cardSecurityCodeVerificationVal));
        sb.append(',');
        sb.append("cardVerificationMismatchStatusReasonCd");
        sb.append('=');
        sb.append(((this.cardVerificationMismatchStatusReasonCd == null)?"<null>":this.cardVerificationMismatchStatusReasonCd));
        sb.append(',');
        sb.append("chipCardVerificationIndicatorVerifiedInd");
        sb.append('=');
        sb.append(((this.chipCardVerificationIndicatorVerifiedInd == null)?"<null>":this.chipCardVerificationIndicatorVerifiedInd));
        sb.append(',');
        sb.append("cardVerificationIndicatorVerificationVal");
        sb.append('=');
        sb.append(((this.cardVerificationIndicatorVerificationVal == null)?"<null>":this.cardVerificationIndicatorVerificationVal));
        sb.append(',');
        sb.append("virtualCardNum");
        sb.append('=');
        sb.append(((this.virtualCardNum == null)?"<null>":this.virtualCardNum));
        sb.append(',');
        sb.append("virtualCardDeclineReferralStatusReasonCd");
        sb.append('=');
        sb.append(((this.virtualCardDeclineReferralStatusReasonCd == null)?"<null>":this.virtualCardDeclineReferralStatusReasonCd));
        sb.append(',');
        sb.append("virtualCardDeclineReferralStatusReasonDesc");
        sb.append('=');
        sb.append(((this.virtualCardDeclineReferralStatusReasonDesc == null)?"<null>":this.virtualCardDeclineReferralStatusReasonDesc));
        sb.append(',');
        sb.append("massCompromisedCd");
        sb.append('=');
        sb.append(((this.massCompromisedCd == null)?"<null>":this.massCompromisedCd));
        sb.append(',');
        sb.append("transactionCccyamt");
        sb.append('=');
        sb.append(((this.transactionCccyamt == null)?"<null>":this.transactionCccyamt));
        sb.append(',');
        sb.append("authorizationFeatureId");
        sb.append('=');
        sb.append(((this.authorizationFeatureId == null)?"<null>":this.authorizationFeatureId));
        sb.append(',');
        sb.append("originatingAgreementTypeCd");
        sb.append('=');
        sb.append(((this.originatingAgreementTypeCd == null)?"<null>":this.originatingAgreementTypeCd));
        sb.append(',');
        sb.append("originalCardNum");
        sb.append('=');
        sb.append(((this.originalCardNum == null)?"<null>":this.originalCardNum));
        sb.append(',');
        sb.append("cardTypeCd");
        sb.append('=');
        sb.append(((this.cardTypeCd == null)?"<null>":this.cardTypeCd));
        sb.append(',');
        sb.append("partyAgreementRoleCd");
        sb.append('=');
        sb.append(((this.partyAgreementRoleCd == null)?"<null>":this.partyAgreementRoleCd));
        sb.append(',');
        sb.append("cardExpirationYm");
        sb.append('=');
        sb.append(((this.cardExpirationYm == null)?"<null>":this.cardExpirationYm));
        sb.append(',');
        sb.append("convenienceCheckNum");
        sb.append('=');
        sb.append(((this.convenienceCheckNum == null)?"<null>":this.convenienceCheckNum));
        sb.append(',');
        sb.append("pointOfServiceTerminalEntryCd");
        sb.append('=');
        sb.append(((this.pointOfServiceTerminalEntryCd == null)?"<null>":this.pointOfServiceTerminalEntryCd));
        sb.append(',');
        sb.append("pointOfServiceTerminalEntryDesc");
        sb.append('=');
        sb.append(((this.pointOfServiceTerminalEntryDesc == null)?"<null>":this.pointOfServiceTerminalEntryDesc));
        sb.append(',');
        sb.append("recurringInd");
        sb.append('=');
        sb.append(((this.recurringInd == null)?"<null>":this.recurringInd));
        sb.append(',');
        sb.append("authorizationMessageTypeCd");
        sb.append('=');
        sb.append(((this.authorizationMessageTypeCd == null)?"<null>":this.authorizationMessageTypeCd));
        sb.append(',');
        sb.append("authorizationMessageTypeDesc");
        sb.append('=');
        sb.append(((this.authorizationMessageTypeDesc == null)?"<null>":this.authorizationMessageTypeDesc));
        sb.append(',');
        sb.append("cardholderAuthenticationVerificationValueResultCd");
        sb.append('=');
        sb.append(((this.cardholderAuthenticationVerificationValueResultCd == null)?"<null>":this.cardholderAuthenticationVerificationValueResultCd));
        sb.append(',');
        sb.append("accountHolderAuthenticationValueResultCd");
        sb.append('=');
        sb.append(((this.accountHolderAuthenticationValueResultCd == null)?"<null>":this.accountHolderAuthenticationValueResultCd));
        sb.append(',');
        sb.append("cashBackCccyamt");
        sb.append('=');
        sb.append(((this.cashBackCccyamt == null)?"<null>":this.cashBackCccyamt));
        sb.append(',');
        sb.append("beforeTransactionCreditAvailableCccyamt");
        sb.append('=');
        sb.append(((this.beforeTransactionCreditAvailableCccyamt == null)?"<null>":this.beforeTransactionCreditAvailableCccyamt));
        sb.append(',');
        sb.append("beforeTransactionCashAvailableCccyamt");
        sb.append('=');
        sb.append(((this.beforeTransactionCashAvailableCccyamt == null)?"<null>":this.beforeTransactionCashAvailableCccyamt));
        sb.append(',');
        sb.append("merchantInfo");
        sb.append('=');
        sb.append(((this.merchantInfo == null)?"<null>":this.merchantInfo));
        sb.append(',');
        sb.append("electricTransactionInfo");
        sb.append('=');
        sb.append(((this.electricTransactionInfo == null)?"<null>":this.electricTransactionInfo));
        sb.append(',');
        sb.append("tsysExtension");
        sb.append('=');
        sb.append(((this.tsysExtension == null)?"<null>":this.tsysExtension));
        sb.append(',');
        sb.append("paymentTokenId");
        sb.append('=');
        sb.append(((this.paymentTokenId == null)?"<null>":this.paymentTokenId));
        sb.append(',');
        sb.append("paymentTokenRequesterId");
        sb.append('=');
        sb.append(((this.paymentTokenRequesterId == null)?"<null>":this.paymentTokenRequesterId));
        sb.append(',');
        sb.append("chipCard");
        sb.append('=');
        sb.append(((this.chipCard == null)?"<null>":this.chipCard));
        sb.append(',');
        sb.append("transactionCurrencyCd");
        sb.append('=');
        sb.append(((this.transactionCurrencyCd == null)?"<null>":this.transactionCurrencyCd));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.cardholderAuthenticationVerificationValueResultCd == null)? 0 :this.cardholderAuthenticationVerificationValueResultCd.hashCode()));
        result = ((result* 31)+((this.chipCardVerificationIndicatorVerifiedInd == null)? 0 :this.chipCardVerificationIndicatorVerifiedInd.hashCode()));
        result = ((result* 31)+((this.convenienceCheckNum == null)? 0 :this.convenienceCheckNum.hashCode()));
        result = ((result* 31)+((this.electricTransactionInfo == null)? 0 :this.electricTransactionInfo.hashCode()));
        result = ((result* 31)+((this.paymentTokenRequesterId == null)? 0 :this.paymentTokenRequesterId.hashCode()));
        result = ((result* 31)+((this.activityTypeCd == null)? 0 :this.activityTypeCd.hashCode()));
        result = ((result* 31)+((this.declineStatusReasonCd == null)? 0 :this.declineStatusReasonCd.hashCode()));
        result = ((result* 31)+((this.pointOfServiceTerminalEntryCd == null)? 0 :this.pointOfServiceTerminalEntryCd.hashCode()));
        result = ((result* 31)+((this.cardTypeCd == null)? 0 :this.cardTypeCd.hashCode()));
        result = ((result* 31)+((this.beforeTransactionCashAvailableCccyamt == null)? 0 :this.beforeTransactionCashAvailableCccyamt.hashCode()));
        result = ((result* 31)+((this.tsysExtension == null)? 0 :this.tsysExtension.hashCode()));
        result = ((result* 31)+((this.virtualCardDeclineReferralStatusReasonDesc == null)? 0 :this.virtualCardDeclineReferralStatusReasonDesc.hashCode()));
        result = ((result* 31)+((this.cardVerificationIndicatorVerificationVal == null)? 0 :this.cardVerificationIndicatorVerificationVal.hashCode()));
        result = ((result* 31)+((this.eventDttm == null)? 0 :this.eventDttm.hashCode()));
        result = ((result* 31)+((this.virtualCardDeclineReferralStatusReasonCd == null)? 0 :this.virtualCardDeclineReferralStatusReasonCd.hashCode()));
        result = ((result* 31)+((this.cardSecurityCodeVerificationVal == null)? 0 :this.cardSecurityCodeVerificationVal.hashCode()));
        result = ((result* 31)+((this.standInProcessingReasonCd == null)? 0 :this.standInProcessingReasonCd.hashCode()));
        result = ((result* 31)+((this.approvalCd == null)? 0 :this.approvalCd.hashCode()));
        result = ((result* 31)+((this.authorizationRequestCd == null)? 0 :this.authorizationRequestCd.hashCode()));
        result = ((result* 31)+((this.originatingAgreementTypeCd == null)? 0 :this.originatingAgreementTypeCd.hashCode()));
        result = ((result* 31)+((this.authorizationResponseCd == null)? 0 :this.authorizationResponseCd.hashCode()));
        result = ((result* 31)+((this.virtualCardNum == null)? 0 :this.virtualCardNum.hashCode()));
        result = ((result* 31)+((this.transactionCccyamt == null)? 0 :this.transactionCccyamt.hashCode()));
        result = ((result* 31)+((this.cardExpirationYm == null)? 0 :this.cardExpirationYm.hashCode()));
        result = ((result* 31)+((this.massCompromisedCd == null)? 0 :this.massCompromisedCd.hashCode()));
        result = ((result* 31)+((this.originalCardNum == null)? 0 :this.originalCardNum.hashCode()));
        result = ((result* 31)+((this.transactionCurrencyCd == null)? 0 :this.transactionCurrencyCd.hashCode()));
        result = ((result* 31)+((this.authorizationMessageTypeCd == null)? 0 :this.authorizationMessageTypeCd.hashCode()));
        result = ((result* 31)+((this.accountHolderAuthenticationValueResultCd == null)? 0 :this.accountHolderAuthenticationValueResultCd.hashCode()));
        result = ((result* 31)+((this.merchantInfo == null)? 0 :this.merchantInfo.hashCode()));
        result = ((result* 31)+((this.sourceTransactionId == null)? 0 :this.sourceTransactionId.hashCode()));
        result = ((result* 31)+((this.chipCard == null)? 0 :this.chipCard.hashCode()));
        result = ((result* 31)+((this.authorizationFeatureId == null)? 0 :this.authorizationFeatureId.hashCode()));
        result = ((result* 31)+((this.authorizationMessageTypeDesc == null)? 0 :this.authorizationMessageTypeDesc.hashCode()));
        result = ((result* 31)+((this.activityTypeDesc == null)? 0 :this.activityTypeDesc.hashCode()));
        result = ((result* 31)+((this.partyAgreementRoleCd == null)? 0 :this.partyAgreementRoleCd.hashCode()));
        result = ((result* 31)+((this.recurringInd == null)? 0 :this.recurringInd.hashCode()));
        result = ((result* 31)+((this.authorizationRequestTypeDesc == null)? 0 :this.authorizationRequestTypeDesc.hashCode()));
        result = ((result* 31)+((this.paymentTokenId == null)? 0 :this.paymentTokenId.hashCode()));
        result = ((result* 31)+((this.cardVerificationMismatchStatusReasonCd == null)? 0 :this.cardVerificationMismatchStatusReasonCd.hashCode()));
        result = ((result* 31)+((this.cashBackCccyamt == null)? 0 :this.cashBackCccyamt.hashCode()));
        result = ((result* 31)+((this.pointOfServiceTerminalEntryDesc == null)? 0 :this.pointOfServiceTerminalEntryDesc.hashCode()));
        result = ((result* 31)+((this.beforeTransactionCreditAvailableCccyamt == null)? 0 :this.beforeTransactionCreditAvailableCccyamt.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AuthorizationEventDetail) == false) {
            return false;
        }
        AuthorizationEventDetail rhs = ((AuthorizationEventDetail) other);
        return ((((((((((((((((((((((((((((((((((((((((((((this.cardholderAuthenticationVerificationValueResultCd == rhs.cardholderAuthenticationVerificationValueResultCd)||((this.cardholderAuthenticationVerificationValueResultCd!= null)&&this.cardholderAuthenticationVerificationValueResultCd.equals(rhs.cardholderAuthenticationVerificationValueResultCd)))&&((this.chipCardVerificationIndicatorVerifiedInd == rhs.chipCardVerificationIndicatorVerifiedInd)||((this.chipCardVerificationIndicatorVerifiedInd!= null)&&this.chipCardVerificationIndicatorVerifiedInd.equals(rhs.chipCardVerificationIndicatorVerifiedInd))))&&((this.convenienceCheckNum == rhs.convenienceCheckNum)||((this.convenienceCheckNum!= null)&&this.convenienceCheckNum.equals(rhs.convenienceCheckNum))))&&((this.electricTransactionInfo == rhs.electricTransactionInfo)||((this.electricTransactionInfo!= null)&&this.electricTransactionInfo.equals(rhs.electricTransactionInfo))))&&((this.paymentTokenRequesterId == rhs.paymentTokenRequesterId)||((this.paymentTokenRequesterId!= null)&&this.paymentTokenRequesterId.equals(rhs.paymentTokenRequesterId))))&&((this.activityTypeCd == rhs.activityTypeCd)||((this.activityTypeCd!= null)&&this.activityTypeCd.equals(rhs.activityTypeCd))))&&((this.declineStatusReasonCd == rhs.declineStatusReasonCd)||((this.declineStatusReasonCd!= null)&&this.declineStatusReasonCd.equals(rhs.declineStatusReasonCd))))&&((this.pointOfServiceTerminalEntryCd == rhs.pointOfServiceTerminalEntryCd)||((this.pointOfServiceTerminalEntryCd!= null)&&this.pointOfServiceTerminalEntryCd.equals(rhs.pointOfServiceTerminalEntryCd))))&&((this.cardTypeCd == rhs.cardTypeCd)||((this.cardTypeCd!= null)&&this.cardTypeCd.equals(rhs.cardTypeCd))))&&((this.beforeTransactionCashAvailableCccyamt == rhs.beforeTransactionCashAvailableCccyamt)||((this.beforeTransactionCashAvailableCccyamt!= null)&&this.beforeTransactionCashAvailableCccyamt.equals(rhs.beforeTransactionCashAvailableCccyamt))))&&((this.tsysExtension == rhs.tsysExtension)||((this.tsysExtension!= null)&&this.tsysExtension.equals(rhs.tsysExtension))))&&((this.virtualCardDeclineReferralStatusReasonDesc == rhs.virtualCardDeclineReferralStatusReasonDesc)||((this.virtualCardDeclineReferralStatusReasonDesc!= null)&&this.virtualCardDeclineReferralStatusReasonDesc.equals(rhs.virtualCardDeclineReferralStatusReasonDesc))))&&((this.cardVerificationIndicatorVerificationVal == rhs.cardVerificationIndicatorVerificationVal)||((this.cardVerificationIndicatorVerificationVal!= null)&&this.cardVerificationIndicatorVerificationVal.equals(rhs.cardVerificationIndicatorVerificationVal))))&&((this.eventDttm == rhs.eventDttm)||((this.eventDttm!= null)&&this.eventDttm.equals(rhs.eventDttm))))&&((this.virtualCardDeclineReferralStatusReasonCd == rhs.virtualCardDeclineReferralStatusReasonCd)||((this.virtualCardDeclineReferralStatusReasonCd!= null)&&this.virtualCardDeclineReferralStatusReasonCd.equals(rhs.virtualCardDeclineReferralStatusReasonCd))))&&((this.cardSecurityCodeVerificationVal == rhs.cardSecurityCodeVerificationVal)||((this.cardSecurityCodeVerificationVal!= null)&&this.cardSecurityCodeVerificationVal.equals(rhs.cardSecurityCodeVerificationVal))))&&((this.standInProcessingReasonCd == rhs.standInProcessingReasonCd)||((this.standInProcessingReasonCd!= null)&&this.standInProcessingReasonCd.equals(rhs.standInProcessingReasonCd))))&&((this.approvalCd == rhs.approvalCd)||((this.approvalCd!= null)&&this.approvalCd.equals(rhs.approvalCd))))&&((this.authorizationRequestCd == rhs.authorizationRequestCd)||((this.authorizationRequestCd!= null)&&this.authorizationRequestCd.equals(rhs.authorizationRequestCd))))&&((this.originatingAgreementTypeCd == rhs.originatingAgreementTypeCd)||((this.originatingAgreementTypeCd!= null)&&this.originatingAgreementTypeCd.equals(rhs.originatingAgreementTypeCd))))&&((this.authorizationResponseCd == rhs.authorizationResponseCd)||((this.authorizationResponseCd!= null)&&this.authorizationResponseCd.equals(rhs.authorizationResponseCd))))&&((this.virtualCardNum == rhs.virtualCardNum)||((this.virtualCardNum!= null)&&this.virtualCardNum.equals(rhs.virtualCardNum))))&&((this.transactionCccyamt == rhs.transactionCccyamt)||((this.transactionCccyamt!= null)&&this.transactionCccyamt.equals(rhs.transactionCccyamt))))&&((this.cardExpirationYm == rhs.cardExpirationYm)||((this.cardExpirationYm!= null)&&this.cardExpirationYm.equals(rhs.cardExpirationYm))))&&((this.massCompromisedCd == rhs.massCompromisedCd)||((this.massCompromisedCd!= null)&&this.massCompromisedCd.equals(rhs.massCompromisedCd))))&&((this.originalCardNum == rhs.originalCardNum)||((this.originalCardNum!= null)&&this.originalCardNum.equals(rhs.originalCardNum))))&&((this.transactionCurrencyCd == rhs.transactionCurrencyCd)||((this.transactionCurrencyCd!= null)&&this.transactionCurrencyCd.equals(rhs.transactionCurrencyCd))))&&((this.authorizationMessageTypeCd == rhs.authorizationMessageTypeCd)||((this.authorizationMessageTypeCd!= null)&&this.authorizationMessageTypeCd.equals(rhs.authorizationMessageTypeCd))))&&((this.accountHolderAuthenticationValueResultCd == rhs.accountHolderAuthenticationValueResultCd)||((this.accountHolderAuthenticationValueResultCd!= null)&&this.accountHolderAuthenticationValueResultCd.equals(rhs.accountHolderAuthenticationValueResultCd))))&&((this.merchantInfo == rhs.merchantInfo)||((this.merchantInfo!= null)&&this.merchantInfo.equals(rhs.merchantInfo))))&&((this.sourceTransactionId == rhs.sourceTransactionId)||((this.sourceTransactionId!= null)&&this.sourceTransactionId.equals(rhs.sourceTransactionId))))&&((this.chipCard == rhs.chipCard)||((this.chipCard!= null)&&this.chipCard.equals(rhs.chipCard))))&&((this.authorizationFeatureId == rhs.authorizationFeatureId)||((this.authorizationFeatureId!= null)&&this.authorizationFeatureId.equals(rhs.authorizationFeatureId))))&&((this.authorizationMessageTypeDesc == rhs.authorizationMessageTypeDesc)||((this.authorizationMessageTypeDesc!= null)&&this.authorizationMessageTypeDesc.equals(rhs.authorizationMessageTypeDesc))))&&((this.activityTypeDesc == rhs.activityTypeDesc)||((this.activityTypeDesc!= null)&&this.activityTypeDesc.equals(rhs.activityTypeDesc))))&&((this.partyAgreementRoleCd == rhs.partyAgreementRoleCd)||((this.partyAgreementRoleCd!= null)&&this.partyAgreementRoleCd.equals(rhs.partyAgreementRoleCd))))&&((this.recurringInd == rhs.recurringInd)||((this.recurringInd!= null)&&this.recurringInd.equals(rhs.recurringInd))))&&((this.authorizationRequestTypeDesc == rhs.authorizationRequestTypeDesc)||((this.authorizationRequestTypeDesc!= null)&&this.authorizationRequestTypeDesc.equals(rhs.authorizationRequestTypeDesc))))&&((this.paymentTokenId == rhs.paymentTokenId)||((this.paymentTokenId!= null)&&this.paymentTokenId.equals(rhs.paymentTokenId))))&&((this.cardVerificationMismatchStatusReasonCd == rhs.cardVerificationMismatchStatusReasonCd)||((this.cardVerificationMismatchStatusReasonCd!= null)&&this.cardVerificationMismatchStatusReasonCd.equals(rhs.cardVerificationMismatchStatusReasonCd))))&&((this.cashBackCccyamt == rhs.cashBackCccyamt)||((this.cashBackCccyamt!= null)&&this.cashBackCccyamt.equals(rhs.cashBackCccyamt))))&&((this.pointOfServiceTerminalEntryDesc == rhs.pointOfServiceTerminalEntryDesc)||((this.pointOfServiceTerminalEntryDesc!= null)&&this.pointOfServiceTerminalEntryDesc.equals(rhs.pointOfServiceTerminalEntryDesc))))&&((this.beforeTransactionCreditAvailableCccyamt == rhs.beforeTransactionCreditAvailableCccyamt)||((this.beforeTransactionCreditAvailableCccyamt!= null)&&this.beforeTransactionCreditAvailableCccyamt.equals(rhs.beforeTransactionCreditAvailableCccyamt))));
    }

}
