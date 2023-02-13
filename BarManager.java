// Your First Program\
import java.util.*;

class BarManager{
    public static void main(String[] args) {
        System.out.println("Welcome to Bar Inventory Manager"); 
    
        int volume = 1;

        // System.out.printf("Volume of the first bottle is: %d", volume);


        // LiquorType();
        //I don't remember Java that well. I am trying to remember what structures to use
        //for each functionality. Do we use an array of strings for a list of liquor types or brands?
        // I need to look at my old java programs, I remember using classes to manage other classes
    
        // liquor Jack = new liquor();

        // Jack.type = "Whiskey";
        // Jack.price = 10.00;
        // Jack.brand = "Jack Daniels";
        // Jack.volume = 40;

        // System.out.println(Jack.brand + " is a " + Jack.type);
        // System.out.println("It costs $" + Jack.price + ". Volume = " + Jack.volume);
    
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
    }

}