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
        Font fuente=new Font("Calibri", 1, 30);
        texto.setFont(fuente);
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

    public void anaydeTicket(String nombre, int precio) {
        if (!tickets.containsKey(nombre)){
            tickets.put(nombre, precio);
        }else {
            tickets.put(nombre,tickets.get(nombre)+precio);
        }
        actualizar();
    }

    private void actualizar() {
        String salida=" ";
        int total=0;
        for (Map.Entry<String, Integer>tapas:tickets.entrySet()) {
            salida+=tapas.getKey()+": "+tapas.getValue()+"€\n";
            total+=tapas.getValue();
        }
        texto.setText(salida+"\n\n\n-----------------\nTotal: "+total+"€");
    }

    public int ensenyaTotal(){
        int totalAPagar=0;
        for(Integer i:tickets.values()){
            totalAPagar+=i;
        }
        return totalAPagar;
    }
}
