/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Operaciones;

import accesoDatos.*;
import clases.Informe;
import clases.InformeProduccion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Chavez Vigil
 */
public class OperacionesInformes {

    Conexion con = new Conexion();

    public void almacenarInforme(Informe info) {
        try {
            PreparedStatement sen = con.conectar().prepareStatement("UPDATE InformeLaboratorista SET Fecha ='" + info.getFecha() + "', MuestrasAna ='" + info.getMuestrasA() + "', PresenciaN ='" + info.getPreN() + "', PresenciaPor ='" + info.getPrePor() + "', AusenciaN ='" + info.getAusN() + "', AusenciaPor ='" + info.getAusPor() + "' WHERE Fecha ='" + info.getFecha() + "'");
            if (sen.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "¡Datos Modificados!");
            } else {
                PreparedStatement sentencia = con.conectar().prepareStatement("INSERT INTO InformeLaboratorista (Fecha,MuestrasAna,PresenciaN,PresenciaPor,AusenciaN,AusenciaPor) VALUES ('" + info.getFecha() + "','" + info.getMuestrasA() + "','" + info.getPreN() + "','" + info.getPrePor() + "','" + info.getAusN() + "','" + info.getAusPor() + "')");
                sentencia.executeUpdate();
                con.desconectar();
                JOptionPane.showMessageDialog(null, "¡Datos Almacenados!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public void eliminarInforme(Informe info) {
        try {
            PreparedStatement sentencia = con.conectar().prepareStatement("DELETE FROM InformeLaboratorista WHERE Fecha = '" + info.getFecha() + "'");
            if (sentencia.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "¡Eliminado Correctamente!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public void listarInformeLab(JTable tablita) {
        try {
            Statement sentencia = null;
            ResultSet resultado = null;
            sentencia = con.conectar().createStatement();
            resultado = sentencia.executeQuery("SELECT * FROM InformeLaboratorista ORDER BY Fecha");
            DefaultTableModel modelo = new DefaultTableModel();

            modelo.addColumn("Fecha");
            modelo.addColumn("Muestras");
            modelo.addColumn("PresenciaN");
            modelo.addColumn("PresenciaPor");
            modelo.addColumn("AusenciaN");
            modelo.addColumn("AusenciaPor");
            int valor = 0;
            while (resultado.next()) {
                modelo.addRow(new Object[]{});
                modelo.setValueAt(resultado.getString("Fecha"), valor, 0);
                modelo.setValueAt(resultado.getInt("MuestrasAna"), valor, 1);
                modelo.setValueAt(resultado.getInt("PresenciaN"), valor, 2);
                modelo.setValueAt(resultado.getFloat("PresenciaPor"), valor, 3);
                modelo.setValueAt(resultado.getInt("AusenciaN"), valor, 4);
                modelo.setValueAt(resultado.getFloat("AusenciaPor"), valor, 5);
                valor = valor + 1;
            }
            tablita.setModel(modelo);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        con.desconectar();
    }

    public void listarInformeProd(JTable tablita) {
        try {
            Statement sentencia = null;
            ResultSet resultado = null;
            sentencia = con.conectar().createStatement();
            resultado = sentencia.executeQuery("SELECT * FROM InformeProduccion ORDER BY IdProduccion");
            DefaultTableModel modelo = new DefaultTableModel();

            modelo.addColumn("Fecha");
            modelo.addColumn("At. Indivudial");
            modelo.addColumn("At. Grupal");
            modelo.addColumn("Vis. Dom.");
            modelo.addColumn("Total Aten.");
            modelo.addColumn("Rec (lt)");
            modelo.addColumn("Dist (lt)");
            modelo.addColumn("Donantes");
            modelo.addColumn("Receptores");
            modelo.addColumn("Microbiologicos");
            modelo.addColumn("Fis-Quim");
            modelo.addColumn("Crematocrito");
            modelo.addColumn("AcidezD");
            modelo.addColumn("Tot. Anal. FQ");
            modelo.addColumn("Tot. General");
            int valor = 0;
            while (resultado.next()) {
                modelo.addRow(new Object[]{});
                modelo.setValueAt(resultado.getDate("IdProduccion"), valor, 0);
                modelo.setValueAt(resultado.getInt("AtenIndividual"), valor, 1);
                modelo.setValueAt(resultado.getInt("AtenGrupo"), valor, 2);
                modelo.setValueAt(resultado.getInt("VisDom"), valor, 3);
                modelo.setValueAt(resultado.getInt("TotalAten"), valor, 4);
                modelo.setValueAt(resultado.getDouble("Recolectado"), valor, 5);
                modelo.setValueAt(resultado.getDouble("Distribuido"), valor, 6);
                modelo.setValueAt(resultado.getInt("DonantesP"), valor, 7);
                modelo.setValueAt(resultado.getInt("ReceptoresP"), valor, 8);
                modelo.setValueAt(resultado.getDouble("Microbiologia"), valor, 9);
                modelo.setValueAt(resultado.getDouble("FisQui"), valor, 10);
                modelo.setValueAt(resultado.getDouble("Crematocrito"), valor, 11);
                modelo.setValueAt(resultado.getDouble("AcidezDornic"), valor, 12);
                modelo.setValueAt(resultado.getDouble("TotAnaFQ"), valor, 13);
                modelo.setValueAt(resultado.getDouble("TotGenAna"), valor, 14);
                valor = valor + 1;
            }
            tablita.setModel(modelo);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        con.desconectar();
    }

    public String obtenerRutaExcel() {
        String rutaE = null;
        try {
            JFileChooser jfc = new JFileChooser();
            jfc.showSaveDialog(null);
            rutaE = jfc.getSelectedFile().getPath() + ".xls";
            System.out.println(rutaE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede exportar a Excel");
        }
        return rutaE;
    }

    public void almacenarInformeProd(InformeProduccion info) {
        try {
            PreparedStatement sen = con.conectar().prepareStatement("UPDATE InformeProduccion SET IdProduccion ='" + info.getIdProduccion() + "', AtenIndividual ='" + info.getAtenIndivisual() + "', AtenGrupo ='" + info.getAtenGrupo() + "', VisDom ='" + info.getVisDom() + "', TotalAten ='" + info.getTotalAten() + "', Recolectado ='" + info.getRecolectado() + "', Distribuido ='" + info.getDistribuido() + "', DonantesP ='" + info.getDonantesP() + "', ReceptoresP ='" + info.getReceptoresP() + "', Microbiologia ='" + info.getMicrobiologia() + "', FisQui ='" + info.getFisQui() + "', Crematocrito ='" + info.getCrematocrito() + "', AcidezDornic ='" + info.getAcidezDornic() + "', TotAnaFQ ='" + info.getTotAnaFQ() + "', TotGenAna ='" + info.getTotGenAna() + "' WHERE IdProduccion ='" + info.getIdProduccion() + "'");
            if (sen.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "¡Datos Modificados!");
            } else {
                PreparedStatement sentencia = con.conectar().prepareStatement("INSERT INTO InformeProduccion (IdProduccion,AtenIndividual,AtenGrupo,VisDom,TotalAten,Recolectado,Distribuido,DonantesP,ReceptoresP,Microbiologia,FisQui,Crematocrito,AcidezDornic,TotAnaFQ,TotGenAna) VALUES ('" + info.getIdProduccion() + "','" + info.getAtenIndivisual() + "','" + info.getAtenGrupo() + "','" + info.getVisDom() + "','" + info.getTotalAten() + "','" + info.getRecolectado() + "','" + info.getDistribuido() + "','" + info.getDonantesP() + "','" + info.getReceptoresP() + "','" + info.getMicrobiologia() + "','" + info.getFisQui() + "','" + info.getCrematocrito() + "','" + info.getAcidezDornic() + "','" + info.getTotAnaFQ() + "','" + info.getTotGenAna() + "')");
                sentencia.executeUpdate();
                con.desconectar();
                JOptionPane.showMessageDialog(null, "¡Datos Almacenados!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public void eliminarInformeProd(InformeProduccion info) {
        try {
            PreparedStatement sentencia = con.conectar().prepareStatement("DELETE FROM InformeProduccion WHERE IdProduccion = '" + info.getIdProduccion() + "'");
            if (sentencia.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "¡Eliminado Correctamente!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
}
