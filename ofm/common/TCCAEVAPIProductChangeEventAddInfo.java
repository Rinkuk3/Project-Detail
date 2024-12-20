package com.td.api.ofm.common;

public class TCCAEVAPIProductChangeEventAddInfo {

    private TCCAEVAPIGenericAgreementAltkey agreementAltkey;
    private String productId;
    private String eventReasonCd;
    private TCCAEVAPIProductChangeEventToParty party;
    private String originatingUserId;
    private String originatingUserFunctionCd;
    private String solicitationChannelTypeCd;
    private String accessChannelTypeCd;

    public TCCAEVAPIGenericAgreementAltkey getAgreementAltkey() {
        return agreementAltkey;
    }

    public void setAgreementAltkey(TCCAEVAPIGenericAgreementAltkey agreementAltkey) {
        this.agreementAltkey = agreementAltkey;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getEventReasonCd() {
        return eventReasonCd;
    }

    public void setEventReasonCd(String eventReasonCd) {
        this.eventReasonCd = eventReasonCd;
    }

    public TCCAEVAPIProductChangeEventToParty getParty() {
        return party;
    }

    public void setParty(TCCAEVAPIProductChangeEventToParty party) {
        this.party = party;
    }

    public String getOriginatingUserId() {
        return originatingUserId;
    }

    public void setOriginatingUserId(String originatingUserId) {
        this.originatingUserId = originatingUserId;
    }

    public String getOriginatingUserFunctionCd() {
        return originatingUserFunctionCd;
    }

    public void setOriginatingUserFunctionCd(String originatingUserFunctionCd) {
        this.originatingUserFunctionCd = originatingUserFunctionCd;
    }

    public String getSolicitationChannelTypeCd() {
        return solicitationChannelTypeCd;
    }

    public void setSolicitationChannelTypeCd(String solicitationChannelTypeCd) {
        this.solicitationChannelTypeCd = solicitationChannelTypeCd;
    }

    public String getAccessChannelTypeCd() {
        return accessChannelTypeCd;
    }

    public void setAccessChannelTypeCd(String accessChannelTypeCd) {
        this.accessChannelTypeCd = accessChannelTypeCd;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TCCAEVAPIProductChangeEventAddInfo.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("agreementAltkey");
        sb.append('=');
        sb.append(((this.agreementAltkey == null)?"<null>":this.agreementAltkey));
        sb.append(',');
        sb.append("productId");
        sb.append('=');
        sb.append(((this.productId == null)?"<null>":this.productId));
        sb.append(',');
        sb.append("eventReasonCd");
        sb.append('=');
        sb.append(((this.eventReasonCd == null)?"<null>":this.eventReasonCd));
        sb.append(',');
        sb.append("party");
        sb.append('=');
        sb.append(((this.party == null)?"<null>":this.party));
        sb.append(',');
        sb.append("originatingUserId");
        sb.append('=');
        sb.append(((this.originatingUserId == null)?"<null>":this.originatingUserId));
        sb.append(',');
        sb.append("originatingUserFunctionCd");
        sb.append('=');
        sb.append(((this.originatingUserFunctionCd == null)?"<null>":this.originatingUserFunctionCd));
        sb.append(',');
        sb.append("solicitationChannelTypeCd");
        sb.append('=');
        sb.append(((this.solicitationChannelTypeCd == null)?"<null>":this.solicitationChannelTypeCd));
        sb.append(',');
        sb.append("accessChannelTypeCd");
        sb.append('=');
        sb.append(((this.accessChannelTypeCd == null)?"<null>":this.accessChannelTypeCd));
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
        result = ((result* 31)+((this.originatingUserId == null)? 0 :this.originatingUserId.hashCode()));
        result = ((result* 31)+((this.accessChannelTypeCd == null)? 0 :this.accessChannelTypeCd.hashCode()));
        result = ((result* 31)+((this.productId == null)? 0 :this.productId.hashCode()));
        result = ((result* 31)+((this.agreementAltkey == null)? 0 :this.agreementAltkey.hashCode()));
        result = ((result* 31)+((this.originatingUserFunctionCd == null)? 0 :this.originatingUserFunctionCd.hashCode()));
        result = ((result* 31)+((this.solicitationChannelTypeCd == null)? 0 :this.solicitationChannelTypeCd.hashCode()));
        result = ((result* 31)+((this.eventReasonCd == null)? 0 :this.eventReasonCd.hashCode()));
        result = ((result* 31)+((this.party == null)? 0 :this.party.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TCCAEVAPIProductChangeEventAddInfo) == false) {
            return false;
        }
        TCCAEVAPIProductChangeEventAddInfo rhs = ((TCCAEVAPIProductChangeEventAddInfo) other);
        return (((((((((this.originatingUserId == rhs.originatingUserId)||((this.originatingUserId!= null)&&this.originatingUserId.equals(rhs.originatingUserId)))&&((this.accessChannelTypeCd == rhs.accessChannelTypeCd)||((this.accessChannelTypeCd!= null)&&this.accessChannelTypeCd.equals(rhs.accessChannelTypeCd))))&&((this.productId == rhs.productId)||((this.productId!= null)&&this.productId.equals(rhs.productId))))&&((this.agreementAltkey == rhs.agreementAltkey)||((this.agreementAltkey!= null)&&this.agreementAltkey.equals(rhs.agreementAltkey))))&&((this.originatingUserFunctionCd == rhs.originatingUserFunctionCd)||((this.originatingUserFunctionCd!= null)&&this.originatingUserFunctionCd.equals(rhs.originatingUserFunctionCd))))&&((this.solicitationChannelTypeCd == rhs.solicitationChannelTypeCd)||((this.solicitationChannelTypeCd!= null)&&this.solicitationChannelTypeCd.equals(rhs.solicitationChannelTypeCd))))&&((this.eventReasonCd == rhs.eventReasonCd)||((this.eventReasonCd!= null)&&this.eventReasonCd.equals(rhs.eventReasonCd))))&&((this.party == rhs.party)||((this.party!= null)&&this.party.equals(rhs.party))));
    }

}
