package Proyecto;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.atomic.AtomicInteger;

public class BotonCoctelesYTapas {
    Ticket ticket=new Ticket();
    public JButton getBoton(){
        return boton;
    }


    private final String nombre;
    private JButton boton;
    private final int precio;

    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public BotonCoctelesYTapas(String nombre, int precio, String link){
        boton=new JButton();
        boton.setIcon(new ImageIcon(link));
        boton.setMaximumSize(new Dimension(20,20));
        this.nombre=nombre;
        this.precio =precio;

        //int cantidad=precio;
        //boton.addActionListener(e-> System.out.println(nombre + " " +precio));
        boton.addActionListener(e -> {
            ticket.anaydeTicket(nombre, precio);
        });
        //boton.addActionListener(e -> ticket.texto.setText(nombre +""+precio));
    }
}
