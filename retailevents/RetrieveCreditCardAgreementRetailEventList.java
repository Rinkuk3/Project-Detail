package com.td.api.mbcca.response.retailevents;

import java.util.ArrayList;
import java.util.List;

import com.td.api.mbcca.response.account.RetailEvent;
import com.td.api.mbcca.shared.Pagination;
import com.td.api.mbcca.shared.Status;
import lombok.Data;

@Data
public class RetrieveCreditCardAgreementRetailEventList {
    private Status status;
    private Pagination pagination;
    private List<RetailEvent> retailEvent = new ArrayList<RetailEvent>();
}
