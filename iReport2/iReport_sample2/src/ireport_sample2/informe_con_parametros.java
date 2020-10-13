package ireport_sample2;
/* librerias de ireport*/
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
/**
*  @web http://jc-mouse.blogspot.com/
 * @author Mouse
 */
public class informe_con_parametros {
//se estable una conexion con la base de datos
    private conexion con = new conexion();    
    
    public informe_con_parametros(){
    }
    
     /* reporte sencillo con conexion a base de datos MySQL, 
      * el reporte cuenta con un parametro de entrada */    
     public void ver_informe_con_parametros(String parametro){         
     JasperReport reporte;
     JasperPrint reporte_view;     
     try{
         //direccion del archivo JASPER
          URL  in = this.getClass().getResource("jcReport_Sample1.jasper");
          reporte = (JasperReport) JRLoader.loadObject( in );     
          //Se crea un objeto HashMap
          Map <String,String> parametros = new HashMap<String,String>();             
          parametros.clear();     
          //el nombre que se dio al parametro en JasperReport fue "p1", y se debe llamar desde Java con
          //ese mismo nombre, a su lado se pasa el valor del parametro
          parametros.put( "p1", parametro );               
          //-----------------------------------
          reporte_view= JasperFillManager.fillReport( reporte, parametros, con.getConnection() );
          JasperViewer.viewReport( reporte_view ); 
          //terminamos la conexion a la base de datos
          con.desconectar();
	  }catch (JRException E){
	    E.printStackTrace();
          }
    }
}
