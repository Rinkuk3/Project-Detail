package com.td.mbna.msec.midtier.transfer.payload;

public class DepositToChequingPayeeType {

    private String id;
    private String nickName;
    private String transitNum;
    private String bankId;
    private String acctNum;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getTransitNum() {
        return transitNum;
    }

    public void setTransitNum(String transitNum) {
        this.transitNum = transitNum;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public String getAcctNum() {
        return acctNum;
    }

    public void setAcctNum(String acctNum) {
        this.acctNum = acctNum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(DepositToChequingPayeeType.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("nickName");
        sb.append('=');
        sb.append(((this.nickName == null)?"<null>":this.nickName));
        sb.append(',');
        sb.append("transitNum");
        sb.append('=');
        sb.append(((this.transitNum == null)?"<null>":this.transitNum));
        sb.append(',');
        sb.append("bankId");
        sb.append('=');
        sb.append(((this.bankId == null)?"<null>":this.bankId));
        sb.append(',');
        sb.append("acctNum");
        sb.append('=');
        sb.append(((this.acctNum == null)?"<null>":this.acctNum));
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
        result = ((result* 31)+((this.transitNum == null)? 0 :this.transitNum.hashCode()));
        result = ((result* 31)+((this.bankId == null)? 0 :this.bankId.hashCode()));
        result = ((result* 31)+((this.id == null)? 0 :this.id.hashCode()));
        result = ((result* 31)+((this.nickName == null)? 0 :this.nickName.hashCode()));
        result = ((result* 31)+((this.acctNum == null)? 0 :this.acctNum.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DepositToChequingPayeeType) == false) {
            return false;
        }
        DepositToChequingPayeeType rhs = ((DepositToChequingPayeeType) other);
        return ((((((this.transitNum == rhs.transitNum)||((this.transitNum!= null)&&this.transitNum.equals(rhs.transitNum)))&&((this.bankId == rhs.bankId)||((this.bankId!= null)&&this.bankId.equals(rhs.bankId))))&&((this.id == rhs.id)||((this.id!= null)&&this.id.equals(rhs.id))))&&((this.nickName == rhs.nickName)||((this.nickName!= null)&&this.nickName.equals(rhs.nickName))))&&((this.acctNum == rhs.acctNum)||((this.acctNum!= null)&&this.acctNum.equals(rhs.acctNum))));
    }

}
