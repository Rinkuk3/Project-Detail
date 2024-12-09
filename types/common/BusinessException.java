package com.td.mbna.msec.midtier.types.common;

public class BusinessException extends ExceptionInfo {

	private String errorSource;

	public String getErrorSource() {
		return errorSource;
	}

	public void setErrorSource(String errorSource) {
		this.errorSource = errorSource;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(BusinessException.class.getName()).append('@')
				.append(Integer.toHexString(System.identityHashCode(this)))
				.append('[');
		sb.append("errorSource");
		sb.append('=');
		sb.append(((this.errorSource == null) ? "<null>" : this.errorSource));
		sb.append(',');
		if (sb.charAt((sb.length() - 1)) == ',') {
			sb.setCharAt((sb.length() - 1), ']');
		} else {
			sb.append(']');
		}
		return sb.toString();
	}

	@Override
	public int hashCode() {
		int result = 1;
		result = ((result * 31) + ((this.errorSource == null) ? 0
				: this.errorSource.hashCode()));
		return result;
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof BusinessException) == false) {
			return false;
		}
		BusinessException rhs = ((BusinessException) other);
		return (this.errorSource == rhs.errorSource)
				|| ((this.errorSource != null) && this.errorSource
						.equals(rhs.errorSource));
	}

}
