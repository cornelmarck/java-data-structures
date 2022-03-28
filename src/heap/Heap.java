import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.function.BiPredicate;

public class Heap<T extends Comparable<T>> extends CompleteBinaryTree<T> implements PriorityQueue<T> {
    BiPredicate<Integer, Integer> isWorse;

    public Heap(HeapType type) {
        setHeapType(type);
    }

    private void setHeapType(HeapType type) {
        if (type == HeapType.MIN) {
            isWorse = (item, than) -> get(item).compareTo(get(than)) > 0;
        }
        else if (type == HeapType.MAX) {
            isWorse = (item, than) -> get(item).compareTo(get(than)) < 0;
        }
        else {
            throw new IllegalArgumentException("Heap type does not exist");
        }
    }

    public Heap(HeapType type, Collection<T> items) {
        super(items);
        setHeapType(type);
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
            if (right(k) < size() && isWorse.test(left(k), right(k))) {
                child = right(k);
            }
            else {
                child = left(k);
            }

            if (!isWorse.test(k, child)) {
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
        while (k > 0 && isWorse.test(parent(k), k)) {
            swap(k, parent(k));
            k = parent(k);
        }
    }
}
