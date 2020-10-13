package datos;

import static datos.Conexion.*;
import domain.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonaJDBC {
    
    private Connection conexionTransaccional;
            
    private static final String SQL_SELECT = "SELECT  id_persona, nombre, apellido, email, telefono FROM persona";
    private static final String SQL_INSERT = "INSERT INTO persona(nombre, apellido, email, telefono) VALUES(?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE persona SET nombre = ?, apellido = ?, email = ?, telefono = ? WHERE id_persona = ?";
    private static final String SQL_DELETE = "DELETE FROM persona WHERE id_persona = ?";
    
   public PersonaJDBC(){
       
   }
    
   public PersonaJDBC(Connection conexionTransaccionalParam){
       this.conexionTransaccional = conexionTransaccionalParam;
   }
           
    public List<Persona> seleccionar() throws SQLException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Persona persona = null;
        List<Persona> personas = new ArrayList<>();
        
        try {
            con = conexionTransaccional == null ? Conexion.getConnection() : this.conexionTransaccional;
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
            
        }
        finally{
            try {
                Conexion.close(rs);
                Conexion.close(stm);
                if(this.conexionTransaccional == null){
                    Conexion.close(con);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        
        return personas;
    }
    
    public int insertar(Persona personaParam) throws SQLException{
        Connection con = null;
        PreparedStatement stm = null;
        int registros = 0;
        
        try {
            con = conexionTransaccional == null ? Conexion.getConnection() : this.conexionTransaccional;
            stm = con.prepareStatement(SQL_INSERT);
            stm.setString(1, personaParam.getNombre());
            stm.setString(2, personaParam.getApellido());
            stm.setString(3, personaParam.getEmail());
            stm.setString(4, personaParam.getTelefono());
            registros = stm.executeUpdate(); //puede ejecutar tipos de sentencias insert update y delete, afecta registros en la base, NO es un updte exclusivo
        }finally{
            try {
                Conexion.close(stm);
                if(this.conexionTransaccional == null){
                    Conexion.close(con);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        
        return registros;
    }
    
    public int actualizar(Persona personaParam) throws SQLException{
        Connection con = null;
        PreparedStatement stm = null;
        int registros = 0;
        
        try {
            con = conexionTransaccional == null ? Conexion.getConnection() : this.conexionTransaccional;
            stm = con.prepareStatement(SQL_UPDATE);
            stm.setString(1, personaParam.getNombre());
            stm.setString(2, personaParam.getApellido());
            stm.setString(3, personaParam.getEmail());
            stm.setString(4, personaParam.getTelefono());
            stm.setInt(5, personaParam.getIdPersona());
            registros = stm.executeUpdate();
        }finally{
            try {
                Conexion.close(stm);
                if(this.conexionTransaccional == null){
                    Conexion.close(con);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        
        return registros;
    }
    
    public int eliminar(int idEliminar) throws SQLException{
        int registros = 0;
        Connection con = null;
        PreparedStatement stm = null;
        
        try {
            con = conexionTransaccional == null ? Conexion.getConnection() : this.conexionTransaccional;
            stm = con.prepareStatement(SQL_DELETE);
            stm.setInt(1, idEliminar);
            registros = stm.executeUpdate();
        }finally{
            try {
                Conexion.close(stm);
                if(this.conexionTransaccional == null){
                    Conexion.close(con);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        
        return registros;
    }
    
}
