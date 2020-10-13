<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Hola Mundo JSP</title>
    </head>
    <body>
        <h1>Hola Mundo JSP</h1>
        <ul>
            <li> <% out.print("Hola Mundo con Scriptlet"); %> </li>
            <li> ${"Hola Mundo con Expression Language (EL)"} </li>
            <li> <%= "Hola Mundo con Expresiones" %> </li>
            <li> <c:out value="Hola Mundo con JSTL"/> </li>
        </ul>
    </body>
</html>
