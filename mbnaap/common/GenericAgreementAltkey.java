package com.td.api.mbnaap.common;

import lombok.Data;

@Data
public class GenericAgreementAltkey {

    private String bankNum;
    private String branchNum;
    private String accountNum;
    private String accountNumMasked;
    private String agreementTypeCd;
    private String agreementKey;   
}