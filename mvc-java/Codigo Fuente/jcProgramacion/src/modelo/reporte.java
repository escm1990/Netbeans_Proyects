package modelo;
import java.net.URL;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
/**
 * @web http://www.jc-mouse.net/
 * @author Mouse
 */
public class reporte {

    private Connection conn = null;
//___________________________________________________________________________________ Soy una barra separadora :)
    public reporte(Connection conn)
    {
        this.conn = conn;
    }
//___________________________________________________________________________________ Soy una barra separadora :)
/* IMPRIME LA PROGRAMACION UTILIZANDO LAS LIBRERIAS DE IREPORT
 */
    public void ver_reporte(String CU, String CI, String Nombre, String Matricula){
     JasperReport reporte;
     JasperPrint reporte_view;
     try{
         //direccion del archivo JASPER
          URL  in = this.getClass().getResource("/vista/reporte/jcMatricula.jasper");
          reporte = (JasperReport) JRLoader.loadObject( in );
          //Se crea un objeto HashMap
          Map <String,String> parametros = new HashMap<String,String>();
          parametros.clear();
          //parametros de entrada
          parametros.put( "pCU", CU );
          parametros.put( "pCI", CI );
          parametros.put( "pNombre", Nombre );
          parametros.put( "pNumMatricula", Matricula );
          //-----------------------------------
          reporte_view= JasperFillManager.fillReport( reporte, parametros, conn );
          JasperViewer.viewReport( reporte_view , false );
	  }catch (JRException e){}
    }
//___________________________________________________________________________________ Soy una barra separadora :)
}
