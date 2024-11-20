package Cinema;
/**
 *
 * @author's : Lombana y Moreno
 */
public class GestionU {
    private Nodo cabeza;

    public GestionU() {
        cabeza = null;
    }

    // Agregar usuario al final de la lista
    public void agregarUsuario(Usuario usuario) {
        Nodo nuevoNodo = new Nodo(usuario);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo actual = cabeza;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo);
        }
    }

    // Método para Editar usuario
    public void editarUsuario(Usuario usuario) {
        Nodo temp = cabeza;
        // Iteramos sobre la lista de nodos para encontrar el usuario con la misma identificación
        while (temp != null) {
            if (temp.getUsuario().getNombre_Usurio().equals(usuario.getNombre_Usurio())) {
                temp.getUsuario().setNombre(usuario.getNombre());

                try {
                    temp.getUsuario().setTipo_Usuario(usuario.getTipo_Usuario());
                } catch (IllegalArgumentException e) {
                    System.out.println("Error al actualizar el tipo de usuario: " + e.getMessage());
                    return;
                }

                temp.getUsuario().setEmail(usuario.getEmail());
                temp.getUsuario().setID_Usuario(usuario.getID_Usuario());
                temp.getUsuario().setImagenPerfil(usuario.getImagenPerfil());
                return;
            }
            temp = temp.getSiguiente();
        }
    }
          
    // Método para eliminar por identificacion
    public void eliminarUsuario(String Nombre_Usurio) {
        if (cabeza == null) return ;

        if (cabeza.getUsuario().getNombre_Usurio().equals(Nombre_Usurio)) {
            cabeza = cabeza.getSiguiente();
        } else {
            Nodo temp = cabeza;
            while (temp.getSiguiente() != null && !temp.getSiguiente().getUsuario().getNombre_Usurio().equals(Nombre_Usurio)) {
                temp = temp.getSiguiente();
            }
            if (temp.getSiguiente() != null) {
                temp.setSiguiente(temp.getSiguiente().getSiguiente());
            }
        }
    }

    // Consultar  usuario por su identificación
    public Usuario obtenerUsuarioPorId(String Nombre_Usurio) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.getUsuario().getNombre_Usurio().equals(Nombre_Usurio)) {
                return actual.getUsuario();
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    // Obtener todos los usuarios en una lista enlazada
    public Nodo getListaUsuarios() {
        return cabeza;
    }
}
    

