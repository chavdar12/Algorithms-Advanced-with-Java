import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TheMadGardenerTests {

    @Test
    public void increasingSequence() throws Exception {
        assertEquals("1 2 3 4 5 6 7 8 9 10 \n5.50\n10", Console.run(TheMadGardener::main, "1 2 3 4 5 6 7 8 9 10\n"));
    }

    @Test
    public void peakAtFirstPlant() throws Exception {
        assertEquals("5 4 3 2 1 \n3.00\n5", Console.run(TheMadGardener::main, "5 4 3 2 1\n"));
    }

    @Test
    public void prefersLargerSumOnEqualLength() throws Exception {
        assertEquals("3 2 \n2.50\n2", Console.run(TheMadGardener::main, "3 1 2\n"));
    }

    @Test
    public void risesThenFalls() throws Exception {
        assertEquals("1 3 5 4 2 \n3.00\n5", Console.run(TheMadGardener::main, "1 3 5 4 2\n"));
    }
}
