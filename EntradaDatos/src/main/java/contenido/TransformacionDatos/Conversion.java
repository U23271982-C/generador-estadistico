package contenido.TransformacionDatos;
import contenido.OrdenamientoDatos.DatosOrdenados;
import contenido.gestorDatos;

public class Conversion {
    DatosOrdenados[] Datos = new DatosOrdenados[Conversion.contadorFilasBD()];

    public static String ruta = "C:\\ProyectoFinal_TP\\GeneradordeEstadistica\\Recursos\\src\\main\\java\\contenido\\BaseDatos\\Catálogo Sísmico Perú 1960-2021 (DATASET).csv";

    //BD convertidas en fila
    public DatosOrdenados[] datosBD(String ruta) {
        String datos = "";
        try{
            datos = gestorDatos.abrirArchivo(ruta);
        }catch (Exception e){
            /*clasificar las expeciones*/
            System.out.println(e.getMessage());
        }

        //Separamos BD por fila
        String[] sismosBDPlano = datos.split("\r\n");

        //Hacemos una copia para quitar el enunciado
        String[] sismosBD = new String[sismosBDPlano.length - 1];
        System.arraycopy(sismosBDPlano,1,sismosBD,0,sismosBD.length);

        //agregamos los dastos al constructor
        for (int i = 0; i < sismosBD.length; i++) {
            String[] datosSeparados = sismosBD[i].split(",");

            Datos[i] = new DatosOrdenados(Integer.parseInt(datosSeparados[0]),
                    Integer.parseInt(datosSeparados[1]),datosSeparados[2],
                    Double.parseDouble(datosSeparados[3]),Double.parseDouble(datosSeparados[4])
                    ,Integer.parseInt(datosSeparados[5]),Double.parseDouble(datosSeparados[6]));
        }
        return Datos;
    }
    //contador filas BD
    public static int contadorFilasBD() {
        String datos = "";
        try{
            datos = gestorDatos.abrirArchivo(ruta);
        }catch (Exception e){
            /*clasificar las expeciones*/
            System.out.println(e.getMessage());
        }

        //Separamos BD por fila
        String[] simosBDPlano = datos.split("\n");

        return simosBDPlano.length-1;
    }

}
