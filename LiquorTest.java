import org.junit.*;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class LiquorTest {

    @Test
    public void testGetBrand() {
        Liquor test = new Liquor("Gin", "Brand", 10.00, 40);
        assertEquals("Brand", test.getBrand());
    }


    @Test
    public void testSetBrand() {
        Liquor test = new Liquor("Type", null, 10.00, 40);
        test.setBrand("Brand");
        assertEquals("Brand", test.getBrand());
    }

    @Test
    public void testGetType() {
        Liquor test = new Liquor("Gin", "Brand", 10.00, 40);
        assertEquals("Gin", test.getType());
    }

    @Test
    public void testSetType() {
        Liquor test = new Liquor(null, null, 10.00, 40);
        test.setType("Type");
        assertEquals("Type", test.getType());
    }

    @Test
    public void testGetPrice() {
        Liquor test = new Liquor("Gin", "Brand", 10.00, 40);
        assertEquals("$10.00", test.getPrice());
    }

    @Test
    public void testSetPrice() {
        Liquor test = new Liquor("Gin", "Brand", 0, 40);
        test.setPrice(10.00);
        assertEquals("$10.00", test.getPrice());
    }

    @Test
    public void testGetVol() {
        Liquor test = new Liquor("Gin", "Brand", 10.00, 40);
        assertEquals(40, test.getVolume());
    }

    @Test
    public void testSetVol() {
        Liquor test = new Liquor("Gin", "Brand", 10.00, 0);
        test.setVolume(24);
        assertEquals(24, test.getVolume());
    }

//    @Test
//    public void testFindBrand() {
//        ArrayList<Liquor> list = new ArrayList<>();
//
//        Liquor t1 = new Liquor("Gin", "Hendricks", 15.00, 24);
//        Liquor t2 = new Liquor("Whiskey", "Jameson", 15.00, 24);
//        Liquor t3 = new Liquor("Vodka", "Smirnoff", 15.00, 24);
//
//        list.add(t1);
//        list.add(t2);
//        list.add(t3);
//
//        ArrayList<Liquor> list2 = new ArrayList<>();
//        list2.add(Liquor.findBrand(list, "Jameson"));
//
//        assertEquals("Jameson", list2.get(0).getBrand());
//    }
//
//    @Test
//    public void testFindType() {
//        ArrayList<Liquor> list = new ArrayList<>();
//
//        Liquor t1 = new Liquor("Gin", "Hendricks", 15.00, 24);
//        Liquor t2 = new Liquor("Whiskey", "Jameson", 15.00, 24);
//        Liquor t3 = new Liquor("Vodka", "Smirnoff", 15.00, 24);
//
//        list.add(t1);
//        list.add(t2);
//        list.add(t3);
//
//        ArrayList<Liquor> list2 = new ArrayList<>();
//        list2.add(Liquor.findType(list, "Gin"));
//
//        assertEquals("Gin", list2.get(0).getType());
//    }

    @Test
    public void testTotalPrice() {

        ArrayList<Liquor> list = new ArrayList<>();

        Liquor t1 = new Liquor("Gin", "Hendricks", 15.00, 24);
        Liquor t2 = new Liquor("Whiskey", "Jameson", 15.00, 24);
        Liquor t3 = new Liquor("Vodka", "Smirnoff", 15.00, 24);

        list.add(t1);
        list.add(t2);
        list.add(t3);

        assertEquals("$45.00", Liquor.totalPrice(list));
    }
}
