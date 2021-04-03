<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Personas</title>
    </head>
    <body>

        <table border="1">
            <caption>Listado de Personas</caption>
            <tr>
                <th>Id Persona</th>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Email</th>
                <th>Teléfono</th>
            </tr>
            <!-- personaVista es la variable del foreach
                 "personas" es el atributo que se seteó desde el controlador
                  para el listado de personas: request.setAttribute("personas", personas); -->
            <c:forEach var="personaVista" items="${personas}">
                <tr>
                    <td>${personaVista.id_persona}</td>
                    <td>${personaVista.nombre}</td>
                    <td>${personaVista.apellido}</td>
                    <td>${personaVista.email}</td>
                    <td>${personaVista.telefono}</td>
                </tr>
            </c:forEach>
        </table>

    </body>
</html>
