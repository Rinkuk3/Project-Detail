package com.td.mbna.msec.midtier.transfer.payload.balancetransfertocreditor;

import java.util.ArrayList;
import java.util.List;

import com.td.mbna.msec.midtier.transfer.payload.BTConfirmationType;

public class ResponsePayload {

    private List<BTConfirmationType> confirmation = new ArrayList<BTConfirmationType>();
    private Integer minNumOfDays;
    private Integer maxNumOfDays;
    private Boolean containFailure;
    private Boolean allowBalanceTransfer;
    private Boolean allowTransferToChequing;

    public List<BTConfirmationType> getConfirmation() {
        return confirmation;
    }

    public void setConfirmation(List<BTConfirmationType> confirmation) {
        this.confirmation = confirmation;
    }

    public Integer getMinNumOfDays() {
        return minNumOfDays;
    }

    public void setMinNumOfDays(Integer minNumOfDays) {
        this.minNumOfDays = minNumOfDays;
    }

    public Integer getMaxNumOfDays() {
        return maxNumOfDays;
    }

    public void setMaxNumOfDays(Integer maxNumOfDays) {
        this.maxNumOfDays = maxNumOfDays;
    }

    public Boolean getContainFailure() {
        return containFailure;
    }

    public void setContainFailure(Boolean containFailure) {
        this.containFailure = containFailure;
    }

    public Boolean getAllowBalanceTransfer() {
        return allowBalanceTransfer;
    }

    public void setAllowBalanceTransfer(Boolean allowBalanceTransfer) {
        this.allowBalanceTransfer = allowBalanceTransfer;
    }

    public Boolean getAllowTransferToChequing() {
        return allowTransferToChequing;
    }

    public void setAllowTransferToChequing(Boolean allowTransferToChequing) {
        this.allowTransferToChequing = allowTransferToChequing;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ResponsePayload.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("confirmation");
        sb.append('=');
        sb.append(((this.confirmation == null)?"<null>":this.confirmation));
        sb.append(',');
        sb.append("minNumOfDays");
        sb.append('=');
        sb.append(((this.minNumOfDays == null)?"<null>":this.minNumOfDays));
        sb.append(',');
        sb.append("maxNumOfDays");
        sb.append('=');
        sb.append(((this.maxNumOfDays == null)?"<null>":this.maxNumOfDays));
        sb.append(',');
        sb.append("containFailure");
        sb.append('=');
        sb.append(((this.containFailure == null)?"<null>":this.containFailure));
        sb.append(',');
        sb.append("allowBalanceTransfer");
        sb.append('=');
        sb.append(((this.allowBalanceTransfer == null)?"<null>":this.allowBalanceTransfer));
        sb.append(',');
        sb.append("allowTransferToChequing");
        sb.append('=');
        sb.append(((this.allowTransferToChequing == null)?"<null>":this.allowTransferToChequing));
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
        result = ((result* 31)+((this.containFailure == null)? 0 :this.containFailure.hashCode()));
        result = ((result* 31)+((this.minNumOfDays == null)? 0 :this.minNumOfDays.hashCode()));
        result = ((result* 31)+((this.allowTransferToChequing == null)? 0 :this.allowTransferToChequing.hashCode()));
        result = ((result* 31)+((this.confirmation == null)? 0 :this.confirmation.hashCode()));
        result = ((result* 31)+((this.allowBalanceTransfer == null)? 0 :this.allowBalanceTransfer.hashCode()));
        result = ((result* 31)+((this.maxNumOfDays == null)? 0 :this.maxNumOfDays.hashCode()));
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
        return (((((((this.containFailure == rhs.containFailure)||((this.containFailure!= null)&&this.containFailure.equals(rhs.containFailure)))&&((this.minNumOfDays == rhs.minNumOfDays)||((this.minNumOfDays!= null)&&this.minNumOfDays.equals(rhs.minNumOfDays))))&&((this.allowTransferToChequing == rhs.allowTransferToChequing)||((this.allowTransferToChequing!= null)&&this.allowTransferToChequing.equals(rhs.allowTransferToChequing))))&&((this.confirmation == rhs.confirmation)||((this.confirmation!= null)&&this.confirmation.equals(rhs.confirmation))))&&((this.allowBalanceTransfer == rhs.allowBalanceTransfer)||((this.allowBalanceTransfer!= null)&&this.allowBalanceTransfer.equals(rhs.allowBalanceTransfer))))&&((this.maxNumOfDays == rhs.maxNumOfDays)||((this.maxNumOfDays!= null)&&this.maxNumOfDays.equals(rhs.maxNumOfDays))));
    }

}
