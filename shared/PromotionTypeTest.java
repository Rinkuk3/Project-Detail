import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PromotionTypeTest {

    private PromotionType promotionType;

    @BeforeEach
    void setUp() {
        promotionType = new PromotionType();
    }

    @Test
    void testGetSetTypeCd() {
        String typeCd = "PROMO123";
        promotionType.setTypeCd(typeCd);
        assertEquals(typeCd, promotionType.getTypeCd());
    }

    @Test
    void testGetSetTypeDesc() {
        String typeDesc = "Discount Promotion";
        promotionType.setTypeDesc(typeDesc);
        assertEquals(typeDesc, promotionType.getTypeDesc());
    }

    @Test
    void testToString() {
        promotionType.setTypeCd("PROMO123");
        promotionType.setTypeDesc("Discount Promotion");

        String expected = "com.td.api.mbofp.shared.PromotionType@" + Integer.toHexString(System.identityHashCode(promotionType)) +
                "[typeCd=PROMO123,typeDesc=Discount Promotion]";
        assertTrue(promotionType.toString().contains(expected));
    }

    @Test
    void testHashCode() {
        PromotionType promotionType1 = new PromotionType();
        promotionType1.setTypeCd("PROMO123");
        promotionType1.setTypeDesc("Discount Promotion");

        PromotionType promotionType2 = new PromotionType();
        promotionType2.setTypeCd("PROMO123");
        promotionType2.setTypeDesc("Discount Promotion");

        assertEquals(promotionType1.hashCode(), promotionType2.hashCode());
    }

    @Test
    void testEqualsTrue() {
        PromotionType anotherPromotionType = new PromotionType();
        anotherPromotionType.setTypeCd("PROMO123");
        anotherPromotionType.setTypeDesc("Discount Promotion");

        promotionType.setTypeCd("PROMO123");
        promotionType.setTypeDesc("Discount Promotion");

        assertTrue(promotionType.equals(anotherPromotionType));
    }

    @Test
    void testEqualsFalse() {
        PromotionType anotherPromotionType = new PromotionType();
        anotherPromotionType.setTypeCd("PROMO456");
        anotherPromotionType.setTypeDesc("Buy One Get One");

        promotionType.setTypeCd("PROMO123");
        promotionType.setTypeDesc("Discount Promotion");

        assertFalse(promotionType.equals(anotherPromotionType));
    }

    @Test
    void testEqualsNull() {
        assertFalse(promotionType.equals(null));
    }

    @Test
    void testEqualsSameObject() {
        assertTrue(promotionType.equals(promotionType));
    }

    @Test
    void testEqualsDifferentClass() {
        String str = "Not a PromotionType";
        assertFalse(promotionType.equals(str));
    }
}
