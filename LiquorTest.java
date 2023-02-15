import org.junit.*;
import static org.junit.Assert.*;

public class LiquorTest {

    @Test
    public void testGetBrand() {
        liquor test = new liquor("Gin", "Brand", 10.00, 40);
        assertEquals("Brand", test.getBrand());
    }

    @Test
    public void testSetBrand() {
        liquor test = new liquor("Type", null, 10.00, 40);
        test.setBrand("Brand");
        assertEquals("Brand", test.getBrand());
    }

    @Test
    public void testGetType() {
        liquor test = new liquor("Gin", "Brand", 10.00, 40);
        assertEquals("Gin", test.getType());
    }

    @Test
    public void testSetType() {
        liquor test = new liquor(null, null, 10.00, 40);
        test.setType("Type");
        assertEquals("Type", test.getType());
    }
}
