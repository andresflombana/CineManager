<%-- 
    Document   : login
    Author's   : Lombana y Moreno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file = "/lib/header.jsp"%>
<%@ page import="javax.servlet.http.HttpSession" %>

<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>Cine Manager</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <link href="styles/css/style.css" rel="stylesheet" type="text/css" />
        <link href="styles/css/ie6.css" rel="stylesheet" type="text/css" />
        <script src="styles/js/jquery-1.4.2.min.js" type="text/javascript"></script>
        <script src="styles/js/cufon-yui.js" type="text/javascript"></script>
        <script src="styles/js/cufon-replace.js" type="text/javascript"></script>
        <script src="styles/js/Gill_Sans_400.font.js" type="text/javascript"></script>
        <script src="styles/js/script.js" type="text/javascript"></script>
    </head>


    <body id="page2">
        <div class="tail-top">
            <div class="tail-bottom">
                <div id="main">
                    <div id="header">
                        <div class="row-1">
                            <div class="fleft"><a href="#">Cine<span>Manager</span></a></div>
                        </div>
                        <div class="row-2">
                            <ul>
                                <li><a href="index.jsp">Inicio</a></li>
                                <li><a href="login.jsp" class="active">Login</a></li>
                                <li><a href="cines.jsp">Cines</a></li>
                                <li><a href="SvPeliculas?destino=peliculas" >Películas</a></li>
                            </ul>
                        </div>
                    </div>
                    <div id="content">
                        <div id="slogan">
                            <div class="container mt-2">

                                <%
                                    HttpSession contersession = request.getSession(false); // No crear nueva sesión si no existe
                                    if (contersession != null) {
                                        String mensaje = (String) contersession.getAttribute("mensaje");
                                        Boolean usuarioLogueado = (Boolean) contersession.getAttribute("usuario_logueado");

                                        if (mensaje != null) {
                                %>
                                <div class="alert alert-success">
                                    <%= mensaje%>
                                </div>
                                <%
                                    }

                                    // Mostrar el botón solo si el usuario está logueado
                                    if (usuarioLogueado != null && usuarioLogueado) {
                                %>
                                <button type="button" class="btn btn-outline-info" onclick="window.location.href = 'paginaDestino.jsp'">
                                    Ir a Registro de Usuarios
                                </button>
                                <button type="button" class="btn btn-outline-dark" onclick="window.location.href = 'registroPeliculas.jsp'">
                                    Ir a Registro de Peliculas
                                </button>                                <%
                                        }
                                        // Eliminar el mensaje después de mostrarlo
                                        contersession.removeAttribute("mensaje");
                                    }
                                %>

                                <%-- Formulario de inicio de sesión --%>
                                <div class="image png"></div>
                                <div class="inside">
                                    <form action="SvLogin" method="POST">
                                        <div class="form-group">
                                            <label for="exampleInputEmail1">Correo</label>
                                            <input type="email" class="form-control" name="correo" id="exampleInputEmail1" aria-describedby="emailHelp">
                                        </div>
                                        <div class="form-group">
                                            <label for="exampleInputPassword1">Contraseña</label>
                                            <input type="password" name="password" class="form-control" id="exampleInputPassword1">
                                        </div>
                                        <p></p>
                                        <a href="SvLogin" class="btn btn-danger">Cerrar sesión</a>
                                        <button type="submit" class="btn btn-success">Ingresar</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <footer class="footer1">
            <p>EDD 1 - 2024 <a href="#">Andrés Lombana y Sebastián Moreno</a></p>
            <p>Design by <a href="http://www.templatemonster.com/">TemplateMonster</a></p>
        </footer>    
    </body>
</html>