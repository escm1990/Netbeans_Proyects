/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ListaPacientes.java
 *
 * Created on 14-sep-2012, 1:04:13
 */
package vistas;

import accesoDatos.OperacionesConsulta;
import Operaciones.OperacionesInformes;
import accesoDatos.Operaciones;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 *
 * @author Chavez Vigil
 */
public class ListaPacientes extends javax.swing.JFrame {

    /** Creates new form ListaPacientes */
    Operaciones op = new Operaciones();
    OperacionesConsulta opc = new OperacionesConsulta();
    OperacionesInformes opi = new OperacionesInformes();
    
    
    public ListaPacientes() {
        initComponents();
        opc.listarPacientes(jtLista);
    }
    
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/iconBLH.png"));
        return retValue;
    }

    public void exportarExcel(String ruta) throws IOException, WriteException {
        try {

            //Exportación a Excel
            WritableWorkbook workbook = Workbook.createWorkbook(new File(ruta));
            WritableSheet sheet = workbook.createSheet("Listado de Pacientes", 0);

            //Encabezados de los datos del paciente
            Label label0 = new Label(0, 0, "Carnet");
            Label label1 = new Label(1, 0, "Nombres");
            Label label2 = new Label(2, 0, "Apellidos");
            Label label3 = new Label(3, 0, "FechaNac");
            Label label4 = new Label(4, 0, "SemGest");
            Label label5 = new Label(5, 0, "Sexo");
            Label label6 = new Label(6, 0, "Nit");
            Label label7 = new Label(7, 0, "Notas");
            Label label8 = new Label(8, 0, "Departamento");
            Label label9 = new Label(9, 0, "Municipio");
            Label label10 = new Label(10, 0, "Parto");
            Label label11 = new Label(11, 0, "Edad Materna");
            Label label12 = new Label(12, 0, "Gravidez");
            Label label13 = new Label(13, 0, "Patologia");
            Label label14 = new Label(14, 0, "Tipo");

            //Agregando datos en las celdas           
            sheet.addCell(label0);
            sheet.addCell(label1);
            sheet.addCell(label2);
            sheet.addCell(label3);
            sheet.addCell(label4);
            sheet.addCell(label5);
            sheet.addCell(label6);
            sheet.addCell(label7);
            sheet.addCell(label8);
            sheet.addCell(label9);
            sheet.addCell(label10);
            sheet.addCell(label11);
            sheet.addCell(label12);
            sheet.addCell(label13);
            sheet.addCell(label14);

            //Llenando los carnet
            for (int i = 0; i < jtLista.getRowCount(); i++) {
                Object object = jtLista.getValueAt(i, 0);
                sheet.addCell(new Label(0, i+1, String.valueOf(object)));
            }

            //Llenando los nombres
            for (int i = 0; i < jtLista.getRowCount(); i++) {
                Object object = jtLista.getValueAt(i, 1);
                sheet.addCell(new Label(1, i+1, String.valueOf(object)));
            }
            //Llenando los apellidos
            for (int i = 0; i < jtLista.getRowCount(); i++) {
                Object object = jtLista.getValueAt(i, 2);
                sheet.addCell(new Label(2, i+1, String.valueOf(object)));
            }
            //Llenando las fechas de nacimiento
            for (int i = 0; i < jtLista.getRowCount(); i++) {
                Object object = jtLista.getValueAt(i, 3);
                sheet.addCell(new Label(3, i+1, String.valueOf(object)));
            }
            //Llenando las semanas de gestación
            for (int i = 0; i < jtLista.getRowCount(); i++) {
                Object object = jtLista.getValueAt(i, 4);
                sheet.addCell(new Label(4, i+1, String.valueOf(object)));
            }
            //Llenando el sexo
            for (int i = 0; i < jtLista.getRowCount(); i++) {
                Object object = jtLista.getValueAt(i, 5);
                sheet.addCell(new Label(5, i+1, String.valueOf(object)));
            }
            //Llenando los nit
            for (int i = 0; i < jtLista.getRowCount(); i++) {
                Object object = jtLista.getValueAt(i, 6);
                sheet.addCell(new Label(6, i+1, String.valueOf(object)));
            }
            //Llenando las notas
            for (int i = 0; i < jtLista.getRowCount(); i++) {
                Object object = jtLista.getValueAt(i, 7);
                sheet.addCell(new Label(7, i+1, String.valueOf(object)));
            }
            //Llenando los departamento
            for (int i = 0; i < jtLista.getRowCount(); i++) {
                Object object = jtLista.getValueAt(i, 8);
                sheet.addCell(new Label(8, i+1, String.valueOf(object)));
            }
            //Llenando los municipio
            for (int i = 0; i < jtLista.getRowCount(); i++) {
                Object object = jtLista.getValueAt(i, 9);
                sheet.addCell(new Label(9, i+1, String.valueOf(object)));
            }
            //Llenando los parto
            for (int i = 0; i < jtLista.getRowCount(); i++) {
                Object object = jtLista.getValueAt(i, 10);
                sheet.addCell(new Label(10, i+1, String.valueOf(object)));
            }
            //Llenando la edad materna
            for (int i = 0; i < jtLista.getRowCount(); i++) {
                Object object = jtLista.getValueAt(i, 11);
                sheet.addCell(new Label(11, i+1, String.valueOf(object)));
            }
            //Llenando la gravidez
            for (int i = 0; i < jtLista.getRowCount(); i++) {
                Object object = jtLista.getValueAt(i, 12);
                sheet.addCell(new Label(12, i+1, String.valueOf(object)));
            }
            //Llenando las patologías
            for (int i = 0; i < jtLista.getRowCount(); i++) {
                Object object = jtLista.getValueAt(i, 13);
                sheet.addCell(new Label(13, i+1, String.valueOf(object)));
            }
            //Llenando los tipos de niños
            for (int i = 0; i < jtLista.getRowCount(); i++) {
                Object object = jtLista.getValueAt(i, 14);
                sheet.addCell(new Label(14, i+1, String.valueOf(object)));
            }

            //Escribiendo y cerrando el libro
            workbook.write();
            workbook.close();

            Process p = Runtime.getRuntime().exec("rundll32 SHELL32.DLL,ShellExec_RunDLL " + ruta);

        } catch (Exception e) {
            System.out.println("ERROR EN EXCEL: " + e.getMessage());
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtLista = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jcbBuscarPacientes = new javax.swing.JComboBox();
        jtfCriterio = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lista de Pacientes - Banco de Leche Humana");
        setIconImage(getIconImage());

        jPanel1.setBackground(new java.awt.Color(129, 158, 237));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        net.java.dev.koalalayout.KoalaLayout koalaLayout1 = new net.java.dev.koalalayout.KoalaLayout();
        koalaLayout1.setGridheight(30);
        koalaLayout1.setGridwidth(30);
        jPanel1.setLayout(koalaLayout1);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setAutoscrolls(true);
        jScrollPane1.setFocusable(false);
        jScrollPane1.setOpaque(false);

        jtLista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Carnet", "Nombres", "Apellidos", "FechaNac", "SemanasGestacion", "Sexo", "Nit", "Notas", "Departamento", "Municipio", "Parto", "EdadMaterna", "Gravidez", "Patologia", "Tipo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Float.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jtLista.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jtLista.setRowHeight(25);
        jScrollPane1.setViewportView(jtLista);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 28;
        gridBagConstraints.gridheight = 21;
        jPanel1.add(jScrollPane1, gridBagConstraints);

        jLabel1.setText("Listar por: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 3;
        jPanel1.add(jLabel1, gridBagConstraints);

        jcbBuscarPacientes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos", "Fecha", "Carnet", "Nombres", "Apellidos" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.gridheight = 3;
        jPanel1.add(jcbBuscarPacientes, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.gridheight = 3;
        jPanel1.add(jtfCriterio, gridBagConstraints);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/page_excel.png"))); // NOI18N
        jButton1.setText("EXCEL");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 23;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 3;
        jPanel1.add(jButton1, gridBagConstraints);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/magnifier.png"))); // NOI18N
        jButton2.setText("BUSCAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 18;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 3;
        jPanel1.add(jButton2, gridBagConstraints);

        jMenu1.setText("Archivo");

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem3.setText("Salir");
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Editar");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 964, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-980)/2, (screenSize.height-436)/2, 980, 436);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            exportarExcel(opi.obtenerRutaExcel());
        } catch (IOException ex) {
            Logger.getLogger(ControlPaciente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (WriteException ex) {
            Logger.getLogger(ControlPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
// TODO add your handling code here:
    if (jcbBuscarPacientes.getSelectedIndex() == 0) {
            opc.listarPacientes(jtLista);
        } else {
            if (jcbBuscarPacientes.getSelectedIndex() == 1) {
                op.listarPacientesFiltrados(jtLista, "FechaNac", jtfCriterio.getText());
                jtfCriterio.setText("");
            } else if (jcbBuscarPacientes.getSelectedIndex() == 2) {
                op.listarPacientesFiltrados(jtLista, "Carnet", jtfCriterio.getText());
                jtfCriterio.setText("");
            } else if (jcbBuscarPacientes.getSelectedIndex() == 3) {
                op.listarPacientesFiltrados(jtLista, "Nombres", jtfCriterio.getText());
                jtfCriterio.setText("");
            }else if (jcbBuscarPacientes.getSelectedIndex() == 4) {
                op.listarPacientesFiltrados(jtLista, "Apellidos", jtfCriterio.getText());
                jtfCriterio.setText("");
            }
        }
}//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListaPacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaPacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaPacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaPacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ListaPacientes().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox jcbBuscarPacientes;
    private javax.swing.JTable jtLista;
    private javax.swing.JTextField jtfCriterio;
    // End of variables declaration//GEN-END:variables
}
