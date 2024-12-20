package com.td.api.mbcca.request.cancelip;

public class TsysExtension {

    private VisaChargeBack visaChargeBack;
    private VisaFee visaFee;
    private MasterCardFee masterCardFee;
    private MasterCardChargeBack masterCardChargeBack;

    public VisaChargeBack getVisaChargeBack() {
        return visaChargeBack;
    }

    public void setVisaChargeBack(VisaChargeBack visaChargeBack) {
        this.visaChargeBack = visaChargeBack;
    }

    public VisaFee getVisaFee() {
        return visaFee;
    }

    public void setVisaFee(VisaFee visaFee) {
        this.visaFee = visaFee;
    }

    public MasterCardFee getMasterCardFee() {
        return masterCardFee;
    }

    public void setMasterCardFee(MasterCardFee masterCardFee) {
        this.masterCardFee = masterCardFee;
    }

    public MasterCardChargeBack getMasterCardChargeBack() {
        return masterCardChargeBack;
    }

    public void setMasterCardChargeBack(MasterCardChargeBack masterCardChargeBack) {
        this.masterCardChargeBack = masterCardChargeBack;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TsysExtension.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("visaChargeBack");
        sb.append('=');
        sb.append(((this.visaChargeBack == null)?"<null>":this.visaChargeBack));
        sb.append(',');
        sb.append("visaFee");
        sb.append('=');
        sb.append(((this.visaFee == null)?"<null>":this.visaFee));
        sb.append(',');
        sb.append("masterCardFee");
        sb.append('=');
        sb.append(((this.masterCardFee == null)?"<null>":this.masterCardFee));
        sb.append(',');
        sb.append("masterCardChargeBack");
        sb.append('=');
        sb.append(((this.masterCardChargeBack == null)?"<null>":this.masterCardChargeBack));
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
        result = ((result* 31)+((this.visaFee == null)? 0 :this.visaFee.hashCode()));
        result = ((result* 31)+((this.masterCardChargeBack == null)? 0 :this.masterCardChargeBack.hashCode()));
        result = ((result* 31)+((this.visaChargeBack == null)? 0 :this.visaChargeBack.hashCode()));
        result = ((result* 31)+((this.masterCardFee == null)? 0 :this.masterCardFee.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TsysExtension) == false) {
            return false;
        }
        TsysExtension rhs = ((TsysExtension) other);
        return (((((this.visaFee == rhs.visaFee)||((this.visaFee!= null)&&this.visaFee.equals(rhs.visaFee)))&&((this.masterCardChargeBack == rhs.masterCardChargeBack)||((this.masterCardChargeBack!= null)&&this.masterCardChargeBack.equals(rhs.masterCardChargeBack))))&&((this.visaChargeBack == rhs.visaChargeBack)||((this.visaChargeBack!= null)&&this.visaChargeBack.equals(rhs.visaChargeBack))))&&((this.masterCardFee == rhs.masterCardFee)||((this.masterCardFee!= null)&&this.masterCardFee.equals(rhs.masterCardFee))));
    }

}
