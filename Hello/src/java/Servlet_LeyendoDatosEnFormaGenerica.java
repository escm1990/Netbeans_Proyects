/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rayalam
 */
public class Servlet_LeyendoDatosEnFormaGenerica extends HttpServlet {

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
            out.println("<title>Leyendo Datos En Forma Generica</title>");  
            out.println("</head>");
            out.println("<body bgcolor=\"#fdf5e6\" b><table border=1 align=center");
            out.println("<tr bgcolor=\"#ffad00\"><th>nombre del parametro</th><th>valor</th></tr>");
            out.println("<tr>");
            
            Enumeration nombreps = request.getParameterNames();
            while (nombreps.hasMoreElements()){
            String nombrep= (String)nombreps.nextElement();
            out.println("<td>"+nombrep +"</td><td>");
            String [] valores=request.getParameterValues(nombrep);
            out.println("<ul>");
            out.println(valores.length);
            if (valores!=null)
            {    
            for(int i=0;i<=valores.length-1;i++)
            out.println("<li>"+valores[i]+"</li>");
            out.println("</td></tr></ul>");
            }
            else
            out.println("<li>sin valor</li></li>");
            }
            
            
            
            out.println("</table></body>");
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
