import java.text.DecimalFormat;

public class liquor {

    String type; // whiskey, vodka, etc.
    String brand;
    double price;
    int volume;

    DecimalFormat dollar = new DecimalFormat("$##.00");

    public liquor(String liqType, String liqBrand, double liqPrice, int liqVol) {
        type = liqType;
        brand = liqBrand;
        price = liqPrice;
        volume = liqVol;
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
}