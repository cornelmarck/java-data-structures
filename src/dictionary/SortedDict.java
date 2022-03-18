public interface SortedDict<K extends Comparable<K>, V> extends Dict<K, V> {

    K min();

    K max();

    K floor(K key);

    K ceil(K key);

    int rank(K key);

    K select(int rank);
}
