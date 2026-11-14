import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/** Runs a console program's main with the given stdin and returns what it printed. */
public final class Console {

    public interface Program {
        void main(String[] args) throws Exception;
    }

    public static String run(Program program, String input) throws Exception {
        InputStream in = System.in;
        PrintStream out = System.out;
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        try {
            System.setIn(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));
            System.setOut(new PrintStream(buffer, true, StandardCharsets.UTF_8));
            program.main(new String[0]);
        } finally {
            System.setIn(in);
            System.setOut(out);
        }
        return buffer.toString(StandardCharsets.UTF_8).replace("\r\n", "\n").strip();
    }

    private Console() {
    }
}
