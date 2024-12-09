package com.td.mbna.msec.midtier.types.common;

import java.io.Serializable;

public class AffinityInfoTypeLanguageSpecific implements Serializable {

	private static final long serialVersionUID = 478177829248909731L;
    private String cardPicture;
    private String mobileCardPicture;
    private String logo;
    private String shortDesc;
    private String longDesc;
    private String cptDescription;

    public String getCardPicture() {
        return cardPicture;
    }

    public void setCardPicture(String cardPicture) {
        this.cardPicture = cardPicture;
    }

    public String getMobileCardPicture() {
        return mobileCardPicture;
    }

    public void setMobileCardPicture(String mobileCardPicture) {
        this.mobileCardPicture = mobileCardPicture;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getLongDesc() {
        return longDesc;
    }

    public void setLongDesc(String longDesc) {
        this.longDesc = longDesc;
    }

    public String getCptDescription() {
        return cptDescription;
    }

    public void setCptDescription(String cptDescription) {
        this.cptDescription = cptDescription;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AffinityInfoTypeLanguageSpecific.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("cardPicture");
        sb.append('=');
        sb.append(((this.cardPicture == null)?"<null>":this.cardPicture));
        sb.append(',');
        sb.append("mobileCardPicture");
        sb.append('=');
        sb.append(((this.mobileCardPicture == null)?"<null>":this.mobileCardPicture));
        sb.append(',');
        sb.append("logo");
        sb.append('=');
        sb.append(((this.logo == null)?"<null>":this.logo));
        sb.append(',');
        sb.append("shortDesc");
        sb.append('=');
        sb.append(((this.shortDesc == null)?"<null>":this.shortDesc));
        sb.append(',');
        sb.append("longDesc");
        sb.append('=');
        sb.append(((this.longDesc == null)?"<null>":this.longDesc));
        sb.append(',');
        sb.append("cptDescription");
        sb.append('=');
        sb.append(((this.cptDescription == null)?"<null>":this.cptDescription));
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
        result = ((result* 31)+((this.mobileCardPicture == null)? 0 :this.mobileCardPicture.hashCode()));
        result = ((result* 31)+((this.cptDescription == null)? 0 :this.cptDescription.hashCode()));
        result = ((result* 31)+((this.cardPicture == null)? 0 :this.cardPicture.hashCode()));
        result = ((result* 31)+((this.logo == null)? 0 :this.logo.hashCode()));
        result = ((result* 31)+((this.shortDesc == null)? 0 :this.shortDesc.hashCode()));
        result = ((result* 31)+((this.longDesc == null)? 0 :this.longDesc.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AffinityInfoTypeLanguageSpecific) == false) {
            return false;
        }
        AffinityInfoTypeLanguageSpecific rhs = ((AffinityInfoTypeLanguageSpecific) other);
        return (((((((this.mobileCardPicture == rhs.mobileCardPicture)||((this.mobileCardPicture!= null)&&this.mobileCardPicture.equals(rhs.mobileCardPicture)))&&((this.cptDescription == rhs.cptDescription)||((this.cptDescription!= null)&&this.cptDescription.equals(rhs.cptDescription))))&&((this.cardPicture == rhs.cardPicture)||((this.cardPicture!= null)&&this.cardPicture.equals(rhs.cardPicture))))&&((this.logo == rhs.logo)||((this.logo!= null)&&this.logo.equals(rhs.logo))))&&((this.shortDesc == rhs.shortDesc)||((this.shortDesc!= null)&&this.shortDesc.equals(rhs.shortDesc))))&&((this.longDesc == rhs.longDesc)||((this.longDesc!= null)&&this.longDesc.equals(rhs.longDesc))));
    }

}
