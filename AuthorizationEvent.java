package com.td.api.mbcca.response.account;

import java.math.BigDecimal;
import java.util.Date;

import com.td.api.mbcca.shared.Cccyamt;
import com.td.api.mbcca.shared.MerchantInfo;
import com.td.api.mbcca.shared.TdCardsExtensionEventDescription;

public class AuthorizationEvent {

    private String eventId;
    private String eventDescriptionTxt;
    private String statusCd;
    private Date eventDttm;
    private String debitCreditCd;
    private BigDecimal amt;
    private MerchantInfo merchantInfo;
    private String activityTypeCd;
    private String activityTypeDesc;
    private String originalCardNum;
    private String transactionSourceCd;
    private String transactionSourceDesc;
    private String approvalCd;
    private OriginalCccyamt originalCccyamt;
    private String preAuthorizationCd;
    private String authorizationResponseCd;
    private Cccyamt afterTransactionAvailableCccyamt;
    private String authorizationMessageTypeCd;
    private String acquirerBankIdentificationNum;
    private String acquirerCountryCd;
    private Boolean authorizationForeignCurrencyInd;
    private String cardNumMasked;
    private Boolean paymentHoldInd;
    private Boolean foreignTransactionInd;
    private TdCardsExtensionEventDescription tdCardsExtension;
    private String authorizationResponseReasonDesc;
    private Boolean virtualCardNumberInd;
    private String paymentTokenId;
    private String paymentTokenRequesterId;
    private ChipCard chipCard;
    private String transactionCurrencyCd;
    private AuthorizationEventDetail authorizationEventDetail;
    private String startDt;
    private String startTm;

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getEventDescriptionTxt() {
        return eventDescriptionTxt;
    }

    public void setEventDescriptionTxt(String eventDescriptionTxt) {
        this.eventDescriptionTxt = eventDescriptionTxt;
    }

    public String getStatusCd() {
        return statusCd;
    }

    public void setStatusCd(String statusCd) {
        this.statusCd = statusCd;
    }

    public Date getEventDttm() {
        return eventDttm;
    }

    public void setEventDttm(Date eventDttm) {
        this.eventDttm = eventDttm;
    }

    public String getDebitCreditCd() {
        return debitCreditCd;
    }

    public void setDebitCreditCd(String debitCreditCd) {
        this.debitCreditCd = debitCreditCd;
    }

    public BigDecimal getAmt() {
        return amt;
    }

    public void setAmt(BigDecimal amt) {
        this.amt = amt;
    }

    public MerchantInfo getMerchantInfo() {
        return merchantInfo;
    }

    public void setMerchantInfo(MerchantInfo merchantInfo) {
        this.merchantInfo = merchantInfo;
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

    public String getOriginalCardNum() {
        return originalCardNum;
    }

    public void setOriginalCardNum(String originalCardNum) {
        this.originalCardNum = originalCardNum;
    }

    public String getTransactionSourceCd() {
        return transactionSourceCd;
    }

    public void setTransactionSourceCd(String transactionSourceCd) {
        this.transactionSourceCd = transactionSourceCd;
    }

    public String getTransactionSourceDesc() {
        return transactionSourceDesc;
    }

    public void setTransactionSourceDesc(String transactionSourceDesc) {
        this.transactionSourceDesc = transactionSourceDesc;
    }

    public String getApprovalCd() {
        return approvalCd;
    }

    public void setApprovalCd(String approvalCd) {
        this.approvalCd = approvalCd;
    }

    public OriginalCccyamt getOriginalCccyamt() {
        return originalCccyamt;
    }

    public void setOriginalCccyamt(OriginalCccyamt originalCccyamt) {
        this.originalCccyamt = originalCccyamt;
    }

    public String getPreAuthorizationCd() {
        return preAuthorizationCd;
    }

    public void setPreAuthorizationCd(String preAuthorizationCd) {
        this.preAuthorizationCd = preAuthorizationCd;
    }

    public String getAuthorizationResponseCd() {
        return authorizationResponseCd;
    }

    public void setAuthorizationResponseCd(String authorizationResponseCd) {
        this.authorizationResponseCd = authorizationResponseCd;
    }

    public Cccyamt getAfterTransactionAvailableCccyamt() {
        return afterTransactionAvailableCccyamt;
    }

    public void setAfterTransactionAvailableCccyamt(Cccyamt afterTransactionAvailableCccyamt) {
        this.afterTransactionAvailableCccyamt = afterTransactionAvailableCccyamt;
    }

    public String getAuthorizationMessageTypeCd() {
        return authorizationMessageTypeCd;
    }

    public void setAuthorizationMessageTypeCd(String authorizationMessageTypeCd) {
        this.authorizationMessageTypeCd = authorizationMessageTypeCd;
    }

    public String getAcquirerBankIdentificationNum() {
        return acquirerBankIdentificationNum;
    }

    public void setAcquirerBankIdentificationNum(String acquirerBankIdentificationNum) {
        this.acquirerBankIdentificationNum = acquirerBankIdentificationNum;
    }

    public String getAcquirerCountryCd() {
        return acquirerCountryCd;
    }

    public void setAcquirerCountryCd(String acquirerCountryCd) {
        this.acquirerCountryCd = acquirerCountryCd;
    }

    public Boolean getAuthorizationForeignCurrencyInd() {
        return authorizationForeignCurrencyInd;
    }

    public void setAuthorizationForeignCurrencyInd(Boolean authorizationForeignCurrencyInd) {
        this.authorizationForeignCurrencyInd = authorizationForeignCurrencyInd;
    }

    public String getCardNumMasked() {
        return cardNumMasked;
    }

    public void setCardNumMasked(String cardNumMasked) {
        this.cardNumMasked = cardNumMasked;
    }

    public Boolean getPaymentHoldInd() {
        return paymentHoldInd;
    }

    public void setPaymentHoldInd(Boolean paymentHoldInd) {
        this.paymentHoldInd = paymentHoldInd;
    }

    public Boolean getForeignTransactionInd() {
        return foreignTransactionInd;
    }

    public void setForeignTransactionInd(Boolean foreignTransactionInd) {
        this.foreignTransactionInd = foreignTransactionInd;
    }

    public TdCardsExtensionEventDescription getTdCardsExtension() {
        return tdCardsExtension;
    }

    public void setTdCardsExtension(TdCardsExtensionEventDescription tdCardsExtension) {
        this.tdCardsExtension = tdCardsExtension;
    }

    public String getAuthorizationResponseReasonDesc() {
        return authorizationResponseReasonDesc;
    }

    public void setAuthorizationResponseReasonDesc(String authorizationResponseReasonDesc) {
        this.authorizationResponseReasonDesc = authorizationResponseReasonDesc;
    }

    public Boolean getVirtualCardNumberInd() {
        return virtualCardNumberInd;
    }

    public void setVirtualCardNumberInd(Boolean virtualCardNumberInd) {
        this.virtualCardNumberInd = virtualCardNumberInd;
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

    public AuthorizationEventDetail getAuthorizationEventDetail() {
        return authorizationEventDetail;
    }

    public void setAuthorizationEventDetail(AuthorizationEventDetail authorizationEventDetail) {
        this.authorizationEventDetail = authorizationEventDetail;
    }

    public String getStartDt() {
        return startDt;
    }

    public void setStartDt(String startDt) {
        this.startDt = startDt;
    }

    public String getStartTm() {
        return startTm;
    }

    public void setStartTm(String startTm) {
        this.startTm = startTm;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AuthorizationEvent.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("eventId");
        sb.append('=');
        sb.append(((this.eventId == null)?"<null>":this.eventId));
        sb.append(',');
        sb.append("eventDescriptionTxt");
        sb.append('=');
        sb.append(((this.eventDescriptionTxt == null)?"<null>":this.eventDescriptionTxt));
        sb.append(',');
        sb.append("statusCd");
        sb.append('=');
        sb.append(((this.statusCd == null)?"<null>":this.statusCd));
        sb.append(',');
        sb.append("eventDttm");
        sb.append('=');
        sb.append(((this.eventDttm == null)?"<null>":this.eventDttm));
        sb.append(',');
        sb.append("debitCreditCd");
        sb.append('=');
        sb.append(((this.debitCreditCd == null)?"<null>":this.debitCreditCd));
        sb.append(',');
        sb.append("amt");
        sb.append('=');
        sb.append(((this.amt == null)?"<null>":this.amt));
        sb.append(',');
        sb.append("merchantInfo");
        sb.append('=');
        sb.append(((this.merchantInfo == null)?"<null>":this.merchantInfo));
        sb.append(',');
        sb.append("activityTypeCd");
        sb.append('=');
        sb.append(((this.activityTypeCd == null)?"<null>":this.activityTypeCd));
        sb.append(',');
        sb.append("activityTypeDesc");
        sb.append('=');
        sb.append(((this.activityTypeDesc == null)?"<null>":this.activityTypeDesc));
        sb.append(',');
        sb.append("originalCardNum");
        sb.append('=');
        sb.append(((this.originalCardNum == null)?"<null>":this.originalCardNum));
        sb.append(',');
        sb.append("transactionSourceCd");
        sb.append('=');
        sb.append(((this.transactionSourceCd == null)?"<null>":this.transactionSourceCd));
        sb.append(',');
        sb.append("transactionSourceDesc");
        sb.append('=');
        sb.append(((this.transactionSourceDesc == null)?"<null>":this.transactionSourceDesc));
        sb.append(',');
        sb.append("approvalCd");
        sb.append('=');
        sb.append(((this.approvalCd == null)?"<null>":this.approvalCd));
        sb.append(',');
        sb.append("originalCccyamt");
        sb.append('=');
        sb.append(((this.originalCccyamt == null)?"<null>":this.originalCccyamt));
        sb.append(',');
        sb.append("preAuthorizationCd");
        sb.append('=');
        sb.append(((this.preAuthorizationCd == null)?"<null>":this.preAuthorizationCd));
        sb.append(',');
        sb.append("authorizationResponseCd");
        sb.append('=');
        sb.append(((this.authorizationResponseCd == null)?"<null>":this.authorizationResponseCd));
        sb.append(',');
        sb.append("afterTransactionAvailableCccyamt");
        sb.append('=');
        sb.append(((this.afterTransactionAvailableCccyamt == null)?"<null>":this.afterTransactionAvailableCccyamt));
        sb.append(',');
        sb.append("authorizationMessageTypeCd");
        sb.append('=');
        sb.append(((this.authorizationMessageTypeCd == null)?"<null>":this.authorizationMessageTypeCd));
        sb.append(',');
        sb.append("acquirerBankIdentificationNum");
        sb.append('=');
        sb.append(((this.acquirerBankIdentificationNum == null)?"<null>":this.acquirerBankIdentificationNum));
        sb.append(',');
        sb.append("acquirerCountryCd");
        sb.append('=');
        sb.append(((this.acquirerCountryCd == null)?"<null>":this.acquirerCountryCd));
        sb.append(',');
        sb.append("authorizationForeignCurrencyInd");
        sb.append('=');
        sb.append(((this.authorizationForeignCurrencyInd == null)?"<null>":this.authorizationForeignCurrencyInd));
        sb.append(',');
        sb.append("cardNumMasked");
        sb.append('=');
        sb.append(((this.cardNumMasked == null)?"<null>":this.cardNumMasked));
        sb.append(',');
        sb.append("paymentHoldInd");
        sb.append('=');
        sb.append(((this.paymentHoldInd == null)?"<null>":this.paymentHoldInd));
        sb.append(',');
        sb.append("foreignTransactionInd");
        sb.append('=');
        sb.append(((this.foreignTransactionInd == null)?"<null>":this.foreignTransactionInd));
        sb.append(',');
        sb.append("tdCardsExtension");
        sb.append('=');
        sb.append(((this.tdCardsExtension == null)?"<null>":this.tdCardsExtension));
        sb.append(',');
        sb.append("authorizationResponseReasonDesc");
        sb.append('=');
        sb.append(((this.authorizationResponseReasonDesc == null)?"<null>":this.authorizationResponseReasonDesc));
        sb.append(',');
        sb.append("virtualCardNumberInd");
        sb.append('=');
        sb.append(((this.virtualCardNumberInd == null)?"<null>":this.virtualCardNumberInd));
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
        sb.append("authorizationEventDetail");
        sb.append('=');
        sb.append(((this.authorizationEventDetail == null)?"<null>":this.authorizationEventDetail));
        sb.append(',');
        sb.append("startDt");
        sb.append('=');
        sb.append(((this.startDt == null)?"<null>":this.startDt));
        sb.append(',');
        sb.append("startTm");
        sb.append('=');
        sb.append(((this.startTm == null)?"<null>":this.startTm));
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
        result = ((result* 31)+((this.acquirerBankIdentificationNum == null)? 0 :this.acquirerBankIdentificationNum.hashCode()));
        result = ((result* 31)+((this.paymentHoldInd == null)? 0 :this.paymentHoldInd.hashCode()));
        result = ((result* 31)+((this.eventDescriptionTxt == null)? 0 :this.eventDescriptionTxt.hashCode()));
        result = ((result* 31)+((this.amt == null)? 0 :this.amt.hashCode()));
        result = ((result* 31)+((this.acquirerCountryCd == null)? 0 :this.acquirerCountryCd.hashCode()));
        result = ((result* 31)+((this.paymentTokenRequesterId == null)? 0 :this.paymentTokenRequesterId.hashCode()));
        result = ((result* 31)+((this.authorizationEventDetail == null)? 0 :this.authorizationEventDetail.hashCode()));
        result = ((result* 31)+((this.startTm == null)? 0 :this.startTm.hashCode()));
        result = ((result* 31)+((this.activityTypeCd == null)? 0 :this.activityTypeCd.hashCode()));
        result = ((result* 31)+((this.eventDttm == null)? 0 :this.eventDttm.hashCode()));
        result = ((result* 31)+((this.authorizationForeignCurrencyInd == null)? 0 :this.authorizationForeignCurrencyInd.hashCode()));
        result = ((result* 31)+((this.preAuthorizationCd == null)? 0 :this.preAuthorizationCd.hashCode()));
        result = ((result* 31)+((this.approvalCd == null)? 0 :this.approvalCd.hashCode()));
        result = ((result* 31)+((this.eventId == null)? 0 :this.eventId.hashCode()));
        result = ((result* 31)+((this.transactionSourceCd == null)? 0 :this.transactionSourceCd.hashCode()));
        result = ((result* 31)+((this.originalCccyamt == null)? 0 :this.originalCccyamt.hashCode()));
        result = ((result* 31)+((this.authorizationResponseCd == null)? 0 :this.authorizationResponseCd.hashCode()));
        result = ((result* 31)+((this.originalCardNum == null)? 0 :this.originalCardNum.hashCode()));
        result = ((result* 31)+((this.foreignTransactionInd == null)? 0 :this.foreignTransactionInd.hashCode()));
        result = ((result* 31)+((this.transactionCurrencyCd == null)? 0 :this.transactionCurrencyCd.hashCode()));
        result = ((result* 31)+((this.authorizationMessageTypeCd == null)? 0 :this.authorizationMessageTypeCd.hashCode()));
        result = ((result* 31)+((this.statusCd == null)? 0 :this.statusCd.hashCode()));
        result = ((result* 31)+((this.transactionSourceDesc == null)? 0 :this.transactionSourceDesc.hashCode()));
        result = ((result* 31)+((this.merchantInfo == null)? 0 :this.merchantInfo.hashCode()));
        result = ((result* 31)+((this.afterTransactionAvailableCccyamt == null)? 0 :this.afterTransactionAvailableCccyamt.hashCode()));
        result = ((result* 31)+((this.virtualCardNumberInd == null)? 0 :this.virtualCardNumberInd.hashCode()));
        result = ((result* 31)+((this.chipCard == null)? 0 :this.chipCard.hashCode()));
        result = ((result* 31)+((this.tdCardsExtension == null)? 0 :this.tdCardsExtension.hashCode()));
        result = ((result* 31)+((this.debitCreditCd == null)? 0 :this.debitCreditCd.hashCode()));
        result = ((result* 31)+((this.activityTypeDesc == null)? 0 :this.activityTypeDesc.hashCode()));
        result = ((result* 31)+((this.authorizationResponseReasonDesc == null)? 0 :this.authorizationResponseReasonDesc.hashCode()));
        result = ((result* 31)+((this.paymentTokenId == null)? 0 :this.paymentTokenId.hashCode()));
        result = ((result* 31)+((this.startDt == null)? 0 :this.startDt.hashCode()));
        result = ((result* 31)+((this.cardNumMasked == null)? 0 :this.cardNumMasked.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AuthorizationEvent) == false) {
            return false;
        }
        AuthorizationEvent rhs = ((AuthorizationEvent) other);
        return (((((((((((((((((((((((((((((((((((this.acquirerBankIdentificationNum == rhs.acquirerBankIdentificationNum)||((this.acquirerBankIdentificationNum!= null)&&this.acquirerBankIdentificationNum.equals(rhs.acquirerBankIdentificationNum)))&&((this.paymentHoldInd == rhs.paymentHoldInd)||((this.paymentHoldInd!= null)&&this.paymentHoldInd.equals(rhs.paymentHoldInd))))&&((this.eventDescriptionTxt == rhs.eventDescriptionTxt)||((this.eventDescriptionTxt!= null)&&this.eventDescriptionTxt.equals(rhs.eventDescriptionTxt))))&&((this.amt == rhs.amt)||((this.amt!= null)&&this.amt.equals(rhs.amt))))&&((this.acquirerCountryCd == rhs.acquirerCountryCd)||((this.acquirerCountryCd!= null)&&this.acquirerCountryCd.equals(rhs.acquirerCountryCd))))&&((this.paymentTokenRequesterId == rhs.paymentTokenRequesterId)||((this.paymentTokenRequesterId!= null)&&this.paymentTokenRequesterId.equals(rhs.paymentTokenRequesterId))))&&((this.authorizationEventDetail == rhs.authorizationEventDetail)||((this.authorizationEventDetail!= null)&&this.authorizationEventDetail.equals(rhs.authorizationEventDetail))))&&((this.startTm == rhs.startTm)||((this.startTm!= null)&&this.startTm.equals(rhs.startTm))))&&((this.activityTypeCd == rhs.activityTypeCd)||((this.activityTypeCd!= null)&&this.activityTypeCd.equals(rhs.activityTypeCd))))&&((this.eventDttm == rhs.eventDttm)||((this.eventDttm!= null)&&this.eventDttm.equals(rhs.eventDttm))))&&((this.authorizationForeignCurrencyInd == rhs.authorizationForeignCurrencyInd)||((this.authorizationForeignCurrencyInd!= null)&&this.authorizationForeignCurrencyInd.equals(rhs.authorizationForeignCurrencyInd))))&&((this.preAuthorizationCd == rhs.preAuthorizationCd)||((this.preAuthorizationCd!= null)&&this.preAuthorizationCd.equals(rhs.preAuthorizationCd))))&&((this.approvalCd == rhs.approvalCd)||((this.approvalCd!= null)&&this.approvalCd.equals(rhs.approvalCd))))&&((this.eventId == rhs.eventId)||((this.eventId!= null)&&this.eventId.equals(rhs.eventId))))&&((this.transactionSourceCd == rhs.transactionSourceCd)||((this.transactionSourceCd!= null)&&this.transactionSourceCd.equals(rhs.transactionSourceCd))))&&((this.originalCccyamt == rhs.originalCccyamt)||((this.originalCccyamt!= null)&&this.originalCccyamt.equals(rhs.originalCccyamt))))&&((this.authorizationResponseCd == rhs.authorizationResponseCd)||((this.authorizationResponseCd!= null)&&this.authorizationResponseCd.equals(rhs.authorizationResponseCd))))&&((this.originalCardNum == rhs.originalCardNum)||((this.originalCardNum!= null)&&this.originalCardNum.equals(rhs.originalCardNum))))&&((this.foreignTransactionInd == rhs.foreignTransactionInd)||((this.foreignTransactionInd!= null)&&this.foreignTransactionInd.equals(rhs.foreignTransactionInd))))&&((this.transactionCurrencyCd == rhs.transactionCurrencyCd)||((this.transactionCurrencyCd!= null)&&this.transactionCurrencyCd.equals(rhs.transactionCurrencyCd))))&&((this.authorizationMessageTypeCd == rhs.authorizationMessageTypeCd)||((this.authorizationMessageTypeCd!= null)&&this.authorizationMessageTypeCd.equals(rhs.authorizationMessageTypeCd))))&&((this.statusCd == rhs.statusCd)||((this.statusCd!= null)&&this.statusCd.equals(rhs.statusCd))))&&((this.transactionSourceDesc == rhs.transactionSourceDesc)||((this.transactionSourceDesc!= null)&&this.transactionSourceDesc.equals(rhs.transactionSourceDesc))))&&((this.merchantInfo == rhs.merchantInfo)||((this.merchantInfo!= null)&&this.merchantInfo.equals(rhs.merchantInfo))))&&((this.afterTransactionAvailableCccyamt == rhs.afterTransactionAvailableCccyamt)||((this.afterTransactionAvailableCccyamt!= null)&&this.afterTransactionAvailableCccyamt.equals(rhs.afterTransactionAvailableCccyamt))))&&((this.virtualCardNumberInd == rhs.virtualCardNumberInd)||((this.virtualCardNumberInd!= null)&&this.virtualCardNumberInd.equals(rhs.virtualCardNumberInd))))&&((this.chipCard == rhs.chipCard)||((this.chipCard!= null)&&this.chipCard.equals(rhs.chipCard))))&&((this.tdCardsExtension == rhs.tdCardsExtension)||((this.tdCardsExtension!= null)&&this.tdCardsExtension.equals(rhs.tdCardsExtension))))&&((this.debitCreditCd == rhs.debitCreditCd)||((this.debitCreditCd!= null)&&this.debitCreditCd.equals(rhs.debitCreditCd))))&&((this.activityTypeDesc == rhs.activityTypeDesc)||((this.activityTypeDesc!= null)&&this.activityTypeDesc.equals(rhs.activityTypeDesc))))&&((this.authorizationResponseReasonDesc == rhs.authorizationResponseReasonDesc)||((this.authorizationResponseReasonDesc!= null)&&this.authorizationResponseReasonDesc.equals(rhs.authorizationResponseReasonDesc))))&&((this.paymentTokenId == rhs.paymentTokenId)||((this.paymentTokenId!= null)&&this.paymentTokenId.equals(rhs.paymentTokenId))))&&((this.startDt == rhs.startDt)||((this.startDt!= null)&&this.startDt.equals(rhs.startDt))))&&((this.cardNumMasked == rhs.cardNumMasked)||((this.cardNumMasked!= null)&&this.cardNumMasked.equals(rhs.cardNumMasked))));
    }

}
