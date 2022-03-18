import java.util.List;
import java.util.Objects;

public class SortedAssociationList<K extends Comparable<K>, V> implements SortedDict<K, V> {
    private List<K> keys;
    private List<V> values;
    private int size;

    @Override
    public void put(K key, V value) {
        int index = binarySearch(key);

        if (doesMatch(index, key)) {
            values.set(index, value);
        }
        else {
            keys.add(index, key);
            values.add(index, value);
            size++;
        }
    }

    @Override
    public V get(K key) {
        int index = binarySearch(key);

        if (doesMatch(index, key)) {
            return values.get(index);
        }
        else {
            return null;
        }

    }

    @Override
    public void delete(K key) {
        int index = binarySearch(key);

        if (doesMatch(index, key)) {
            keys.remove(index);
            values.remove(index);
            size--;
        }
    }

    @Override
    public boolean contains(K key) {
        return get(key) != null;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterable<K> keys() {
        return null;
    }

    @Override
    public K min() {
        if (isEmpty()) {
            return null;
        }
        return keys.get(0);
    }

    @Override
    public K max() {
        if (isEmpty()) {
            return null;
        }
        return keys.get(size() - 1);
    }

    @Override
    public K floor(K key) {
        int sameOrNext = binarySearch(key);

        if (doesMatch(sameOrNext, key)) {
            return key;
        }
        else if (sameOrNext == 0) {
            return null;
        }

        return keys.get(sameOrNext - 1);
    }

    @Override
    public K ceil(K key) {
        int sameOrNext = binarySearch(key);

        if (sameOrNext == size()) {
            return null;
        }

        return key;
    }

    @Override
    public int rank(K key) {
        return 0;
    }

    @Override
    public K select(int rank) {
        return null;
    }

    private int binarySearch(K key) {
        int hi = size();
        int lo = 0;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (keys.get(mid).compareTo(key) >= 0) {
                hi = mid;
            }
            else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    private boolean doesMatch(int index, K key) {
        return index < size() && Objects.equals(keys.get(index), key);
    }

}
