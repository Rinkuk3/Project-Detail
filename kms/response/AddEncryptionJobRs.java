package com.td.api.kms.response;

import java.util.ArrayList;
import java.util.List;

public class AddEncryptionJobRs {

    private List<CryptographyKey> cryptographyKey = new ArrayList<CryptographyKey>();
    private CipherData cipherData;
    private Hash hash;

    public List<CryptographyKey> getCryptographyKey() {
        return cryptographyKey;
    }

    public void setCryptographyKey(List<CryptographyKey> cryptographyKey) {
        this.cryptographyKey = cryptographyKey;
    }

    public CipherData getCipherData() {
        return cipherData;
    }

    public void setCipherData(CipherData cipherData) {
        this.cipherData = cipherData;
    }

    public Hash getHash() {
        return hash;
    }

    public void setHash(Hash hash) {
        this.hash = hash;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AddEncryptionJobRs.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("cryptographyKey");
        sb.append('=');
        sb.append(((this.cryptographyKey == null)?"<null>":this.cryptographyKey));
        sb.append(',');
        sb.append("cipherData");
        sb.append('=');
        sb.append(((this.cipherData == null)?"<null>":this.cipherData));
        sb.append(',');
        sb.append("hash");
        sb.append('=');
        sb.append(((this.hash == null)?"<null>":this.hash));
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
        result = ((result* 31)+((this.cipherData == null)? 0 :this.cipherData.hashCode()));
        result = ((result* 31)+((this.cryptographyKey == null)? 0 :this.cryptographyKey.hashCode()));
        result = ((result* 31)+((this.hash == null)? 0 :this.hash.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AddEncryptionJobRs) == false) {
            return false;
        }
        AddEncryptionJobRs rhs = ((AddEncryptionJobRs) other);
        return ((((this.cipherData == rhs.cipherData)||((this.cipherData!= null)&&this.cipherData.equals(rhs.cipherData)))&&((this.cryptographyKey == rhs.cryptographyKey)||((this.cryptographyKey!= null)&&this.cryptographyKey.equals(rhs.cryptographyKey))))&&((this.hash == rhs.hash)||((this.hash!= null)&&this.hash.equals(rhs.hash))));
    }

}
