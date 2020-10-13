<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Variables implicitas</title>
    </head>
    <body>
        <h1>Variables implicitas</h1>
        <br>
        <ul>
            <li>Nombre de la aplicacion: ${pageContext.request.contextPath}</li>
            <li>Navegador del cliente: ${header["User-Agent"]} </li>
            <li>ID Session ${cookie.JSESSIONID.value}</li>
            <li>Web Server: ${pageContext.servletContext.serverInfo}</li>
            <li>Parametro: ${param.usuario}</li>
        </ul>
    </body>
</html>
