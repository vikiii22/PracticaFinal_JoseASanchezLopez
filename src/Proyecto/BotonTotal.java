package Proyecto;

import javax.swing.*;
import java.awt.*;

/**
 * @author Jose
 * @version 1.0
 */
public class BotonTotal {
    public JPanel ventana;
    public JButton total;
    public JButton imprimeTicket;
    public ImrpimeTicket imprimir;
    public Ticket ticket;

    /**
     * Método del contrustor botón total e imprime ticket
     */
    public BotonTotal(){
        ventana=new JPanel();
        total=new JButton("TOTAL");
        total.setPreferredSize(new Dimension(300,70));
        Font fuente=new Font("Calibri",3,50);
        Font fuente2=new Font("Calibri", 3, 30);
        total.setFont(fuente);
        total.setBackground(Color.GRAY);
        imprimir=new ImrpimeTicket();
        ticket=new Ticket();

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

    /**
     * Método que obtiene el panel
     * @return ventana
     */
    public JPanel getPanel(){
        return ventana;
    }

    /**
     * Método que obtiene el total
     * @return total
     */
    public JButton getTotal() {
        return total;
    }
}
