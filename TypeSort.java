import java.util.Comparator;

public class TypeSort implements Comparator<Drinks> {
    public int compare(final Drinks liq1, final Drinks liq2) {
        return liq1.getType().compareTo(liq2.getType());
    }
}
