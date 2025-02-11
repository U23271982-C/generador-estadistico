package contenido;

import java.util.Date;
import java.util.Scanner;

public class LectorDatos {

    private String fechaHoraOperacion;

    public String getFechaHoraOperacion() {
        return fechaHoraOperacion;
    }

    //#region LeerInt

    //lee sin parámetros
    public int leerEntero() {
        Scanner lector = new Scanner(System.in);
        int entrada = -1;

        try {
            System.out.println("Ingrese un valor entero:");
            entrada = lector.nextInt();
            lector.nextLine();

            fechaHoraOperacion = (new Date()).toString();
        } catch (Exception e) {
            //throw new RuntimeException(e);
            System.out.println("Número fuero del rango de Int " + e.getMessage());
        }
        return entrada;
    }

    //lee con parámetros de mensaje entrada; rango min y max
    public static int leerEntero(String mensaje, int minimo, int maximo) {
        Scanner lector = new Scanner(System.in);
        int entrada = -1;

        try {
            do {
                System.out.println(mensaje);
                entrada = lector.nextInt();
                lector.nextLine();
            } while (entrada < minimo || entrada > maximo);
        } catch (Exception e) {
            //throw new RuntimeException(e);
            System.out.println("Número fuero del rango de Int: " + e.getMessage());
        }

        return entrada;
    }

    //lee con parámetros mensaje de entrada y de error; rango min y max
    public static int leerEntero(String mensaje, String mensajeError, int minimo, int maximo) {
        Scanner lector = new Scanner(System.in);
        int entrada = -1;
        boolean esValorValido;

        try {
            do {
                System.out.println(mensaje);
                entrada = lector.nextInt();
                lector.nextLine();
                esValorValido = !(entrada < minimo || entrada > maximo);
                if (!esValorValido) {
                    System.out.println(mensajeError);
                }
            } while (!esValorValido);
        } catch (Exception e) {
            //throw new RuntimeException(e);
            System.out.println("Número fuero del rango de Int " + e.getMessage());

        }

        return entrada;
    }
    //#endregion

    //#region LeerByte

    //lee con parámetros mensaje de entrada; rango min y max
    public static byte leerByte(String mensaje, int minimo, int maximo){
        Scanner lector = new Scanner(System.in);
        byte entrada;

        do {
            System.out.println(mensaje);
            entrada = lector.nextByte();
            lector.nextLine();
        } while (entrada < minimo || entrada > maximo);

        // fechaHoraOperacion = (new Date()).toString();
        return entrada;
    }

    //lee con parámetros mensaje de entrad y de error; rango min y max
    public static byte leerByte(String mensaje, String mensajeError, byte minimo, byte maximo){
        Scanner lector = new Scanner(System.in);
        byte entrada = -1;
        boolean esValorValido;

        try {
            do {
                System.out.println(mensaje);
                entrada = lector.nextByte();
                lector.nextLine();
                esValorValido = !(entrada < minimo || entrada > maximo);
                if (!esValorValido) {
                    System.out.println(mensajeError);
                }
            } while (!esValorValido);
        } catch (Exception e) {
            //throw new RuntimeException(e.getMessage());
            System.out.println("Número fuero del rango de Byte (-128 a 127) "+ e.getMessage());
        }
        return entrada;
    }
    //#endregion

    //#region LeerDouble

    //lee con parámetros mensaje de entrada y error; rango min y max
    public static double leerDouble(String mensaje, String mensajeError, double minimo, double maximo){
        Scanner lector = new Scanner(System.in);
        double entrada = 0.0;
        boolean esValorValido;

        try {
            do {
                System.out.println(mensaje);
                entrada = lector.nextDouble();
                lector.nextLine();
                esValorValido = !(entrada < minimo || entrada > maximo);
                if (!esValorValido) {
                    System.out.println(mensajeError);
                }
            } while (!esValorValido);
        } catch (Exception e) {
            //throw new RuntimeException(e.getMessage());
            System.out.println(e.getMessage());
        }
        return entrada;
    }

    //lee parámetro de mensaje de entrada
    public static double leerDouble(String mensaje){
        Scanner lector = new Scanner(System.in);

        double entrada = -1.0;
        try {
            entrada = lector.nextDouble();
            lector.nextLine();
        } catch (Exception e) {
            //throw new RuntimeException(e);
            System.out.println("Número fuero del rango de Double: " + e.getMessage());
        }

        return entrada;
    }
    //#endregion

    //#region LeerString

    //lee con parámetros mensaje de entrada
    public static String leerCadena(String mensaje) {
        Scanner lector = new Scanner(System.in);
        String entrada = "";

        try {
            do {
                System.out.println(mensaje);
                entrada = lector.nextLine();
            } while (entrada.isEmpty());
        } catch (Exception e) {
            //throw new RuntimeException(e);
            System.out.println("La entrada no es tipo cadena " + e.getMessage());
        }

        return entrada;
    }

    //lee ruta para guardar y dar la extenión de un archivoplano
    public static String leerRutaGuardarTextoPlano(){
        Scanner lector = new Scanner(System.in);
        String ruta;
        String nombreArchivo;

        do {
            System.out.println("Ingrese la ruta donde desea guardar el archivo plano");
            ruta = lector.nextLine();
        } while (ruta.isEmpty());

        do {
            System.out.println("Ingrese nuevo nombre para el archivo plano");
            nombreArchivo = lector.nextLine();
        } while (nombreArchivo.isEmpty());

        String extencionArchivoPlano = """
                FORMATO DE TEXTO PLANO
                ===============================
                [1] .txt
                [2] .csv
                [3] .json
                ===============================""";
        byte opcion = LectorDatos.leerByte(extencionArchivoPlano,1,3);
        String extencion =
                switch (opcion){
                    case 1  -> ".txt";
                    case 2  -> ".csv";
                    default -> ".json";
                };

        return String.format("%s\\%s%s",ruta,nombreArchivo,extencion);
    }
    //#endregions

}
