<%-- 
    Document   : paginaDestino (registroUsuarios)
    Author's   : Lombana y Moreno
--%>

<%@page import="Cinema.Usuario"%>
<%@page import="Cinema.Nodo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="lib/header.jsp" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>CineManager - Formulario Usuarios</title>
    <meta charset="UTF-8">
    <link href="styles/css/style.css" rel="stylesheet" type="text/css" />
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;700&display=swap" rel="stylesheet">
    <script src="styles/js/jquery-1.4.2.min.js" type="text/javascript"></script>
    <script src="styles/js/cufon-yui.js" type="text/javascript"></script>
    <script src="styles/js/cufon-replace.js" type="text/javascript"></script>
    <script src="styles/js/Gill_Sans_400.font.js" type="text/javascript"></script>
</head>
    
    <body class="body1">
    <div class="main-wrapper1">
        <header class="header1">
            <div class="logo1">
                <a href="#">Register a <span>New User</span></a>
            </div>
            <nav class="nav1">
                <ul class="nav-list1">
                    <li><a href="index.jsp">Inicio</a></li>
                    <li><a href="login.jsp">Login</a></li>
                    <li><a href="registroPeliculas.jsp">Registrar Pelis</a></li>
                    <li><a href="cines.jsp">Cines</a></li>
                    <li><a href="SvPeliculas?destino=peliculas">Películas</a></li>
                </ul>
            </nav>
        </header>
        
         <section class="content1">
            <h1 class="mt-4">Gestión de Usuarios</h1>
            <form method="post" action="SvUsuario" enctype="multipart/form-data" class="user-form">
                <div class="form-row">
                    <div class="col-md-6 mb-3">
                        <label for="Nombre_Usurio">Nombre de Usuario</label>
                        <input type="text" class="form-control" name="Nombre_Usurio" required>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="nombre">Nombre Completo</label>
                        <input type="text" class="form-control" name="nombre" required>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="Tipo_Usuario">Tipo de Usuario</label>
                        <select class="form-control" name="Tipo_Usuario" id="Tipo_Usuario" required>
                            <option value="" disabled selected>Seleccione un tipo de usuario</option>
                            <option value="administrador">Administrador</option>
                            <option value="cliente">Cliente</option>
                        </select>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="ID_Usuario">ID Usuario</label>
                        <input type="number" class="form-control" name="ID_Usuario" required>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="Email">Email</label>
                        <input type="email" class="form-control" name="Email" required>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="imagenPerfil">Imagen de Perfil (.png)</label>
                        <input type="file" class="form-control" name="imagenPerfil" required>
                    </div>
                </div>
                <button class="btn btn-primary" type="submit">Añadir Usuario</button>
            </form>

            <hr />

            <h2>Lista de Usuarios</h2>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Nombre de Usuario</th>
                        <th>Nombre Completo</th>
                        <th>Tipo de Usuario</th>
                        <th>ID Usuario</th>
                        <th>Email</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <% 
                    Nodo nodoActual = (Nodo) request.getAttribute("usuarios");
                    while (nodoActual != null) {
                        Usuario usuario = nodoActual.getUsuario();
                    %>
                        <tr>
                            <td><%= usuario.getNombre_Usurio() %></td>
                            <td><%= usuario.getNombre() %></td>
                            <td><%= usuario.getTipo_Usuario() %></td>                         
                            <td><%= usuario.getID_Usuario() %></td>
                            <td><%= usuario.getEmail()%></td>
                            <td>
                                <button type="button" class="btn btn-warning btn-sm" data-bs-toggle="modal" data-bs-target="#modalEdit<%= usuario.getNombre_Usurio()%>">Editar</button>
                                <a href="SvUsuario?action=delete&id=<%= usuario.getNombre_Usurio()%>" class="btn btn-danger btn-sm">Eliminar</a>
                            </td>

                        </tr>

                        <!-- Modal para editar usuario -->
                        <div class="modal fade" id="modalEdit<%= usuario.getNombre_Usurio() %>" tabindex="-1" aria-labelledby="modalLabel<%= usuario.getNombre_Usurio() %>" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="modalLabel<%= usuario.getNombre_Usurio() %>">Editar Usuario</h5>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                    </div>
                                    <form method="post" action="SvUsuario" enctype="multipart/form-data">
                                        <div class="modal-body">
                                            <input type="hidden" name="Nombre_Usurio" value="<%= usuario.getNombre_Usurio() %>">
                                            <input type="hidden" name="editar" value="true">
                                            <div class="mb-3">
                                                <label for="nombre<%= usuario.getNombre_Usurio() %>" class="form-label">Nombre</label>
                                                <input type="text" class="form-control" name="nombre" value="<%= usuario.getNombre() %>" required>
                                            </div>
                                            <div class="mb-3">
                                                <label for="Tipo_Usuario<%= usuario.getNombre_Usurio()%>" class="form-label">Tipo de Usuario</label>
                                                <select class="form-control" name="Tipo_Usuario" id="Tipo_Usuario<%= usuario.getNombre_Usurio()%>" required>
                                                    <option value="" disabled selected>Seleccione un tipo de usuario</option>
                                                    <option value="administrador" <%= "administrador".equals(usuario.getTipo_Usuario()) ? "selected" : ""%>>Administrador</option>
                                                    <option value="cliente" <%= "cliente".equals(usuario.getTipo_Usuario()) ? "selected" : ""%>>Cliente</option>
                                                </select>
                                            </div>
                                            <div class="mb-3">
                                                <label for="ID_Usuario<%= usuario.getNombre_Usurio()%>" class="form-label">ID_Usuario</label>
                                                <input type="number" class="form-control" name="ID_Usuario" value="<%= usuario.getID_Usuario() %>" required>
                                            </div>
                                            <div class="mb-3">
                                                <label for="Email<%= usuario.getNombre_Usurio() %>" class="form-label">Email</label>
                                                <input type="email" class="form-control" name="Email" value="<%= usuario.getEmail() %>" required>
                                            </div>
                                            <div class="mb-3">
                                                <label for="imagenPerfil<%= usuario.getNombre_Usurio() %>" class="form-label">Imagen de Perfil (.png)</label>
                                                <input type="file" class="form-control" name="imagenPerfil">
                                                <img src="<%= usuario.getImagenPerfil() %>" alt="Perfil" width="100" class="mt-2">
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                                            <button type="submit" class="btn btn-primary">Guardar Cambios</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    <% 
                        nodoActual = nodoActual.getSiguiente();
                    } %>
                </tbody>
            </table>
        </section>
        <footer class="footer1">
            <p>EDD 1 - 2024 <a href="#">Andrés Lombana y Sebastián Moreno</a></p>
            <p>Design by <a href="http://www.templatemonster.com/">TemplateMonster</a></p>
        </footer> 
    </div>
    </body>
</html>