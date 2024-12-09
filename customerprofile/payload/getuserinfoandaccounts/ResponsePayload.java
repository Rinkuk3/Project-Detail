package com.td.mbna.msec.midtier.customerprofile.payload.getuserinfoandaccounts;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

import com.td.mbna.msec.midtier.customerprofile.payload.CustomerAcctLogonInfoType;
import com.td.mbna.msec.midtier.types.common.AccountOffersType;
import com.td.mbna.msec.midtier.types.common.AcctOverviewType;
import com.td.mbna.msec.midtier.types.common.CustAcctType;
import com.td.mbna.msec.midtier.types.eligibility.CustEligType;

@Data
public class ResponsePayload implements Serializable {

	private static final long serialVersionUID = 1L;
    private String custId;
    private CustEligType custElig;
    private List<CustomerAcctLogonInfoType> accountCustomerDetails = new ArrayList<CustomerAcctLogonInfoType>();
    private List<AcctOverviewType> custAccts = new ArrayList<AcctOverviewType>();
    private List<AccountOffersType> accountOffers = new ArrayList<AccountOffersType>();
    private List<CustAcctType> enrolledAccts = new ArrayList<CustAcctType>();
    private List<CustAcctType> allAccts = new ArrayList<CustAcctType>();
    private List<CustAcctType> kycAccts = new ArrayList<CustAcctType>();
    private List<CustAcctType> cliAccts = new ArrayList<CustAcctType>();

}
