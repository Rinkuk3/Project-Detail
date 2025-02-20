package com.td.api.mbofp.response.retrievecampaign;

public class CardLayout {

    private String cardLayoutId;
    private String languageCd;

    public String getCardLayoutId() {
        return cardLayoutId;
    }

    public void setCardLayoutId(String cardLayoutId) {
        this.cardLayoutId = cardLayoutId;
    }

    public String getLanguageCd() {
        return languageCd;
    }

    public void setLanguageCd(String languageCd) {
        this.languageCd = languageCd;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CardLayout.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("cardLayoutId");
        sb.append('=');
        sb.append(((this.cardLayoutId == null)?"<null>":this.cardLayoutId));
        sb.append(',');
        sb.append("languageCd");
        sb.append('=');
        sb.append(((this.languageCd == null)?"<null>":this.languageCd));
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
        result = ((result* 31)+((this.cardLayoutId == null)? 0 :this.cardLayoutId.hashCode()));
        result = ((result* 31)+((this.languageCd == null)? 0 :this.languageCd.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CardLayout) == false) {
            return false;
        }
        CardLayout rhs = ((CardLayout) other);
        return (((this.cardLayoutId == rhs.cardLayoutId)||((this.cardLayoutId!= null)&&this.cardLayoutId.equals(rhs.cardLayoutId)))&&((this.languageCd == rhs.languageCd)||((this.languageCd!= null)&&this.languageCd.equals(rhs.languageCd))));
    }

}
