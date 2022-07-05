import java.util.*;

public class PrimMinimumSpanningTree<V> {
    private WeightedGraph<V> graph;
    private Set<WeightedEdge<V>> treeEdges;

    public PrimMinimumSpanningTree(WeightedGraph<V> graph) {
        this.graph = graph;
        treeEdges = new HashSet<>();

        computeTree();
    }

    private void computeTree() {
        Set<V> visited = new HashSet<>();
        Queue<WeightedEdge<V>> crossingEdges = new PriorityQueue<>();

        V root = graph.vertices().iterator().next();
        visited.add(root);
        crossingEdges.addAll(graph.getAdjacent(root));

        while (!crossingEdges.isEmpty()) {
            WeightedEdge<V> minEdge = crossingEdges.remove();
            if (!visited.contains(minEdge.from())) {
                treeEdges.add(minEdge);
                visited.add(minEdge.from());
                crossingEdges.addAll(graph.getAdjacent(minEdge.from()));
            }
            else if (!visited.contains(minEdge.to())) {
                treeEdges.add(minEdge);
                visited.add(minEdge.to());
                crossingEdges.addAll(graph.getAdjacent(minEdge.to()));
            }
        }
    }

    public Set<WeightedEdge<V>> getTreeEdges() {
        return treeEdges;
    }

    public double getTreeWeight() {
        return treeEdges.stream().mapToDouble(WeightedEdge::getWeight).sum();
    }

}
