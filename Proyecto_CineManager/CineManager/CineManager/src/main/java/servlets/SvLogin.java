package servlets;
/**
 *
 * @author's : Lombana y Moreno
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SvLogin", urlPatterns = {"/SvLogin"})
public class SvLogin extends HttpServlet {

    private String rutaArchivo;

    @Override
    public void init() throws ServletException {
        super.init();
        rutaArchivo = getServletContext().getRealPath("data/admins.txt");
    }
    
    
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Invalidar la sesión actual
        HttpSession contersession = request.getSession(false);
        if (contersession != null) {
            contersession.invalidate();
        }
        // Redirigir al login después de cerrar sesión
        response.sendRedirect("login.jsp");
    }


     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Obtener datos del formulario
        String correo = request.getParameter("correo");
        String password = request.getParameter("password");
        boolean usuarioExiste = false;

        // Obtener la sesión
        HttpSession contersession = request.getSession();
        
        // Comprobar si el usuario ya está logueado
        Boolean usuarioLogueado = (Boolean) contersession.getAttribute("usuario_logueado");
        if (usuarioLogueado != null && usuarioLogueado) {
            // Si ya está logueado, mostrar un mensaje y redirigir
            contersession.setAttribute("mensaje", "Ya estás en la sesión.");
            response.sendRedirect("login.jsp");
            return;
        }

        // Lectura del archivo para verificar si el usuario existe
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datosUsuario = linea.split(";");
                String correoExistente = datosUsuario[0];
                String passwordExistente = datosUsuario[1];

                // Verificar credenciales
                if (correoExistente.equals(correo) && passwordExistente.equals(password)) {
                    usuarioExiste = true;
                    break;
                }
            }
        }

        if (usuarioExiste) {
            // Guardar el usuario como logueado y mostrar mensaje
            contersession.setAttribute("usuario_logueado", true);
            contersession.setAttribute("mensaje", "Bienvenido administrador, " + correo);
            response.sendRedirect("login.jsp");
        } else {
            // Mensaje de error si las credenciales son incorrectas
            contersession.setAttribute("mensaje", "Acceso denegado. Credenciales incorrectas.");
            response.sendRedirect("login.jsp");
        }
}
}
