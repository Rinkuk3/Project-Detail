package com.td.api.mbcca.response.account;

public class Altkey {

    private String cardNum;
    private String cardNumMasked;
    private String accountNum;
    private String key;

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getCardNumMasked() {
        return cardNumMasked;
    }

    public void setCardNumMasked(String cardNumMasked) {
        this.cardNumMasked = cardNumMasked;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Altkey.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("cardNum");
        sb.append('=');
        sb.append(((this.cardNum == null)?"<null>":this.cardNum));
        sb.append(',');
        sb.append("cardNumMasked");
        sb.append('=');
        sb.append(((this.cardNumMasked == null)?"<null>":this.cardNumMasked));
        sb.append(',');
        sb.append("accountNum");
        sb.append('=');
        sb.append(((this.accountNum == null)?"<null>":this.accountNum));
        sb.append(',');
        sb.append("key");
        sb.append('=');
        sb.append(((this.key == null)?"<null>":this.key));
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
        result = ((result* 31)+((this.cardNum == null)? 0 :this.cardNum.hashCode()));
        result = ((result* 31)+((this.accountNum == null)? 0 :this.accountNum.hashCode()));
        result = ((result* 31)+((this.cardNumMasked == null)? 0 :this.cardNumMasked.hashCode()));
        result = ((result* 31)+((this.key == null)? 0 :this.key.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Altkey) == false) {
            return false;
        }
        Altkey rhs = ((Altkey) other);
        return (((((this.cardNum == rhs.cardNum)||((this.cardNum!= null)&&this.cardNum.equals(rhs.cardNum)))&&((this.accountNum == rhs.accountNum)||((this.accountNum!= null)&&this.accountNum.equals(rhs.accountNum))))&&((this.cardNumMasked == rhs.cardNumMasked)||((this.cardNumMasked!= null)&&this.cardNumMasked.equals(rhs.cardNumMasked))))&&((this.key == rhs.key)||((this.key!= null)&&this.key.equals(rhs.key))));
    }

}
