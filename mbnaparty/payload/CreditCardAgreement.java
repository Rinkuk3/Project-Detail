package com.td.api.mbna.msec.midtier.mbnaparty.payload;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;

@Data
public class CreditCardAgreement implements Serializable {
    private String hostAgreementNum;
    private String hostInstanceId;
    private String statusCd;
    private String startDt;
    private String endDt;
    private ArrayList<AgreementToAccessDevice> agreementToAccessDevice;
    private ArrayList<AgreementToAgreementGroup> agreementToAgreementGroup;
}
