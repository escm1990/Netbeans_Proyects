<%
String usuario = "";
HttpSession sesion = request.getSession();
if (sesion.getAttribute("admin") == null) {
%>
 <script>
 alert("Es necesario identificarse")
 location.href="index.jsp";     
 </script>
<%
} else {
usuario = (String)sesion.getAttribute("admin");
}
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<% 
  Connection con = null;
 //si ya fue presionado el boton
      //recuperar los valores del formulario
String id = request.getParameter("id");
String usu = request.getParameter("usuario");
String cla = request.getParameter("clave");
String url="jdbc:postgresql://localhost/sistema";
try{
     Class.forName("org.postgresql.Driver");
    con = DriverManager.getConnection(url,"postgres","admin");
    if(con!=null){
               Statement comando = con.createStatement();                       
         int a = 0;   
        a = comando.executeUpdate("update usuarios set usuario='"+usu+"',clave='"+cla+"' where id_usuario='"+id+"'");
        if(a>=1){ 
           out.print("<script>alert('Usuario Modificado');location.href='index.jsp?pag=consultar_usuarios.jsp';</script>");
        }else{ 
           out.print("<script>alert('Error al Modificado');location.href='index.jsp?pag=consultar_usuarios.jsp';</script>");
       }
        }
        
}catch(SQLException ex){
    out.print("error sql");
}catch(ClassNotFoundException ex){
    out.print("error ex");

} 

  
%>
