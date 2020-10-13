package datos;

import static datos.Conexion.*;
import domain.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAO {
    
    private static final String SQL_SELECT = "SELECT  id_persona, nombre, apellido, email, telefono FROM persona";
    private static final String SQL_INSERT = "INSERT INTO persona(nombre, apellido, email, telefono) VALUES(?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE persona SET nombre = ?, apellido = ?, email = ?, telefono = ? WHERE id_persona = ?";
    private static final String SQL_DELETE = "DELETE FROM persona WHERE id_persona = ?";
    
    public List<Persona> seleccionar(){
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Persona persona = null;
        List<Persona> personas = new ArrayList<>();
        
        try {
            con = getConnection();
            stm = con.prepareStatement(SQL_SELECT);
            rs = stm.executeQuery();
            
            while(rs.next()){
                int idPersona = rs.getInt("id_persona");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                
                //Convertir información de BD a Objetos Java
                persona = new Persona(idPersona, nombre, apellido, email, telefono);
                
                //agregando objetos de tipo persona a la lista
                personas.add(persona);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                Conexion.close(rs);
                Conexion.close(stm);
                Conexion.close(con);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        
        return personas;
    }
    
    public int insertar(Persona personaParam){
        Connection con = null;
        PreparedStatement stm = null;
        int registros = 0;
        
        try {
            con = Conexion.getConnection();
            stm = con.prepareStatement(SQL_INSERT);
            stm.setString(1, personaParam.getNombre());
            stm.setString(2, personaParam.getApellido());
            stm.setString(3, personaParam.getEmail());
            stm.setString(4, personaParam.getTelefono());
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
    
    public int actualizar(Persona personaParam){
        Connection con = null;
        PreparedStatement stm = null;
        int registros = 0;
        
        try {
            con = getConnection();
            stm = con.prepareStatement(SQL_UPDATE);
            stm.setString(1, personaParam.getNombre());
            stm.setString(2, personaParam.getApellido());
            stm.setString(3, personaParam.getEmail());
            stm.setString(4, personaParam.getTelefono());
            stm.setInt(5, personaParam.getIdPersona());
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
