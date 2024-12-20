package com.td.mbna.msec.midtier.mbnaad.request.response;

public class ChipCard {

    private String partyKey;
    private String sequenceNum;
    private String featureClassificationCd;
    private String featureDesc;
    private String expirationDt;
    private Boolean blockedInd;
    private Boolean outstandingScriptInd;

    public String getPartyKey() {
        return partyKey;
    }

    public void setPartyKey(String partyKey) {
        this.partyKey = partyKey;
    }

    public String getSequenceNum() {
        return sequenceNum;
    }

    public void setSequenceNum(String sequenceNum) {
        this.sequenceNum = sequenceNum;
    }

    public String getFeatureClassificationCd() {
        return featureClassificationCd;
    }

    public void setFeatureClassificationCd(String featureClassificationCd) {
        this.featureClassificationCd = featureClassificationCd;
    }

    public String getFeatureDesc() {
        return featureDesc;
    }

    public void setFeatureDesc(String featureDesc) {
        this.featureDesc = featureDesc;
    }

    public String getExpirationDt() {
        return expirationDt;
    }

    public void setExpirationDt(String expirationDt) {
        this.expirationDt = expirationDt;
    }

    public Boolean getBlockedInd() {
        return blockedInd;
    }

    public void setBlockedInd(Boolean blockedInd) {
        this.blockedInd = blockedInd;
    }

    public Boolean getOutstandingScriptInd() {
        return outstandingScriptInd;
    }

    public void setOutstandingScriptInd(Boolean outstandingScriptInd) {
        this.outstandingScriptInd = outstandingScriptInd;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ChipCard.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("partyKey");
        sb.append('=');
        sb.append(((this.partyKey == null)?"<null>":this.partyKey));
        sb.append(',');
        sb.append("sequenceNum");
        sb.append('=');
        sb.append(((this.sequenceNum == null)?"<null>":this.sequenceNum));
        sb.append(',');
        sb.append("featureClassificationCd");
        sb.append('=');
        sb.append(((this.featureClassificationCd == null)?"<null>":this.featureClassificationCd));
        sb.append(',');
        sb.append("featureDesc");
        sb.append('=');
        sb.append(((this.featureDesc == null)?"<null>":this.featureDesc));
        sb.append(',');
        sb.append("expirationDt");
        sb.append('=');
        sb.append(((this.expirationDt == null)?"<null>":this.expirationDt));
        sb.append(',');
        sb.append("blockedInd");
        sb.append('=');
        sb.append(((this.blockedInd == null)?"<null>":this.blockedInd));
        sb.append(',');
        sb.append("outstandingScriptInd");
        sb.append('=');
        sb.append(((this.outstandingScriptInd == null)?"<null>":this.outstandingScriptInd));
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
        result = ((result* 31)+((this.expirationDt == null)? 0 :this.expirationDt.hashCode()));
        result = ((result* 31)+((this.sequenceNum == null)? 0 :this.sequenceNum.hashCode()));
        result = ((result* 31)+((this.featureClassificationCd == null)? 0 :this.featureClassificationCd.hashCode()));
        result = ((result* 31)+((this.featureDesc == null)? 0 :this.featureDesc.hashCode()));
        result = ((result* 31)+((this.blockedInd == null)? 0 :this.blockedInd.hashCode()));
        result = ((result* 31)+((this.partyKey == null)? 0 :this.partyKey.hashCode()));
        result = ((result* 31)+((this.outstandingScriptInd == null)? 0 :this.outstandingScriptInd.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ChipCard) == false) {
            return false;
        }
        ChipCard rhs = ((ChipCard) other);
        return ((((((((this.expirationDt == rhs.expirationDt)||((this.expirationDt!= null)&&this.expirationDt.equals(rhs.expirationDt)))&&((this.sequenceNum == rhs.sequenceNum)||((this.sequenceNum!= null)&&this.sequenceNum.equals(rhs.sequenceNum))))&&((this.featureClassificationCd == rhs.featureClassificationCd)||((this.featureClassificationCd!= null)&&this.featureClassificationCd.equals(rhs.featureClassificationCd))))&&((this.featureDesc == rhs.featureDesc)||((this.featureDesc!= null)&&this.featureDesc.equals(rhs.featureDesc))))&&((this.blockedInd == rhs.blockedInd)||((this.blockedInd!= null)&&this.blockedInd.equals(rhs.blockedInd))))&&((this.partyKey == rhs.partyKey)||((this.partyKey!= null)&&this.partyKey.equals(rhs.partyKey))))&&((this.outstandingScriptInd == rhs.outstandingScriptInd)||((this.outstandingScriptInd!= null)&&this.outstandingScriptInd.equals(rhs.outstandingScriptInd))));
    }

}
