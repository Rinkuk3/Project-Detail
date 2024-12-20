package com.td.mbna.msec.midtier.mbnaad.request.response;

public class Card {

    private ChipCard chipCard;

    public ChipCard getChipCard() {
        return chipCard;
    }

    public void setChipCard(ChipCard chipCard) {
        this.chipCard = chipCard;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Card.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("chipCard");
        sb.append('=');
        sb.append(((this.chipCard == null)?"<null>":this.chipCard));
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
        result = ((result* 31)+((this.chipCard == null)? 0 :this.chipCard.hashCode()));
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
        return ((this.chipCard == rhs.chipCard)||((this.chipCard!= null)&&this.chipCard.equals(rhs.chipCard)));
    }

}
