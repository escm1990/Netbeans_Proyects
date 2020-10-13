/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package progra3_db;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pc06
 */
public class Operaciones {

    private Conexion con = new Conexion();

    public void agregar(String carnet, String nombres, String apellidos, String fecha, String carrera) throws SQLException {
        try {
            int rows_updated = 0;
            PreparedStatement stmt1 = con.conectar().prepareStatement("INSERT INTO alumnos(Carnet,Nombres,Apellidos,Fecha_nac,Carrera) VALUES(?,?,?,?,?)");
            stmt1.setString(1, carnet);
            stmt1.setString(2, nombres);
            stmt1.setString(3, apellidos);
            stmt1.setString(4, fecha);
            stmt1.setString(5, carrera);
            rows_updated = stmt1.executeUpdate();
            if (rows_updated == 1) {
                JOptionPane.showMessageDialog(null, "Alumno agregado exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo agregar el alumno.\nPor favor verificar datos.");
            }
            con.desconectar();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error " + ex.getMessage());
        }
    }

    public void eliminar(String carnet) {
        try {
            int rows_updated = 0;
            PreparedStatement stmt1 = con.conectar().prepareStatement("DELETE alumnos.* FROM alumnos WHERE Carnet = '" + carnet + "'");
            rows_updated = stmt1.executeUpdate();
            if (rows_updated == 1) {
                JOptionPane.showMessageDialog(null, "Alumno eliminado(a) exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar el alumno\nFavor verificar los datos");
            }
            con.desconectar();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error " + ex.getMessage());
        }
    }

    public void listar(JTable tabla) {
        try {
            Statement sentencia = null;
            ResultSet resultado = null;
            sentencia = con.conectar().createStatement();
            resultado = sentencia.executeQuery("SELECT * FROM alumnos ORDER BY Carnet asc");
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Carnet");
            modelo.addColumn("Nombres");
            modelo.addColumn("Apellidos");
            modelo.addColumn("Fecha Nac");
            modelo.addColumn("Carrera");
            int cont=0;
            while(resultado.next()){
                modelo.addRow(new Object[]{});
                modelo.setValueAt(resultado.getString("Carnet"), cont, 0);
                modelo.setValueAt(resultado.getString("Nombres"), cont, 1);
                modelo.setValueAt(resultado.getString("Apellidos"), cont, 2);
                modelo.setValueAt(resultado.getDate("Fecha_nac").toString(), cont, 3);
                modelo.setValueAt(resultado.getString("Carrera"), cont, 4);
                cont+=1;
            }
            tabla.setModel(modelo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        con.desconectar();
    }

    public DefaultTableModel buscar_alumno(String campo, String valor){
        DefaultTableModel res = new DefaultTableModel();
        res.addColumn("Carnet");
        res.addColumn("Nombres");
        res.addColumn("Apellidos");
        res.addColumn("Fecha Nac");
        res.addColumn("Carrera");
        try{
            Statement sentencia = null;
            ResultSet resultado = null;
            sentencia = con.conectar().createStatement();
            resultado = sentencia.executeQuery("SELECT * FROM alumnos WHERE " + campo + " LIKE '%" + valor + "%'");
            int cont = 0;
            resultado.last();
            if(resultado.getRow()<=0){
                JOptionPane.showMessageDialog(null, "No hay datos en el campo "+campo+" con el valor "+valor);
            }
            else{
                resultado.beforeFirst();
                while(resultado.next()){
                    res.addRow(new Object[]{});
                    res.setValueAt(resultado.getString("Carnet"), cont, 0);
                    res.setValueAt(resultado.getString("Nombres"), cont, 1);
                    res.setValueAt(resultado.getString("Apellidos"), cont, 2);
                    res.setValueAt(resultado.getDate("Fecha_nac").toString() , cont, 3);
                    res.setValueAt(resultado.getString("Carrera"), cont, 4);
                    cont++;
                }
            }
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            con.desconectar();
       }
       return res;
    }
}