/**
 * Created by nick on 04.11.16.
 * Output
 */
public class OutputInt implements IOutputInt {
    public static void output(IReader in, IWriter out) {
        while (in.hasChar()) {
            out.writeChar(in.readChar());
        }
    }
}
