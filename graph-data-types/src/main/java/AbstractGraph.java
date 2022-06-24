import java.util.*;

public abstract class AbstractGraph<V> {
    Map<V, Set<V>> adjacencyList;

    public AbstractGraph() {
        adjacencyList = new HashMap<>();
    }

    public boolean containsVertex(V vertex) {
        return adjacencyList.containsKey(vertex);
    }

    public Set<V> vertexSet() {
        return Set.copyOf(adjacencyList.keySet());
    }

    public Set<V> getAdjacent(V vertex) {
        return Set.copyOf(adjacencyList.get(vertex));
    }

    public void addVertex(V vertex) {
        adjacencyList.put(vertex, new HashSet<>());
    }

    public abstract void addEdge(V vertex1, V vertex2);

    public void removeVertex(V vertex) {
        adjacencyList.values().forEach(s -> s.remove(vertex));
        adjacencyList.remove(vertex);
    }

    public abstract void removeEdge(V vertex1, V vertex2);
}
