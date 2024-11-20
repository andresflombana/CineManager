package Cinema;
/**
 *
 * @author's : Lombana y Moreno
 */
public class Usuario {
    
    private String Nombre_Usurio;
    private String nombre;
    private int ID_Usuario;
    private String Tipo_Usuario;
    private String Email;
    private String imagenPerfil;

    public Usuario() {
    }

    public Usuario(String Nombre_Usurio, String nombre, int ID_Usuario, String Tipo_Usuario, String Email, String imagenPerfil) {
        this.Nombre_Usurio = Nombre_Usurio;
        this.nombre = nombre;
        this.ID_Usuario = ID_Usuario;
        this.Tipo_Usuario = Tipo_Usuario;
        this.Email = Email;
        this.imagenPerfil = imagenPerfil;
    }

    public String getNombre_Usurio() {
        return Nombre_Usurio;
    }

    public void setNombre_Usurio(String Nombre_Usurio) {
        this.Nombre_Usurio = Nombre_Usurio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getID_Usuario() {
        return ID_Usuario;
    }

    public void setID_Usuario(int ID_Usuario) {
        this.ID_Usuario = ID_Usuario;
    }

    public String getTipo_Usuario() {
        return Tipo_Usuario;
    }

    public void setTipo_Usuario(String Tipo_Usuario) {
        // Validar que el tipo de usuario sea "administrador" o "cliente"
        if ("administrador".equals(Tipo_Usuario) || "cliente".equals(Tipo_Usuario)) {
            this.Tipo_Usuario = Tipo_Usuario;
        } else {
            throw new IllegalArgumentException("Tipo de usuario no válido. Debe ser 'administrador' o 'cliente'.");
        }
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getImagenPerfil() {
        return imagenPerfil;
    }

    public void setImagenPerfil(String imagenPerfil) {
        this.imagenPerfil = imagenPerfil;
    }
}