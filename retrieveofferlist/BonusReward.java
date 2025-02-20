package com.td.api.mbofp.response.retrieveofferlist;

import java.math.BigDecimal;

public class BonusReward {

    private String bonusRewardId;
    private String bonusRewardDesc;
    private BigDecimal rewardAmt;
    private String currencyCd;
    private String activateConditionCd;

    public String getBonusRewardId() {
        return bonusRewardId;
    }

    public void setBonusRewardId(String bonusRewardId) {
        this.bonusRewardId = bonusRewardId;
    }

    public String getBonusRewardDesc() {
        return bonusRewardDesc;
    }

    public void setBonusRewardDesc(String bonusRewardDesc) {
        this.bonusRewardDesc = bonusRewardDesc;
    }

    public BigDecimal getRewardAmt() {
        return rewardAmt;
    }

    public void setRewardAmt(BigDecimal rewardAmt) {
        this.rewardAmt = rewardAmt;
    }

    public String getCurrencyCd() {
        return currencyCd;
    }

    public void setCurrencyCd(String currencyCd) {
        this.currencyCd = currencyCd;
    }

    public String getActivateConditionCd() {
        return activateConditionCd;
    }

    public void setActivateConditionCd(String activateConditionCd) {
        this.activateConditionCd = activateConditionCd;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(BonusReward.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("bonusRewardId");
        sb.append('=');
        sb.append(((this.bonusRewardId == null)?"<null>":this.bonusRewardId));
        sb.append(',');
        sb.append("bonusRewardDesc");
        sb.append('=');
        sb.append(((this.bonusRewardDesc == null)?"<null>":this.bonusRewardDesc));
        sb.append(',');
        sb.append("rewardAmt");
        sb.append('=');
        sb.append(((this.rewardAmt == null)?"<null>":this.rewardAmt));
        sb.append(',');
        sb.append("currencyCd");
        sb.append('=');
        sb.append(((this.currencyCd == null)?"<null>":this.currencyCd));
        sb.append(',');
        sb.append("activateConditionCd");
        sb.append('=');
        sb.append(((this.activateConditionCd == null)?"<null>":this.activateConditionCd));
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
        result = ((result* 31)+((this.rewardAmt == null)? 0 :this.rewardAmt.hashCode()));
        result = ((result* 31)+((this.currencyCd == null)? 0 :this.currencyCd.hashCode()));
        result = ((result* 31)+((this.activateConditionCd == null)? 0 :this.activateConditionCd.hashCode()));
        result = ((result* 31)+((this.bonusRewardId == null)? 0 :this.bonusRewardId.hashCode()));
        result = ((result* 31)+((this.bonusRewardDesc == null)? 0 :this.bonusRewardDesc.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof BonusReward) == false) {
            return false;
        }
        BonusReward rhs = ((BonusReward) other);
        return ((((((this.rewardAmt == rhs.rewardAmt)||((this.rewardAmt!= null)&&this.rewardAmt.equals(rhs.rewardAmt)))&&((this.currencyCd == rhs.currencyCd)||((this.currencyCd!= null)&&this.currencyCd.equals(rhs.currencyCd))))&&((this.activateConditionCd == rhs.activateConditionCd)||((this.activateConditionCd!= null)&&this.activateConditionCd.equals(rhs.activateConditionCd))))&&((this.bonusRewardId == rhs.bonusRewardId)||((this.bonusRewardId!= null)&&this.bonusRewardId.equals(rhs.bonusRewardId))))&&((this.bonusRewardDesc == rhs.bonusRewardDesc)||((this.bonusRewardDesc!= null)&&this.bonusRewardDesc.equals(rhs.bonusRewardDesc))));
    }

}
