import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AssociationList<K, V> implements Dict<K, V> {
    Node root;
    int size;

    public AssociationList() {
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        Objects.requireNonNull(value);

        Node found = search(key);
        if (found != null) {
            found.value = value;
        }
        else {
            root = new Node(key, root, value);
            size++;
        }
    }

    @Override
    public V get(K key) {
        Node node = root;
        while (node != null) {
            if (Objects.equals(node.key, key)) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    @Override
    public void delete(K key) {
        Node node = root;
        while (node.hasNext()) {
            if (Objects.equals(node.next.key, key)) {
                node.next = node.next.next;
                size--;
            }
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
        List<K> keyList = new ArrayList<>();

        Node node = root;
        while (node != null) {
            keyList.add(node.key);
            node = node.next;
        }

        return keyList;
    }

    private Node search(K key) {
        Node node = root;
        while (node != null) {
            if (Objects.equals(node.key, key)) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    private class Node {
        public K key;
        public Node next;
        public V value;

        public Node(K key, Node next, V value) {
            this.key = key;
            this.next = next;
            this.value = value;
        }

        public boolean hasNext() {
            return next != null;
        }
    }
}
