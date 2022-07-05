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
        adjacencyList.get(edge.from()).add(edge);
        if (!adjacencyList.containsKey(edge.to())) {
            addVertex(edge.to());
        }
        adjacencyList.get(edge.to()).add(edge);
    }

    @Override
    public void removeEdge(WeightedEdge<V> edge) {
        adjacencyList.get(edge.from()).remove(edge);
        adjacencyList.get(edge.to()).remove(edge);
    }

    public static WeightedGraph<Integer> buildFromFileNaturalInt(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        int numberOfVertices = scanner.nextInt();
        int numberOfEdges = scanner.nextInt();
        WeightedGraph<Integer> graph = new WeightedGraph<>();

        for (int i = 0; i < numberOfVertices; i++) {
            graph.addVertex(i);
        }
        for (int i = 0; i < numberOfEdges; i++) {
            graph.addEdge(new WeightedEdge<>(scanner.nextInt(), scanner.nextInt(), scanner.nextDouble()));
        }
        return graph;
    }

    public static WeightedGraph<String> buildfromFileString(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        int numberOfVertices = scanner.nextInt();
        int numberOfEdges = scanner.nextInt();
        WeightedGraph<String> graph = new WeightedGraph<>();

        for (int i = 0; i < numberOfEdges; i++) {
            WeightedEdge<String> edge = new WeightedEdge<>(scanner.next(), scanner.next(), scanner.nextDouble());
            if (!graph.containsVertex(edge.from())) {
                graph.addVertex(edge.from());
            }
            if (!graph.containsVertex(edge.to())) {
                graph.addVertex(edge.to());
            }
            graph.addEdge(edge);
        }
        return graph;
    }
}
