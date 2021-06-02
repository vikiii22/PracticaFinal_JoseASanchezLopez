package Proyecto;

import javax.swing.*;
import java.awt.*;
import java.util.Map;
import java.util.TreeMap;

public class Ticket extends JFrame{
    JPanel panel;
    public JTextArea texto;
    Map<String, Integer> tickets;
    public Ticket(){
        panel=new JPanel();
        texto=new JTextArea(30,30);
        texto.setSize(30,30);
        texto.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        tickets=new TreeMap<>();
        panel.add(texto);
    }

    public JTextArea getTexto(){
        return texto;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void anaydeTicket(String nombre, int cantidad) {
        if (!tickets.containsKey(nombre)){
            tickets.put(nombre, cantidad);
        }else {
            tickets.put(nombre,tickets.get(nombre)+cantidad);
        }
        actualizar();
    }

    public void actualizar() {
        String salida="";
        for (Map.Entry<String, Integer>tapas:tickets.entrySet()) {
            salida+=tapas.getKey()+" "+tapas.getValue()+"\n";
        }
        texto.setText(salida);
        System.out.println(salida);
    }

   /* public static void main(String[] args) {
        Ticket ventana=new Ticket();

        ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);

        ventana.pack();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }*/
}
