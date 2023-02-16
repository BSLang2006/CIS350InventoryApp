// Your First Program\
import java.util.*;

class BarManager{
    public static void main(String[] args) {
        System.out.println("Welcome to Bar Inventory Manager"); 
    
        int volume = 1;
    
        liquor Smirnoff = new liquor("Vodka", "Smirnoff", 12.00, 40);
        liquor Ciroc = new liquor("Vodka", "Ciroc", 12.00, 40);
        liquor BombaySapphire = new liquor("Gin", "Bombay", 14.00, 24);
        liquor Patron = new liquor("Tequila", "Patron", 15.00, 16);
        liquor Jack = new liquor("Whiskey", "Jack Daniels", 15.00, 40);

        ArrayList<liquor> liquorList = new ArrayList<>();
        liquorList.add(Smirnoff);
        liquorList.add(Ciroc);
        liquorList.add(BombaySapphire);
        liquorList.add(Patron);
        liquorList.add(Jack);

        liquor testLiquor = new liquor(null, null, volume, volume);
        testLiquor.setBrand("Brand");
        testLiquor.setPrice(25.00);
        testLiquor.setType("Gin");
        testLiquor.setVolume(24);

        liquorList.add(testLiquor);

        for (liquor liquor : liquorList) {
            System.out.println(liquor.getBrand());
        }

        System.out.println(testLiquor);
        System.out.println(Jack);
    }
}