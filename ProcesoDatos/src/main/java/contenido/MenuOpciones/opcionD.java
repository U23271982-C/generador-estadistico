package contenido.MenuOpciones;

import contenido.LectorDatos;
import contenido.OrdenamientoDatos.DatosOrdenados;

public class opcionD {
    public static void resolver(DatosOrdenados[] BD) {

        //#region Formato Reporte D
        String opcionD = """
            Reporte D: Tabla con el número de eventos sísmicos por cada hora dado un año.\s
            (en este caso los datos corresponden al año %d)

            HORA        FREC    PORC
            ============================
            00          %2d      %5.2f%%
            01          %2d      %5.2f%%
            02          %2d      %5.2f%%
            03          %2d      %5.2f%%
            04          %2d      %5.2f%%
            05          %2d      %5.2f%%
            06          %2d      %5.2f%%
            07          %2d      %5.2f%%
            08          %2d      %5.2f%%
            09          %2d      %5.2f%%
            10          %2d      %5.2f%%
            11          %2d      %5.2f%%
            12          %2d      %5.2f%%
            13          %2d      %5.2f%%
            14          %2d      %5.2f%%
            15          %2d      %5.2f%%
            16          %2d      %5.2f%%
            17          %2d      %5.2f%%
            18          %2d      %5.2f%%
            19          %2d      %5.2f%%
            20          %2d      %5.2f%%
            21          %2d      %5.2f%%
            22          %2d      %5.2f%%
            23          %2d      %5.2f%%
            ============================
            TOTAL       %2d     %5.2f%%
            """;
        //#endregion

        int yearEntreda = 0;

        yearEntreda = LectorDatos.leerEntero("Ingrese el año",
                    "Año fuera del rango", 1960, 2021);


        int[] contadoreHora = new int[24];//arreglo par contar horas

        for (int i = 0; i < BD.length; i++) {
            String fecha = Integer.toString(BD[i].fechaUTC);//convierte cadena fecha
            int year = Integer.parseInt(fecha.substring(0, 4));//separa año (0,4)
            if (yearEntreda == year) {
                String hora = BD[i].horaUTC.substring(0,2);//separa hora (0,2)

                switch (hora){//se suma según la clasificación de hora
                    //#region Clasifiacion Hora
                    case "01" -> contadoreHora[0]++;
                    case "02" -> contadoreHora[1]++;
                    case "03" -> contadoreHora[2]++;
                    case "04" -> contadoreHora[3]++;
                    case "05" -> contadoreHora[4]++;
                    case "06" -> contadoreHora[5]++;
                    case "07" -> contadoreHora[6]++;
                    case "08" -> contadoreHora[7]++;
                    case "09" -> contadoreHora[8]++;
                    case "10" -> contadoreHora[9]++;
                    case "11" -> contadoreHora[10]++;
                    case "12" -> contadoreHora[11]++;
                    case "13" -> contadoreHora[12]++;
                    case "14" -> contadoreHora[13]++;
                    case "15" -> contadoreHora[14]++;
                    case "16" -> contadoreHora[15]++;
                    case "17" -> contadoreHora[16]++;
                    case "18" -> contadoreHora[17]++;
                    case "19" -> contadoreHora[18]++;
                    case "20" -> contadoreHora[19]++;
                    case "21" -> contadoreHora[20]++;
                    case "22" -> contadoreHora[21]++;
                    case "23" -> contadoreHora[22]++;
                    default -> contadoreHora[23]++;
                    //endregion
                }
            }
        }


        int sumaTotal = 0;//suma catidad total horas
        for (int j : contadoreHora) {
            sumaTotal += j;
        }

        //porcentaje
        float[] porcentaje = new float[24];
        for (int i = 0; i < contadoreHora.length; i++) {
            porcentaje[i] = (float) (contadoreHora[i] * 100) / sumaTotal;
        }


        float sumaTotalporcentaje = 0;
        for (float v : porcentaje) {
            sumaTotalporcentaje += v;
        }

        //#region Formato Impresion
        String Tablad = String.format
                (opcionD, yearEntreda,
                contadoreHora[23], porcentaje[23],
                contadoreHora[0], porcentaje[1],
                contadoreHora[1], porcentaje[2],
                contadoreHora[2], porcentaje[3],
                contadoreHora[3], porcentaje[4],
                contadoreHora[4], porcentaje[5],
                contadoreHora[5], porcentaje[6],
                contadoreHora[6], porcentaje[7],
                contadoreHora[7], porcentaje[8],
                contadoreHora[8], porcentaje[9],
                contadoreHora[9], porcentaje[10],
                contadoreHora[10], porcentaje[11],
                contadoreHora[11], porcentaje[12],
                contadoreHora[12], porcentaje[13],
                contadoreHora[13], porcentaje[14],
                contadoreHora[14], porcentaje[15],
                contadoreHora[15], porcentaje[16],
                contadoreHora[16], porcentaje[17],
                contadoreHora[17], porcentaje[18],
                contadoreHora[18], porcentaje[19],
                contadoreHora[19], porcentaje[20],
                contadoreHora[20], porcentaje[21],
                contadoreHora[21], porcentaje[22],
                contadoreHora[22], porcentaje[23], sumaTotal, sumaTotalporcentaje);
        //#endregion

        Menu.Final(Tablad, BD);
    }
}