package com.td.api.mbcca.response.account;

public class CardExpiration {

    private String expirationYm;
    private Boolean neverExpiresInd;

    public String getExpirationYm() {
        return expirationYm;
    }

    public void setExpirationYm(String expirationYm) {
        this.expirationYm = expirationYm;
    }

    public Boolean getNeverExpiresInd() {
        return neverExpiresInd;
    }

    public void setNeverExpiresInd(Boolean neverExpiresInd) {
        this.neverExpiresInd = neverExpiresInd;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CardExpiration.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("expirationYm");
        sb.append('=');
        sb.append(((this.expirationYm == null)?"<null>":this.expirationYm));
        sb.append(',');
        sb.append("neverExpiresInd");
        sb.append('=');
        sb.append(((this.neverExpiresInd == null)?"<null>":this.neverExpiresInd));
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
        result = ((result* 31)+((this.expirationYm == null)? 0 :this.expirationYm.hashCode()));
        result = ((result* 31)+((this.neverExpiresInd == null)? 0 :this.neverExpiresInd.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CardExpiration) == false) {
            return false;
        }
        CardExpiration rhs = ((CardExpiration) other);
        return (((this.expirationYm == rhs.expirationYm)||((this.expirationYm!= null)&&this.expirationYm.equals(rhs.expirationYm)))&&((this.neverExpiresInd == rhs.neverExpiresInd)||((this.neverExpiresInd!= null)&&this.neverExpiresInd.equals(rhs.neverExpiresInd))));
    }

}
