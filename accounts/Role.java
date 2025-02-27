package com.td.api.mbcca.response.account;

import java.math.BigDecimal;

public class Role {

    /**
     * A canonical code which defines the various roles that parties have with the agreement such as

     * primary obligor, secondary obligor, co-signer, account holder, beneficiary, trustees, etc.

     * This role code may be used to identify which roles can have access to balance information.

     * Valid values:

     * PRIM - Primary card holder,

     * AUTH - Authorized user,

     * CONT - Contact,

     * LPOA - Limited power of attorney,

     * COAP - Coapplicant,

     * BUS - Business,

     * GUAR - Guarantor,

     * PERP - Perpetrator,

     * DUAL - Dual
     * (Required)
     * 
     */
    private String roleCd;
    private String startDt;
    private String endDt;
    BigDecimal amt;
    BigDecimal pct;
    private String statusCd;

    public String getRoleCd() {
        return roleCd;
    }

    public void setRoleCd(String roleCd) {
        this.roleCd = roleCd;
    }

    public String getStartDt() {
        return startDt;
    }

    public void setStartDt(String startDt) {
        this.startDt = startDt;
    }

    public String getEndDt() {
        return endDt;
    }

    public void setEndDt(String endDt) {
        this.endDt = endDt;
    }

    public BigDecimal getAmt() {
        return amt;
    }

    public void setAmt(BigDecimal amt) {
        this.amt = amt;
    }

    public BigDecimal getPct() {
        return pct;
    }

    public void setPct(BigDecimal pct) {
        this.pct = pct;
    }

    public String getStatusCd() {
        return statusCd;
    }

    public void setStatusCd(String statusCd) {
        this.statusCd = statusCd;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Role.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("roleCd");
        sb.append('=');
        sb.append(((this.roleCd == null)?"<null>":this.roleCd));
        sb.append(',');
        sb.append("startDt");
        sb.append('=');
        sb.append(((this.startDt == null)?"<null>":this.startDt));
        sb.append(',');
        sb.append("endDt");
        sb.append('=');
        sb.append(((this.endDt == null)?"<null>":this.endDt));
        sb.append(',');
        sb.append("amt");
        sb.append('=');
        sb.append(((this.amt == null)?"<null>":this.amt));
        sb.append(',');
        sb.append("pct");
        sb.append('=');
        sb.append(((this.pct == null)?"<null>":this.pct));
        sb.append(',');
        sb.append("statusCd");
        sb.append('=');
        sb.append(((this.statusCd == null)?"<null>":this.statusCd));
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
        result = ((result* 31)+((this.roleCd == null)? 0 :this.roleCd.hashCode()));
        result = ((result* 31)+((this.pct == null)? 0 :this.pct.hashCode()));
        result = ((result* 31)+((this.startDt == null)? 0 :this.startDt.hashCode()));
        result = ((result* 31)+((this.endDt == null)? 0 :this.endDt.hashCode()));
        result = ((result* 31)+((this.amt == null)? 0 :this.amt.hashCode()));
        result = ((result* 31)+((this.statusCd == null)? 0 :this.statusCd.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Role) == false) {
            return false;
        }
        Role rhs = ((Role) other);
        return (((((((this.roleCd == rhs.roleCd)||((this.roleCd!= null)&&this.roleCd.equals(rhs.roleCd)))&&((this.pct == rhs.pct)||((this.pct!= null)&&this.pct.equals(rhs.pct))))&&((this.startDt == rhs.startDt)||((this.startDt!= null)&&this.startDt.equals(rhs.startDt))))&&((this.endDt == rhs.endDt)||((this.endDt!= null)&&this.endDt.equals(rhs.endDt))))&&((this.amt == rhs.amt)||((this.amt!= null)&&this.amt.equals(rhs.amt))))&&((this.statusCd == rhs.statusCd)||((this.statusCd!= null)&&this.statusCd.equals(rhs.statusCd))));
    }

}
