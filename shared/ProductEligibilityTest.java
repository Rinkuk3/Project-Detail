package com.td.api.mbofp.shared;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProductEligibilityTest {

    @Test
    void testGettersAndSetters() {
        ProductEligibility eligibility = new ProductEligibility();

        eligibility.setProductFeatureEligibilityTypeCd("TypeA");
        eligibility.setProductEligibilityVal("Eligible");

        assertEquals("TypeA", eligibility.getProductFeatureEligibilityTypeCd());
        assertEquals("Eligible", eligibility.getProductEligibilityVal());
    }

    @Test
    void testToString() {
        ProductEligibility eligibility = new ProductEligibility();
        eligibility.setProductFeatureEligibilityTypeCd("TypeB");
        eligibility.setProductEligibilityVal("Not Eligible");

        String result = eligibility.toString();

        assertTrue(result.contains("TypeB"));
        assertTrue(result.contains("Not Eligible"));
    }

    @Test
    void testHashCode() {
        ProductEligibility eligibility1 = new ProductEligibility();
        eligibility1.setProductFeatureEligibilityTypeCd("TypeC");
        eligibility1.setProductEligibilityVal("Eligible");

        ProductEligibility eligibility2 = new ProductEligibility();
        eligibility2.setProductFeatureEligibilityTypeCd("TypeC");
        eligibility2.setProductEligibilityVal("Eligible");

        assertEquals(eligibility1.hashCode(), eligibility2.hashCode());
    }

    @Test
    void testEquals() {
        ProductEligibility eligibility1 = new ProductEligibility();
        eligibility1.setProductFeatureEligibilityTypeCd("TypeD");
        eligibility1.setProductEligibilityVal("Eligible");

        ProductEligibility eligibility2 = new ProductEligibility();
        eligibility2.setProductFeatureEligibilityTypeCd("TypeD");
        eligibility2.setProductEligibilityVal("Eligible");

        ProductEligibility eligibility3 = new ProductEligibility();
        eligibility3.setProductFeatureEligibilityTypeCd("TypeE");
        eligibility3.setProductEligibilityVal("Not Eligible");

        assertEquals(eligibility1, eligibility2);
        assertNotEquals(eligibility1, eligibility3);
        assertNotEquals(eligibility1, null);
        assertNotEquals(eligibility1, new Object());
    }
}
