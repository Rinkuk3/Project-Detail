package com.td.api.mbcca.response.account;

public class AgreementToParty {

    private String partyKey;
    private String roleCd;
    private String roleStatusCd;
    private String partyIdentificationNum;

    public String getPartyKey() {
        return partyKey;
    }

    public void setPartyKey(String partyKey) {
        this.partyKey = partyKey;
    }

    public String getRoleCd() {
        return roleCd;
    }

    public void setRoleCd(String roleCd) {
        this.roleCd = roleCd;
    }

    public String getRoleStatusCd() {
        return roleStatusCd;
    }

    public void setRoleStatusCd(String roleStatusCd) {
        this.roleStatusCd = roleStatusCd;
    }

    public String getPartyIdentificationNum() {
        return partyIdentificationNum;
    }

    public void setPartyIdentificationNum(String partyIdentificationNum) {
        this.partyIdentificationNum = partyIdentificationNum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AgreementToParty.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("partyKey");
        sb.append('=');
        sb.append(((this.partyKey == null)?"<null>":this.partyKey));
        sb.append(',');
        sb.append("roleCd");
        sb.append('=');
        sb.append(((this.roleCd == null)?"<null>":this.roleCd));
        sb.append(',');
        sb.append("roleStatusCd");
        sb.append('=');
        sb.append(((this.roleStatusCd == null)?"<null>":this.roleStatusCd));
        sb.append(',');
        sb.append("partyIdentificationNum");
        sb.append('=');
        sb.append(((this.partyIdentificationNum == null)?"<null>":this.partyIdentificationNum));
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
        result = ((result* 31)+((this.partyIdentificationNum == null)? 0 :this.partyIdentificationNum.hashCode()));
        result = ((result* 31)+((this.partyKey == null)? 0 :this.partyKey.hashCode()));
        result = ((result* 31)+((this.roleStatusCd == null)? 0 :this.roleStatusCd.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AgreementToParty) == false) {
            return false;
        }
        AgreementToParty rhs = ((AgreementToParty) other);
        return (((((this.roleCd == rhs.roleCd)||((this.roleCd!= null)&&this.roleCd.equals(rhs.roleCd)))&&((this.partyIdentificationNum == rhs.partyIdentificationNum)||((this.partyIdentificationNum!= null)&&this.partyIdentificationNum.equals(rhs.partyIdentificationNum))))&&((this.partyKey == rhs.partyKey)||((this.partyKey!= null)&&this.partyKey.equals(rhs.partyKey))))&&((this.roleStatusCd == rhs.roleStatusCd)||((this.roleStatusCd!= null)&&this.roleStatusCd.equals(rhs.roleStatusCd))));
    }

}
