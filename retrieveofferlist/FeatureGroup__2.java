package com.td.api.mbofp.response.retrieveofferlist;

import java.util.ArrayList;
import java.util.List;

import com.td.api.mbofp.shared.Fee;
import com.td.api.mbofp.shared.MinimumPayment;
import com.td.api.mbofp.shared.Rate;

public class FeatureGroup__2 {

    private List<Rate> rate = new ArrayList<Rate>();
    private List<Fee> fee = new ArrayList<Fee>();
    private MinimumPayment minimumPayment;
    private Integer inactiveLimitMonthCnt;

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

    public Integer getInactiveLimitMonthCnt() {
        return inactiveLimitMonthCnt;
    }

    public void setInactiveLimitMonthCnt(Integer inactiveLimitMonthCnt) {
        this.inactiveLimitMonthCnt = inactiveLimitMonthCnt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(FeatureGroup__2 .class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
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
        sb.append("inactiveLimitMonthCnt");
        sb.append('=');
        sb.append(((this.inactiveLimitMonthCnt == null)?"<null>":this.inactiveLimitMonthCnt));
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
        result = ((result* 31)+((this.inactiveLimitMonthCnt == null)? 0 :this.inactiveLimitMonthCnt.hashCode()));
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
        if ((other instanceof FeatureGroup__2) == false) {
            return false;
        }
        FeatureGroup__2 rhs = ((FeatureGroup__2) other);
        return (((((this.inactiveLimitMonthCnt == rhs.inactiveLimitMonthCnt)||((this.inactiveLimitMonthCnt!= null)&&this.inactiveLimitMonthCnt.equals(rhs.inactiveLimitMonthCnt)))&&((this.rate == rhs.rate)||((this.rate!= null)&&this.rate.equals(rhs.rate))))&&((this.fee == rhs.fee)||((this.fee!= null)&&this.fee.equals(rhs.fee))))&&((this.minimumPayment == rhs.minimumPayment)||((this.minimumPayment!= null)&&this.minimumPayment.equals(rhs.minimumPayment))));
    }

}
