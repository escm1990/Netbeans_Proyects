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
    <td colspan="4" class="th">Consultar Balances Sucursal 3 </td>
  </tr>
  <tr>
    <td align="left" class="td">Id</td>
    <td align="left" class="td">Empresa</td>    
	<td align="left" class="td">Agregar</td>
	<td align="left" class="td">ver</td>
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
    ResultSet datos = comando.executeQuery("select * from empresas3");     
    while(datos.next()){
%>	  
  <tr>
    <td class="td"><% out.println(datos.getInt("id_empresa"));%></td>
    <td class="td"><% out.println(datos.getString("empresa"));%></td>
    <td align="center" class="td"><a href="index.jsp?pag=insertar_balance3.jsp&amp;id=<% out.println(datos.getInt("id_empresa"));  %>&n=<% out.println(datos.getString("empresa"));  %>"><img src="css/add.png" width="16" height="16" border="0" /></a></td>
    <td align="center" class="td"><a href="index.jsp?pag=ver_balances3.jsp&amp;id=<% out.println(datos.getInt("id_empresa"));  %>&n=<% out.println(datos.getString("empresa"));  %>"><img src="css/arrow_out.png" width="16" height="16" border="0" /></a></td>
	    
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
