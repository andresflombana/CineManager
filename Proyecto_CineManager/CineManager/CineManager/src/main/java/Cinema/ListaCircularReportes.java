package Cinema;
/**
 *
 * @author's : Lombana y Moreno
 */
public class ListaCircularReportes {
    private NodoCircular cabeza;
    private NodoCircular ultimo;

    // Constructor
    public ListaCircularReportes() {
        cabeza = null;
        ultimo = null;
    }

    // Método para agregar una película al reporte
    public void agregarReporte(Pelicula pelicula) {
        NodoCircular nuevoNodo = new NodoCircular(pelicula);
        if (cabeza == null) {
            // Si la lista está vacía, el nodo se apunta a sí mismo
            cabeza = nuevoNodo;
            ultimo = nuevoNodo;
            ultimo.setSiguiente(cabeza);
        } else {
            // Inserta al final y apunta al primero
            ultimo.setSiguiente(nuevoNodo);
            ultimo = nuevoNodo;
            ultimo.setSiguiente(cabeza);
        }
    }

    // Método para mostrar el reporte (recorrido completo)
    public void mostrarReportes() {
        if (cabeza == null) {
            System.out.println("No hay reportes disponibles.");
            return;
        }

        NodoCircular actual = cabeza;
        do {
            Pelicula p = actual.getPelicula();
            System.out.println("ID: " + p.getIdPelicula());
            System.out.println("Título: " + p.getTitulo());
            System.out.println("Director: " + p.getDirector());
            System.out.println("Fecha de Estreno: " + p.getFechaEstreno());
            System.out.println("-----------------------------------");
            actual = actual.getSiguiente();
        } while (actual != cabeza);
    }

    // Método para verificar si la lista está vacía
    public boolean estaVacia() {
        return cabeza == null;
    }
}
