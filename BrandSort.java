import java.util.Comparator;

class BrandSort implements Comparator<Drinks> {

    @Override
    public int compare(Drinks liq1, Drinks liq2) {
        return liq1.getBrand().compareTo(liq2.getBrand());
    }
}
