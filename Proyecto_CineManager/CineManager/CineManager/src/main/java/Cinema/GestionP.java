package Cinema;

import java.io.BufferedReader;
import javax.servlet.ServletContext;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author's : Lombana y Moreno
 */
public class GestionP {

    private class NodoDoble {

        private Pelicula pelicula;
        private NodoDoble siguiente;
        private NodoDoble anterior;

        public NodoDoble(Pelicula pelicula) {
            this.pelicula = pelicula;
            this.siguiente = null;
            this.anterior = null;
        }

        public Pelicula getPelicula() {
            return pelicula;
        }

        public NodoDoble getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(NodoDoble siguiente) {
            this.siguiente = siguiente;
        }
    }

    private NodoDoble cabeza;
    private NodoDoble cola;
    private final String archivoPeliculas;
    private final ServletContext servletContext;

    // Instancia de la lista circular de reportes
    private ListaCircularReportes listaReportes;

    public GestionP(ServletContext servletContext, String rutaArchivo) throws PeliculasException {
        this.cabeza = null;
        this.cola = null;
        this.archivoPeliculas = rutaArchivo;
        this.servletContext = servletContext;
        cargarPeliculas();
        this.listaReportes = new ListaCircularReportes();
    }

    // Método para agregar una película
    public void agregarPelicula(Pelicula pelicula) throws PeliculasException {
        try {
            NodoDoble nuevoNodo = new NodoDoble(pelicula);
            if (cabeza == null) {
                cabeza = nuevoNodo;
                cola = nuevoNodo;
            } else {
                cola.setSiguiente(nuevoNodo);
                nuevoNodo.anterior = cola;
                cola = nuevoNodo;
            }
            guardarPeliculas();
        } catch (IOException e) {
            throw new PeliculasException(PeliculasException.ERROR_ARCHIVO, e);
        }
    }


    // Método para eliminar una película por ID
    public boolean eliminarPelicula(int idPelicula) throws PeliculasException, IOException {
        NodoDoble actual = cabeza;

        while (actual != null) {
            if (actual.getPelicula().getIdPelicula() == idPelicula) {
                if (actual.anterior != null) {
                    actual.anterior.setSiguiente(actual.getSiguiente());
                } else {
                    cabeza = actual.getSiguiente();
                }
                if (actual.getSiguiente() != null) {
                    actual.getSiguiente().anterior = actual.anterior;
                } else {
                    cola = actual.anterior;
                }
                guardarPeliculas();
                return true;
            }
            actual = actual.getSiguiente();
        }
        throw new PeliculasException(PeliculasException.PELICULA_NO_ENCONTRADA);
    }

    // Método para editar una película por ID
    public boolean editarPelicula(Pelicula peliculaModificada) throws IOException {
        NodoDoble actual = cabeza;

        while (actual != null) {
            if (actual.getPelicula().getIdPelicula() == peliculaModificada.getIdPelicula()) {
                actual.getPelicula().setTitulo(peliculaModificada.getTitulo());
                actual.getPelicula().setSinopsis(peliculaModificada.getSinopsis());
                actual.getPelicula().setDirector(peliculaModificada.getDirector());
                actual.getPelicula().setFechaEstreno(peliculaModificada.getFechaEstreno());
                actual.getPelicula().setCalificacionCritica(peliculaModificada.getCalificacionCritica());
                actual.getPelicula().setCalificacionAudiencia(peliculaModificada.getCalificacionAudiencia());
                actual.getPelicula().setPortada(peliculaModificada.getPortada());
                actual.getPelicula().setCineSeleccionado(peliculaModificada.getCineSeleccionado());
                guardarPeliculas();
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    // Método para buscar una película por ID
    public Pelicula buscarPelicula(int idPelicula) throws PeliculasException {
        NodoDoble actual = cabeza;

        while (actual != null) {
            if (actual.getPelicula().getIdPelicula() == idPelicula) {
                return actual.getPelicula();
            }
            actual = actual.getSiguiente();
        }
        throw new PeliculasException(PeliculasException.PELICULA_NO_ENCONTRADA);
    }

    // Método para listar todas las películas
    public List<Pelicula> listarPeliculas() throws PeliculasException {
        if (cabeza == null) {
            throw new PeliculasException(PeliculasException.LISTA_VACIA);
        }
        
        List<Pelicula> peliculas = new ArrayList<>();
        NodoDoble actual = cabeza;

        while (actual != null) {
            peliculas.add(actual.getPelicula());
            actual = actual.getSiguiente();
        }

        System.out.println("Películas encontradas: " + peliculas.size());
        return peliculas;
    }

    // Método para verificar si la lista está vacía
    public boolean estaVacia() {
        return cabeza == null;
    }

    // Método para guardar todas las películas en un archivo
    private void guardarPeliculas() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoPeliculas))) {
            NodoDoble actual = cabeza;
            while (actual != null) {
                writer.write(peliculaToTXT(actual.getPelicula()));
                writer.newLine();
                actual = actual.getSiguiente();
            }
        }
    }
    
    // Método para cargar todas las películas desde un archivo
    private void cargarPeliculas() throws PeliculasException {
        File file = new File(archivoPeliculas);
        if (!file.exists()) {
            System.out.println("El archivo no existe: " + archivoPeliculas);
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Pelicula pelicula = txtToPelicula(line);
                if (pelicula != null) {
                    NodoDoble nuevoNodo = new NodoDoble(pelicula);
                    if (cabeza == null) {
                        cabeza = nuevoNodo;
                        cola = nuevoNodo;
                    } else {
                        cola.setSiguiente(nuevoNodo);
                        nuevoNodo.anterior = cola;
                        cola = nuevoNodo;
                    }
                }
            }
        } catch (IOException e) {
            throw new PeliculasException(PeliculasException.ERROR_ARCHIVO, e);
        }
    }

    // Convertir objeto Pelicula a formato TXT
    private String peliculaToTXT(Pelicula pelicula) {
        return pelicula.getIdPelicula() + ";" + pelicula.getTitulo() + ";" + pelicula.getSinopsis() + ";"
                + pelicula.getDirector() + ";" + pelicula.getFechaEstreno() + ";"
                + pelicula.getCalificacionCritica() + ";" + pelicula.getCalificacionAudiencia() + ";"
                + pelicula.getPortada() + ";" + pelicula.getCineSeleccionado();
    }

    // Convertir línea TXT a objeto Pelicula
    private Pelicula txtToPelicula(String line) throws PeliculasException {
        try {
            String[] fields = line.split(";");
            if (fields.length != 9) {
                throw new PeliculasException(PeliculasException.FORMATO_INCORRECTO);
            }
            return new Pelicula(
                    Integer.parseInt(fields[0]),
                    fields[1],
                    fields[2],
                    fields[3],
                    fields[4],
                    Double.parseDouble(fields[5]),
                    Double.parseDouble(fields[6]),
                    fields[7],
                    fields[8]
            );
        } catch (Exception e) {
            System.err.println("Error al procesar línea: " + line + " - " + e.getMessage());
            return null;
        }
    }

    // Método para escribir el reporte en el archivo
    public void escribirReporteEnArchivo(Pelicula pelicula, ServletContext context) throws IOException {
        String rutaRelativa = "/data/reportePeliculas.txt";
        File archivo = new File(context.getRealPath(rutaRelativa));

        System.out.println("Ruta del archivo: " + archivo.getAbsolutePath());

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true))) {
            writer.write("ID: " + pelicula.getIdPelicula() + ", ");
            writer.write("Título: " + pelicula.getTitulo() + ", ");
            writer.write("Director: " + pelicula.getDirector() + ", ");
            writer.write("Fecha de Estreno: " + pelicula.getFechaEstreno());
            writer.newLine();
            System.out.println("Escritura completada para: " + pelicula.getTitulo());
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
            throw e;
        }
    }
}
