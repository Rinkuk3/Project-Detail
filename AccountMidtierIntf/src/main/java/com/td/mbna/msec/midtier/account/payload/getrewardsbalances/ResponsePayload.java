package com.td.mbna.msec.midtier.account.payload.getrewardsbalances;

public class ResponsePayload {

	private Long availableBalanceQty;

    private String loyaltyUnitOfMeasure;
    
	public Long getAvailableBalanceQty() {
		return availableBalanceQty;
	}

	public void setAvailableBalanceQty(Long availableBalanceQty) {
		this.availableBalanceQty = availableBalanceQty;
	}
	
	public String getLoyaltyUnitOfMeasure() {
		return loyaltyUnitOfMeasure;
	}
	
	public void setLoyaltyUnitOfMeasure(String loyaltyUnitOfMeasure) {
		this.loyaltyUnitOfMeasure = loyaltyUnitOfMeasure;
	}
	
	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ResponsePayload.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("availableBalanceQty");
        sb.append('=');
        sb.append(((this.availableBalanceQty == null)?"<null>":this.availableBalanceQty));
        sb.append(',');
        sb.append("loyaltyUnitOfMeasure");
        sb.append('=');
        sb.append(((this.loyaltyUnitOfMeasure == null)?"<null>":this.loyaltyUnitOfMeasure));
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
        result = ((result* 31)+((this.availableBalanceQty == null)? 0 :this.availableBalanceQty.hashCode()));
        result = ((result* 31)+((this.loyaltyUnitOfMeasure == null)? 0 :this.loyaltyUnitOfMeasure.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ResponsePayload) == false) {
            return false;
        }
        ResponsePayload rhs = ((ResponsePayload) other);
        return (((this.availableBalanceQty == rhs.availableBalanceQty)||((this.availableBalanceQty!= null)&&this.availableBalanceQty.equals(rhs.availableBalanceQty)))&&((this.loyaltyUnitOfMeasure == rhs.loyaltyUnitOfMeasure)||((this.loyaltyUnitOfMeasure!= null)&&this.loyaltyUnitOfMeasure.equals(rhs.loyaltyUnitOfMeasure))));
    }

}