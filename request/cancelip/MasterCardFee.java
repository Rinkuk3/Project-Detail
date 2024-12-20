package com.td.api.mbcca.request.cancelip;

public class MasterCardFee {

    private String reasonCd;
    private String functionCd;
    private String cardSequenceNum;

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(MasterCardFee.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
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
        result = ((result* 31)+((this.functionCd == null)? 0 :this.functionCd.hashCode()));
        result = ((result* 31)+((this.cardSequenceNum == null)? 0 :this.cardSequenceNum.hashCode()));
        result = ((result* 31)+((this.reasonCd == null)? 0 :this.reasonCd.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof MasterCardFee) == false) {
            return false;
        }
        MasterCardFee rhs = ((MasterCardFee) other);
        return ((((this.functionCd == rhs.functionCd)||((this.functionCd!= null)&&this.functionCd.equals(rhs.functionCd)))&&((this.cardSequenceNum == rhs.cardSequenceNum)||((this.cardSequenceNum!= null)&&this.cardSequenceNum.equals(rhs.cardSequenceNum))))&&((this.reasonCd == rhs.reasonCd)||((this.reasonCd!= null)&&this.reasonCd.equals(rhs.reasonCd))));
    }

}
