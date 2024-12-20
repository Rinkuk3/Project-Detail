package com.td.mbna.msec.midtier.persistance.entity;

import java.io.Serializable;

/**
 * This class corresponds to individual rows in the CHATELIGIBILITY table in the local database.
 *   
 */
 public class ChatEligibility implements Serializable {

	private static final long serialVersionUID = 8490618167168163640L;
	private String productCodes;
	private int isOnlineChat;

	public String getProductCodes() {
		return productCodes;
	}
	public void setProductCodes(String productCodes) {
		this.productCodes = productCodes;
	}
	public boolean isOnlineChatAllowed() {
		if (isOnlineChat==1) {
			return true;
		}
		return false;
	}
	public void setIsOnlineChatAllowed(boolean isOnlineChat) {
		if (isOnlineChat) {
			this.isOnlineChat = 1;
		}else {
			this.isOnlineChat = 0;
		}
	}
	/**
	 * hashCode
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + isOnlineChat;
		result = prime * result
				+ ((productCodes == null) ? 0 : productCodes.hashCode());
		return result;
	}
	// comparing two chatEligiblity objects
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof ChatEligibility)) {
			return false;
		}
		ChatEligibility other = (ChatEligibility) obj;
		if (isOnlineChat != other.isOnlineChat) {
			return false;
		}
		if (productCodes == null) {
			if (other.productCodes != null) {
				return false;
			}
		} else if (!productCodes.equals(other.productCodes)) {
			return false;
		}
		return true;
	}
}
