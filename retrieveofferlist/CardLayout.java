package com.td.api.mbofp.response.retrieveofferlist;

import java.util.ArrayList;
import java.util.List;

public class CardLayout {

    private String cardLayoutId;
    private String cardLayoutDesc;
    private String priorityCd;
    private String languageCd;
    private List<CardImage> cardImage = new ArrayList<CardImage>();

    public String getCardLayoutId() {
        return cardLayoutId;
    }

    public void setCardLayoutId(String cardLayoutId) {
        this.cardLayoutId = cardLayoutId;
    }

    public String getCardLayoutDesc() {
        return cardLayoutDesc;
    }

    public void setCardLayoutDesc(String cardLayoutDesc) {
        this.cardLayoutDesc = cardLayoutDesc;
    }

    public String getPriorityCd() {
        return priorityCd;
    }

    public void setPriorityCd(String priorityCd) {
        this.priorityCd = priorityCd;
    }

    public String getLanguageCd() {
        return languageCd;
    }

    public void setLanguageCd(String languageCd) {
        this.languageCd = languageCd;
    }

    public List<CardImage> getCardImage() {
        return cardImage;
    }

    public void setCardImage(List<CardImage> cardImage) {
        this.cardImage = cardImage;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CardLayout.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("cardLayoutId");
        sb.append('=');
        sb.append(((this.cardLayoutId == null)?"<null>":this.cardLayoutId));
        sb.append(',');
        sb.append("cardLayoutDesc");
        sb.append('=');
        sb.append(((this.cardLayoutDesc == null)?"<null>":this.cardLayoutDesc));
        sb.append(',');
        sb.append("priorityCd");
        sb.append('=');
        sb.append(((this.priorityCd == null)?"<null>":this.priorityCd));
        sb.append(',');
        sb.append("languageCd");
        sb.append('=');
        sb.append(((this.languageCd == null)?"<null>":this.languageCd));
        sb.append(',');
        sb.append("cardImage");
        sb.append('=');
        sb.append(((this.cardImage == null)?"<null>":this.cardImage));
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
        result = ((result* 31)+((this.cardLayoutDesc == null)? 0 :this.cardLayoutDesc.hashCode()));
        result = ((result* 31)+((this.cardImage == null)? 0 :this.cardImage.hashCode()));
        result = ((result* 31)+((this.languageCd == null)? 0 :this.languageCd.hashCode()));
        result = ((result* 31)+((this.priorityCd == null)? 0 :this.priorityCd.hashCode()));
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
        return ((((((this.cardLayoutId == rhs.cardLayoutId)||((this.cardLayoutId!= null)&&this.cardLayoutId.equals(rhs.cardLayoutId)))&&((this.cardLayoutDesc == rhs.cardLayoutDesc)||((this.cardLayoutDesc!= null)&&this.cardLayoutDesc.equals(rhs.cardLayoutDesc))))&&((this.cardImage == rhs.cardImage)||((this.cardImage!= null)&&this.cardImage.equals(rhs.cardImage))))&&((this.languageCd == rhs.languageCd)||((this.languageCd!= null)&&this.languageCd.equals(rhs.languageCd))))&&((this.priorityCd == rhs.priorityCd)||((this.priorityCd!= null)&&this.priorityCd.equals(rhs.priorityCd))));
    }

}
