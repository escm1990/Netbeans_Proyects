<%-- 
    Document   : principal
    Created on : 06-mar-2012, 23:40:03
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    HttpSession session_actual = request.getSession(true);
    String usuario = (String) session_actual.getAttribute("USER");
    if (usuario == null) {
        response.sendRedirect("index.jsp");
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Bienvenido: <%=usuario%></h1>
        <form method="post" action="/inventando/cerrarSesion" id="cs">
            <input type="submit" value="Cerrar sesion"/>
        </form>
    </body>
</html>
