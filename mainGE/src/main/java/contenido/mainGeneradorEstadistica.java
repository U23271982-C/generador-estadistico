package contenido;
import contenido.EstructuradeEntrada.Acceso;
import contenido.MenuOpciones.Menu;
import contenido.TransformacionDatos.Conversion;

public class mainGeneradorEstadistica {
    public static void main(String[] args) {
        String rutaArchivoBDsismos = "C:\\ProyectoFinal_TP\\GeneradordeEstadistica\\Recursos\\src\\main\\java\\contenido\\BaseDatos\\Catálogo Sísmico Perú 1960-2021 (DATASET).csv";
                //LectorDatos.leerCadena("Ingrese la ruta del archivo de Base de Datos");
        String rutaArchivoCredeciales = "C:\\ProyectoFinal_TP\\GeneradordeEstadistica\\Recursos\\src\\main\\java\\contenido\\BaseDatos\\credencialesBD.txt";
                //LectorDatos.leerCadena("Ingrese la ruta del archivo de credenciales");
        Acceso.validarCredenciales //Validamos si se encuentra el archivo de las credenciales
                (Acceso.validarDireccionArchivoCredenciales(rutaArchivoCredeciales));
        Conversion conversion = new Conversion();

        Menu.Pricipal(conversion.datosBD(rutaArchivoBDsismos));//Mostrar reporte de Menu Principal
    }
}
