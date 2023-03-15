// Your First Program\
import java.util.Scanner;
import java.util.ArrayList;

public class BarManager {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in).useDelimiter("\\n");
        System.out.println("Welcome to Bar Inventory Manager");

        Drinks smirnoff = new Drinks("Vodka", "Smirnoff", 12.00, 40);
        Drinks ciroc = new Drinks("Vodka", "Ciroc", 12.00, 40);
        Drinks bombaySapphire = new Drinks("Gin", "Bombay", 14.00, 24);
        Drinks patron = new Drinks("Tequila", "Patron", 15.00, 16);
        Drinks jack = new Drinks("Whiskey", "Jack Daniels", 15.00, 40);

        ArrayList<Drinks> drinksList = new ArrayList<>();
        drinksList.add(smirnoff);
        drinksList.add(ciroc);
        drinksList.add(bombaySapphire);
        drinksList.add(patron);
        drinksList.add(jack);

        Drinks testDrinks = new Drinks(null, null, 0, 0);
        testDrinks.setBrand("Brand");
        testDrinks.setPrice(25.50);
        testDrinks.setType("Gin");
        testDrinks.setVolume(24);

        drinksList.add(testDrinks);

        System.out.println("Current Inventory: ");
        Drinks.printInventory(drinksList);

        String userInput;
        System.out.println("Would you like to add to inventory? (y/n)");
        userInput = scanner.next();

        if (userInput.equals("y")) {
            while (!userInput.equals("n")) {
                Drinks item = new Drinks(null, null, 0, 0);
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
                drinksList.add(item);
                System.out.println("Would you like to add more? (y/n)");
                userInput = scanner.next();
            }
        }

        // printing updated liquorList
        System.out.println("Updated Inventory:");
        Drinks.printInventory(drinksList);

        System.out.println("----------------------------");
        System.out.println("Testing sorting by brand");
        drinksList.sort(new BrandSort());
        Drinks.printInventory(drinksList);

        System.out.println("----------------------------");
        System.out.println("Testing sorting by type");
        drinksList.sort(new TypeSort());
        Drinks.printInventory(drinksList);

        System.out.println("----------------------------");
        System.out.println("Testing sorting by price");
        drinksList.sort(new PriceSort());
        Drinks.printInventory(drinksList);

        System.out.println("----------------------------");
        System.out.println("Testing sorting by volume");
        drinksList.sort(new VolSort());
        Drinks.printInventory(drinksList);

        System.out.println("----------------------------");
        System.out.println("Returning only a type");
        Drinks.findType(drinksList, "Vodka");

        System.out.println("----------------------------");
        System.out.println("Returning only a brand");
        Drinks.findBrand(drinksList, "Jack Daniels");

        System.out.println("----------------------------");
        System.out.println("Total Price");
        System.out.println(Drinks.totalPrice(drinksList));

        System.out.println("-----------------------------");
        System.out.println("Adding beer");
        Beer beer = new Beer("Beer", "Bud Light", 2, 12);
        drinksList.add(beer);
        Beer.printInventory(drinksList);

        System.out.println("-----------------------------");
        System.out.println("Adding soda");
        NonAlcohol coke = new NonAlcohol("Soda", "Coca Cola", 2, 12);
        drinksList.add(coke);
        Drinks.printInventory(drinksList);

        System.out.println("-----------------------------");
        System.out.println("Removing a drink (ciroc)");
        Drinks.removeDrink("Ciroc", "Vodka", drinksList);
        Drinks.printInventory(drinksList);

        System.out.println("-----------------------------");
        System.out.println("Emptying a drink");
        smirnoff.setVolume(0);
        Drinks.printInventory(drinksList);
        System.out.println("BEFORE");
        Drinks.removeEmpty(drinksList);
        System.out.println("AFTER");
        Drinks.printInventory(drinksList);
    }
}
