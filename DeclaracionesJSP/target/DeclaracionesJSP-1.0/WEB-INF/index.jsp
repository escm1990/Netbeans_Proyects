<%-- Agregamos una declaracion de JSP --%>
<%! 
//Declaracion de variable con método get
private String usuario = "Alberto";

public String getUsuario(){
    return this.usuario;
}

//Declaracion de un contador de visitas
private int contadorVisitas = 1;
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Uso de declaraciones JSP</title>
    </head>
    <body>
        <h1>Uso de declaraciones JSP</h1>
        Valor de usuario por medio del atributo: <%= this.usuario %>
        <br>
        Valor del usuario por medio del metodo: <%= this.getUsuario() %>
        <br>
        Contador de visitas: <%=contadorVisitas++%>
    </body>
</html>
