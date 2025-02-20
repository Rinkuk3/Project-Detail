import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

class VariableRateTest {

    private VariableRate variableRate;

    @BeforeEach
    void setUp() {
        variableRate = new VariableRate();
    }

    @Test
    void testGetSetInterestIndexRate() {
        BigDecimal interestIndexRate = new BigDecimal("2.5");
        variableRate.setInterestIndexRate(interestIndexRate);
        assertEquals(interestIndexRate, variableRate.getInterestIndexRate());
    }

    @Test
    void testGetSetSpreadRate() {
        BigDecimal spreadRate = new BigDecimal("1.0");
        variableRate.setSpreadRate(spreadRate);
        assertEquals(spreadRate, variableRate.getSpreadRate());
    }

    @Test
    void testGetSetUpperLimitRate() {
        BigDecimal upperLimitRate = new BigDecimal("5.0");
        variableRate.setUpperLimitRate(upperLimitRate);
        assertEquals(upperLimitRate, variableRate.getUpperLimitRate());
    }

    @Test
    void testGetSetLowerLimitRate() {
        BigDecimal lowerLimitRate = new BigDecimal("0.5");
        variableRate.setLowerLimitRate(lowerLimitRate);
        assertEquals(lowerLimitRate, variableRate.getLowerLimitRate());
    }

    @Test
    void testToString() {
        variableRate.setInterestIndexRate(new BigDecimal("2.5"));
        variableRate.setSpreadRate(new BigDecimal("1.0"));
        variableRate.setUpperLimitRate(new BigDecimal("5.0"));
        variableRate.setLowerLimitRate(new BigDecimal("0.5"));

        String expected = "com.td.api.mbofp.shared.VariableRate@" + Integer.toHexString(System.identityHashCode(variableRate)) +
                "[interestIndexRate=2.5,spreadRate=1.0,upperLimitRate=5.0,lowerLimitRate=0.5]";
        assertTrue(variableRate.toString().contains(expected));
    }

    @Test
    void testHashCode() {
        variableRate.setInterestIndexRate(new BigDecimal("2.5"));
        variableRate.setSpreadRate(new BigDecimal("1.0"));
        variableRate.setUpperLimitRate(new BigDecimal("5.0"));
        variableRate.setLowerLimitRate(new BigDecimal("0.5"));

        int expectedHashCode = variableRate.getInterestIndexRate().hashCode() * 31 +
                               variableRate.getUpperLimitRate().hashCode() * 31 +
                               variableRate.getSpreadRate().hashCode() * 31 +
                               variableRate.getLowerLimitRate().hashCode();
        assertEquals(expectedHashCode, variableRate.hashCode());
    }

    @Test
    void testEqualsTrue() {
        VariableRate anotherVariableRate = new VariableRate();
        anotherVariableRate.setInterestIndexRate(new BigDecimal("2.5"));
        anotherVariableRate.setSpreadRate(new BigDecimal("1.0"));
        anotherVariableRate.setUpperLimitRate(new BigDecimal("5.0"));
        anotherVariableRate.setLowerLimitRate(new BigDecimal("0.5"));

        variableRate.setInterestIndexRate(new BigDecimal("2.5"));
        variableRate.setSpreadRate(new BigDecimal("1.0"));
        variableRate.setUpperLimitRate(new BigDecimal("5.0"));
        variableRate.setLowerLimitRate(new BigDecimal("0.5"));

        assertTrue(variableRate.equals(anotherVariableRate));
    }

    @Test
    void testEqualsFalse() {
        VariableRate anotherVariableRate = new VariableRate();
        anotherVariableRate.setInterestIndexRate(new BigDecimal("3.0"));
        anotherVariableRate.setSpreadRate(new BigDecimal("1.0"));
        anotherVariableRate.setUpperLimitRate(new BigDecimal("5.0"));
        anotherVariableRate.setLowerLimitRate(new BigDecimal("0.5"));

        variableRate.setInterestIndexRate(new BigDecimal("2.5"));
        variableRate.setSpreadRate(new BigDecimal("1.0"));
        variableRate.setUpperLimitRate(new BigDecimal("5.0"));
        variableRate.setLowerLimitRate(new BigDecimal("0.5"));

        assertFalse(variableRate.equals(anotherVariableRate));
    }

    @Test
    void testEqualsNull() {
        assertFalse(variableRate.equals(null));
    }

    @Test
    void testEqualsSameObject() {
        assertTrue(variableRate.equals(variableRate));
    }

    @Test
    void testEqualsDifferentClass() {
        String str = "Not a VariableRate";
        assertFalse(variableRate.equals(str));
    }
}
