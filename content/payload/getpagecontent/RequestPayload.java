package com.td.mbna.msec.midtier.content.payload.getpagecontent;

import java.util.HashMap;
import java.util.Map;

import com.td.mbna.msec.midtier.content.payload.PageDisplayStyleType;

public class RequestPayload {

    private String pageId;
    private PageDisplayStyleType pageDisplayStyle;
    private String langId;

    public String getPageId() {
        return pageId;
    }

    public void setPageId(String pageId) {
        this.pageId = pageId;
    }

    public PageDisplayStyleType getPageDisplayStyle() {
        return pageDisplayStyle;
    }

    public void setPageDisplayStyle(PageDisplayStyleType pageDisplayStyle) {
        this.pageDisplayStyle = pageDisplayStyle;
    }

    public String getLangId() {
        return langId;
    }

    public void setLangId(String langId) {
        this.langId = langId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(RequestPayload.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("pageId");
        sb.append('=');
        sb.append(((this.pageId == null)?"<null>":this.pageId));
        sb.append(',');
        sb.append("pageDisplayStyle");
        sb.append('=');
        sb.append(((this.pageDisplayStyle == null)?"<null>":this.pageDisplayStyle));
        sb.append(',');
        sb.append("langId");
        sb.append('=');
        sb.append(((this.langId == null)?"<null>":this.langId));
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
        result = ((result* 31)+((this.pageId == null)? 0 :this.pageId.hashCode()));
        result = ((result* 31)+((this.langId == null)? 0 :this.langId.hashCode()));
        result = ((result* 31)+((this.pageDisplayStyle == null)? 0 :this.pageDisplayStyle.hashCode()));
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
        return ((((this.pageId == rhs.pageId)||((this.pageId!= null)&&this.pageId.equals(rhs.pageId)))&&((this.langId == rhs.langId)||((this.langId!= null)&&this.langId.equals(rhs.langId))))&&((this.pageDisplayStyle == rhs.pageDisplayStyle)||((this.pageDisplayStyle!= null)&&this.pageDisplayStyle.equals(rhs.pageDisplayStyle))));
    }

    public enum PageDisplayStyle {

        REGULAR("REGULAR"),
        POPUP("POPUP");
        private final String value;
        private final static Map<String, RequestPayload.PageDisplayStyle> CONSTANTS = new HashMap<String, RequestPayload.PageDisplayStyle>();

        static {
            for (RequestPayload.PageDisplayStyle c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private PageDisplayStyle(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        public String value() {
            return this.value;
        }

        public static RequestPayload.PageDisplayStyle fromValue(String value) {
            RequestPayload.PageDisplayStyle constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
