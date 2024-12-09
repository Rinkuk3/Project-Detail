package com.td.mbna.msec.midtier.content.payload;

public class LinkContentType {

    private String link;
    private String altText;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getAltText() {
        return altText;
    }

    public void setAltText(String altText) {
        this.altText = altText;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(LinkContentType.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("link");
        sb.append('=');
        sb.append(((this.link == null)?"<null>":this.link));
        sb.append(',');
        sb.append("altText");
        sb.append('=');
        sb.append(((this.altText == null)?"<null>":this.altText));
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
        result = ((result* 31)+((this.link == null)? 0 :this.link.hashCode()));
        result = ((result* 31)+((this.altText == null)? 0 :this.altText.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof LinkContentType) == false) {
            return false;
        }
        LinkContentType rhs = ((LinkContentType) other);
        return (((this.link == rhs.link)||((this.link!= null)&&this.link.equals(rhs.link)))&&((this.altText == rhs.altText)||((this.altText!= null)&&this.altText.equals(rhs.altText))));
    }

}
