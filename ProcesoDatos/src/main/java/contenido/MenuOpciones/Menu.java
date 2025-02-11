package contenido.MenuOpciones;

import contenido.EstructuradeEntrada.validarOpcion;
import contenido.LectorDatos;
import contenido.OrdenamientoDatos.DatosOrdenados;
import contenido.gestorDatos;

import java.io.IOException;

public class Menu {
    public static void Pricipal(DatosOrdenados[] BD) {//Clasificación de las opciones del menu principal
        switch (validarOpcion.opcionMenuPrincipal()) {
            case 0:
                System.out.println("CIERRE COMPLETADO");
                System.exit(0);

            case 1: opcionA.resolver(BD);break;//Invoca la clase opcion A

            case 2: opcionB.resolver(BD);break;//Invoca la clase opcion B

            case 3: opcionC.resolver(BD);break;//Invoca la clase opcion C

            case 4: opcionD.resolver(BD);break;//Invoca la clase opcion D
        }
    }

    public static void Final(String mostrarASCII, DatosOrdenados[] BD){//Calsifiación de las opciones del segundo menu
        switch (validarOpcion.opcionMenuFinal()){
            case 0: Menu.Pricipal(BD);break;//Regresa al menú principal

            case 1: System.out.println(mostrarASCII); break;//Imprime en consola

            case 2://Guarda el archivo plano
                String rutaGuardarArchivo = LectorDatos.leerRutaGuardarTextoPlano();
                try {
                    gestorDatos.guardarArchivo(rutaGuardarArchivo,mostrarASCII);
                    System.out.println("Se guardo con éxito");
                } catch (IOException e) {
                    //throw new RuntimeException(e);
                    System.out.println("No se encontro la ruta para guardar el archivo" + e.getMessage());
                }
                break;
        }
    }
}
