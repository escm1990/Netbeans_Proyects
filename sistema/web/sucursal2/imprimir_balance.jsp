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
 Connection con = null;
 String url="jdbc:postgresql://localhost/sistema";
    try{
        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection(url,"postgres","admin");
            if(con!=null){
               Statement comando = con.createStatement();
               String sql = "select * from empresas2,balance2 where empresas2.id_empresa='"+id+"' and balance2.id_empresa='"+id+"'";              
               ResultSet cli = comando.executeQuery(sql);               
               cli.next();
                                       
 %>     
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*;" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Documento sin t&iacute;tulo</title>
<link href="css/css.css" rel="stylesheet" type="text/css" />
<style>

/*------------------------------------------------left panel--------------------*/
#iz{
width:50%;
float:left;
text-align:center;
}


/*------------------------------------------------left panel--------------------*/
#der{

width:50%;
float:left;

}

</style>

</head>

<body onLoad="print();"><br />
<div align="center">
<table width="0" border="0" cellspacing="0" cellpadding="3">
  <tr>
    <td>Nombre de la Empresa </td>
    <td><label>
     <%out.println(cli.getString("empresa"));%>
    </label></td>
  </tr>
  <tr>
    <td>Fecha</td>
    <td><%out.println(cli.getString("fecha"));%></td>
  </tr>
</table>
</div>
<br />
<br />
<div id="capa">
 <div id="der">
   <table width="465" border="0" cellspacing="0" cellpadding="3">
     <tr>
       <td colspan="5" align="center" class="tds"><strong>Activos</strong></td>
      </tr>
     <tr>
       <td align="center" class="tds"><strong>Circulante</strong></td>
       <td align="right" class="tds">&nbsp;</td>
       <td align="right" class="tds">&nbsp;</td>
       <td align="right" class="tds">&nbsp;</td>
       <td align="right" class="tds">&nbsp;</td>
     </tr>
     <tr>
       <td class="tds">Caja</td>
       <td align="right" class="tds">&nbsp;</td>
       <td align="right" class="tds">&nbsp;</td>
       <td align="right" class="tds"><%out.println(cli.getString("caja"));%></td>
       <td align="right" class="tds">&nbsp;</td>
     </tr>
     <tr>
       <td class="tds">Bancos</td>
       <td align="right" class="tds">&nbsp;</td>
       <td align="right" class="tds">&nbsp;</td>
       <td align="right" class="tds"><%out.println(cli.getString("bancos"));%></td>
       <td align="right" class="tds">&nbsp;</td>
     </tr>
     <tr>
       <td class="tds">Inventario de mercancias </td>
       <td align="right" class="tds">&nbsp;</td>
       <td align="right" class="tds">&nbsp;</td>
       <td align="right" class="tds"><%out.println(cli.getString("inventarios_mercaderia"));%></td>
       <td align="right" class="tds">&nbsp;</td>
     </tr>
     <tr>
       <td class="tds">Clientes</td>
       <td align="right" class="tds"><%out.println(cli.getString("clientes"));%></td>
       <td align="right" class="tds">&nbsp;</td>
       <td align="right" class="tds">&nbsp;</td>
       <td align="right" class="tds">&nbsp;</td>
     </tr>
     <tr>
       <td class="tds">Documentos por cobrar </td>
       <td align="right" class="tds"><%out.println(cli.getString("documentos_cobrar"));%></td>
       <td align="right" class="tds">&nbsp;</td>
       <td align="right" class="tds">&nbsp;</td>
       <td align="right" class="tds">&nbsp;</td>
     </tr>
     <tr>
       <td class="tds">Deudores diversos </td>
       <td align="right" class="tds"><%out.println(cli.getString("deudores_diversos"));%></td>
       <td align="right" class="tds"><%out.println(cli.getString("deudores_diversos2"));%></td>
       <td align="right" class="tds">&nbsp;</td>
       <td align="right" class="tds">&nbsp;</td>
     </tr>
     <tr>
       <td class="tds">Menos: Prevision para Creditos </td>
       <td align="right" class="tds">&nbsp;</td>
       <td align="right" class="tds">&nbsp;</td>
       <td align="right" class="tds">&nbsp;</td>
       <td align="right" class="tds">&nbsp;</td>
     </tr>
     <tr>
       <td class="tds">incobrables</td>
       <td align="right" class="tds">&nbsp;</td>
       <td align="right" class="tds"><%out.println(cli.getString("provision_incobrables"));%></td>
       <td align="right" class="tds"><%out.println(cli.getString("provision_incobrables2"));%></td>
       <td align="right" class="tds">&nbsp;</td>
     </tr>
     <tr>
       <td class="tds">IVA acreditable </td>
       <td align="right" class="tds">&nbsp;</td>
       <td align="right" class="tds">&nbsp;</td>
       <td align="right" class="tds"><%out.println(cli.getString("iva_acreditable"));%></td>
       <td align="right" class="tds"><%out.println(cli.getString("iva_acreditable2"));%></td>
     </tr>
     <tr>
       <td align="center" class="tds"><strong>Fijo</strong></td>
       <td align="right" class="tds">&nbsp;</td>
       <td align="right" class="tds">&nbsp;</td>
       <td align="right" class="tds">&nbsp;</td>
       <td align="right" class="tds">&nbsp;</td>
     </tr>
     <tr>
       <td class="tds">Terrenos</td>
       <td align="right" class="tds">&nbsp;</td>
       <td align="right" class="tds"><%out.println(cli.getString("terrenos"));%></td>
       <td align="right" class="tds">&nbsp;</td>
       <td align="right" class="tds">&nbsp;</td>
     </tr>
     <tr>
       <td class="tds">Menos: Superavit para revaluacion </td>
       <td align="right" class="tds">&nbsp;</td>
       <td align="right" class="tds">&nbsp;</td>
       <td align="right" class="tds">&nbsp;</td>
       <td align="right" class="tds">&nbsp;</td>
     </tr>
     <tr>
       <td class="tds">de terrenos </td>
       <td align="right" class="tds">&nbsp;</td>
       <td align="right" class="tds"><%out.println(cli.getString("superavit_terrenos"));%></td>
       <td align="right" class="tds"><%out.println(cli.getString("superavit_terrenos2"));%></td>
       <td align="right" class="tds">&nbsp;</td>
     </tr>
     <tr>
       <td class="tds">Edificios</td>
       <td align="right" class="tds">&nbsp;</td>
       <td align="right" class="tds"><%out.println(cli.getString("edificios"));%></td>
       <td align="right" class="tds">&nbsp;</td>
       <td align="right" class="tds">&nbsp;</td>
     </tr>
     <tr>
       <td class="tds">Menos: Depreciacion acumulada </td>
       <td align="right" class="tds">&nbsp;</td>
       <td align="right" class="tds"><%out.println(cli.getString("depreciacion_acumulada"));%></td>
       <td align="right" class="tds"><%out.println(cli.getString("depreciacion_acumulada2"));%></td>
       <td align="right" class="tds">&nbsp;</td>
     </tr>
     <tr>
       <td class="tds">Mobiliario y equipo </td>
       <td align="right" class="tds">&nbsp;</td>
       <td align="right" class="tds"><%out.println(cli.getString("mobiliario"));%></td>
       <td align="right" class="tds">&nbsp;</td>
       <td align="right" class="tds">&nbsp;</td>
     </tr>
     <tr>
       <td class="tds">Menos: Depreciacion acumulada </td>
       <td align="right" class="tds">&nbsp;</td>
       <td align="right" class="tds"><%out.println(cli.getString("depreciacion_acumulada3"));%></td>
       <td align="right" class="tds"><%out.println(cli.getString("depreciacion_acumulada4"));%></td>
       <td align="right" class="tds">&nbsp;</td>
     </tr>
     <tr>
       <td class="tds">Equipo de reparto </td>
       <td align="right" class="tds">&nbsp;</td>
       <td align="right" class="tds"><%out.println(cli.getString("equipo_reparto"));%></td>
       <td align="right" class="tds">&nbsp;</td>
       <td align="right" class="tds">&nbsp;</td>
     </tr>
     <tr>
       <td class="tds">Menos: Depreciacion acumulada </td>
       <td align="right" class="tds">&nbsp;</td>
       <td align="right" class="tds"><%out.println(cli.getString("depreciacion_acumulada5"));%></td>
       <td align="right" class="tds"><%out.println(cli.getString("depreciacion_acumulada6"));%></td>
       <td align="right" class="tds"><%out.println(cli.getString("depreciacion_acumulada7"));%></td>
     </tr>
     <tr>
       <td align="center" class="tds"><strong>Cargos diferidos </strong></td>
       <td align="right" class="tds">&nbsp;</td>
       <td align="right" class="tds">&nbsp;</td>
       <td align="right" class="tds">&nbsp;</td>
       <td align="right" class="tds">&nbsp;</td>
     </tr>
     <tr>
       <td class="tds">Rentas pagados por anticipado </td>
       <td align="right" class="tds">&nbsp;</td>
       <td align="right" class="tds">&nbsp;</td>
       <td align="right" class="tds"><%out.println(cli.getString("rentas_anticipado"));%></td>
       <td align="right" class="tds">&nbsp;</td>
     </tr>
     <tr>
       <td class="tds">Intereses pagados por anticipado </td>
       <td align="right" class="tds">&nbsp;</td>
       <td align="right" class="tds">&nbsp;</td>
       <td align="right" class="tds"><%out.println(cli.getString("intereses_anticipado"));%></td>
       <td align="right" class="tds">&nbsp;</td>
     </tr>
     <tr>
       <td class="tds">Gastos de instalacion </td>
       <td align="right" class="tds">&nbsp;</td>
       <td align="right" class="tds"><%out.println(cli.getString("gastos_instalacion"));%></td>
       <td align="right" class="tds">&nbsp;</td>
       <td align="right" class="tds">&nbsp;</td>
     </tr>
     <tr>
       <td class="tds">Menos: Amortizacion acumulada </td>
       <td align="right" class="tds">&nbsp;</td>
       <td align="right" class="tds"><%out.println(cli.getString("amortizacion_acumulada"));%></td>
       <td align="right" class="tds"><%out.println(cli.getString("amortizacion_acumulada2"));%></td>
       <td align="right" class="tds">&nbsp;</td>
     </tr>
     <tr>
       <td class="tds">Papeleria y utiles </td>
       <td align="right" class="tds">&nbsp;</td>
       <td align="right" class="tds">&nbsp;</td>
       <td align="right" class="tds"><%out.println(cli.getString("papeleria"));%></td>
       <td align="right" class="tds">&nbsp;</td>
     </tr>
     <tr>
       <td class="tds">Propaganda</td>
       <td align="right" class="tds">&nbsp;</td>
       <td align="right" class="tds">&nbsp;</td>
       <td align="right" class="tds"><%out.println(cli.getString("propaganda"));%></td>
       <td align="right" class="tds"><%out.println(cli.getString("propaganda2"));%></td>
     </tr>
     <tr>
       <td class="tds">Total Activo </td>
       <td align="right" class="tds">&nbsp;</td>
       <td align="right" class="tds">&nbsp;</td>
       <td align="right" class="tds">&nbsp;</td>
       <td align="right" class="tds"><%out.println(cli.getString("total"));%></td>
     </tr>
   </table>
 </div>
 <div id="iz" >
   <table width="429" border="0" cellspacing="0" cellpadding="3">
     <tr>
       <td class="tds" colspan="5" align="center"><b>Pasivos</b></td>
     </tr>
     <tr>
       <td class="tds"><strong>Flotante</strong></td>
       <td class="tds">&nbsp;</td>
       <td class="tds">&nbsp;</td>
       <td class="tds">&nbsp;</td>
       <td class="tds">&nbsp;</td>
     </tr>
     <tr>
       <td class="tds">Proveedores</td>
       <td class="tds">&nbsp;</td>
       <td class="tds">&nbsp;</td>
       <td class="tds"><%out.println(cli.getString("proveedores"));%></td>
       <td class="tds">&nbsp;</td>
     </tr>
     <tr>
       <td class="tds">Documentos por pagar </td>
       <td class="tds">&nbsp;</td>
       <td class="tds">&nbsp;</td>
       <td class="tds"><%out.println(cli.getString("documentos_pagar"));%></td>
       <td class="tds">&nbsp;</td>
     </tr>
     <tr>
       <td class="tds">Acreedores Diversos </td>
       <td class="tds">&nbsp;</td>
       <td class="tds">&nbsp;</td>
       <td class="tds"><%out.println(cli.getString("acreedores_diversos"));%></td>
       <td class="tds">&nbsp;</td>
     </tr>
     <tr>
       <td class="tds">IVA por pagar </td>
       <td class="tds">&nbsp;</td>
       <td class="tds">&nbsp;</td>
       <td class="tds"><%out.println(cli.getString("iva_pagar"));%></td>
       <td class="tds"><%out.println(cli.getString("iva_pagar2"));%></td>
     </tr>
     <tr>
       <td class="tds"><strong>Consolidado</strong></td>
       <td class="tds">&nbsp;</td>
       <td class="tds">&nbsp;</td>
       <td class="tds">&nbsp;</td>
       <td class="tds">&nbsp;</td>
     </tr>
     <tr>
       <td class="tds">Acreedores Hipotecarios </td>
       <td class="tds">&nbsp;</td>
       <td class="tds">&nbsp;</td>
       <td class="tds">&nbsp;</td>
       <td class="tds"><%out.println(cli.getString("acreedores_hipotecarios"));%></td>
     </tr>
     <tr>
       <td class="tds">Total pasivo </td>
       <td class="tds">&nbsp;</td>
       <td class="tds">&nbsp;</td>
       <td class="tds">&nbsp;</td>
       <td class="tds"><%out.println(cli.getString("total_pasivo"));%></td>
     </tr>
     <tr>
       <td class="tds"><strong>Capital contable </strong></td>
       <td class="tds">&nbsp;</td>
       <td class="tds">&nbsp;</td>
       <td class="tds">&nbsp;</td>
       <td class="tds">&nbsp;</td>
     </tr>
     <tr>
       <td class="tds">Capital anterior </td>
       <td class="tds">&nbsp;</td>
       <td class="tds">&nbsp;</td>
       <td class="tds"><%out.println(cli.getString("capital_anterior"));%></td>
       <td class="tds">&nbsp;</td>
     </tr>
     <tr>
       <td class="tds">Utlidad de ejercicio </td>
       <td class="tds">&nbsp;</td>
       <td class="tds">&nbsp;</td>
       <td class="tds"><%out.println(cli.getString("utilidad_ejercicio"));%></td>
       <td class="tds"><%out.println(cli.getString("utilidad_ejercicio2"));%></td>
     </tr>
     <tr>
       <td class="tds">Total pasivo mas capital </td>
       <td class="tds">&nbsp;</td>
       <td class="tds">&nbsp;</td>
       <td class="tds">&nbsp;</td>
       <td class="tds"><%out.println(cli.getString("total2"));%></td>
     </tr>
     <tr>
       <td colspan="5" align="center" class="tds">&nbsp;</td>
     </tr>
   </table>
 </div>

  <br />
  <br />
  <p>&nbsp;</p>
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />

</div>
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
