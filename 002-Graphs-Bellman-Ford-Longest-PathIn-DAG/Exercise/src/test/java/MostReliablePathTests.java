import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MostReliablePathTests {

    @Test
    public void findsMostReliablePath() throws Exception {
        String input = "Nodes: 7\nPath: 0 - 6\nEdges: 10\n0 3 85\n0 4 88\n3 1 95\n3 5 98\n4 5 99\n4 2 14\n5 1 5\n"
                + "5 6 90\n1 6 100\n2 6 95\n";

        assertEquals("Most reliable path reliability: 81.11%\n0 -> 4 -> 5 -> 3 -> 1 -> 6",
                Console.run(MostReliablePath::main, input));
    }

    @Test
    public void prefersLongerButMoreReliablePath() throws Exception {
        String input = "Nodes: 4\nPath: 0 - 3\nEdges: 4\n0 3 50\n0 1 90\n1 2 90\n2 3 90\n";

        assertEquals("Most reliable path reliability: 72.90%\n0 -> 1 -> 2 -> 3",
                Console.run(MostReliablePath::main, input));
    }
}
