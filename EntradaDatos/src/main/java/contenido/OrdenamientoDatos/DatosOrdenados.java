package contenido.OrdenamientoDatos;

public class DatosOrdenados {
    public int id;
    public int fechaUTC;
    public String horaUTC;
    public double latitud;
    public double longitud;
    public int profundidad;
    public double magnitud;


    public DatosOrdenados//Constructor completo
            (int id, int fecha, String hora, double latitud,
                          double longitud, int profundidad, double magnitud) {
        this.id = id;
        this.fechaUTC = fecha;
        this.horaUTC = hora;
        this.latitud = latitud;
        this.longitud = longitud;
        this.profundidad = profundidad;
        this.magnitud = magnitud;
    }

}
