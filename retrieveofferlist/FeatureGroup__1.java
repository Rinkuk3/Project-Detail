package com.td.api.mbofp.response.retrieveofferlist;

import java.util.ArrayList;
import java.util.List;

public class FeatureGroup__1 {

    private List<CardLayout> cardLayout = new ArrayList<CardLayout>();

    public List<CardLayout> getCardLayout() {
        return cardLayout;
    }

    public void setCardLayout(List<CardLayout> cardLayout) {
        this.cardLayout = cardLayout;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(FeatureGroup__1 .class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("cardLayout");
        sb.append('=');
        sb.append(((this.cardLayout == null)?"<null>":this.cardLayout));
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
        result = ((result* 31)+((this.cardLayout == null)? 0 :this.cardLayout.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof FeatureGroup__1) == false) {
            return false;
        }
        FeatureGroup__1 rhs = ((FeatureGroup__1) other);
        return ((this.cardLayout == rhs.cardLayout)||((this.cardLayout!= null)&&this.cardLayout.equals(rhs.cardLayout)));
    }

}
