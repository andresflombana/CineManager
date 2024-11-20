<%-- 
    Document   : index
    Author's   : Lombana y Moreno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="lib/header.jsp" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>CineManager - Cines</title>
    <meta charset="UTF-8">
    <link href="styles/css/style.css" rel="stylesheet" type="text/css" />
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;700&display=swap" rel="stylesheet">
    <script src="styles/js/jquery-1.4.2.min.js" type="text/javascript"></script>
    <script src="styles/js/cufon-yui.js" type="text/javascript"></script>
    <script src="styles/js/cufon-replace.js" type="text/javascript"></script>
    <script src="styles/js/Gill_Sans_400.font.js" type="text/javascript"></script>
</head>
<body class="body2">
    <div class="main-wrapper2">
        <header class="header2">
            <div class="logo2">
                <a href="#">Cine<span>Manager</span></a>
            </div>
            <nav class="nav2">
                <ul class="nav-list2">
                    <li><a href="index.jsp">Inicio</a></li>
                    <li><a href="login.jsp">Login</a></li>
                    <li><a href="login.jsp">Registrar Users</a></li>
                    <li><a href="login.jsp">Registrar Pelis</a></li>
                    <li><a href="cines.jsp" class="active">Cines</a></li>
                    <li><a href="SvPeliculas?destino=peliculas">Películas</a></li>
                </ul>
            </nav>
        </header>

        <section class="hero2">
            <div class="hero-text2">
                <h2>Explora los mejores <span>Cines</span></h2>
                <p>Encuentra información detallada sobre las principales salas de cine.</p>
            </div>
        </section>

        <section class="content2">
            <h3>Salas de Cine en <span>Pasto</span></h3>
            <ul class="cinemas-list2">
                <li>
                    <div class="cinema-image2">
                        <img src="images/cinemark.png" alt="Cinepolis Pasto" />
                    </div>
                    <h4>Cinemark Pasto</h4>
                    <p><strong>Dirección:</strong> Cl. 11 #34 - 78, Pasto - Nariño.</p>
                    <p><strong>Contacto:</strong> 27220000</p>
                    <div class="cinema-map2">
                        <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3988.9180169586575!2d-77.2914640262831!3d1.2172048619904572!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x8e2ed37e500bc359%3A0x2ba55837fcdd0999!2sCinemark%20Unicentro%20Pasto!5e0!3m2!1ses!2sco!4v1725724057808!5m2!1ses!2sco" width="350" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
                    </div>
                </li>
                <li>
                    <div class="cinema-image2">
                        <img src="images/royalfilms.png" alt="Cine Colombia Pasto" />
                    </div>
                    <h4>Royal Films Único Pasto</h4>
                    <p><strong>Dirección:</strong> Cl. 22 # 6 - 61, Pasto - Nariño.</p>
                    <p><strong>Contacto:</strong> 27374032</p>
                    <div class="cinema-map2">
                        <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d63822.436357950006!2d-77.31682360777647!3d1.227802429761343!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x8e2ed4ebf51a3937%3A0x7a9fd3f1fd3944e1!2sRoyal%20Films!5e0!3m2!1ses!2sco!4v1725724017022!5m2!1ses!2sco" width="360" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
                    </div>
                </li>
                <li>
                    <div class="cinema-image2">
                        <img src="images/valledeatriz.jpg" alt="Cinemark Pasto" />
                    </div>
                    <h4>Cinemas Valle de Atriz</h4>
                    <p><strong>Dirección:</strong> Centro Comercial Valle De Atriz.</p>
                    <p><strong>Contacto:</strong> 27364393</p>
                    <div class="cinema-map2">
                        <iframe src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d15955.609727666906!2d-77.2859232!3d1.2276955!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x8e2ed4787ea3d7c5%3A0x76301d463dd23e25!2sCinemas%20Valle%20De%20Atriz!5e0!3m2!1ses!2sco!4v1725723882940!5m2!1ses!2sco" width="350" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
                    </div>
                </li>
            </ul>
        </section>
        <footer class="footer2">
            <p>EDD 1 - 2024 <a href="#">Andrés Lombana y Sebastián Moreno</a></p>
            <p>Design by <a href="http://www.templatemonster.com/">TemplateMonster</a></p>
        </footer>
    </div>
</body>
</html>