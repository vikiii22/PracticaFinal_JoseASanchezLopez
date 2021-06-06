package Proyecto;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PanelCoctelesYTapas {
    public final JPanel panel;
    List<BotonCoctelesYTapas> botones;
    Ticket ticket;
    PanelCoctelesYTapas(Ticket ticket) throws IOException {
        panel=new JPanel();
        panel.setLayout(new GridLayout(4,3));
        botones=new ArrayList<>();
        rellenaBotonesDeFichero();
        this.ticket=ticket;
        for (BotonCoctelesYTapas b:botones) {
            panel.add(b.getBoton());
            b.getBoton().addActionListener(e -> ticket.anaydeTicket(b.getNombre(), b.getPrecio()));
        }
    }

    private void rellenaBotonesDeFichero() throws IOException {
        List<String>lineas= Files.readAllLines(Paths.get("coctelesYTapas.csv"));
        for (String s:lineas) {
            String[] campos=s.split(":");
            BotonCoctelesYTapas nuevo=new BotonCoctelesYTapas(campos[0], Integer.parseInt(campos[1]), campos[2]);
            botones.add(nuevo);
        }
    }


    public JPanel getPanel(){
        return panel;
    }

    public static void main(String[] args) throws IOException {
        JFrame ventana=new JFrame("Miami Beach");
        Ticket ticket=new Ticket();
        BotonTotal boton=new BotonTotal();
        ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        PanelCoctelesYTapas cocteles=new PanelCoctelesYTapas(ticket);

        ventana.add(cocteles.getPanel());
        ventana.setLayout(new GridLayout(1,2));

        //Botón de total
        JPanel panelBotonYTicket=new JPanel(new BorderLayout());
        panelBotonYTicket.add(boton.getPanel(), BorderLayout.SOUTH);
        boton.getTotal().addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Total a pagar: "+ticket.ensenyaTotal()+"€");
            ESHtml.escribeHTML(ticket.ensenyaTotal());
        });
        ventana.add(panelBotonYTicket);

        //Añadir el panel del ticket
        panelBotonYTicket.add(ticket.getPanel());

        ventana.pack();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
}
