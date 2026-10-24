import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UndefinedTests {

    @Test
    public void findsShortestPathWithNegativeEdges() throws Exception {
        String input = "6\n8\n1 2 8\n1 3 10\n2 4 1\n3 6 2\n4 3 -4\n4 6 -1\n6 5 -2\n5 3 1\n1\n6\n";

        assertEquals("1 2 4 3 6 \n7", Console.run(Undefined::main, input));
    }

    @Test
    public void reportsNegativeCycle() throws Exception {
        String input = "4\n4\n1 2 1\n2 3 -1\n3 4 -1\n4 1 -1\n1\n4\n";

        assertEquals("Undefined", Console.run(Undefined::main, input));
    }
}
