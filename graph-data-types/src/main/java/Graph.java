public class Graph<V> extends AbstractGraph<V> {

    public void addEdge(V vertex1, V vertex2) {
        adjacencyList.get(vertex1).add(vertex2);
        adjacencyList.get(vertex2).add(vertex1);
    }

    public void removeEdge(V vertex1, V vertex2) {
        adjacencyList.get(vertex1).remove(vertex2);
        adjacencyList.get(vertex2).remove(vertex1);
    }
}
