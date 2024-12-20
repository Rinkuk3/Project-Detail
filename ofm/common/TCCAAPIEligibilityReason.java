package com.td.api.ofm.common;

public class TCCAAPIEligibilityReason {

    private String reasonCd;
    private String reasonValueCd;
    private String reasonValueDesc;

    public String getReasonCd() {
        return reasonCd;
    }

    public void setReasonCd(String reasonCd) {
        this.reasonCd = reasonCd;
    }

    public String getReasonValueCd() {
        return reasonValueCd;
    }

    public void setReasonValueCd(String reasonValueCd) {
        this.reasonValueCd = reasonValueCd;
    }

    public String getReasonValueDesc() {
        return reasonValueDesc;
    }

    public void setReasonValueDesc(String reasonValueDesc) {
        this.reasonValueDesc = reasonValueDesc;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TCCAAPIEligibilityReason.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("reasonCd");
        sb.append('=');
        sb.append(((this.reasonCd == null)?"<null>":this.reasonCd));
        sb.append(',');
        sb.append("reasonValueCd");
        sb.append('=');
        sb.append(((this.reasonValueCd == null)?"<null>":this.reasonValueCd));
        sb.append(',');
        sb.append("reasonValueDesc");
        sb.append('=');
        sb.append(((this.reasonValueDesc == null)?"<null>":this.reasonValueDesc));
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
        result = ((result* 31)+((this.reasonValueDesc == null)? 0 :this.reasonValueDesc.hashCode()));
        result = ((result* 31)+((this.reasonValueCd == null)? 0 :this.reasonValueCd.hashCode()));
        result = ((result* 31)+((this.reasonCd == null)? 0 :this.reasonCd.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TCCAAPIEligibilityReason) == false) {
            return false;
        }
        TCCAAPIEligibilityReason rhs = ((TCCAAPIEligibilityReason) other);
        return ((((this.reasonValueDesc == rhs.reasonValueDesc)||((this.reasonValueDesc!= null)&&this.reasonValueDesc.equals(rhs.reasonValueDesc)))&&((this.reasonValueCd == rhs.reasonValueCd)||((this.reasonValueCd!= null)&&this.reasonValueCd.equals(rhs.reasonValueCd))))&&((this.reasonCd == rhs.reasonCd)||((this.reasonCd!= null)&&this.reasonCd.equals(rhs.reasonCd))));
    }

}
