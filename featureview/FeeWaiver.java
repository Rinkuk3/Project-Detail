package com.td.api.mbcca.response.account.featureview;

public class FeeWaiver {

    private AnnualFee annualFee;
    private LateFee lateFee;
    private OverLimitFee overLimitFee;
    private FinanceChargeFee financeChargeFee;
    private ForeignExchangeFee foreignExchangeFee;

    public AnnualFee getAnnualFee() {
        return annualFee;
    }

    public void setAnnualFee(AnnualFee annualFee) {
        this.annualFee = annualFee;
    }

    public LateFee getLateFee() {
        return lateFee;
    }

    public void setLateFee(LateFee lateFee) {
        this.lateFee = lateFee;
    }

    public OverLimitFee getOverLimitFee() {
        return overLimitFee;
    }

    public void setOverLimitFee(OverLimitFee overLimitFee) {
        this.overLimitFee = overLimitFee;
    }

    public FinanceChargeFee getFinanceChargeFee() {
        return financeChargeFee;
    }

    public void setFinanceChargeFee(FinanceChargeFee financeChargeFee) {
        this.financeChargeFee = financeChargeFee;
    }

    public ForeignExchangeFee getForeignExchangeFee() {
        return foreignExchangeFee;
    }

    public void setForeignExchangeFee(ForeignExchangeFee foreignExchangeFee) {
        this.foreignExchangeFee = foreignExchangeFee;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(FeeWaiver.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("annualFee");
        sb.append('=');
        sb.append(((this.annualFee == null)?"<null>":this.annualFee));
        sb.append(',');
        sb.append("lateFee");
        sb.append('=');
        sb.append(((this.lateFee == null)?"<null>":this.lateFee));
        sb.append(',');
        sb.append("overLimitFee");
        sb.append('=');
        sb.append(((this.overLimitFee == null)?"<null>":this.overLimitFee));
        sb.append(',');
        sb.append("financeChargeFee");
        sb.append('=');
        sb.append(((this.financeChargeFee == null)?"<null>":this.financeChargeFee));
        sb.append(',');
        sb.append("foreignExchangeFee");
        sb.append('=');
        sb.append(((this.foreignExchangeFee == null)?"<null>":this.foreignExchangeFee));
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
        result = ((result* 31)+((this.lateFee == null)? 0 :this.lateFee.hashCode()));
        result = ((result* 31)+((this.foreignExchangeFee == null)? 0 :this.foreignExchangeFee.hashCode()));
        result = ((result* 31)+((this.financeChargeFee == null)? 0 :this.financeChargeFee.hashCode()));
        result = ((result* 31)+((this.annualFee == null)? 0 :this.annualFee.hashCode()));
        result = ((result* 31)+((this.overLimitFee == null)? 0 :this.overLimitFee.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof FeeWaiver) == false) {
            return false;
        }
        FeeWaiver rhs = ((FeeWaiver) other);
        return ((((((this.lateFee == rhs.lateFee)||((this.lateFee!= null)&&this.lateFee.equals(rhs.lateFee)))&&((this.foreignExchangeFee == rhs.foreignExchangeFee)||((this.foreignExchangeFee!= null)&&this.foreignExchangeFee.equals(rhs.foreignExchangeFee))))&&((this.financeChargeFee == rhs.financeChargeFee)||((this.financeChargeFee!= null)&&this.financeChargeFee.equals(rhs.financeChargeFee))))&&((this.annualFee == rhs.annualFee)||((this.annualFee!= null)&&this.annualFee.equals(rhs.annualFee))))&&((this.overLimitFee == rhs.overLimitFee)||((this.overLimitFee!= null)&&this.overLimitFee.equals(rhs.overLimitFee))));
    }

}
