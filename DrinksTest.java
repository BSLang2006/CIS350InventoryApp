import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

public class DrinksTest {

    /**
     * Tests getting the brand.
     */
    @Test
    public void testGetBrand() {
        Drinks test = new Drinks("Gin", "Brand", 10.00, 40);
        assertEquals("Brand", test.getBrand());
    }

    /**
     * Tests setting the brand.
     */
    @Test
    public void testSetBrand() {
        Drinks test = new Drinks("Type", null, 10.00, 40);
        test.setBrand("Brand");
        assertEquals("Brand", test.getBrand());
    }

    /**
     * Tests getting the type.
     */
    @Test
    public void testGetType() {
        Drinks test = new Drinks("Gin", "Brand", 10.00, 40);
        assertEquals("Gin", test.getType());
    }

    /**
     * Tests setting the type.
     */
    @Test
    public void testSetType() {
        Drinks test = new Drinks(null, null, 10.00, 40);
        test.setType("Type");
        assertEquals("Type", test.getType());
    }

    /**
     * Tests getting the price.
     */
    @Test
    public void testGetPrice() {
        Drinks test = new Drinks("Gin", "Brand", 10.00, 40);
        assertEquals("$10.00", test.getPrice());
    }

    /**
     * Tests setting the price.
     */
    @Test
    public void testSetPrice() {
        Drinks test = new Drinks("Gin", "Brand", 0, 40);
        test.setPrice(10.00);
        assertEquals("$10.00", test.getPrice());
    }

    /**
     * Tests getting the volume.
     */
    @Test
    public void testGetVol() {
        Drinks test = new Drinks("Gin", "Brand", 10.00, 40);
        assertEquals(40, test.getVolume());
    }

    /**
     * Tests setting the volume.
     */
    @Test
    public void testSetVol() {
        Drinks test = new Drinks("Gin", "Brand", 10.00, 0);
        test.setVolume(24);
        assertEquals(24, test.getVolume());
    }

    /**
     * Tests making sure setting a negative volume throws an error.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetVolumeNegative() {
        Drinks test = new Drinks("Gin", "Brand", 10.00, 0);
        test.setVolume(-24);
    }

    /**
     * Tests making sure setting a negative price throws an error.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetPriceNegative() {
        Drinks test = new Drinks("Gin", "Brand", 0, 64);
        test.setPrice(-64);

    }

    /**
     * Tests filtering by type.
     */
    @Test
    public void testFindType() {
        ArrayList<Drinks> list = new ArrayList<>();
        ArrayList<Drinks> list2;

        Drinks t1 = new Drinks("Gin", "Hendricks", 15.00, 24);
        Drinks t2 = new Drinks("Whiskey", "Jameson", 15.00, 24);
        Drinks t3 = new Drinks("Vodka", "Smirnoff", 15.00, 24);

        list.add(t1);
        list.add(t2);
        list.add(t3);

        list2 = Drinks.findType(list, "Vodka");

        System.out.println(list2);
        assertEquals(list2.get(0).getType(), "Vodka");
    }

    /**
     * Tests filtering by brand.
     */
    @Test
    public void testFindBrand() {
        ArrayList<Drinks> list = new ArrayList<>();
        ArrayList<Drinks> list2;

        Drinks t1 = new Drinks("Gin", "Hendricks", 15.00, 24);
        Drinks t2 = new Drinks("Whiskey", "Jameson", 15.00, 24);
        Drinks t3 = new Drinks("Vodka", "Smirnoff", 15.00, 24);

        list.add(t1);
        list.add(t2);
        list.add(t3);

        list2 = Drinks.findBrand(list, "Jameson");
        assertEquals(list2.get(0).getBrand(), "Jameson");
    }

    /**
     * Tests adding up the total price.
     */
    @Test
    public void testTotalPrice() {

        ArrayList<Drinks> list = new ArrayList<>();

        Drinks t1 = new Drinks("Gin", "Hendricks", 15.00, 24);
        Drinks t2 = new Drinks("Whiskey", "Jameson", 15.00, 24);
        Drinks t3 = new Drinks("Vodka", "Smirnoff", 15.00, 24);

        list.add(t1);
        list.add(t2);
        list.add(t3);

        assertEquals("$45.00", Drinks.totalPrice(list));
    }
}
