package Proyecto;

import javax.swing.*;
import java.awt.*;

public class BotonTotal {
    JPanel ventana;
    JButton total;
    JButton imprimeTicket;
    ImrpimeTicket imprimir;
    public BotonTotal(){
        ventana=new JPanel();
        total=new JButton("TOTAL");
        total.setPreferredSize(new Dimension(300,70));
        Font fuente=new Font("Calibri",3,50);
        Font fuente2=new Font("Calibri", 3, 30);
        total.setFont(fuente);
        total.setBackground(Color.GRAY);
        imprimir=new ImrpimeTicket();

        imprimeTicket=new JButton("Imprime ticket");
        imprimeTicket.setPreferredSize(new Dimension(300,70));
        imprimeTicket.setFont(fuente2);
        imprimeTicket.setBackground(Color.GRAY);

        ventana.add(total);
        ventana.add(imprimeTicket);
        imprimeTicket.addActionListener(e -> {
            imprimir.imprimirTicket("Mis tickets");
        });
    }
    public JPanel getPanel(){
        return ventana;
    }

    public void ensenyaTotal(String nombre, int precio){
        Ticket ticket=new Ticket();
        ticket.anaydeTicket(nombre, precio);
        int totalAPagar=0;
        totalAPagar+=precio;
        JOptionPane.showMessageDialog(null, "El total a pagar es: "+totalAPagar+"€");
    }
}
