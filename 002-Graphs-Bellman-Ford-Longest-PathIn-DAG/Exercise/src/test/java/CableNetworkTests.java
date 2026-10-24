import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CableNetworkTests {

    private static final String EDGES = "Nodes: 9\nEdges: 15\n1 4 8\n4 0 6 connected\n1 7 7\n4 7 10\n4 8 3\n7 8 4\n"
            + "0 8 5 connected\n8 6 9\n8 3 20 connected\n0 5 4\n0 3 9 connected\n6 3 8\n6 2 12\n5 3 2\n3 2 14 connected\n";

    @Test
    public void connectsCheapestNodesWithinBudget() throws Exception {
        assertEquals("Budget used: 13", Console.run(CableNetwork::main, "Budget: 20\n" + EDGES));
    }

    @Test
    public void spendsBudgetExactly() throws Exception {
        assertEquals("Budget used: 21", Console.run(CableNetwork::main, "Budget: 21\n" + EDGES));
    }
}
