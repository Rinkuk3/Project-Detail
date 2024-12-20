package com.td.api.kms.request;

import java.util.ArrayList;
import java.util.List;

public class Party {

    private List<String> roleCd = new ArrayList<String>();
    private List<Name> name = new ArrayList<Name>();

    public List<String> getRoleCd() {
        return roleCd;
    }

    public void setRoleCd(List<String> roleCd) {
        this.roleCd = roleCd;
    }

    public List<Name> getName() {
        return name;
    }

    public void setName(List<Name> name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Party.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("roleCd");
        sb.append('=');
        sb.append(((this.roleCd == null)?"<null>":this.roleCd));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
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
        result = ((result* 31)+((this.roleCd == null)? 0 :this.roleCd.hashCode()));
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Party) == false) {
            return false;
        }
        Party rhs = ((Party) other);
        return (((this.roleCd == rhs.roleCd)||((this.roleCd!= null)&&this.roleCd.equals(rhs.roleCd)))&&((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name))));
    }

}
