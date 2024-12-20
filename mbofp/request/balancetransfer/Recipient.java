package com.td.api.mbofp.request.balancetransfer;

public class Recipient {

    private String fullName;
    private String individualFirstName;
    private String individualLastName;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getIndividualFirstName() {
        return individualFirstName;
    }

    public void setIndividualFirstName(String individualFirstName) {
        this.individualFirstName = individualFirstName;
    }

    public String getIndividualLastName() {
        return individualLastName;
    }

    public void setIndividualLastName(String individualLastName) {
        this.individualLastName = individualLastName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Recipient.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("fullName");
        sb.append('=');
        sb.append(((this.fullName == null)?"<null>":this.fullName));
        sb.append(',');
        sb.append("individualFirstName");
        sb.append('=');
        sb.append(((this.individualFirstName == null)?"<null>":this.individualFirstName));
        sb.append(',');
        sb.append("individualLastName");
        sb.append('=');
        sb.append(((this.individualLastName == null)?"<null>":this.individualLastName));
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
        result = ((result* 31)+((this.individualFirstName == null)? 0 :this.individualFirstName.hashCode()));
        result = ((result* 31)+((this.fullName == null)? 0 :this.fullName.hashCode()));
        result = ((result* 31)+((this.individualLastName == null)? 0 :this.individualLastName.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Recipient) == false) {
            return false;
        }
        Recipient rhs = ((Recipient) other);
        return ((((this.individualFirstName == rhs.individualFirstName)||((this.individualFirstName!= null)&&this.individualFirstName.equals(rhs.individualFirstName)))&&((this.fullName == rhs.fullName)||((this.fullName!= null)&&this.fullName.equals(rhs.fullName))))&&((this.individualLastName == rhs.individualLastName)||((this.individualLastName!= null)&&this.individualLastName.equals(rhs.individualLastName))));
    }

}
