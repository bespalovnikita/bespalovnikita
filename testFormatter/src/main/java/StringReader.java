/**
 * Created by nick on 04.11.16.
 * Reader to read chars from string.
 */
public class StringReader implements IReader, IWriter {
    private final String value;
    private int index = 0;

    public StringReader(String value) {
        this.value = value;
    }
    public boolean hasChar() {
        return index < value.length();
    }
    public char readChar() {
        return value.charAt(index++);
    }
    public void writeString(String str) {    }
    public void writeChar(char c) {    }
}
