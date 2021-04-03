package mx.com.gm.web;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.com.gm.domain.Persona;
import mx.com.gm.servicio.PersonaService;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        //recuperar la instancia de la capa de datos
        PersonaService personaService = new PersonaService();
        List<Persona> personas = personaService.listarPersonas();
        //definiendo la variable en un alcance, para que sea accesible desde el jsp
        request.setAttribute("personas", personas);
        try {
            //redireccionar al jsp
            request.getRequestDispatcher("/WEB-INF/listado.jsp").forward(request, response);
        } catch (ServletException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
}
