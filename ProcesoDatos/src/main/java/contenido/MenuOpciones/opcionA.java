package contenido.MenuOpciones;

import contenido.LectorDatos;
import contenido.OrdenamientoDatos.DatosOrdenados;

import java.util.Objects;

public class opcionA {

        public static void resolver(DatosOrdenados[] BD){
            String opcionA = """
                Reporte A: Tabla con el número de eventos sísmicos por año dado un rango de año. \s
                (en este caso los datos corresponden a los años %d y %d)
                Nº    AÑO         FREC  PORC
                ===============================
                %s
                ===============================
                TOTAL             %d    %.2f
                """;

            int yearIncio = LectorDatos.leerEntero("Ingrese el año incio",
                    "Año fuera del rango",1960,2021);
            int yearFin = LectorDatos.leerEntero("Ingrese el año final",
                    "Año fuera del rango",yearIncio,2021);
            String[] Years = new String[yearFin - yearIncio + 1]; // guardamos todos los años
            int[] contYears = new int[Years.length];

            for (int i = 0; i < BD.length; i++) {
                String fecha = Integer.toString(BD[i].fechaUTC); // convierte cadena fecha
                int year = Integer.parseInt(fecha.substring(0, 4)); // separa año (0,4)

                if (year >= yearIncio && year <= yearFin) {
                    for (int j = 0; j < contYears.length; j++) {
                        if (Years[j] == null) {
                            Years[j] = Integer.toString(year);
                            contYears[j]++;
                            break;
                        } else if (Objects.equals(Years[j], Integer.toString(year))) {
                            contYears[j]++;
                            break;
                        }
                    }
                }
            }

            // contador total
            int sumaTotal = 0;
            for (int contme : contYears) {
                sumaTotal += contme;
            }

            // porcentaje
            float[] porcentaje = new float[Years.length];
            for (int i = 0; i < contYears.length; i++) {
                porcentaje[i] = (float) (contYears[i] * 100) / sumaTotal;
            }

            float sumaTotalporcentaje = 0;
            for (float porcen : porcentaje) {
                sumaTotalporcentaje += porcen;
            }

            StringBuilder sb = new StringBuilder();
            String lineaReporte = "%d    %s          %d    %.2f\n";
            int cont = 1;
            for (int i = 0; i < contYears.length; i++) {
                if (Years[i] != null) {
                    sb.append(String.format(lineaReporte, cont++, Years[i], contYears[i], porcentaje[i]));
                }
            }

            String TablaA = sb.toString();
            System.out.printf(opcionA, yearIncio, yearFin, TablaA, sumaTotal, sumaTotalporcentaje);



        Menu.Final(TablaA, BD);
    }
}