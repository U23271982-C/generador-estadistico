package contenido.EstructuradeEntrada;

import contenido.LectorDatos;
import contenido.ReporteASCII.reporteASCII;

import java.util.Scanner;

public class validarOpcion {

    public static byte opcionMenuPrincipal(){//Lee la opcion del menu principal
        byte entrada = 0;
            try {

                entrada = LectorDatos.leerByte(reporteASCII.getReporteMenuPrincipal(),
                            "Elección inválida",(byte)0,(byte)4);

            } catch (Exception e) {
                //throw new RuntimeException(e.getMessage());
                System.out.println("Entrada de dato incorrecta :" + e.getMessage());
            }
        return entrada;

    }

    public static short opcionMenuFinal(){//Lee la opcion del segundo menu
        try {
            return LectorDatos.leerByte(reporteASCII.getReporteMenuFinal(),
                    "Elección inválida",(byte)0,(byte)2);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
