import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;

public class MergeSort<T extends Comparable<T>> implements SortingAlgorithm<T> {

    public void sort(List<T> items) {
        sort(items, Comparator.naturalOrder());
    }

    public void sort(List<T> items, Comparator<T> comparator) {
        recursiveMergeSort(items, 0, items.size(), comparator);
    }

    private void recursiveMergeSort(List<T> items, int from, int to, Comparator<T> comparator) {
        if (from >= to - 1) {
            return;
        }

        int mid = from + (to - from) / 2;
        recursiveMergeSort(items, from, mid, comparator);
        recursiveMergeSort(items, mid, to, comparator);
        mergeList(items, from, mid, to, comparator);
    }

    private void mergeList(List<T> items, int from, int mid, int to, Comparator<T> comparator) {
        Queue<T> left = new ArrayDeque<>(items.subList(from, mid));
        Queue<T> right = new ArrayDeque<>(items.subList(mid, to));

        int i = 0;
        while (!left.isEmpty() && !right.isEmpty()) {
            if (comparator.compare(left.peek(), right.peek()) <= 0) {
                items.set(i, left.remove());
            }
            else {
                items.set(i, right.remove());
            }
            i++;
        }

        while (!left.isEmpty()) {
            items.set(i, left.remove());
            i++;
        }
        while (!right.isEmpty()) {
            items.set(i, right.remove());
            i++;
        }
    }
}
