package com.td.mbna.msec.midtier.creditcard.payload;

public class BusinessException extends Throwable {

	private static final long serialVersionUID = 1L;
	
	private com.td.mbna.msec.midtier.types.common.BusinessException faultInfo;

	public com.td.mbna.msec.midtier.types.common.BusinessException getFaultInfo() {
		return faultInfo;
	}

	public void setFaultInfo(
			com.td.mbna.msec.midtier.types.common.BusinessException faultInfo) {
		this.faultInfo = faultInfo;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(BusinessException.class.getName()).append('@')
				.append(Integer.toHexString(System.identityHashCode(this)))
				.append('[');

		sb.append("faultInfo");
		sb.append('=');
		sb.append(((this.faultInfo == null) ? "<null>" : this.faultInfo));
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
		result = ((result * 31) + ((this.faultInfo == null) ? 0
				: this.faultInfo.hashCode()));
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
		return (this.faultInfo == rhs.faultInfo)
				|| ((this.faultInfo != null) && this.faultInfo
						.equals(rhs.faultInfo));
	}

}
