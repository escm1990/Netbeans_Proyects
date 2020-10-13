/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package progra3_db;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author pc06
 */
public class Conexion {

    Connection conexion = null;

    public Connection conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/bd_progra3", "root", "");
//            JOptionPane.showMessageDialog(null, "Conectado satisfactoriamente");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return conexion;
    }

    public void desconectar(){
        try{
            conexion.close();
//            JOptionPane.showMessageDialog(null, "Desconectado satisfactoriamente");
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
}
