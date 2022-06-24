public class DirectedGraph<V> extends AbstractGraph<V> {

    @Override
    public void addEdge(V from, V to) {
        adjacencyList.get(from).add(to);
    }

    @Override
    public void removeEdge(V vertex1, V vertex2) {
        adjacencyList.get(vertex1).remove(vertex2);
    }
}
