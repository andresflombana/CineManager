package Cinema;
/**
 *
 * @author's : Lombana y Moreno
 */
public class NodoCircular {
    private Pelicula pelicula;
    private NodoCircular siguiente;

    // Constructor
    public NodoCircular(Pelicula pelicula) {
        this.pelicula = pelicula;
        this.siguiente = null;
    }

    // Getters y Setters
    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public NodoCircular getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCircular siguiente) {
        this.siguiente = siguiente;
    }
}
