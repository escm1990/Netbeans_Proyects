<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSTL Core</title>
    </head>
    <body>
        <h1>JSTL Core</h1>
        <!-- Manipulacion de variables -->
        <c:set var="nombre" value="Ernesto"/>
        Variable nombre: <c:out value="${nombre}" />
        <br>
        <br>
        Variable con HTML
        <c:out value="<h4>HOLA</h4>" escapeXml="false"/>
        <br>
        <br>
        <!-- Codigo condicionado con IF -->
        <c:set var="bandera" value="true" />
        <c:if test="${bandera}">
            La bandera es verdadera
        </c:if>
        <br>
        <br>
        <!-- Codigo condicionado con switch -->
        <c:if test="${param.opcion!=null}">
            <c:choose>
                <c:when test="${param.opcion == 1}">Opcion 1 seleccionada</c:when>
                <c:when test="${param.opcion == 2}">Opcion 2 seleccionada</c:when>
                <c:otherwise>Opcion ${param.opcion} desconocida</c:otherwise>
            </c:choose>
        </c:if> 
        <br>
        <br>
        <!-- Iteracion de un arreglo -->
        <%
            String nombres[] = {"Clauida","Pedro","Juan"};
            request.setAttribute("nombres",nombres);
        %>
        <br>
        Lista de nombres
        <br>
        <ul>
            <c:forEach var="persona" items="${nombres}">
                <li>Nombre: ${persona}</li>
            </c:forEach>
        </ul>
    </body>
</html>
