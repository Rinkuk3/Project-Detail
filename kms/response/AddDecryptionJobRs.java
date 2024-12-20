package com.td.api.kms.response;

import java.util.ArrayList;
import java.util.List;

public class AddDecryptionJobRs {

    private List<CryptographyKey> cryptographyKey = new ArrayList<CryptographyKey>();
    private Data data;

    public List<CryptographyKey> getCryptographyKey() {
        return cryptographyKey;
    }

    public void setCryptographyKey(List<CryptographyKey> cryptographyKey) {
        this.cryptographyKey = cryptographyKey;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AddDecryptionJobRs.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("cryptographyKey");
        sb.append('=');
        sb.append(((this.cryptographyKey == null)?"<null>":this.cryptographyKey));
        sb.append(',');
        sb.append("data");
        sb.append('=');
        sb.append(((this.data == null)?"<null>":this.data));
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
        result = ((result* 31)+((this.data == null)? 0 :this.data.hashCode()));
        result = ((result* 31)+((this.cryptographyKey == null)? 0 :this.cryptographyKey.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AddDecryptionJobRs) == false) {
            return false;
        }
        AddDecryptionJobRs rhs = ((AddDecryptionJobRs) other);
        return (((this.data == rhs.data)||((this.data!= null)&&this.data.equals(rhs.data)))&&((this.cryptographyKey == rhs.cryptographyKey)||((this.cryptographyKey!= null)&&this.cryptographyKey.equals(rhs.cryptographyKey))));
    }

}
