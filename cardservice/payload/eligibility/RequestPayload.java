package com.td.mbna.msec.midtier.cardservice.payload.eligibility;

import java.util.ArrayList;
import java.util.List;

public class RequestPayload {

    private List<AuthorizedUser> authorizedUsers = new ArrayList<AuthorizedUser>();
    public List<AuthorizedUser> getAuthorizedUsers() {
        return authorizedUsers;
    }

    public void setAuthorizedUsers(List<AuthorizedUser> authorizedUsers) {
        this.authorizedUsers = authorizedUsers;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(RequestPayload.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("authorizedUsers");
        sb.append('=');
        sb.append(((this.authorizedUsers == null)?"<null>":this.authorizedUsers));
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
        result = ((result* 31)+((this.authorizedUsers == null)? 0 :this.authorizedUsers.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RequestPayload) == false) {
            return false;
        }
        RequestPayload rhs = ((RequestPayload) other);
        return ((this.authorizedUsers == rhs.authorizedUsers)||((this.authorizedUsers!= null)&&this.authorizedUsers.equals(rhs.authorizedUsers)));
    }

}
