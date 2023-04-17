import java.util.Comparator;

public class PriceSort implements Comparator<Drinks> {

    /**
     *
     * @param liq1 the first object to be compared.
     * @param liq2 the second object to be compared.
     * @return
     */
    @Override
    public int compare(Drinks liq1, Drinks liq2) {
        return Double.compare(liq1.getPriceSimple(), liq2.getPriceSimple());
    }
}
