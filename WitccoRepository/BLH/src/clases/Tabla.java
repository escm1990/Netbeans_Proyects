/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import accesoDatos.Conexion;
import java.beans.Statement;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JViewport;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class Tabla {

    private Conexion con = new Conexion();

    public DefaultTableModel listarPacientes() {
        modeloEditado res = new modeloEditado();
        res.addColumn("");
        res.addColumn("Paciente");
        String pacientes[] = new String[5];

        for (int i = 0; i < pacientes.length; i++) {
            pacientes[i] = "paciente " + i;

        }


        int x = 0;
        while (x < pacientes.length) {
            res.addRow(new Object[]{});
            res.setValueAt(pacientes[x], x, 1);
            x++;
        }


        return res;
    }

    public class modeloEditado extends DefaultTableModel {

//        JViewport scroll = (JViewport) tbLista.getParent();
//        int ancho = scroll.getWidth();
        int anchoColumna;

        /** Segunda columna ComboBox, cuarta Boolean y el resto Object */
        @Override
        public Class getColumnClass(int columna) {
            if (columna == 0) {
                return Boolean.class;
            }
            return Object.class;
        }
//
//        @Override
//        public boolean isCellEditable(int row, int column) {
//            if ((column == 3) || (column == 5)) {
//                return true;
//            }
//            return false;
//        }
    }
}
