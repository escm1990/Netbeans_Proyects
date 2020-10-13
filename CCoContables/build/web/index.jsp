<%-- 
    Document   : index
    Created on : 16-mar-2012, 23:49:41
    Author     : CCOntables
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>CCOntables</title>
        <link rel="stylesheet" type="text/css" href="estilos/index.css" media="screen"/>
        <script language="javascript" type="text/javascript" src="scripts/funciones.js"></script>
    </head>

    <body background="imagenes/fondo.jpg">
        <div id="login" align="right">
            <form method="post" id="form1" name="login" action="/CCoContables/genSesion">
                <table width="410" border="0">
                    <tr>
                        <td width="161"><font color="#FFFFFF">Usuario:</font></td>
                        <td width="176"><font color="#FFFFFF">Contraseña:</font></td>
                        <td width="59">&nbsp;</td>
                    </tr>
                    <tr>
                        <td height="29"><input type="text" name="usuario" id="usuario" onblur = "obligatorio(this)" /></td>
                        <td><label for="pass"></label>
                            <input type="password" name="pass" id="pass" onblur = "obligatorio(this)"/></td>
                        <td><input type="submit" name="entrar" id="entrar" value="Entrar" /></td>
                    </tr>
                </table>
            </form>
        </div>
        <label for="usuario"></label>
        <div id="main" align="center">
            <form id="form2" name="form2" method="post" action="/CCoContables/ManejoDatos">
                <table width="964" height="391" border="0" align="center">
                    <tr>
                        <td width="605" rowspan="9"><div align="left"><img src="imagenes/Inicio2.png" width="605" height="375" align="left" /></div>
                        </td>
                        <td height="48" colspan="3"><strong>Registra tu empresa:</strong></td>
                    </tr>
                    <tr>
                        <td width="12"><div align="left"></div></td>
                        <td width="166">Nombre Empresa:</td>
                        <td width="163"><label for="nombreEmpresa"></label>
                            <input type="text" name="nombreEmpresa" id="nombreEmpresa" onfocus="entroEnfoco(this)" onblur=" obligatorio(this); salioEnfoco(this)"/></td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td>Correo Electrónico:</td>
                        <td><label for="email"></label>
                            <input type="text" name="email" id="email" onfocus="entroEnfoco(this)" onblur="obligatorio(this); salioEnfoco(this); validarEmail(this)"/></td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td>Escribe de nuevo tu correo electrónico:</td>
                        <td><label for="repEmail"></label>
                            <input type="text" name="repEmail" id="repEmail" onfocus="entroEnfoco(this)" onblur=" obligatorio(this); salioEnfoco(this); validarEmail(this)"/></td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td>Dirección:</td>
                        <td><label for="direccion"></label>
                            <input type="text" name="address" id="address" onfocus="entroEnfoco(this)" onblur=" obligatorio(this); salioEnfoco(this)"/></td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td>Usuario:</td>
                        <td><label for="newUsuario"></label>
                            <input type="text" name="newUsuario" id="newUsuario" onfocus="entroEnfoco(this)" onblur=" obligatorio(this); salioEnfoco(this)"/></td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td>Password:</td>
                        <td><label for="newPass"></label>
                            <input type="password" name="newPass" id="newPass" onfocus="entroEnfoco(this)" onblur="obligatorio(this); salioEnfoco(this)"/></td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td>Repite tu password:</td>
                        <td><label for="repNewPass"></label>
                            <input type="password" name="repNewPass" id="repNewPass" onfocus="entroEnfoco(this)" onblur=" obligatorio(this); salioEnfoco(this)"/></td>
                    </tr>
                    <tr>
                        <td height="116">&nbsp;</td>
                        <td>&nbsp;</td>
                        <td><input type="submit" name="registrar" id="registrar" value="Registrar" /></td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
