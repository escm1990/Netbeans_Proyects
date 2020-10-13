package jcmaccesscurso;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * @web http://jc-mouse.blogspot.com/
 * @author Mouse
 * CLASE QUE NOS PERMITE LA CONEXION A UNA BASE DE DATOS ACCESS
 */
public class Access_connection {
 //contraseña a la base de datos si es que tuviera, si no se deja vacio
   static String password = "";
   //nombre de la base de datos Acces con extension *.mdb o *.accdb
   static String dbName = "dbCurso.accdb";
   //direccion de la base de datos
   static String bd = System.getProperty("user.dir") + "\\" + dbName + ";PWD=" + password;
   //driver para base de datos Access 2000, 2003, 2007, 2010
   static String url = "jdbc:odbc:;DRIVER=Microsoft Access Driver (*.mdb, *.accdb);DBQ=" + bd;
   Connection conn = null;
   
   public Access_connection() {
      try{
         //obtenemos el driver para Access 
         Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
         //obtenemos la conexión         
         conn = DriverManager.getConnection(url);
         //si la conexion tuvo exito
         if (conn!=null){
            System.out.println("Conexión a base de datos "+bd+". listo");
         }
      }catch(SQLException e){
         System.out.println(e);
      }catch(ClassNotFoundException e){
         System.out.println(e);
      }
   }
   
   /**Permite retornar la conexión
    * @return conn
    */
   public Connection getConnection(){
      return conn;
   }

   //como dice su nombre, termina la conexion a la base de datos
   public void desconectar(){
        try {
            conn.close();
            //conn = null;
            System.out.println("La conexion a la  base de datos " + bd + " a terminado");
        } catch (SQLException ex) {
            Logger.getLogger(Access_connection.class.getName()).log(Level.SEVERE, null, ex);
        }
       
   }
   
}
