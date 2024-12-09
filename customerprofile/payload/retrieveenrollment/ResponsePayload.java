package com.td.mbna.msec.midtier.customerprofile.payload.retrieveenrollment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

import com.td.mbna.msec.midtier.types.common.CustAcctType;

@Data
public class ResponsePayload implements Serializable {

	private static final long serialVersionUID = 5821260862927342472L;
	private String custId;
    private List<CustAcctType> enrolledAccts = new ArrayList<CustAcctType>();

}
