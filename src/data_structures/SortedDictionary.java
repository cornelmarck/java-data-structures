package data_structures;

public interface SortedDictionary<K extends Comparable<K>, V> extends Dictionary<K, V> {

    K min();

    K max();

    K floor(K key);

    K ceil(K key);

    int rank(K key);

    K select(int rank);
}
