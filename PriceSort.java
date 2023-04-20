import java.util.Comparator;

public class PriceSort implements Comparator<Drinks> {

    /**
     *
     * @param liq1 the first object to be compared.
     * @param liq2 the second object to be compared.
     * @return
     */
    @Override
    public int compare(final Drinks liq1, final Drinks liq2) {
        return Double.compare(liq1.getPriceSimple(), liq2.getPriceSimple());
    }
}
