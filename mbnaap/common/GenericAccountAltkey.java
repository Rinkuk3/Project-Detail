package com.td.api.mbnaap.common;

import lombok.Data;

/**
 * Generic Alternate key for external account.
 * 
 */
@Data
public class GenericAccountAltkey {

    private String bankNum;
    private String branchNum;
    private String accountNum;
    private String accountKey; 

}