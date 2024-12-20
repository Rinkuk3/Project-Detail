package com.td.mbna.msec.midtier.mbnaad.request.response.accesscard;

public class Card {

    private String statusCd;
    private String cardNum;
    private String cardNumMasked;
    private String onCardName;
    private String onCardCompanyName;
    private CardExpiration cardExpiration;
    private String deviceTypeCd;
    private String typeCd;
    private String lastCardRequestDt;

    public String getStatusCd() {
        return statusCd;
    }

    public void setStatusCd(String statusCd) {
        this.statusCd = statusCd;
    }

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

    public String getOnCardName() {
        return onCardName;
    }

    public void setOnCardName(String onCardName) {
        this.onCardName = onCardName;
    }

    public String getOnCardCompanyName() {
        return onCardCompanyName;
    }

    public void setOnCardCompanyName(String onCardCompanyName) {
        this.onCardCompanyName = onCardCompanyName;
    }

    public CardExpiration getCardExpiration() {
        return cardExpiration;
    }

    public void setCardExpiration(CardExpiration cardExpiration) {
        this.cardExpiration = cardExpiration;
    }

    public String getDeviceTypeCd() {
        return deviceTypeCd;
    }

    public void setDeviceTypeCd(String deviceTypeCd) {
        this.deviceTypeCd = deviceTypeCd;
    }

    public String getTypeCd() {
        return typeCd;
    }

    public void setTypeCd(String typeCd) {
        this.typeCd = typeCd;
    }

    public String getLastCardRequestDt() {
        return lastCardRequestDt;
    }

    public void setLastCardRequestDt(String lastCardRequestDt) {
        this.lastCardRequestDt = lastCardRequestDt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Card.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("statusCd");
        sb.append('=');
        sb.append(((this.statusCd == null)?"<null>":this.statusCd));
        sb.append(',');
        sb.append("cardNum");
        sb.append('=');
        sb.append(((this.cardNum == null)?"<null>":this.cardNum));
        sb.append(',');
        sb.append("cardNumMasked");
        sb.append('=');
        sb.append(((this.cardNumMasked == null)?"<null>":this.cardNumMasked));
        sb.append(',');
        sb.append("onCardName");
        sb.append('=');
        sb.append(((this.onCardName == null)?"<null>":this.onCardName));
        sb.append(',');
        sb.append("onCardCompanyName");
        sb.append('=');
        sb.append(((this.onCardCompanyName == null)?"<null>":this.onCardCompanyName));
        sb.append(',');
        sb.append("cardExpiration");
        sb.append('=');
        sb.append(((this.cardExpiration == null)?"<null>":this.cardExpiration));
        sb.append(',');
        sb.append("deviceTypeCd");
        sb.append('=');
        sb.append(((this.deviceTypeCd == null)?"<null>":this.deviceTypeCd));
        sb.append(',');
        sb.append("typeCd");
        sb.append('=');
        sb.append(((this.typeCd == null)?"<null>":this.typeCd));
        sb.append(',');
        sb.append("lastCardRequestDt");
        sb.append('=');
        sb.append(((this.lastCardRequestDt == null)?"<null>":this.lastCardRequestDt));
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
        result = ((result* 31)+((this.onCardName == null)? 0 :this.onCardName.hashCode()));
        result = ((result* 31)+((this.typeCd == null)? 0 :this.typeCd.hashCode()));
        result = ((result* 31)+((this.lastCardRequestDt == null)? 0 :this.lastCardRequestDt.hashCode()));
        result = ((result* 31)+((this.onCardCompanyName == null)? 0 :this.onCardCompanyName.hashCode()));
        result = ((result* 31)+((this.deviceTypeCd == null)? 0 :this.deviceTypeCd.hashCode()));
        result = ((result* 31)+((this.statusCd == null)? 0 :this.statusCd.hashCode()));
        result = ((result* 31)+((this.cardExpiration == null)? 0 :this.cardExpiration.hashCode()));
        result = ((result* 31)+((this.cardNumMasked == null)? 0 :this.cardNumMasked.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Card) == false) {
            return false;
        }
        Card rhs = ((Card) other);
        return ((((((((((this.cardNum == rhs.cardNum)||((this.cardNum!= null)&&this.cardNum.equals(rhs.cardNum)))&&((this.onCardName == rhs.onCardName)||((this.onCardName!= null)&&this.onCardName.equals(rhs.onCardName))))&&((this.typeCd == rhs.typeCd)||((this.typeCd!= null)&&this.typeCd.equals(rhs.typeCd))))&&((this.lastCardRequestDt == rhs.lastCardRequestDt)||((this.lastCardRequestDt!= null)&&this.lastCardRequestDt.equals(rhs.lastCardRequestDt))))&&((this.onCardCompanyName == rhs.onCardCompanyName)||((this.onCardCompanyName!= null)&&this.onCardCompanyName.equals(rhs.onCardCompanyName))))&&((this.deviceTypeCd == rhs.deviceTypeCd)||((this.deviceTypeCd!= null)&&this.deviceTypeCd.equals(rhs.deviceTypeCd))))&&((this.statusCd == rhs.statusCd)||((this.statusCd!= null)&&this.statusCd.equals(rhs.statusCd))))&&((this.cardExpiration == rhs.cardExpiration)||((this.cardExpiration!= null)&&this.cardExpiration.equals(rhs.cardExpiration))))&&((this.cardNumMasked == rhs.cardNumMasked)||((this.cardNumMasked!= null)&&this.cardNumMasked.equals(rhs.cardNumMasked))));
    }

}
