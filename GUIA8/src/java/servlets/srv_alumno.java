/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import reglas_negocio.alumno;
import reglas_negocio.alumno;
import reglas_negocio.catalogo_alumnos;
import reglas_negocio.catalogo_alumnos;

/**
 *
 * @author USUARIO
 */
public class srv_alumno extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset-UTF-8");
        PrintWriter out = response.getWriter();
        String nom,car,apell;
        try {
            catalogo_alumnos obj = new catalogo_alumnos();
            car=request.getParameter("car");
            nom=request.getParameter("nomb");
            apell=request.getParameter("apell");
            alumno alu = new alumno(car, nom, apell);
            if(obj.agregar(alu)){
                out.println("<html><head><title>SERVLET GUIA 8</title></head><body><br><h1>ALUMNO AGREGADO SATISFACTORIAMENTE</h1></body></html>");
            }else{
             out.println("<html><head><title>SERVLET GUIA 8</title></head><body><br><h1>ERROR MORTAL: "+obj.error+"</h1></body></html>");
            }
        } finally {
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
