package sort;

import java.util.Comparator;
import java.util.List;

public class SimpleQuickSort<T extends Comparable<T>> implements SortingAlgorithm<T> {

    @Override
    public void sort(List<T> items) {
        sort(items, Comparator.naturalOrder());
    }

    @Override
    public void sort(List<T> items, Comparator<T> comparator) {
        recursiveQuickSort(items, 0, items.size(), comparator);
    }

    private void recursiveQuickSort(List<T> items, int from, int to, Comparator<T> comparator) {
        if (from >= to) {
            return;
        }
        int split = twoWayPartition(items, from, to, comparator);
        recursiveQuickSort(items, from, split, comparator);
        recursiveQuickSort(items, split + 1, to, comparator);
    }

    private int twoWayPartition(List<T> items, int from, int to, Comparator<T> comparator) {
        int pivot = to - 1;

        int i = from - 1;
        for (int j = from; j < pivot; j++) {
            if (comparator.compare(items.get(j), items.get(pivot)) <= 0) {
                i++;
                swap(items, i, j);
            }
        }
        swap(items, i + 1, pivot);
        return i + 1;
    }

    private void swap(List<T> items, int idx1, int idx2) {
        T tmp = items.get(idx1);
        items.set(idx1, items.get(idx2));
        items.set(idx2, tmp);
    }
}
