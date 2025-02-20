package com.td.api.mbofp.shared;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomAttributeTest {

    @Test
    void testGettersAndSetters() {
        CustomAttribute attribute = new CustomAttribute();
        attribute.setCustomAttributeId("ID123");
        attribute.setCustomAttributeDesc("Description");
        attribute.setLabelTxt("Label");
        attribute.setRequiredInd(true);
        attribute.setDefaultVal("Default");
        attribute.setMinimumLengthCnt(1);
        attribute.setMaximumLengthCnt(10);
        attribute.setDataTypeCd("String");
        attribute.setVisibleInd(false);
        attribute.setReadOnlyInd(true);
        attribute.setCheckDigitRequiredInd(false);
        attribute.setFormatVal("Format");

        assertEquals("ID123", attribute.getCustomAttributeId());
        assertEquals("Description", attribute.getCustomAttributeDesc());
        assertEquals("Label", attribute.getLabelTxt());
        assertTrue(attribute.getRequiredInd());
        assertEquals("Default", attribute.getDefaultVal());
        assertEquals(1, attribute.getMinimumLengthCnt());
        assertEquals(10, attribute.getMaximumLengthCnt());
        assertEquals("String", attribute.getDataTypeCd());
        assertFalse(attribute.getVisibleInd());
        assertTrue(attribute.getReadOnlyInd());
        assertFalse(attribute.getCheckDigitRequiredInd());
        assertEquals("Format", attribute.getFormatVal());
    }

    @Test
    void testToString() {
        CustomAttribute attribute = new CustomAttribute();
        attribute.setCustomAttributeId("ID456");
        attribute.setCustomAttributeDesc("Desc");
        String result = attribute.toString();

        assertTrue(result.contains("ID456"));
        assertTrue(result.contains("Desc"));
    }

    @Test
    void testHashCode() {
        CustomAttribute attribute1 = new CustomAttribute();
        attribute1.setCustomAttributeId("ID123");

        CustomAttribute attribute2 = new CustomAttribute();
        attribute2.setCustomAttributeId("ID123");

        assertEquals(attribute1.hashCode(), attribute2.hashCode());
    }

    @Test
    void testEquals() {
        CustomAttribute attribute1 = new CustomAttribute();
        attribute1.setCustomAttributeId("ID123");

        CustomAttribute attribute2 = new CustomAttribute();
        attribute2.setCustomAttributeId("ID123");

        CustomAttribute attribute3 = new CustomAttribute();
        attribute3.setCustomAttributeId("ID789");

        assertEquals(attribute1, attribute2);
        assertNotEquals(attribute1, attribute3);
        assertNotEquals(attribute1, null);
        assertNotEquals(attribute1, new Object());
    }
}
