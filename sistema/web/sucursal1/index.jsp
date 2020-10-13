<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%
if(request.getParameter("salir")!=null){ 
if(request.getParameter("salir").toString().equals("si")){
  session.invalidate();
  response.sendRedirect("index.jsp");
}
}else{ 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title></title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="js/jquery.js"></script>

<link href="css/efectos.css" rel="stylesheet" type="text/css" />
</head>

<body>

<div id="baner">
  <div align="center"><img src="images/baner.jpg" /></div>
</div>

<div id="menu">
   <%
 if(session.getAttribute("admin")!=null){
    %>   
  <ul>
    <li><a href="index.jsp" title="">Inicio</a></li>
    <li><a href="index.jsp?pag=usuarios.jsp" title="">Usuarios</a></li>
    <li><a href="index.jsp?pag=empresas.jsp" title="">Empresas</a></li>
    <li><a href="index.jsp?pag=estadisticas.jsp" title="">Estadisticas</a></li>
    <li><a href="index.jsp" title="">Chat</a></li>
	<li><a href="index.jsp?salir=si" title="">Salir [x]</a></li>
  </ul> 
    <% } %>
</div>
 
<div id="body">
</div>
<div id="centro">
<div align="center">
    <%   
       String pag = null;
       pag = request.getParameter("pag");    
       if(pag==null){
       pag="inicio.jsp";                                     
       }else{
       if(session.getAttribute("admin")==null){
        if(pag==null){
           pag="bienvenido.jsp";
       }   
        }
       }
      %>
    <jsp:include page="<%=pag%>" flush="true" />
	</div>
    
</div>
<div id="derecha">
    <%   
        String log = null;       
       if(session.getAttribute("admin")==null){
       log="login.jsp";                                     
       }else{
           log="perfil.jsp";
       }   
 %>
	<jsp:include page="<%=log%>" flush="true" />
    
</div>
	

<div id="footer">
<div id="copyright">&copy; JSP - Confisco tus Bienes, S.A de C.V </div>

</div>
</body>
</html>
<%
} 
%>