import java.util.*;

public class CompleteBinaryTree<T> {
    List<T> nodes;

    public CompleteBinaryTree() {
        nodes = new ArrayList<>();
    }

    public CompleteBinaryTree(Collection<T> items) {
        nodes = new ArrayList<>();
        nodes.addAll(items);
    }

    public int parent(int index) {
        return (index - 1) / 2;
    }

    public int left(int index) {
        return 2*index + 1;
    }

    public int right(int index) {
        return 2*index + 2;
    }

    public T get(int index) {
        return nodes.get(index);
    }

    void swap(int index1, int index2) {
        T tmp = nodes.get(index1);
        nodes.set(index1, nodes.get(index2));
        nodes.set(index2, tmp);
    }

    public int size() {
        return nodes.size();
    }

    public int height() {
        if (size() == 0) {
            return 0;
        }
        return (int) Math.floor(Math.log(size()) / Math.log(2)) + 1;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompleteBinaryTree<?> that)) return false;
        return Objects.equals(nodes, that.nodes);
    }

    @Override
    public final int hashCode() {
        return Objects.hash(nodes);
    }
}
