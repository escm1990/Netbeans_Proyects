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
 <%
  String id = request.getParameter("id");
  String e = request.getParameter("e");
 Connection con = null;
 String url="jdbc:postgresql://localhost/sistema";
    try{
        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection(url,"postgres","admin");
            if(con!=null){
               Statement comando = con.createStatement();
               String sql = "select * from empresas2,estados2 where empresas2.id_empresa='"+id+"' and estados2.id_estado='"+e+"'";              
               ResultSet cli = comando.executeQuery(sql);               
               cli.next();
                                       
 %>     
<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Documento sin t&iacute;tulo</title>
<link href="css/css.css" rel="stylesheet" type="text/css" />
</head>

<body onload="print();">
<div align="center">
<form name="autoSumForm" method="post" action="">
  <br />
  <table width="0" border="0" cellspacing="0" cellpadding="3">
    <tr>
      <td align="left">Nombre de la Empresa </td>
      <td align="left"><label>
       <%out.println(cli.getString("empresa"));%>
      </label></td>
    </tr>
    <tr>
      <td align="left">Fecha        </td>
      <td align="left"><%out.println(cli.getString("fecha"));%></td>
    </tr>
  </table>
  <br />
  <table width="664" border="0" cellpadding="3" cellspacing="0" class="table">
    <tr>
      <td class="tds">Ventas Totales </td>
      <td class="tds">&nbsp;</td>
      <td class="tds">&nbsp;</td>
      <td class="tds"><%out.println(cli.getString("ventas_totales"));%></td>
      <td class="tds">&nbsp;</td>
    </tr>
    <tr>
      <td class="tds">Menos: Devoluciones sobre ventas </td>
      <td class="tds">&nbsp;</td>
      <td class="tds"><%out.println(cli.getString("devoluciones_ventas"));%></td>
      <td class="tds">&nbsp;</td>
      <td class="tds">&nbsp;</td>
    </tr>
    <tr>
      <td class="tds">Menos: Rebajas sobre ventas </td>
      <td class="tds">&nbsp;</td>
      <td class="tds"><%out.println(cli.getString("rebajas_ventas"));%></td>
      <td class="tds"><%out.println(cli.getString("rebajas_ventas2"));%></td>
      <td class="tds">&nbsp;</td>
    </tr>
    <tr>
      <td class="tds"><strong>Ventas Netas </strong></td>
      <td class="tds">&nbsp;</td>
      <td class="tds">&nbsp;</td>
      <td class="tds">&nbsp;</td>
      <td class="tds"><%out.println(cli.getString("ventas_netas"));%></td>
    </tr>
    <tr>
      <td class="tds">Inventario Inicial </td>
      <td class="tds">&nbsp;</td>
      <td class="tds">&nbsp;</td>
      <td class="tds"><%out.println(cli.getString("inventario_inicial"));%></td>
      <td class="tds">&nbsp;</td>
    </tr>
    <tr>
      <td class="tds">Compras</td>
      <td class="tds"><%out.println(cli.getString("compras"));%></td>
      <td class="tds">&nbsp;</td>
      <td class="tds">&nbsp;</td>
      <td class="tds">&nbsp;</td>
    </tr>
    <tr>
      <td class="tds">Mas: Gastos de compra </td>
      <td class="tds"><%out.println(cli.getString("gastos_compras"));%></td>
      <td class="tds">&nbsp;</td>
      <td class="tds">&nbsp;</td>
      <td class="tds">&nbsp;</td>
    </tr>
    <tr>
      <td class="tds"><strong>Compras totales </strong></td>
      <td class="tds">&nbsp;</td>
      <td class="tds"><%out.println(cli.getString("compras_totales"));%></td>
      <td class="tds">&nbsp;</td>
      <td class="tds">&nbsp;</td>
    </tr>
    <tr>
      <td class="tds">Menos: Devoluciones de compra </td>
      <td class="tds"><%out.println(cli.getString("deboluciones_compras"));%></td>
      <td class="tds">&nbsp;</td>
      <td class="tds">&nbsp;</td>
      <td class="tds">&nbsp;</td>
    </tr>
    <tr>
      <td class="tds">Menos: Rebaja sobre compras </td>
      <td class="tds"><%out.println(cli.getString("rebajas_compras"));%></td>
      <td class="tds"><%out.println(cli.getString("rebajas_compras2"));%></td>
      <td class="tds">&nbsp;</td>
      <td class="tds">&nbsp;</td>
    </tr>
    <tr>
      <td class="tds"><strong>Compras Netas </strong></td>
      <td class="tds">&nbsp;</td>
      <td class="tds">&nbsp;</td>
      <td class="tds"><%out.println(cli.getString("compras_netas"));%></td>
      <td class="tds">&nbsp;</td>
    </tr>
    <tr>
      <td class="tds">Total de mercancia </td>
      <td class="tds">&nbsp;</td>
      <td class="tds">&nbsp;</td>
      <td class="tds"><%out.println(cli.getString("total_mercancia"));%></td>
      <td class="tds">&nbsp;</td>
    </tr>
    <tr>
      <td class="tds">Menos: Inventario Final </td>
      <td class="tds">&nbsp;</td>
      <td class="tds">&nbsp;</td>
      <td class="tds"><%out.println(cli.getString("inventario_final"));%></td>
      <td class="tds">&nbsp;</td>
    </tr>
    <tr>
      <td class="tds"><strong>Costo de lo vendido </strong></td>
      <td class="tds">&nbsp;</td>
      <td class="tds">&nbsp;</td>
      <td class="tds">&nbsp;</td>
      <td class="tds"><%out.println(cli.getString("costo_vendido"));%></td>
    </tr>
    <tr>
      <td class="tds"><strong>Utilidad Bruta </strong></td>
      <td class="tds">&nbsp;</td>
      <td class="tds">&nbsp;</td>
      <td class="tds">&nbsp;</td>
      <td class="tds"><%out.println(cli.getString("utilidad_bruta"));%></td>
    </tr>
    <tr>
      <td class="tds">Gastos de operacion </td>
      <td class="tds">&nbsp;</td>
      <td class="tds">&nbsp;</td>
      <td class="tds">&nbsp;</td>
      <td class="tds">&nbsp;</td>
    </tr>
    <tr>
      <td class="tds">Gastos de venta </td>
      <td class="tds">&nbsp;</td>
      <td class="tds"><%out.println(cli.getString("gastos_venta"));%></td>
      <td class="tds">&nbsp;</td>
      <td class="tds">&nbsp;</td>
    </tr>
    <tr>
      <td class="tds">Gastos de administracion </td>
      <td class="tds">&nbsp;</td>
      <td class="tds"><%out.println(cli.getString("gastos_administracion"));%></td>
      <td class="tds"><%out.println(cli.getString("gastos_administracion2"));%></td>
      <td class="tds">&nbsp;</td>
    </tr>
    <tr>
      <td class="tds">Productos financieros </td>
      <td class="tds">&nbsp;</td>
      <td class="tds">&nbsp;</td>
      <td class="tds"><%out.println(cli.getString("productos_financieros"));%></td>
      <td class="tds"><%out.println(cli.getString("productos_financieros2"));%></td>
    </tr>
    <tr>
      <td class="tds">Utilidad de operacion </td>
      <td class="tds">&nbsp;</td>
      <td class="tds">&nbsp;</td>
      <td class="tds">&nbsp;</td>
      <td class="tds"><%out.println(cli.getString("utilidad_operacion"));%></td>
    </tr>
    <tr>
      <td class="tds">Otros gastos </td>
      <td class="tds">&nbsp;</td>
      <td class="tds">&nbsp;</td>
      <td class="tds">&nbsp;</td>
      <td class="tds"><%out.println(cli.getString("otros_gastos"));%></td>
    </tr>
    <tr>
      <td class="tds">Utilidad de Ejercicio </td>
      <td class="tds">&nbsp;</td>
      <td class="tds">&nbsp;</td>
      <td class="tds">&nbsp;</td>
      <td class="tds"><%out.println(cli.getString("utilidad_ejercicio"));%></td>
    </tr>
  </table>
</form></div>
<p>&nbsp;</p>
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
