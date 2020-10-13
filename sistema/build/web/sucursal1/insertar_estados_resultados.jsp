<% 
 Connection con = null;
 //si ya fue presionado el boton
 if(request.getParameter("ok")!=null){ 
     //recuperar los valores del formulario
String id = request.getParameter("id");
String fec = request.getParameter("fec");
String vt = request.getParameter("vt");
String dv = request.getParameter("dv");
String rv = request.getParameter("rv");
String rv2 = request.getParameter("rv2");
String vn = request.getParameter("vn");
String ini = request.getParameter("ini");
String cm = request.getParameter("cm");
String gc = request.getParameter("gc");
String ct = request.getParameter("ct");
String dc = request.getParameter("dc");
String rc = request.getParameter("rc");
String rc2 = request.getParameter("rc2");
String cn = request.getParameter("cn");
String tm = request.getParameter("tm");
String inf = request.getParameter("inf");
String cv = request.getParameter("cv");
String ub = request.getParameter("ub");
String gv = request.getParameter("gv");
String ga = request.getParameter("ga");
String ga2 = request.getParameter("ga2");
String pf = request.getParameter("pf");
String pf2 = request.getParameter("pf2");
String up = request.getParameter("up");
String og = request.getParameter("ot");
String ue = request.getParameter("uj");
String url="jdbc:postgresql://localhost/sistema";
try{
     Class.forName("org.postgresql.Driver");
    con = DriverManager.getConnection(url,"postgres","admin");
    if(con!=null){
               Statement comando = con.createStatement();         
                  
         int a = 0;   
        a = comando.executeUpdate("insert into estados1(id_empresa,fecha,ventas_totales,devoluciones_ventas,rebajas_ventas,rebajas_ventas2,ventas_netas,inventario_inicial,compras,gastos_compras,compras_totales,deboluciones_compras,rebajas_compras,rebajas_compras2,compras_netas,total_mercancia,inventario_final,costo_vendido,utilidad_bruta,gastos_venta,gastos_administracion,gastos_administracion2,productos_financieros,productos_financieros2,utilidad_operacion,otros_gastos,utilidad_ejercicio) values ('"+id+"','"+fec+"','"+vt+"','"+dv+"','"+rv+"','"+rv2+"','"+vn+"','"+ini+"','"+cm+"','"+gc+"','"+ct+"','"+dc+"','"+rc+"','"+rc2+"','"+cn+"','"+tm+"','"+inf+"','"+cv+"','"+ub+"','"+gv+"','"+ga+"','"+ga2+"','"+pf+"','"+pf2+"','"+up+"','"+og+"','"+ue+"')");
        if(a>=1){
            out.print("<script languaje=javascript>alert('Estado Agregado');" +
                       "location.href='index.jsp?pag=estados.jsp';</script>");
        }else{            out.print("<script languaje=javascript>alert('Error al guardar');" +
                       "location.href='index.jsp?pag=estados.jsp';</script>");
       
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
<script>
function Sumar(){  
      interval = setInterval("calcular()",1);  
}  
function calcular(){  
      uno = document.autoSumForm.dv.value;  
      dos = document.autoSumForm.rv.value;  
      document.autoSumForm.rv2.value = (uno * 1) + (dos * 1);  
	  
      aa = document.autoSumForm.vt.value;  
      ab = document.autoSumForm.rv2.value;  
      document.autoSumForm.vn.value = (aa * 1) - (ab * 1);  
	  
      ac = document.autoSumForm.cm.value;  
      ad = document.autoSumForm.gc.value;  
      document.autoSumForm.ct.value = (ac * 1) + (ad * 1);  
	  
	  ae = document.autoSumForm.dc.value;  
      af = document.autoSumForm.rc.value;  
      document.autoSumForm.rc2.value = (ae * 1) + (af * 1);  
	  
      ag = document.autoSumForm.ct.value;  
      ah = document.autoSumForm.rc2.value;  
      document.autoSumForm.cn.value = (ag * 1) - (ah * 1);  
	  
	  ai = document.autoSumForm.tm.value;  
      aj = document.autoSumForm.inf.value;  
      document.autoSumForm.cv.value = (ai * 1) - (aj * 1);
	  
	  ak = document.autoSumForm.vn.value;  
      al = document.autoSumForm.cv.value;  
      document.autoSumForm.ub.value = (ak * 1) - (al * 1);  
	  
	  am = document.autoSumForm.gv.value;  
      an = document.autoSumForm.ga.value;  
      document.autoSumForm.ga2.value = (am * 1) + (an * 1);
	  
	  ao = document.autoSumForm.ga2.value;  
      ap = document.autoSumForm.pf.value;  
      document.autoSumForm.pf2.value = (ao * 1) - (ap * 1);
	  
	  ar = document.autoSumForm.ub.value;  
      as = document.autoSumForm.pf2.value;  
      document.autoSumForm.up.value = (ar * 1) - (as * 1);
	  
	  at = document.autoSumForm.up.value;  
      aw = document.autoSumForm.ot.value;  
      document.autoSumForm.uj.value = (at * 1) - (aw * 1);
	  
	  
	  
	  }  
function NoSumar(){  
      clearInterval(interval);  
}  
</script>
</head>

<body>
<form name="autoSumForm" method="post" action="">
  <br />
  <table width="0" border="0" cellspacing="0" cellpadding="3">
    <tr>
      <td>Nombre de la Empresa </td>
      <td><label>
        <% String n = request.getParameter("n");
                    out.print(n);       
%>
      </label></td>
    </tr>
    <tr>
      <td>Fecha
        <input name="id" type="hidden" id="id" value="<% String id = request.getParameter("id");
                    out.print(id);       
%>" /></td>
      <td><input name="fec" type="text" id="fec" size="40" /></td>
    </tr>
  </table>
  <br />
  <table width="0" border="0" cellpadding="3" cellspacing="0" class="table">
    <tr>
      <td class="tds">Ventas Totales </td>
      <td class="tds">&nbsp;</td>
      <td class="tds">&nbsp;</td>
      <td class="tds"><input name="vt" type="text" id="vt" size="10" onFocus="Sumar();" onBlur="NoSumar();" /></td>
      <td class="tds">&nbsp;</td>
    </tr>
    <tr>
      <td class="tds">Menos: Devoluciones sobre ventas </td>
      <td class="tds">&nbsp;</td>
      <td class="tds"><input name="dv" type="text" id="dv" size="10" onFocus="Sumar();" onBlur="NoSumar();" /></td>
      <td class="tds">&nbsp;</td>
      <td class="tds">&nbsp;</td>
    </tr>
    <tr>
      <td class="tds">Menos: Rebajas sobre ventas </td>
      <td class="tds">&nbsp;</td>
      <td class="tds"><input name="rv" type="text" id="rv" size="10" onFocus="Sumar();" onBlur="NoSumar();" /></td>
      <td class="tds"><input name="rv2" type="text" id="rv2" size="10" onFocus="Sumar();" onBlur="NoSumar();" /></td>
      <td class="tds">&nbsp;</td>
    </tr>
    <tr>
      <td class="tds"><strong>Ventas Netas </strong></td>
      <td class="tds">&nbsp;</td>
      <td class="tds">&nbsp;</td>
      <td class="tds">&nbsp;</td>
      <td class="tds"><input name="vn" type="text" id="vn" size="10" onFocus="Sumar();" onBlur="NoSumar();" /></td>
    </tr>
    <tr>
      <td class="tds">Inventario Inicial </td>
      <td class="tds">&nbsp;</td>
      <td class="tds">&nbsp;</td>
      <td class="tds"><input name="ini" type="text" id="ini" size="10" /></td>
      <td class="tds">&nbsp;</td>
    </tr>
    <tr>
      <td class="tds">Compras</td>
      <td class="tds"><input name="cm" type="text" id="cm" size="10"  onFocus="Sumar();" onBlur="NoSumar();" /></td>
      <td class="tds">&nbsp;</td>
      <td class="tds">&nbsp;</td>
      <td class="tds">&nbsp;</td>
    </tr>
    <tr>
      <td class="tds">Mas: Gastos de compra </td>
      <td class="tds"><input name="gc" type="text" id="gc" size="10"  onfocus="Sumar();" onblur="NoSumar();" /></td>
      <td class="tds">&nbsp;</td>
      <td class="tds">&nbsp;</td>
      <td class="tds">&nbsp;</td>
    </tr>
    <tr>
      <td class="tds"><strong>Compras totales </strong></td>
      <td class="tds">&nbsp;</td>
      <td class="tds"><input name="ct" type="text" id="ct" size="10"  onFocus="Sumar();" onBlur="NoSumar();" /></td>
      <td class="tds">&nbsp;</td>
      <td class="tds">&nbsp;</td>
    </tr>
    <tr>
      <td class="tds">Menos: Devoluciones de compra </td>
      <td class="tds"><input name="dc" type="text" id="dc" size="10"  onFocus="Sumar();" onBlur="NoSumar();" /></td>
      <td class="tds">&nbsp;</td>
      <td class="tds">&nbsp;</td>
      <td class="tds">&nbsp;</td>
    </tr>
    <tr>
      <td class="tds">Menos: Rebaja sobre compras </td>
      <td class="tds"><input name="rc" type="text" id="rc" size="10"  onFocus="Sumar();" onBlur="NoSumar();" /></td>
      <td class="tds"><input name="rc2" type="text" id="rc2" size="10" onFocus="Sumar();" onBlur="NoSumar();" /></td>
      <td class="tds">&nbsp;</td>
      <td class="tds">&nbsp;</td>
    </tr>
    <tr>
      <td class="tds"><strong>Compras Netas </strong></td>
      <td class="tds">&nbsp;</td>
      <td class="tds">&nbsp;</td>
      <td class="tds"><input name="cn" type="text" id="cn" size="10" onFocus="Sumar();" onBlur="NoSumar();" /></td>
      <td class="tds">&nbsp;</td>
    </tr>
    <tr>
      <td class="tds">Total de mercancia </td>
      <td class="tds">&nbsp;</td>
      <td class="tds">&nbsp;</td>
      <td class="tds"><input name="tm" type="text" id="tm" size="10" onFocus="Sumar();" onBlur="NoSumar();" /></td>
      <td class="tds">&nbsp;</td>
    </tr>
    <tr>
      <td class="tds">Menos: Inventario Final </td>
      <td class="tds">&nbsp;</td>
      <td class="tds">&nbsp;</td>
      <td class="tds"><input name="inf" type="text" id="inf" size="10" onFocus="Sumar();" onBlur="NoSumar();" /></td>
      <td class="tds">&nbsp;</td>
    </tr>
    <tr>
      <td class="tds"><strong>Costo de lo vendido </strong></td>
      <td class="tds">&nbsp;</td>
      <td class="tds">&nbsp;</td>
      <td class="tds">&nbsp;</td>
      <td class="tds"><input name="cv" type="text" id="cv" size="10" onFocus="Sumar();" onBlur="NoSumar();" /></td>
    </tr>
    <tr>
      <td class="tds"><strong>Utilidad Bruta </strong></td>
      <td class="tds">&nbsp;</td>
      <td class="tds">&nbsp;</td>
      <td class="tds">&nbsp;</td>
      <td class="tds"><input name="ub" type="text" id="ub" size="10" /></td>
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
      <td class="tds"><input name="gv" type="text" id="gv" size="10" onFocus="Sumar();" onBlur="NoSumar();" /></td>
      <td class="tds">&nbsp;</td>
      <td class="tds">&nbsp;</td>
    </tr>
    <tr>
      <td class="tds">Gastos de administracion </td>
      <td class="tds">&nbsp;</td>
      <td class="tds"><input name="ga" type="text" id="ga" size="10" onFocus="Sumar();" onBlur="NoSumar();" /></td>
      <td class="tds"><input name="ga2" type="text" id="ga2" size="10" onFocus="Sumar();" onBlur="NoSumar();" /></td>
      <td class="tds">&nbsp;</td>
    </tr>
    <tr>
      <td class="tds">Productos financieros </td>
      <td class="tds">&nbsp;</td>
      <td class="tds">&nbsp;</td>
      <td class="tds"><input name="pf" type="text" id="pf" size="10" onFocus="Sumar();" onBlur="NoSumar();" /></td>
      <td class="tds"><input name="pf2" type="text" id="pf2" size="10"  onFocus="Sumar();" onBlur="NoSumar();"/></td>
    </tr>
    <tr>
      <td class="tds">Utilidad de operacion </td>
      <td class="tds">&nbsp;</td>
      <td class="tds">&nbsp;</td>
      <td class="tds">&nbsp;</td>
      <td class="tds"><input name="up" type="text" id="up" size="10" onFocus="Sumar();" onBlur="NoSumar();" /></td>
    </tr>
    <tr>
      <td class="tds">Otros gastos </td>
      <td class="tds">&nbsp;</td>
      <td class="tds">&nbsp;</td>
      <td class="tds">&nbsp;</td>
      <td class="tds"><input name="ot" type="text" id="ot" size="10" onFocus="Sumar();" onBlur="NoSumar();" /></td>
    </tr>
    <tr>
      <td class="tds">Utilidad de Ejercicio </td>
      <td class="tds">&nbsp;</td>
      <td class="tds">&nbsp;</td>
      <td class="tds">&nbsp;</td>
      <td class="tds"><input name="uj" type="text" id="uj" size="10" onFocus="Sumar();" onBlur="NoSumar();" /></td>
    </tr>
    <tr>
      <td colspan="5" align="center" class="tds"><input name="ok" type="submit" id="ok" value="Guardar Estado" /></td>
    </tr>
  </table>
</form>
<p>&nbsp;</p>
</body>
</html>
