package Proyecto;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BotonCoctelesYTapas {
    Ticket ticket=new Ticket();
    public JButton getBoton(){
        return boton;
    }


    private final String nombre;
    private JButton boton;
    private final int cantidad;

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public BotonCoctelesYTapas(String nombre, int cantidad, String link){
        boton=new JButton(nombre);
        boton.setIcon(new ImageIcon(link));
        this.nombre=nombre;
        this.cantidad=cantidad;

        int precio=cantidad;
        //boton.addActionListener(e-> System.out.println(nombre + " " +cantidad));
        boton.addActionListener(e -> {
            ticket.anaydeTicket(nombre, cantidad);
        });
        //boton.addActionListener(e -> ticket.texto.setText(nombre +""+cantidad));
    }
}
