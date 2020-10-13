/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladoresRatios;

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
public class ServletEndeudamientoCorto extends HttpServlet {

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
        operacionesRatios op = new operacionesRatios();
        RazonesAplacamiento R_aplacamiento = new RazonesAplacamiento();
        try {

            double pasivoCirculante = op.totalValor(21, 2);
            double totalActivos = op.totalValor(1, 0);
            double endeudamientoCorto = R_aplacamiento.endeudamientoCorto(pasivoCirculante, totalActivos);
            endeudamientoCorto = endeudamientoCorto * 100;
            endeudamientoCorto = Math.rint(endeudamientoCorto);
            endeudamientoCorto = endeudamientoCorto / 100;
            out.println("<html><body><h3>Razon de Endeudamiento a Corto Plazo</h3><p>Endeudamiento a Corto Plazo de la Empresa : " + endeudamientoCorto + "</p></body></html>");
            
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
