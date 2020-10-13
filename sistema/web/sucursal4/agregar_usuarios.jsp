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
String usu = request.getParameter("usuario");
String cla = request.getParameter("clave");
String url="jdbc:postgresql://localhost/sistema";
try{
     Class.forName("org.postgresql.Driver");
    con = DriverManager.getConnection(url,"postgres","admin");
    if(con!=null){
               Statement comando = con.createStatement(); 
        ResultSet datos = comando.executeQuery("select * from usuarios4 where usuario='"+usu+"'");
        if(datos.next()==true){
            out.print("<script languaje=javascript>alert('Ya existe otro usuario con este nombre');" +
                       "location.href('index.jsp?pag=agregar_usuarios.jsp');</script>");
            }else{            
         int a = 0;   
        a = comando.executeUpdate("insert into usuarios4(usuario,clave) values ('"+usu+"','"+cla+"')");
        if(a>=1){
            out.print("<script languaje=javascript>alert('Usuario Agregado');" +
                       "location.href('index.jsp?pag=agregar_usuarios.jsp');</script>");
        }else{
            out.print("<script languaje=javascript>alert('Error al guardar');" +
                       "location.href('index.jsp?pag=agregar_usuarios.jsp');</script>");
        }
        }
    }    
}catch(SQLException ex){
    out.print("ex");
}catch(ClassNotFoundException ex){
    out.print("ex");
}
} 
  
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*;" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Documento sin t&iacute;tulo</title>
<link href="css/css.css" rel="stylesheet" type="text/css" />
<script>
function Clave(){
    clave = document.f1.clave.value;
    clave1 = document.f1.clave1.value;

    if (clave == clave1)
    {
    return true;
    }else{
       alert("claves no coinciden");
       return false;
}         }

</script>
</head>

<body>
<form id="form1" name="f1" method="post" action="index.jsp?pag=agregar_usuarios.jsp">
  <table width="0" border="0" cellspacing="0" cellpadding="3">
    <tr>
      <td colspan="2" align="center" class="td">Agregar usuarios </td>
    </tr>
    <tr>
      <td align="left" class="td">Usuario</td>
      <td class="td"><input name="usuario" type="text" id="usuario" /></td>
    </tr>
    <tr>
      <td align="left" class="td">Clave</td>
      <td class="td"><input name="clave" type="password" id="clave" /></td>
    </tr>
    <tr>
      <td align="left" class="td">Confirmar Clave </td>
      <td class="td"><input name="clave1" type="password" id="clave1" /></td>
    </tr>
    <tr>
        <td colspan="2" align="center" class="td"><input name="ok" type="submit" id="ok" value="Guardar" onclick="return Clave();" /></td>
    </tr>
  </table>
</form>
</body>
</html>
