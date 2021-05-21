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
    PanelCoctelesYTapas() throws IOException {
        panel=new JPanel();
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

        ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        PanelCoctelesYTapas cocteles=new PanelCoctelesYTapas();

        ventana.add(cocteles.getPanel());

        ventana.pack();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
}
