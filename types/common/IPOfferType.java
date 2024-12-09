package com.td.mbna.msec.midtier.types.common;

import com.google.gson.annotations.JsonAdapter;
import com.td.mbna.msec.midtier.serializers.GsonDateDeSerializer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class IPOfferType implements Serializable {

	private static final long serialVersionUID = 2607661554647718805L;
	
    @JsonAdapter(value = GsonDateDeSerializer.class)
    private Long expiryDate;
    
    private Boolean earlyExpired;
    private Integer duration;
    private String eligibleNegotiatedType;
    private java.math.BigDecimal fixedFeeAmount;
    private java.math.BigDecimal minimumFeeAmount;
    private java.math.BigDecimal maximumFeeAmount;
    private java.math.BigDecimal feePercentage;
    private List<IPRate> rate = new ArrayList<IPRate>();

    public List<IPRate> getRate() {
        return rate;
    }

    public void setRate(List<IPRate> rate) {
        this.rate = rate;
    }

    public Long getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Long expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Boolean getEarlyExpired() {
        return earlyExpired;
    }

    public void setEarlyExpired(Boolean earlyExpired) {
        this.earlyExpired = earlyExpired;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public java.math.BigDecimal getFixedFeeAmount() {
        return fixedFeeAmount;
    }

    public void setFixedFeeAmount(java.math.BigDecimal fixedFeeAmount) {
        this.fixedFeeAmount = fixedFeeAmount;
    }

    public java.math.BigDecimal getMinimumFeeAmount() {
        return minimumFeeAmount;
    }

    public void setMinimumFeeAmount(java.math.BigDecimal minimumFeeAmount) {
        this.minimumFeeAmount = minimumFeeAmount;
    }

    public java.math.BigDecimal getMaximumFeeAmount() {
        return maximumFeeAmount;
    }

    public void setMaximumFeeAmount(java.math.BigDecimal maximumFeeAmount) {
        this.maximumFeeAmount = maximumFeeAmount;
    }

    public java.math.BigDecimal getFeePercentage() {
        return feePercentage;
    }

    public void setFeePercentage(java.math.BigDecimal feePercentage) {
        this.feePercentage = feePercentage;
    }

    public String getEligibleNegotiatedType() {
        return eligibleNegotiatedType;
    }

    public void setEligibleNegotiatedType(String eligibleNegotiatedType) {
        this.eligibleNegotiatedType = eligibleNegotiatedType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(IPOfferType.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("rate");
        sb.append('=');
        sb.append(((this.rate == null)?"<null>":this.rate));
        sb.append(',');
        sb.append("expiryDate");
        sb.append('=');
        sb.append(((this.expiryDate == null)?"<null>":this.expiryDate));
        sb.append(',');
        sb.append("earlyExpired");
        sb.append('=');
        sb.append(((this.earlyExpired == null)?"<null>":this.earlyExpired));
        sb.append(',');
        sb.append("duration");
        sb.append('=');
        sb.append(((this.duration == null)?"<null>":this.duration));
        sb.append(',');
        sb.append("fixedFeeAmount");
        sb.append('=');
        sb.append(((this.fixedFeeAmount == null)?"<null>":this.fixedFeeAmount));
        sb.append(',');
        sb.append("minimumFeeAmount");
        sb.append('=');
        sb.append(((this.minimumFeeAmount == null)?"<null>":this.minimumFeeAmount));
        sb.append(',');
        sb.append("maximumFeeAmount");
        sb.append('=');
        sb.append(((this.maximumFeeAmount == null)?"<null>":this.maximumFeeAmount));
        sb.append(',');
        sb.append("feePercentage");
        sb.append('=');
        sb.append(((this.feePercentage == null)?"<null>":this.feePercentage));
        sb.append(',');
        sb.append("eligibleNegotiatedType");
        sb.append('=');
        sb.append(((this.eligibleNegotiatedType == null)?"<null>":this.eligibleNegotiatedType));
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
        result = ((result* 31)+((this.expiryDate == null)? 0 :this.expiryDate.hashCode()));
        result = ((result* 31)+((this.duration == null)? 0 :this.duration.hashCode()));
        result = ((result* 31)+((this.minimumFeeAmount == null)? 0 :this.minimumFeeAmount.hashCode()));
        result = ((result* 31)+((this.rate == null)? 0 :this.rate.hashCode()));
        result = ((result* 31)+((this.feePercentage == null)? 0 :this.feePercentage.hashCode()));
        result = ((result* 31)+((this.fixedFeeAmount == null)? 0 :this.fixedFeeAmount.hashCode()));
        result = ((result* 31)+((this.earlyExpired == null)? 0 :this.earlyExpired.hashCode()));
        result = ((result* 31)+((this.maximumFeeAmount == null)? 0 :this.maximumFeeAmount.hashCode()));
        result = ((result* 31)+((this.eligibleNegotiatedType == null)? 0 :this.eligibleNegotiatedType.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof IPOfferType) == false) {
            return false;
        }
        IPOfferType rhs = ((IPOfferType) other);
        return ((((((((((this.expiryDate == rhs.expiryDate)||((this.expiryDate!= null)&&this.expiryDate.equals(rhs.expiryDate)))&&((this.duration == rhs.duration)||((this.duration!= null)&&this.duration.equals(rhs.duration))))&&((this.minimumFeeAmount == rhs.minimumFeeAmount)||((this.minimumFeeAmount!= null)&&this.minimumFeeAmount.equals(rhs.minimumFeeAmount))))&&((this.rate == rhs.rate)||((this.rate!= null)&&this.rate.equals(rhs.rate))))&&((this.feePercentage == rhs.feePercentage)||((this.feePercentage!= null)&&this.feePercentage.equals(rhs.feePercentage))))&&((this.fixedFeeAmount == rhs.fixedFeeAmount)||((this.fixedFeeAmount!= null)&&this.fixedFeeAmount.equals(rhs.fixedFeeAmount))))&&((this.earlyExpired == rhs.earlyExpired)||((this.earlyExpired!= null)&&this.earlyExpired.equals(rhs.earlyExpired))))&&((this.maximumFeeAmount == rhs.maximumFeeAmount)||((this.maximumFeeAmount!= null)&&this.maximumFeeAmount.equals(rhs.maximumFeeAmount))))&&((this.eligibleNegotiatedType == rhs.eligibleNegotiatedType)||((this.eligibleNegotiatedType!= null)&&this.eligibleNegotiatedType.equals(rhs.eligibleNegotiatedType))));
    }

}
