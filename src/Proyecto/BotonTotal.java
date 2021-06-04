package Proyecto;

import javax.swing.*;
import java.awt.*;

public class BotonTotal {
    JPanel ventana;
    JButton total;
    JButton imprimeTicket;
    public BotonTotal(){
        ventana=new JPanel();
        total=new JButton("TOTAL");
        total.setPreferredSize(new Dimension(200,70));
        Font fuente=new Font("Calibri",3,50);
        Font fuente2=new Font("Calibri", 3, 20);
        total.setFont(fuente);
        total.setBackground(Color.GRAY);

        imprimeTicket=new JButton("Imprime ticket");
        imprimeTicket.setPreferredSize(new Dimension(200,70));
        imprimeTicket.setFont(fuente2);
        imprimeTicket.setBackground(Color.GRAY);

        ventana.add(total);
        ventana.add(imprimeTicket);
        total.addActionListener(e -> System.out.println(total.getText()+" es: "));
    }
    public JPanel getPanel(){
        return ventana;
    }
}
