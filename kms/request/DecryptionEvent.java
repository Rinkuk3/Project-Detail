package com.td.api.kms.request;

import java.util.ArrayList;
import java.util.List;

public class DecryptionEvent {

    private Party party;
    private String encryptionMethodCd;
    private List<CryptographyKey> cryptographyKey = new ArrayList<CryptographyKey>();
    private CipherData cipherData;

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }

    public String getEncryptionMethodCd() {
        return encryptionMethodCd;
    }

    public void setEncryptionMethodCd(String encryptionMethodCd) {
        this.encryptionMethodCd = encryptionMethodCd;
    }

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(DecryptionEvent.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("party");
        sb.append('=');
        sb.append(((this.party == null)?"<null>":this.party));
        sb.append(',');
        sb.append("encryptionMethodCd");
        sb.append('=');
        sb.append(((this.encryptionMethodCd == null)?"<null>":this.encryptionMethodCd));
        sb.append(',');
        sb.append("cryptographyKey");
        sb.append('=');
        sb.append(((this.cryptographyKey == null)?"<null>":this.cryptographyKey));
        sb.append(',');
        sb.append("cipherData");
        sb.append('=');
        sb.append(((this.cipherData == null)?"<null>":this.cipherData));
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
        result = ((result* 31)+((this.encryptionMethodCd == null)? 0 :this.encryptionMethodCd.hashCode()));
        result = ((result* 31)+((this.cipherData == null)? 0 :this.cipherData.hashCode()));
        result = ((result* 31)+((this.cryptographyKey == null)? 0 :this.cryptographyKey.hashCode()));
        result = ((result* 31)+((this.party == null)? 0 :this.party.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DecryptionEvent) == false) {
            return false;
        }
        DecryptionEvent rhs = ((DecryptionEvent) other);
        return (((((this.encryptionMethodCd == rhs.encryptionMethodCd)||((this.encryptionMethodCd!= null)&&this.encryptionMethodCd.equals(rhs.encryptionMethodCd)))&&((this.cipherData == rhs.cipherData)||((this.cipherData!= null)&&this.cipherData.equals(rhs.cipherData))))&&((this.cryptographyKey == rhs.cryptographyKey)||((this.cryptographyKey!= null)&&this.cryptographyKey.equals(rhs.cryptographyKey))))&&((this.party == rhs.party)||((this.party!= null)&&this.party.equals(rhs.party))));
    }

}
