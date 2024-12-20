package com.td.mbna.msec.midtier.pinmanagement.payload.getpin;

public class ResponsePayload {

    private String encryptedPinBlock;
    private String kmsSingleUseKey;
    private String kmsCDV;

    public String getEncryptedPinBlock() {
        return encryptedPinBlock;
    }

    public void setEncryptedPinBlock(String encryptedPinBlock) {
        this.encryptedPinBlock = encryptedPinBlock;
    }

    public String getKmsSingleUseKey() {
        return kmsSingleUseKey;
    }

    public void setKmsSingleUseKey(String kmsSingleUseKey) {
        this.kmsSingleUseKey = kmsSingleUseKey;
    }

    public String getKmsCDV() {
        return kmsCDV;
    }

    public void setKmsCDV(String kmsCDV) {
        this.kmsCDV = kmsCDV;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ResponsePayload.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("encryptedPinBlock");
        sb.append('=');
        sb.append(((this.encryptedPinBlock == null)?"<null>":this.encryptedPinBlock));
        sb.append(',');
        sb.append("kmsSingleUseKey");
        sb.append('=');
        sb.append(((this.kmsSingleUseKey == null)?"<null>":this.kmsSingleUseKey));
        sb.append(',');
        sb.append("kmsCDV");
        sb.append('=');
        sb.append(((this.kmsCDV == null)?"<null>":this.kmsCDV));
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
        result = ((result* 31)+((this.kmsSingleUseKey == null)? 0 :this.kmsSingleUseKey.hashCode()));
        result = ((result* 31)+((this.encryptedPinBlock == null)? 0 :this.encryptedPinBlock.hashCode()));
        result = ((result* 31)+((this.kmsCDV == null)? 0 :this.kmsCDV.hashCode()));
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
        return ((((this.kmsSingleUseKey == rhs.kmsSingleUseKey)||((this.kmsSingleUseKey!= null)&&this.kmsSingleUseKey.equals(rhs.kmsSingleUseKey)))&&((this.encryptedPinBlock == rhs.encryptedPinBlock)||((this.encryptedPinBlock!= null)&&this.encryptedPinBlock.equals(rhs.encryptedPinBlock))))&&((this.kmsCDV == rhs.kmsCDV)||((this.kmsCDV!= null)&&this.kmsCDV.equals(rhs.kmsCDV))));
    }

}
