package clases;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import net.sf.jasperreports.view.save.JRPdfSaveContributor.*;
import net.sf.jasperreports.view.JRViewer.*;
import net.sf.jasperreports.view.save.JRMultipleSheetsXlsSaveContributor.*;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author USUARIO
 */
public class IniciarReporte {

    Connection conn = null;

    public IniciarReporte() {
        try {
            Class.forName("com.mysql.jdbc.Driver"); //se carga el driver
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/reporte", "root", "admin");
            System.out.println("Conexión establecida exitosamente");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Se inicia la clase que ejecutara el reporte y se carga el archivo
    public void runReporte(String carnet) {


        try {
            String ruta = System.getProperty("user.dir") + "\\src\\reportes\\Reporte.jasper";
            System.out.println("Cargando desde: " + ruta);
            if (ruta == null) {
                System.out.println("No se encuentra el archivo.");
                System.exit(2);
            }

            JasperReport masterReport = null;
            try {
                masterReport = (JasperReport) JRLoader.loadObject(ruta);
            } catch (JRException e) {
                System.out.println("Error cargando el reporte maestro: " + e.getMessage());
                System.exit(3);
            }

            //Se pueden agregar más parámetros basta con poner mas parametro.put
            Map parametro = new HashMap();
            parametro.put("Carnet", carnet);

            //Reporte diseñado y compilado con iReport
            JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport, parametro, conn);

            //Se lanza el Viewer de Jasper, no termina aplicación al salir
            JasperViewer jviewer = new JasperViewer(jasperPrint, false);
            jviewer.setTitle("Geniz -Reporte");
            jviewer.setVisible(true);
        } catch (Exception j) {
            System.out.println("Mensaje de Error:" + j.getMessage());

        }
    }

    public void cerrar() {
        try {
            conn.close();
            System.out.println("Finalizón la conexion");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
