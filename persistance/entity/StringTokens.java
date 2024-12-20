package com.td.mbna.msec.midtier.persistance.entity;

import java.io.Serializable;

/**
 * This class corresponds to an object used by the Customer Notes service.
 *   
 */
public class StringTokens  implements Serializable{

	private static final long serialVersionUID = 103039740264660116L;
	String value;
	int sequence;
	
	public StringTokens(String value,int sequence) {
		this.value = value;
		this.sequence = sequence;
	}
	@Override
	public String toString() {
		return "value: |" + this.value + "|, length=" + value.length() + ",sequence=" + sequence ;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public int getSequence() {
		return sequence;
	}
	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
}
