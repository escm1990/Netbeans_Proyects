package datos;

import static datos.Conexion.getConnection;
import domain.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    
    private static final String SQL_SELECT = "SELECT id_usuario, usuario, password FROM usuario";
    private static final String SQL_INSERT = "INSERT INTO usuario(usuario, password) VALUES(?,?)";
    private static final String SQL_UPDATE = "UPDATE usuario SET usuario = ?, password = ? WHERE id_usuario = ?";
    private static final String SQL_DELETE = "DELETE FROM usuario WHERE id_usuario = ?";
    
    public List<Usuario> seleccionar(){
        List<Usuario> usuarios = new ArrayList<>();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Usuario usuarioObj = null;
        
        try {
            con = Conexion.getConnection();
            stm = con.prepareStatement(SQL_SELECT);
            rs = stm.executeQuery();
            
            while(rs.next()){
                int idUsuario = rs.getInt("id_usuario");
                String usuarioNombre = rs.getString("usuario");
                String password = rs.getString("password");
                
                usuarioObj = new Usuario(usuarioNombre, password);
                
                usuarios.add(usuarioObj);
            }
            
        } catch (SQLException ex) {
             ex.printStackTrace(System.out);
        }finally{
            try {
                Conexion.close(rs);
                Conexion.close(stm);
                Conexion.close(con);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return usuarios;
    }
    
    public int insertar(Usuario usuarioParam){
        Connection con = null;
        PreparedStatement stm = null;
        int registros = 0;
        
        try {
            con = Conexion.getConnection();
            stm = con.prepareStatement(SQL_INSERT);
            stm.setString(1, usuarioParam.getUsuario());
            stm.setString(2, usuarioParam.getPassword());
            registros = stm.executeUpdate(); //puede ejecutar tipos de sentencias insert update y delete, afecta registros en la base, NO es un updte exclusivo
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            try {
                Conexion.close(stm);
                Conexion.close(con);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        
        return registros;
    }
    
    public int actualizar(Usuario usuarioParam){
        Connection con = null;
        PreparedStatement stm = null;
        int registros = 0;
        
        try {
            con = getConnection();
            stm = con.prepareStatement(SQL_UPDATE);
            stm.setString(1, usuarioParam.getUsuario());
            stm.setString(2, usuarioParam.getPassword());
            stm.setInt(3, usuarioParam.getIdUsuario());
            registros = stm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            try {
                Conexion.close(stm);
                Conexion.close(con);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        
        return registros;
    }
    
    public int eliminar(int idEliminar){
        int registros = 0;
        Connection con = null;
        PreparedStatement stm = null;
        
        try {
            con = getConnection();
            stm = con.prepareStatement(SQL_DELETE);
            stm.setInt(1, idEliminar);
            registros = stm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            try {
                Conexion.close(stm);
                Conexion.close(con);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        
        return registros;
    }
    
}
