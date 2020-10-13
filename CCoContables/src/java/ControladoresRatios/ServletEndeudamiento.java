/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladoresRatios;

import Modelos.Operaciones;
import Modelos.operacionesRatios;
import Ratios.RazonesAplacamiento;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Chavez Vigil
 */
public class ServletEndeudamiento extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        RazonesAplacamiento R_Aplacamiento = new RazonesAplacamiento();
        operacionesRatios op = new operacionesRatios();
        try {
            double totalActivo = op.totalValor(1, 0);
            double totalPasivo = op.totalValor(2, 0);
            double endeudamiento = R_Aplacamiento.endeudamiento(totalPasivo, totalActivo);
            endeudamiento = endeudamiento * 100;
            endeudamiento = Math.rint(endeudamiento);
            endeudamiento = endeudamiento / 100;
            out.println("<html><body><h3>Razon de Endeudamiento</h3><p>Endeudamiento de la Empresa : " + endeudamiento + "</p></body></html>");

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
