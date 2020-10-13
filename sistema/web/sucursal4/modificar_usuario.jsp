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
usuario = (String)sesion.getAttribute("admin");
}
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
 <%
  String id = request.getParameter("id");
 Connection con = null;
 String url="jdbc:postgresql://localhost/sistema";
    try{
        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection(url,"postgres","admin");
            if(con!=null){
               Statement comando = con.createStatement();
               String sql = "select * from usuarios4 where id_usuario='"+id+"'";              
               ResultSet cli = comando.executeQuery(sql);               
               cli.next();
                                       
 %>     
<html>
<head>
<title></title>
<link rel="stylesheet" href="css/css.css" type="text/css" />

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
<script src="js/validacion.js" type="text/javascript"></script>
</head>
<body bgcolor="#FFFFFF">
<form name="f1" method="post" action="index.jsp?pag=modificar_usuario2.jsp">
  <table border="0" cellspacing="0" cellpadding="3">
    <tr>
      <td colspan="2" align="center" class="th">Datos personales del Usuario</td>
    </tr>
       <tr>
           <td align="left" class="td"><input type="hidden" name="id" value="<% out.println(cli.getInt("id_usuario"));%>">Usuario</td>
      <td align="left" class="td"><input type="text" name="usuario" maxlength="30" value="<%out.println(cli.getString("usuario"));%>"></td>
    </tr>
    <tr>
      <td align="left" class="td">Clave</td>
      <td align="left" class="td"><input type="password" name="clave" maxlength="30" value="<%out.println(cli.getString("clave"));%>"></td>
    </tr>
    <tr>
      <td align="left" class="td">Confirmar Clave</td>
      <td align="left" class="td"><input type="password" name="clave1" maxlength="30" <%out.println(cli.getString("clave"));%>></td>
    </tr>
       <tr>
      <td colspan="2" align="center" class="td"><input type="submit" name="guardar" value="Guardar" class="button" onClick="return Clave()">
          <input name="reset" type="reset" class="button" value="Limpiar" ></td>
    </tr>
  </table>
</form>

</body>
</html>
<%

}
        
}catch(ClassNotFoundException ex){
  out.println("no se encuentra la clase");
 }catch(SQLException ex){
   out.println("error en el driver");
   } 
%>