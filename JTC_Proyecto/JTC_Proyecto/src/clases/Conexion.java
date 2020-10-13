/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 * Con esta clase nos conectamos
 * directamente a la base de datos.
 * @author USUARIO
 */
public class Conexion {

    Connection conexion = null;

    /**
     * Método que se conecta a
     * la base de datos.
     * @return
     */
    public Connection conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/examenes_bd", "root", "admin");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return conexion;
    }

    /**
     * Metodo para desconectarnos
     * de la base de datos.
     */
    public void desconectar() {
        try {
            conexion.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
}