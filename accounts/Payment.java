package com.td.api.mbcca.response.account;

import com.td.api.mbcca.shared.Cccyamt;

public class Payment {

    private Cccyamt interestFreePaidInFullCccyamt;

    public Cccyamt getInterestFreePaidInFullCccyamt() {
        return interestFreePaidInFullCccyamt;
    }

    public void setInterestFreePaidInFullCccyamt(Cccyamt interestFreePaidInFullCccyamt) {
        this.interestFreePaidInFullCccyamt = interestFreePaidInFullCccyamt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Payment.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("interestFreePaidInFullCccyamt");
        sb.append('=');
        sb.append(((this.interestFreePaidInFullCccyamt == null)?"<null>":this.interestFreePaidInFullCccyamt));
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
        result = ((result* 31)+((this.interestFreePaidInFullCccyamt == null)? 0 :this.interestFreePaidInFullCccyamt.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Payment) == false) {
            return false;
        }
        Payment rhs = ((Payment) other);
        return ((this.interestFreePaidInFullCccyamt == rhs.interestFreePaidInFullCccyamt)||((this.interestFreePaidInFullCccyamt!= null)&&this.interestFreePaidInFullCccyamt.equals(rhs.interestFreePaidInFullCccyamt)));
    }

}
