
<!DOCTYPE HTML>
<%
    HttpSession session_actual = request.getSession(true);
    String usuario = (String) session_actual.getAttribute("USER");
    if (usuario == null) {
        response.sendRedirect("index.jsp");
    }
%>
<html>
    <head>
        <meta charset="iso-8859-1">
        <meta name="Description" content="description">
        <meta name="Keywords" content="keywords"> 
        <meta name="author" content="author"> 
        <link rel="stylesheet" type="text/css" href="estilos/principal.css" media="screen">

        <title>CCOntables</title>

    </head>

    <body>
        <div id="apDiv1">
            <div align="right">
                <form method="post" action="/CCoContables/cerrarSesion" id="cs">
                    <input type="submit" value="Cerrar sesion"/>
                </form>
            </div>
        </div>

        <div class="top">
            <div class="header">
                <div align="center"><label><img src="imagenes/CCO.png" alt="" width="266" height="130" align="left"></label>
                </div>
                CCOntables:<br>
                Tu Empresa en un Clic</div>	
        </div>

        <div class="content">	
            <div class="navigation">		
                <a href="nuevaSucursal.jsp" target="portada"><img src="imagenes/nuevaSucursal.png" alt="" width="140" height="70"></a>
                <a href="menuCatalogo.jsp" target="portada"><img src="imagenes/nuevoCC.png" alt="" width="140" height="70"></a>
                <a href="ingEstadosFinancieros.jsp" target="portada"><img src="imagenes/nuevoEF.png" alt="" width="140" height="70"></a>
                <a href="razonesfinancieras.jsp" target="portada"><img src="imagenes/calcularRF.png" alt="" width="140" height="70"></a>
                <a href="menu.jsp" target="portada"><img src="imagenes/sucursalesListar.png" alt="" width="140" height="70"></a>
                <div class="clearer"><span></span></div>
            </div>

            <div class="main">
                <div>
                    <iframe id="portada" frameborder="0" align="middle" width=100% height=400px></iframe>
                </div>

                <div class="clearer"><span></span></div>
            </div>

            <div id="footer">
                &copy; 2012 <a href="index.jsp">CCOntables</a>. Valid <a href="http://jigsaw.w3.org/css-validator/check/referer">CSS</a> &amp; <a href="http://validator.w3.org/check?uri=referer">XHTML</a>. Template design by <a href="http://av.uesocc.edu.sv">CCO inc.</a>
            </div>
        </div>

    </body>
</html>