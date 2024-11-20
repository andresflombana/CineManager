<%-- 
    Document   : index
    Author's   : Lombana y Moreno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="lib/header.jsp" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>CineManager</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <link href="styles/css/style.css" rel="stylesheet" type="text/css" />
        <link href="styles/css/ie6.css" rel="stylesheet" type="text/css" />
        <script src="styles/js/jquery-1.4.2.min.js" type="text/javascript"></script>
        <script src="styles/js/cufon-yui.js" type="text/javascript"></script>
        <script src="styles/js/cufon-replace.js" type="text/javascript"></script>
        <script src="styles/js/Gill_Sans_400.font.js" type="text/javascript"></script>
        <script src="styles/js/script.js" type="text/javascript"></script>
    </head>
    <body id="page1">
        <div class="tail-top">
            <div class="tail-bottom">
                <div id="main">
                    <div id="header">
                        <div class="row-1">
                            <div class="fleft"><a href="#">Cine<span>Manager</span></a></div>
                        </div>
                        <div class="row-2">
                            <ul>
                                <li><a href="index.jsp" class="active">Inicio</a></li>
                                <li><a href="login.jsp">Login</a></li>
                                <li><a href="cines.jsp">Cines</a></li>
                                <li><a href="SvPeliculas?destino=peliculas">Películas</a></li>
                            </ul>
                        </div>
                    </div>
                    <div id="content">
                        <div id="slogan">
                            <div class="image jpg"></div>
                            <div class="inside">
                                <h2>ESTO ES CINE<span>TODOS SOMOS CINE.</span></h2>
                                <p>Encuentra la información más actualizada sobre cines y películas en la ciudad de Pasto.</p>
                                <div class="wrapper"><a href="cines.jsp" class="link1"><span><span>Leer Más</span></span></a></div>
                            </div>
                        </div>
                        <div class="box">
                            <div class="border-right">
                                <div class="border-left">
                                    <div class="inner">
                                        <h3>Bienvenidos a <b>Cine</b> <span>Manager</span></h3>
                                        <p>CineManager es una aplicación creada por y para amantes del cine, los usuarios tendrán una experiencia informativa sobre los cines y peliculas en cartelera en la ciudad de Pasto. El propósito principal es mantener actualizada la información sobre cines en nuestra ciudad.</p>
                                        <div class="img-box1"><img src="images/oscars.jpeg" alt="" />El cine, desde sus inicios como una simple proyección de imágenes en movimiento, ha evolucionado hasta convertirse en una de las formas de arte más influyentes del mundo. Los hermanos Lumière, con su cinematógrafo, marcaron un hito al presentar las primeras proyecciones públicas en el siglo XIX. El cine mudo, con figuras como Chaplin y Keaton, dio paso al cine sonoro, ampliando las posibilidades narrativas. Hollywood se consolidó como la meca del cine, produciendo películas que cautivaron al público a nivel mundial. Con el tiempo, el cine ha experimentado una constante evolución, desde el cine clásico hasta el cine independiente y el cine digital, adaptándose a las nuevas tecnologías y a los cambios sociales.</div>
                                        <p>CineManager te hará explotar tu ambición por el cine, no te pierdas ningún estreno y enterate en qué cine estarán presentando tus peliculas favoritas!</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="content">
                            <h3>Películas Más Taquilleras<span> del 2024</span></h3>
                            <div class="movies-container">
                                <div class="column">
                                    <h4>Inside Out 2</h4>
                                    <img src="images/insideout2.png" alt="" />
                                    <p>Ahora que es adolescente, Riley experimenta nuevos sentimientos como Ansiedad y Envidia, que se imponen a los viejos mientras ella duda sobre si abandonar a sus antiguas amigas por otras de la escuela secundaria.</p>
                                    <p>Al 94% de los espectadores les gustó esta película</p>
                                </div>
                                <div class="column">
                                    <h4>Deadpool And Wolverine</h4>
                                    <img src="images/deadpool.jpeg" alt="" />
                                    <p>Deadpool viaja en el tiempo con la intención de reclutar a Wolverine en la batalla contra un enemigo común: Paradox.</p>
                                    <p>Al 95% de los espectadores les gustó esta película</p>
                                </div>
                                <div class="column">
                                    <h4>Despicable Me 4</h4>
                                    <img src="images/despicableme4.jpg" alt="" />
                                    <p>Gru y su familia deben adoptar identidades falsas para ocultarse de un supervillano, un antiguo compañero de la escuela de Gru que le guarda rencor desde pequeño y pretende convertir a la familia en híbridos entre humano y cucaracha.</p>
                                    <p>Al 86% de los espectadores les gustó esta película</p>
                                </div>
                                <div class="column last">
                                    <h4>Venom: El último baile</h4>
                                    <img src="images/venom_3.jpg" alt="" />
                                    <p>Eddie y Venom están huyendo. Perseguidos por sus dos mundos y con la red cerrándose, el dúo se ve obligado a tomar una decisión devastadora que echará el telón al último baile de Venom y Eddie.</p>
                                    <p>Al 81% de los espectadores les gustó esta película</p>
                                </div>
                            </div>
                            <!-- Opción para serializar películas -->
                            <center><form action="SvSerializarPeliculas" method="post">
                                    <input type="submit" value="Serializar Películas" class="btn" />
                                </form></center>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <footer class="footer1">
            <p>EDD 1 - 2024 <a href="#">Andrés Lombana y Sebastián Moreno</a></p>
            <p>Design by <a href="http://www.templatemonster.com/">TemplateMonster</a></p>
        </footer>        
        <script type="text/javascript"> Cufon.now();</script>
    </body>
</html>