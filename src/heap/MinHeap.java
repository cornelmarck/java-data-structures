import java.util.Collection;

public class MinHeap<T extends Comparable<T>> extends Heap<T> {
    public MinHeap() {}

    public MinHeap(Collection<T> items) {
        super(items);
    }

    @Override
    boolean isWorse(int item, int than) {
        return get(item).compareTo(get(than)) > 0;
    }
}