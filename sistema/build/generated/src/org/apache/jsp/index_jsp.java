package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");

if(request.getParameter("salir")!=null){ 
if(request.getParameter("salir").toString().equals("si")){
  session.invalidate();
  response.sendRedirect("index.jsp");
}
}else{ 

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\" />\r\n");
      out.write("<title></title>\r\n");
      out.write("<link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<script language=\"javascript\" src=\"js/jquery.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<link href=\"css/efectos.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<div id=\"baner\">\r\n");
      out.write("  <div align=\"center\"><img src=\"images/baner.jpg\" /></div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div id=\"menu\">\r\n");
      out.write("   ");

 if(session.getAttribute("admin")!=null){
    
      out.write("   \r\n");
      out.write("  <ul>\r\n");
      out.write("    <li><a href=\"index.jsp\" title=\"\">Inicio</a></li>\r\n");
      out.write("    <li><a href=\"index.jsp?pag=usuarios.jsp\" title=\"\">Usuarios</a></li>\r\n");
      out.write("    <li><a href=\"index.jsp?pag=empresas.jsp\" title=\"\">Empresas</a></li>\r\n");
      out.write("    <li><a href=\"index.jsp?pag=estadisticas.jsp\" title=\"\">Estadisticas</a></li>\r\n");
      out.write("    <li><a href=\"index.php?pag=inventarios.php\" title=\"\">Chat</a></li>\r\n");
      out.write("\t<li><a href=\"index.jsp?salir=si\" title=\"\">Salir [x]</a></li>\r\n");
      out.write("  </ul> \r\n");
      out.write("    ");
 } 
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write(" \r\n");
      out.write("<div id=\"body\">\r\n");
      out.write("</div>\r\n");
      out.write("<div id=\"centro\">\r\n");
      out.write("<div align=\"center\">\r\n");
      out.write("    ");
   
       String pag = null;
       pag = request.getParameter("pag");    
       if(pag==null){
       pag="inicio.jsp";                                     
       }else{
       if(session.getAttribute("admin")==null){
        if(pag==null){
           pag="bienvenido.jsp";
       }   
        }
       }
      
      out.write("\r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, pag, out, true);
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("    \r\n");
      out.write("</div>\r\n");
      out.write("<div id=\"derecha\">\r\n");
      out.write("    ");
   
        String log = null;       
       if(session.getAttribute("admin")==null){
       log="login.jsp";                                     
       }else{
           log="perfil.jsp";
       }   
 
      out.write("\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, log, out, true);
      out.write("\r\n");
      out.write("    \r\n");
      out.write("</div>\r\n");
      out.write("\t\r\n");
      out.write("</div>\r\n");
      out.write("<div id=\"footer\">\r\n");
      out.write("<div id=\"copyright\">&copy; JSP - Confisco tus Bienes, S.A de C.V </div>\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");

} 

    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
