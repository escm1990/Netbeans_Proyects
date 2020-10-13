<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<% 
if(request.getParameter("ok")!=null){ 
String usu = request.getParameter("usuario");
String cla = request.getParameter("clave");
/*
cambiar el usuario a root 
*/
String user="postgres";
String pass="admin";
String url="jdbc:postgresql://localhost/sistema";
Connection con=null;
try{
    Class.forName("org.postgresql.Driver");
    con=DriverManager.getConnection(url,user,pass);
    if(con!=null){
    Statement comando = con.createStatement();
    ResultSet datos = comando.executeQuery("select * from usuarios where usuario='"+usu+"' and clave='"+cla+"'");     
    if(datos.next()){
        comando.close();
        con.close();
        session.setAttribute("admin", ""+usu+"");    
    response.sendRedirect("index.jsp?pag=bienvenido.jsp");
    }else{
      response.sendRedirect("index.jsp?pag=inicio.jsp");
    }
     }

        
}catch(SQLException ex){
    out.println(ex.getMessage());
}catch(ClassNotFoundException ex){
    out.println(ex.getMessage());
}
        
}

      

%>



<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Documento sin t&iacute;tulo</title>
<link href="css/css.css" rel="stylesheet" type="text/css" />
</head>

<body>
<form name="f1" method="post" action="login.jsp">
  <div align="center"> <br />
    <table width="0" border="0" cellspacing="0" cellpadding="3">
      <tr>
        <td align="center">Inicio de Sesion </td>
      </tr>
      <tr>
        <td>Usuario</td>
      </tr>
      <tr>
        <td><input name="usuario" type="text" id="usuario" /></td>
      </tr>
      <tr>
        <td>Clave</td>
      </tr>
      <tr>
        <td><input name="clave" type="password" id="clave" /></td>
      </tr>
      <tr>
        <td align="center"><input name="ok" type="submit" id="ok" value="Iniciar" /></td>
      </tr>
    </table>
  </div>
</form>
</body>
</html>
