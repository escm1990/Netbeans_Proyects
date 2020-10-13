<%-- 
    Document   : nuevaSucursal
    Created on : 13-abr-2012, 17:42:57
    Author     : Chavez Vigil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <script language="javascript" type="text/javascript" src="scripts/funciones.js"></script>
     <link type="text/css" href="estilos/newSuc_css.css" media="screen"/>
	<title>Nueva Sucursal</title>
<link href="estilos/newSuc_css.css" rel="stylesheet" type="text/css">
<style type="text/css">
#apDiv1 {
	position:absolute;
	width:200px;
	height:115px;
	z-index:1;
	left: 410px;
	top: 301px;
}
</style>
</head>
    <body>
    <form method="post" name ="registro" action="/CCoContables/AlmacenarSucursal" >
    <table width="918" height="276" border="0">
                <tr>
                    <td width="109"> <img src="imagenes/Ingresar.png" alt="" width="84" height="79" align="middle"></td>
                    <td colspan="4"><div align="center">INGRESE DATOS DE LA EMPRESA</div></td>
                </tr>
                <tr>
                    <td height="24" colspan="2">Nombre Sucursal: </td>
                    <td width="176"><input type="text" name="nombreEmpresa" id="nombreEmpresa" onBlur="isAlphabet(this)"/></td>
                    <td colspan="2">Datos del Encargado
                    </td>
                </tr>
                <tr>
                    <td height="24" colspan="2">Email:</td>
                    <td><input type="text" name="usuario" id="usuario" onBlur="emailValidator(this)"/></td>
                    <td width="159">Nombres:</td>
                    <td width="411"><label for="nom_enc"></label>
                    <input type="text" name="nom_enc" id="nom_enc" onBlur="isAlphabet(this)"></td>
                </tr>
                <tr>
                    <td height="24" colspan="2">Password: </td>
                    <td><input type="password" name="password" id="password" /></td>
                    <td>Apellidos:</td>
                    <td><label for="ape_enc"></label>
                    <input type="text" name="ape_enc" id="ape_enc" onBlur="isAlphabet(this)"></td>
                </tr>
                <tr>
                    <td height="24" colspan="2">Repit Pass:</td>
                    <td><input type="password" name="repitPass" id="repitPass" /></td>
                    <td>Fecha Nacimiento:</td>
                    <td><label for="fec_enc"></label>
                    <input type="text" name="fec_enc" id="fec_enc"></td>
                </tr>
                <tr>
                    <td height="24" colspan="2">Dirección: </td>
                    <td><input type="text" name="direccion" id="direccion" /></td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td height="24" colspan="2">Telefono:</td>
                    <td><input type="text" name="tel" id="tel" /></td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr> 
                    <td height="33" colspan="2">&nbsp;</td>
                    <td>&nbsp;</td>
                    <td><input type="submit" name="registrar" id="registrar" value="Registrar" /></td>
                    <td>&nbsp;</td>
                </tr>
      </table>
    </form>
</body>
</html>
