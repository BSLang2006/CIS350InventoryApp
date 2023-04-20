import java.text.DecimalFormat;
import java.util.ArrayList;

public class Drinks {

    /**
     * The drink's type (whiskey, vodka, etc.).
     */
    private String type;

    /**
     * The drink's brand (Patron, Smirnoff, etc.).
     */
    private String brand;

    /**
     * The drink's price.
     */
    private double price;

    /**
     * The volume of the drink.
     */
    private int volume;

    /**
     * Formatting to currency format.
     */
    private static DecimalFormat dollar = new DecimalFormat("$##.00");

    /**
     * Drink constructor.
     * @param drinkType the drink's type.
     * @param drinkBrand the drink's brand.
     * @param drinkPrice the drink's price.
     * @param drinkVol the drink's volume.
     */
    public Drinks(final String drinkType, final String drinkBrand,
                  final double drinkPrice, final int drinkVol) {
        type = drinkType;
        brand = drinkBrand;
        price = drinkPrice;
        volume = drinkVol;
    }

    /**
     * Brand setter.
     * @param brand the drink's brand.
     */
    public void setBrand(final String brand) {
        this.brand = brand;
    }

    /**
     * Brand getter.
     * @return brand.
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Type setter.
     * @param type the drink's type.
     */
    public void setType(final String type) {
        this.type = type;
    }

    /**
     * Type getter.
     * @return the drink's type.
     */
    public String getType() {
        return type;
    }

    /**
     * Price setter.
     * @param price the drink's price.
     */
    public void setPrice(final double price) {
//        this.price = price;
        if (price > 0) {
            this.price = price;
        } else {
            throw new IllegalArgumentException("Error setting price");
        }
    }

    /**
     * Price getter.
     * @return formatted price.
     */
    public String getPrice() {
        return dollar.format(price);
    }

    /**
     * Returns unformatted price.
     * @return unformatted price.
     */
    public double getPriceSimple() {
        return price;
    }

    /**
     * Volume setter.
     * @param volume the drink's volume.
     */
    public void setVolume(final int volume) {
        if (volume > 0) {
            this.volume = volume;
        } else {
            throw new IllegalArgumentException("Error setting volume");
        }
    }

    /**
     * Volume getter.
     * @return volume.
     */
    public int getVolume() {
        return volume;
    }

    /**
     * toString for drinks.
     * @return string formatted drink.
     */
    public String toString() {
        return "Brand: " + this.getBrand() + ", Type: " + this.type
                + ", Price: " + dollar.format(this.price)
                + ", Volume (oz): " + this.volume;
    }

    /**
     * Filters types for drinks.
     * @param list the list of drinks.
     * @param s the type.
     * @return list of filtered drinks.
     */
    public static ArrayList<Drinks> findType(final ArrayList<Drinks> list,
                                             final String s) {
        ArrayList<Drinks> tempList = new ArrayList<>();
        for (Drinks drinks : list) {
            if (drinks.getType().equalsIgnoreCase(s)) {
                tempList.add(drinks);
            }
        }
        return tempList;
    }

    /**
     * Filter brands of drink.
     * @param list the list of drinks.
     * @param s the brand.
     * @return list of filtered drinks.
     */
    public static ArrayList<Drinks> findBrand(final ArrayList<Drinks> list,
                                              final String s) {
        ArrayList<Drinks> tempList = new ArrayList<>();
        for (Drinks drinks : list) {
            if (drinks.getBrand().equalsIgnoreCase(s)) {
                tempList.add(drinks);
            }
        }
        return tempList;
    }

    /**
     * Adds up the price of the inventory.
     * @param list the list of drinks
     * @return price of inventory.
     */
    public static String totalPrice(final ArrayList<Drinks> list) {
        double price = 0.0;
        for (Drinks drinks : list) {
            price = price + drinks.getPriceSimple();
        }
        return dollar.format(price);
    }
}
