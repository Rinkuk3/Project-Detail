package com.td.api.mbofp.request.updateofferdisposition;

public class Party {

    private String roleCd;

    public String getRoleCd() {
        return roleCd;
    }

    public void setRoleCd(String roleCd) {
        this.roleCd = roleCd;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Party.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("roleCd");
        sb.append('=');
        sb.append(((this.roleCd == null)?"<null>":this.roleCd));
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
        return ((this.roleCd == rhs.roleCd)||((this.roleCd!= null)&&this.roleCd.equals(rhs.roleCd)));
    }

}
