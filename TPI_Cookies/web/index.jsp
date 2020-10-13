<%-- 
    Document   : index
    Created on : 18-abr-2012, 10:24:22
    Author     : Chavez Vigil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="post" action="/TPI_Cookies/alumno" id="frm">           
            <h1><th>Ingrese Datos Alumnos</th></h1>
            <table align ="center" border ="1">                             
                <tr>
                    <td>Carnet: </td><td><input type ="text" name ="id"></input></td>
                </tr>
                <tr>
                    <td>Nombre: </td><td><input type ="text" name ="nombre"></input></td>
                </tr>
                <tr>
                    <td>Apellidos: </td><td><input type ="text" name ="apellido"></input></td>
                </tr>
                <tr>
                    <td>Direccion: </td><td><input type ="text" name ="dir"></input></td>
                </tr>
                <tr>
                    <td>Departamento: </td><td><input type ="text" name ="dep"></input></td>
                </tr>
                <tr>
                    <td>Municipio: </td><td><input type ="text" name ="muni"></input></td>
                </tr>
                <tr>
                    <td>E-mail: </td><td><input type ="text" name ="mail"></input></td>
                </tr>
                <tr>
                    <td>Telefono: </td><td><input type ="text" name ="tel"></input></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Mostrar Cookies" name="Enviar" /></td>
                </tr>
            </table>
        </form>
        <h3>Erick Stanley Cruz Martinez</h3>        
    </body>
</html>
