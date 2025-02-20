import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

class StatusTest {

    private Status status;
    private Severity severity;
    private Additionalstatus additionalStatus;

    @BeforeEach
    void setUp() {
        status = new Status();
        severity = Severity.WARNING;
        additionalStatus = new Additionalstatus(); // Assuming Additionalstatus is already defined
    }

    @Test
    void testGetSetServerStatusCode() {
        String serverStatusCode = "200";
        status.setServerStatusCode(serverStatusCode);
        assertEquals(serverStatusCode, status.getServerStatusCode());
    }

    @Test
    void testGetSetSeverity() {
        status.setSeverity(severity);
        assertEquals(severity, status.getSeverity());
    }

    @Test
    void testGetSetAdditionalStatus() {
        status.setAdditionalStatus(Arrays.asList(additionalStatus));
        assertEquals(Arrays.asList(additionalStatus), status.getAdditionalStatus());
    }

    @Test
    void testToString() {
        status.setServerStatusCode("200");
        status.setSeverity(severity);
        status.setAdditionalStatus(Arrays.asList(additionalStatus));

        String expected = "com.td.api.mbofp.shared.Status@" + Integer.toHexString(System.identityHashCode(status)) +
                "[serverStatusCode=200,severity=Warning,additionalStatus=[" + additionalStatus + "]]";
        assertTrue(status.toString().contains(expected));
    }

    @Test
    void testHashCode() {
        status.setServerStatusCode("200");
        status.setSeverity(severity);
        status.setAdditionalStatus(Arrays.asList(additionalStatus));

        int expectedHashCode = status.getServerStatusCode().hashCode() * 31 + 
                               status.getSeverity().hashCode() * 31 + 
                               status.getAdditionalStatus().hashCode();
        assertEquals(expectedHashCode, status.hashCode());
    }

    @Test
    void testEqualsTrue() {
        Status anotherStatus = new Status();
        anotherStatus.setServerStatusCode("200");
        anotherStatus.setSeverity(severity);
        anotherStatus.setAdditionalStatus(Arrays.asList(additionalStatus));

        status.setServerStatusCode("200");
        status.setSeverity(severity);
        status.setAdditionalStatus(Arrays.asList(additionalStatus));

        assertTrue(status.equals(anotherStatus));
    }

    @Test
    void testEqualsFalse() {
        Status anotherStatus = new Status();
        anotherStatus.setServerStatusCode("404");
        anotherStatus.setSeverity(Severity.ERROR);
        anotherStatus.setAdditionalStatus(Arrays.asList(additionalStatus));

        status.setServerStatusCode("200");
        status.setSeverity(severity);
        status.setAdditionalStatus(Arrays.asList(additionalStatus));

        assertFalse(status.equals(anotherStatus));
    }

    @Test
    void testEqualsNull() {
        assertFalse(status.equals(null));
    }

    @Test
    void testEqualsSameObject() {
        assertTrue(status.equals(status));
    }

    @Test
    void testEqualsDifferentClass() {
        String str = "Not a Status";
        assertFalse(status.equals(str));
    }

    @Test
    void testSeverityFromValue() {
        assertEquals(Severity.WARNING, Severity.fromValue("Warning"));
        assertEquals(Severity.ERROR, Severity.fromValue("Error"));
    }

    @Test
    void testSeverityFromValueThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> Severity.fromValue("Invalid"));
    }
}
