package com.td.api.mbcca.request.cancelip;

public class VisaChargeBack {

    private String reasonCd;
    private String documentationStatusCd;
    private String referenceNum;
    private String reimbursementFeeCd;
    private String mailTelephoneOrderTransactionCd;
    private String partialChargeBackCd;
    private String authorizationSourceCd;
    private String merchantPointOfServiceTerminalChannelInstanceId;
    private String terminalChannelTypeSourceCd;
    private String merchantPointOfServiceTerminalCapabilitySourceCd;
    private String merchantPointOfServiceTerminalEntrySourceCd;
    private String cardHolderIdentificationTypeSourceCd;
    private String memberMessageTxt;
    private Boolean adjustmentPostedInd;
    private OriginalAuthorizationEvent originalAuthorizationEvent;

    public String getReasonCd() {
        return reasonCd;
    }

    public void setReasonCd(String reasonCd) {
        this.reasonCd = reasonCd;
    }

    public String getDocumentationStatusCd() {
        return documentationStatusCd;
    }

    public void setDocumentationStatusCd(String documentationStatusCd) {
        this.documentationStatusCd = documentationStatusCd;
    }

    public String getReferenceNum() {
        return referenceNum;
    }

    public void setReferenceNum(String referenceNum) {
        this.referenceNum = referenceNum;
    }

    public String getReimbursementFeeCd() {
        return reimbursementFeeCd;
    }

    public void setReimbursementFeeCd(String reimbursementFeeCd) {
        this.reimbursementFeeCd = reimbursementFeeCd;
    }

    public String getMailTelephoneOrderTransactionCd() {
        return mailTelephoneOrderTransactionCd;
    }

    public void setMailTelephoneOrderTransactionCd(String mailTelephoneOrderTransactionCd) {
        this.mailTelephoneOrderTransactionCd = mailTelephoneOrderTransactionCd;
    }

    public String getPartialChargeBackCd() {
        return partialChargeBackCd;
    }

    public void setPartialChargeBackCd(String partialChargeBackCd) {
        this.partialChargeBackCd = partialChargeBackCd;
    }

    public String getAuthorizationSourceCd() {
        return authorizationSourceCd;
    }

    public void setAuthorizationSourceCd(String authorizationSourceCd) {
        this.authorizationSourceCd = authorizationSourceCd;
    }

    public String getMerchantPointOfServiceTerminalChannelInstanceId() {
        return merchantPointOfServiceTerminalChannelInstanceId;
    }

    public void setMerchantPointOfServiceTerminalChannelInstanceId(String merchantPointOfServiceTerminalChannelInstanceId) {
        this.merchantPointOfServiceTerminalChannelInstanceId = merchantPointOfServiceTerminalChannelInstanceId;
    }

    public String getTerminalChannelTypeSourceCd() {
        return terminalChannelTypeSourceCd;
    }

    public void setTerminalChannelTypeSourceCd(String terminalChannelTypeSourceCd) {
        this.terminalChannelTypeSourceCd = terminalChannelTypeSourceCd;
    }

    public String getMerchantPointOfServiceTerminalCapabilitySourceCd() {
        return merchantPointOfServiceTerminalCapabilitySourceCd;
    }

    public void setMerchantPointOfServiceTerminalCapabilitySourceCd(String merchantPointOfServiceTerminalCapabilitySourceCd) {
        this.merchantPointOfServiceTerminalCapabilitySourceCd = merchantPointOfServiceTerminalCapabilitySourceCd;
    }

    public String getMerchantPointOfServiceTerminalEntrySourceCd() {
        return merchantPointOfServiceTerminalEntrySourceCd;
    }

    public void setMerchantPointOfServiceTerminalEntrySourceCd(String merchantPointOfServiceTerminalEntrySourceCd) {
        this.merchantPointOfServiceTerminalEntrySourceCd = merchantPointOfServiceTerminalEntrySourceCd;
    }

    public String getCardHolderIdentificationTypeSourceCd() {
        return cardHolderIdentificationTypeSourceCd;
    }

    public void setCardHolderIdentificationTypeSourceCd(String cardHolderIdentificationTypeSourceCd) {
        this.cardHolderIdentificationTypeSourceCd = cardHolderIdentificationTypeSourceCd;
    }

    public String getMemberMessageTxt() {
        return memberMessageTxt;
    }

    public void setMemberMessageTxt(String memberMessageTxt) {
        this.memberMessageTxt = memberMessageTxt;
    }

    public Boolean getAdjustmentPostedInd() {
        return adjustmentPostedInd;
    }

    public void setAdjustmentPostedInd(Boolean adjustmentPostedInd) {
        this.adjustmentPostedInd = adjustmentPostedInd;
    }

    public OriginalAuthorizationEvent getOriginalAuthorizationEvent() {
        return originalAuthorizationEvent;
    }

    public void setOriginalAuthorizationEvent(OriginalAuthorizationEvent originalAuthorizationEvent) {
        this.originalAuthorizationEvent = originalAuthorizationEvent;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(VisaChargeBack.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("reasonCd");
        sb.append('=');
        sb.append(((this.reasonCd == null)?"<null>":this.reasonCd));
        sb.append(',');
        sb.append("documentationStatusCd");
        sb.append('=');
        sb.append(((this.documentationStatusCd == null)?"<null>":this.documentationStatusCd));
        sb.append(',');
        sb.append("referenceNum");
        sb.append('=');
        sb.append(((this.referenceNum == null)?"<null>":this.referenceNum));
        sb.append(',');
        sb.append("reimbursementFeeCd");
        sb.append('=');
        sb.append(((this.reimbursementFeeCd == null)?"<null>":this.reimbursementFeeCd));
        sb.append(',');
        sb.append("mailTelephoneOrderTransactionCd");
        sb.append('=');
        sb.append(((this.mailTelephoneOrderTransactionCd == null)?"<null>":this.mailTelephoneOrderTransactionCd));
        sb.append(',');
        sb.append("partialChargeBackCd");
        sb.append('=');
        sb.append(((this.partialChargeBackCd == null)?"<null>":this.partialChargeBackCd));
        sb.append(',');
        sb.append("authorizationSourceCd");
        sb.append('=');
        sb.append(((this.authorizationSourceCd == null)?"<null>":this.authorizationSourceCd));
        sb.append(',');
        sb.append("merchantPointOfServiceTerminalChannelInstanceId");
        sb.append('=');
        sb.append(((this.merchantPointOfServiceTerminalChannelInstanceId == null)?"<null>":this.merchantPointOfServiceTerminalChannelInstanceId));
        sb.append(',');
        sb.append("terminalChannelTypeSourceCd");
        sb.append('=');
        sb.append(((this.terminalChannelTypeSourceCd == null)?"<null>":this.terminalChannelTypeSourceCd));
        sb.append(',');
        sb.append("merchantPointOfServiceTerminalCapabilitySourceCd");
        sb.append('=');
        sb.append(((this.merchantPointOfServiceTerminalCapabilitySourceCd == null)?"<null>":this.merchantPointOfServiceTerminalCapabilitySourceCd));
        sb.append(',');
        sb.append("merchantPointOfServiceTerminalEntrySourceCd");
        sb.append('=');
        sb.append(((this.merchantPointOfServiceTerminalEntrySourceCd == null)?"<null>":this.merchantPointOfServiceTerminalEntrySourceCd));
        sb.append(',');
        sb.append("cardHolderIdentificationTypeSourceCd");
        sb.append('=');
        sb.append(((this.cardHolderIdentificationTypeSourceCd == null)?"<null>":this.cardHolderIdentificationTypeSourceCd));
        sb.append(',');
        sb.append("memberMessageTxt");
        sb.append('=');
        sb.append(((this.memberMessageTxt == null)?"<null>":this.memberMessageTxt));
        sb.append(',');
        sb.append("adjustmentPostedInd");
        sb.append('=');
        sb.append(((this.adjustmentPostedInd == null)?"<null>":this.adjustmentPostedInd));
        sb.append(',');
        sb.append("originalAuthorizationEvent");
        sb.append('=');
        sb.append(((this.originalAuthorizationEvent == null)?"<null>":this.originalAuthorizationEvent));
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
        result = ((result* 31)+((this.mailTelephoneOrderTransactionCd == null)? 0 :this.mailTelephoneOrderTransactionCd.hashCode()));
        result = ((result* 31)+((this.terminalChannelTypeSourceCd == null)? 0 :this.terminalChannelTypeSourceCd.hashCode()));
        result = ((result* 31)+((this.documentationStatusCd == null)? 0 :this.documentationStatusCd.hashCode()));
        result = ((result* 31)+((this.authorizationSourceCd == null)? 0 :this.authorizationSourceCd.hashCode()));
        result = ((result* 31)+((this.merchantPointOfServiceTerminalEntrySourceCd == null)? 0 :this.merchantPointOfServiceTerminalEntrySourceCd.hashCode()));
        result = ((result* 31)+((this.originalAuthorizationEvent == null)? 0 :this.originalAuthorizationEvent.hashCode()));
        result = ((result* 31)+((this.reasonCd == null)? 0 :this.reasonCd.hashCode()));
        result = ((result* 31)+((this.referenceNum == null)? 0 :this.referenceNum.hashCode()));
        result = ((result* 31)+((this.merchantPointOfServiceTerminalCapabilitySourceCd == null)? 0 :this.merchantPointOfServiceTerminalCapabilitySourceCd.hashCode()));
        result = ((result* 31)+((this.reimbursementFeeCd == null)? 0 :this.reimbursementFeeCd.hashCode()));
        result = ((result* 31)+((this.partialChargeBackCd == null)? 0 :this.partialChargeBackCd.hashCode()));
        result = ((result* 31)+((this.merchantPointOfServiceTerminalChannelInstanceId == null)? 0 :this.merchantPointOfServiceTerminalChannelInstanceId.hashCode()));
        result = ((result* 31)+((this.adjustmentPostedInd == null)? 0 :this.adjustmentPostedInd.hashCode()));
        result = ((result* 31)+((this.cardHolderIdentificationTypeSourceCd == null)? 0 :this.cardHolderIdentificationTypeSourceCd.hashCode()));
        result = ((result* 31)+((this.memberMessageTxt == null)? 0 :this.memberMessageTxt.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof VisaChargeBack) == false) {
            return false;
        }
        VisaChargeBack rhs = ((VisaChargeBack) other);
        return ((((((((((((((((this.mailTelephoneOrderTransactionCd == rhs.mailTelephoneOrderTransactionCd)||((this.mailTelephoneOrderTransactionCd!= null)&&this.mailTelephoneOrderTransactionCd.equals(rhs.mailTelephoneOrderTransactionCd)))&&((this.terminalChannelTypeSourceCd == rhs.terminalChannelTypeSourceCd)||((this.terminalChannelTypeSourceCd!= null)&&this.terminalChannelTypeSourceCd.equals(rhs.terminalChannelTypeSourceCd))))&&((this.documentationStatusCd == rhs.documentationStatusCd)||((this.documentationStatusCd!= null)&&this.documentationStatusCd.equals(rhs.documentationStatusCd))))&&((this.authorizationSourceCd == rhs.authorizationSourceCd)||((this.authorizationSourceCd!= null)&&this.authorizationSourceCd.equals(rhs.authorizationSourceCd))))&&((this.merchantPointOfServiceTerminalEntrySourceCd == rhs.merchantPointOfServiceTerminalEntrySourceCd)||((this.merchantPointOfServiceTerminalEntrySourceCd!= null)&&this.merchantPointOfServiceTerminalEntrySourceCd.equals(rhs.merchantPointOfServiceTerminalEntrySourceCd))))&&((this.originalAuthorizationEvent == rhs.originalAuthorizationEvent)||((this.originalAuthorizationEvent!= null)&&this.originalAuthorizationEvent.equals(rhs.originalAuthorizationEvent))))&&((this.reasonCd == rhs.reasonCd)||((this.reasonCd!= null)&&this.reasonCd.equals(rhs.reasonCd))))&&((this.referenceNum == rhs.referenceNum)||((this.referenceNum!= null)&&this.referenceNum.equals(rhs.referenceNum))))&&((this.merchantPointOfServiceTerminalCapabilitySourceCd == rhs.merchantPointOfServiceTerminalCapabilitySourceCd)||((this.merchantPointOfServiceTerminalCapabilitySourceCd!= null)&&this.merchantPointOfServiceTerminalCapabilitySourceCd.equals(rhs.merchantPointOfServiceTerminalCapabilitySourceCd))))&&((this.reimbursementFeeCd == rhs.reimbursementFeeCd)||((this.reimbursementFeeCd!= null)&&this.reimbursementFeeCd.equals(rhs.reimbursementFeeCd))))&&((this.partialChargeBackCd == rhs.partialChargeBackCd)||((this.partialChargeBackCd!= null)&&this.partialChargeBackCd.equals(rhs.partialChargeBackCd))))&&((this.merchantPointOfServiceTerminalChannelInstanceId == rhs.merchantPointOfServiceTerminalChannelInstanceId)||((this.merchantPointOfServiceTerminalChannelInstanceId!= null)&&this.merchantPointOfServiceTerminalChannelInstanceId.equals(rhs.merchantPointOfServiceTerminalChannelInstanceId))))&&((this.adjustmentPostedInd == rhs.adjustmentPostedInd)||((this.adjustmentPostedInd!= null)&&this.adjustmentPostedInd.equals(rhs.adjustmentPostedInd))))&&((this.cardHolderIdentificationTypeSourceCd == rhs.cardHolderIdentificationTypeSourceCd)||((this.cardHolderIdentificationTypeSourceCd!= null)&&this.cardHolderIdentificationTypeSourceCd.equals(rhs.cardHolderIdentificationTypeSourceCd))))&&((this.memberMessageTxt == rhs.memberMessageTxt)||((this.memberMessageTxt!= null)&&this.memberMessageTxt.equals(rhs.memberMessageTxt))));
    }

}
