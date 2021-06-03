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
        this.panel.add(texto);
        tickets=new TreeMap<>();
        //Ticket t=new Ticket();
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

    private void actualizar() {
        String salida=" ";
        for (Map.Entry<String, Integer>tapas:tickets.entrySet()) {
            salida+=tapas.getKey()+" "+tapas.getValue()+"\n";
        }
        texto.setText(salida);
        //Aquí imprimo la salida para ver si está funcionando
        System.out.println(salida);
    }
}
