<%-- 
    Document   : index
    Created on : 03-mar-2012, 8:22:56
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="post" action="/GUIA8/srv_alumno" id="frm">
            Carnet:<input name="car" type="text" style="height:20px; width:150px;"><br><br>
            Nombres:<input name="nomb" type="text" style="height:20px; width:150px;"><br><br>
            Apellidos:<input name="apell" type="text" style="height:20px; width:150px;"><br><br>
            <input type="submit" value="procesar">
        </form>
    </body>
</html>
