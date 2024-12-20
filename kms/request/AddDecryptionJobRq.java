package com.td.api.kms.request;

public class AddDecryptionJobRq {

    private DecryptionEvent decryptionEvent;

    public DecryptionEvent getDecryptionEvent() {
        return decryptionEvent;
    }

    public void setDecryptionEvent(DecryptionEvent decryptionEvent) {
        this.decryptionEvent = decryptionEvent;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AddDecryptionJobRq.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("decryptionEvent");
        sb.append('=');
        sb.append(((this.decryptionEvent == null)?"<null>":this.decryptionEvent));
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
        result = ((result* 31)+((this.decryptionEvent == null)? 0 :this.decryptionEvent.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AddDecryptionJobRq) == false) {
            return false;
        }
        AddDecryptionJobRq rhs = ((AddDecryptionJobRq) other);
        return ((this.decryptionEvent == rhs.decryptionEvent)||((this.decryptionEvent!= null)&&this.decryptionEvent.equals(rhs.decryptionEvent)));
    }

}
