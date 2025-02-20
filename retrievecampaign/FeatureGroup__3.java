package com.td.api.mbofp.response.retrievecampaign;

import java.util.ArrayList;
import java.util.List;

import com.td.api.mbofp.shared.Fee;
import com.td.api.mbofp.shared.MerchantCategory;
import com.td.api.mbofp.shared.Rate;

public class FeatureGroup__3 {

    private Rate rate;
    private List<Fee> fee = new ArrayList<Fee>();
    private List<MerchantCategory> merchantCategory = new ArrayList<MerchantCategory>();

    public Rate getRate() {
        return rate;
    }

    public void setRate(Rate rate) {
        this.rate = rate;
    }

    public List<Fee> getFee() {
        return fee;
    }

    public void setFee(List<Fee> fee) {
        this.fee = fee;
    }

    public List<MerchantCategory> getMerchantCategory() {
        return merchantCategory;
    }

    public void setMerchantCategory(List<MerchantCategory> merchantCategory) {
        this.merchantCategory = merchantCategory;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(FeatureGroup__3 .class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("rate");
        sb.append('=');
        sb.append(((this.rate == null)?"<null>":this.rate));
        sb.append(',');
        sb.append("fee");
        sb.append('=');
        sb.append(((this.fee == null)?"<null>":this.fee));
        sb.append(',');
        sb.append("merchantCategory");
        sb.append('=');
        sb.append(((this.merchantCategory == null)?"<null>":this.merchantCategory));
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
        result = ((result* 31)+((this.merchantCategory == null)? 0 :this.merchantCategory.hashCode()));
        result = ((result* 31)+((this.rate == null)? 0 :this.rate.hashCode()));
        result = ((result* 31)+((this.fee == null)? 0 :this.fee.hashCode()));
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
        return ((((this.merchantCategory == rhs.merchantCategory)||((this.merchantCategory!= null)&&this.merchantCategory.equals(rhs.merchantCategory)))&&((this.rate == rhs.rate)||((this.rate!= null)&&this.rate.equals(rhs.rate))))&&((this.fee == rhs.fee)||((this.fee!= null)&&this.fee.equals(rhs.fee))));
    }

}
