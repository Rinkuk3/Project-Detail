package com.td.api.kms.request;

public class RequestCriterium {

    private String propertyTypeCd;
    private String propertyVal;

    public String getPropertyTypeCd() {
        return propertyTypeCd;
    }

    public void setPropertyTypeCd(String propertyTypeCd) {
        this.propertyTypeCd = propertyTypeCd;
    }

    public String getPropertyVal() {
        return propertyVal;
    }

    public void setPropertyVal(String propertyVal) {
        this.propertyVal = propertyVal;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(RequestCriterium.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("propertyTypeCd");
        sb.append('=');
        sb.append(((this.propertyTypeCd == null)?"<null>":this.propertyTypeCd));
        sb.append(',');
        sb.append("propertyVal");
        sb.append('=');
        sb.append(((this.propertyVal == null)?"<null>":this.propertyVal));
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
        result = ((result* 31)+((this.propertyTypeCd == null)? 0 :this.propertyTypeCd.hashCode()));
        result = ((result* 31)+((this.propertyVal == null)? 0 :this.propertyVal.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RequestCriterium) == false) {
            return false;
        }
        RequestCriterium rhs = ((RequestCriterium) other);
        return (((this.propertyTypeCd == rhs.propertyTypeCd)||((this.propertyTypeCd!= null)&&this.propertyTypeCd.equals(rhs.propertyTypeCd)))&&((this.propertyVal == rhs.propertyVal)||((this.propertyVal!= null)&&this.propertyVal.equals(rhs.propertyVal))));
    }

}
