/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Erick Cruz
 */
public class alumno extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Obteniendo valores de los elementos del formulario
        String name = request.getParameter("nombre");
        String carnet = request.getParameter("id");
        String ape = request.getParameter("apellido");
        String dir = request.getParameter("dir");
        String dto = request.getParameter("dep");
        String muni = request.getParameter("muni");
        String mail = request.getParameter("mail");
        String tel = request.getParameter("tel");

        //Creación de las Cookies
        Cookie cookie1 = new Cookie("Carnet", carnet);
        Cookie cookie2 = new Cookie("Nombre", name);
        Cookie cookie3 = new Cookie("Apellido", ape);
        Cookie cookie4 = new Cookie("Direccion", dir);
        Cookie cookie5 = new Cookie("Departamento", dto);
        Cookie cookie6 = new Cookie("Municipio", muni);
        Cookie cookie7 = new Cookie("E-Mail", mail);
        Cookie cookie8 = new Cookie("Telefono", tel);

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            //Creando Arreglos de Cookies para mostrar al Cliente
            Cookie[] arrayCookie = new Cookie[8];
            arrayCookie[0] = cookie1;
            arrayCookie[1] = cookie2;
            arrayCookie[2] = cookie3;
            arrayCookie[3] = cookie4;
            arrayCookie[4] = cookie5;
            arrayCookie[5] = cookie6;
            arrayCookie[6] = cookie7;
            arrayCookie[7] = cookie8;

            Cookie tem;

            //Inicio del Código HTML y dibujo de una tabla con las Cookies a mostrar
            out.println("<html><body><center><h1>COOKIES CREADAS</h1><table border=1>");
            
            //Llenando la tabla con el arreglo de Cookies
            for (int i = 0; i < arrayCookie.length; i++) {
                tem = arrayCookie[i];
                response.setContentType("text/html;charset=UTF-8");
                out.println("<tr><td>" + tem.getName() + "</td><td>" + tem.getValue() + "</td></tr>");
            }
            
            //Imprimiendo las Cookies concatenadas
            out.println("<tr><td>Cookie_1</td><td>" + cookie2.getValue() + " , " + cookie3.getValue() + "</td></tr>");
            out.println("<tr><td>Cookie_2</td><td>" + cookie4.getValue() + " , " + cookie5.getValue() + " , " + cookie6.getValue() + "</td></tr>");
            out.println("<tr><td>Cookie_3</td><td>" + cookie7.getValue() + " , " + cookie8.getValue() + "</td></tr>");
            
            //Fin del código HTML
            out.println("</table></center></body></html>");
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
