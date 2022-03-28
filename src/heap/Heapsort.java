import java.util.List;

public class Heapsort {
    public static <T extends Comparable<T>> void sort(List<T> items) {
        PriorityQueue<T> h = new Heap<>(HeapType.MAX, items);

        for (int i = items.size() - 1; i >= 0; i--) {
            items.set(i, h.remove());
        }
    }

    public static <T extends Comparable<T>> void sortInverse(List<T> items) {
        PriorityQueue<T> h = new Heap<>(HeapType.MIN, items);

        for (int i = items.size() - 1; i >= 0; i--) {
            items.set(i, h.remove());
        }
    }
}
