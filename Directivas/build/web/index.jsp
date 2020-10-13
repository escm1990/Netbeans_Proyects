<%-- 
    Document   : index
    Created on : 14-may-2012, 20:37:10
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import ="java.util.*"%>
<%@page session = "true" %>
<%@page buffer = "12kb" %>
<%@page autoFlush="true" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center><h1>Manejo de Directivas - Page</h1></center>
    
    <h2>Date Time</h2><%= new Date()%>
    <h2>Id session</h2><%= session.getId()%>
    <h2>Tamaño Buffer</h2><%=response.getBufferSize() / 1024%>KB 

    <form name="form1" method="post" action="Div0.jsp">
        <input type="submit" value="Manejo de Errores">
    </form>
    
    <form name="form2" method="post" action="include.jsp">
        <input type="submit" value="Include`s Example">
    </form>

</body>
</html>
