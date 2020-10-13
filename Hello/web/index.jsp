<%-- 
    Document   : index
    Created on : 12-07-2011, 10:40:05 AM
    Author     : rayalam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="Servlet_ServletConfig" method="post">
            <input type="submit" value="Leydo Web.xml..." name="Isend">
            <br><a href="MiServletHello/DatosExtras/123">Diciendo Hello</a>
            <BR><a href="NewServlet">new servlet(uso de paquetes)</a>
            <BR><a href="Servlet_LeyendoNavegador/123">Leyendo Navegador</a>
            <br><a href="Servlet_LeyendoCabezeras">Leyendo Cabezeras</a>
            
            <br><a href="CapturaDatos.html" >pasando datos a servlet</a>
            <br><a href="CaturaDatosGenericos.html" >pasando datos a servlet enforma generica</a>
            <br><a href="Servlet_CreateCookie">creando cookies</a>
            <br><a href="Servlet_ShowCookieValues">Checking cookie values</a> 
            <br><a href="RecuperaCookies.html">captura valor cookie</a>
        </form>
    </body>
</html>
