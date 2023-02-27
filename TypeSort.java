import java.util.Comparator;

public class TypeSort implements Comparator<Liquor> {
    public int compare(Liquor liq1, Liquor liq2) {
        return liq1.getType().compareTo(liq2.getType());
    }
}
