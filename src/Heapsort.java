import java.util.Comparator;
import java.util.List;

public class Heapsort {
    public static <T extends Comparable<T>> void sort(List<T> items) {
        Heap<T> h = new Heap<>(items);

        for (int i = items.size() - 1; i >= 0; i--) {
            items.set(i, h.remove());
        }
    }

    public static <T extends Comparable<T>> void sortInverse(List<T> items) {
        Heap<T> h = new Heap<>(items, Comparator.reverseOrder());

        for (int i = items.size() - 1; i >= 0; i--) {
            items.set(i, h.remove());
        }
    }
}
