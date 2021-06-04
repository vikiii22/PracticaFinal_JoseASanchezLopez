package Proyecto;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ImrpimeTicket {
        public void imprimirTicket(String s){
            JTextPane jtp = new JTextPane();
            jtp.setBackground(Color.white);
            jtp.setFont(new Font("Calibri",Font.BOLD,16));
            jtp.setText(s);
            boolean show = true;
            try {
                jtp.print(null, null, show, null, null, show);
            } catch (java.awt.print.PrinterException ex) {
                ex.printStackTrace();
            }
        }

}