import java.util.*;

public class BinarySearchTree<K extends Comparable<K>, V> implements SortedDictionary<K, V> {
    private Node root;

    public BinarySearchTree() {}

    @Override
    public void put(K key, V value) {
        root = putInSubTree(root, key, value);
    }

    @Override
    public V get(K key) {
        Node found = search(key);

        if (doesMatch(found, key)) {
            return found.value;
        }
        return null;
    }

    @Override
    public void delete(K key) {
        deleteInSubtree(root, key);
    }

    private Node deleteInSubtree(Node node, K key) {
        if (node == null) {
            return null;
        }

        int compare = key.compareTo(node.key);
        if (compare < 0) {
            return deleteInSubtree(node.right, key);
        }
        else if (compare > 0) {
            return deleteInSubtree(node.left, key);
        }
        else {
            Node target = node;
            node = minOfTree(target.right);
            node.left = target.left;
            node.right = deleteMin(target.right);
        }
        node.count = 1 + node.left.count + node.right.count;
        return node;
    }

    private Node deleteMin(Node node) {
        if (node.left == null) {
            return node.right;
        }

        node.left = deleteMin(node.left);
        node.count = 1 + node.left.count + node.right.count;

        return node;
    }

    @Override
    public boolean contains(K key) {
        return doesMatch(search(key), key);
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int size() {
        if (isEmpty()) {
            return 0;
        }
        return root.count;
    }

    @Override
    public Iterable<K> keys() {
        List<K> keys = new ArrayList<>();
        getOrderedKeys(root, keys);
        return keys;
    }

    private Node search(K key) {
        Node current = root;
        Node previous = null;

        while (current != null) {
            int compare = key.compareTo(current.key);

            if (compare < 0) {
                previous = current;
                current = current.left;

            }
            else if (compare > 0) {
                previous = current;
                current = current.right;
            }
            else {
                return current;
            }
        }
        return previous;
    }

    private boolean doesMatch(Node node, K key) {
        return node != null && key.compareTo(node.key) == 0;
    }

    private void getOrderedKeys(Node node, Collection<K> keys) {
        if (node == null) {
            return;
        }

        getOrderedKeys(node.left, keys);
        keys.add(node.key);
        getOrderedKeys(node.right, keys);
    }

    @Override
    public K min() {
        return minOfTree(root).key;
    }
    private Node minOfTree(Node node) {
        if (node == null) {
            return null;
        }

        if (node.left == null) {
            return node;
        }

        return minOfTree(node.left);
    }

    @Override
    public K max() {
        if (isEmpty()) {
            return null;
        }

        Node current = root;
        while (current.right != null) {
            current = current.right;
        }

        return current.key;
    }

    @Override
    public K floor(K key) {
        Node found = floorSubtree(root, key);
        if (found != null) {
            return found.key;
        }
        return null;
    }

    private Node floorSubtree(Node node, K key) {
        if (node == null) {
            return null;
        }

        int compare = key.compareTo(node.key);
        if (compare < 0) {
            return floorSubtree(node.left, key);
        }
        else if (compare > 0) {
            Node right = floorSubtree(node.right, key);
            if (right != null) {
                return right;
            }
            return node;
        }
        else {
            return node;
        }
    }

    @Override
    public K ceil(K key) {
        Node found = ceilSubtree(root, key);
        if (found != null) {
            return found.key;
        }
        return null;
    }

    private Node ceilSubtree(Node node, K key) {
        if (node == null) {
            return null;
        }

        int compare = key.compareTo(node.key);
        if (compare > 0) {
            return ceilSubtree(node.right, key);
        }
        else if (compare < 0) {
            Node found = ceilSubtree(node.left, key);
            if (found != null) {
                return found;
            }
            return node;
        }
        else {
            return node;
        }
    }

    @Override
    public int rank(K key) {
        return computeRank(root, key);
    }

    @Override
    public K select(int rank) {
        List<K> keys = new ArrayList<>();
        getOrderedKeys(root, keys);

        return keys.get(rank);
    }

    private Node putInSubTree(Node node, K key, V value) {
        if (node == null) {
            return new Node(key, value);
        }

        int compare = key.compareTo(node.key);
        if (compare < 0) {
            node.left = putInSubTree(node.left, key, value);
        }
        else if (compare > 0) {
            node.right = putInSubTree(node.right, key, value);
        }
        else {
            node.value = value;
        }

        node.count = 1 + node.left.count + node.right.count;
        return node;
    }

    private int computeRank(Node node, K key) {
        if (node == null) {
            return 0;
        }

        int compare = key.compareTo(node.key);
        if (compare < 0) {
            return computeRank(node.left, key);
        }
        else if (compare > 0) {
            return 1 + node.left.count + computeRank(node.right, key);
        }
        else {
            return node.left.count;
        }
    }

    private class Node {
        private K key;
        private V value;
        private int count;

        private Node left;
        private Node right;


        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.count = 0;
        }
    }

}
