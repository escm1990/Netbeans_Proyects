<%-- 
    Document   : index
    Created on : 05-20-2011, 01:19:51 PM
    Author     : wzamora
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hola Primer Servlet</title>
    </head>
    <body>
       
        <p align="center">
        <form action="NuevoServlet" method="POST">
            Ingrese su Nombre:<input type="text" name="Nombre" value="" size="45" />
            <input type="submit" value="Enviar" name="enviar"/>
        </form>
    </p>
    </body>
</html>
