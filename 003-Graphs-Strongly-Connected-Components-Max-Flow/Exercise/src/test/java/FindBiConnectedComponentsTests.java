import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindBiConnectedComponentsTests {

    @Test
    public void countsComponents() throws Exception {
        String input = "Nodes: 9\nEdges: 10\n0 1\n0 2\n1 2\n2 3\n3 4\n4 5\n5 3\n4 6\n6 7\n7 4\n";

        assertEquals("Number of bi-connected components: 4", Console.run(FindBiConnectedComponents::main, input));
    }

    @Test
    public void countsComponentsInEveryConnectedPart() throws Exception {
        String input = "Nodes: 6\nEdges: 6\n0 1\n1 2\n2 0\n3 4\n4 5\n5 3\n";

        assertEquals("Number of bi-connected components: 2", Console.run(FindBiConnectedComponents::main, input));
    }
}
