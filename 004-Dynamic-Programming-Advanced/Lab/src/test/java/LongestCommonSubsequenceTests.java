import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestCommonSubsequenceTests {

    @Test
    public void findsLength() throws Exception {
        assertEquals("3", Console.run(LongestCommonSubsequence::main, "ABCDGH\nAEDFHR\n"));
    }

    @Test
    public void noCommonCharacters() throws Exception {
        assertEquals("0", Console.run(LongestCommonSubsequence::main, "abc\nxyz\n"));
    }
}
