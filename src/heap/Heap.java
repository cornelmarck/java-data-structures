import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

public abstract class Heap<T extends Comparable<T>> extends CompleteBinaryTree<T> implements PriorityQueue<T> {
    public Heap() {}

    public Heap(Collection<T> items) {
        super(items);
        heapify();
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

    private void heapify() {
        for (int i = size() - 1; i >= 0; i--) {
            sink(i);
        }
    }

    private void sink(int k) {
        while (left(k) < size()) {
            int child;
            if (right(k) < size() && isWorse(left(k), right(k))) {
                child = right(k);
            }
            else {
                child = left(k);
            }

            if (!isWorse(k, child)) {
                break;
            }
            swap(k, child);
            k = child;
        }
    }

    private void swim(int k) {
        while (k > 0 && isWorse(parent(k), k)) {
            swap(k, parent(k));
            k = parent(k);
        }
    }

    abstract boolean isWorse(int item, int than);

}
