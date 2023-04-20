import java.util.Comparator;

public class VolSort implements Comparator<Drinks> {
    @Override
    public int compare(final Drinks liq1, final Drinks liq2) {
        return Integer.compare(liq1.getVolume(), liq2.getVolume());
    }
}
