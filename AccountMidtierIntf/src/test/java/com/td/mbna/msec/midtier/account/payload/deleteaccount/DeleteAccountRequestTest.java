package com.td.mbna.msec.midtier.account.payload.deleteaccount;

import com.td.mbna.msec.midtier.types.common.AuditInfo;
import com.td.mbna.msec.midtier.types.common.BaseRequest;
import com.td.mbna.msec.midtier.types.common.TrackingInfoType;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DeleteAccountRequestTest {

    private DeleteAccountRequest deleteAccountRequest = new DeleteAccountRequest();
    private AuditInfo auditInfo = new AuditInfo();
    private TrackingInfoType sessionInfo = new TrackingInfoType();

    @Test
    void testGettersAndSetters() {
        RequestPayload requestPayload  = new RequestPayload();
        deleteAccountRequest.setRequestPayload(requestPayload);
        deleteAccountRequest.setAcctNum("12345");
        deleteAccountRequest.setAcctType("testType");
        deleteAccountRequest.setAuditInfo(auditInfo);
        deleteAccountRequest.setCardNum("1234567890");
        deleteAccountRequest.setAliasCustId("testId");
        deleteAccountRequest.setCustId("testId");
        deleteAccountRequest.setCustInterface("testInterface");
        deleteAccountRequest.setIsPrimaryUser(true);
        deleteAccountRequest.setLanguagePref("testLang");
        deleteAccountRequest.setMultiCard(true);
        deleteAccountRequest.setReserved1("testReserved");
        deleteAccountRequest.setSessionInfo(sessionInfo);

        assertEquals("12345", deleteAccountRequest.getAcctNum());
        assertEquals("testType", deleteAccountRequest.getAcctType());
        assertEquals("1234567890", deleteAccountRequest.getCardNum());
        assertEquals("testId", deleteAccountRequest.getAliasCustId());
        assertEquals("testId", deleteAccountRequest.getCustId());
        assertEquals("testInterface", deleteAccountRequest.getCustInterface());
        assertEquals(true, deleteAccountRequest.getIsPrimaryUser());
        assertEquals(true, deleteAccountRequest.isMultiCard());
        assertEquals(auditInfo, deleteAccountRequest.getAuditInfo());
        assertEquals(sessionInfo, deleteAccountRequest.getSessionInfo());
        assertEquals("testLang", deleteAccountRequest.getLanguagePref());
        assertEquals(requestPayload, deleteAccountRequest.getRequestPayload());
        assertEquals("12345", deleteAccountRequest.getAcctNum());

    }
}