package com.td.mbna.msec.midtier.persistance.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class CustomerActionItem implements Serializable{
	
	private static final long serialVersionUID = 8073767061242367804L;
	
	private long actionID;
	private String customerID;
	private String accountNumber;
	private String visited;
	private String dismissed;
	private int count;
	
}
