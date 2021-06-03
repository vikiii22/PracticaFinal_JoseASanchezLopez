package Proyecto;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PanelCoctelesYTapas {
    public final JPanel panel;
    List<BotonCoctelesYTapas> botones;
    PanelCoctelesYTapas() throws IOException {
        panel=new JPanel();
        panel.setLayout(new GridLayout(4,3));
        botones=new ArrayList<>();
        rellenaBotonesDeFichero();
        for (BotonCoctelesYTapas b:botones) {
            panel.add(b.getBoton());
        }
    }

    private void rellenaBotonesDeFichero() throws IOException {
        List<String>lineas= Files.readAllLines(Paths.get("coctelesYTapas.csv"));
        for (String s:lineas) {
            String[] campos=s.split(":");
            BotonCoctelesYTapas nuevo=new BotonCoctelesYTapas(campos[0], Integer.parseInt(campos[1]));
            botones.add(nuevo);
        }
    }


    public JPanel getPanel(){
        return panel;
    }

    public static void main(String[] args) throws IOException {
        JFrame ventana=new JFrame("Miami Beach");
        Ticket ticket=new Ticket();
        ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        PanelCoctelesYTapas cocteles=new PanelCoctelesYTapas();

        ventana.add(cocteles.getPanel());
        ventana.setLayout(new GridLayout(1,2));

        //Botón de total
        JPanel panelBoton=new JPanel(new BorderLayout());
        JButton total=new JButton("Total");;
        total.setPreferredSize(new Dimension(120,70));
        total.setBackground(Color.GRAY);
        panelBoton.add(total, BorderLayout.SOUTH);
        ventana.add(panelBoton);

        //Añadir el panel del ticket
        //ventana.add(ticket.getPanel());
        panelBoton.add(ticket.getPanel());

        ventana.pack();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
}
