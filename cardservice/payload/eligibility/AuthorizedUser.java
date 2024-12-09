package com.td.mbna.msec.midtier.cardservice.payload.eligibility;

public class AuthorizedUser {

    private String customerId = "";
    private String cardNumber = "";

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AuthorizedUser.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("customerId");
        sb.append('=');
        sb.append(((this.customerId == null)?"<null>":this.customerId));
        sb.append(',');
        sb.append("cardNumber");
        sb.append('=');
        sb.append(((this.cardNumber == null)?"<null>":this.cardNumber));
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
        result = ((result* 31)+((this.customerId == null)? 0 :this.customerId.hashCode()));
        result = ((result* 31)+((this.cardNumber == null)? 0 :this.cardNumber.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AuthorizedUser) == false) {
            return false;
        }
        AuthorizedUser rhs = ((AuthorizedUser) other);
        return (((this.customerId == rhs.customerId)||((this.customerId!= null)&&this.customerId.equals(rhs.customerId)))&&((this.cardNumber == rhs.cardNumber)||((this.cardNumber!= null)&&this.cardNumber.equals(rhs.cardNumber))));
    }

}
