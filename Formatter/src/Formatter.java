/**
 @version 1.30 1999-12-16
 @author Cay Horstmann
 */

import java.text.*;
import javax.swing.*;

public class Formatter {

    public static void main(String[] args)    {
        String text = JOptionPane.showInputDialog
                ("Write what u want");
        String space="    ";
        char open='{';
        char close='}';
        char bracket=';';
        int opencount=0;
        boolean isclose=false;
        boolean opened=false;
        boolean isbracket=false;
        String retext="";
        boolean sth=false;
        for (int i=0; i< text.length(); i++){
            sth=false;

            if(text.charAt(i)==open){
                opencount= opencount +1;
                opened=true;
                isclose=false;
                retext = retext+open + "\n";
                for (int j = 0; j < opencount; j++) {
                    retext = retext + space;
                }
                sth=true;
            }

            if((text.charAt(i)==close)&&(opened)){
                opencount = opencount - 1;
                sth=true;
                if((!isclose)&&(!isbracket)) {
                    retext = retext + "\n";
                }
                if((!isclose)&&(!isbracket)){
                    for (int j = 0; j < opencount; j++) {
                        retext = retext + space;
                    }
                }
                retext = retext +close+"\n";
                for (int j = 0; j < opencount-1; j++) {
                    retext = retext + space;
                }
                isclose=true;
            }
            isbracket=false;

            if((text.charAt(i)==bracket)&&(opened)) {
                sth=true;
                isclose=false;
                isbracket=true;
                retext = retext + bracket + "\n";
                for (int j = 0; j < opencount; j++) {
                    retext = retext + space;
                }
            }
            if ((opened)&&(!sth)){
                retext= retext+text.charAt(i);
                }

            if ((opened)&&(opencount==0)) {
                break;
            }

        }
        System.out.println(retext);
    }
}