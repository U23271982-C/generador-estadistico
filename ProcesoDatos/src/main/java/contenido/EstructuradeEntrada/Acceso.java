package contenido.EstructuradeEntrada;
import contenido.LectorDatos;
import contenido.gestorDatos;

import java.io.IOException;

public class Acceso {

    private static String datos;

    //Valida si esta el archivo en la ruta
    public static String[] validarDireccionArchivoCredenciales(String direcArchivoCredenciales){
        boolean salir = true;
        do {
            try {
                datos = gestorDatos.abrirArchivo(direcArchivoCredenciales);
                System.out.println("Bienvenido");
                break;
            } catch (IOException e) {
                System.out.println(e.getMessage());
                salir = false;
            }
        }while (!salir);
        String[] credenciales = datos.split("\r\n");

        return credenciales;
    }

    //Valida las credenciales ingresadas
    public static void validarCredenciales(String[] credencialesBD) {
        boolean validador = false;
        int contador = 0;
        try {
            do {
                String user = LectorDatos.leerCadena("Ingrese usuario");
                String password = LectorDatos.leerCadena("Ingrese contraseña");
                String credenciales = String.format("%s|%s",user,password);
                //buscamos si esta las credenciales en nuestra BD credenciales
                for (String s : credencialesBD) {
                    if (s.equals(credenciales)) {
                        validador = true;
                        break;
                    }
                }
                if (validador){
                    System.out.println("Se verifico las credenciales");break;
                }else {
                    contador++;
                    System.out.println("No se encontró las credenciales. Intento: " + contador);
                    if (contador == 3){
                        System.out.println("Llegaste al límete de intentos");
                        System.exit(0);}
                }
            } while (contador < 3);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
