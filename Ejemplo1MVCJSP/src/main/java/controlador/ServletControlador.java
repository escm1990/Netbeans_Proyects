package controlador;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Rectangulo;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. PROCESAMIENTO DE PARAMETROS (en este ejemplo no se usa)

        // 2. CREAMOS LOS JAVABEANS
        Rectangulo rec = new Rectangulo(3, 6);

        // 3. Agregar el javabeans a algún alcance
        request.setAttribute("mensaje", "Saludos desde el Servlet"); //alcance request
        HttpSession session = request.getSession();
        session.setAttribute("rectangulo", rec); //alcance session

        // 4. REDIRECCIONAR A LA VISTA SELECCIONADA
        RequestDispatcher rd = request.getRequestDispatcher("vista/desplegarVariables.jsp");
        rd.forward(request, response); //propagar los objetos request y response a la vista
    }

}
