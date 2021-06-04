package Proyecto;

import javax.swing.*;
import java.awt.*;

public class BotonTotal {
    JPanel ventana;
    JButton total;
    public BotonTotal(){
        ventana=new JPanel();
        total=new JButton("TOTAL");
        total.setPreferredSize(new Dimension(400,70));
        Font fuente=new Font("Calibri",3,50);
        total.setFont(fuente);
        total.setBackground(Color.GRAY);
        ventana.add(total);
        total.addActionListener(e -> System.out.println(total.getText()+" es: "));
    }
    public JPanel getPanel(){
        return ventana;
    }
}
