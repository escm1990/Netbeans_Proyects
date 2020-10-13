<%-- 
    Document   : Catalogo
    Created on : 13-abr-2012, 17:33:09
    Author     : CCOntables
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script language="javascript" type="text/javascript" src="scripts/funciones.js"></script>
        <link type="text/css" href="estilos/catalogo_css.css" media="screen"/>
    </head>
    <body>
        <form name="catalogo" action="/CCoContables/listarCuentas" method="post">
            <table width="464" height="275" border="0">
                <tr>
                    <td width="97" height="102"><img src="imagenes/catalogo.png" width="90" height="79"></td>
                    <td colspan="2"><h3>INGRESE CUENTAS DEL CATALOGO</h3></td>
                </tr>
                <tr>
                    <td height="27">&nbsp;</td>
                    <td width="159">IDCuenta:</td>
                    <td><input type="text" name="idCuenta" id="idCuenta" /></td>
                </tr>
                <tr>
                    <td height="33">&nbsp;</td>
                    <td>Nombre de la Cuenta:</td>
                    <td><input type="text" name="nombreCuenta" id="nombreCuenta" /></td>
                </tr>
                <tr>
                    <td height="31">&nbsp;</td>
                    <td>Valor Inicial:</td>
                    <td><input type="text" name="Valor" id="Valor" /></td>
                </tr>
                <tr>
                    <td height="36">&nbsp;</td>
                    <td>Id Cuenta Padre:</td>
                    <td><label for="Id_cuentaPadre"></label>
                        <input type="text" name="Id_cuentaPadre" id="Id_cuentaPadre" /></td>
                </tr>
                <tr>
                    <td height="32">&nbsp;</td>
                    <td>&nbsp;</td>
                    <td><input type="submit" name="Almacenar" id="Almacenar" value="Almacenar" /></td>
                </tr>
            </table>
        </form>
    </body>
</html>
