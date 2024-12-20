package com.td.api.rewards.response.getrewardssaml;

public class RewardsSamlResponse {
	
	private String ssoToken;


    public String getSsoToken() {
		return ssoToken;
	}

	public void setSsoToken(String ssoToken) {
		this.ssoToken = ssoToken;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(RewardsSamlResponse.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("ssoToken");
        sb.append('=');
        sb.append(((this.ssoToken == null)?"<null>":this.ssoToken));
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
        result = ((result* 31)+((this.ssoToken == null)? 0 :this.ssoToken.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RewardsSamlResponse) == false) {
            return false;
        }
        RewardsSamlResponse rhs = ((RewardsSamlResponse) other);
        return ((this.ssoToken == rhs.ssoToken)||((this.ssoToken!= null)&&this.ssoToken.equals(rhs.ssoToken)));
    }

}
