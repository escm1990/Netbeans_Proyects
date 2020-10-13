<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP con Scriptlets</title>
    </head>
    <body>
        <h1>JSP con Scriptlets</h1>
        <br>
        <%-- Scriptlet para enviar informacion al navegador --%>
        <% 
            //Scriptlet con código JAVA
            out.print("Saludos desde un Scriptlet");            
        %>
        <br>
        <%-- Scriptlet para manipular los objetos implícitos --%>
        <%
            String nombreAplicacion = request.getContextPath();
            out.print("Nombre de la aplicacion "+nombreAplicacion);
        %>
        <br>
        <%-- Scriptlet con codigo condicionado --%>
        <%
            if(session == null && session.isNew()){
        %>
            La sesion SI es nueva
        <%
            } else if(session != null){
        %>
            La sesion NO es nueva
        <%
        }
        %>
        <br>
        <a href="index.html">Volver al inicio</a>
    </body>
</html>
