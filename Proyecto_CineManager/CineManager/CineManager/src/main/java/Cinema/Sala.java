package Cinema;

import java.util.ArrayList;
/**
 *
 * @author's : Lombana y Moreno
 */
public class Sala {
    private int ID_Sala;
    private int Numero_Sala;
    private int ID_Cine;
    private ArrayList<Pelicula> peliculas;

    public Sala() {
    }

    public Sala(int ID_Sala, int Numero_Sala, int ID_Cine) {
        this.ID_Sala = ID_Sala;
        this.Numero_Sala = Numero_Sala;
        this.ID_Cine = ID_Cine;
    }

    public int getID_Sala() {
        return ID_Sala;
    }

    public void setID_Sala(int ID_Sala) {
        this.ID_Sala = ID_Sala;
    }

    public int getNumero_Sala() {
        return Numero_Sala;
    }

    public void setNumero_Sala(int Numero_Sala) {
        this.Numero_Sala = Numero_Sala;
    }

    public int getID_Cine() {
        return ID_Cine;
    }

    public void setID_Cine(int ID_Cine) {
        this.ID_Cine = ID_Cine;
    }

    
}
