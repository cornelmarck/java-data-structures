import java.util.Collection;

public class MaxHeap<T extends Comparable<T>> extends AbstractHeap<T> {
    public MaxHeap() {}

    public MaxHeap(Collection<T> items) {
        super(items);
    }

    @Override
    boolean isWorse(int item, int than) {
        return get(item).compareTo(get(than)) < 0;
    }
}
