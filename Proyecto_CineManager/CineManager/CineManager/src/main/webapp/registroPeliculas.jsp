<%-- 
    Document   : registroPeliculas
    Author's   : Lombana y Moreno
--%>

<%@page import="java.util.List"%>
<%@page import="Cinema.GestionP"%>
<%@page import="Cinema.Pelicula"%>
<%@page import="Cinema.NodoDoble"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="lib/header.jsp" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>CineManager - Formulario Películas</title>
    <meta charset="UTF-8">
    <link href="styles/css/style.css" rel="stylesheet" type="text/css" />
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;700&display=swap" rel="stylesheet">
    <script src="styles/js/jquery-1.4.2.min.js" type="text/javascript"></script>
</head>
    
<body class="body1">
    <div class="main-wrapper1">
        <header class="header1">
            <div class="logo1">
                <a href="#">Register a <span>New Film</span></a>
            </div>
            <nav class="nav1">
                <ul class="nav-list1">
                    <li><a href="index.jsp">Inicio</a></li>
                    <li><a href="login.jsp">Login</a></li>
                    <li><a href="paginaDestino.jsp">Registrar Users</a></li>
                    <li><a href="cines.jsp">Cines</a></li>
                    <li><a href="SvPeliculas?destino=peliculas">Películas</a></li>
                </ul>
            </nav>
        </header>
        
        <section class="content1">
            <h1 class="mt-4">Gestión de Películas</h1>
            <%-- Mostrar mensajes de error o éxito --%>
            <% 
                String error = (String) request.getAttribute("error");
                String mensaje = (String) request.getAttribute("mensaje");
                if (error != null) { 
            %>
                <div class="alert alert-danger"><%= error %></div>
            <% 
                } else if (mensaje != null) { 
            %>
                <div class="alert alert-success"><%= mensaje %></div>
            <% } %>            
            <form method="post" action="SvPeliculas" enctype="multipart/form-data" class="movie-form">
                <!-- Formulario de registro de película -->
                <div class="form-row">
                    <div class="col-md-6 mb-3">
                        <label for="idPelicula">ID Película</label>
                        <input type="number" class="form-control" name="idPelicula" required>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="titulo">Título</label>
                        <input type="text" class="form-control" name="titulo" >
                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="sinopsis">Sinopsis</label>
                        <textarea class="form-control" name="sinopsis" required></textarea>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="director">Director</label>
                        <input type="text" class="form-control" name="director" required>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="fechaEstreno">Fecha de Estreno</label>
                        <input type="date" class="form-control" name="fechaEstreno" required>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="calificacionCritica">Calificación Crítica (0-10)</label>
                        <input type="number" step="0.1" class="form-control" name="calificacionCritica" min="0" max="10" required>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="calificacionAudiencia">Calificación Audiencia (0-10)</label>
                        <input type="number" step="0.1" class="form-control" name="calificacionAudiencia" min="0" max="10" required>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="cineSeleccionado">Cine</label>
                        <input type="text" class="form-control" name="cineSeleccionado" required>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="portada">Portada</label>
                        <input type="file" class="form-control" name="portada" accept="image/*">
                    </div>
                </div>
                <input type="hidden" name="editar" value="false">
                    <button class="btn btn-success" type="submit">Registrar Película</button>
            </form>

            <hr />

            <h2>Lista de Películas</h2>
            <div class="d-flex flex-wrap justify-content-between">
                <%
                    List<Pelicula> peliculas = (List<Pelicula>) request.getAttribute("peliculas");
                    if (peliculas != null && !peliculas.isEmpty()) {
                        for (Pelicula pelicula : peliculas) {
                %>
                <div class="movie-card">
                    <img src="<%= pelicula.getPortada() %>" alt="<%= pelicula.getTitulo() %>">
                    <div class="movie-info">
                        <h4><%= pelicula.getTitulo() %></h4>
                        <p><%= pelicula.getSinopsis() %></p>
                        <p><strong>Director:</strong> <%= pelicula.getDirector() %></p>
                        <p><strong>Fecha Estreno:</strong> <%= pelicula.getFechaEstreno() %></p>
                        <p class="rating">Calificación Crítica: <%= pelicula.getCalificacionCritica() %>/10</p>
                        <p class="rating">Calificación Audiencia: <%= pelicula.getCalificacionAudiencia() %>/10</p>
                        <div>
                            <button type="button" class="btn btn-warning btn-sm" data-bs-toggle="modal" data-bs-target="#modalEdit<%= pelicula.getIdPelicula() %>">Editar</button>
                            <a href="SvPeliculas?action=delete&idPelicula=<%= pelicula.getIdPelicula() %>" class="btn btn-danger btn-sm">Eliminar</a>
                        </div>
                    </div>
                </div>

                <!-- Modal para editar película -->
                <div class="modal fade" id="modalEdit<%= pelicula.getIdPelicula()%>" tabindex="-1" role="dialog" aria-labelledby="modalEditLabel<%= pelicula.getIdPelicula()%>" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="modalEditLabel<%= pelicula.getIdPelicula()%>">Editar Película</h5>
                            </div>
                            <form method="post" action="SvPeliculas" enctype="multipart/form-data">
                                <div class="modal-body">
                                    <input type="hidden" name="idPelicula" value="<%= pelicula.getIdPelicula()%>">
                                        <div class="form-group">
                                            <label for="titulo">Título</label>
                                        <input type="text" class="form-control" name="titulo" value="<%= pelicula.getTitulo() %>" required>
                                    </div>
                                    <div class="form-group">
                                        <label for="sinopsis">Sinopsis</label>
                                        <textarea class="form-control" name="sinopsis" required><%= pelicula.getSinopsis() %></textarea>
                                    </div>
                                    <div class="form-group">
                                        <label for="director">Director</label>
                                        <input type="text" class="form-control" name="director" value="<%= pelicula.getDirector() %>" required>
                                    </div>
                                    <div class="form-group">
                                        <label for="fechaEstreno">Fecha de Estreno</label>
                                        <input type="date" class="form-control" name="fechaEstreno" value="<%= pelicula.getFechaEstreno() %>" required>
                                    </div>
                                    <div class="form-group">
                                        <label for="calificacionCritica">Calificación Crítica (0-10)</label>
                                        <input type="number" step="0.1" class="form-control" name="calificacionCritica" min="0" max="10" value="<%= pelicula.getCalificacionCritica() %>" required>
                                    </div>
                                    <div class="form-group">
                                        <label for="calificacionAudiencia">Calificación Audiencia (0-10)</label>
                                        <input type="number" step="0.1" class="form-control" name="calificacionAudiencia" min="0" max="10" value="<%= pelicula.getCalificacionAudiencia() %>" required>
                                    </div>
                                    <div class="form-group">
                                        <label for="cineSeleccionado">Cine</label>
                                        <input type="text" class="form-control" name="cineSeleccionado" value="<%= pelicula.getCineSeleccionado() %>" required>
                                    </div>
                                    <div class="form-group">
                                        <label for="portada">Portada</label>
                                        <input type="file" class="form-control" name="portada" accept="image/*" required>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                                    <button type="submit" class="btn btn-primary">Guardar Cambios</button>
                                </div>
                                <input type="hidden" name="editar" value="true">
                            </form>
                        </div>
                    </div>
                </div>
                <%
                        }
                    } else { 
                %>
                <div class="text-center" style="width: 100%;">Para gestionar tus películas, por favor agrega una.</div>
                <%
                    }
                %>
            </div>
            <footer class="footer1">
                <p>EDD 1 - 2024 <a href="#">Andrés Lombana y Sebastián Moreno</a></p>
                <p>Design by <a href="http://www.templatemonster.com/">TemplateMonster</a></p>
            </footer>
        </section>
    </div>
</body>
</html>