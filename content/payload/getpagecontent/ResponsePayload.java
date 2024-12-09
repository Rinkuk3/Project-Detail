package com.td.mbna.msec.midtier.content.payload.getpagecontent;

import java.io.Serializable;

public class ResponsePayload implements Serializable {

	private static final long serialVersionUID = 1L;
    private String title;
    private String content;
    private String contentContent;
    private String toDisplay;
    private String contentTablet;
    private String contentMobile;
    private String desktopImage;
    private String tabletImage;
    private String mobileImage;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContentContent() {
        return contentContent;
    }

    public void setContentContent(String contentContent) {
        this.contentContent = contentContent;
    }

    public String getToDisplay() {
        return toDisplay;
    }

    public void setToDisplay(String toDisplay) {
        this.toDisplay = toDisplay;
    }

    public String getContentTablet() {
        return contentTablet;
    }

    public void setContentTablet(String contentTablet) {
        this.contentTablet = contentTablet;
    }

    public String getContentMobile() {
        return contentMobile;
    }

    public void setContentMobile(String contentMobile) {
        this.contentMobile = contentMobile;
    }

    public String getDesktopImage() {
        return desktopImage;
    }

    public void setDesktopImage(String desktopImage) {
        this.desktopImage = desktopImage;
    }

    public String getTabletImage() {
        return tabletImage;
    }

    public void setTabletImage(String tabletImage) {
        this.tabletImage = tabletImage;
    }

    public String getMobileImage() {
        return mobileImage;
    }

    public void setMobileImage(String mobileImage) {
        this.mobileImage = mobileImage;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ResponsePayload.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("title");
        sb.append('=');
        sb.append(((this.title == null)?"<null>":this.title));
        sb.append(',');
        sb.append("content");
        sb.append('=');
        sb.append(((this.content == null)?"<null>":this.content));
        sb.append(',');
        sb.append("contentContent");
        sb.append('=');
        sb.append(((this.contentContent == null)?"<null>":this.contentContent));
        sb.append(',');
        sb.append("toDisplay");
        sb.append('=');
        sb.append(((this.toDisplay == null)?"<null>":this.toDisplay));
        sb.append(',');
        sb.append("contentTablet");
        sb.append('=');
        sb.append(((this.contentTablet == null)?"<null>":this.contentTablet));
        sb.append(',');
        sb.append("contentMobile");
        sb.append('=');
        sb.append(((this.contentMobile == null)?"<null>":this.contentMobile));
        sb.append(',');
        sb.append("desktopImage");
        sb.append('=');
        sb.append(((this.desktopImage == null)?"<null>":this.desktopImage));
        sb.append(',');
        sb.append("tabletImage");
        sb.append('=');
        sb.append(((this.tabletImage == null)?"<null>":this.tabletImage));
        sb.append(',');
        sb.append("mobileImage");
        sb.append('=');
        sb.append(((this.mobileImage == null)?"<null>":this.mobileImage));
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
        result = ((result* 31)+((this.tabletImage == null)? 0 :this.tabletImage.hashCode()));
        result = ((result* 31)+((this.contentTablet == null)? 0 :this.contentTablet.hashCode()));
        result = ((result* 31)+((this.mobileImage == null)? 0 :this.mobileImage.hashCode()));
        result = ((result* 31)+((this.contentContent == null)? 0 :this.contentContent.hashCode()));
        result = ((result* 31)+((this.toDisplay == null)? 0 :this.toDisplay.hashCode()));
        result = ((result* 31)+((this.desktopImage == null)? 0 :this.desktopImage.hashCode()));
        result = ((result* 31)+((this.contentMobile == null)? 0 :this.contentMobile.hashCode()));
        result = ((result* 31)+((this.title == null)? 0 :this.title.hashCode()));
        result = ((result* 31)+((this.content == null)? 0 :this.content.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ResponsePayload) == false) {
            return false;
        }
        ResponsePayload rhs = ((ResponsePayload) other);
        return ((((((((((this.tabletImage == rhs.tabletImage)||((this.tabletImage!= null)&&this.tabletImage.equals(rhs.tabletImage)))&&((this.contentTablet == rhs.contentTablet)||((this.contentTablet!= null)&&this.contentTablet.equals(rhs.contentTablet))))&&((this.mobileImage == rhs.mobileImage)||((this.mobileImage!= null)&&this.mobileImage.equals(rhs.mobileImage))))&&((this.contentContent == rhs.contentContent)||((this.contentContent!= null)&&this.contentContent.equals(rhs.contentContent))))&&((this.toDisplay == rhs.toDisplay)||((this.toDisplay!= null)&&this.toDisplay.equals(rhs.toDisplay))))&&((this.desktopImage == rhs.desktopImage)||((this.desktopImage!= null)&&this.desktopImage.equals(rhs.desktopImage))))&&((this.contentMobile == rhs.contentMobile)||((this.contentMobile!= null)&&this.contentMobile.equals(rhs.contentMobile))))&&((this.title == rhs.title)||((this.title!= null)&&this.title.equals(rhs.title))))&&((this.content == rhs.content)||((this.content!= null)&&this.content.equals(rhs.content))));
    }

}
