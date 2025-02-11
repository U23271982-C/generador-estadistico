package contenido.MenuOpciones;

import contenido.LectorDatos;
import contenido.OrdenamientoDatos.DatosOrdenados;

public class opcionB {
    public static void resolver(DatosOrdenados[] BD){

        //# region Formato Reporte B
        String opcionB = """
            Reporte B: Tabla con el número de eventos sísmicos por mes dado un año.\s
            (en este caso los datos corresponden al año %d)
            Nº    MES            FREC   PORC
            ==================================
            01    ENERO          %2d     %5.2f%%
            02    FEBRERO        %2d     %5.2f%%
            03    MARZO          %2d     %5.2f%%
            04    ABRIL          %2d     %5.2f%%
            05    MAYO           %2d     %5.2f%%
            06    JUNIO          %2d     %5.2f%%
            07    JULIO          %2d     %5.2f%%
            08    AGOSTO         %2d     %5.2f%%
            09    SEPTIEMBRE     %2d     %5.2f%%
            10    OCTUBRE        %2d     %5.2f%%
            11    NOVIEMBRE      %2d     %5.2f%%
            12    DICIEMBRE      %2d     %5.2f%%
            ==================================
            TOTAL                %2d    %5.2f%%
            """;
        //#endregion

        int[] contMes = new int[12];

        int yearEntrada;

        yearEntrada = LectorDatos.leerEntero("Ingrese el año",
                    "Año fuera del rango",1960,2021);


        for (int i = 0; i < BD.length; i++) {
            String fecha = Integer.toString(BD[i].fechaUTC);//converte cadena fecha
            int year = Integer.parseInt(fecha.substring(0, 4));//separa año (0,4)
            if (yearEntrada == year){
                int mes = Integer.parseInt(fecha.substring(4, 6));//separa mes (4,6)
                switch (mes){
                    //#region Clasificacion Mes
                    case 1  -> contMes[0]++;
                    case 2  -> contMes[1]++;
                    case 3  -> contMes[2]++;
                    case 4  -> contMes[3]++;
                    case 5  -> contMes[4]++;
                    case 6  -> contMes[5]++;
                    case 7  -> contMes[6]++;
                    case 8  -> contMes[7]++;
                    case 9  -> contMes[8]++;
                    case 10 -> contMes[9]++;
                    case 11 -> contMes[10]++;
                    default -> contMes[11]++;
                    //#endregion
                }
            }
        }

        //suma cantidad total mes
        int sumaTotal = 0;
        for (int contme : contMes) {
            sumaTotal += contme;
        }

        //porcentaje
        float[] porcentaje = new float[12];
        for (int i = 0; i < contMes.length; i++) {
            porcentaje[i] = (float) (contMes[i] * 100) / sumaTotal;
        }

        float sumaTotalporcentaje = 0;
        for (float v : porcentaje) {
            sumaTotalporcentaje += v;
        }

        //#region Formato Impresion
        String Tablab = String.format(opcionB, yearEntrada,contMes[0], porcentaje[0], contMes[1], porcentaje[1],
                contMes[2], porcentaje[2], contMes[3], porcentaje[3], contMes[4], porcentaje[4],
                contMes[5], porcentaje[5], contMes[6], porcentaje[6], contMes[7], porcentaje[7],
                contMes[8], porcentaje[8], contMes[9], porcentaje[9], contMes[10], porcentaje[10],
                contMes[11], porcentaje[11], sumaTotal, sumaTotalporcentaje);
        //#endregion

        Menu.Final(Tablab, BD);
    }
}

