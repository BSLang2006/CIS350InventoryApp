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
        this.price = price;
    }

    public String getPrice() {
        return dollar.format(price);
    }

    public double getPriceSimple() {
        return price;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }

    public String toString() {
        return "Type: " + this.type + ", Price: " + dollar.format(this.price) + ", Brand: "
                + this.brand + ", Volume (oz): " + this.volume;
    }
    public static void printInventory(ArrayList<Drinks> list) {
        for (Drinks drinks : list) {
            System.out.println(drinks);
        }
    }

//    public static ArrayList<Liquor> findType (ArrayList<Liquor> list, String s) {
//
//        ArrayList<Liquor> filteredList = new ArrayList<>();
//        for (Liquor liquor : list) {
//            if (liquor.getType().equalsIgnoreCase(s)) {
//                filteredList.add(liquor);
//            }
//        }
//        return filteredList;
//    }

    public static void findType (ArrayList<Drinks> list, String s) {
        for (Drinks drinks : list) {
            if (drinks.getType().equalsIgnoreCase(s)) {
                System.out.println(drinks);
            }
        }
    }

//    public static Liquor findBrand (ArrayList<Liquor> list, String s) {
//        for (Liquor liquor : list) {
//            if (liquor.getBrand().equalsIgnoreCase(s)) {
//                System.out.println(liquor);
//                return liquor;
//            }
//        }
//        return null;
//    }

    public static void findBrand (ArrayList<Drinks> list, String s) {
        for (Drinks drinks : list) {
            if (drinks.getBrand().equalsIgnoreCase(s)) {
                System.out.println(drinks);
            }
        }
    }
    public static String totalPrice(ArrayList<Drinks> list) {
        double price = 0.0;
        for (Drinks drinks : list) {
            price = price + drinks.getPriceSimple();
        }
        return dollar.format(price);
    }
}