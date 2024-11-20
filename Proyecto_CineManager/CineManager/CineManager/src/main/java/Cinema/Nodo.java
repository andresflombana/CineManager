package Cinema;
/**
 *
 * @author's : Lombana y Moreno
 */
public class Nodo {
    private Usuario usuario;
    private Nodo siguiente;

    //Se inicializa nodo
    public Nodo(Usuario usuario) {
        this.usuario = usuario;
        this.siguiente = null; // inicializa puntero
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}
