package com.td.api.mbofp.shared;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class FeeTest {

    @Test
    void testGettersAndSetters() {
        Fee fee = new Fee();
        PercentageBasedFee percentageFee = new PercentageBasedFee();

        fee.setTypeCd("TYPE1");
        fee.setFeeClassificationCd("FEE_CLASS");
        fee.setFeatureClassificationCd("FEATURE_CLASS");
        fee.setFeatureSubClassificationCd("FEATURE_SUB_CLASS");
        fee.setTransactionCategoryCd("TRANSACTION_CATEGORY");
        fee.setFixedFeeAmt(new BigDecimal("100.50"));
        fee.setPercentageBasedFee(percentageFee);

        assertEquals("TYPE1", fee.getTypeCd());
        assertEquals("FEE_CLASS", fee.getFeeClassificationCd());
        assertEquals("FEATURE_CLASS", fee.getFeatureClassificationCd());
        assertEquals("FEATURE_SUB_CLASS", fee.getFeatureSubClassificationCd());
        assertEquals("TRANSACTION_CATEGORY", fee.getTransactionCategoryCd());
        assertEquals(new BigDecimal("100.50"), fee.getFixedFeeAmt());
        assertEquals(percentageFee, fee.getPercentageBasedFee());
    }

    @Test
    void testToString() {
        Fee fee = new Fee();
        fee.setTypeCd("TYPE2");
        fee.setFeeClassificationCd("CLASS2");
        String result = fee.toString();

        assertTrue(result.contains("TYPE2"));
        assertTrue(result.contains("CLASS2"));
    }

    @Test
    void testHashCode() {
        Fee fee1 = new Fee();
        fee1.setTypeCd("TYPE1");

        Fee fee2 = new Fee();
        fee2.setTypeCd("TYPE1");

        assertEquals(fee1.hashCode(), fee2.hashCode());
    }

    @Test
    void testEquals() {
        Fee fee1 = new Fee();
        fee1.setTypeCd("TYPE1");

        Fee fee2 = new Fee();
        fee2.setTypeCd("TYPE1");

        Fee fee3 = new Fee();
        fee3.setTypeCd("TYPE3");

        assertEquals(fee1, fee2);
        assertNotEquals(fee1, fee3);
        assertNotEquals(fee1, null);
        assertNotEquals(fee1, new Object());
    }
}
