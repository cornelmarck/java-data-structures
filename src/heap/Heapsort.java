import java.util.List;

public class Heapsort {
    public static <T extends Comparable<T>> void sort(List<T> items) {
        AbstractHeap<T> h = new MaxHeap<>(items);

        for (int i = items.size() - 1; i >= 0; i--) {
            items.set(i, h.remove());
        }
    }

    public static <T extends Comparable<T>> void sortInverse(List<T> items) {
        AbstractHeap<T> h = new MinHeap<>(items);

        for (int i = items.size() - 1; i >= 0; i--) {
            items.set(i, h.remove());
        }
    }
}
