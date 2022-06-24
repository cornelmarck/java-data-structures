import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;

public class WeightedGraph<V> extends AbstractWeightedGraph<V> {

    @Override
    public int getNumberOfEdges() {
        return adjacencyList.values().stream().mapToInt(Set::size).sum() / 2;
    }

    @Override
    public void addEdge(WeightedEdge<V> edge) {
        adjacencyList.get(edge.getFrom()).add(edge);
        adjacencyList.get(edge.getTo()).add(edge);
    }

    @Override
    public void removeEdge(WeightedEdge<V> edge) {
        adjacencyList.get(edge.getFrom()).remove(edge);
        adjacencyList.get(edge.getTo()).remove(edge);
    }

    public static WeightedGraph<Integer> fromFile(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        int numberOfVertices = scanner.nextInt();
        int numberOfEdges = scanner.nextInt();
        WeightedGraph<Integer> graph = new WeightedGraph<>();

        for (int i = 0; i < numberOfEdges; i++) {
            graph.addVertex(i);
            graph.addEdge(new WeightedEdge<>(scanner.nextInt(), scanner.nextInt(), scanner.nextDouble()));
        }
        return graph;
    }
}
