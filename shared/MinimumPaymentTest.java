package com.td.api.mbofp.shared;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class MinimumPaymentTest {

    @Test
    void testGettersAndSetters() {
        MinimumPayment minimumPayment = new MinimumPayment();

        minimumPayment.setMinimumPaymentAmt(new BigDecimal("100.50"));
        minimumPayment.setCalculationPercentageRate(new BigDecimal("2.5"));

        assertEquals(new BigDecimal("100.50"), minimumPayment.getMinimumPaymentAmt());
        assertEquals(new BigDecimal("2.5"), minimumPayment.getCalculationPercentageRate());
    }

    @Test
    void testToString() {
        MinimumPayment minimumPayment = new MinimumPayment();
        minimumPayment.setMinimumPaymentAmt(new BigDecimal("50.75"));
        minimumPayment.setCalculationPercentageRate(new BigDecimal("1.25"));

        String result = minimumPayment.toString();

        assertTrue(result.contains("50.75"));
        assertTrue(result.contains("1.25"));
    }

    @Test
    void testHashCode() {
        MinimumPayment mp1 = new MinimumPayment();
        mp1.setMinimumPaymentAmt(new BigDecimal("200"));
        mp1.setCalculationPercentageRate(new BigDecimal("3.5"));

        MinimumPayment mp2 = new MinimumPayment();
        mp2.setMinimumPaymentAmt(new BigDecimal("200"));
        mp2.setCalculationPercentageRate(new BigDecimal("3.5"));

        assertEquals(mp1.hashCode(), mp2.hashCode());
    }

    @Test
    void testEquals() {
        MinimumPayment mp1 = new MinimumPayment();
        mp1.setMinimumPaymentAmt(new BigDecimal("300"));
        mp1.setCalculationPercentageRate(new BigDecimal("4.0"));

        MinimumPayment mp2 = new MinimumPayment();
        mp2.setMinimumPaymentAmt(new BigDecimal("300"));
        mp2.setCalculationPercentageRate(new BigDecimal("4.0"));

        MinimumPayment mp3 = new MinimumPayment();
        mp3.setMinimumPaymentAmt(new BigDecimal("150"));
        mp3.setCalculationPercentageRate(new BigDecimal("2.0"));

        assertEquals(mp1, mp2);
        assertNotEquals(mp1, mp3);
        assertNotEquals(mp1, null);
        assertNotEquals(mp1, new Object());
    }
}
