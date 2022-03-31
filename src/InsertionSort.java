import java.util.Comparator;
import java.util.List;

public class InsertionSort<T extends Comparable<T>> implements SortingAlgorithm<T>{


    @Override
    public void sort(List<T> items) {
        sort(items, Comparator.naturalOrder());
    }

    @Override
    public void sort(List<T> items, Comparator<T> comparator) {
        for (int j = 1; j < items.size(); j++) {
            T key = items.get(j);

            int i = j - 1;
            while (i >= 0 && key.compareTo(items.get(i)) < 0) {
                items.set(i, items.get(i + 1));
                i--;
            }
            items.set(i, key);
        }
    }
}
