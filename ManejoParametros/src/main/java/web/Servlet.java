package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        //Leer los parámetros del formulario HTML
        String usuario =  request.getParameter("usuario");
        String password = request.getParameter("password");
        System.out.println("Usuario: "+usuario);
        System.out.println("Password: "+password);
        
        //Imprimir respuesta
        PrintWriter out = response.getWriter();
        out.print("<html>");
        out.print("<body>");
        out.print("El parametro usuario es: "+usuario);
        out.print("<br/>");
        out.print("El parametro password es: "+password);
        out.print("</body>");
        out.print("</html>");
        out.close();
    }
}
