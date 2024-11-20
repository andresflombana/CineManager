package servlets;
/**
 *
 * @author's : Lombana y Moreno
 */
import Cinema.GestionU;
import Cinema.Usuario;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(name = "SvUsuario", urlPatterns = {"/SvUsuario"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 10)
public class SvUsuario extends HttpServlet {
private static final long serialVersionUID = 1L;
private GestionU gestorU = new GestionU();
 private String uploadPath;
    private String rutaUsuarios;
    private String rutaAdmins;

    @Override
    public void init() throws ServletException {
        super.init();
         uploadPath = getServletContext().getRealPath("") + File.separator + "imagenes";
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) uploadDir.mkdir();
        rutaUsuarios = getServletContext().getRealPath("data/usuarios.txt");
        rutaAdmins = getServletContext().getRealPath("data/admins.txt");
    }
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String id = request.getParameter("id");

        if (action != null && action.equals("delete") && id != null) {
            gestorU.eliminarUsuario(id);
        }

        request.setAttribute("usuarios", gestorU.getListaUsuarios());
        request.getRequestDispatcher("paginaDestino.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Obtener datos del formulario de registro
        String correo = request.getParameter("correo");
        String password = request.getParameter("password");
        boolean usuarioExiste = false;
        boolean esAdmin = false;

        // Verificar si el correo ya existe en el archivo de usuarios
        try (BufferedReader brUsuarios = new BufferedReader(new FileReader(rutaUsuarios))) {
            String linea;
            while ((linea = brUsuarios.readLine()) != null) {
                String[] datosUsuario = linea.split(";");
                String correoExistente = datosUsuario[0];

                if (correoExistente.equals(correo)) {
                    usuarioExiste = true;
                    break;
                }
            }
        }

        // Verificar si el correo existe en el archivo de admins
        try (BufferedReader brAdmins = new BufferedReader(new FileReader(rutaAdmins))) {
            String linea;
            while ((linea = brAdmins.readLine()) != null) {
                String[] datosAdmin = linea.split(";");
                String correoAdmin = datosAdmin[0];

                if (correoAdmin.equals(correo)) {
                    esAdmin = true;
                    break;
                }
            }
        }

        // Configuración del response para enviar mensajes al usuario
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (usuarioExiste) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('El usuario ya está registrado');");
            out.println("location='registro.jsp';");  // Redirige a la página de registro
            out.println("</script>");
        } else if (esAdmin) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('El correo pertenece a un administrador y no puede registrarse como usuario');");
            out.println("location='registro.jsp';");
            out.println("</script>");
        } else {
            // Si no existe, registrar el nuevo usuario
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaUsuarios, true))) {
                bw.write(correo + ";" + password);
                bw.newLine();
            }

            out.println("<script type=\"text/javascript\">");
            out.println("alert('Registro exitoso');");
            out.println("location='login.jsp';");  // Redirige a la página de login
            out.println("</script>");
        }
        
        String Nombre_Usurio = request.getParameter("Nombre_Usurio");
        String nombre = request.getParameter("nombre");
        int ID_Usuario = Integer.parseInt(request.getParameter("ID_Usuario"));
        String Tipo_Usuario = request.getParameter("Tipo_Usuario");
        // Verificar si el Tipo_Usuario es válido
        if (!Tipo_Usuario.equals("administrador") && !Tipo_Usuario.equals("cliente")) {
            // Si no es válido, mostrar un mensaje de error
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Tipo de usuario no válido');");
            out.println("location='paginaDestino.jsp';");  // Redirige a la página de registro
            out.println("</script>");
            return;
        }
        String Email = request.getParameter("Email");
        String imagenPerfil = "imagenes/perfilxDefecto.png";

        Part imagenPart = request.getPart("imagenPerfil");
        if (imagenPart != null && imagenPart.getSize() > 0) {
            String fileName = getFileName(imagenPart);
            imagenPart.write(uploadPath + File.separator + fileName);
            imagenPerfil = "imagenes/" + fileName;
        }

        Usuario usuario = new Usuario(Nombre_Usurio, nombre, ID_Usuario, Tipo_Usuario, Email, imagenPerfil);
        String editar = request.getParameter("editar");

        if (editar != null && editar.equals("true")) {
            gestorU.editarUsuario(usuario);
        } else {
            gestorU.agregarUsuario(usuario);
        }

        request.setAttribute("usuarios", gestorU.getListaUsuarios());
        request.getRequestDispatcher("paginaDestino.jsp").forward(request, response);
        
        
    }
     private String getFileName(Part part) {
        String contentDisposition = part.getHeader("content-disposition");
        for (String cd : contentDisposition.split(";")) {
            if (cd.trim().startsWith("nombreArchivo")) {
                return cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
}
