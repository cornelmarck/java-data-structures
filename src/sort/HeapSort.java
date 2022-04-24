package sort;

import data_structures.Heap;
import java.util.Comparator;
import java.util.List;

public class HeapSort<T extends Comparable<T>> implements SortingAlgorithm<T> {
    @Override
    public void sort(List<T> items) {
        sort(items, Comparator.reverseOrder());
    }

    @Override
    public void sort(List<T> items, Comparator<T> comparator) {
        Heap<T> h = new Heap<T>(items, comparator);

        for (int i = items.size() - 1; i >= 0; i--) {
            items.set(i, h.remove());
        }
    }
}

