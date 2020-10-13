/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reglas_negocios;

import java.sql.*;

/**
 *
 * @author p-rico
 */
public class catalogo_usuario {

    private conexion con = new conexion();
    public String error;

    public boolean agregar(usuario usu) {
        boolean res = false;
        try {
            Statement sentencia = null;
            ResultSet resultado = null;
            sentencia = con.conectar().createStatement();

            resultado = sentencia.executeQuery("SELECT * FROM usuario WHERE Usuario='" + usu.Usuario + "'");
            resultado.last();
            if (resultado.getRow() <= 0) {
            } else {
                String usuar = resultado.getString("Usuario");
                String pass = resultado.getString("Pass");
                if((usuar.equals(usu.Usuario))&&(pass.equals(usu.Pass))){
                    res=true;
                }
                    
            }
            con.desconectar();
        } catch (SQLException ex) {
            error = ex.getMessage();
        }
        return res;
    }
}
