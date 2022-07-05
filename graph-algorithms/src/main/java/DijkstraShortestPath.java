import java.util.*;

public class DijkstraShortestPath<V> {
    private final DirectedWeightedGraph<V> graph;
    private Map<V, Double> distanceToSource;
    private Map<V, WeightedEdge<V>> edgeTo;
    private PriorityQueue<V> pq;
    private Set<V> visited;

    public DijkstraShortestPath(DirectedWeightedGraph<V> graph, V source) {
        this.graph = graph;
        distanceToSource = new HashMap<>();
        edgeTo = new HashMap<>();
        pq = new PriorityQueue<>(Comparator.comparingDouble(this::distanceTo));

        computeShortestPath(source);
    }

    private void computeShortestPath(V source) {
        pq.add(source);
        edgeTo.put(source, null);
        graph.vertices().forEach(x -> distanceToSource.put(x, Double.POSITIVE_INFINITY));
        distanceToSource.put(source, 0.0);

        while (!pq.isEmpty()) {
            relax(pq.remove());
        }
    }

    private void relax(V vertex) {
        for (WeightedEdge<V> edge : graph.getAdjacent(vertex)) {
            if (distanceTo(edge.to()) > distanceTo(edge.from()) + edge.getWeight()) {
                distanceToSource.put(edge.to(), distanceTo(edge.from()) + edge.getWeight());
                edgeTo.put(edge.to(), edge);
                if (visited.contains(edge.to())){
                    pq.remove(edge.to());
                    pq.add(edge.to());
                }
                else {
                    pq.add(edge.to());
                    visited.add(edge.to());
                }
            }
        }
    }

    private void relaxEdge(WeightedEdge<V> edge) {
        if (distanceTo(edge.to()) > distanceTo(edge.from()) + edge.getWeight()) {
            distanceToSource.put(edge.to(), distanceTo(edge.from()) + edge.getWeight());
            edgeTo.put(edge.to(), edge);
        }
    }

    double distanceTo(V destination) {
        return -1;
    }

    Iterable<WeightedEdge<V>> pathTo(V destination) {
        return null;
    }




}
