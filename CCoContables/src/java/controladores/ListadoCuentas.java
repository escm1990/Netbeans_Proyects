/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import Modelos.Operaciones;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JTable;

/**
 *
 * @author Chavez Vigil
 */
public class ListadoCuentas extends HttpServlet {

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
            JTable tabla = new JTable();
            Operaciones op = new Operaciones();
            op.listarCatalogo(tabla);
            double monto = op.sumarCuenta(11);
            out.println("<html>");
            out.println("<head>");
            out.println("<title></title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<p><h3>CATÁLOGO DE CUENTAS</h3></p><br>");
            out.println("<form method='post' action=''id='frm'>");
            out.println("<table border = 1>");
            out.println("<tr><td>ID</td><td>NOMBRE</td><td>VALOR $</td><td>UTILIZAR</td><tr>");
            for (int i = 0; i < tabla.getRowCount(); i++) {
                out.println("<tr>");
                for (int j = 0; j < tabla.getColumnCount(); j++) {
                    out.println("<td>" + tabla.getValueAt(i, j) + "</td>");
                    if (i == 5 && j == 3) {
                        tabla.setValueAt(monto, 5, 3);
                    }
                }
                out.println("<td><input type ='checkbox' name = ''></td></tr>");
            }
            out.println("<tr><td><input type = 'submit' name = enviar value = Enviar></td></tr>");
            out.println("</table>");
            out.println("</form>");
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
