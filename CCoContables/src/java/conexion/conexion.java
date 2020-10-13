/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.*;
import javax.swing.*;

public class conexion {
    private String password="admin";
    private String usuario="root";
    private String direccionServidor="localhost";
    private String nombreBaseDatos="ccocontables";
    private Connection conexion = null;
    
    public Connection conectar(){
      try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (Exception msj) {
            JOptionPane.showMessageDialog(null, msj.getMessage());
        }
        try {
//           password = JOptionPane.showInputDialog("Pass?");
           conexion = DriverManager.getConnection("jdbc:mysql://"+direccionServidor +
                   "/"+nombreBaseDatos, usuario, password);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return conexion;
    }
    
    public void desconectar(){
        try{
            conexion.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }    
}