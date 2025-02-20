import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

class RateTest {

    private Rate rate;

    @BeforeEach
    void setUp() {
        rate = new Rate();
    }

    @Test
    void testGetSetTypeCd() {
        String typeCd = "RATE123";
        rate.setTypeCd(typeCd);
        assertEquals(typeCd, rate.getTypeCd());
    }

    @Test
    void testGetSetFeatureClassificationCd() {
        String featureClassificationCd = "FEATURE1";
        rate.setFeatureClassificationCd(featureClassificationCd);
        assertEquals(featureClassificationCd, rate.getFeatureClassificationCd());
    }

    @Test
    void testGetSetFixedRate() {
        BigDecimal fixedRate = new BigDecimal("5.5");
        rate.setFixedRate(fixedRate);
        assertEquals(fixedRate, rate.getFixedRate());
    }

    @Test
    void testGetSetVariableRate() {
        VariableRate variableRate = new VariableRate();
        rate.setVariableRate(variableRate);
        assertEquals(variableRate, rate.getVariableRate());
    }

    @Test
    void testGetSetRateForLifeInd() {
        Boolean rateForLifeInd = true;
        rate.setRateForLifeInd(rateForLifeInd);
        assertEquals(rateForLifeInd, rate.getRateForLifeInd());
    }

    @Test
    void testGetSetPromotionTerm() {
        PromotionTerm promotionTerm = new PromotionTerm();
        rate.setPromotionTerm(promotionTerm);
        assertEquals(promotionTerm, rate.getPromotionTerm());
    }

    @Test
    void testToString() {
        rate.setTypeCd("RATE123");
        rate.setFeatureClassificationCd("FEATURE1");
        rate.setFixedRate(new BigDecimal("5.5"));
        rate.setVariableRate(new VariableRate());
        rate.setPromotionTerm(new PromotionTerm());

        String expected = "com.td.api.mbofp.shared.Rate@" + Integer.toHexString(System.identityHashCode(rate)) +
                "[typeCd=RATE123,featureClassificationCd=FEATURE1,fixedRate=5.5,variableRate=<null>,promotionTerm=<null>]";
        assertTrue(rate.toString().contains(expected));
    }

    @Test
    void testHashCode() {
        rate.setTypeCd("RATE123");
        rate.setFeatureClassificationCd("FEATURE1");
        rate.setFixedRate(new BigDecimal("5.5"));
        rate.setVariableRate(new VariableRate());
        rate.setPromotionTerm(new PromotionTerm());

        int expectedHashCode = rate.getTypeCd().hashCode() * 31 + 
                               rate.getFeatureClassificationCd().hashCode() * 31 + 
                               rate.getFixedRate().hashCode() * 31 + 
                               rate.getVariableRate().hashCode() * 31 + 
                               rate.getPromotionTerm().hashCode();
        assertEquals(expectedHashCode, rate.hashCode());
    }

    @Test
    void testEqualsTrue() {
        Rate anotherRate = new Rate();
        anotherRate.setTypeCd("RATE123");
        anotherRate.setFeatureClassificationCd("FEATURE1");
        anotherRate.setFixedRate(new BigDecimal("5.5"));
        anotherRate.setVariableRate(new VariableRate());
        anotherRate.setPromotionTerm(new PromotionTerm());

        rate.setTypeCd("RATE123");
        rate.setFeatureClassificationCd("FEATURE1");
        rate.setFixedRate(new BigDecimal("5.5"));
        rate.setVariableRate(new VariableRate());
        rate.setPromotionTerm(new PromotionTerm());

        assertTrue(rate.equals(anotherRate));
    }

    @Test
    void testEqualsFalse() {
        Rate anotherRate = new Rate();
        anotherRate.setTypeCd("RATE456");
        anotherRate.setFeatureClassificationCd("FEATURE2");
        anotherRate.setFixedRate(new BigDecimal("6.5"));
        anotherRate.setVariableRate(new VariableRate());
        anotherRate.setPromotionTerm(new PromotionTerm());

        rate.setTypeCd("RATE123");
        rate.setFeatureClassificationCd("FEATURE1");
        rate.setFixedRate(new BigDecimal("5.5"));
        rate.setVariableRate(new VariableRate());
        rate.setPromotionTerm(new PromotionTerm());

        assertFalse(rate.equals(anotherRate));
    }

    @Test
    void testEqualsNull() {
        assertFalse(rate.equals(null));
    }

    @Test
    void testEqualsSameObject() {
        assertTrue(rate.equals(rate));
    }

    @Test
    void testEqualsDifferentClass() {
        String str = "Not a Rate";
        assertFalse(rate.equals(str));
    }
}
