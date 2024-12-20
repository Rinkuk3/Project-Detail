
package com.td.api.mbpad.response.retrievedirectcredit;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

import com.td.api.mbnaap.common.DirectCredit;
import com.td.api.mbnaap.common.Pagination;
import com.td.api.mbnaap.common.Transaction;

@Data
public class RetrieveDirectCreditResponse {
    private Pagination pagination;
    private DirectCredit directCredit;
    private List<Transaction> transaction = new ArrayList<Transaction>();   

}