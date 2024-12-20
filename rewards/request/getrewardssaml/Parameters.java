package com.td.api.rewards.request.getrewardssaml;

import java.io.Serializable;

public class Parameters implements Serializable {

	private static final long serialVersionUID = -3937025825349214072L;
	
	private String subject;
	private String accountId;
    private String locale;
    
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}

    public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	
    public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Parameters.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("subject");
        sb.append('=');
        sb.append(((this.subject == null)?"<null>":this.subject));
        sb.append(',');
        sb.append("accountId");
        sb.append('=');
        sb.append(((this.accountId == null)?"<null>":this.accountId));
        sb.append(',');
        sb.append("locale");
        sb.append('=');
        sb.append(((this.locale == null)?"<null>":this.locale));
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
        result = ((result* 31)+((this.subject == null)? 0 :this.subject.hashCode()));
        result = ((result* 31)+((this.accountId == null)? 0 :this.accountId.hashCode()));
        result = ((result* 31)+((this.locale == null)? 0 :this.locale.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Parameters) == false) {
            return false;
        }
        Parameters rhs = ((Parameters) other);
        return (((((this.subject == rhs.subject)||((this.subject!= null)&&this.subject.equals(rhs.subject))))&&((this.accountId == rhs.accountId)||((this.accountId!= null)&&this.accountId.equals(rhs.accountId))))&&((this.locale == rhs.locale)||((this.locale!= null)&&this.locale.equals(rhs.locale))));
    }

}
