package com.td.api.mbcca.creditcard.request;

public class AddressInfo {

    private String cardAddressId;
    private String correspondenceAddressId;
    private String pinMailerAddressId;
    private String statementAddressId;

    public String getCardAddressId() {
        return cardAddressId;
    }

    public void setCardAddressId(String cardAddressId) {
        this.cardAddressId = cardAddressId;
    }

    public String getCorrespondenceAddressId() {
        return correspondenceAddressId;
    }

    public void setCorrespondenceAddressId(String correspondenceAddressId) {
        this.correspondenceAddressId = correspondenceAddressId;
    }

    public String getPinMailerAddressId() {
        return pinMailerAddressId;
    }

    public void setPinMailerAddressId(String pinMailerAddressId) {
        this.pinMailerAddressId = pinMailerAddressId;
    }

    public String getStatementAddressId() {
        return statementAddressId;
    }

    public void setStatementAddressId(String statementAddressId) {
        this.statementAddressId = statementAddressId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AddressInfo.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("cardAddressId");
        sb.append('=');
        sb.append(((this.cardAddressId == null)?"<null>":this.cardAddressId));
        sb.append(',');
        sb.append("correspondenceAddressId");
        sb.append('=');
        sb.append(((this.correspondenceAddressId == null)?"<null>":this.correspondenceAddressId));
        sb.append(',');
        sb.append("pinMailerAddressId");
        sb.append('=');
        sb.append(((this.pinMailerAddressId == null)?"<null>":this.pinMailerAddressId));
        sb.append(',');
        sb.append("statementAddressId");
        sb.append('=');
        sb.append(((this.statementAddressId == null)?"<null>":this.statementAddressId));
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
        result = ((result* 31)+((this.statementAddressId == null)? 0 :this.statementAddressId.hashCode()));
        result = ((result* 31)+((this.cardAddressId == null)? 0 :this.cardAddressId.hashCode()));
        result = ((result* 31)+((this.pinMailerAddressId == null)? 0 :this.pinMailerAddressId.hashCode()));
        result = ((result* 31)+((this.correspondenceAddressId == null)? 0 :this.correspondenceAddressId.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AddressInfo) == false) {
            return false;
        }
        AddressInfo rhs = ((AddressInfo) other);
        return (((((this.statementAddressId == rhs.statementAddressId)||((this.statementAddressId!= null)&&this.statementAddressId.equals(rhs.statementAddressId)))&&((this.cardAddressId == rhs.cardAddressId)||((this.cardAddressId!= null)&&this.cardAddressId.equals(rhs.cardAddressId))))&&((this.pinMailerAddressId == rhs.pinMailerAddressId)||((this.pinMailerAddressId!= null)&&this.pinMailerAddressId.equals(rhs.pinMailerAddressId))))&&((this.correspondenceAddressId == rhs.correspondenceAddressId)||((this.correspondenceAddressId!= null)&&this.correspondenceAddressId.equals(rhs.correspondenceAddressId))));
    }

}
