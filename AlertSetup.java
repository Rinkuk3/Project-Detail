package com.td.api.mbcca.response.account;

public class AlertSetup {

    private CardWatch cardWatch;
    private TieredWatch tieredWatch;

    public CardWatch getCardWatch() {
        return cardWatch;
    }

    public void setCardWatch(CardWatch cardWatch) {
        this.cardWatch = cardWatch;
    }

    public TieredWatch getTieredWatch() {
        return tieredWatch;
    }

    public void setTieredWatch(TieredWatch tieredWatch) {
        this.tieredWatch = tieredWatch;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AlertSetup.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("cardWatch");
        sb.append('=');
        sb.append(((this.cardWatch == null)?"<null>":this.cardWatch));
        sb.append(',');
        sb.append("tieredWatch");
        sb.append('=');
        sb.append(((this.tieredWatch == null)?"<null>":this.tieredWatch));
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
        result = ((result* 31)+((this.cardWatch == null)? 0 :this.cardWatch.hashCode()));
        result = ((result* 31)+((this.tieredWatch == null)? 0 :this.tieredWatch.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AlertSetup) == false) {
            return false;
        }
        AlertSetup rhs = ((AlertSetup) other);
        return (((this.cardWatch == rhs.cardWatch)||((this.cardWatch!= null)&&this.cardWatch.equals(rhs.cardWatch)))&&((this.tieredWatch == rhs.tieredWatch)||((this.tieredWatch!= null)&&this.tieredWatch.equals(rhs.tieredWatch))));
    }

}
