package com.td.api.kms.response;

public class CipherData {

    private String encodingSchemeTypeCd;
    private String cipherTxt;
    private Integer lengthCnt;
    private KmsExtension kmsExtension;

    public String getEncodingSchemeTypeCd() {
        return encodingSchemeTypeCd;
    }

    public void setEncodingSchemeTypeCd(String encodingSchemeTypeCd) {
        this.encodingSchemeTypeCd = encodingSchemeTypeCd;
    }

    public String getCipherTxt() {
        return cipherTxt;
    }

    public void setCipherTxt(String cipherTxt) {
        this.cipherTxt = cipherTxt;
    }

    public Integer getLengthCnt() {
        return lengthCnt;
    }

    public void setLengthCnt(Integer lengthCnt) {
        this.lengthCnt = lengthCnt;
    }

    public KmsExtension getKmsExtension() {
        return kmsExtension;
    }

    public void setKmsExtension(KmsExtension kmsExtension) {
        this.kmsExtension = kmsExtension;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CipherData.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("encodingSchemeTypeCd");
        sb.append('=');
        sb.append(((this.encodingSchemeTypeCd == null)?"<null>":this.encodingSchemeTypeCd));
        sb.append(',');
        sb.append("cipherTxt");
        sb.append('=');
        sb.append(((this.cipherTxt == null)?"<null>":this.cipherTxt));
        sb.append(',');
        sb.append("lengthCnt");
        sb.append('=');
        sb.append(((this.lengthCnt == null)?"<null>":this.lengthCnt));
        sb.append(',');
        sb.append("kmsExtension");
        sb.append('=');
        sb.append(((this.kmsExtension == null)?"<null>":this.kmsExtension));
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
        result = ((result* 31)+((this.lengthCnt == null)? 0 :this.lengthCnt.hashCode()));
        result = ((result* 31)+((this.encodingSchemeTypeCd == null)? 0 :this.encodingSchemeTypeCd.hashCode()));
        result = ((result* 31)+((this.kmsExtension == null)? 0 :this.kmsExtension.hashCode()));
        result = ((result* 31)+((this.cipherTxt == null)? 0 :this.cipherTxt.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CipherData) == false) {
            return false;
        }
        CipherData rhs = ((CipherData) other);
        return (((((this.lengthCnt == rhs.lengthCnt)||((this.lengthCnt!= null)&&this.lengthCnt.equals(rhs.lengthCnt)))&&((this.encodingSchemeTypeCd == rhs.encodingSchemeTypeCd)||((this.encodingSchemeTypeCd!= null)&&this.encodingSchemeTypeCd.equals(rhs.encodingSchemeTypeCd))))&&((this.kmsExtension == rhs.kmsExtension)||((this.kmsExtension!= null)&&this.kmsExtension.equals(rhs.kmsExtension))))&&((this.cipherTxt == rhs.cipherTxt)||((this.cipherTxt!= null)&&this.cipherTxt.equals(rhs.cipherTxt))));
    }

}
