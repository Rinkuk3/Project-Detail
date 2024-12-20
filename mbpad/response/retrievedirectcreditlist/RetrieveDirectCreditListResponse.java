
package com.td.api.mbpad.response.retrievedirectcreditlist;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

import com.td.api.mbnaap.common.DirectCredit;
import com.td.api.mbnaap.common.Pagination;

@Data
public class RetrieveDirectCreditListResponse {

    private Pagination pagination;
    private List<DirectCredit> directCredit = new ArrayList<DirectCredit>();

   
}