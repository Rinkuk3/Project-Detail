package com.td.api.kms.request;

public class AddEncryptionJobRq {

    private EncryptionEvent encryptionEvent;

    public EncryptionEvent getEncryptionEvent() {
        return encryptionEvent;
    }

    public void setEncryptionEvent(EncryptionEvent encryptionEvent) {
        this.encryptionEvent = encryptionEvent;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AddEncryptionJobRq.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("encryptionEvent");
        sb.append('=');
        sb.append(((this.encryptionEvent == null)?"<null>":this.encryptionEvent));
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
        result = ((result* 31)+((this.encryptionEvent == null)? 0 :this.encryptionEvent.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AddEncryptionJobRq) == false) {
            return false;
        }
        AddEncryptionJobRq rhs = ((AddEncryptionJobRq) other);
        return ((this.encryptionEvent == rhs.encryptionEvent)||((this.encryptionEvent!= null)&&this.encryptionEvent.equals(rhs.encryptionEvent)));
    }

}
