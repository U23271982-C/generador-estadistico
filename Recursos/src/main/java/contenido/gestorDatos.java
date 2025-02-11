package contenido;

import java.io.FileReader;
import java.io.IOException;
import java.io.*;

public class gestorDatos {
        //Abre archivo de plano
        public static String abrirArchivo(String ruta) throws IOException {
                StringBuilder contenido = new StringBuilder();
                FileReader lector = new FileReader(ruta);
                int caracter;
                while ((caracter = lector.read()) != -1) {
                        contenido.append((char)caracter);
                }
                lector.close();
                return contenido.toString();
        }

        //Guarda archivo plano
        public static void guardarArchivo(String ruta, String mensaje) throws IOException {
                File archivo = new File(ruta);
                FileWriter escritor = new FileWriter(ruta);

                escritor.write(mensaje.toCharArray());
                escritor.close();
        }
}
