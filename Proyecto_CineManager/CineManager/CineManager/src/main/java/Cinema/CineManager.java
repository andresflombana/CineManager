package Cinema;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;
/**
 *
 * @author's : Lombana y Moreno
 */
public class CineManager {

    private GestionP gestionP;

    public CineManager(GestionP gestionP) {
        this.gestionP = gestionP;
    }

    // Método para serializar la lista de películas usando la lista real de GestionP
    public void serializarPeliculas() throws IOException, PeliculasException {
        String rutaRelativa = "data/peliculasSerializadas.data";
        File archivo = new File(rutaRelativa);

        // Obtener la lista de películas desde GestionP
        Object[] peliculas = gestionP.listarPeliculas().toArray();

        // Serializar el objeto de películas
        try (FileOutputStream fos = new FileOutputStream(archivo); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(peliculas);
        }

        // Confirmar la serialización en consola
        System.out.println("Películas serializadas en: " + archivo.getAbsolutePath());
    }

    // Método que llama a la serialización con manejo de errores
    public void Método1() {
        try {
            serializarPeliculas();
            JOptionPane.showMessageDialog(null, "Serialización correcta", "Respuesta", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al serializar: " + e.getMessage(), "Respuesta", JOptionPane.ERROR_MESSAGE);
        }
    }
}
