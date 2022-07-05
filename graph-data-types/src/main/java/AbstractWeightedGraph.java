import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractWeightedGraph<V> {
    Map<V, Set<WeightedEdge<V>>> adjacencyList;

    public AbstractWeightedGraph() {
        adjacencyList = new HashMap<>();
    }

    public boolean containsVertex(V vertex) {
        return adjacencyList.containsKey(vertex);
    }

    public int getNumberOfVertices() {
        return adjacencyList.size();
    }

    public abstract int getNumberOfEdges();

    public Set<WeightedEdge<V>> getAdjacent(V vertex) {
        return adjacencyList.get(vertex);
    }

    public void addVertex(V vertex) {
        adjacencyList.put(vertex, new HashSet<>());
    }

    public void removeVertex(V vertex) {
        adjacencyList.values().forEach(s -> s.remove(vertex));
        adjacencyList.remove(vertex);
    }

    public Set<V> vertices() {
        return adjacencyList.keySet();
    }

    public abstract void addEdge(WeightedEdge<V> edge);

    public abstract void removeEdge(WeightedEdge<V> edge);
}
