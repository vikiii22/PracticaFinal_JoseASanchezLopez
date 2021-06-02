package Proyecto;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

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

    public BotonCoctelesYTapas(String nombre, int cantidad){
        boton=new JButton(nombre);
        //boton
        this.nombre=nombre;
        this.cantidad=cantidad;

        int precio=cantidad;
        //boton.addActionListener(e-> System.out.println(nombre + " " +cantidad));
        boton.addActionListener(e -> ticket.anaydeTicket(nombre, cantidad));
    }
}
