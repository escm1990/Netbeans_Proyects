
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Operaciones;

import accesoDatos.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;


/**
 *
 * @author
 */
public class OperacionesReportes {

    Conexion con = new Conexion();
    OperacionesDonantNinos opDN = new OperacionesDonantNinos();
    
    public void runReporte(String nombreReporte, String imagen) {
        try {

            String archivo = System.getProperty("user.dir");
            archivo = archivo + "/src/Reportes/" + nombreReporte + ".jasper";
            JasperReport masterReport = null;
            masterReport = (JasperReport) JRLoader.loadObject(archivo);

            Map parametro = new HashMap();
            parametro.put("banner",imagen);
            JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport, parametro, con.conectar());

            JasperViewer jviewer = new JasperViewer(jasperPrint, false);
            jviewer.setTitle("Visor de documentos");
            jviewer.setVisible(true);

        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
     public void runReportePaciente(String nombreReporte, String imagen, String car) {
        try {

            String archivo = System.getProperty("user.dir");
            archivo = archivo + "/src/reportes/" + nombreReporte + ".jasper";
            
            JasperReport masterReport = null;
            masterReport = (JasperReport) JRLoader.loadObject(archivo);
   
            String val = opDN.obtenerCarnetPaciente(car);
            
            Map parametro = new HashMap();
            parametro.put("banner",imagen);
            parametro.put("car",val);
            JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport, parametro, con.conectar());

            JasperViewer jviewer = new JasperViewer(jasperPrint, false);
            jviewer.setTitle("Visor de documentos");
            jviewer.setVisible(true);

        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
public void runReporteDonantes(String nombreReporte, String imagen, String car) {
        try {

            String archivo = System.getProperty("user.dir");
            archivo = archivo + "/src/reportes/" + nombreReporte + ".jasper";
            
            JasperReport masterReport = null;
            masterReport = (JasperReport) JRLoader.loadObject(archivo);
   
            String val = opDN.obtenerDocumentoDonante(car);
            
            Map parametro = new HashMap();
            parametro.put("banner",imagen);
            parametro.put("par",val);
            JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport, parametro, con.conectar());

            JasperViewer jviewer = new JasperViewer(jasperPrint, false);
            jviewer.setTitle("Visor de documentos");
            jviewer.setVisible(true);

        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public String getRuta() {
        String archivo = System.getProperty("user.dir");
        archivo = archivo + "\\src\\reportes\\banner.png";
        return archivo;
    }
}