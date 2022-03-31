import java.util.Collection;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class Heap<T extends Comparable<T>> extends CompleteBinaryTree<T> {
    Comparator<T> comparator;

    public Heap() {
        this(Comparator.naturalOrder());
    }

    public Heap(Comparator<T> comparator) {
        super();
        this.comparator = comparator;
    }

    public Heap(Collection<T> items) {
        this(items, Comparator.naturalOrder());
    }

    public Heap(Collection<T> items, Comparator<T> comparator) {
        super(items);
        this.comparator = comparator;
        heapify();
    }

    private void heapify() {
        for (int i = size()/2 - 1; i >= 0; i--) {
            sink(i);
        }
    }

    private void sink(int k) {
        while (left(k) < size()) {
            int child;

            if (right(k) < size() && comparator.compare(get(left(k)), get(right(k))) >= 0) {
                child = right(k);
            }
            else {
                child = left(k);
            }

            if (comparator.compare(get(k), get(child)) < 0) {
                break;
            }
            swap(k, child);
            k = child;
        }
    }

    public void insert(T item) {
        nodes.add(item);
        swim(size() - 1);
    }

    public T remove() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }
        T root = nodes.get(0);
        swap(0, size() - 1);
        nodes.remove(size() - 1);
        sink(0);

        return root;
    }

    private void swim(int k) {
        while (k > 0 && comparator.compare(get(parent(k)), get(k)) >= 0) {
            swap(k, parent(k));
            k = parent(k);
        }
    }
}
