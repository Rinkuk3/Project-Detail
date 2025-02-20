package com.td.api.mbofp.response.retrievecampaign;

import java.util.ArrayList;
import java.util.List;

import com.td.api.mbofp.shared.Fee;
import com.td.api.mbofp.shared.MinimumPayment;
import com.td.api.mbofp.shared.Rate;

public class FeatureGroup__1 {

    private BonusReward bonusReward;
    private List<DelinquencyPolicy> delinquencyPolicy = new ArrayList<DelinquencyPolicy>();
    private List<Rate> rate = new ArrayList<Rate>();
    private List<Fee> fee = new ArrayList<Fee>();
    private MinimumPayment minimumPayment;

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

    public List<Rate> getRate() {
        return rate;
    }

    public void setRate(List<Rate> rate) {
        this.rate = rate;
    }

    public List<Fee> getFee() {
        return fee;
    }

    public void setFee(List<Fee> fee) {
        this.fee = fee;
    }

    public MinimumPayment getMinimumPayment() {
        return minimumPayment;
    }

    public void setMinimumPayment(MinimumPayment minimumPayment) {
        this.minimumPayment = minimumPayment;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(FeatureGroup__1 .class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("bonusReward");
        sb.append('=');
        sb.append(((this.bonusReward == null)?"<null>":this.bonusReward));
        sb.append(',');
        sb.append("delinquencyPolicy");
        sb.append('=');
        sb.append(((this.delinquencyPolicy == null)?"<null>":this.delinquencyPolicy));
        sb.append(',');
        sb.append("rate");
        sb.append('=');
        sb.append(((this.rate == null)?"<null>":this.rate));
        sb.append(',');
        sb.append("fee");
        sb.append('=');
        sb.append(((this.fee == null)?"<null>":this.fee));
        sb.append(',');
        sb.append("minimumPayment");
        sb.append('=');
        sb.append(((this.minimumPayment == null)?"<null>":this.minimumPayment));
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
        result = ((result* 31)+((this.delinquencyPolicy == null)? 0 :this.delinquencyPolicy.hashCode()));
        result = ((result* 31)+((this.rate == null)? 0 :this.rate.hashCode()));
        result = ((result* 31)+((this.fee == null)? 0 :this.fee.hashCode()));
        result = ((result* 31)+((this.minimumPayment == null)? 0 :this.minimumPayment.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof FeatureGroup__1) == false) {
            return false;
        }
        FeatureGroup__1 rhs = ((FeatureGroup__1) other);
        return ((((((this.bonusReward == rhs.bonusReward)||((this.bonusReward!= null)&&this.bonusReward.equals(rhs.bonusReward)))&&((this.delinquencyPolicy == rhs.delinquencyPolicy)||((this.delinquencyPolicy!= null)&&this.delinquencyPolicy.equals(rhs.delinquencyPolicy))))&&((this.rate == rhs.rate)||((this.rate!= null)&&this.rate.equals(rhs.rate))))&&((this.fee == rhs.fee)||((this.fee!= null)&&this.fee.equals(rhs.fee))))&&((this.minimumPayment == rhs.minimumPayment)||((this.minimumPayment!= null)&&this.minimumPayment.equals(rhs.minimumPayment))));
    }

}
