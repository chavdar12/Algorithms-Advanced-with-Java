import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BigTripTests {

    @Test
    public void findsLongestPathAndRoute() throws Exception {
        String input = "6\n9\n1 2 5\n1 3 3\n2 4 6\n2 3 2\n3 5 4\n3 6 2\n3 4 7\n4 6 1\n4 5 3\n1\n6\n";

        assertEquals("15\n1 2 3 4 6", Console.run(BigTrip::main, input));
    }

    @Test
    public void ignoresEdgesLeavingUnreachableNodes() throws Exception {
        String input = "3\n2\n2 3 -5\n1 3 4\n1\n3\n";

        assertEquals("4\n1 3", Console.run(BigTrip::main, input));
    }
}
