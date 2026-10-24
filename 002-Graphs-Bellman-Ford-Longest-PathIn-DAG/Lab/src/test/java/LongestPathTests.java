import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestPathTests {

    @Test
    public void findsLongestPath() throws Exception {
        String input = "4\n4\n1 2 5\n1 3 3\n3 4 6\n4 2 4\n1\n2\n";

        assertEquals("13", Console.run(LongestPath::main, input));
    }

    @Test
    public void ignoresEdgesLeavingUnreachableNodes() throws Exception {
        // node 2 is unreachable from 1; relaxing its negative edge used to overflow MIN_VALUE
        String input = "3\n2\n2 3 -5\n1 3 4\n1\n3\n";

        assertEquals("4", Console.run(LongestPath::main, input));
    }
}
