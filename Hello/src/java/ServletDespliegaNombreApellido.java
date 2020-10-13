/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rayalam
 */
public class ServletDespliegaNombreApellido extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Datos del Cliente</title>");  
            out.println("</head>");
            out.println("<body> <ul>");
            out.println("<i>Nombre:"+request.getParameter("nombre") +"</i><br>");
            out.println("<i>Apellido:"+request.getParameter("apellido") +"</i><br>");
            out.println("<i>Edad:"+request.getParameter("edad") +"</i><br>");
            out.println("<i>Email:"+request.getParameter("email") +"</i></ul><br>");
String [] valores=request.getParameterValues("departamento");
int i=0;
out.print("Departamento:");
if (valores!=null)
 for(i=0;i<=valores.length-2;i++)
     out.print(valores[i]+",");
     out.print(valores[i]);

    
String [] lenguajes=request.getParameterValues("lenguajes");
out.print("<br>lenguajes:");
if (valores!=null)
 for(i=0;i<=lenguajes.length-2;i++)
     out.print(lenguajes[i]+",");
     out.print(lenguajes[i]);
     
     
            out.println("</body>");
            out.println("</html>");
          } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
