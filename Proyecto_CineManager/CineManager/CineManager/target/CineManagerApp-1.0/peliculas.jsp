<%-- 
    Document   : peliculas
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
        <title>CineManager - Películas</title>
        <meta charset="UTF-8">
        <link href="styles/css/style.css" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;700&display=swap" rel="stylesheet">
        <script src="styles/js/jquery-1.4.2.min.js" type="text/javascript"></script>
    </head>
    <body class="body1">
        <div class="main-wrapper1">
            <header class="header1">
                <div class="logo1">
                    <a href="#">Cine<span>Películas</span></a>
                </div>
                <nav class="nav1">
                    <ul class="nav-list1">
                        <li><a href="index.jsp">Inicio</a></li>
                        <li><a href="login.jsp">Login</a></li>
                        <li><a href="login.jsp">Registrar Users</a></li>
                        <li><a href="login.jsp">Registrar Pelis</a></li>
                        <li><a href="cines.jsp">Cines</a></li>
                        <li><a href="SvPeliculas?destino=peliculas" class="active">Películas</a></li>
                    </ul>
                </nav>
            </header>

            <section class="hero1">
                <div class="hero-text1">
                    <h2>Esto es cine<span>Sobre películas.</span></h2>
                    <p>Las películas más esperadas, nuevas y emocionantes.</p>
                </div>
            </section>

            <p></p>
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
                            <strong>Sinopsis:</strong>
                            <p><%= pelicula.getSinopsis() %></p>
                            <p><strong>Director:</strong> <%= pelicula.getDirector() %></p>
                            <p><strong>Fecha Estreno:</strong> <%= pelicula.getFechaEstreno() %></p>
                            <p class="rating">Calificación de la Crítica: <%= pelicula.getCalificacionCritica() %>/10</p>
                            <p class="rating">Calificación de la Audiencia: <%= pelicula.getCalificacionAudiencia() %>/10</p>
                            <strong>¿En qué cines la encuentras?</strong>
                            <p><%= pelicula.getCineSeleccionado() %></p>
                        </div>
                    </div>
                    <%
                            }
                        } else { 
                    %>
                    <div class="text-center" style="width: 100%;">No hay películas registradas.</div>
                    <%
                        }
                    %>
                </div>
            <footer class="footer1">
                <p>EDD 1 - 2024 <a href="#">Andrés Lombana y Sebastián Moreno</a></p>
                <p>Design by <a href="http://www.templatemonster.com/">TemplateMonster</a></p>
            </footer>
        </div>
    </body>
</html>