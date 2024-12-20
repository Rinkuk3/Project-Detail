package com.td.api.mbcca.response.account.featureview;

public class CardReceiptVerificationNextAnnualFee {

    private String partyRoleCd;
    private String partyId;
    private String partyName;
    private String accountNum;
    private String nextChargeDt;

    public String getPartyRoleCd() {
        return partyRoleCd;
    }

    public void setPartyRoleCd(String partyRoleCd) {
        this.partyRoleCd = partyRoleCd;
    }

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public String getNextChargeDt() {
        return nextChargeDt;
    }

    public void setNextChargeDt(String nextChargeDt) {
        this.nextChargeDt = nextChargeDt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CardReceiptVerificationNextAnnualFee.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("partyRoleCd");
        sb.append('=');
        sb.append(((this.partyRoleCd == null)?"<null>":this.partyRoleCd));
        sb.append(',');
        sb.append("partyId");
        sb.append('=');
        sb.append(((this.partyId == null)?"<null>":this.partyId));
        sb.append(',');
        sb.append("partyName");
        sb.append('=');
        sb.append(((this.partyName == null)?"<null>":this.partyName));
        sb.append(',');
        sb.append("accountNum");
        sb.append('=');
        sb.append(((this.accountNum == null)?"<null>":this.accountNum));
        sb.append(',');
        sb.append("nextChargeDt");
        sb.append('=');
        sb.append(((this.nextChargeDt == null)?"<null>":this.nextChargeDt));
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
        result = ((result* 31)+((this.partyName == null)? 0 :this.partyName.hashCode()));
        result = ((result* 31)+((this.partyId == null)? 0 :this.partyId.hashCode()));
        result = ((result* 31)+((this.accountNum == null)? 0 :this.accountNum.hashCode()));
        result = ((result* 31)+((this.nextChargeDt == null)? 0 :this.nextChargeDt.hashCode()));
        result = ((result* 31)+((this.partyRoleCd == null)? 0 :this.partyRoleCd.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CardReceiptVerificationNextAnnualFee) == false) {
            return false;
        }
        CardReceiptVerificationNextAnnualFee rhs = ((CardReceiptVerificationNextAnnualFee) other);
        return ((((((this.partyName == rhs.partyName)||((this.partyName!= null)&&this.partyName.equals(rhs.partyName)))&&((this.partyId == rhs.partyId)||((this.partyId!= null)&&this.partyId.equals(rhs.partyId))))&&((this.accountNum == rhs.accountNum)||((this.accountNum!= null)&&this.accountNum.equals(rhs.accountNum))))&&((this.nextChargeDt == rhs.nextChargeDt)||((this.nextChargeDt!= null)&&this.nextChargeDt.equals(rhs.nextChargeDt))))&&((this.partyRoleCd == rhs.partyRoleCd)||((this.partyRoleCd!= null)&&this.partyRoleCd.equals(rhs.partyRoleCd))));
    }

}
