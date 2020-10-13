package accesoDatos;

import java.sql.*;
import javax.swing.*;

public class Conexion {

    Connection conexion = null;
    int puerto1 = 49205; //Orellana
    int puerto2 = 1433; //Cruz
    int puerto3 = 1433; //Chavez49180

    public Connection conectar() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        } catch (Exception msj) {
            JOptionPane.showMessageDialog(null, msj.getMessage());
        }
        try {           //usuario y contra!!
            conexion = DriverManager.getConnection("jdbc:sqlserver://localhost:" + puerto2 + ";user=BLH;password=BLH; databaseName = BLHBD");
//        conexion = DriverManager.getConnection("jdbc:sqlserver://localhost:"+puerto2+";databaseName=BLHBD;integratedSecurity=true;");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return conexion;
    }

    public void desconectar() {
        try {
            conexion.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
}
