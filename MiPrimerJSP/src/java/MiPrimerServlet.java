/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USUARIO
 */
public class MiPrimerServlet extends HttpServlet {

    @Override
    public void init(ServletConfig conf) throws ServletException{
        super.init(conf);
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
            out.println("<html>");
            out.println("<head>");
            out.println("<title>MiPrimerServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>¿COMO ESTAS?</h1>");
            out.println("</body>");
            out.println("</html>");
    }

}
