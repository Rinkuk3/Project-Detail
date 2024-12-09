package com.td.mbna.msec.midtier.customerprofile.payload.getuserinfoandaccounts;

import java.io.Serializable;
import java.util.List;

import com.td.mbna.msec.midtier.types.common.CustAcctType;

import lombok.Data;

@Data
public class RequestPayload implements Serializable {

	private static final long serialVersionUID = 7264087787576057248L;
    private String customerId;
    private List<CustAcctType> enrolledAccts ;

}
