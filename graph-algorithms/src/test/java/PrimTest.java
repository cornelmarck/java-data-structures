import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

public class PrimTest {

    @Test
    public void testCLRS() throws FileNotFoundException {
        File input = new File(this.getClass().getResource("graph_clrs.txt").getPath());
        WeightedGraph<String> graph = WeightedGraph.buildfromFileString(input);
        PrimMinimumSpanningTree<String> primMst = new PrimMinimumSpanningTree<>(graph);

        Assertions.assertEquals(37, primMst.getTreeWeight());
        Assertions.assertEquals(8, primMst.getTreeEdges().size());
    }

}
