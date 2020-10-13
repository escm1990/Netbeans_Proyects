<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*;" %>
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

 Connection con = null;
 //si ya fue presionado el boton
      //recuperar los valores del formulario
String id = request.getParameter("id");
String url="jdbc:postgresql://localhost/sistema";
try{
     Class.forName("org.postgresql.Driver");
    con = DriverManager.getConnection(url,"postgres","admin");
    if(con!=null){
               Statement comando = con.createStatement(); 
                      
         int a = 0;   
        a = comando.executeUpdate("delete from estados4 where id_estado='"+id+"'");
        if(a>=1){ %>
           <script>alert('Registro Eliminado');location.href='index.jsp?pag=estados.jsp';</script>
      <%  }else{ %>
            <script>alert('Error al Eliminar');location.href='index.jsp?pag=estados.jsp';</script>
       <% }
        }
        
}catch(SQLException ex){
    out.print("ex");
}catch(ClassNotFoundException ex){
    out.print("ex");

} 
  
%>