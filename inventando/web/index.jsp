<%-- 
    Document   : index
    Created on : 06-mar-2012, 20:13:08
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="post" action="/inventando/generarSesion" id="frm">
            <table align="center" width="300" style="border:blue 3px solid">
                <thead>
                    <tr>
                        <th colspan="2">ACCESO</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Usuario:</td>
                        <td><input type="text" name="usuario" value=""/></td>
                    </tr>
                     <tr>
                        <td>Password:</td>
                        <td><input type="password" name="pass" value=""/></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Aceptar"/></td>
                    </tr>
                </tbody>
            </table> 
        </form>    
    </body>
</html>
