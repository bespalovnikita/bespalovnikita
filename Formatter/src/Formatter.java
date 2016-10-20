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
        boolean inputclose=false;
        boolean opened=false;
        boolean isbracket=false;
        String retext="";
        boolean nextstring=false;
        boolean nextstring2=false;

        for (int i=0; i< text.length(); i++){
            if (nextstring){
                retext = retext + "\n";
                for (int j = 0; j < opencount; j++){
                    retext = retext + space;
                }
            }

            if (nextstring2) {
                retext = retext + "\n";
                for (int j = 0; j < opencount - 1; j++) {
                    retext = retext + space;
                }
            }

            inputclose=false;
            nextstring=false;
            nextstring2=false;

            if(text.charAt(i)==open){
                opencount= opencount +1;
                opened=true;
                nextstring=true;
            }

            if((text.charAt(i)==close)&&(opened)){
                opencount = opencount - 1;
                if (!isbracket) {
                    retext = retext + "\n";
                }
                inputclose = true;
            }

            if (opened){
                if (inputclose)
                {
                    for (int j = 0; j < opencount; j++) {
                        retext = retext + space;

                    }
                   nextstring2=true;
                }
                isbracket=false;
                retext= retext+text.charAt(i);
                if((text.charAt(i)==bracket)&&(opened)){
                    retext = retext + "\n";
                    isbracket=true;
                    for (int j = 0; j < opencount; j++) {
                        retext = retext + space;
                    }
                }

            }

            if ((opened)&&(opencount==0)) {
                break;
            }

        }
        System.out.println(retext);
    }
}