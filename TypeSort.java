import java.util.Comparator;

public class TypeSort implements Comparator<Drinks> {
    public int compare(Drinks liq1, Drinks liq2) {
        return liq1.getType().compareTo(liq2.getType());
    }
}
