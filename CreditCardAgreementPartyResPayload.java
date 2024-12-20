package com.td.api.mbcca.response.account;

import lombok.Data;

import java.util.List;

@Data
public class CreditCardAgreementPartyResPayload {
    private CreditCardAgreement creditCardAgreement;
    private List<CreditCardAgreementToParty> creditCardAgreementToParty;
    private List<AlertSetup> alertSetup;
    private Boolean status;
}
