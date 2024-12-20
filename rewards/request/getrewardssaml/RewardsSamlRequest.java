package com.td.api.rewards.request.getrewardssaml;

public class RewardsSamlRequest {

	private Parameters parameters;
	private String pingConnectionID;
	
	public Parameters getParameters() {
		return parameters;
	}

	public void setParameters(Parameters parameters) {
		this.parameters = parameters;
	}

	public String getPingConnectionID() {
		return pingConnectionID;
	}

	public void setPingConnectionID(String pingConnectionID) {
		this.pingConnectionID = pingConnectionID;
	}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(RewardsSamlRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("parameters");
        sb.append('=');
        sb.append(((this.parameters == null)?"<null>":this.parameters));
        sb.append(',');
        sb.append("pingConnectionID");
        sb.append('=');
        sb.append(((this.pingConnectionID == null)?"<null>":this.pingConnectionID));
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
        result = ((result* 31)+((this.parameters == null)? 0 :this.parameters.hashCode()));
        result = ((result* 31)+((this.pingConnectionID == null)? 0 :this.pingConnectionID.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RewardsSamlRequest) == false) {
            return false;
        }
        RewardsSamlRequest rhs = ((RewardsSamlRequest) other);
        return (((this.parameters == rhs.parameters)||((this.parameters!= null)&&this.parameters.equals(rhs.parameters)))&&((this.pingConnectionID == rhs.pingConnectionID)||((this.pingConnectionID!= null)&&this.pingConnectionID.equals(rhs.pingConnectionID))));
    }

}
