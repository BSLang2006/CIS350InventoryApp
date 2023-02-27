import java.util.Comparator;

public class VolSort implements Comparator<Liquor> {
    @Override
    public int compare(Liquor liq1, Liquor liq2) {
        return Integer.compare(liq1.getVolume(), liq2.getVolume());
    }
}
