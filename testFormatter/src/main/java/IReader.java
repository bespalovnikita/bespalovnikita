/**
 * Created by nick on 04.11.16.
 * Reader interface
 */
public interface IReader {
    boolean hasChar();
    char readChar();

    void writeChar(char c);

    void writeString(String a);
}
