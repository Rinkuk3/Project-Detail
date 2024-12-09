package com.td.mbna.msec.midtier.types.common;

import java.io.Serializable;

public class CardHolderInfo implements Serializable {

	private static final long serialVersionUID = -3436797549292130127L;

	private String cardNumber;
	private String cardHolderName;

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

}
