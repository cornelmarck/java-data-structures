import java.util.Comparator;
import java.util.List;

public class HeapSort {

    public static <T extends Comparable<T>> void sort(List<T> items) {
        sort(items, Comparator.reverseOrder());
    }

    public static <T extends Comparable<T>> void sort(List<T> items, Comparator<T> comparator) {
        Heap<T> h = new Heap<>(items, comparator);

        for (int i = items.size() - 1; i >= 0; i--) {
            items.set(i, h.remove());
        }
    }
}

