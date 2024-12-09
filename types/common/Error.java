package com.td.mbna.msec.midtier.types.common;

public class Error {

    protected String errorCode;
    protected String severity;
    protected String errorDescription;


    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }
    

    public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Error.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("errorCode");
        sb.append('=');
        sb.append(((this.errorCode == null)?"<null>":this.errorCode));
        sb.append(',');
        sb.append("severity");
        sb.append('=');
        sb.append(((this.severity == null)?"<null>":this.severity));
        sb.append(',');
        sb.append("errorDescription");
        sb.append('=');
        sb.append(((this.errorDescription == null)?"<null>":this.errorDescription));
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
        result = ((result* 31)+((this.severity == null)? 0 :this.severity.hashCode()));
        result = ((result* 31)+((this.errorCode == null)? 0 :this.errorCode.hashCode()));
        result = ((result* 31)+((this.errorDescription == null)? 0 :this.errorDescription.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Error) == false) {
            return false;
        }
        Error rhs = ((Error) other);
        return (((((this.severity == rhs.severity)||((this.severity!= null)&&this.severity.equals(rhs.severity)))&&((this.errorCode == rhs.errorCode)||((this.errorCode!= null)&&this.errorCode.equals(rhs.errorCode))))&&((this.errorDescription == rhs.errorDescription)||((this.errorDescription!= null)&&this.errorDescription.equals(rhs.errorDescription)))));
    }


}
