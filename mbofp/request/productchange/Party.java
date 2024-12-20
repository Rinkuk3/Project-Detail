package com.td.api.mbofp.request.productchange;

public class Party {

    private String languageTypeCd;
    private String identificationMembershipNum;

    public String getLanguageTypeCd() {
        return languageTypeCd;
    }

    public void setLanguageTypeCd(String languageTypeCd) {
        this.languageTypeCd = languageTypeCd;
    }

    public String getIdentificationMembershipNum() {
        return identificationMembershipNum;
    }

    public void setIdentificationMembershipNum(String identificationMembershipNum) {
        this.identificationMembershipNum = identificationMembershipNum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Party.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("languageTypeCd");
        sb.append('=');
        sb.append(((this.languageTypeCd == null)?"<null>":this.languageTypeCd));
        sb.append(',');
        sb.append("identificationMembershipNum");
        sb.append('=');
        sb.append(((this.identificationMembershipNum == null)?"<null>":this.identificationMembershipNum));
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
        result = ((result* 31)+((this.languageTypeCd == null)? 0 :this.languageTypeCd.hashCode()));
        result = ((result* 31)+((this.identificationMembershipNum == null)? 0 :this.identificationMembershipNum.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Party) == false) {
            return false;
        }
        Party rhs = ((Party) other);
        return (((this.languageTypeCd == rhs.languageTypeCd)||((this.languageTypeCd!= null)&&this.languageTypeCd.equals(rhs.languageTypeCd)))&&((this.identificationMembershipNum == rhs.identificationMembershipNum)||((this.identificationMembershipNum!= null)&&this.identificationMembershipNum.equals(rhs.identificationMembershipNum))));
    }

}
