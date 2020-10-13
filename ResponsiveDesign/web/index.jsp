<%-- 
    Document   : index
    Created on : 01-may-2012, 11:58:33
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario Principal</title>
        <style type="text/css">
            body
            {
                background: #7a94e4;
                color: white;
                font-family: Helvetica, Arial;
                font-size: 16px;
            }
            h1
            {
                text-align: center;
                text-shadow: 5px 5px 10px rgba(0,0,0,0,5);
            }
            form
            {
                background: beige;
                color: black;
                border-radius: 0.5em;
                display: block;
                margin: 1em auto;
                padding: 1em;
                box-shadow: 0px 5px 10px rgba(0,0,0,0,5);
                width: 60%;
            }
            .naranja
            {
                color: orange;
                font-weight: bold;
            }
            .error{
                background-color:#FFFF00;
                border: 2px solid #FF0000;
            }
            } 
        </style>

        <script lenguaje="Javascript">
                    document.writeln("Su resolución es de: "+screen.width + " x " + screen.height)
        </script>
    </head>

    <body>
    <center><h1>Formulario Principal</h1></center>
    <form action="ManejoDatos" method="post">
        <div class=centraTabla>
            <table
                <tr>
                    <td>Nombres:</td>
                    <td><input type="text" name="nombre"><br><td>
                </tr>
                <tr>
                    <td>Apellidos:</td>
                    <td><input type="text" name="apellido"><br></td>
                </tr>
                <tr>
                    <td>Edad:</td>
                    <td><input type="text" name="edad"><br></td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><input type="text" name="email"><br></td>
                </tr>
                <tr>
                    <td><br>Sexo:<br></td>
                    <td>
                        <select name="sexo" multiple size="2">
                            <option value="Masculino">Masculino</option>
                            <option value="Femenino">Femenino</option>
                        </select><br><br>
                    </td>
                </tr>
                <tr>
                    <td>
                        <br><br><input type="submit" name="Enviar Datos" value="Enviar Datos"></td>
                </tr>
            </table>
        </div>
    </form>
    <marquee><b>ERICK STANLEY CRUZ MARTINEZ - TPI 2012</b></marquee>
</body>
</html>
