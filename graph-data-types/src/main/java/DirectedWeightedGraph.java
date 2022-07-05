import java.util.Set;

public class DirectedWeightedGraph<V> extends WeightedGraph<V> {
    @Override
    public int getNumberOfEdges() {
        return adjacencyList.values().stream().mapToInt(Set::size).sum();
    }

    @Override
    public void addEdge(WeightedEdge<V> edge) {
        adjacencyList.get(edge.from()).add(edge);
        if (!adjacencyList.containsKey(edge.to())) {
            addVertex(edge.to());
        }
    }

    @Override
    public void removeEdge(WeightedEdge<V> edge) {
        adjacencyList.get(edge.from()).remove(edge);
    }

}
