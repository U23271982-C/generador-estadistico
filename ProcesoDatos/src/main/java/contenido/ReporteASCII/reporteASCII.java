package contenido.ReporteASCII;

public class reporteASCII {

    private static String reporteMenuPrincipal = """
            -------------------------------------------------------
            MENU PRINCIPAL
            --------------------------------------------------------
            1. Número de eventos sísmicos por año dado un rango de
               años
            2. Número de eventos sísmicos por mes dado un año.
            3. Número de eventos sísmicos por mes dados un rango de
               magnitudes y un año
            4. Número de eventos sísmicos por cada hora dado un año.
            0. FIN DEL PROGRAMA
            --------------------------------------------------------
            Ingrese opción [1 – 4]""";

    private static String reporteMenuFinal = """
            --------------------------------------------------------
            MÓDULO 01 – EVENTOS POR RANGO DE AÑOS
            --------------------------------------------------------
            1. Imprimir por pantalla.
            2. Exportar a archivo plano.
            0. Volver al Menú Principal
            --------------------------------------------------------
            Ingrese opción [1-2]""";


    public static String getReporteMenuPrincipal() {
        return reporteMenuPrincipal;
    }

    public static String getReporteMenuFinal() {
        return reporteMenuFinal;
    }
}
