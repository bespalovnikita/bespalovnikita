/**
 * @since 1.0
 * @version
 * @author Nikita Bespalov.
 */

/**
 *Read string form dialogue and then formatting it.
 */
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 *Read string form stream and then formatting it.
 */
public class testFormatter {


    private OutputInt outputInt;
    private InputInt inputInt;

    @Before
        public void setUp(){
            inputInt = new InputInt();
            outputInt = new OutputInt();
        }

    @Test
    public void formatter(){
        String text = "";
        IReader in = new StringReader("{234343;}");
        InputInt.input(in,text);
        String space = "    ";
        char open = '{';
        char close = '}';
        char bracket = ';';
        String enter = "\n";
        int openCount = 0;
        boolean isClose = false;
        boolean opened = false;
        boolean isBracket = false;
        IReader reText = new StringReader("");
        boolean sth;
        for (int i = 0; i < text.length(); i++) {
            sth = false;
            if (text.charAt(i) == open) {
                openCount = openCount + 1;
                opened = true;
                isClose = false;
                reText.writeChar(open);
                reText.writeString(enter);
                for (int j = 0; j < openCount; j++) {
                    reText.writeString(space);
                }
                sth = true;
            }
            if ((text.charAt(i) == close) && (opened)) {
                openCount = openCount - 1;
                sth = true;
                if ((!isClose) && (!isBracket)) {
                    reText.writeString(enter);
                }
                if ((!isClose) && (!isBracket)) {
                    for (int j = 0; j < openCount; j++) {
                        reText.writeString(space);
                    }
                }
                reText.writeChar(close);
                reText.writeString(enter);
                for (int j = 0; j < openCount - 1; j++) {
                    reText.writeString(space);
                }
                isClose = true;
            }
            isBracket = false;
            if ((text.charAt(i) == bracket) && (opened)) {
                sth = true;
                isClose = false;
                isBracket = true;
                reText.writeChar(bracket);
                reText.writeString(enter);
                for (int j = 0; j < openCount; j++) {
                    reText.writeString(space);
                }
            }
            if ((opened) && (!sth)) {
                reText.writeChar(text.charAt(i));
            }

            if ((opened) && (openCount == 0)) {
                break;
            }
        }
        IWriter out = new StringWriter();
        OutputInt.output(reText,out);
        assertEquals("{}", out.toString());
    }
}

