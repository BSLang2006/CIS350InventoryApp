import java.util.Comparator;

public class PriceSort implements Comparator<Drinks> {
    @Override
    public int compare(Drinks liq1, Drinks liq2) {
        return Double.compare(liq1.getPriceSimple(), liq2.getPriceSimple());
    }
}
