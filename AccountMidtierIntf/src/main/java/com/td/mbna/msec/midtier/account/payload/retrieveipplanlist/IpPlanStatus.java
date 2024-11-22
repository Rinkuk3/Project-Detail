package com.td.mbna.msec.midtier.account.payload.retrieveipplanlist;

import java.io.Serializable;

public enum IpPlanStatus implements Serializable {
	Active,
	Inactive,
	RecentlyClosed,
	CloseIneligible;
}
