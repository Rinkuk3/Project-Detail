package com.td.mbna.msec.midtier.types.common;

import java.io.Serializable;

public class AffinitySpecType implements Serializable {

	private static final long serialVersionUID = -3470365706705811642L;
    private String tsysProductCode;
    private String clientProductCode;
    private String miscInfo;

    public String getTsysProductCode() {
        return tsysProductCode;
    }

    public void setTsysProductCode(String tsysProductCode) {
        this.tsysProductCode = tsysProductCode;
    }

    public String getClientProductCode() {
        return clientProductCode;
    }

    public void setClientProductCode(String clientProductCode) {
        this.clientProductCode = clientProductCode;
    }

    public String getMiscInfo() {
        return miscInfo;
    }

    public void setMiscInfo(String miscInfo) {
        this.miscInfo = miscInfo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AffinitySpecType.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("tsysProductCode");
        sb.append('=');
        sb.append(((this.tsysProductCode == null)?"<null>":this.tsysProductCode));
        sb.append(',');
        sb.append("clientProductCode");
        sb.append('=');
        sb.append(((this.clientProductCode == null)?"<null>":this.clientProductCode));
        sb.append(',');
        sb.append("miscInfo");
        sb.append('=');
        sb.append(((this.miscInfo == null)?"<null>":this.miscInfo));
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
        result = ((result* 31)+((this.tsysProductCode == null)? 0 :this.tsysProductCode.hashCode()));
        result = ((result* 31)+((this.miscInfo == null)? 0 :this.miscInfo.hashCode()));
        result = ((result* 31)+((this.clientProductCode == null)? 0 :this.clientProductCode.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AffinitySpecType) == false) {
            return false;
        }
        AffinitySpecType rhs = ((AffinitySpecType) other);
        return ((((this.tsysProductCode == rhs.tsysProductCode)||((this.tsysProductCode!= null)&&this.tsysProductCode.equals(rhs.tsysProductCode)))&&((this.miscInfo == rhs.miscInfo)||((this.miscInfo!= null)&&this.miscInfo.equals(rhs.miscInfo))))&&((this.clientProductCode == rhs.clientProductCode)||((this.clientProductCode!= null)&&this.clientProductCode.equals(rhs.clientProductCode))));
    }

}
