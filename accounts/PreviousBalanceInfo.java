package com.td.api.mbcca.response.account;

import java.util.ArrayList;
import java.util.List;

public class PreviousBalanceInfo {

    private String cycleDt;
    private List<TransactionCategoryBalance> transactionCategoryBalance = new ArrayList<TransactionCategoryBalance>();

    public String getCycleDt() {
        return cycleDt;
    }

    public void setCycleDt(String cycleDt) {
        this.cycleDt = cycleDt;
    }

    public List<TransactionCategoryBalance> getTransactionCategoryBalance() {
        return transactionCategoryBalance;
    }

    public void setTransactionCategoryBalance(List<TransactionCategoryBalance> transactionCategoryBalance) {
        this.transactionCategoryBalance = transactionCategoryBalance;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PreviousBalanceInfo.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("cycleDt");
        sb.append('=');
        sb.append(((this.cycleDt == null)?"<null>":this.cycleDt));
        sb.append(',');
        sb.append("transactionCategoryBalance");
        sb.append('=');
        sb.append(((this.transactionCategoryBalance == null)?"<null>":this.transactionCategoryBalance));
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
        result = ((result* 31)+((this.cycleDt == null)? 0 :this.cycleDt.hashCode()));
        result = ((result* 31)+((this.transactionCategoryBalance == null)? 0 :this.transactionCategoryBalance.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PreviousBalanceInfo) == false) {
            return false;
        }
        PreviousBalanceInfo rhs = ((PreviousBalanceInfo) other);
        return (((this.cycleDt == rhs.cycleDt)||((this.cycleDt!= null)&&this.cycleDt.equals(rhs.cycleDt)))&&((this.transactionCategoryBalance == rhs.transactionCategoryBalance)||((this.transactionCategoryBalance!= null)&&this.transactionCategoryBalance.equals(rhs.transactionCategoryBalance))));
    }

}
