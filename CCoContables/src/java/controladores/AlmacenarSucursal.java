/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import Clases.Empresa;
import Clases.Encargado;
import Modelos.Operaciones;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author Chavez Vigil
 */
public class AlmacenarSucursal extends HttpServlet {

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
        Operaciones op = new Operaciones();
        Encargado encargado;
        Empresa empresa;
        
        String nombreEncargado, apellido, email, pass, passRepit, direccion, telefono, nombreEmpresa, fechaNac;

        try {
            nombreEncargado = request.getParameter("nom_enc");
            apellido = request.getParameter("ape_enc");
            email = request.getParameter("usuario");
            pass = request.getParameter("password");
            passRepit = request.getParameter("repitPass");
            direccion = request.getParameter("direccion");
            telefono = request.getParameter("tel");
            nombreEmpresa = request.getParameter("nombreEmpresa");
            fechaNac = request.getParameter("fec_enc");
            encargado = new Encargado(nombreEncargado, apellido, fechaNac,telefono);
            empresa = new Empresa(nombreEmpresa, email, pass, passRepit, direccion);
            
            if(pass.equals(passRepit)){
                op.agregarEmpresaUsuario(empresa, encargado);
            }else{
                JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
            }
           
        } catch (Exception e) {
            System.out.println(e.getMessage());
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
