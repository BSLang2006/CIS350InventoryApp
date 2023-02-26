import java.util.Comparator;

class BrandSort implements Comparator<Liquor> {

    @Override
    public int compare(Liquor o1, Liquor o2) {
        return o1.getBrand().compareTo(o2.getBrand());
    }
}
