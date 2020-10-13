/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoDatos;

import clases.Paciente;
import clases.PropiedadesPaciente;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class OperacionesDonantNinos {

    Conexion con = new Conexion();

    public void listarNinos(JTable tabla) {
        try {

            Statement sentencia = null;
            ResultSet resultado = null;

            sentencia = con.conectar().createStatement();
            resultado = sentencia.executeQuery("SELECT * FROM Paciente ORDER BY Carnet asc");
            DefaultTableModel modelo = new DefaultTableModel();

            modelo.addColumn("Carnet");
            modelo.addColumn("Nombres");
            modelo.addColumn("Apellidos");

            int valor = 0;
            while (resultado.next()) {
                modelo.addRow(new Object[]{});
                modelo.setValueAt(resultado.getString("Carnet"), valor, 0);
                modelo.setValueAt(resultado.getString("Nombres"), valor, 1);
                modelo.setValueAt(resultado.getString("Apellidos"), valor, 2);
                valor = valor + 1;
            }
            tabla.setModel(modelo);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        con.desconectar();

    }

    public Paciente listarInfoNino(String carnet) {
        Paciente paciente = null;
        PropiedadesPaciente propiedades = null;
        try {
            Statement sentencia = null;
            ResultSet resultado = null;

            sentencia = con.conectar().createStatement();
            resultado = sentencia.executeQuery("SELECT * FROM Paciente WHERE Carnet = '" + carnet + "'");
            resultado.next();
            paciente = new Paciente(resultado.getString("Carnet"), resultado.getString("Nombres"), resultado.getString("Apellidos"), resultado.getDate("FechaNac"), resultado.getString("Sexo"), resultado.getString("SemanasGestacion"), resultado.getString("Notas"),resultado.getString("Tipo"));
 
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }      
        con.desconectar();
        return paciente;
    }
    
     public PropiedadesPaciente listarPropeNino(String carnet) {
        PropiedadesPaciente propiedades = null;
        try {
            Statement sentencia = null;
            ResultSet resultado = null;

            sentencia = con.conectar().createStatement();
            resultado = sentencia.executeQuery("SELECT * FROM Paciente WHERE Carnet = '" + carnet + "'");
            resultado.next();
            propiedades = new PropiedadesPaciente(resultado.getString("Parto"), resultado.getString("EdadMaterna"), resultado.getString("Gravidez"), resultado.getString("Patologia"), resultado.getString("Municipio"), resultado.getString("Departamento"));
            
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }      
        con.desconectar();
        return propiedades;
    }
    
     public String EncargadoPaciente(String carnet) {
        String encargado = null;
        try {
            Statement sentencia = null;
            ResultSet resultado = null;

            sentencia = con.conectar().createStatement();
            resultado = sentencia.executeQuery("SELECT Nit FROM Paciente WHERE Carnet = '" + carnet + "'");
            resultado.next();
            encargado = resultado.getString("Nit");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }      
        con.desconectar();
        return encargado;
    }

    public void almacenarInfoNino(Paciente paciente, String encar, PropiedadesPaciente propiedades) {
        try {
            Date fecha = new Date(paciente.getFechaNac().getTime());
            PreparedStatement sentencia = con.conectar().prepareStatement("INSERT INTO Paciente (Carnet,Nombres,Apellidos,FechaNac,SemanasGestacion,Sexo,Nit,Notas,Departamento,Municipio,Parto,EdadMaterna,Gravidez,Patologia,Tipo) VALUES ('" + paciente.getCarnet() + "','" + paciente.getNombre() + "','" + paciente.getApellido() + "','" + fecha + "','" + paciente.getSemGest() + "','" + paciente.getSexo() + "','" + encar + "','" + paciente.getNotas() + "','" + propiedades.getDepartamento() + "','" + propiedades.getMunicipio() + "','" + propiedades.getParto() + "','" + propiedades.getEdadMaterna() + "','" + propiedades.getGravidez() + "','" + propiedades.getPatologia() + "','" + paciente.getTipo() + "')");
            sentencia.executeUpdate();
            JOptionPane.showMessageDialog(null, "¡Datos Almacenados!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        con.desconectar();
    }

    public void eliminarNino(String carnet) {
        try {
            PreparedStatement sentencia = con.conectar().prepareStatement("DELETE FROM Paciente WHERE Carnet = '" + carnet + "'");
            if (sentencia.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "¡Eliminado Correctamente!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public String obtenerCarnetPaciente(String valor) throws SQLException {
        ResultSet resultado = null;
        Statement stmt1 = null;
        String carnet = null;
        stmt1 = con.conectar().createStatement();
        resultado = stmt1.executeQuery("SELECT Carnet FROM Paciente WHERE Carnet = '" + valor + "'");
        while (resultado.next()) {
            carnet = resultado.getString("Carnet");
        }
        return carnet;
    }
    
    public String obtenerDocumentoDonante(String valor) throws SQLException {
        ResultSet resultado = null;
        Statement stmt1 = null;
        String documento = null;
        stmt1 = con.conectar().createStatement();
        resultado = stmt1.executeQuery("SELECT Documento FROM Persona WHERE Documento = '" + valor + "'");
        while (resultado.next()) {
            documento = resultado.getString("Documento");
        }
        return documento;
    }
    
     public void actualizarPaciente(Paciente p, PropiedadesPaciente pro){
        try{  
            Date fecha = new Date(p.getFechaNac().getTime());
            PreparedStatement sentencia = con.conectar().prepareStatement("UPDATE Paciente SET Nombres ='" + p.getNombre() + "', Apellidos ='" + p.getApellido() + "',FechaNac ='" + fecha + "',SemanasGestacion ='" + p.getSemGest() + "',Sexo ='" + p.getSexo() + "',Notas='" + p.getNotas()+ "',Departamento ='" + pro.getDepartamento()+ "',Municipio ='" + pro.getMunicipio()+ "',Parto ='" + pro.getParto()+ "',EdadMaterna ='" + pro.getEdadMaterna()+ "',Gravidez ='" + pro.getGravidez()+ "',Patologia ='" + pro.getPatologia()+ "',Tipo ='" + p.getTipo()+ "' WHERE Carnet = '"+p.getCarnet()+"'");
            sentencia.executeUpdate();
            JOptionPane.showMessageDialog(null, "¡Datos Modificados!");
        }catch(Exception e){
           JOptionPane.showMessageDialog(null, e.getMessage());
        }
    } 
}
