package Proyecto;

import javax.swing.*;
import java.awt.*;

public class Ticket extends JFrame{
    public JTextArea texto;
    public Ticket(){
        texto=new JTextArea(25,25);
        texto.setBounds(10,50,400,300);
        texto.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        add(texto);
    }

    public JTextArea getTexto(){
        return texto;
    }

   /* public static void main(String[] args) {
        Ticket ventana=new Ticket();

        ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);

        ventana.pack();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }*/
}
