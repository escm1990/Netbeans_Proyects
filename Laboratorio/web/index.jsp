<%-- 
    Document   : index
    Created on : 03-28-2012, 05:30:53 PM
    Author     : Erick Cruz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style type="text/css">
            input.error{
                background-color: red;
                border:  3px solid red;
            }
        </style>
        <script type="text/javascript">
            function validar (elemento){
                if(elemento.value != ""){
                    var dato = elemento.value;
                    if(isNaN(dato)){
                        elemento.className = 'error';
                        alert("Error! Introduzca Datos Numéricos");
                    }else{
                        elemento.className = '';
                    }
                }
            } 
        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ecuaciones</title>
    </head>
    <body>
        <h1>Ecuaciones by Erick Cruz</h1>
        <form name="form1" method="post" action="ServletLab">
            <input type="text" name="A" required onblur="validar(this)">X^2 + <input type="text" name="B" required onblur="validar(this)">X + <input type="text" name="C" required onblur="validar(this)"> = 0
            <input type="submit" value="Aceptar">
        </form>
    </body>
</html>
