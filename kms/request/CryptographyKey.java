package com.td.api.kms.request;

public class CryptographyKey {

	
    private String encodingSchemeTypeCd;
    private String typeName;
    private String keyId;
    private String keyVal;
    private String indexVal;
    private String checkDigitVal;
    private KmsExtension kmsExtension;

    public String getEncodingSchemeTypeCd() {
        return encodingSchemeTypeCd;
    }

    public void setEncodingSchemeTypeCd(String encodingSchemeTypeCd) {
        this.encodingSchemeTypeCd = encodingSchemeTypeCd;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getKeyId() {
        return keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }

    public String getKeyVal() {
        return keyVal;
    }

    public void setKeyVal(String keyVal) {
        this.keyVal = keyVal;
    }

    public String getIndexVal() {
        return indexVal;
    }

    public void setIndexVal(String indexVal) {
        this.indexVal = indexVal;
    }

    public String getCheckDigitVal() {
        return checkDigitVal;
    }

    public void setCheckDigitVal(String checkDigitVal) {
        this.checkDigitVal = checkDigitVal;
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
        sb.append(CryptographyKey.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("encodingSchemeTypeCd");
        sb.append('=');
        sb.append(((this.encodingSchemeTypeCd == null)?"<null>":this.encodingSchemeTypeCd));
        sb.append(',');
        sb.append("typeName");
        sb.append('=');
        sb.append(((this.typeName == null)?"<null>":this.typeName));
        sb.append(',');
        sb.append("keyId");
        sb.append('=');
        sb.append(((this.keyId == null)?"<null>":this.keyId));
        sb.append(',');
        sb.append("keyVal");
        sb.append('=');
        sb.append(((this.keyVal == null)?"<null>":this.keyVal));
        sb.append(',');
        sb.append("indexVal");
        sb.append('=');
        sb.append(((this.indexVal == null)?"<null>":this.indexVal));
        sb.append(',');
        sb.append("checkDigitVal");
        sb.append('=');
        sb.append(((this.checkDigitVal == null)?"<null>":this.checkDigitVal));
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
        result = ((result* 31)+((this.kmsExtension == null)? 0 :this.kmsExtension.hashCode()));
        result = ((result* 31)+((this.typeName == null)? 0 :this.typeName.hashCode()));
        result = ((result* 31)+((this.keyId == null)? 0 :this.keyId.hashCode()));
        result = ((result* 31)+((this.encodingSchemeTypeCd == null)? 0 :this.encodingSchemeTypeCd.hashCode()));
        result = ((result* 31)+((this.indexVal == null)? 0 :this.indexVal.hashCode()));
        result = ((result* 31)+((this.keyVal == null)? 0 :this.keyVal.hashCode()));
        result = ((result* 31)+((this.checkDigitVal == null)? 0 :this.checkDigitVal.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CryptographyKey) == false) {
            return false;
        }
        CryptographyKey rhs = ((CryptographyKey) other);
        return ((((((((this.kmsExtension == rhs.kmsExtension)||((this.kmsExtension!= null)&&this.kmsExtension.equals(rhs.kmsExtension)))&&((this.typeName == rhs.typeName)||((this.typeName!= null)&&this.typeName.equals(rhs.typeName))))&&((this.keyId == rhs.keyId)||((this.keyId!= null)&&this.keyId.equals(rhs.keyId))))&&((this.encodingSchemeTypeCd == rhs.encodingSchemeTypeCd)||((this.encodingSchemeTypeCd!= null)&&this.encodingSchemeTypeCd.equals(rhs.encodingSchemeTypeCd))))&&((this.indexVal == rhs.indexVal)||((this.indexVal!= null)&&this.indexVal.equals(rhs.indexVal))))&&((this.keyVal == rhs.keyVal)||((this.keyVal!= null)&&this.keyVal.equals(rhs.keyVal))))&&((this.checkDigitVal == rhs.checkDigitVal)||((this.checkDigitVal!= null)&&this.checkDigitVal.equals(rhs.checkDigitVal))));
    }

}
