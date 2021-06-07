package Proyecto;

import java.io.IOException;
import java.io.UTFDataFormatException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ESHtml {
    public static void escribeHTML(int total){
        String salida="<html><head><meta charset=\"UTF-8\"><link rel=\"stylesheet\" type=\"text/css\" href=\"estilo.css\" media=\"screen\"/></head>";
        salida+="<body><h1>Total a pagar: </h1><h2>"+total+"€</h2></body></html>";
        try {
            Files.writeString(Paths.get("pagina.html"), salida, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
