package com.td.api.mbofp.response.retrieveofferlist;

import java.util.ArrayList;
import java.util.List;

import com.td.api.mbofp.shared.Fee;
import com.td.api.mbofp.shared.MerchantCategory;
import com.td.api.mbofp.shared.Rate;

public class FeatureGroup {

    private String featureGroupId;
    private List<CreditLimit> creditLimit = new ArrayList<CreditLimit>();
    private List<Rate> rate = new ArrayList<Rate>();
    private Fee fee;
    private List<MerchantCategory> merchantCategory = new ArrayList<MerchantCategory>();

    public String getFeatureGroupId() {
        return featureGroupId;
    }

    public void setFeatureGroupId(String featureGroupId) {
        this.featureGroupId = featureGroupId;
    }

    public List<CreditLimit> getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(List<CreditLimit> creditLimit) {
        this.creditLimit = creditLimit;
    }

    public List<Rate> getRate() {
        return rate;
    }

    public void setRate(List<Rate> rate) {
        this.rate = rate;
    }

    public Fee getFee() {
        return fee;
    }

    public void setFee(Fee fee) {
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
        sb.append(FeatureGroup.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("featureGroupId");
        sb.append('=');
        sb.append(((this.featureGroupId == null)?"<null>":this.featureGroupId));
        sb.append(',');
        sb.append("creditLimit");
        sb.append('=');
        sb.append(((this.creditLimit == null)?"<null>":this.creditLimit));
        sb.append(',');
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
        result = ((result* 31)+((this.creditLimit == null)? 0 :this.creditLimit.hashCode()));
        result = ((result* 31)+((this.merchantCategory == null)? 0 :this.merchantCategory.hashCode()));
        result = ((result* 31)+((this.featureGroupId == null)? 0 :this.featureGroupId.hashCode()));
        result = ((result* 31)+((this.rate == null)? 0 :this.rate.hashCode()));
        result = ((result* 31)+((this.fee == null)? 0 :this.fee.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof FeatureGroup) == false) {
            return false;
        }
        FeatureGroup rhs = ((FeatureGroup) other);
        return ((((((this.creditLimit == rhs.creditLimit)||((this.creditLimit!= null)&&this.creditLimit.equals(rhs.creditLimit)))&&((this.merchantCategory == rhs.merchantCategory)||((this.merchantCategory!= null)&&this.merchantCategory.equals(rhs.merchantCategory))))&&((this.featureGroupId == rhs.featureGroupId)||((this.featureGroupId!= null)&&this.featureGroupId.equals(rhs.featureGroupId))))&&((this.rate == rhs.rate)||((this.rate!= null)&&this.rate.equals(rhs.rate))))&&((this.fee == rhs.fee)||((this.fee!= null)&&this.fee.equals(rhs.fee))));
    }

}
