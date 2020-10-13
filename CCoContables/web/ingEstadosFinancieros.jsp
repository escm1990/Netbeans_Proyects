<%-- 
    Document   : ingEstadosFinancieros
    Created on : 13-abr-2012, 18:49:29
    Author     : CCOntables
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="estilos/menu-8.css" type="text/css" />
        <title>Estados Financieros</title>
    </head>
    <body>
        <div id="contenedor">
            <div id="izquierda">
                <div id="menu">
                    <ul>
                        <li class="nivel1 primera"><a href="#" target="mostrar" class="nivel1"><img src="imagenes/balance-general.png" width="70" height="70">Balance General</a>
                        </li>
                        <li class="nivel1"><a href="#" target="mostrar" class="nivel1"><img src="imagenes/calculadora.jpg" width="70" height="70"><br />Estado de Resultados</a>
                        </li>
                        <li class="nivel1"><a href="#" target="mostrar" class="nivel1"><img src="imagenes/Logo2.png" width="70" height="70"><br />Estado de Variacion de Capital</a>
                        </li>
                    </ul>
                </div>
            </div>
            <div id="derecha">
                <div id="mostrar">                
                <iframe name="mostrar" frameborder="0" align="middle" width=100% height=100%></iframe></div>
            </div>
        </div>
    </body>
</html>
