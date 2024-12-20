package com.td.api.kms.response;

public class KmsExtension {

    private String initializationVectorVal;
    private String authorizationTagVal;
    private Integer initializationVectorLengthCnt;
    private Integer authorizationTagLengthCnt;

    public String getInitializationVectorVal() {
        return initializationVectorVal;
    }

    public void setInitializationVectorVal(String initializationVectorVal) {
        this.initializationVectorVal = initializationVectorVal;
    }

    public String getAuthorizationTagVal() {
        return authorizationTagVal;
    }

    public void setAuthorizationTagVal(String authorizationTagVal) {
        this.authorizationTagVal = authorizationTagVal;
    }

    public Integer getInitializationVectorLengthCnt() {
        return initializationVectorLengthCnt;
    }

    public void setInitializationVectorLengthCnt(Integer initializationVectorLengthCnt) {
        this.initializationVectorLengthCnt = initializationVectorLengthCnt;
    }

    public Integer getAuthorizationTagLengthCnt() {
        return authorizationTagLengthCnt;
    }

    public void setAuthorizationTagLengthCnt(Integer authorizationTagLengthCnt) {
        this.authorizationTagLengthCnt = authorizationTagLengthCnt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(KmsExtension.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("initializationVectorVal");
        sb.append('=');
        sb.append(((this.initializationVectorVal == null)?"<null>":this.initializationVectorVal));
        sb.append(',');
        sb.append("authorizationTagVal");
        sb.append('=');
        sb.append(((this.authorizationTagVal == null)?"<null>":this.authorizationTagVal));
        sb.append(',');
        sb.append("initializationVectorLengthCnt");
        sb.append('=');
        sb.append(((this.initializationVectorLengthCnt == null)?"<null>":this.initializationVectorLengthCnt));
        sb.append(',');
        sb.append("authorizationTagLengthCnt");
        sb.append('=');
        sb.append(((this.authorizationTagLengthCnt == null)?"<null>":this.authorizationTagLengthCnt));
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
        result = ((result* 31)+((this.authorizationTagVal == null)? 0 :this.authorizationTagVal.hashCode()));
        result = ((result* 31)+((this.initializationVectorVal == null)? 0 :this.initializationVectorVal.hashCode()));
        result = ((result* 31)+((this.authorizationTagLengthCnt == null)? 0 :this.authorizationTagLengthCnt.hashCode()));
        result = ((result* 31)+((this.initializationVectorLengthCnt == null)? 0 :this.initializationVectorLengthCnt.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof KmsExtension) == false) {
            return false;
        }
        KmsExtension rhs = ((KmsExtension) other);
        return (((((this.authorizationTagVal == rhs.authorizationTagVal)||((this.authorizationTagVal!= null)&&this.authorizationTagVal.equals(rhs.authorizationTagVal)))&&((this.initializationVectorVal == rhs.initializationVectorVal)||((this.initializationVectorVal!= null)&&this.initializationVectorVal.equals(rhs.initializationVectorVal))))&&((this.authorizationTagLengthCnt == rhs.authorizationTagLengthCnt)||((this.authorizationTagLengthCnt!= null)&&this.authorizationTagLengthCnt.equals(rhs.authorizationTagLengthCnt))))&&((this.initializationVectorLengthCnt == rhs.initializationVectorLengthCnt)||((this.initializationVectorLengthCnt!= null)&&this.initializationVectorLengthCnt.equals(rhs.initializationVectorLengthCnt))));
    }

}