/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package reglas_negocio;
import java.sql.*;
/**
 *
 * @author p-rico
 */
public class catalogo_alumnos
{
    private conexion con =new conexion();
    public String error;
    public boolean agregar(alumno alum)
    {
        boolean res=false;
        try
        {
            int rows_updated = 0;
            PreparedStatement stmt1 = con.conectar().prepareStatement("INSERT INTO alumno (Carnet,Nombres,Apellidos) VALUES  (?,?,?)");
            stmt1.setString(1, alum.Carnet);
            stmt1.setString(2, alum.Nombres);
            stmt1.setString(3, alum.Apellidos);
            rows_updated = stmt1.executeUpdate();
            if (rows_updated==1)
            {
                res=true;
            }
            else
            {
                error="No se pudo agregar el alumno, favor verificar datos!!!!";
                res=false;
            }
            con.desconectar();
        } catch (SQLException ex) {
            error=ex.getMessage();
        }
        return res;
    }
}
