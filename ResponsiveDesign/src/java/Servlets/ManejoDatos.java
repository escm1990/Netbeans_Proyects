/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USUARIO
 */
public class ManejoDatos extends HttpServlet {

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
            out.println("<style type='text/css'>body "
                    + "{background: #4ef562; color: #fff;font: 16px/1.8 sans-serif;}"
                    + ".container {width: 84%;margin:0 auto;max-width:1140px;}"
                    + "header {	width: 100%;margin:0px auto;}"
                    + "h1 {background: rgba(0,0,0,0.2);text-align: center;color:#fff;font: 100px/1 'Impact';"
                    + "text-transform: uppercase;display: block;text-shadow:#253e45 -1px 1px 0,#253e45 -2px 2px 0,"
                    + "#d45848 -3px 3px 0,#d45848 -4px 4px 0;margin: 5% auto 5%;}</style>");
            out.println("</head>");
            out.println("<body>");
            evaluarEdad(request, response);
            out.println("<script src='http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js'></script>"
                    + "<script src='jquery.fittext.js'></script>"
                    + "<script type='text/javascript'>"
                    + "	$('#fittext1').fitText();"
                    + "$('#fittext2').fitText(1.2);"
                    + "$('#fittext3').fitText(1.1, { minFontSize: 50, maxFontSize: '75px' });</script>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    public void evaluarEdad(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        int edad = Integer.parseInt(request.getParameter("edad"));
        if (edad >= 18) {
            out.println("<div class='container'>");
            out.println("<h1 id='fittext1'>");
            out.println("Tu edad es " + request.getParameter("edad") 
                    +" años, por lo tanto eres Mayor de Edad");
            out.println("</h1>");
            out.println("</div>");
        } else {
            out.println("<div class='container'>");
            out.println("<h1 id='fittext2'>");
            out.println("Tu edad es " + request.getParameter("edad") 
                    +" años, por lo tanto eres Menor de Edad");
            out.println("</h1>");
            out.println("</div>");
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
