package com.td.mbna.msec.midtier.types.common;

import java.io.Serializable;

public class UserNameType implements Serializable {

	private static final long serialVersionUID = -3332636755001744166L;
    private String firstName;
    private String lastName;
    private String middleName;
    private String suffix;
    private String suffixText;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getSuffixText() {
        return suffixText;
    }

    public void setSuffixText(String suffixText) {
        this.suffixText = suffixText;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(UserNameType.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("firstName");
        sb.append('=');
        sb.append(((this.firstName == null)?"<null>":this.firstName));
        sb.append(',');
        sb.append("lastName");
        sb.append('=');
        sb.append(((this.lastName == null)?"<null>":this.lastName));
        sb.append(',');
        sb.append("middleName");
        sb.append('=');
        sb.append(((this.middleName == null)?"<null>":this.middleName));
        sb.append(',');
        sb.append("suffix");
        sb.append('=');
        sb.append(((this.suffix == null)?"<null>":this.suffix));
        sb.append(',');
        sb.append("suffixText");
        sb.append('=');
        sb.append(((this.suffixText == null)?"<null>":this.suffixText));
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
        result = ((result* 31)+((this.firstName == null)? 0 :this.firstName.hashCode()));
        result = ((result* 31)+((this.lastName == null)? 0 :this.lastName.hashCode()));
        result = ((result* 31)+((this.suffixText == null)? 0 :this.suffixText.hashCode()));
        result = ((result* 31)+((this.middleName == null)? 0 :this.middleName.hashCode()));
        result = ((result* 31)+((this.suffix == null)? 0 :this.suffix.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof UserNameType) == false) {
            return false;
        }
        UserNameType rhs = ((UserNameType) other);
        return ((((((this.firstName == rhs.firstName)||((this.firstName!= null)&&this.firstName.equals(rhs.firstName)))&&((this.lastName == rhs.lastName)||((this.lastName!= null)&&this.lastName.equals(rhs.lastName))))&&((this.suffixText == rhs.suffixText)||((this.suffixText!= null)&&this.suffixText.equals(rhs.suffixText))))&&((this.middleName == rhs.middleName)||((this.middleName!= null)&&this.middleName.equals(rhs.middleName))))&&((this.suffix == rhs.suffix)||((this.suffix!= null)&&this.suffix.equals(rhs.suffix))));
    }

}
