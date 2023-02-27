import java.util.Comparator;

class BrandSort implements Comparator<Liquor> {

    @Override
    public int compare(Liquor liq1, Liquor liq2) {
        return liq1.getBrand().compareTo(liq2.getBrand());
    }
}
