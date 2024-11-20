package Cinema;
/**
 *
 * @author's : Lombana y Moreno
 */
public class Pelicula {

    private int idPelicula;
    private String titulo;
    private String sinopsis;
    private String director;
    private String fechaEstreno;
    private double calificacionCritica;
    private double calificacionAudiencia;
    private String portada;
    private String cineSeleccionado;

    // Constructor vacío
    public Pelicula() {
    }

    // Constructor con todos los parámetros
    public Pelicula(int idPelicula, String titulo, String sinopsis, String director, String fechaEstreno, double calificacionCritica, double calificacionAudiencia, String portada, String cineSeleccionado) {
        this.idPelicula = idPelicula;
        this.titulo = titulo;
        this.sinopsis = sinopsis;
        this.director = director;
        this.fechaEstreno = fechaEstreno;
        this.calificacionCritica = calificacionCritica;
        this.calificacionAudiencia = calificacionAudiencia;
        this.portada = portada;
        this.cineSeleccionado = cineSeleccionado;
    }

    // Getters y setters
    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getFechaEstreno() {
        return fechaEstreno;
    }

    public void setFechaEstreno(String fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public double getCalificacionCritica() {
        return calificacionCritica;
    }

    public void setCalificacionCritica(double calificacionCritica) {
        this.calificacionCritica = calificacionCritica;
    }

    public double getCalificacionAudiencia() {
        return calificacionAudiencia;
    }

    public void setCalificacionAudiencia(double calificacionAudiencia) {
        this.calificacionAudiencia = calificacionAudiencia;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    public String getCineSeleccionado() {
        return cineSeleccionado;
    }

    public void setCineSeleccionado(String cineSeleccionado) {
        this.cineSeleccionado = cineSeleccionado;
    }
}
