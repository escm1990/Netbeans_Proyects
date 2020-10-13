/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author P-RICO
 */
import java.sql.*;
import javax.swing.JOptionPane;
public class conexion
{
    Connection conexion=null;
    public Connection conectar()
    {
           try
           {
                Class.forName("com.mysql.jdbc.Driver");
           }
           catch (Exception ex)
           {
                JOptionPane.showMessageDialog(null, ex.getMessage());
           }
            try
            {
                conexion = DriverManager.getConnection("jdbc:mysql://localhost/bd_progra3", "root", "admin");
                //JOptionPane.showMessageDialog(null, "Conectado satisfactoriamente");
               /**esta linea podria variar si han puesto un nombre diferente a la base d datos
                o si han puesto otra contraseña, pero si lo hicieron como se los habia propuest
                no habra problem, e segundo parametro es el usuario y el tercero es la pass*/
            }
            catch (SQLException ex)
            {
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
