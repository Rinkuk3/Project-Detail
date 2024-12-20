package com.td.api.mbofp.response.retrievecampaign;

public class BonusReward {

    private String bonusRewardId;

    public String getBonusRewardId() {
        return bonusRewardId;
    }

    public void setBonusRewardId(String bonusRewardId) {
        this.bonusRewardId = bonusRewardId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(BonusReward.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("bonusRewardId");
        sb.append('=');
        sb.append(((this.bonusRewardId == null)?"<null>":this.bonusRewardId));
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
        result = ((result* 31)+((this.bonusRewardId == null)? 0 :this.bonusRewardId.hashCode()));
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
        return ((this.bonusRewardId == rhs.bonusRewardId)||((this.bonusRewardId!= null)&&this.bonusRewardId.equals(rhs.bonusRewardId)));
    }

}
