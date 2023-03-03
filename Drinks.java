import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * This holds all of our functions for drinks.
 */
public class Drinks {

    String type; // whiskey, vodka, etc.
    String brand;
    double price;
    int volume;

    static DecimalFormat dollar = new DecimalFormat("$##.00");

    /**
     * Constructor for Drinks.
     *
     * @param drinkType;
     * @param drinkBrand;
     * @param drinkPrice;
     * @param drinkVol;
     */
    public Drinks(String drinkType, String drinkBrand,
                  double drinkPrice, int drinkVol) {
        type = drinkType;
        brand = drinkBrand;
        price = drinkPrice;
        volume = drinkVol;
    }

    /**
     * Set the brand of the drink.
     *
     * @param brand;
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Fetch the brand of the drink.
     *
     * @return brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Set the type of the drink.
     *
     * @param type;
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Get the type of the drink.
     *
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * Set the price of the drink.
     *
     * @param price;
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Get the price of the drink, formatted using DecimalFormatter.
     *
     * @return price
     */
    public String getPrice() {
        return dollar.format(price);
    }

    /**
     * Returns an unformatted double of the price.
     * @return price
     */
    public double getPriceSimple() {
        return price;
    }

    /**
     * Set the volume of the bottle.
     * @param volume;
     */
    public void setVolume(int volume) {
        this.volume = volume;
    }

    /**
     * Get the volume of the bottle.
     *
     * @return volume
     */
    public int getVolume() {
        return volume;
    }

    /**
     * Returns a drink as a string.
     * @return a detailed string of items in the inventory
     */
    public String toString() {
        return "Type: " + this.type + ", Price: "
                + dollar.format(this.price) + ", Brand: "
                + this.brand + ", Volume (oz): " + this.volume;
    }

    /**
     * Used to print our list of drinks.
     * @param list;
     */
    public static void printInventory(ArrayList<Drinks> list) {
        for (Drinks drinks : list) {
            System.out.println(drinks);
        }
    }

    /**
     * Given a type (as a String), find items in the list that match.
     *
     * @param list;
     * @param s;
     */
    public static void findType(ArrayList<Drinks> list, String s) {
        for (Drinks drinks : list) {
            if (drinks.getType().equalsIgnoreCase(s)) {
                System.out.println(drinks);
            }
        }
    }

    /**
     * Given a brand, find items that match that brand.
     *
     * @param list;
     * @param s;
     */
    public static void findBrand(ArrayList<Drinks> list, String s) {
        for (Drinks drinks : list) {
            if (drinks.getBrand().equalsIgnoreCase(s)) {
                System.out.println(drinks);
            }
        }
    }

    /**
     * Using getPriceSimple, adds up the price of everything in the
     * inventory.
     *
     * @param list;
     * @return dollar;
     */
    public static String totalPrice(ArrayList<Drinks> list) {
        double price = 0.0;
        for (Drinks drinks : list) {
            price = price + drinks.getPriceSimple();
        }
        return dollar.format(price);
    }

    /**
     * Given a brand and type, remove drinks that match those parameters
     * from the list.
     *
     * @param brand;
     * @param type;
     * @param list;
     */
    public static void removeDrink(String brand, String type,
                                   ArrayList<Drinks> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getBrand().equalsIgnoreCase(brand)
            && list.get(i).getType().equalsIgnoreCase(type)) {
                list.remove(i);
            }
        }
    }

    /**
     * Remove drinks from the list that are empty.
     *
     * @param list;
     */
    public static void removeEmpty(ArrayList<Drinks> list) {
        int i;
        for (i = 0; i < list.size(); i++) {
            if (list.get(i).getVolume() == 0) {
                list.remove(i);
            }
        }
    }
}
