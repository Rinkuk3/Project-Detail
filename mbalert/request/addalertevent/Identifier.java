package com.td.api.mbalert.request.addalertevent;

import lombok.Data;

@Data
public class Identifier {

    private AgreementIdentifier agreementIdentifier;
    private CardIdentifier cardIdentifier;

}
