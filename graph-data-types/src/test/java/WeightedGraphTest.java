import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

class WeightedGraphTest {

    @Test
    void fromFile() throws FileNotFoundException {
        File input = new File(this.getClass().getResource("graph6.txt").toString());
        WeightedGraph<Integer> graph = WeightedGraph.fromFile(input);
        Assertions.assertEquals(8, graph.getNumberOfEdges());
        Assertions.assertEquals(6, graph.getNumberOfVertices());
    }
}