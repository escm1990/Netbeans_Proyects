<%@page errorPage="WEB-INF/manejoErrores.jsp" %>
<%@page import="utilerias.Conversiones, java.util.Date" %>
<%@page contentType="application/vnd.ms-excel" %>
<%
    String nombreArchivo = "reporte.xls";
    response.setHeader("Content-Disposition", "attachment;filename="+nombreArchivo);
%>    
<!DOCTYPE html>
<html>
    <head>
        <title>Reporte Excel</title>
    </head>
    <body>
        <h1>Reporte Excel</h1>
        <br>
        <table border="1">
            <tr>
                <th>Curso</th>
                <th>Descripcion</th>
                <th>Fecha</th>
            </tr>
            <tr>
                <td>1. Fundamentos de Java</td>
                <td>Sintaxis basica</td>
                <td><%= Conversiones.format(new Date()) %></td>
            </tr>
            <tr>
                <td>2. Programacion con Java</td>
                <td>Conceptos de programación orientada a objeto</td>
                <td><%= Conversiones.format(new Date()) %></td>
            </tr>
        </table>
    </body>
</html>
