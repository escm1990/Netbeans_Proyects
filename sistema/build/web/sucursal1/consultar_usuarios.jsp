<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Documento sin t&iacute;tulo</title>
<link href="css/css.css" rel="stylesheet" type="text/css" />
<script languaje="javascript"> 
function confirmar(){ 
   if (confirm("Esta realmente seguro que quiere eliminar este registro")){
      return true; 
   } else { 
      return false; 
   }
} 
</script>
</head>

<body>
<table width="0" border="0" cellpadding="3" cellspacing="0" class="table">
  <tr>
    <td class="td">Id</td>
    <td class="td">Usuario</td>
    <td class="td">Eliminar</td>
    <td class="td">Modificar</td>
  </tr>
<%    
String user="postgres";
String pass="admin";
String url="jdbc:postgresql://localhost/sistema";
Connection con=null;
try{
    Class.forName("org.postgresql.Driver");
    con=DriverManager.getConnection(url,user,pass);
    if(con!=null){
    Statement comando = con.createStatement();
    ResultSet datos = comando.executeQuery("select * from usuarios1");     
    while(datos.next()){
         out.print("<tr>");
    out.println("<td class=td>"+datos.getString("id_usuario")+"</td>");
    out.print("<td class=td>"+datos.getString("usuario")+"</td>");
    out.print("<td class=td><a href='index.jsp?pag=eliminar_usuario.jsp&id="+datos.getString("id_usuario")+"' onclick='return confirmar();'><img src=css/delete.png></a></td>");
    out.print("<td class=td><a href=index.jsp?pag=modificar_usuario.jsp&id="+datos.getString("id_usuario")+" ><img src=css/arrow_refresh.png></a></td>");
  out.print("</tr>");
        
               }
       

         }else{
      response.sendRedirect("index.jsp?pag=inicio.jsp");   }
     

        
}catch(SQLException ex){
    out.println(ex.getMessage());
}catch(ClassNotFoundException ex){
    out.println(ex.getMessage());
}    
%>          
</table>
</body>
</html>
