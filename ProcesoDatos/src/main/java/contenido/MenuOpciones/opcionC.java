package contenido.MenuOpciones;

import contenido.LectorDatos;
import contenido.OrdenamientoDatos.DatosOrdenados;


public class opcionC {
    public static void resolver(DatosOrdenados[] BD){
        //#region Formato Reporte C
        String opcionC = """
            Reporte C: Tabla con el número de eventos sísmicos por cada hora dado un año.\s
            (en este caso los datos corresponden a las magnitudes entre %.2f y %.2f \ndel año %d)
            
            Nº    MES            FREC  PORC
            ===================================
            01    ENERO          %2d    %5.2f%%
            02    FEBRERO        %2d    %5.2f%%
            03    MARZO          %2d    %5.2f%%
            04    ABRIL          %2d    %5.2f%%
            05    MAYO           %2d    %5.2f%%
            06    JUNIO          %2d    %5.2f%%
            07    JULIO          %2d    %5.2f%%
            08    AGOSTO         %2d    %5.2f%%
            09    SEPTIEMBRE     %2d    %5.2f%%
            10    OCTUBRE        %2d    %5.2f%%
            11    NOVIEMBRE      %2d    %5.2f%%
            12    DICIEMBRE      %2d    %5.2f%%
            ===================================
            TOTAL                %2d   %5.2f%%
            """;
        //#endregion

        //#region Lectura Datos
        int yearEntrada = LectorDatos.leerEntero("Ingrese año",
                "Rango de año inválido",1960,2021);

        double magnitudIncio = LectorDatos.leerDouble("Ingrese magnitud inicial",
                "Magnitud inválida", 0,10);
        double magnitudFin = LectorDatos.leerDouble("Ingrese magnitud final",
                "Magnitud inválida", magnitudIncio,10);
        //#endregion

        int[] contadoreMes = new int[12];

        //int contadorYearMagnitud = 0;
        for (int i = 0; i < BD.length; i++) {
            String fecha = Integer.toString(BD[i].fechaUTC);//convierte cadena fecha
            int year = Integer.parseInt(fecha.substring(0,4));//separa año
            if (year == yearEntrada) {
                //verificamos si esta dentro de las magnitudes
                if (BD[i].magnitud >= magnitudIncio && BD[i].magnitud <= magnitudFin) {
                    //extraemos el número del mes
                    int mes = Integer.parseInt(fecha.substring(4, 6));
                    //sumamos según el número del mes
                    switch (mes) {
                        //#region Clasificación Mes
                        case 1 -> contadoreMes[0]++;
                        case 2 -> contadoreMes[1]++;
                        case 3 -> contadoreMes[2]++;
                        case 4 -> contadoreMes[3]++;
                        case 5 -> contadoreMes[4]++;
                        case 6 -> contadoreMes[5]++;
                        case 7 -> contadoreMes[6]++;
                        case 8 -> contadoreMes[7]++;
                        case 9 -> contadoreMes[8]++;
                        case 10 -> contadoreMes[9]++;
                        case 11 -> contadoreMes[10]++;
                        default -> contadoreMes[11]++;
                        //#endregion
                    }
                }
            }
        }

        //suma cantidad total mes
        int sumaTotal = 0;
        for (int i : contadoreMes){
            sumaTotal += i;
        }

        //porcentaje
        float[] porcentaje = new float[12];
        for (int i = 0; i < contadoreMes.length; i++) {
            porcentaje[i] = (float) (contadoreMes[i] * 100) / sumaTotal;
        }

        float sumaTotalporcentaje = 0;
        for (float j : porcentaje) {
            sumaTotalporcentaje += j;
        }

        //#region Formato Impresion
        String TablaC = String.format(opcionC, magnitudIncio, magnitudFin, yearEntrada,
                contadoreMes[0], porcentaje[0],
                contadoreMes[1], porcentaje[1],
                contadoreMes[2], porcentaje[2],
                contadoreMes[3], porcentaje[3],
                contadoreMes[4], porcentaje[4],
                contadoreMes[5], porcentaje[5],
                contadoreMes[6], porcentaje[6],
                contadoreMes[7], porcentaje[7],
                contadoreMes[8], porcentaje[8],
                contadoreMes[9], porcentaje[9],
                contadoreMes[10], porcentaje[10],
                contadoreMes[11], porcentaje[11],
                sumaTotal,sumaTotalporcentaje
                );
        //#endregion

        Menu.Final(TablaC, BD);
    }
}
