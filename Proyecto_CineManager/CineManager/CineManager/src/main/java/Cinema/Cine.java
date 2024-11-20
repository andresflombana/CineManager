package Cinema;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author's : Lombana y Moreno
 */
public class Cine {
    private String nombre;

    // Constructor
    public Cine(String nombre) {
        this.nombre = nombre;
    }

    // Getter
    public String getNombre() {
        return nombre;
    }

    // Método estático para obtener los cines predefinidos
    public static List<Cine> obtenerCines() {
        List<Cine> cines = new ArrayList<>();
        cines.add(new Cine("Cinemark Pasto"));
        cines.add(new Cine("Royal Films Único Pasto"));
        cines.add(new Cine("Cinemas Valle de Atriz"));
        System.out.println("Lista de cines: " + cines);
        return cines;
    }
}
