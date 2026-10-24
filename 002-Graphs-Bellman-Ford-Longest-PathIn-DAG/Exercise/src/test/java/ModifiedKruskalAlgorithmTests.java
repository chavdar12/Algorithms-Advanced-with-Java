import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModifiedKruskalAlgorithmTests {

    @Test
    public void findsMinimumSpanningForestWeight() throws Exception {
        String input = "Nodes: 4\nEdges: 5\n0 1 9\n0 3 4\n3 1 6\n3 2 11\n1 2 5\n";

        assertEquals("Minimum spanning forest weight: 15", Console.run(ModifiedKruskalAlgorithm::main, input));
    }

    @Test
    public void handlesDisconnectedGraph() throws Exception {
        String input = "Nodes: 4\nEdges: 2\n0 1 3\n2 3 4\n";

        assertEquals("Minimum spanning forest weight: 7", Console.run(ModifiedKruskalAlgorithm::main, input));
    }
}
