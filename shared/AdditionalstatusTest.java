package com.td.api.mbofp.shared;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AdditionalstatusTest {

    @Test
    void testGettersAndSetters() {
        Additionalstatus status = new Additionalstatus();
        status.setStatusCode(200);
        status.setServerStatusCode("OK");
        status.setSeverity(Additionalstatus.Severity.INFO);
        status.setStatusDesc("Success");

        assertEquals(200, status.getStatusCode());
        assertEquals("OK", status.getServerStatusCode());
        assertEquals(Additionalstatus.Severity.INFO, status.getSeverity());
        assertEquals("Success", status.getStatusDesc());
    }

    @Test
    void testToString() {
        Additionalstatus status = new Additionalstatus();
        status.setStatusCode(500);
        status.setServerStatusCode("ERROR");
        status.setSeverity(Additionalstatus.Severity.ERROR);
        status.setStatusDesc("Internal Server Error");

        String result = status.toString();
        assertTrue(result.contains("500"));
        assertTrue(result.contains("ERROR"));
        assertTrue(result.contains("Internal Server Error"));
    }

    @Test
    void testHashCode() {
        Additionalstatus status1 = new Additionalstatus();
        status1.setStatusCode(200);
        status1.setServerStatusCode("OK");
        status1.setSeverity(Additionalstatus.Severity.INFO);
        status1.setStatusDesc("Success");

        Additionalstatus status2 = new Additionalstatus();
        status2.setStatusCode(200);
        status2.setServerStatusCode("OK");
        status2.setSeverity(Additionalstatus.Severity.INFO);
        status2.setStatusDesc("Success");

        assertEquals(status1.hashCode(), status2.hashCode());
    }

    @Test
    void testEquals() {
        Additionalstatus status1 = new Additionalstatus();
        status1.setStatusCode(200);
        status1.setServerStatusCode("OK");
        status1.setSeverity(Additionalstatus.Severity.INFO);
        status1.setStatusDesc("Success");

        Additionalstatus status2 = new Additionalstatus();
        status2.setStatusCode(200);
        status2.setServerStatusCode("OK");
        status2.setSeverity(Additionalstatus.Severity.INFO);
        status2.setStatusDesc("Success");

        Additionalstatus status3 = new Additionalstatus();
        status3.setStatusCode(500);

        assertEquals(status1, status2);
        assertNotEquals(status1, status3);
        assertNotEquals(status1, null);
        assertNotEquals(status1, new Object());
    }

    @Test
    void testSeverityEnum() {
        assertEquals(Additionalstatus.Severity.INFO, Additionalstatus.Severity.fromValue("Info"));
        assertEquals(Additionalstatus.Severity.WARNING, Additionalstatus.Severity.fromValue("Warning"));
        assertEquals(Additionalstatus.Severity.ERROR, Additionalstatus.Severity.fromValue("Error"));

        assertThrows(IllegalArgumentException.class, () -> Additionalstatus.Severity.fromValue("Invalid"));

        assertEquals("Info", Additionalstatus.Severity.INFO.toString());
        assertEquals("Warning", Additionalstatus.Severity.WARNING.toString());
        assertEquals("Error", Additionalstatus.Severity.ERROR.toString());
    }
}
