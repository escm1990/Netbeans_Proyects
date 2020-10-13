package paquete;


/**
 *
 * @author Arturo Ernesto Salinas Rodríguez
 * @version 1.0
 * © 2011 Todos los derechos reservados
 */
import java.sql.*;
import javax.swing.JOptionPane;

public class Conexion
{
    Connection conexion=null;
    /**
     *
     * @return método que permite la conexión a la base de datos
     */
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
                conexion = DriverManager.getConnection("jdbc:mysql://localhost/hdp_bd", "root", "");

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
