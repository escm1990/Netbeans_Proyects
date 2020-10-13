/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package reglas_negocios;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author p-rico
 */
public class conexion
{
     Connection conexion=null;
     public Connection conectar(){

                try {
                    Class.forName("com.mysql.jdbc.Driver");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
                try {

                    conexion = DriverManager.getConnection("jdbc:mysql://localhost/hdp_bd", "root", "");


                }
                catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
             return conexion;

        }
     public void desconectar()
     {
            try
            {
                conexion.close();
            }

            catch (SQLException ex)
            {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
     }

}
