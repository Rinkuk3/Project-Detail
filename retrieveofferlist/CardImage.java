package com.td.api.mbofp.response.retrieveofferlist;

public class CardImage {

    private String cardImageId;
    private String typeCd;
    private String cardImageDesc;
    private String languageCd;

    public String getCardImageId() {
        return cardImageId;
    }

    public void setCardImageId(String cardImageId) {
        this.cardImageId = cardImageId;
    }

    public String getTypeCd() {
        return typeCd;
    }

    public void setTypeCd(String typeCd) {
        this.typeCd = typeCd;
    }

    public String getCardImageDesc() {
        return cardImageDesc;
    }

    public void setCardImageDesc(String cardImageDesc) {
        this.cardImageDesc = cardImageDesc;
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
        sb.append(CardImage.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("cardImageId");
        sb.append('=');
        sb.append(((this.cardImageId == null)?"<null>":this.cardImageId));
        sb.append(',');
        sb.append("typeCd");
        sb.append('=');
        sb.append(((this.typeCd == null)?"<null>":this.typeCd));
        sb.append(',');
        sb.append("cardImageDesc");
        sb.append('=');
        sb.append(((this.cardImageDesc == null)?"<null>":this.cardImageDesc));
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
        result = ((result* 31)+((this.cardImageDesc == null)? 0 :this.cardImageDesc.hashCode()));
        result = ((result* 31)+((this.languageCd == null)? 0 :this.languageCd.hashCode()));
        result = ((result* 31)+((this.cardImageId == null)? 0 :this.cardImageId.hashCode()));
        result = ((result* 31)+((this.typeCd == null)? 0 :this.typeCd.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CardImage) == false) {
            return false;
        }
        CardImage rhs = ((CardImage) other);
        return (((((this.cardImageDesc == rhs.cardImageDesc)||((this.cardImageDesc!= null)&&this.cardImageDesc.equals(rhs.cardImageDesc)))&&((this.languageCd == rhs.languageCd)||((this.languageCd!= null)&&this.languageCd.equals(rhs.languageCd))))&&((this.cardImageId == rhs.cardImageId)||((this.cardImageId!= null)&&this.cardImageId.equals(rhs.cardImageId))))&&((this.typeCd == rhs.typeCd)||((this.typeCd!= null)&&this.typeCd.equals(rhs.typeCd))));
    }

}
