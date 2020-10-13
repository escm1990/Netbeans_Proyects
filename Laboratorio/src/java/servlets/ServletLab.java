package servlets;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import clases.cuadratica;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pc19
 */
public class ServletLab extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /*
             * TODO output your page here. You may use following sample code.
             */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>SEVLET</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("A = " + request.getParameter("A"));
            out.println("<br>");
            out.println("B = " + request.getParameter("B"));
            out.println("<br>");
            out.println("C = " + request.getParameter("C"));
            out.println("<br>");
            out.println("<br>");
            out.println(request.getParameter("A") + "X² + " + request.getParameter("B") + "X + " + request.getParameter("C") + "= 0");
            out.println("<br>");
            resolver(request, response);
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    public void resolver(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        double A = Double.parseDouble(request.getParameter("A"));
        double B = Double.parseDouble(request.getParameter("B"));
        double C = Double.parseDouble(request.getParameter("C"));
        cuadratica cu = new cuadratica(A, B, C);

        double comp = Math.pow(B, 2) - (4) * (A) * (C);
        if (comp > 0) {
            double X1 = cu.calcularX1();
            double X2 = cu.calcularX2();
            out.println("<br>");
            out.println("X1 = " + X1);
            out.println("<br>");
            out.println("X2 = " + X2);
            X1 = cu.borrarX();
            X2 = cu.borrarX();
        } else {
            out.println("<br>");
            out.println("IMPOSIBLE EFECTUAR!!!!");
            
        }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
