package com.td.mbna.msec.midtier.content.payload.getlinkcontent;

public class RequestPayload {

    private String contentId;
    private String langId;
    private String path;

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public String getLangId() {
        return langId;
    }

    public void setLangId(String langId) {
        this.langId = langId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(RequestPayload.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("contentId");
        sb.append('=');
        sb.append(((this.contentId == null)?"<null>":this.contentId));
        sb.append(',');
        sb.append("langId");
        sb.append('=');
        sb.append(((this.langId == null)?"<null>":this.langId));
        sb.append(',');
        sb.append("path");
        sb.append('=');
        sb.append(((this.path == null)?"<null>":this.path));
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
        result = ((result* 31)+((this.contentId == null)? 0 :this.contentId.hashCode()));
        result = ((result* 31)+((this.path == null)? 0 :this.path.hashCode()));
        result = ((result* 31)+((this.langId == null)? 0 :this.langId.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RequestPayload) == false) {
            return false;
        }
        RequestPayload rhs = ((RequestPayload) other);
        return ((((this.contentId == rhs.contentId)||((this.contentId!= null)&&this.contentId.equals(rhs.contentId)))&&((this.path == rhs.path)||((this.path!= null)&&this.path.equals(rhs.path))))&&((this.langId == rhs.langId)||((this.langId!= null)&&this.langId.equals(rhs.langId))));
    }

}
