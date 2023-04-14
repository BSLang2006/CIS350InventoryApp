import org.junit.*;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DrinksTest {

    @Test
    public void testGetBrand() {
        Drinks test = new Drinks("Gin", "Brand", 10.00, 40);
        assertEquals("Brand", test.getBrand());
    }


    @Test
    public void testSetBrand() {
        Drinks test = new Drinks("Type", null, 10.00, 40);
        test.setBrand("Brand");
        assertEquals("Brand", test.getBrand());
    }

    @Test
    public void testGetType() {
        Drinks test = new Drinks("Gin", "Brand", 10.00, 40);
        assertEquals("Gin", test.getType());
    }

    @Test
    public void testSetType() {
        Drinks test = new Drinks(null, null, 10.00, 40);
        test.setType("Type");
        assertEquals("Type", test.getType());
    }

    @Test
    public void testGetPrice() {
        Drinks test = new Drinks("Gin", "Brand", 10.00, 40);
        assertEquals("$10.00", test.getPrice());
    }

    @Test
    public void testSetPrice() {
        Drinks test = new Drinks("Gin", "Brand", 0, 40);
        test.setPrice(10.00);
        assertEquals("$10.00", test.getPrice());
    }

    @Test
    public void testGetVol() {
        Drinks test = new Drinks("Gin", "Brand", 10.00, 40);
        assertEquals(40, test.getVolume());
    }

    @Test
    public void testSetVol() {
        Drinks test = new Drinks("Gin", "Brand", 10.00, 0);
        test.setVolume(24);
        assertEquals(24, test.getVolume());
    }


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

        list2 = Drinks.findType(list,"Vodka");
        assertEquals(list2.get(0).getType(),"Gin");

        }

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

        list2 = Drinks.findBrand(list,"Jameson");
        assertEquals(list2.get(0).getBrand(),"Jameson");

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
