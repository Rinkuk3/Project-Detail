package com.td.api.mbcca.response.account;

import com.td.api.mbcca.shared.Cccyamt;

public class CategoryInfo {

    private String reassignedCategoryCd;
    private String newCategoryCd;
    private String newTermBalanceCd;
    private String expiryDt;
    private Boolean cptExpiredInd;
    private String originalCategoryCd;
    private Cccyamt cptExpirationRemainingBalanceCccyamt;

    public String getReassignedCategoryCd() {
        return reassignedCategoryCd;
    }

    public void setReassignedCategoryCd(String reassignedCategoryCd) {
        this.reassignedCategoryCd = reassignedCategoryCd;
    }

    public String getNewCategoryCd() {
        return newCategoryCd;
    }

    public void setNewCategoryCd(String newCategoryCd) {
        this.newCategoryCd = newCategoryCd;
    }

    public String getNewTermBalanceCd() {
        return newTermBalanceCd;
    }

    public void setNewTermBalanceCd(String newTermBalanceCd) {
        this.newTermBalanceCd = newTermBalanceCd;
    }

    public String getExpiryDt() {
        return expiryDt;
    }

    public void setExpiryDt(String expiryDt) {
        this.expiryDt = expiryDt;
    }

    public Boolean getCptExpiredInd() {
        return cptExpiredInd;
    }

    public void setCptExpiredInd(Boolean cptExpiredInd) {
        this.cptExpiredInd = cptExpiredInd;
    }

    public String getOriginalCategoryCd() {
        return originalCategoryCd;
    }

    public void setOriginalCategoryCd(String originalCategoryCd) {
        this.originalCategoryCd = originalCategoryCd;
    }

    public Cccyamt getCptExpirationRemainingBalanceCccyamt() {
        return cptExpirationRemainingBalanceCccyamt;
    }

    public void setCptExpirationRemainingBalanceCccyamt(Cccyamt cptExpirationRemainingBalanceCccyamt) {
        this.cptExpirationRemainingBalanceCccyamt = cptExpirationRemainingBalanceCccyamt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CategoryInfo.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("reassignedCategoryCd");
        sb.append('=');
        sb.append(((this.reassignedCategoryCd == null)?"<null>":this.reassignedCategoryCd));
        sb.append(',');
        sb.append("newCategoryCd");
        sb.append('=');
        sb.append(((this.newCategoryCd == null)?"<null>":this.newCategoryCd));
        sb.append(',');
        sb.append("newTermBalanceCd");
        sb.append('=');
        sb.append(((this.newTermBalanceCd == null)?"<null>":this.newTermBalanceCd));
        sb.append(',');
        sb.append("expiryDt");
        sb.append('=');
        sb.append(((this.expiryDt == null)?"<null>":this.expiryDt));
        sb.append(',');
        sb.append("cptExpiredInd");
        sb.append('=');
        sb.append(((this.cptExpiredInd == null)?"<null>":this.cptExpiredInd));
        sb.append(',');
        sb.append("originalCategoryCd");
        sb.append('=');
        sb.append(((this.originalCategoryCd == null)?"<null>":this.originalCategoryCd));
        sb.append(',');
        sb.append("cptExpirationRemainingBalanceCccyamt");
        sb.append('=');
        sb.append(((this.cptExpirationRemainingBalanceCccyamt == null)?"<null>":this.cptExpirationRemainingBalanceCccyamt));
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
        result = ((result* 31)+((this.reassignedCategoryCd == null)? 0 :this.reassignedCategoryCd.hashCode()));
        result = ((result* 31)+((this.newTermBalanceCd == null)? 0 :this.newTermBalanceCd.hashCode()));
        result = ((result* 31)+((this.newCategoryCd == null)? 0 :this.newCategoryCd.hashCode()));
        result = ((result* 31)+((this.originalCategoryCd == null)? 0 :this.originalCategoryCd.hashCode()));
        result = ((result* 31)+((this.cptExpirationRemainingBalanceCccyamt == null)? 0 :this.cptExpirationRemainingBalanceCccyamt.hashCode()));
        result = ((result* 31)+((this.expiryDt == null)? 0 :this.expiryDt.hashCode()));
        result = ((result* 31)+((this.cptExpiredInd == null)? 0 :this.cptExpiredInd.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CategoryInfo) == false) {
            return false;
        }
        CategoryInfo rhs = ((CategoryInfo) other);
        return ((((((((this.reassignedCategoryCd == rhs.reassignedCategoryCd)||((this.reassignedCategoryCd!= null)&&this.reassignedCategoryCd.equals(rhs.reassignedCategoryCd)))&&((this.newTermBalanceCd == rhs.newTermBalanceCd)||((this.newTermBalanceCd!= null)&&this.newTermBalanceCd.equals(rhs.newTermBalanceCd))))&&((this.newCategoryCd == rhs.newCategoryCd)||((this.newCategoryCd!= null)&&this.newCategoryCd.equals(rhs.newCategoryCd))))&&((this.originalCategoryCd == rhs.originalCategoryCd)||((this.originalCategoryCd!= null)&&this.originalCategoryCd.equals(rhs.originalCategoryCd))))&&((this.cptExpirationRemainingBalanceCccyamt == rhs.cptExpirationRemainingBalanceCccyamt)||((this.cptExpirationRemainingBalanceCccyamt!= null)&&this.cptExpirationRemainingBalanceCccyamt.equals(rhs.cptExpirationRemainingBalanceCccyamt))))&&((this.expiryDt == rhs.expiryDt)||((this.expiryDt!= null)&&this.expiryDt.equals(rhs.expiryDt))))&&((this.cptExpiredInd == rhs.cptExpiredInd)||((this.cptExpiredInd!= null)&&this.cptExpiredInd.equals(rhs.cptExpiredInd))));
    }

}
