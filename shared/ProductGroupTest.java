import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductGroupTest {

    private ProductGroup productGroup;

    @BeforeEach
    void setUp() {
        productGroup = new ProductGroup();
    }

    @Test
    void testGetSetProductGroupId() {
        String productGroupId = "123";
        productGroup.setProductGroupId(productGroupId);
        assertEquals(productGroupId, productGroup.getProductGroupId());
    }

    @Test
    void testGetSetProductGroupName() {
        String productGroupName = "Electronics";
        productGroup.setProductGroupName(productGroupName);
        assertEquals(productGroupName, productGroup.getProductGroupName());
    }

    @Test
    void testGetSetProductGroupDesc() {
        String productGroupDesc = "Description of electronics";
        productGroup.setProductGroupDesc(productGroupDesc);
        assertEquals(productGroupDesc, productGroup.getProductGroupDesc());
    }

    @Test
    void testToString() {
        productGroup.setProductGroupId("123");
        productGroup.setProductGroupName("Electronics");
        productGroup.setProductGroupDesc("Description of electronics");

        String expected = "com.td.api.mbofp.shared.ProductGroup@" + Integer.toHexString(System.identityHashCode(productGroup)) +
                "[productGroupId=123,productGroupName=Electronics,productGroupDesc=Description of electronics]";
        assertTrue(productGroup.toString().contains(expected));
    }

    @Test
    void testHashCode() {
        ProductGroup productGroup1 = new ProductGroup();
        productGroup1.setProductGroupId("123");
        productGroup1.setProductGroupName("Electronics");
        productGroup1.setProductGroupDesc("Description of electronics");

        ProductGroup productGroup2 = new ProductGroup();
        productGroup2.setProductGroupId("123");
        productGroup2.setProductGroupName("Electronics");
        productGroup2.setProductGroupDesc("Description of electronics");

        assertEquals(productGroup1.hashCode(), productGroup2.hashCode());
    }

    @Test
    void testEqualsTrue() {
        ProductGroup anotherProductGroup = new ProductGroup();
        anotherProductGroup.setProductGroupId("123");
        anotherProductGroup.setProductGroupName("Electronics");
        anotherProductGroup.setProductGroupDesc("Description of electronics");

        productGroup.setProductGroupId("123");
        productGroup.setProductGroupName("Electronics");
        productGroup.setProductGroupDesc("Description of electronics");

        assertTrue(productGroup.equals(anotherProductGroup));
    }

    @Test
    void testEqualsFalse() {
        ProductGroup anotherProductGroup = new ProductGroup();
        anotherProductGroup.setProductGroupId("456");
        anotherProductGroup.setProductGroupName("Clothing");
        anotherProductGroup.setProductGroupDesc("Description of clothing");

        productGroup.setProductGroupId("123");
        productGroup.setProductGroupName("Electronics");
        productGroup.setProductGroupDesc("Description of electronics");

        assertFalse(productGroup.equals(anotherProductGroup));
    }

    @Test
    void testEqualsNull() {
        assertFalse(productGroup.equals(null));
    }

    @Test
    void testEqualsSameObject() {
        assertTrue(productGroup.equals(productGroup));
    }

    @Test
    void testEqualsDifferentClass() {
        String str = "Not a ProductGroup";
        assertFalse(productGroup.equals(str));
    }
}
