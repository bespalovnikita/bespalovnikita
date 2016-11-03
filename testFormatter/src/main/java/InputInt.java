/**
 * Created by nick on 04.11.16.
 * Input
 */
public class InputInt implements IInputInt {
     public static void input(IReader in, String str) {
         while (in.hasChar()) {
             str = str + in.readChar();
         }


     }
}
