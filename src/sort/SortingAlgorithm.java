package sort;

import java.util.Comparator;
import java.util.List;

public interface SortingAlgorithm<T extends Comparable<T>> {

    void sort(List<T> items);

    void sort(List<T> items, Comparator<T> comparator);

}
