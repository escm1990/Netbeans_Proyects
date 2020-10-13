 <% 
 Connection con = null;
 //si ya fue presionado el boton
 if(request.getParameter("ok")!=null){ 
     //recuperar los valores del formulario
String id = request.getParameter("id");
String fec = request.getParameter("fec");
String caj = request.getParameter("cj");
String ban = request.getParameter("bc");
String inv = request.getParameter("inv");
String cli = request.getParameter("cli");
String dc = request.getParameter("doc");
String dd = request.getParameter("ddv");
String dd2 = request.getParameter("ddv2");
String pi = request.getParameter("im");
String pi2 = request.getParameter("in2");
String iva = request.getParameter("iva");
String iva2 = request.getParameter("iva2");
String tr = request.getParameter("ter");
String st = request.getParameter("srt");
String st2 = request.getParameter("srt2");
String ed = request.getParameter("edi");
String da = request.getParameter("dpa");
String da2 = request.getParameter("dpa2");
String mb = request.getParameter("mee");
String da3 = request.getParameter("dpa3");
String da4 = request.getParameter("dpa4");
String er = request.getParameter("er");
String da5 = request.getParameter("dpa6");
String da6 = request.getParameter("dpa7");
String da7 = request.getParameter("dpa8");
String ra = request.getParameter("rpa");
String ia = request.getParameter("ipa");
String gi = request.getParameter("gi");
String am = request.getParameter("aa");
String am2 = request.getParameter("aa2");
String pp = request.getParameter("pu");
String pp2 = request.getParameter("pp");
String pro2 = request.getParameter("pp2");
String tots = request.getParameter("total");
String pro = request.getParameter("pr");
String dp = request.getParameter("dp");
String ad = request.getParameter("ad");
String ivap = request.getParameter("ivp");
String ivap2 = request.getParameter("ivp2");
String ah = request.getParameter("ah");
String tp = request.getParameter("tp");
String ca = request.getParameter("ca");
String uj = request.getParameter("uj");
String uj2 = request.getParameter("uj2");
String tot2 = request.getParameter("total2");
String url="jdbc:postgresql://localhost/sistema";
try{
     Class.forName("org.postgresql.Driver");
    con = DriverManager.getConnection(url,"postgres","admin");
    if(con!=null){
               Statement comando = con.createStatement();         
                  
         int a = 0;   
        a = comando.executeUpdate("insert into balance3(id_empresa,fecha,caja,bancos,inventarios_mercaderia,clientes,documentos_cobrar,deudores_diversos,deudores_diversos2,provision_incobrables,provision_incobrables2,iva_acreditable,iva_acreditable2,terrenos,superavit_terrenos,superavit_terrenos2,edificios,depreciacion_acumulada,depreciacion_acumulada2,mobiliario,depreciacion_acumulada3,depreciacion_acumulada4,equipo_reparto,depreciacion_acumulada5,depreciacion_acumulada6,depreciacion_acumulada7,rentas_anticipado,intereses_anticipado,gastos_instalacion,amortizacion_acumulada,amortizacion_acumulada2,papeleria,propaganda,total,proveedores,documentos_pagar,acreedores_diversos,iva_pagar,iva_pagar2,acreedores_hipotecarios,total_pasivo,capital_anterior,utilidad_ejercicio,utilidad_ejercicio2,total2,propaganda2) values ('"+id+"','"+fec+"','"+caj+"','"+ban+"','"+inv+"','"+cli+"','"+dc+"','"+dd+"','"+dd2+"','"+pi+"','"+pi2+"','"+iva+"','"+iva2+"','"+tr+"','"+st+"','"+st2+"','"+ed+"','"+da+"','"+da2+"','"+mb+"','"+da3+"','"+da4+"','"+er+"','"+da5+"','"+da6+"','"+da7+"','"+ra+"','"+ia+"','"+gi+"','"+am+"','"+am2+"','"+pp+"','"+pp2+"','"+tots+"','"+pro+"','"+dp+"','"+ad+"','"+ivap+"','"+ivap2+"','"+ah+"','"+tp+"','"+ca+"','"+uj+"','"+uj2+"','"+tot2+"','"+pro2+"')");
        if(a>=1){
            out.print("<script languaje=javascript>alert('Registro Agregado');" +
                       "location.href='index.jsp?pag=balances.jsp';</script>");
        }else{            out.print("<script languaje=javascript>alert('Error al guardar');" +
                       "location.href='index.jsp?pag=balances.jsp';</script>");
       
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
function Sumar(){  
      interval = setInterval("calcular()",1);  
}  
function calcular(){  
      uno = document.autoSumForm.cli.value;  
      dos = document.autoSumForm.doc.value;  
	  tre = document.autoSumForm.ddv.value;   	  
      document.autoSumForm.ddv2.value = (uno * 1) + (dos * 1) + (tre * 1);  
	  
	  un = document.autoSumForm.cj.value;  
      du = document.autoSumForm.bc.value;  
	  tr = document.autoSumForm.inv.value;   
	  cu = document.autoSumForm.in2.value;   
	  ci = document.autoSumForm.iva.value;   
      document.autoSumForm.iva2.value = (un * 1) + (du * 1) + (tr * 1) + (cu * 1) + (ci * 1) ;   
	  
	  ux = document.autoSumForm.ddv2.value;  
      dx = document.autoSumForm.im.value;  
      document.autoSumForm.in2.value = (ux * 1) - (dx * 1); 

  	  ax = document.autoSumForm.ter.value;  
      bx = document.autoSumForm.srt.value;  
      document.autoSumForm.srt2.value = (ax * 1) - (bx * 1); 
	  
	  cx = document.autoSumForm.edi.value;  
      fx = document.autoSumForm.dpa.value;  
      document.autoSumForm.dpa2.value = (cx * 1) - (fx * 1); 
	  
	  gx = document.autoSumForm.mee.value;  
      hx = document.autoSumForm.dpa3.value;  
      document.autoSumForm.dpa4.value = (gx * 1) - (hx * 1); 
	  
  	  ix = document.autoSumForm.er.value;  
      jx = document.autoSumForm.dpa6.value;  
      document.autoSumForm.dpa7.value = (ix * 1) - (jx * 1); 
	  
	  kx = document.autoSumForm.srt2.value;  
      lx = document.autoSumForm.dpa2.value;
	  mx = document.autoSumForm.dpa4.value;
	  nx = document.autoSumForm.dpa7.value;  
      document.autoSumForm.dpa8.value = (kx * 1) + (lx * 1) + (mx * 1) + (nx * 1); 
	  
	  ox = document.autoSumForm.gi.value;  
      px = document.autoSumForm.aa.value;  
      document.autoSumForm.aa2.value = (ox * 1) - (px * 1); 
	  
	  qx = document.autoSumForm.rpa.value;  
      rx = document.autoSumForm.ipa.value;
	  xx = document.autoSumForm.aa2.value;
	  yx = document.autoSumForm.pu.value;  
	  zx = document.autoSumForm.pp.value;  
      document.autoSumForm.pp2.value = (qx * 1) + (rx * 1) + (xx * 1) + (yx * 1)+ (zx * 1); 
	  
	  by = document.autoSumForm.iva2.value;  
      cy = document.autoSumForm.dpa8.value;
	  dy = document.autoSumForm.pp2.value;	  
      document.autoSumForm.total.value = (by * 1) + (cy * 1) + (dy * 1); 
	  
	  /*calculos de los pasivos*/
	  
 	  bc = document.autoSumForm.pr.value;  
      cc = document.autoSumForm.dp.value;
	  dc = document.autoSumForm.ad.value;	  
	  fc = document.autoSumForm.ivp.value;	  
      document.autoSumForm.ivp2.value = (bc * 1) + (cc * 1) + (dc * 1)+ (fc * 1); 
	  
	  bd = document.autoSumForm.ivp2.value;  
      cd = document.autoSumForm.ah.value;	    
      document.autoSumForm.tp.value = (bd * 1) + (cd * 1); 
	  
	  bf = document.autoSumForm.ca.value;  
      cf = document.autoSumForm.uj.value;	    
      document.autoSumForm.uj2.value = (bf * 1) + (cf * 1); 
	  
	  bg = document.autoSumForm.tp.value;  
      cg = document.autoSumForm.uj2.value;	    
      document.autoSumForm.total2.value = (bg * 1) + (cg * 1); 
	   
}  
function NoSumar(){  
      clearInterval(interval);  
}  
</script>
</head>

<body>    <br />

<br />
<br />
         
        
        
        
<form  name="autoSumForm" method="post" action="">
  <br />
  <table width="0" border="0" cellspacing="0" cellpadding="3">
    <tr>
      <td>Nombre de la Empresa </td>
      <td><label><% String n = request.getParameter("n");
                    out.print(n);       
%></label></td>
    </tr>
    <tr>
      <td>Fecha
      <input name="id" type="hidden" id="id" value="<% String id = request.getParameter("id");
                    out.print(id);       
%>" /></td>
      <td>
	  
	  <input name="fec" type="text" id="fec" size="40" /></td>
    </tr>
  </table>
  <br />
  <br />



  <table width="0" border="0" cellspacing="0" cellpadding="3">
    <tr>
      <td align="center" class="tds"><strong>Activos</strong></td>
      <td align="right" class="tds">&nbsp;</td>
      <td align="right" class="tds">&nbsp;</td>
      <td align="right" class="tds">&nbsp;</td>
      <td align="right" class="tds">&nbsp;</td>
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
      <td align="right" class="tds"><input name="cj" type="text" id="cj" size="10" onFocus="Sumar();" onBlur="NoSumar();" /></td>
      <td align="right" class="tds">&nbsp;</td>
    </tr>
    <tr>
      <td class="tds">Bancos</td>
      <td align="right" class="tds">&nbsp;</td>
      <td align="right" class="tds">&nbsp;</td>
      <td align="right" class="tds"><input name="bc" type="text" id="bc" size="10" onFocus="Sumar();" onBlur="NoSumar();" /></td>
      <td align="right" class="tds">&nbsp;</td>
    </tr>
    <tr>
      <td class="tds">Inventario de mercancias </td>
      <td align="right" class="tds">&nbsp;</td>
      <td align="right" class="tds">&nbsp;</td>
      <td align="right" class="tds"><input name="inv" type="text" id="inv" size="10" onFocus="Sumar();" onBlur="NoSumar();" /></td>
      <td align="right" class="tds">&nbsp;</td>
    </tr>
    <tr>
      <td class="tds">Clientes</td>
      <td align="right" class="tds"><input name="cli" type="text" id="cli" size="10" onfocus="Sumar();" onblur="NoSumar();" /></td>
      <td align="right" class="tds">&nbsp;</td>
      <td align="right" class="tds">&nbsp;</td>
      <td align="right" class="tds">&nbsp;</td>
    </tr>
    <tr>
      <td class="tds">Documentos por cobrar </td>
      <td align="right" class="tds"><input name="doc" type="text" id="doc" size="10" onFocus="Sumar();" onBlur="NoSumar();" /></td>
      <td align="right" class="tds">&nbsp;</td>
      <td align="right" class="tds">&nbsp;</td>
      <td align="right" class="tds">&nbsp;</td>
    </tr>
    <tr>
      <td class="tds">Deudores diversos </td>
      <td align="right" class="tds"><input name="ddv" type="text" id="ddv" size="10" onFocus="Sumar();" onBlur="NoSumar();" /></td>
      <td align="right" class="tds"><input name="ddv2" type="text" id="ddv2" size="10" onfocus="Sumar();" onblur="NoSumar();" /></td>
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
      <td align="right" class="tds"><input name="im" type="text" id="im" size="10" onFocus="Sumar();" onBlur="NoSumar();" /></td>
      <td align="right" class="tds"><input name="in2" type="text" id="in2" size="10" onFocus="Sumar();" onBlur="NoSumar();" /></td>
      <td align="right" class="tds">&nbsp;</td>
    </tr>
    <tr>
      <td class="tds">IVA acreditable </td>
      <td align="right" class="tds">&nbsp;</td>
      <td align="right" class="tds">&nbsp;</td>
      <td align="right" class="tds"><input name="iva" type="text" id="iva" size="10" onFocus="Sumar();" onBlur="NoSumar();" /></td>
      <td align="right" class="tds"><input name="iva2" type="text" id="iva2" size="10" onFocus="Sumar();" onBlur="NoSumar();" /></td>
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
      <td align="right" class="tds"><input name="ter" type="text" id="ter" size="10" onFocus="Sumar();" onBlur="NoSumar();" /></td>
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
      <td align="right" class="tds"><input name="srt" type="text" id="srt" size="10" onFocus="Sumar();" onBlur="NoSumar();" /></td>
      <td align="right" class="tds"><input name="srt2" type="text" id="srt2" size="10" /></td>
      <td align="right" class="tds">&nbsp;</td>
    </tr>
    <tr>
      <td class="tds">Edificios</td>
      <td align="right" class="tds">&nbsp;</td>
      <td align="right" class="tds"><input name="edi" type="text" id="edi" size="10" onFocus="Sumar();" onBlur="NoSumar();" /></td>
      <td align="right" class="tds">&nbsp;</td>
      <td align="right" class="tds">&nbsp;</td>
    </tr>
    <tr>
      <td class="tds">Menos: Depreciacion acumulada </td>
      <td align="right" class="tds">&nbsp;</td>
      <td align="right" class="tds"><input name="dpa" type="text" id="dpa" size="10" onFocus="Sumar();" onBlur="NoSumar();" /></td>
      <td align="right" class="tds"><input name="dpa2" type="text" id="dpa2" size="10" /></td>
      <td align="right" class="tds">&nbsp;</td>
    </tr>
    <tr>
      <td class="tds">Mobiliario y equipo </td>
      <td align="right" class="tds">&nbsp;</td>
      <td align="right" class="tds"><input name="mee" type="text" id="mee" size="10" onFocus="Sumar();" onBlur="NoSumar();" /></td>
      <td align="right" class="tds">&nbsp;</td>
      <td align="right" class="tds">&nbsp;</td>
    </tr>
    <tr>
      <td class="tds">Menos: Depreciacion acumulada </td>
      <td align="right" class="tds">&nbsp;</td>
      <td align="right" class="tds"><input name="dpa3" type="text" id="dpa3" size="10" onFocus="Sumar();" onBlur="NoSumar();" /></td>
      <td align="right" class="tds"><input name="dpa4" type="text" id="dpa4" size="10" /></td>
      <td align="right" class="tds">&nbsp;</td>
    </tr>
    <tr>
      <td class="tds">Equipo de reparto </td>
      <td align="right" class="tds">&nbsp;</td>
      <td align="right" class="tds"><input name="er" type="text" id="er" size="10" onFocus="Sumar();" onBlur="NoSumar();" /></td>
      <td align="right" class="tds">&nbsp;</td>
      <td align="right" class="tds">&nbsp;</td>
    </tr>
    <tr>
      <td class="tds">Menos: Depreciacion acumulada </td>
      <td align="right" class="tds">&nbsp;</td>
      <td align="right" class="tds"><input name="dpa6" type="text" id="dpa6" size="10" onFocus="Sumar();" onBlur="NoSumar();" /></td>
      <td align="right" class="tds"><input name="dpa7" type="text" id="dpa7" size="10" /></td>
      <td align="right" class="tds"><input name="dpa8" type="text" id="dpa8" size="10" onFocus="Sumar();" onBlur="NoSumar();" /></td>
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
      <td align="right" class="tds"><input name="rpa" type="text" id="rpa" size="10" onFocus="Sumar();" onBlur="NoSumar();" /></td>
      <td align="right" class="tds">&nbsp;</td>
    </tr>
    <tr>
      <td class="tds">Intereses pagados por anticipado </td>
      <td align="right" class="tds">&nbsp;</td>
      <td align="right" class="tds">&nbsp;</td>
      <td align="right" class="tds"><input name="ipa" type="text" id="ipa" size="10" onFocus="Sumar();" onBlur="NoSumar();" /></td>
      <td align="right" class="tds">&nbsp;</td>
    </tr>
    <tr>
      <td class="tds">Gastos de instalacion </td>
      <td align="right" class="tds">&nbsp;</td>
      <td align="right" class="tds"><input name="gi" type="text" id="gi" size="10" onFocus="Sumar();" onBlur="NoSumar();" /></td>
      <td align="right" class="tds">&nbsp;</td>
      <td align="right" class="tds">&nbsp;</td>
    </tr>
    <tr>
      <td class="tds">Menos: Amortizacion acumulada </td>
      <td align="right" class="tds">&nbsp;</td>
      <td align="right" class="tds"><input name="aa" type="text" id="aa" size="10" onFocus="Sumar();" onBlur="NoSumar();" /></td>
      <td align="right" class="tds"><input name="aa2" type="text" id="aa2" size="10" onFocus="Sumar();" onBlur="NoSumar();" /></td>
      <td align="right" class="tds">&nbsp;</td>
    </tr>
    <tr>
      <td class="tds">Papeleria y utiles </td>
      <td align="right" class="tds">&nbsp;</td>
      <td align="right" class="tds">&nbsp;</td>
      <td align="right" class="tds"><input name="pu" type="text" id="pu" size="10" onFocus="Sumar();" onBlur="NoSumar();" /></td>
      <td align="right" class="tds">&nbsp;</td>
    </tr>
    <tr>
      <td class="tds">Propaganda</td>
      <td align="right" class="tds">&nbsp;</td>
      <td align="right" class="tds">&nbsp;</td>
      <td align="right" class="tds"><input name="pp" type="text" id="pp" size="10" onFocus="Sumar();" onBlur="NoSumar();" /></td>
      <td align="right" class="tds"><input name="pp2" type="text" id="pp2" size="10" onFocus="Sumar();" onBlur="NoSumar();" /></td>
    </tr>
    <tr>
      <td class="tds">Total Activo </td>
      <td align="right" class="tds">&nbsp;</td>
      <td align="right" class="tds">&nbsp;</td>
      <td align="right" class="tds">&nbsp;</td>
      <td align="right" class="tds"><input name="total" type="text" id="total" size="10" /></td>
    </tr>
	
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
      <td class="tds"><input name="pr" type="text" id="pr" size="10" onFocus="Sumar();" onBlur="NoSumar();" /></td>
      <td class="tds">&nbsp;</td>
    </tr>
    <tr>
      <td class="tds">Documentos por pagar </td>
      <td class="tds">&nbsp;</td>
      <td class="tds">&nbsp;</td>
      <td class="tds"><input name="dp" type="text" id="dp" size="10" onFocus="Sumar();" onBlur="NoSumar();" /></td>
      <td class="tds">&nbsp;</td>
    </tr>
    <tr>
      <td class="tds">Acreedores Diversos </td>
      <td class="tds">&nbsp;</td>
      <td class="tds">&nbsp;</td>
      <td class="tds"><input name="ad" type="text" id="ad" size="10" onFocus="Sumar();" onBlur="NoSumar();" /></td>
      <td class="tds">&nbsp;</td>
    </tr>
    <tr>
      <td class="tds">IVA por pagar </td>
      <td class="tds">&nbsp;</td>
      <td class="tds">&nbsp;</td>
      <td class="tds"><input name="ivp" type="text" id="ivp" size="10" onFocus="Sumar();" onBlur="NoSumar();" /></td>
      <td class="tds"><input name="ivp2" type="text" id="ivp2" size="10" onFocus="Sumar();" onBlur="NoSumar();" /></td>
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
      <td class="tds"><input name="ah" type="text" id="ah" size="10" onFocus="Sumar();" onBlur="NoSumar();" /></td>
    </tr>
    <tr>
      <td class="tds">Total pasivo </td>
      <td class="tds">&nbsp;</td>
      <td class="tds">&nbsp;</td>
      <td class="tds">&nbsp;</td>
      <td class="tds"><input name="tp" type="text" id="tp" size="10" onFocus="Sumar();" onBlur="NoSumar();" /></td>
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
      <td class="tds"><input name="ca" type="text" id="ca" size="10" onFocus="Sumar();" onBlur="NoSumar();" /></td>
      <td class="tds">&nbsp;</td>
    </tr>
    <tr>
      <td class="tds">Utlidad de ejercicio </td>
      <td class="tds">&nbsp;</td>
      <td class="tds">&nbsp;</td>
      <td class="tds"><input name="uj" type="text" id="uj" size="10" onFocus="Sumar();" onBlur="NoSumar();" /></td>
      <td class="tds"><input name="uj2" type="text" id="uj2" size="10" onFocus="Sumar();" onBlur="NoSumar();" /></td>
    </tr>
    <tr>
      <td class="tds">Total pasivo mas capital </td>
      <td class="tds">&nbsp;</td>
      <td class="tds">&nbsp;</td>
      <td class="tds">&nbsp;</td>
      <td class="tds"><input name="total2" type="text" id="total2" size="10" /></td>
    </tr>
    <tr>
      <td colspan="5" align="center" class="tds"><input name="ok" type="submit" id="ok" value="Guardar" /></td>
    </tr>
  </table>
  <p>&nbsp;</p>
</form>
</body>
</html>
