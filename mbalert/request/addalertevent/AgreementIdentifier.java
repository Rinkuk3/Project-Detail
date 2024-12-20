package com.td.api.mbalert.request.addalertevent;

import lombok.Data;

@Data
public class AgreementIdentifier {

    private String agreementNum;

    private String agreementTypeCd;

    private AltrExtension_BankControl altrExtension;

    private String branchNum;
    

}
