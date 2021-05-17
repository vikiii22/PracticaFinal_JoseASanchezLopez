package Proyecto;

import javax.swing.*;

public class BotonCoctelesYTapas {
    public JButton getBoton(){
        return boton;
    }
    
    String nombre;
    JButton boton;
    int cantidad;
    
    public BotonCoctelesYTapas(String nombre, int cantidad){
        this.nombre=nombre;
        this.cantidad=cantidad;
    }
}
