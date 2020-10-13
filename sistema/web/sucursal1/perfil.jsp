<%-- 
    Document   : perfil
    Created on : 06-19-2011, 03:33:08 PM
    Author     : greg
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/css.css" rel="stylesheet" type="text/css">
    </head>
    <body>
    <table width="0" border="0" cellspacing="0" cellpadding="3">
      <tr>
        <td>Bienvenido</td>
      </tr>
      <tr>
        <td><img src="icos/icono_usuarios.gif" width="99" height="90"></td>
      </tr>
      <tr>
        <td> <%
 if(session.getAttribute("admin")!=null){
     out.print(session.getAttribute("admin"));
     
 }
    %> </td>
      </tr>
    </table>
        
    </body>
</html>
