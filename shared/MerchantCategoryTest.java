package com.td.api.mbofp.shared;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MerchantCategoryTest {

    @Test
    void testGettersAndSetters() {
        MerchantCategory merchantCategory = new MerchantCategory();

        merchantCategory.setFeatureDesc("Test Feature");
        merchantCategory.setFromMerchantCategoryCd("1234");
        merchantCategory.setToMerchantCategoryCd("5678");

        assertEquals("Test Feature", merchantCategory.getFeatureDesc());
        assertEquals("1234", merchantCategory.getFromMerchantCategoryCd());
        assertEquals("5678", merchantCategory.getToMerchantCategoryCd());
    }

    @Test
    void testToString() {
        MerchantCategory merchantCategory = new MerchantCategory();
        merchantCategory.setFeatureDesc("Sample Desc");
        merchantCategory.setFromMerchantCategoryCd("1111");
        merchantCategory.setToMerchantCategoryCd("2222");

        String result = merchantCategory.toString();

        assertTrue(result.contains("Sample Desc"));
        assertTrue(result.contains("1111"));
        assertTrue(result.contains("2222"));
    }

    @Test
    void testHashCode() {
        MerchantCategory mc1 = new MerchantCategory();
        mc1.setFeatureDesc("Feature A");
        mc1.setFromMerchantCategoryCd("123");
        mc1.setToMerchantCategoryCd("456");

        MerchantCategory mc2 = new MerchantCategory();
        mc2.setFeatureDesc("Feature A");
        mc2.setFromMerchantCategoryCd("123");
        mc2.setToMerchantCategoryCd("456");

        assertEquals(mc1.hashCode(), mc2.hashCode());
    }

    @Test
    void testEquals() {
        MerchantCategory mc1 = new MerchantCategory();
        mc1.setFeatureDesc("Feature A");
        mc1.setFromMerchantCategoryCd("123");
        mc1.setToMerchantCategoryCd("456");

        MerchantCategory mc2 = new MerchantCategory();
        mc2.setFeatureDesc("Feature A");
        mc2.setFromMerchantCategoryCd("123");
        mc2.setToMerchantCategoryCd("456");

        MerchantCategory mc3 = new MerchantCategory();
        mc3.setFeatureDesc("Feature B");
        mc3.setFromMerchantCategoryCd("789");
        mc3.setToMerchantCategoryCd("012");

        assertEquals(mc1, mc2);
        assertNotEquals(mc1, mc3);
        assertNotEquals(mc1, null);
        assertNotEquals(mc1, new Object());
    }
}
