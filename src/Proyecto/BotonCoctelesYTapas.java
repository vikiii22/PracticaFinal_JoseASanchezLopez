package Proyecto;

import javax.swing.*;
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
        this.nombre=nombre;
        this.cantidad=cantidad;

        boton.addActionListener(e-> System.out.println(cantidad));
        //boton.addActionListener(e -> ticket.texto.setText(""+cantidad));
    }
}
