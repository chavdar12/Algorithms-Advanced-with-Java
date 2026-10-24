import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AbaspaBasapaTests {

    @Test
    public void findsLongestCommonSubstring() throws Exception {
        assertEquals("bas", Console.run(AbaspaBasapa::main, "abaspa\nbasapa\n"));
    }

    @Test
    public void substringStartingAtFirstCharacter() throws Exception {
        assertEquals("ab", Console.run(AbaspaBasapa::main, "ab\naab\n"));
    }

    @Test
    public void noCommonSubstring() throws Exception {
        assertEquals("", Console.run(AbaspaBasapa::main, "abc\nxyz\n"));
    }
}
