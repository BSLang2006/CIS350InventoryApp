import java.util.Comparator;

public class VolSort implements Comparator<Drinks> {
    @Override
    public int compare(Drinks liq1, Drinks liq2) {
        return Integer.compare(liq1.getVolume(), liq2.getVolume());
    }
}
