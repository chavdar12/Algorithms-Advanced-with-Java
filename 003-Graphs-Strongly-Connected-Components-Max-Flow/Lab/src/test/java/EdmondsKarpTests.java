import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EdmondsKarpTests {

    @Test
    public void findsMaxFlow() {
        int[][] graph = {
                {0, 16, 13, 0, 0, 0},
                {0, 0, 10, 12, 0, 0},
                {0, 4, 0, 0, 14, 0},
                {0, 0, 9, 0, 0, 20},
                {0, 0, 0, 7, 0, 4},
                {0, 0, 0, 0, 0, 0},
        };

        assertEquals(23, EdmondsKarp.findMaxFlow(graph));
    }

    @Test
    public void disconnectedSinkHasZeroFlow() {
        int[][] graph = {
                {0, 5, 0},
                {0, 0, 0},
                {0, 0, 0},
        };

        assertEquals(0, EdmondsKarp.findMaxFlow(graph));
    }
}
