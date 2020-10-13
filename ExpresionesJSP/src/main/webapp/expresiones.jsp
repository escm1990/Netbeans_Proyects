<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP con Expresiones</title>
    </head>
    <body>
        <h1>JSP con Expresiones</h1>
        Concatenacion: <%= "Saludos"+ " " + "JSP"%>
        <br>
        Operacion matematica <%= 2 * 3 / 2 %>
        <br>
        SessionID <%= session.getId() %>
        <br>
        <br>
        <a href="index.html">Regresar al Inicio</a>
    </body>
</html>
