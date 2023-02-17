// Your First Program\
import java.util.*;

class BarManager{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

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
        testLiquor.setPrice(25.50);
        testLiquor.setType("Gin");
        testLiquor.setVolume(24);

        liquorList.add(testLiquor);

//        for (liquor liquor : liquorList) {
//            System.out.println(liquor.getBrand());
//        }

        // Testing toString method
//        System.out.println(testLiquor);
//        System.out.println(Jack);

        System.out.println("Current Inventory: ");
        for (liquor liquor : liquorList) {
            System.out.println(liquor);
        }

        String userInput;
        System.out.println("Would you like to add to inventory? (y/n)");
        userInput = scanner.next();

        if (userInput.equals("y")) {
            while (!userInput.equals("n")) {
                liquor item = new liquor(null, null, 0, 0);
                System.out.println("Enter Type: ");
                String newType = scanner.next();
                System.out.println("Enter Brand: ");
                String newBrand = scanner.next();
                System.out.println("Enter Price: ");
                double newPrice = scanner.nextDouble();
                System.out.println("Enter Volume: ");
                int newVol = scanner.nextInt();
                item.setVolume(newVol);
                item.setPrice(newPrice);
                item.setBrand(newBrand);
                item.setType(newType);
                liquorList.add(item);
                System.out.println("Would you like to add more? (y/n)");
                userInput = scanner.next();
            }
        }

        // printing updated liquorList
        for (liquor liquor : liquorList) {
            System.out.println(liquor);
        }


    }
}