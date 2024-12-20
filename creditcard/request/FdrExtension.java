package com.td.api.mbcca.creditcard.request;

public class FdrExtension {

    private String demandDepositAccountId;

    public String getDemandDepositAccountId() {
        return demandDepositAccountId;
    }

    public void setDemandDepositAccountId(String demandDepositAccountId) {
        this.demandDepositAccountId = demandDepositAccountId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(FdrExtension.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("demandDepositAccountId");
        sb.append('=');
        sb.append(((this.demandDepositAccountId == null)?"<null>":this.demandDepositAccountId));
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
        result = ((result* 31)+((this.demandDepositAccountId == null)? 0 :this.demandDepositAccountId.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof FdrExtension) == false) {
            return false;
        }
        FdrExtension rhs = ((FdrExtension) other);
        return ((this.demandDepositAccountId == rhs.demandDepositAccountId)||((this.demandDepositAccountId!= null)&&this.demandDepositAccountId.equals(rhs.demandDepositAccountId)));
    }

}
