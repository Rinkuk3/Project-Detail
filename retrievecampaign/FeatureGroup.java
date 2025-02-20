package com.td.api.mbofp.response.retrievecampaign;

public class FeatureGroup {

    private CardLayout cardLayout;
    private PlasticEmbossing plasticEmbossing;

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public void setCardLayout(CardLayout cardLayout) {
        this.cardLayout = cardLayout;
    }

    public PlasticEmbossing getPlasticEmbossing() {
        return plasticEmbossing;
    }

    public void setPlasticEmbossing(PlasticEmbossing plasticEmbossing) {
        this.plasticEmbossing = plasticEmbossing;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(FeatureGroup.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("cardLayout");
        sb.append('=');
        sb.append(((this.cardLayout == null)?"<null>":this.cardLayout));
        sb.append(',');
        sb.append("plasticEmbossing");
        sb.append('=');
        sb.append(((this.plasticEmbossing == null)?"<null>":this.plasticEmbossing));
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
        result = ((result* 31)+((this.plasticEmbossing == null)? 0 :this.plasticEmbossing.hashCode()));
        result = ((result* 31)+((this.cardLayout == null)? 0 :this.cardLayout.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof FeatureGroup) == false) {
            return false;
        }
        FeatureGroup rhs = ((FeatureGroup) other);
        return (((this.plasticEmbossing == rhs.plasticEmbossing)||((this.plasticEmbossing!= null)&&this.plasticEmbossing.equals(rhs.plasticEmbossing)))&&((this.cardLayout == rhs.cardLayout)||((this.cardLayout!= null)&&this.cardLayout.equals(rhs.cardLayout))));
    }

}
