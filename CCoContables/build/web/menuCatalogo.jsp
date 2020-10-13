<%-- 
    Document   : menuCatalogo
    Created on : 13-abr-2012, 20:53:24
    Author     : CCOntables
--%>

<%@page import="controladores.ListadoCuentas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="estilos/menuCatalogo.css" rel="stylesheet" type="text/css">
        <title>Menu Catalogo</title>
    </head>
    <body>
        <div id="contenedor">
            <div id="izquierda">
                <p><a href="ListadoCuentas" target="mostrar"><img src="imagenes/lista.png" width="70" height="70"><br>Listar Catalogo</a></br>
                </p>
                <p>                  <a href="Catalogo.jsp" target="mostrar"><img src="imagenes/Dropbox-256-Arrow.png" width="70" height="70"><br>Agregar Cuenta</a></p>
                </br>
            </div>
            <div id="derecha">
                <iframe name="mostrar" frameborder="0" align="middle" width=100% height=100%></iframe>
            </div>
        </div>
    </body>
</html>
