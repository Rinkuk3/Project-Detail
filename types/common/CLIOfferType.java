package com.td.mbna.msec.midtier.types.common;

import java.io.Serializable;

public class CLIOfferType implements Serializable {

	private static final long serialVersionUID = 5672763675963847784L;
    private java.math.BigDecimal cliAmount;

    public java.math.BigDecimal getCliAmount() {
        return cliAmount;
    }

    public void setCliAmount(java.math.BigDecimal cliAmount) {
        this.cliAmount = cliAmount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CLIOfferType.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("cliAmount");
        sb.append('=');
        sb.append(((this.cliAmount == null)?"<null>":this.cliAmount));
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
        result = ((result* 31)+((this.cliAmount == null)? 0 :this.cliAmount.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CLIOfferType) == false) {
            return false;
        }
        CLIOfferType rhs = ((CLIOfferType) other);
        return ((this.cliAmount == rhs.cliAmount)||((this.cliAmount!= null)&&this.cliAmount.equals(rhs.cliAmount)));
    }

}
