package com.td.api.mbofp.shared;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AgreementAltkeyTest {

    @Test
    void testGettersAndSetters() {
        AgreementAltkey agreement = new AgreementAltkey();
        agreement.setCardNum("123456789");

        assertEquals("123456789", agreement.getCardNum());
    }

    @Test
    void testToString() {
        AgreementAltkey agreement = new AgreementAltkey();
        agreement.setCardNum("987654321");

        String result = agreement.toString();
        assertTrue(result.contains("987654321"));
    }

    @Test
    void testHashCode() {
        AgreementAltkey agreement1 = new AgreementAltkey();
        agreement1.setCardNum("123456789");

        AgreementAltkey agreement2 = new AgreementAltkey();
        agreement2.setCardNum("123456789");

        assertEquals(agreement1.hashCode(), agreement2.hashCode());
    }

    @Test
    void testEquals() {
        AgreementAltkey agreement1 = new AgreementAltkey();
        agreement1.setCardNum("123456789");

        AgreementAltkey agreement2 = new AgreementAltkey();
        agreement2.setCardNum("123456789");

        AgreementAltkey agreement3 = new AgreementAltkey();
        agreement3.setCardNum("987654321");

        assertEquals(agreement1, agreement2);
        assertNotEquals(agreement1, agreement3);
        assertNotEquals(agreement1, null);
        assertNotEquals(agreement1, new Object());
    }
}
