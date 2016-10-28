/**
 * @since 1.0
 * @version
 * @author Nikita Bespalov.
 */

/**
*Read string form dialogue and then formatting it.
 */
package formatter;



import java.util.Scanner;
/**
 *Read string form stream and then formatting it.
 */
public class Formatter {
    /** {@inheritDoc} */
    public final void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String text;
        text = sc.nextLine();
        String space = "    ";
        char open = '{';
        char close = '}';
        char bracket = ';';
        int openCount = 0;
        boolean isClose = false;
        boolean opened = false;
        boolean isBracket = false;
        String reText = "";
        boolean sth;
        for (int i = 0; i < text.length(); i++) {
            sth = false;
            if (text.charAt(i) == open) {
                openCount = openCount + 1;
                opened = true;
                isClose = false;
                reText = reText + open + "\n";
                for (int j = 0; j < openCount; j++) {
                    reText = reText + space;
                }
                sth = true;
            }
            if ((text.charAt(i) == close) && (opened)) {
                openCount = openCount - 1;
                sth = true;
                if ((!isClose) && (!isBracket)) {
                    reText = reText + "\n";
                }
                if ((!isClose) && (!isBracket)) {
                    for (int j = 0; j < openCount; j++) {
                        reText = reText + space;
                    }
                }
                reText = reText + close + "\n";
                for (int j = 0; j < openCount - 1; j++) {
                    reText = reText + space;
                }
                isClose = true;
            }
            isBracket = false;
            if ((text.charAt(i) == bracket) && (opened)) {
                sth = true;
                isClose = false;
                isBracket = true;
                reText = reText + bracket + "\n";
                for (int j = 0; j < openCount; j++) {
                    reText = reText + space;
                }
            }
            if ((opened) && (!sth)) {
                reText = reText + text.charAt(i);
                }

            if ((opened) && (openCount == 0)) {
                break;
            }
        }
        System.out.println(reText);
    }
}

