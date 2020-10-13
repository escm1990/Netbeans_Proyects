package ireport_sample2;
import java.sql.*;
/**
 * @web http://jc-mouse.blogspot.com/
 * @author Mouse
 */
public class conexion {
   static String bd = "dbsample";
   static String login = "root";
   static String password = "admin";
   static String url = "jdbc:mysql://localhost/"+bd;

   Connection conn = null;

   /** Constructor de DbConnection */
   public conexion() {
      try{
         //obtenemos el driver de para mysql
         Class.forName("com.mysql.jdbc.Driver");
         //obtenemos la conexión
         conn = DriverManager.getConnection(url,login,password);
         if (conn!=null){
            System.out.println("Conexión a base de datos "+bd+" listo");
         }
      }catch(SQLException e){
         System.out.println(e);
      }catch(ClassNotFoundException e){
         System.out.println(e);
      }
   }
   /* Permite retornar la conexión */
   public Connection getConnection(){
      return conn;
   }
   /* termina la conexion a la base de datos */
   public void desconectar(){
      conn = null;
      System.out.println("La conexion a la  base de datos "+bd+" a terminado");
   }
}

