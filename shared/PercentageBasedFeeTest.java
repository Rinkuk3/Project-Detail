package com.td.api.mbofp.shared;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class PercentageBasedFeeTest {

    @Test
    void testGettersAndSetters() {
        PercentageBasedFee fee = new PercentageBasedFee();

        fee.setPercentageRate(new BigDecimal("5.5"));
        fee.setUpperLimitAmt(new BigDecimal("1000"));
        fee.setLowerLimitAmt(new BigDecimal("50"));

        assertEquals(new BigDecimal("5.5"), fee.getPercentageRate());
        assertEquals(new BigDecimal("1000"), fee.getUpperLimitAmt());
        assertEquals(new BigDecimal("50"), fee.getLowerLimitAmt());
    }

    @Test
    void testToString() {
        PercentageBasedFee fee = new PercentageBasedFee();
        fee.setPercentageRate(new BigDecimal("3.75"));
        fee.setUpperLimitAmt(new BigDecimal("500"));
        fee.setLowerLimitAmt(new BigDecimal("25"));

        String result = fee.toString();

        assertTrue(result.contains("3.75"));
        assertTrue(result.contains("500"));
        assertTrue(result.contains("25"));
    }

    @Test
    void testHashCode() {
        PercentageBasedFee fee1 = new PercentageBasedFee();
        fee1.setPercentageRate(new BigDecimal("2.5"));
        fee1.setUpperLimitAmt(new BigDecimal("750"));
        fee1.setLowerLimitAmt(new BigDecimal("100"));

        PercentageBasedFee fee2 = new PercentageBasedFee();
        fee2.setPercentageRate(new BigDecimal("2.5"));
        fee2.setUpperLimitAmt(new BigDecimal("750"));
        fee2.setLowerLimitAmt(new BigDecimal("100"));

        assertEquals(fee1.hashCode(), fee2.hashCode());
    }

    @Test
    void testEquals() {
        PercentageBasedFee fee1 = new PercentageBasedFee();
        fee1.setPercentageRate(new BigDecimal("1.5"));
        fee1.setUpperLimitAmt(new BigDecimal("600"));
        fee1.setLowerLimitAmt(new BigDecimal("50"));

        PercentageBasedFee fee2 = new PercentageBasedFee();
        fee2.setPercentageRate(new BigDecimal("1.5"));
        fee2.setUpperLimitAmt(new BigDecimal("600"));
        fee2.setLowerLimitAmt(new BigDecimal("50"));

        PercentageBasedFee fee3 = new PercentageBasedFee();
        fee3.setPercentageRate(new BigDecimal("2.0"));
        fee3.setUpperLimitAmt(new BigDecimal("500"));
        fee3.setLowerLimitAmt(new BigDecimal("30"));

        assertEquals(fee1, fee2);
        assertNotEquals(fee1, fee3);
        assertNotEquals(fee1, null);
        assertNotEquals(fee1, new Object());
    }
}
