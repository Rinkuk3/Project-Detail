package com.td.api.dms.response;

import java.io.Serializable;

public class MetadataItem implements Serializable {

	private static final long serialVersionUID = -5559061928075340342L;
	private String keyName = "";
    private String value = "";

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(MetadataItem.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("keyName");
        sb.append('=');
        sb.append(((this.keyName == null)?"<null>":this.keyName));
        sb.append(',');
        sb.append("value");
        sb.append('=');
        sb.append(((this.value == null)?"<null>":this.value));
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
        result = ((result* 31)+((this.keyName == null)? 0 :this.keyName.hashCode()));
        result = ((result* 31)+((this.value == null)? 0 :this.value.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof MetadataItem) == false) {
            return false;
        }
        MetadataItem rhs = ((MetadataItem) other);
        return (((this.keyName == rhs.keyName)||((this.keyName!= null)&&this.keyName.equals(rhs.keyName)))&&((this.value == rhs.value)||((this.value!= null)&&this.value.equals(rhs.value))));
    }

}
