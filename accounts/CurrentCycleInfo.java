package com.td.api.mbcca.response.account;

import com.td.api.mbcca.shared.Cccyamt;

public class CurrentCycleInfo {

    private Cccyamt averageDailyBalanceCccyamt;

    public Cccyamt getAverageDailyBalanceCccyamt() {
        return averageDailyBalanceCccyamt;
    }

    public void setAverageDailyBalanceCccyamt(Cccyamt averageDailyBalanceCccyamt) {
        this.averageDailyBalanceCccyamt = averageDailyBalanceCccyamt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CurrentCycleInfo.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("averageDailyBalanceCccyamt");
        sb.append('=');
        sb.append(((this.averageDailyBalanceCccyamt == null)?"<null>":this.averageDailyBalanceCccyamt));
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
        result = ((result* 31)+((this.averageDailyBalanceCccyamt == null)? 0 :this.averageDailyBalanceCccyamt.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CurrentCycleInfo) == false) {
            return false;
        }
        CurrentCycleInfo rhs = ((CurrentCycleInfo) other);
        return ((this.averageDailyBalanceCccyamt == rhs.averageDailyBalanceCccyamt)||((this.averageDailyBalanceCccyamt!= null)&&this.averageDailyBalanceCccyamt.equals(rhs.averageDailyBalanceCccyamt)));
    }

}
