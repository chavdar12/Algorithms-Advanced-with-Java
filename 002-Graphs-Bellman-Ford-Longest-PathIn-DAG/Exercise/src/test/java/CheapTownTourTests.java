import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheapTownTourTests {

    @Test
    public void findsMinimumTourCost() throws Exception {
        String input = "4\n5\n0 - 1 - 9\n0 - 3 - 4\n3 - 1 - 6\n3 - 2 - 11\n1 - 2 - 5\n";

        assertEquals("Total cost: 15", Console.run(CheapTownTour::main, input));
    }

    @Test
    public void joinsChainsOfTrees() throws Exception {
        // the last edge joins two multi-node trees, so roots must be found through more than one parent
        String input = "6\n5\n0 - 1 - 1\n2 - 3 - 1\n1 - 3 - 2\n4 - 5 - 1\n5 - 0 - 3\n";

        assertEquals("Total cost: 8", Console.run(CheapTownTour::main, input));
    }
}
