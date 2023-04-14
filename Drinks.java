import java.text.DecimalFormat;
import java.util.ArrayList;

public class Drinks {

    String type; // whiskey, vodka, etc.
    String brand;
    double price;
    int volume;

    static DecimalFormat dollar = new DecimalFormat("$##.00");

    public Drinks(String drinkType, String drinkBrand, double drinkPrice, int drinkVol) {
        type = drinkType;
        brand = drinkBrand;
        price = drinkPrice;
        volume = drinkVol;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setPrice(double price) {
//        this.price = price;
        if (price > 0) {
            this.price = price;
        }
        else {
            throw new IllegalArgumentException("Error setting price");
        }
    }

    public String getPrice() {
        return dollar.format(price);
    }

    public double getPriceSimple() {
        return price;
    }

    public void setVolume(int volume) {
//        this.volume = volume;
        if (volume > 0) {
            this.volume = volume;
        }
        else {
            throw new IllegalArgumentException("Error setting volume");
        }
    }

    public int getVolume() {
        return volume;
    }

    public String toString() {
        return "Brand: " + this.getBrand() + ", Type: " + this.type + ", Price: " + dollar.format(this.price) +
                ", Volume (oz): " + this.volume;
    }
//    public static void printInventory(ArrayList<Drinks> list) {
//        for (Drinks drinks : list) {
//            System.out.println(drinks);
//        }
//    }

    public static ArrayList<Drinks> findType (ArrayList<Drinks> list, String s) {
        ArrayList<Drinks> tempList = new ArrayList<>();
        for (Drinks drinks : list) {
            if (drinks.getType().equalsIgnoreCase(s)) {
                tempList.add(drinks);
            }
        }
        return tempList;
    }

    public static ArrayList<Drinks> findBrand (ArrayList<Drinks> list, String s) {
        ArrayList<Drinks> tempList = new ArrayList<>();
        for (Drinks drinks : list) {
            if (drinks.getBrand().equalsIgnoreCase(s)) {
                tempList.add(drinks);
            }
        }
        return tempList;
    }
    public static String totalPrice(ArrayList<Drinks> list) {
        double price = 0.0;
        for (Drinks drinks : list) {
            price = price + drinks.getPriceSimple();
        }
        return dollar.format(price);
    }
}