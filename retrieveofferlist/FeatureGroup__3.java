package com.td.api.mbofp.response.retrieveofferlist;

import java.util.ArrayList;
import java.util.List;

public class FeatureGroup__3 {

    private BonusReward bonusReward;
    private List<DelinquencyPolicy> delinquencyPolicy = new ArrayList<DelinquencyPolicy>();
    private TowTerm towTerm;
    private String feeDiscountCd;

    public BonusReward getBonusReward() {
        return bonusReward;
    }

    public void setBonusReward(BonusReward bonusReward) {
        this.bonusReward = bonusReward;
    }

    public List<DelinquencyPolicy> getDelinquencyPolicy() {
        return delinquencyPolicy;
    }

    public void setDelinquencyPolicy(List<DelinquencyPolicy> delinquencyPolicy) {
        this.delinquencyPolicy = delinquencyPolicy;
    }

    public TowTerm getTowTerm() {
        return towTerm;
    }

    public void setTowTerm(TowTerm towTerm) {
        this.towTerm = towTerm;
    }

    public String getFeeDiscountCd() {
        return feeDiscountCd;
    }

    public void setFeeDiscountCd(String feeDiscountCd) {
        this.feeDiscountCd = feeDiscountCd;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(FeatureGroup__3 .class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("bonusReward");
        sb.append('=');
        sb.append(((this.bonusReward == null)?"<null>":this.bonusReward));
        sb.append(',');
        sb.append("delinquencyPolicy");
        sb.append('=');
        sb.append(((this.delinquencyPolicy == null)?"<null>":this.delinquencyPolicy));
        sb.append(',');
        sb.append("towTerm");
        sb.append('=');
        sb.append(((this.towTerm == null)?"<null>":this.towTerm));
        sb.append(',');
        sb.append("feeDiscountCd");
        sb.append('=');
        sb.append(((this.feeDiscountCd == null)?"<null>":this.feeDiscountCd));
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
        result = ((result* 31)+((this.bonusReward == null)? 0 :this.bonusReward.hashCode()));
        result = ((result* 31)+((this.towTerm == null)? 0 :this.towTerm.hashCode()));
        result = ((result* 31)+((this.delinquencyPolicy == null)? 0 :this.delinquencyPolicy.hashCode()));
        result = ((result* 31)+((this.feeDiscountCd == null)? 0 :this.feeDiscountCd.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof FeatureGroup__3) == false) {
            return false;
        }
        FeatureGroup__3 rhs = ((FeatureGroup__3) other);
        return (((((this.bonusReward == rhs.bonusReward)||((this.bonusReward!= null)&&this.bonusReward.equals(rhs.bonusReward)))&&((this.towTerm == rhs.towTerm)||((this.towTerm!= null)&&this.towTerm.equals(rhs.towTerm))))&&((this.delinquencyPolicy == rhs.delinquencyPolicy)||((this.delinquencyPolicy!= null)&&this.delinquencyPolicy.equals(rhs.delinquencyPolicy))))&&((this.feeDiscountCd == rhs.feeDiscountCd)||((this.feeDiscountCd!= null)&&this.feeDiscountCd.equals(rhs.feeDiscountCd))));
    }

}
