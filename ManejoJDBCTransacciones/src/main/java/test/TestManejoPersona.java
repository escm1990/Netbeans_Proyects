package test;

import datos.Conexion;
import datos.PersonaJDBC;
import domain.Persona;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestManejoPersona {
    
    public static void main(String[] args) {
    
        Connection conexion = null;
        
        try {
            conexion= Conexion.getConnection();
            if(conexion.getAutoCommit()){
                conexion.setAutoCommit(false);
            }
            
        PersonaJDBC personaJDBC = new PersonaJDBC(conexion);
        
        Persona cambioPersona = new Persona();
        cambioPersona.setId_Persona(7);
        cambioPersona.setNombre("Patricia");
        cambioPersona.setApellido("Morgan");
        cambioPersona.setEmail("pmorgan@gmail.com");
        cambioPersona.setTelefono("1122005544");
        
        personaJDBC.actualizar(cambioPersona);
        
        Persona nuevaPersona = new Persona("Carlos","Ramirez","cramirez@gmail.com","99776688");
        personaJDBC.insertar(nuevaPersona);
        
        conexion.commit();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
    }
    
}
