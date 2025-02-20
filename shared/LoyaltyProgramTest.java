package com.td.api.mbofp.shared;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LoyaltyProgramTest {

    @Test
    void testGettersAndSetters() {
        LoyaltyProgram loyaltyProgram = new LoyaltyProgram();

        loyaltyProgram.setLoyaltyProductId("LP123");
        loyaltyProgram.setLoyaltyProductName("Rewards Plus");
        loyaltyProgram.setLoyaltyProductDesc("Premium rewards program");

        assertEquals("LP123", loyaltyProgram.getLoyaltyProductId());
        assertEquals("Rewards Plus", loyaltyProgram.getLoyaltyProductName());
        assertEquals("Premium rewards program", loyaltyProgram.getLoyaltyProductDesc());
    }

    @Test
    void testToString() {
        LoyaltyProgram loyaltyProgram = new LoyaltyProgram();
        loyaltyProgram.setLoyaltyProductId("LP456");
        loyaltyProgram.setLoyaltyProductName("Gold Membership");

        String result = loyaltyProgram.toString();

        assertTrue(result.contains("LP456"));
        assertTrue(result.contains("Gold Membership"));
    }

    @Test
    void testHashCode() {
        LoyaltyProgram lp1 = new LoyaltyProgram();
        lp1.setLoyaltyProductId("LP789");

        LoyaltyProgram lp2 = new LoyaltyProgram();
        lp2.setLoyaltyProductId("LP789");

        assertEquals(lp1.hashCode(), lp2.hashCode());
    }

    @Test
    void testEquals() {
        LoyaltyProgram lp1 = new LoyaltyProgram();
        lp1.setLoyaltyProductId("LP001");

        LoyaltyProgram lp2 = new LoyaltyProgram();
        lp2.setLoyaltyProductId("LP001");

        LoyaltyProgram lp3 = new LoyaltyProgram();
        lp3.setLoyaltyProductId("LP002");

        assertEquals(lp1, lp2);
        assertNotEquals(lp1, lp3);
        assertNotEquals(lp1, null);
        assertNotEquals(lp1, new Object());
    }
}
