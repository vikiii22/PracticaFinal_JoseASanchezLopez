package Proyecto;

import javax.swing.*;
import java.awt.*;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Jose
 * @version 1.0
 */
public class Ticket extends JFrame{
    JPanel panel;
    public JTextArea texto;
    Map<String, Integer> tickets;

    /**
     * Constructor de Ticket
     */
    public Ticket(){
        panel=new JPanel();
        texto=new JTextArea(30,30);
        texto.setSize(30,30);
        Font fuente=new Font("Calibri", 1, 30);
        texto.setFont(fuente);
        texto.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        this.panel.add(texto);
        tickets=new TreeMap<>();
    }

    public JTextArea getTexto(){
        return texto;
    }

    /**
     * Método que devuelve el panel
     * @return panel
     */
    public JPanel getPanel() {
        return panel;
    }

    /**
     * Método que añade el ticket en el JTextArea
     * @param nombre
     * @param precio
     */
    public void anaydeTicket(String nombre, int precio) {
        if (!tickets.containsKey(nombre)){
            tickets.put(nombre, precio);
        }else {
            tickets.put(nombre,tickets.get(nombre)+precio);
        }
        actualizar();
    }

    /**
     * Método que actualiza
     */
    private void actualizar() {
        String salida=" ";
        int total=0;
        for (Map.Entry<String, Integer>tapas:tickets.entrySet()) {
            salida+=tapas.getKey()+": "+tapas.getValue()+"€\n";
            total+=tapas.getValue();
        }
        texto.setText(salida+"\n\n\n-----------------\nTotal: "+total+"€");
    }

    /**
     * Método para sacar el total
     * @return total
     */
    public int ensenyaTotal(){
        int totalAPagar=0;
        for(Integer i:tickets.values()){
            totalAPagar+=i;
        }
        return totalAPagar;
    }

    /**
     * Método para hacer una salida de ticket
     * @return salida
     */
    public String salidaTicket(){
        String salida=" ";
        int total=0;
        for (Map.Entry<String, Integer>tapas:tickets.entrySet()) {
            salida+=tapas.getKey()+": "+tapas.getValue()+"€\n";
            total+=tapas.getValue();
    }
        return salida;
}
}
