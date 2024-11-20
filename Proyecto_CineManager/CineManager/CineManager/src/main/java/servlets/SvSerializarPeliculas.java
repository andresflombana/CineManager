package servlets;
/**
 *
 * @author's : Lombana y Moreno
 */
import Cinema.CineManager;
import Cinema.GestionP;
import Cinema.PeliculasException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SvSerializarPeliculas")
public class SvSerializarPeliculas extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private GestionP gestionP;

    @Override
    public void init() throws ServletException {
        super.init();
        // Inicializar GestionP utilizando el archivo de películas
        String archivoPeliculasPath = getServletContext().getRealPath("/data/peliculas.txt");
        try {
            gestionP = new GestionP(getServletContext(), archivoPeliculasPath);
        } catch (PeliculasException ex) {
            Logger.getLogger(SvSerializarPeliculas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CineManager cineManager = new CineManager(gestionP);

        try {
            cineManager.serializarPeliculas();  // Llama al método de serialización
            // Notifica al usuario del éxito
            response.getWriter().write("<script>alert('Serialización correcta'); window.location='index.jsp';</script>");
        } catch (Exception e) {
            // Notifica al usuario en caso de error
            response.getWriter().write("<script>alert('Error al serializar: " + e.getMessage() + "'); window.location='index.jsp';</script>");
        }
    }
}