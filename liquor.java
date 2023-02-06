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

    public liquor(String t, String b, double p, int vol) {
        type = t;
        brand = b;
        price = p;
        volume = vol;
    }
}