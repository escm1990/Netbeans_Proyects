<%-- 
    Document   : index
    Created on : 07-mar-2012, 20:45:57
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CAPITULO 4</title>
    </head>
    <body>
        <form action="Servlet_TPI" method="post">
            <table>
                <tr>
                    <td>Apellido:</td>
                    <td><input name="apellido" align="left" size="15">&nbsp;</td>
                </tr>
                <tr>
                    <td>Nombre:</td>
                    <td><input name="nombre" align="left" size="15">&nbsp;</td>
                </tr>
                <tr>
                    <td>Edad:</td>
                    <td><input name="edad" align="left" size="11">&nbsp;</td>
                </tr>
                <tr>
                    <td>Usuario:</td>
                    <td><input name="user" align="left">&nbsp;</td>
                </tr>
                <tr>
                    <td>Contrasena:</td>
                    <td><input name="pass" align="left" size="8" type="password">&nbsp;</td>
                </tr>
            </table>
            <input type="submit" name="aceptar" value="Enviar">
            <input type="reset" value="cancelar">
        </form>
    </body>
</html>
