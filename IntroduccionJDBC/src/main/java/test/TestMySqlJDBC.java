package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestMySqlJDBC {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(url,"root","admin");
            Statement instruccion = conexion.createStatement();
            var sql = "SELECT  id_persona, nombre, apellido, email, telefono FROM persona";
            ResultSet resultado = instruccion.executeQuery(sql);
                while(resultado.next()){
                    // se puede acceder por el indice o por el nombre de la columna
                    System.out.print("Id Persona: "+resultado.getInt(1));
                    System.out.print(" Nombre: "+resultado.getString(2));
                    System.out.print(" Apellido: "+resultado.getString("apellido"));
                    System.out.print(" Email: "+resultado.getString("email")); 
                    System.out.print(" Telefono: "+resultado.getString(5));
                    System.out.println("");
                }
            resultado.close();
            instruccion.close();
            conexion.close();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
