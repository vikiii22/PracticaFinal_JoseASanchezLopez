package Proyecto;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase principal
 * @author Jose
 * @Version 1.0
 */

public class PanelCoctelesYTapas {
    public final JPanel panel;
    List<BotonCoctelesYTapas> botones;
    public Ticket ticket;

    /**
     * Constructor panel principal
     * @param ticket
     * @throws IOException
     */
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

    /**
     * Método que rellena los botones automáticamente desde el fichero.csv
     * @throws IOException
     */
    private void rellenaBotonesDeFichero() throws IOException {
        List<String>lineas= Files.readAllLines(Paths.get("coctelesYTapas.csv"));
        for (String s:lineas) {
            String[] campos=s.split(":");
            BotonCoctelesYTapas nuevo=new BotonCoctelesYTapas(campos[0], Integer.parseInt(campos[1]), campos[2]);
            botones.add(nuevo);
        }
    }

    /**
     * Método que obtiene el panel
     * @return panel
     */
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
            JOptionPane.showMessageDialog(null, "<html><h1>Miami Beach Ticket</h1>"+ticket.salidaTicket()+
                    "<html><hr><br><h1>Total a pagar: "+ticket.ensenyaTotal()+"€</h1>");
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
