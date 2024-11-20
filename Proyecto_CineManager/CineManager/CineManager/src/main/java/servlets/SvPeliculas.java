package servlets;
/**
 *
 * @author's : Lombana y Moreno
 */
import Cinema.GestionP;
import Cinema.Pelicula;
import Cinema.PeliculasException;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(name = "SvPeliculas", urlPatterns = {"/SvPeliculas"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 10)
public class SvPeliculas extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private GestionP gestorP;
    private String uploadPath;

    @Override
    public void init() throws ServletException {
        super.init();
        uploadPath = getServletContext().getRealPath("") + File.separator + "portadas";
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        String archivoPeliculasPath = getServletContext().getRealPath("/data/peliculas.txt");
        try {
            gestorP = new GestionP(getServletContext(), archivoPeliculasPath);
            System.out.println("Películas cargadas correctamente.");
        } catch (PeliculasException e) {
            System.err.println("Error al inicializar GestionP: " + e.getMessage());
            throw new ServletException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String idPelicula = request.getParameter("idPelicula");

        try {
            if (action != null) {
                switch (action) {
                    case "delete":
                        if (idPelicula != null) {
                            int id = Integer.parseInt(idPelicula);
                            System.out.println("Eliminando película con ID: " + id);
                            gestorP.eliminarPelicula(id);
                        }
                        break;
                    case "edit":
                        if (idPelicula != null) {
                            int id = Integer.parseInt(idPelicula);
                            Pelicula pelicula = gestorP.buscarPelicula(id);
                            System.out.println("Editando película: " + pelicula.getTitulo());
                            request.setAttribute("pelicula", pelicula);
                        }
                        break;
                }
            }

            // Obtener la lista de películas
            List<Pelicula> peliculas = gestorP.listarPeliculas();
            System.out.println("Número de películas obtenidas: " + peliculas.size());
            request.setAttribute("peliculas", peliculas);

        } catch (PeliculasException e) {
            System.err.println("Error en la lógica de negocio: " + e.getMessage());
            request.setAttribute("error", "Error al procesar la solicitud: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error inesperado en doGet: " + e.getMessage());
            request.setAttribute("error", "Ocurrió un error inesperado: " + e.getMessage());
        }

        // Verificar el destino y redirigir a la página adecuada
        String destino = request.getParameter("destino");
        if ("peliculas".equals(destino)) {
            request.getRequestDispatcher("peliculas.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("registroPeliculas.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Ejecutando doPost en SvPeliculas...");

        try {
            // Obtener parámetros del formulario
            int idPelicula = Integer.parseInt(request.getParameter("idPelicula"));
            String titulo = request.getParameter("titulo");
            String sinopsis = request.getParameter("sinopsis");
            String director = request.getParameter("director");
            String fechaEstreno = request.getParameter("fechaEstreno");
            double calificacionCritica = Double.parseDouble(request.getParameter("calificacionCritica"));
            double calificacionAudiencia = Double.parseDouble(request.getParameter("calificacionAudiencia"));
            String cineSeleccionado = request.getParameter("cineSeleccionado");
            String portada = "portadas/default.png";

            // Manejar la carga de la portada
            Part imagenPart = request.getPart("portada");
            if (imagenPart != null && imagenPart.getSize() > 0) {
                String fileName = getFileName(imagenPart);
                imagenPart.write(uploadPath + File.separator + fileName);
                portada = "portadas/" + fileName;
                System.out.println("Portada guardada en: " + portada);
            }

            // Crear objeto Pelicula
            Pelicula pelicula = new Pelicula(idPelicula, titulo, sinopsis, director, fechaEstreno, calificacionCritica, calificacionAudiencia, portada, cineSeleccionado);
            System.out.println("Película creada: " + pelicula.getTitulo());

            String editar = request.getParameter("editar");
            if ("true".equals(editar)) {
                System.out.println("Editando película...");
                gestorP.editarPelicula(pelicula);
            } else {
                System.out.println("Invocando agregarPelicula en GestionP...");
                gestorP.agregarPelicula(pelicula);

                // Escribir reporte de la película
                gestorP.escribirReporteEnArchivo(pelicula, getServletContext());
                System.out.println("Reporte de película escrito.");
            }

        } catch (PeliculasException e) {
            System.err.println("Error en la lógica de negocio: " + e.getMessage());
            request.setAttribute("error", "Error al procesar la película: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
            request.setAttribute("error", "Ocurrió un error inesperado: " + e.getMessage());
        }

        System.out.println("Redirigiendo a lista de películas...");
        response.sendRedirect("SvPeliculas");
    }

    private String getFileName(Part part) {
        String contentDisposition = part.getHeader("content-disposition");
        for (String cd : contentDisposition.split(";")) {
            if (cd.trim().startsWith("filename")) {
                return cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
}
