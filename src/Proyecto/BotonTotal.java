package Proyecto;

import javax.swing.*;
import java.awt.*;

public class BotonTotal {
    JPanel ventana;
    JButton total;
    public BotonTotal(){
        ventana=new JPanel();
        total=new JButton("Total");
        total.setPreferredSize(new Dimension(400,70));
        total.setBackground(Color.GRAY);
        ventana.add(total);
    }
    public JPanel getPanel(){
        return ventana;
    }
}
