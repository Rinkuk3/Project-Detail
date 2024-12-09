package com.td.mbna.msec.midtier.types.common;

import java.io.Serializable;

public class AccountOfferInputType implements Serializable {

	private static final long serialVersionUID = 1527196380983648882L;
    private String acctNum;
    private OfferInputPerAccountType offerInput;

    public String getAcctNum() {
        return acctNum;
    }

    public void setAcctNum(String acctNum) {
        this.acctNum = acctNum;
    }

    public OfferInputPerAccountType getOfferInput() {
        return offerInput;
    }

    public void setOfferInput(OfferInputPerAccountType offerInput) {
        this.offerInput = offerInput;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AccountOfferInputType.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("acctNum");
        sb.append('=');
        sb.append(((this.acctNum == null)?"<null>":this.acctNum));
        sb.append(',');
        sb.append("offerInput");
        sb.append('=');
        sb.append(((this.offerInput == null)?"<null>":this.offerInput));
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
        result = ((result* 31)+((this.offerInput == null)? 0 :this.offerInput.hashCode()));
        result = ((result* 31)+((this.acctNum == null)? 0 :this.acctNum.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AccountOfferInputType) == false) {
            return false;
        }
        AccountOfferInputType rhs = ((AccountOfferInputType) other);
        return (((this.offerInput == rhs.offerInput)||((this.offerInput!= null)&&this.offerInput.equals(rhs.offerInput)))&&((this.acctNum == rhs.acctNum)||((this.acctNum!= null)&&this.acctNum.equals(rhs.acctNum))));
    }

}
