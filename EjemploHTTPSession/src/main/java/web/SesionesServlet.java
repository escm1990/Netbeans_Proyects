package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SesionesServlet")
public class SesionesServlet extends  HttpServlet{
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession sesion = request.getSession();
        String titulo = null;
        
        //Pedir atributo contadorVisitas a la sesion
        Integer contadorVisitas = (Integer) sesion.getAttribute("contadorVisitas");
        if(contadorVisitas == null){
            contadorVisitas = 1;
            titulo = "Bienvenido por primera vez";
        } else{
            contadorVisitas++;
            titulo = "Bienvenido nuevamente";
        }
        
        // Agregamos el nuevo valor a la sesión
        sesion.setAttribute("contadorVisitas", contadorVisitas);
        
        //Devolver informacion al cliente
        PrintWriter out = response.getWriter();
        out.print("no. accesos al recurso: "+contadorVisitas);
        out.append("<br/>");
        out.print("ID de la sesion: "+ sesion.getId());
        out.close();
    }
    
}
