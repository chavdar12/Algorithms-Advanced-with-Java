import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ZigzagMatrixTests {

    @Test
    public void findsMaxZigzagSum() throws Exception {
        String input = "5\n5\n8,2,3,4,5\n9,3,8,2,1\n3,6,1,7,7\n2,4,5,1,6\n1,1,1,5,3\n";

        assertEquals("30 = 9 + 2 + 8 + 4 + 7", Console.run(ZigzagMatrix::main, input));
    }

    @Test
    public void ignoresCellsWithoutValidPredecessor() throws Exception {
        // bottom-right 100 can only be reached by moving down first, which is not allowed
        assertEquals("2 = 1 + 1", Console.run(ZigzagMatrix::main, "2\n2\n1,1\n1,100\n"));
    }
}
