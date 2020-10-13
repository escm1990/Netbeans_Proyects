/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoDatos;

import clases.Donacion;
import clases.Donante;
import clases.Paciente;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class OperacionesDonacion {

    Conexion con = new Conexion();
//instance table model
//    DefaultTableModel tableModel = new DefaultTableModel() {
//
//        @Override
//        public boolean isCellEditable(int row, int column) {
//            //Only the third column
//            return false;
//        }
//    };

    public void listarDonantes(JTable tabla) {
        try {

            Statement sentencia = null;
            ResultSet resultado = null;

            sentencia = con.conectar().createStatement();
            resultado = sentencia.executeQuery("SELECT * FROM Persona ORDER BY Documento asc");
            DefaultTableModel tableModel = new DefaultTableModel() {

                @Override
                public boolean isCellEditable(int row, int column) {
                    //Only the third column
                    return false;
                }
            };

            tableModel.addColumn("Documento");
            tableModel.addColumn("Nombres");
            tableModel.addColumn("Apellidos");

            int valor = 0;
            while (resultado.next()) {
                tableModel.addRow(new Object[]{});
                tableModel.setValueAt(resultado.getString("Documento"), valor, 0);
                tableModel.isCellEditable(valor, 0);
                tableModel.setValueAt(resultado.getString("Nombres"), valor, 1);
                tableModel.isCellEditable(valor, 1);
                tableModel.setValueAt(resultado.getString("Apellidos"), valor, 2);
                tableModel.isCellEditable(valor, 2);
                valor = valor + 1;
            }

            tabla.setModel(tableModel);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        con.desconectar();

    }

    public Donante listarInfoDonante(String documento) {
        Donante donante = new Donante();
        try {
            Statement sentencia = null;
            ResultSet resultado = null;

            sentencia = con.conectar().createStatement();

            resultado = sentencia.executeQuery("SELECT * FROM Persona WHERE Documento = '" + documento + "'");


            int valor = 0;
            while (resultado.next()) {
                donante.setDocumento(resultado.getString("Documento"));
                donante.setNombre(resultado.getString("Nombres"));
                donante.setApellido(resultado.getString("Apellidos"));
                donante.setFechaNac(resultado.getDate("FechaNac"));
//                System.out.println(donante.getFechaNac());
                donante.setPeso(resultado.getString("Peso"));
                donante.setEstatura(resultado.getString("Estatura"));
                donante.setDireccion(resultado.getString("Direccion"));
                donante.setSemGest(resultado.getString("SemGesta"));
                donante.setFechaParto(resultado.getDate("FechaParto"));
                donante.setVDRL(resultado.getString("vdrl"));
                donante.setHbsAg(resultado.getString("hbsag"));
//                System.out.println(donante.getFechaNac());
                donante.setHIV(resultado.getString("hiv"));
                donante.setTransSangui(resultado.getString("TransSangui"));
                donante.setTabaquismo(resultado.getString("Tabaquismo"));
                donante.setEtilismo(resultado.getString("Etilismo"));
                donante.setAptaDonar(resultado.getString("AptaDonar"));
                donante.setFechaObtencion(resultado.getDate("FechaObtDatos"));
                valor++;
            }
            sentencia = con.conectar().createStatement();

            resultado = sentencia.executeQuery("SELECT * FROM TelefonoPersona WHERE Documento = '" + documento + "'");


            int val = 0;
            while (resultado.next()) {
                donante.setTel(resultado.getString("NoTel"));
                val++;
            }
            return donante;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        con.desconectar();
        return donante;
    }

    public void almacenarInfoDonante(Donante donante) {
        try {
            Date fechaNac = new Date(donante.getFechaNac().getTime());
            Date fechaParto = new Date(donante.getFechaParto().getTime());
            Date fechaObtDatos = new Date(donante.getFechaObtencion().getTime());
            PreparedStatement sentencia = con.conectar().prepareStatement("INSERT INTO Persona (Documento,Nombres,Apellidos,FechaNac,Peso,Estatura,Direccion,SemGesta,FechaParto,vdrl,hbsag,hiv,TransSangui,Tabaquismo,Etilismo,AptaDonar,FechaObtDatos) VALUES ('" + donante.getDocumento() + "','" + donante.getNombre() + "','" + donante.getApellido() + "','" + fechaNac + "','" + donante.getPeso() + "','" + donante.getEstatura() + "','" + donante.getDireccion() + "','" + donante.getSemGest() + "','" + fechaParto + "','" + donante.getVDRL() + "','" + donante.getHbsAg() + "','" + donante.getHIV() + "','" + donante.getTransSangui() + "','" + donante.getTabaquismo() + "','" + donante.getEtilismo() + "','" + donante.getAptaDonar() + "','" + fechaObtDatos + "')");
            sentencia.executeUpdate();
            sentencia = con.conectar().prepareStatement("INSERT INTO TelefonoPersona (NoTel,TipoTelefono,Documento) VALUES ('" + donante.getTel() + "','Fijo','" + donante.getDocumento() + "')");
            sentencia.executeUpdate();
            con.desconectar();
            JOptionPane.showMessageDialog(null, "¡Datos Almacenados!");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
        con.desconectar();
    }
    
    public void modificarInfoDonante(Donante donante){
        try {
            Date fechaNac = new Date(donante.getFechaNac().getTime());
            Date fechaParto = new Date(donante.getFechaParto().getTime());
            Date fechaObtDatos = new Date(donante.getFechaObtencion().getTime());
            PreparedStatement sentencia = con.conectar().prepareStatement("UPDATE Persona SET Nombres = '"+donante.getNombre()+"',Apellidos ='"+donante.getApellido()+"',FechaNac = '"+fechaNac+"',Peso ='"+donante.getPeso()+"',Estatura ='"+donante.getEstatura()+"',Direccion ='"+donante.getDireccion()+"',SemGesta='"+donante.getSemGest()+"',FechaParto ='"+fechaParto+"',vdrl ='"+donante.getVDRL()+"',hbsag ='"+donante.getHbsAg()+"',hiv ='"+donante.getHIV()+"',TransSangui ='"+donante.getTransSangui()+"',Tabaquismo ='"+donante.getTabaquismo()+"',Etilismo ='"+donante.getEtilismo()+"',AptaDonar ='"+donante.getAptaDonar()+"',FechaObtDatos ='"+fechaObtDatos+"' WHERE Documento ='"+donante.getDocumento()+"'");
            sentencia.executeUpdate();
            JOptionPane.showMessageDialog(null, "¡Datos Modificados!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
        con.desconectar();
    }

    public void eliminarDonante(String doc) {
        try {
            PreparedStatement sentencia = con.conectar().prepareStatement("DELETE FROM Donacion WHERE Documento = '" + doc + "'");
            PreparedStatement sentencia2 = con.conectar().prepareStatement("DELETE FROM Persona WHERE Documento = '" + doc + "'");
            sentencia.execute();
            if (sentencia2.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "¡Eliminado Correctamente!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public void almacenarDonacion(Donacion donacion, String idRutaDom) {
        try {
            PreparedStatement sentencia = con.conectar().prepareStatement("INSERT INTO Donacion (FechaDonacion,TipoDonacion,RacionAcep,RacionDesc,Documento,Estatura,Peso,idVisitaDonacion) VALUES ('" + donacion.getFechaDon() + "','" + donacion.getTipo() + "','" + donacion.getRacAceptada() + "','" + donacion.getRacDescartada() + "','" + donacion.getDocumento() + "','" + donacion.getEstatura() + "','" + donacion.getPeso() + "','" + idRutaDom + "')");
            sentencia.executeUpdate();
            con.desconectar();
            JOptionPane.showMessageDialog(null, "¡Datos Almacenados!");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Aca es " + ex.getMessage());
        }
        con.desconectar();
    }

    public void listarDonanciones(JTable tabla, String doc) {
        try {

            Statement sentencia = null;
            ResultSet resultado = null;

            sentencia = con.conectar().createStatement();
            resultado = sentencia.executeQuery("SELECT * FROM Donacion WHERE Documento = '" + doc + "' ORDER BY FechaDonacion asc");

            DefaultTableModel modelo = new DefaultTableModel() {

                @Override
                public boolean isCellEditable(int row, int column) {
                    //Only the third column
                    return false;
                }
            };
            modelo.addColumn("Fecha Donacion");
            modelo.addColumn("Tipo");
            modelo.addColumn("Racion Aceptada");
            modelo.addColumn("Racion Descartada");
            modelo.addColumn("Estatura(cm)");
            modelo.addColumn("Peso(Kg)");

            int valor = 0;
            while (resultado.next()) {
                modelo.addRow(new Object[]{});
                modelo.setValueAt(resultado.getString("FechaDonacion"), valor, 0);
                modelo.setValueAt(resultado.getString("TipoDonacion"), valor, 1);
                modelo.setValueAt(resultado.getString("RacionAcep"), valor, 2);
                modelo.setValueAt(resultado.getString("RacionDesc"), valor, 3);
                modelo.setValueAt(resultado.getString("Estatura"), valor, 4);
                modelo.setValueAt(resultado.getString("Peso"), valor, 5);

                valor = valor + 1;
            }
            tabla.setModel(modelo);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        con.desconectar();

    }

    public void eliminarDonacion(String doc, String fechD) {
        try {
            PreparedStatement sentencia = con.conectar().prepareStatement("DELETE FROM Donacion WHERE Documento = '" + doc + "' AND FechaDonacion = '" + fechD + "'");

            if (sentencia.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "¡Eliminado Correctamente!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

   public void modificarDonacion(Donacion d, Donacion mod) {
        try {

            Statement sen = con.conectar().createStatement();
            ResultSet res = sen.executeQuery("SELECT IdDonacion FROM Donacion WHERE (FechaDonacion = '" + d.getFechaDon() + "') AND (TipoDonacion = '" + d.getTipo() + "') AND (RacionAcep = '" + d.getRacAceptada() + "') AND (RacionDesc = '" + d.getRacDescartada() + "') AND (Documento = '" + d.getDocumento() + "') AND (Estatura = '" + d.getEstatura() + "') AND (Peso = '" + d.getPeso() + "')");
            if (res.next() == true) {
                int id = res.getInt("IdDonacion");
                PreparedStatement sentencia = con.conectar().prepareStatement("UPDATE Donacion SET FechaDonacion ='" + mod.getFechaDon() + "', TipoDonacion ='" + mod.getTipo() + "',RacionAcep ='" + mod.getRacAceptada() + "',RacionDesc ='" + mod.getRacDescartada() + "',Estatura ='" + mod.getEstatura() + "',Peso ='" + mod.getPeso() + "' WHERE IdDonacion = '" + id + "'");
                sentencia.executeUpdate();
                JOptionPane.showMessageDialog(null, "¡Datos Modificados!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
      
    public void buscarDonante(JTable tabla, String condicion, String aBuscar) {
        try {

            Statement sentencia = null;
            ResultSet resultado = null;

            sentencia = con.conectar().createStatement();
            resultado = sentencia.executeQuery("SELECT * FROM Persona WHERE " + condicion + " LIKE '" + aBuscar + "%' ORDER BY " + condicion + " asc");
            DefaultTableModel modelo = new DefaultTableModel();

            modelo.addColumn("Documento");
            modelo.addColumn("Nombres");
            modelo.addColumn("Apellidos");

            int valor = 0;
            while (resultado.next()) {
                modelo.addRow(new Object[]{});
                modelo.setValueAt(resultado.getString("Documento"), valor, 0);
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
}
