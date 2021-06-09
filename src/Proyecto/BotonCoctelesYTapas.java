package Proyecto;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Jose
 * @version 1.0
 */
public class BotonCoctelesYTapas {
    Ticket ticket=new Ticket();
    public JButton getBoton(){
        return boton;
    }


    private final String nombre;
    private JButton boton;
    private final int precio;

    /**
     * Método que devuelve el nombre
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método que devuelve el precio
     * @return precio
     */
    public int getPrecio() {
        return precio;
    }

    /**
     * Constructor de la clase Boton de cócteles y tapas
     * @param nombre
     * @param precio
     * @param link
     */
    public BotonCoctelesYTapas(String nombre, int precio, String link){
        boton=new JButton();
        boton.setIcon(new ImageIcon(link));
        boton.setMaximumSize(new Dimension(20,20));
        this.nombre=nombre;
        this.precio =precio;

        boton.addActionListener(e -> {
            ticket.anaydeTicket(nombre, precio);
        });
    }
}
