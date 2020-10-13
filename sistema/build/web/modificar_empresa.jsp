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
               String sql = "select * from empresas where id_empresa='"+id+"'";              
               ResultSet cli = comando.executeQuery(sql);               
               cli.next();
                                       
 %>     
<html>
<head>
<title></title>
<link rel="stylesheet" href="css/css.css" type="text/css" />

<script src="js/validacion.js" type="text/javascript"></script>
</head>
<body bgcolor="#FFFFFF">
<form name="f1" method="post" action="index.jsp?pag=modificar_empresa2.jsp">
<br>
<br>
<table border="0" cellspacing="0" cellpadding="3">
    <tr>
      <td colspan="2" align="center" class="th">Modificar Empresa</td>
    </tr>
       <tr>
           <td align="left" class="td"><input type="hidden" name="id" value="<% out.println(cli.getInt("id_empresa"));%>">
           Nombre de la Empresa </td>
      <td align="left" class="td"><input name="empresa" type="text" id="empresa" value="<%out.println(cli.getString("empresa"));%>" maxlength="30"></td>
    </tr>
       <tr>
      <td colspan="2" align="center" class="td"><input type="submit" name="guardar" value="Guardar" class="button" onClick="return Clave()"></td>
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