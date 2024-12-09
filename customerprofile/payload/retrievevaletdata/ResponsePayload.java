package com.td.mbna.msec.midtier.customerprofile.payload.retrievevaletdata;


public class ResponsePayload {

	private String objectData;

	public String getObjectData() {
		return objectData;
	}

	public void setObjectData(String objectData) {
		this.objectData = objectData;
	}

	@Override
	public String toString() {
		return "RequestPayload [objectData=" + objectData + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((objectData == null) ? 0 : objectData.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResponsePayload other = (ResponsePayload) obj;
		if (objectData == null) {
			if (other.objectData != null)
				return false;
		} else if (!objectData.equals(other.objectData))
			return false;
		return true;
	}

    
}
