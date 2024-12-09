package com.td.mbna.msec.midtier.customerprofile.payload.customeragreement;

import com.td.mbna.msec.midtier.types.common.DisclosureInfoType;
import lombok.Data;

@Data
public class RequestPayload {
    private DisclosureInfoType disclosureInfo;
    private String accountNo;
}
