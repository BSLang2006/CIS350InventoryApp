// Your First Program\
import java.util.*;

class BarManager{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in).useDelimiter("\\n");
        System.out.println("Welcome to Bar Inventory Manager"); 
    
        int volume = 1;
    
        Liquor Smirnoff = new Liquor("Vodka", "Smirnoff", 12.00, 40);
        Liquor Ciroc = new Liquor("Vodka", "Ciroc", 12.00, 40);
        Liquor BombaySapphire = new Liquor("Gin", "Bombay", 14.00, 24);
        Liquor Patron = new Liquor("Tequila", "Patron", 15.00, 16);
        Liquor Jack = new Liquor("Whiskey", "Jack Daniels", 15.00, 40);

        ArrayList<Liquor> liquorList = new ArrayList<>();
        liquorList.add(Smirnoff);
        liquorList.add(Ciroc);
        liquorList.add(BombaySapphire);
        liquorList.add(Patron);
        liquorList.add(Jack);

        Liquor testLiquor = new Liquor(null, null, volume, volume);
        testLiquor.setBrand("Brand");
        testLiquor.setPrice(25.50);
        testLiquor.setType("Gin");
        testLiquor.setVolume(24);

        liquorList.add(testLiquor);

        System.out.println("Current Inventory: ");
        Liquor.printInventory(liquorList);

        String userInput;
        System.out.println("Would you like to add to inventory? (y/n)");
        userInput = scanner.next();

        if (userInput.equals("y")) {
            while (!userInput.equals("n")) {
                Liquor item = new Liquor(null, null, 0, 0);
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
        System.out.println("Updated Inventory:");
        Liquor.printInventory(liquorList);

        System.out.println("----------------------------");
        System.out.println("Testing sorting by brand");
        liquorList.sort(new BrandSort());
        Liquor.printInventory(liquorList);

        System.out.println("----------------------------");
        System.out.println("Testing sorting by type");
        liquorList.sort(new TypeSort());
        Liquor.printInventory(liquorList);

        System.out.println("----------------------------");
        System.out.println("Testing sorting by price");
        liquorList.sort(new PriceSort());
        Liquor.printInventory(liquorList);

        System.out.println("----------------------------");
        System.out.println("Testing sorting by volume");
        liquorList.sort(new VolSort());
        Liquor.printInventory(liquorList);

        System.out.println("----------------------------");
        System.out.println("Returning only a type");
        Liquor.findType(liquorList, "Vodka");

        System.out.println("----------------------------");
        System.out.println("Returning only a brand");
        Liquor.findBrand(liquorList, "Jack Daniels");

        System.out.println("----------------------------");
        System.out.println("Total Price");
        System.out.println(Liquor.totalPrice(liquorList));
    }
}
