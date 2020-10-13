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
    <td colspan="4" class="th"> Estados 
      <% String n = request.getParameter("n");
	  String id = request.getParameter("id");
                    out.print(n);       
%>
- Sucursal 1 </td>
  </tr>
  <tr>
    <td align="center" class="td">Id</td>
    <td align="center" class="td">Fecha</td>    
	<td align="center" class="td">Eliminar</td>
	<td align="center" class="td">Imprimir</td>
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
    ResultSet datos = comando.executeQuery("select * from estados1 where id_empresa='"+id+"'");     
    while(datos.next()){
%>	  
  <tr>
    <td class="td"><% out.println(datos.getInt("id_estado"));%></td>
    <td class="td"><% out.println(datos.getString("fecha"));%></td>
    <td align="center" class="td"><a href="index.jsp?pag=eliminar_estado1.jsp&amp;id=<% out.println(datos.getInt("id_estado"));  %>" onclick="return confirmar();"><img src="css/delete.png" width="16" height="16" border="0" /></a></td>
    <td align="center" class="td"><a href="imprimir_estado1.jsp?id=<% out.println(datos.getInt("id_empresa"));  %>&e=<% out.println(datos.getInt("id_estado"));  %>" target="_blank"><img src="css/arrow_out.png" width="16" height="16" border="0" /></a></td>
	    
  </tr>
  <%
 }    
         }    

        
}catch(SQLException ex){
    out.println(ex.getMessage());
}catch(ClassNotFoundException ex){
    out.println(ex.getMessage());
}    
%>            
</table>
<br />
</body>
</html>
