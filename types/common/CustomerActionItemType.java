package com.td.mbna.msec.midtier.types.common;

import java.io.Serializable;
import java.math.BigInteger;

public class CustomerActionItemType implements Serializable {

	private static final long serialVersionUID = -6398571107585857390L;
    private BigInteger actionID;
    private String customerID;
    private String accountNumber;
    private Boolean visited;
    private Boolean dismissed;

    public BigInteger getActionID() {
        return actionID;
    }

    public void setActionID(BigInteger actionID) {
        this.actionID = actionID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Boolean getVisited() {
        return visited;
    }

    public void setVisited(Boolean visited) {
        this.visited = visited;
    }

    public Boolean getDismissed() {
        return dismissed;
    }

    public void setDismissed(Boolean dismissed) {
        this.dismissed = dismissed;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CustomerActionItemType.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("actionID");
        sb.append('=');
        sb.append(((this.actionID == null)?"<null>":this.actionID));
        sb.append(',');
        sb.append("customerID");
        sb.append('=');
        sb.append(((this.customerID == null)?"<null>":this.customerID));
        sb.append(',');
        sb.append("accountNumber");
        sb.append('=');
        sb.append(((this.accountNumber == null)?"<null>":this.accountNumber));
        sb.append(',');
        sb.append("visited");
        sb.append('=');
        sb.append(((this.visited == null)?"<null>":this.visited));
        sb.append(',');
        sb.append("dismissed");
        sb.append('=');
        sb.append(((this.dismissed == null)?"<null>":this.dismissed));
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
        result = ((result* 31)+((this.customerID == null)? 0 :this.customerID.hashCode()));
        result = ((result* 31)+((this.visited == null)? 0 :this.visited.hashCode()));
        result = ((result* 31)+((this.dismissed == null)? 0 :this.dismissed.hashCode()));
        result = ((result* 31)+((this.actionID == null)? 0 :this.actionID.hashCode()));
        result = ((result* 31)+((this.accountNumber == null)? 0 :this.accountNumber.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CustomerActionItemType) == false) {
            return false;
        }
        CustomerActionItemType rhs = ((CustomerActionItemType) other);
        return ((((((this.customerID == rhs.customerID)||((this.customerID!= null)&&this.customerID.equals(rhs.customerID)))&&((this.visited == rhs.visited)||((this.visited!= null)&&this.visited.equals(rhs.visited))))&&((this.dismissed == rhs.dismissed)||((this.dismissed!= null)&&this.dismissed.equals(rhs.dismissed))))&&((this.actionID == rhs.actionID)||((this.actionID!= null)&&this.actionID.equals(rhs.actionID))))&&((this.accountNumber == rhs.accountNumber)||((this.accountNumber!= null)&&this.accountNumber.equals(rhs.accountNumber))));
    }

}
