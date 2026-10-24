import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RectangleIntersectionTests {

    @Test
    public void measuresOverlap() throws Exception {
        assertEquals("4", Console.run(RectangleIntersection::main, "2\n0 4 0 4\n2 6 2 6\n"));
    }

    @Test
    public void disjointRectanglesDoNotOverlap() throws Exception {
        assertEquals("0", Console.run(RectangleIntersection::main, "2\n0 1 0 1\n5 6 5 6\n"));
    }

    @Test
    public void zeroWidthRectangleCoversNothing() throws Exception {
        assertEquals("0", Console.run(RectangleIntersection::main, "2\n0 0 0 10\n0 5 0 10\n"));
    }
}
