package com.td.api.mbofp.response.retrieveofferlist;

public class TowTerm {

    private String untilAgeCd;
    private String untilAgeNum;
    private String fixedEndDt;
    private String openingExpiryDt;
    private String calculationTypeCd;

    public String getUntilAgeCd() {
        return untilAgeCd;
    }

    public void setUntilAgeCd(String untilAgeCd) {
        this.untilAgeCd = untilAgeCd;
    }

    public String getUntilAgeNum() {
        return untilAgeNum;
    }

    public void setUntilAgeNum(String untilAgeNum) {
        this.untilAgeNum = untilAgeNum;
    }

    public String getFixedEndDt() {
        return fixedEndDt;
    }

    public void setFixedEndDt(String fixedEndDt) {
        this.fixedEndDt = fixedEndDt;
    }

    public String getOpeningExpiryDt() {
        return openingExpiryDt;
    }

    public void setOpeningExpiryDt(String openingExpiryDt) {
        this.openingExpiryDt = openingExpiryDt;
    }

    public String getCalculationTypeCd() {
        return calculationTypeCd;
    }

    public void setCalculationTypeCd(String calculationTypeCd) {
        this.calculationTypeCd = calculationTypeCd;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TowTerm.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("untilAgeCd");
        sb.append('=');
        sb.append(((this.untilAgeCd == null)?"<null>":this.untilAgeCd));
        sb.append(',');
        sb.append("untilAgeNum");
        sb.append('=');
        sb.append(((this.untilAgeNum == null)?"<null>":this.untilAgeNum));
        sb.append(',');
        sb.append("fixedEndDt");
        sb.append('=');
        sb.append(((this.fixedEndDt == null)?"<null>":this.fixedEndDt));
        sb.append(',');
        sb.append("openingExpiryDt");
        sb.append('=');
        sb.append(((this.openingExpiryDt == null)?"<null>":this.openingExpiryDt));
        sb.append(',');
        sb.append("calculationTypeCd");
        sb.append('=');
        sb.append(((this.calculationTypeCd == null)?"<null>":this.calculationTypeCd));
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
        result = ((result* 31)+((this.calculationTypeCd == null)? 0 :this.calculationTypeCd.hashCode()));
        result = ((result* 31)+((this.untilAgeCd == null)? 0 :this.untilAgeCd.hashCode()));
        result = ((result* 31)+((this.fixedEndDt == null)? 0 :this.fixedEndDt.hashCode()));
        result = ((result* 31)+((this.openingExpiryDt == null)? 0 :this.openingExpiryDt.hashCode()));
        result = ((result* 31)+((this.untilAgeNum == null)? 0 :this.untilAgeNum.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TowTerm) == false) {
            return false;
        }
        TowTerm rhs = ((TowTerm) other);
        return ((((((this.calculationTypeCd == rhs.calculationTypeCd)||((this.calculationTypeCd!= null)&&this.calculationTypeCd.equals(rhs.calculationTypeCd)))&&((this.untilAgeCd == rhs.untilAgeCd)||((this.untilAgeCd!= null)&&this.untilAgeCd.equals(rhs.untilAgeCd))))&&((this.fixedEndDt == rhs.fixedEndDt)||((this.fixedEndDt!= null)&&this.fixedEndDt.equals(rhs.fixedEndDt))))&&((this.openingExpiryDt == rhs.openingExpiryDt)||((this.openingExpiryDt!= null)&&this.openingExpiryDt.equals(rhs.openingExpiryDt))))&&((this.untilAgeNum == rhs.untilAgeNum)||((this.untilAgeNum!= null)&&this.untilAgeNum.equals(rhs.untilAgeNum))));
    }

}
