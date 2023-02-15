import org.junit.*;
import static org.junit.Assert.*;

public class LiquorTest {

    @Test
    public void testGetBrand() {
        liquor test = new liquor("Gin", "Brand", 10.00, 40);
        assertEquals("Brand", test.getBrand());
    }
}
