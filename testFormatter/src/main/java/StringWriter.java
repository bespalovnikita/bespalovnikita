/**
 * Created by nick on 04.11.16.
 * Writer to write a string
 */
public class StringWriter implements  IWriter {
    StringBuilder builder = new StringBuilder();
    public String toString() {
        return builder.toString();
    }
    public void writeChar(char c) {
        builder.append(c);
    }
}
