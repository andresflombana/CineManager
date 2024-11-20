package Cinema;
/**
 *
 * @author's : Lombana y Moreno
 */
public class NodoDoble {
    private Pelicula pelicula;
    private NodoDoble siguiente;  // Apunta al siguiente nodo
    private NodoDoble anterior;   // Apunta al nodo anterior

    // Constructor
    public NodoDoble(Pelicula pelicula) {
        this.pelicula = pelicula;
        this.siguiente = null;  // Inicializa como null
        this.anterior = null;   // Inicializa como null
    }

    // Getters y setters
    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public NodoDoble getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoDoble siguiente) {
        this.siguiente = siguiente;
    }

    public NodoDoble getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoDoble anterior) {
        this.anterior = anterior;
    }
}

