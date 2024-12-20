package com.td.api.kms.request;

import java.util.ArrayList;
import java.util.List;

public class EncryptionEvent {

    private Party party;
    private String encryptionMethodCd;
    private List<CryptographyKey> cryptographyKey = new ArrayList<CryptographyKey>();
    private Data data;
    private AdditionalAuthenticationData additionalAuthenticationData;
    private KmsExtension kmsExtension;

    /**
     * Party who is involved with an event as specified by the event role.
     * 
     */
    public Party getParty() {
        return party;
    }

    /**
     * Party who is involved with an event as specified by the event role.
     * 
     */
    public void setParty(Party party) {
        this.party = party;
    }

    /**
     * Encryption algorithm used to transforming plain text to cipher text e.g.

     * DES - Default if not provided

     * AES

     * RSA

     *  3DES - Maps to DES
     * 
     */
    public String getEncryptionMethodCd() {
        return encryptionMethodCd;
    }

    /**
     * Encryption algorithm used to transforming plain text to cipher text e.g.

     * DES - Default if not provided

     * AES

     * RSA

     *  3DES - Maps to DES
     * 
     */
    public void setEncryptionMethodCd(String encryptionMethodCd) {
        this.encryptionMethodCd = encryptionMethodCd;
    }

    /**
     * A piece of information (a parameter) that determines the functional output of a cryptographic algorithm.
     * 
     */
    public List<CryptographyKey> getCryptographyKey() {
        return cryptographyKey;
    }

    /**
     * A piece of information (a parameter) that determines the functional output of a cryptographic algorithm.
     * 
     */
    public void setCryptographyKey(List<CryptographyKey> cryptographyKey) {
        this.cryptographyKey = cryptographyKey;
    }

    /**
     * Customer data to be encrypted.
     * (Required)
     * 
     */
    public Data getData() {
        return data;
    }

    /**
     * Customer data to be encrypted.
     * (Required)
     * 
     */
    public void setData(Data data) {
        this.data = data;
    }

    /**
     * Additional Authentication Data (AAD) that consumer may specify to be used by the encryption process.  AAD is authenticated but not encrypted. It can be used to authenticate plaintext packet headers.
     * 
     */
    public AdditionalAuthenticationData getAdditionalAuthenticationData() {
        return additionalAuthenticationData;
    }

    /**
     * Additional Authentication Data (AAD) that consumer may specify to be used by the encryption process.  AAD is authenticated but not encrypted. It can be used to authenticate plaintext packet headers.
     * 
     */
    public void setAdditionalAuthenticationData(AdditionalAuthenticationData additionalAuthenticationData) {
        this.additionalAuthenticationData = additionalAuthenticationData;
    }

    /**
     * Encryption event KMS extension segment.
     * 
     */
    public KmsExtension getKmsExtension() {
        return kmsExtension;
    }

    /**
     * Encryption event KMS extension segment.
     * 
     */
    public void setKmsExtension(KmsExtension kmsExtension) {
        this.kmsExtension = kmsExtension;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(EncryptionEvent.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
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
        sb.append("data");
        sb.append('=');
        sb.append(((this.data == null)?"<null>":this.data));
        sb.append(',');
        sb.append("additionalAuthenticationData");
        sb.append('=');
        sb.append(((this.additionalAuthenticationData == null)?"<null>":this.additionalAuthenticationData));
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
        result = ((result* 31)+((this.data == null)? 0 :this.data.hashCode()));
        result = ((result* 31)+((this.additionalAuthenticationData == null)? 0 :this.additionalAuthenticationData.hashCode()));
        result = ((result* 31)+((this.encryptionMethodCd == null)? 0 :this.encryptionMethodCd.hashCode()));
        result = ((result* 31)+((this.cryptographyKey == null)? 0 :this.cryptographyKey.hashCode()));
        result = ((result* 31)+((this.party == null)? 0 :this.party.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof EncryptionEvent) == false) {
            return false;
        }
        EncryptionEvent rhs = ((EncryptionEvent) other);
        return (((((((this.kmsExtension == rhs.kmsExtension)||((this.kmsExtension!= null)&&this.kmsExtension.equals(rhs.kmsExtension)))&&((this.data == rhs.data)||((this.data!= null)&&this.data.equals(rhs.data))))&&((this.additionalAuthenticationData == rhs.additionalAuthenticationData)||((this.additionalAuthenticationData!= null)&&this.additionalAuthenticationData.equals(rhs.additionalAuthenticationData))))&&((this.encryptionMethodCd == rhs.encryptionMethodCd)||((this.encryptionMethodCd!= null)&&this.encryptionMethodCd.equals(rhs.encryptionMethodCd))))&&((this.cryptographyKey == rhs.cryptographyKey)||((this.cryptographyKey!= null)&&this.cryptographyKey.equals(rhs.cryptographyKey))))&&((this.party == rhs.party)||((this.party!= null)&&this.party.equals(rhs.party))));
    }

}
