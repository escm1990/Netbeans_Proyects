<%-- 
    Document   : Div0
    Created on : 15-may-2012, 13:45:41
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page info="Página de Manejo de Errores" %>
<%@page errorPage="paginaError.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%=response.getContentType()%>
        <%Integer valor=new Integer(3/0);%>
    </body>
</html>
