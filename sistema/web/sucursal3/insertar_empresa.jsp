<%
String usuario = "";
HttpSession sesion = request.getSession();
if (sesion.getAttribute("admin") == null) {
%>
 <script>
 alert("Es necesario identificarse")
 location.href="index.jsp";     
 </script>
<%
} else {
usuario = (String)sesion.getAttribute("");
}
%>

  <% 
 Connection con = null;
 //si ya fue presionado el boton
 if(request.getParameter("ok")!=null){ 
     //recuperar los valores del formulario
String emp = request.getParameter("empresa");
String url="jdbc:postgresql://localhost/sistema";
try{
     Class.forName("org.postgresql.Driver");
    con = DriverManager.getConnection(url,"postgres","admin");
    if(con!=null){
               Statement comando = con.createStatement(); 
        
         int a = 0;   
        a = comando.executeUpdate("insert into empresas3(empresa) values ('"+emp+"')");
        if(a>=1){
            out.print("<script languaje=javascript>alert('Registro Agregado');" +
                       "location.href='index.jsp?pag=empresas.jsp';</script>");
        }else{
            out.print("<script languaje=javascript>alert('Error al guardar');" +
                       "location.href='index.jsp?pag=empresas.jsp';</script>");
        
        }
    }    
}catch(SQLException ex){
    out.print("ex");
}catch(ClassNotFoundException ex){
    out.print("ex");
}
} 
  
%>
<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Documento sin t&iacute;tulo</title>
<link href="css/css.css" rel="stylesheet" type="text/css" />
</head>

<body>
<form id="form1" name="form1" method="post" action="">
<br />
<br />
<br />

<table width="0" border="0" cellpadding="3" cellspacing="0" class="table">
    <tr class="th">
      <td colspan="2" align="center" class="td">Agregar Empresas </td>
    </tr>
    <tr>
      <td align="center" class="td">Nombre de la empresa </td>
      <td align="center" class="td"><input name="empresa" type="text" id="empresa" size="50" /></td>
    </tr>
    <tr>
      <td colspan="2" align="center" class="td"><input name="ok" type="submit" id="ok" value="Guardar" /></td>
    </tr>
  </table>
</form>
</body>
</html>
