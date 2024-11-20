package Cinema;
/**
 *
 * @author's : Lombana y Moreno
 */
public class PeliculasException extends Exception {

    public static final String PELICULA_NO_ENCONTRADA = "No se encontró la película con el ID proporcionado.";
    public static final String LISTA_VACIA = "La lista de películas está vacía.";
    public static final String ERROR_ARCHIVO = "Error al procesar el archivo de películas.";
    public static final String FORMATO_INCORRECTO = "El formato del archivo de películas es incorrecto.";

    public PeliculasException(String mensaje) {
        super(mensaje);
    }

    public PeliculasException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
