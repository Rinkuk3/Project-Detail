package com.td.mbna.msec.midtier.pinmanagement.payload.changepin;

public class RequestPayload {

    private String custId;
    private String acctId;
    private String encryptedPinBlock;
    private String singleUseKey;
    private String zpkAlias;
    private String wtkAlias;
    private String cdv;
    private Boolean confirmed;

    private String partyKey;

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getAcctId() {
        return acctId;
    }

    public void setAcctId(String acctId) {
        this.acctId = acctId;
    }

    public String getEncryptedPinBlock() {
        return encryptedPinBlock;
    }

    public void setEncryptedPinBlock(String encryptedPinBlock) {
        this.encryptedPinBlock = encryptedPinBlock;
    }

    public String getSingleUseKey() {
        return singleUseKey;
    }

    public void setSingleUseKey(String singleUseKey) {
        this.singleUseKey = singleUseKey;
    }

    public String getZpkAlias() {
        return zpkAlias;
    }

    public void setZpkAlias(String zpkAlias) {
        this.zpkAlias = zpkAlias;
    }

    public String getWtkAlias() {
        return wtkAlias;
    }

    public void setWtkAlias(String wtkAlias) {
        this.wtkAlias = wtkAlias;
    }

    public String getCdv() {
        return cdv;
    }

    public void setCdv(String cdv) {
        this.cdv = cdv;
    }

    public Boolean getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Boolean confirmed) {
        this.confirmed = confirmed;
    }

    public String getPartyKey() {
        return partyKey;
    }

    public void setPartyKey(String partyKey) {
        this.partyKey = partyKey;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(RequestPayload.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("custId");
        sb.append('=');
        sb.append(((this.custId == null)?"<null>":this.custId));
        sb.append(',');
        sb.append("acctId");
        sb.append('=');
        sb.append(((this.acctId == null)?"<null>":this.acctId));
        sb.append(',');
        sb.append("encryptedPinBlock");
        sb.append('=');
        sb.append(((this.encryptedPinBlock == null)?"<null>":this.encryptedPinBlock));
        sb.append(',');
        sb.append("singleUseKey");
        sb.append('=');
        sb.append(((this.singleUseKey == null)?"<null>":this.singleUseKey));
        sb.append(',');
        sb.append("zpkAlias");
        sb.append('=');
        sb.append(((this.zpkAlias == null)?"<null>":this.zpkAlias));
        sb.append(',');
        sb.append("wtkAlias");
        sb.append('=');
        sb.append(((this.wtkAlias == null)?"<null>":this.wtkAlias));
        sb.append(',');
        sb.append("cdv");
        sb.append('=');
        sb.append(((this.cdv == null)?"<null>":this.cdv));
        sb.append(',');
        sb.append("confirmed");
        sb.append('=');
        sb.append(((this.confirmed == null)?"<null>":this.confirmed));
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
        result = ((result* 31)+((this.cdv == null)? 0 :this.cdv.hashCode()));
        result = ((result* 31)+((this.singleUseKey == null)? 0 :this.singleUseKey.hashCode()));
        result = ((result* 31)+((this.custId == null)? 0 :this.custId.hashCode()));
        result = ((result* 31)+((this.acctId == null)? 0 :this.acctId.hashCode()));
        result = ((result* 31)+((this.wtkAlias == null)? 0 :this.wtkAlias.hashCode()));
        result = ((result* 31)+((this.zpkAlias == null)? 0 :this.zpkAlias.hashCode()));
        result = ((result* 31)+((this.confirmed == null)? 0 :this.confirmed.hashCode()));
        result = ((result* 31)+((this.encryptedPinBlock == null)? 0 :this.encryptedPinBlock.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RequestPayload) == false) {
            return false;
        }
        RequestPayload rhs = ((RequestPayload) other);
        return (((((((((this.cdv == rhs.cdv)||((this.cdv!= null)&&this.cdv.equals(rhs.cdv)))&&((this.singleUseKey == rhs.singleUseKey)||((this.singleUseKey!= null)&&this.singleUseKey.equals(rhs.singleUseKey))))&&((this.custId == rhs.custId)||((this.custId!= null)&&this.custId.equals(rhs.custId))))&&((this.acctId == rhs.acctId)||((this.acctId!= null)&&this.acctId.equals(rhs.acctId))))&&((this.wtkAlias == rhs.wtkAlias)||((this.wtkAlias!= null)&&this.wtkAlias.equals(rhs.wtkAlias))))&&((this.zpkAlias == rhs.zpkAlias)||((this.zpkAlias!= null)&&this.zpkAlias.equals(rhs.zpkAlias))))&&((this.confirmed == rhs.confirmed)||((this.confirmed!= null)&&this.confirmed.equals(rhs.confirmed))))&&((this.encryptedPinBlock == rhs.encryptedPinBlock)||((this.encryptedPinBlock!= null)&&this.encryptedPinBlock.equals(rhs.encryptedPinBlock))));
    }

}
