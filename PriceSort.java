import java.util.Comparator;

public class PriceSort implements Comparator<Liquor> {
    @Override
    public int compare(Liquor liq1, Liquor liq2) {
        return Double.compare(liq1.getPriceSimple(), liq2.getPriceSimple());
    }
}
