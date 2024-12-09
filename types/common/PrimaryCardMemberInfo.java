package com.td.mbna.msec.midtier.types.common;

import java.io.Serializable;

public class PrimaryCardMemberInfo implements Serializable {

	private static final long serialVersionUID = 4218558035919921540L;
	
	private String firstName = "";
	private String middleName = "";
	private String lastName = "";


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	@Override
	public String toString() {
		return "PrimaryCardMemberInfo [firstName=" + firstName
				+ ", middleName=" + middleName + ", lastName=" + lastName + "]";
	}	

	
	
}
