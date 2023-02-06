public class liquor {
    // private short amount = -1;
    
    // public void setAmount(int selectedAmount) {
    //     this.amount = selectedAmount;
    // }

    // public int getAmount() {
    //     return amount;
    // }

    String type; // whiskey, vodka, etc.
    String brand;
    double price;
    int volume;

    public liquor(String liqType, String liqBrand, double liqPrice, int liqVol) {
        type = liqType;
        brand = liqBrand;
        price = liqPrice;
        volume = liqVol;
    }

    public void setBrand(String b) {
        this.brand = b;
    }

    public String getBrand() {
        return brand;
    }
}