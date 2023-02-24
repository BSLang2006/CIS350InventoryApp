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

    @Test
    public void testGetPrice() {
        liquor test = new liquor("Gin", "Brand", 10.00, 40);
        assertEquals("$10.00", test.getPrice());
    }

    @Test
    public void testSetPrice() {
        liquor test = new liquor("Gin", "Brand", 0, 40);
        test.setPrice(10.00);
        assertEquals("$10.00", test.getPrice());
    }

    @Test
    public void testGetVol() {
        liquor test = new liquor("Gin", "Brand", 10.00, 40);
        assertEquals(40, test.getVolume());
    }

    @Test
    public void testSetVol() {
        liquor test = new liquor("Gin", "Brand", 10.00, 0);
        test.setVolume(24);
        assertEquals(24, test.getVolume());
    }
}
