/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoDatos;

import clases.Consulta;
import clases.PropiedadPaciente;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Chavez Vigil
 */
public class OperacionesConsulta {

    Conexion con = new Conexion();

    public void almacenarConsulta(Consulta consulta) {
        try {
            Date fecha = new Date(consulta.getFecha().getTime());
            PreparedStatement sentencia = con.conectar().prepareStatement("INSERT INTO Consulta (Diagnostico,FechaHora,RacionAsignadaPte,JVPM,Carnet,Peso,Estatura,PerimetroCefalico,CondicionSalud) VALUES ('" + consulta.getDiagnostico() + "','" + fecha + "','" + consulta.getRacionAsignada() + "','" + consulta.getJVPM() + "','" + consulta.getCarnet() + "','" + consulta.getPeso() + "','" + consulta.getEstatura() + "','" + consulta.getPerimetroCefalico() + "','" + consulta.getCondicionSalud() + "')");
            sentencia.executeUpdate();
            JOptionPane.showMessageDialog(null, "¡Datos Almacenados!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        con.desconectar();
    }

    public void listarConsulta(JTable tabla, String carnet) {
        try {

            Statement sentencia = null;
            ResultSet resultado = null;

            sentencia = con.conectar().createStatement();
            resultado = sentencia.executeQuery("SELECT * FROM Consulta WHERE Carnet ='" + carnet + "' ORDER BY IdConsulta asc");
            DefaultTableModel modelo = new DefaultTableModel();

            modelo.addColumn("Fecha");
            modelo.addColumn("Carnet");
            modelo.addColumn("Medico");
            modelo.addColumn("Peso(gr)");
            modelo.addColumn("Estatura(cm)");
            modelo.addColumn("Per. Cefalico");
            modelo.addColumn("Ración");
            modelo.addColumn("Condición Salud");
            modelo.addColumn("Diagnostico");

            int valor = 0;
            while (resultado.next()) {
                modelo.addRow(new Object[]{});
                modelo.setValueAt(resultado.getDate("FechaHora"), valor, 0);
                modelo.setValueAt(resultado.getString("Carnet"), valor, 1);
                modelo.setValueAt(resultado.getInt("JVPM"), valor, 2);
                modelo.setValueAt(resultado.getDouble("Peso"), valor, 3);
                modelo.setValueAt(resultado.getDouble("Estatura"), valor, 4);
                modelo.setValueAt(resultado.getString("PerimetroCefalico"), valor, 5);
                modelo.setValueAt(resultado.getDouble("RacionAsignadaPte"), valor, 6);
                modelo.setValueAt(resultado.getString("CondicionSalud"), valor, 7);
                modelo.setValueAt(resultado.getString("Diagnostico"), valor, 8);
                valor = valor + 1;
            }
            tabla.setModel(modelo);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        con.desconectar();

    }

    public void eliminarPropiedadPaciente(String carnet) {
        try {
            PreparedStatement sentencia = con.conectar().prepareStatement("DELETE FROM PropiedadPaciente WHERE Carnet = '" + carnet + "'");
            sentencia.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public void eliminarConsultas(String carnet) {
        try {
            PreparedStatement sentencia = con.conectar().prepareStatement("DELETE FROM Consulta WHERE Carnet = '" + carnet + "'");
            sentencia.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public void eliminarConsulta(String carnet, String fecha, String medico, String peso, String longitud, String pc) {
        try {
            PreparedStatement sentencia = con.conectar().prepareStatement("DELETE FROM Consulta WHERE (Carnet = '" + carnet + "')AND (FechaHora ='" + Date.valueOf(fecha) + "') AND (JVPM ='" + Integer.parseInt(medico) + "') AND (Peso ='" + Double.parseDouble(peso) + "')AND (Estatura ='" + Double.parseDouble(longitud) + "')AND (PerimetroCefalico ='" + pc + "')");
            sentencia.executeUpdate();
            JOptionPane.showMessageDialog(null, "¡Eliminada Correctamente!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public void listarPacientes(JTable tabla) {
        try {

            Statement sentencia = null;
            ResultSet resultado = null;

            sentencia = con.conectar().createStatement();
            resultado = sentencia.executeQuery("SELECT * FROM Paciente ORDER BY Carnet");
            DefaultTableModel modelo = new DefaultTableModel();

            modelo.addColumn("Canet");
            modelo.addColumn("Nombres");
            modelo.addColumn("Apellidos");
            modelo.addColumn("FechaNac");
            modelo.addColumn("SemanasGes");
            modelo.addColumn("Sexo");
            modelo.addColumn("Encargado");
            modelo.addColumn("Notas");
            modelo.addColumn("Departamento");
            modelo.addColumn("Municipio");
            modelo.addColumn("Parto Materno");
            modelo.addColumn("Edad Materna");
            modelo.addColumn("Gravidez");
            modelo.addColumn("Patologia Materna");
            modelo.addColumn("Tipo");

            int valor = 0;
            while (resultado.next()) {
                modelo.addRow(new Object[]{});
                modelo.setValueAt(resultado.getString("Carnet"), valor, 0);
                modelo.setValueAt(resultado.getString("Nombres"), valor, 1);
                modelo.setValueAt(resultado.getString("Apellidos"), valor, 2);
                modelo.setValueAt(resultado.getDate("FechaNac"), valor, 3);
                modelo.setValueAt(resultado.getDouble("SemanasGestacion"), valor, 4);
                modelo.setValueAt(resultado.getString("Sexo"), valor, 5);
                modelo.setValueAt(resultado.getString("Nit"), valor, 6);
                modelo.setValueAt(resultado.getString("Notas"), valor, 7);
                modelo.setValueAt(resultado.getString("Departamento"), valor, 8);
                modelo.setValueAt(resultado.getString("Municipio"), valor, 9);
                modelo.setValueAt(resultado.getString("Parto"), valor, 10);
                modelo.setValueAt(resultado.getString("EdadMaterna"), valor, 11);
                modelo.setValueAt(resultado.getString("Gravidez"), valor, 12);
                modelo.setValueAt(resultado.getString("Patologia"), valor, 13);
                modelo.setValueAt(resultado.getString("Tipo"), valor, 14);
                valor = valor + 1;
            }
            tabla.setModel(modelo);
            tabla.setAutoscrolls(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        con.desconectar();

    }

    public DefaultTableModel buscarNombres(String nombre, String apellido) {
        DefaultTableModel model = null;
        try {
            Statement sentencia = con.conectar().createStatement();
            ResultSet resultado = sentencia.executeQuery("SELECT carnet,Nombres,Apellidos FROM Paciente WHERE Nombres='" + nombre + "'AND Apellidos = '" + apellido + "'");
            model = new DefaultTableModel();
            model.addColumn("Canet");
            model.addColumn("Nombres");
            model.addColumn("Apellidos");
            int valor = 0;
            while (resultado.next()) {
                model.addRow(new Object[]{});
                model.setValueAt(resultado.getString("Carnet"), valor, 0);
                model.setValueAt(resultado.getString("Nombres"), valor, 1);
                model.setValueAt(resultado.getString("Apellidos"), valor, 2);
                valor = valor + 1;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return model;
    }

    public DefaultTableModel buscarNombre(String campo, String dato) {
        DefaultTableModel model = null;
        try {
            Statement sentencia = con.conectar().createStatement();
            ResultSet resultado = sentencia.executeQuery("SELECT carnet,Nombres,Apellidos FROM Paciente WHERE " + campo + "='" + dato + "'");
            model = new DefaultTableModel();
            model.addColumn("Canet");
            model.addColumn("Nombres");
            model.addColumn("Apellidos");
            int valor = 0;
            while (resultado.next()) {
                model.addRow(new Object[]{});
                model.setValueAt(resultado.getString("Carnet"), valor, 0);
                model.setValueAt(resultado.getString("Nombres"), valor, 1);
                model.setValueAt(resultado.getString("Apellidos"), valor, 2);
                valor = valor + 1;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return model;
    }

    public DefaultTableModel buscarFecha(Date de, Date hasta) {
        DefaultTableModel model = null;
        try {
            Statement sentencia = con.conectar().createStatement();
            ResultSet resultado = sentencia.executeQuery("SELECT carnet,Nombres,Apellidos FROM Paciente WHERE (FechaNac >='" + de + "') AND (FechaNac <='" + hasta + "')");
            model = new DefaultTableModel();
            model.addColumn("Canet");
            model.addColumn("Nombres");
            model.addColumn("Apellidos");
            int valor = 0;
            while (resultado.next()) {
                model.addRow(new Object[]{});
                model.setValueAt(resultado.getString("Carnet"), valor, 0);
                model.setValueAt(resultado.getString("Nombres"), valor, 1);
                model.setValueAt(resultado.getString("Apellidos"), valor, 2);
                valor = valor + 1;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return model;
    }

    public void BuscarConsulta(JTable tabla, String campo, String value, String carnet) {
        try {

            Statement sentencia = null;
            ResultSet resultado = null;

            sentencia = con.conectar().createStatement();
            resultado = sentencia.executeQuery("SELECT * FROM Consulta WHERE (" + campo + " ='" + value + "') AND Carnet = '" + carnet + "' ORDER BY IdConsulta asc");
            DefaultTableModel modelo = new DefaultTableModel();

            modelo.addColumn("Fecha");
            modelo.addColumn("Carnet");
            modelo.addColumn("Medico");
            modelo.addColumn("Peso(gr)");
            modelo.addColumn("Estatura(cm)");
            modelo.addColumn("Per. Cefalico");
            modelo.addColumn("Ración");
            modelo.addColumn("Condición Salud");
            modelo.addColumn("Diagnostico");

            int valor = 0;
            while (resultado.next()) {
                modelo.addRow(new Object[]{});
                modelo.setValueAt(resultado.getDate("FechaHora"), valor, 0);
                modelo.setValueAt(resultado.getString("Carnet"), valor, 1);
                modelo.setValueAt(resultado.getInt("JVPM"), valor, 2);
                modelo.setValueAt(resultado.getDouble("Peso"), valor, 3);
                modelo.setValueAt(resultado.getDouble("Estatura"), valor, 4);
                modelo.setValueAt(resultado.getString("PerimetroCefalico"), valor, 5);
                modelo.setValueAt(resultado.getDouble("RacionAsignadaPte"), valor, 6);
                modelo.setValueAt(resultado.getString("CondicionSalud"), valor, 7);
                modelo.setValueAt(resultado.getString("Diagnostico"), valor, 8);
                valor = valor + 1;
            }
            tabla.setModel(modelo);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        con.desconectar();

    }

    public void almacenarPropiedad(PropiedadPaciente prop, String carnet) {
        try {
            PreparedStatement sentencia = con.conectar().prepareStatement("INSERT INTO PropiedadPaciente (FechaIncorporacion,pesoNacer,pesoIncorporarse,estaturaNacer,estaturaIncorporarse,pCefalicoNacer,pCefalicoIncorporarse,carnet) VALUES ('" + prop.getFechaIncorporacion() + "','" + prop.getPesoNacer() + "','" + prop.getPesoIncorporarse() + "','" + prop.getEstaturaNacer() + "','" + prop.getEstaturaIncorporarse() + "','" + prop.getpCefalicoNacer() + "','" + prop.getpCefalicoIncorporarse() + "','" + carnet + "')");
            sentencia.executeUpdate();
            JOptionPane.showMessageDialog(null, "¡Datos Almacenados!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        con.desconectar();
    }

    public PropiedadPaciente extraerPropiedad(String carnet) {
        PropiedadPaciente pro = null;
        try {
            Statement sentencia = con.conectar().createStatement();
            ResultSet resultado = sentencia.executeQuery("SELECT * FROM PropiedadPaciente WHERE Carnet = '" + carnet + "'");
            resultado.next();
            pro = new PropiedadPaciente(resultado.getDate("fechaIncorporacion"), resultado.getDouble("pesoNacer"), resultado.getDouble("pesoIncorporarse"), resultado.getDouble("estaturaNacer"), resultado.getDouble("estaturaIncorporarse"), resultado.getDouble("pCefalicoNacer"), resultado.getDouble("pCefalicoIncorporarse"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return pro;

    }

    public boolean verificarPaciente(String carnet) {
        boolean res = false;
        try {
            Statement sentencia = con.conectar().createStatement();
            ResultSet resultado = sentencia.executeQuery("SELECT pesoNacer FROM PropiedadPaciente WHERE Carnet ='" + carnet + "'");
            if (resultado.next() == true) {
                res = true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return res;
    }

    public void actualizarPropiedades(String carnet, PropiedadPaciente p) {
        try {

            PreparedStatement sentencia = con.conectar().prepareStatement("UPDATE PropiedadPaciente SET fechaIncorporacion ='" + p.getFechaIncorporacion() + "', pesoNacer ='" + p.getPesoNacer() + "',pesoIncorporarse ='" + p.getPesoIncorporarse() + "',estaturaNacer ='" + p.getEstaturaNacer() + "',estaturaIncorporarse ='" + p.getEstaturaIncorporarse() + "',pCefalicoNacer='" + p.getpCefalicoNacer() + "',pCefalicoIncorporarse ='" + p.getpCefalicoIncorporarse() + "' WHERE Carnet = '" + carnet + "'");
            sentencia.executeUpdate();
            JOptionPane.showMessageDialog(null, "¡Datos Modificados!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void actualizarConsulta(Consulta c, Consulta mod) {
        try {

            Statement sen = con.conectar().createStatement();
            ResultSet res = sen.executeQuery("SELECT IdConsulta FROM Consulta WHERE (Diagnostico = '" + c.getDiagnostico() + "') AND (RacionAsignadaPte = '" + c.getRacionAsignada() + "') AND (JVPM = '" + c.getJVPM() + "') AND (Carnet = '" + c.getCarnet() + "') AND (Peso = '" + c.getPeso() + "') AND (Estatura = '" + c.getEstatura() + "') AND (PerimetroCefalico = '" + c.getPerimetroCefalico() + "') AND (CondicionSalud = '" + c.getCondicionSalud() + "')");
            if (res.next() == true) {
                int id = res.getInt("IdConsulta");
                PreparedStatement sentencia = con.conectar().prepareStatement("UPDATE Consulta SET Diagnostico ='" + mod.getDiagnostico() + "', RacionAsignadaPte ='" + mod.getRacionAsignada() + "',Peso ='" + mod.getPeso() + "',Estatura ='" + mod.getEstatura() + "',PerimetroCefalico ='" + mod.getPerimetroCefalico() + "' WHERE IdConsulta = '" + id + "'");
                sentencia.executeUpdate();
                JOptionPane.showMessageDialog(null, "¡Datos Modificados!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public String getNombrePaciente(String nit) {
        String nombre = "";
        String name = "";
        String ape = "";
        try {
            Statement sentencia = con.conectar().createStatement();
            ResultSet resultado = sentencia.executeQuery("SELECT nombres,apeliidos FROM EncargadoPaciente WHERE Nit ='" + nit + "'");
            if (resultado.next() == true) {
                name = resultado.getString("nombres");
                ape = resultado.getString("apeliidos");
                nombre = name + " " + ape;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return nombre;
    }

    public void BuscarEncargado(JTable tabla, String campo, String value) {
        try {

            Statement sentencia = null;
            ResultSet resultado = null;
            TableColumn numero = null;

            sentencia = con.conectar().createStatement();
            resultado = sentencia.executeQuery("SELECT * FROM EncargadoPaciente WHERE (" + campo + " ='" + value + "') ORDER BY Apeliidos asc");
            DefaultTableModel modelo = new DefaultTableModel();

            modelo.addColumn("NIT");
            modelo.addColumn("DUI");
            modelo.addColumn("Nombre");
            modelo.addColumn("Apellido");
            modelo.addColumn("Parentesco");
            modelo.addColumn("Dirección");
            modelo.addColumn("Teléfono");

            int valor = 0;
            while (resultado.next()) {
                modelo.addRow(new Object[]{});
                modelo.setValueAt(resultado.getString("Nit"), valor, 0);
                modelo.setValueAt(resultado.getString("Dui"), valor, 1);
                modelo.setValueAt(resultado.getString("nombres"), valor, 2);
                modelo.setValueAt(resultado.getString("apeliidos"), valor, 3);
                modelo.setValueAt(resultado.getString("parentesco"), valor, 4);
                modelo.setValueAt(resultado.getString("direccion"), valor, 5);
                modelo.setValueAt(resultado.getString("Telefono"), valor, 6);
                valor = valor + 1;
            }
            tabla.setModel(modelo);
            numero = tabla.getColumnModel().getColumn(0);
            numero.setPreferredWidth(105);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        con.desconectar();

    }
}
