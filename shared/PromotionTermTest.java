import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PromotionTermTest {

    private PromotionTerm promotionTerm;

    @BeforeEach
    void setUp() {
        promotionTerm = new PromotionTerm();
    }

    @Test
    void testGetSetUntilAgeCd() {
        String untilAgeCd = "Age30";
        promotionTerm.setUntilAgeCd(untilAgeCd);
        assertEquals(untilAgeCd, promotionTerm.getUntilAgeCd());
    }

    @Test
    void testGetSetUntilAgeNum() {
        String untilAgeNum = "30";
        promotionTerm.setUntilAgeNum(untilAgeNum);
        assertEquals(untilAgeNum, promotionTerm.getUntilAgeNum());
    }

    @Test
    void testGetSetFixedEndDt() {
        String fixedEndDt = "2025-12-31";
        promotionTerm.setFixedEndDt(fixedEndDt);
        assertEquals(fixedEndDt, promotionTerm.getFixedEndDt());
    }

    @Test
    void testToString() {
        promotionTerm.setUntilAgeCd("Age30");
        promotionTerm.setUntilAgeNum("30");
        promotionTerm.setFixedEndDt("2025-12-31");

        String expected = "com.td.api.mbofp.shared.PromotionTerm@" + Integer.toHexString(System.identityHashCode(promotionTerm)) +
                "[untilAgeCd=Age30,untilAgeNum=30,fixedEndDt=2025-12-31]";
        assertTrue(promotionTerm.toString().contains(expected));
    }

    @Test
    void testHashCode() {
        PromotionTerm promotionTerm1 = new PromotionTerm();
        promotionTerm1.setUntilAgeCd("Age30");
        promotionTerm1.setUntilAgeNum("30");
        promotionTerm1.setFixedEndDt("2025-12-31");

        PromotionTerm promotionTerm2 = new PromotionTerm();
        promotionTerm2.setUntilAgeCd("Age30");
        promotionTerm2.setUntilAgeNum("30");
        promotionTerm2.setFixedEndDt("2025-12-31");

        assertEquals(promotionTerm1.hashCode(), promotionTerm2.hashCode());
    }

    @Test
    void testEqualsTrue() {
        PromotionTerm anotherPromotionTerm = new PromotionTerm();
        anotherPromotionTerm.setUntilAgeCd("Age30");
        anotherPromotionTerm.setUntilAgeNum("30");
        anotherPromotionTerm.setFixedEndDt("2025-12-31");

        promotionTerm.setUntilAgeCd("Age30");
        promotionTerm.setUntilAgeNum("30");
        promotionTerm.setFixedEndDt("2025-12-31");

        assertTrue(promotionTerm.equals(anotherPromotionTerm));
    }

    @Test
    void testEqualsFalse() {
        PromotionTerm anotherPromotionTerm = new PromotionTerm();
        anotherPromotionTerm.setUntilAgeCd("Age40");
        anotherPromotionTerm.setUntilAgeNum("40");
        anotherPromotionTerm.setFixedEndDt("2026-12-31");

        promotionTerm.setUntilAgeCd("Age30");
        promotionTerm.setUntilAgeNum("30");
        promotionTerm.setFixedEndDt("2025-12-31");

        assertFalse(promotionTerm.equals(anotherPromotionTerm));
    }

    @Test
    void testEqualsNull() {
        assertFalse(promotionTerm.equals(null));
    }

    @Test
    void testEqualsSameObject() {
        assertTrue(promotionTerm.equals(promotionTerm));
    }

    @Test
    void testEqualsDifferentClass() {
        String str = "Not a PromotionTerm";
        assertFalse(promotionTerm.equals(str));
    }
}
