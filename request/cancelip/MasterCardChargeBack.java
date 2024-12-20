package com.td.api.mbcca.request.cancelip;

public class MasterCardChargeBack {

    private String reasonCd;
    private String functionCd;
    private String cardSequenceNum;
    private String documentationStatusCd;
    private String referenceNum;
    private String memberMessageTxt;
    private String terminalChannelTypeSourceCd;
    private String pointOfServiceTerminalCapabilityCd;
    private String electronicCommerceSecurityLevelCd;
    private String walletId;
    private OriginalAuthorizationEvent__1 originalAuthorizationEvent;

    public String getReasonCd() {
        return reasonCd;
    }

    public void setReasonCd(String reasonCd) {
        this.reasonCd = reasonCd;
    }

    public String getFunctionCd() {
        return functionCd;
    }

    public void setFunctionCd(String functionCd) {
        this.functionCd = functionCd;
    }

    public String getCardSequenceNum() {
        return cardSequenceNum;
    }

    public void setCardSequenceNum(String cardSequenceNum) {
        this.cardSequenceNum = cardSequenceNum;
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

    public String getMemberMessageTxt() {
        return memberMessageTxt;
    }

    public void setMemberMessageTxt(String memberMessageTxt) {
        this.memberMessageTxt = memberMessageTxt;
    }

    public String getTerminalChannelTypeSourceCd() {
        return terminalChannelTypeSourceCd;
    }

    public void setTerminalChannelTypeSourceCd(String terminalChannelTypeSourceCd) {
        this.terminalChannelTypeSourceCd = terminalChannelTypeSourceCd;
    }

    public String getPointOfServiceTerminalCapabilityCd() {
        return pointOfServiceTerminalCapabilityCd;
    }

    public void setPointOfServiceTerminalCapabilityCd(String pointOfServiceTerminalCapabilityCd) {
        this.pointOfServiceTerminalCapabilityCd = pointOfServiceTerminalCapabilityCd;
    }

    public String getElectronicCommerceSecurityLevelCd() {
        return electronicCommerceSecurityLevelCd;
    }

    public void setElectronicCommerceSecurityLevelCd(String electronicCommerceSecurityLevelCd) {
        this.electronicCommerceSecurityLevelCd = electronicCommerceSecurityLevelCd;
    }

    public String getWalletId() {
        return walletId;
    }

    public void setWalletId(String walletId) {
        this.walletId = walletId;
    }

    public OriginalAuthorizationEvent__1 getOriginalAuthorizationEvent() {
        return originalAuthorizationEvent;
    }

    public void setOriginalAuthorizationEvent(OriginalAuthorizationEvent__1 originalAuthorizationEvent) {
        this.originalAuthorizationEvent = originalAuthorizationEvent;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(MasterCardChargeBack.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("reasonCd");
        sb.append('=');
        sb.append(((this.reasonCd == null)?"<null>":this.reasonCd));
        sb.append(',');
        sb.append("functionCd");
        sb.append('=');
        sb.append(((this.functionCd == null)?"<null>":this.functionCd));
        sb.append(',');
        sb.append("cardSequenceNum");
        sb.append('=');
        sb.append(((this.cardSequenceNum == null)?"<null>":this.cardSequenceNum));
        sb.append(',');
        sb.append("documentationStatusCd");
        sb.append('=');
        sb.append(((this.documentationStatusCd == null)?"<null>":this.documentationStatusCd));
        sb.append(',');
        sb.append("referenceNum");
        sb.append('=');
        sb.append(((this.referenceNum == null)?"<null>":this.referenceNum));
        sb.append(',');
        sb.append("memberMessageTxt");
        sb.append('=');
        sb.append(((this.memberMessageTxt == null)?"<null>":this.memberMessageTxt));
        sb.append(',');
        sb.append("terminalChannelTypeSourceCd");
        sb.append('=');
        sb.append(((this.terminalChannelTypeSourceCd == null)?"<null>":this.terminalChannelTypeSourceCd));
        sb.append(',');
        sb.append("pointOfServiceTerminalCapabilityCd");
        sb.append('=');
        sb.append(((this.pointOfServiceTerminalCapabilityCd == null)?"<null>":this.pointOfServiceTerminalCapabilityCd));
        sb.append(',');
        sb.append("electronicCommerceSecurityLevelCd");
        sb.append('=');
        sb.append(((this.electronicCommerceSecurityLevelCd == null)?"<null>":this.electronicCommerceSecurityLevelCd));
        sb.append(',');
        sb.append("walletId");
        sb.append('=');
        sb.append(((this.walletId == null)?"<null>":this.walletId));
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
        result = ((result* 31)+((this.referenceNum == null)? 0 :this.referenceNum.hashCode()));
        result = ((result* 31)+((this.walletId == null)? 0 :this.walletId.hashCode()));
        result = ((result* 31)+((this.pointOfServiceTerminalCapabilityCd == null)? 0 :this.pointOfServiceTerminalCapabilityCd.hashCode()));
        result = ((result* 31)+((this.terminalChannelTypeSourceCd == null)? 0 :this.terminalChannelTypeSourceCd.hashCode()));
        result = ((result* 31)+((this.documentationStatusCd == null)? 0 :this.documentationStatusCd.hashCode()));
        result = ((result* 31)+((this.functionCd == null)? 0 :this.functionCd.hashCode()));
        result = ((result* 31)+((this.electronicCommerceSecurityLevelCd == null)? 0 :this.electronicCommerceSecurityLevelCd.hashCode()));
        result = ((result* 31)+((this.originalAuthorizationEvent == null)? 0 :this.originalAuthorizationEvent.hashCode()));
        result = ((result* 31)+((this.cardSequenceNum == null)? 0 :this.cardSequenceNum.hashCode()));
        result = ((result* 31)+((this.reasonCd == null)? 0 :this.reasonCd.hashCode()));
        result = ((result* 31)+((this.memberMessageTxt == null)? 0 :this.memberMessageTxt.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof MasterCardChargeBack) == false) {
            return false;
        }
        MasterCardChargeBack rhs = ((MasterCardChargeBack) other);
        return ((((((((((((this.referenceNum == rhs.referenceNum)||((this.referenceNum!= null)&&this.referenceNum.equals(rhs.referenceNum)))&&((this.walletId == rhs.walletId)||((this.walletId!= null)&&this.walletId.equals(rhs.walletId))))&&((this.pointOfServiceTerminalCapabilityCd == rhs.pointOfServiceTerminalCapabilityCd)||((this.pointOfServiceTerminalCapabilityCd!= null)&&this.pointOfServiceTerminalCapabilityCd.equals(rhs.pointOfServiceTerminalCapabilityCd))))&&((this.terminalChannelTypeSourceCd == rhs.terminalChannelTypeSourceCd)||((this.terminalChannelTypeSourceCd!= null)&&this.terminalChannelTypeSourceCd.equals(rhs.terminalChannelTypeSourceCd))))&&((this.documentationStatusCd == rhs.documentationStatusCd)||((this.documentationStatusCd!= null)&&this.documentationStatusCd.equals(rhs.documentationStatusCd))))&&((this.functionCd == rhs.functionCd)||((this.functionCd!= null)&&this.functionCd.equals(rhs.functionCd))))&&((this.electronicCommerceSecurityLevelCd == rhs.electronicCommerceSecurityLevelCd)||((this.electronicCommerceSecurityLevelCd!= null)&&this.electronicCommerceSecurityLevelCd.equals(rhs.electronicCommerceSecurityLevelCd))))&&((this.originalAuthorizationEvent == rhs.originalAuthorizationEvent)||((this.originalAuthorizationEvent!= null)&&this.originalAuthorizationEvent.equals(rhs.originalAuthorizationEvent))))&&((this.cardSequenceNum == rhs.cardSequenceNum)||((this.cardSequenceNum!= null)&&this.cardSequenceNum.equals(rhs.cardSequenceNum))))&&((this.reasonCd == rhs.reasonCd)||((this.reasonCd!= null)&&this.reasonCd.equals(rhs.reasonCd))))&&((this.memberMessageTxt == rhs.memberMessageTxt)||((this.memberMessageTxt!= null)&&this.memberMessageTxt.equals(rhs.memberMessageTxt))));
    }

}
