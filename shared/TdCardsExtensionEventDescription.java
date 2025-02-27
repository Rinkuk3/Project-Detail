package com.td.api.mbcca.shared;

public class TdCardsExtensionEventDescription {

    private String eventDescriptionTxt;

    public String getEventDescriptionTxt() {
        return eventDescriptionTxt;
    }

    public void setEventDescriptionTxt(String eventDescriptionTxt) {
        this.eventDescriptionTxt = eventDescriptionTxt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TdCardsExtensionEventDescription.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("eventDescriptionTxt");
        sb.append('=');
        sb.append(((this.eventDescriptionTxt == null)?"<null>":this.eventDescriptionTxt));
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
        result = ((result* 31)+((this.eventDescriptionTxt == null)? 0 :this.eventDescriptionTxt.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TdCardsExtensionEventDescription) == false) {
            return false;
        }
        TdCardsExtensionEventDescription rhs = ((TdCardsExtensionEventDescription) other);
        return ((this.eventDescriptionTxt == rhs.eventDescriptionTxt)||((this.eventDescriptionTxt!= null)&&this.eventDescriptionTxt.equals(rhs.eventDescriptionTxt)));
    }

}
