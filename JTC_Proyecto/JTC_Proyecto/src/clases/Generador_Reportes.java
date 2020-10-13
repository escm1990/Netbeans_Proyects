/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 * Importaciones necesarias para la
 * clase Generador_Reportes
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.*;

/**
 * Clase que permite generar
 * los parciales.
 * @author USUARIO
 */
public class Generador_Reportes extends Conexion {

    private Connection conn;
    private final String login = "root"; //usuario de acceso a MySQL
    private final String password = "admin"; //contraseña de usuario
    private String url = "jdbc:mysql://localhost/examenes_bd";

    /**
     * Genera un reporte conectándose
     * a la base de datos.
     */
    public Generador_Reportes() {
        try {
            Class.forName("com.mysql.jdbc.Driver"); //se carga el driver
            conn = DriverManager.getConnection(url, login, password);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Método que recibe como parámetros el código de parcial
     * y la dirección del reporte a mostrar.
     * @param cod_parcial
     * @param direccion
     * @param urlimagen 
     */
    public void runReporte(String cod_parcial, String direccion, String urlimagen) {

        try {
            String rutaimagen = urlimagen;
            String viewer = direccion;
            System.out.println("Leyendo archivo de: " + viewer);
            System.out.println("Leyendo imagen de: " + rutaimagen);
            if (viewer == null) {
                System.out.println("No encuentro hay vista previa disponible.");
                System.exit(2);
            }

            JasperReport preview = null;
            try {
                System.out.println("Si entra en esta parte");
                preview = (JasperReport) JRLoader.loadObject(viewer);
            } catch (JRException e) {
                System.out.println("Error cargando la vista previa: " + e.getMessage());
                System.exit(3);
            }

            //Este es el parámetro, se pueden agregar más parámetros basta con poner mas parametro.put
            Map parametro = new HashMap();
            parametro.put("cod", cod_parcial);
            parametro.put("rutaImagen", rutaimagen);

            //Reporte diseñado y compilado con iReport
            JasperPrint jasperPrint = JasperFillManager.fillReport(preview, parametro, conn);

            //Se lanza el Viewer de Jasper, no termina aplicación al salir
            JasperViewer jviewer = new JasperViewer(jasperPrint, false);
            jviewer.setTitle("Vista Previa del Parcial");
            jviewer.setVisible(true);
        } catch (Exception j) {
            System.out.println("Mensaje de Error: " + j.getMessage());
        }
    }
}