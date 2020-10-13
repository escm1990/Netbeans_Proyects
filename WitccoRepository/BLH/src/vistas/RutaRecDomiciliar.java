package vistas;

import Instancia.InstanceOfTransport;
import Instancia.InstanceOfGeneralidades;
import Instancia.InstanceOfConsult;
import accesoDatos.Operaciones;
import clases.Motorista;
import clases.VisitaDonacion;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class RutaRecDomiciliar extends javax.swing.JFrame {

    /** Creates new form RutaRecDomiciliar */
    static public String motorista = "";
    static public String vehiculo = "";
    static public String medico = "";
    public int filaAnterior = 0;
    Operaciones op = new Operaciones();

    public RutaRecDomiciliar() {
        initComponents();
        this.jtfMotorista.setText(motorista);
        this.jtfVehiculo.setText(vehiculo);
        this.jtfMedico.setText(medico);
    }
    
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/iconBLH.png"));
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jlIndiceOc = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        fechaDos = new org.freixas.jcalendar.JCalendarCombo();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTrayectos = new javax.swing.JTable();
        jbGuardar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jbAnyadirMotorista = new javax.swing.JButton();
        jtfMotorista = new javax.swing.JTextField();
        jtfVehiculo = new javax.swing.JTextField();
        jbAnyadirVeh = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jtfMedico = new javax.swing.JTextField();
        jbAnyadirMedico = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jbAgregarTrayectoria = new javax.swing.JButton();
        jbModificar = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nueva Ruta - Banco de Leche Humana");
        setIconImage(getIconImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(142, 180, 227));
        net.java.dev.koalalayout.KoalaLayout koalaLayout1 = new net.java.dev.koalalayout.KoalaLayout();
        koalaLayout1.setGridheight(20);
        koalaLayout1.setGridwidth(60);
        jPanel1.setLayout(koalaLayout1);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 17;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        jPanel1.add(jlIndiceOc, gridBagConstraints);

        jPanel3.setBackground(new java.awt.Color(142, 180, 227));
        net.java.dev.koalalayout.KoalaLayout koalaLayout3 = new net.java.dev.koalalayout.KoalaLayout();
        koalaLayout3.setGridheight(10);
        koalaLayout3.setGridwidth(15);
        jPanel3.setLayout(koalaLayout3);

        jLabel2.setText("Fecha de Recoleccion:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.gridheight = 3;
        jPanel3.add(jLabel2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 13;
        gridBagConstraints.gridheight = 5;
        jPanel3.add(fechaDos, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 20;
        gridBagConstraints.gridheight = 3;
        jPanel1.add(jPanel3, gridBagConstraints);

        jPanel4.setBackground(new java.awt.Color(142, 180, 227));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        net.java.dev.koalalayout.KoalaLayout koalaLayout7 = new net.java.dev.koalalayout.KoalaLayout();
        koalaLayout7.setGridheight(30);
        koalaLayout7.setGridwidth(15);
        jPanel4.setLayout(koalaLayout7);

        jtTrayectos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Hora", "Kilometraje", "Lugar Salida", "Lugar LLegada", "Distancia (km)"
            }
        ));
        jtTrayectos.setRowHeight(27);
        jtTrayectos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtTrayectosMouseClicked(evt);
            }
        });
        jtTrayectos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtTrayectosFocusLost(evt);
            }
        });
        jtTrayectos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtTrayectosKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtTrayectosKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jtTrayectos);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 15;
        gridBagConstraints.gridheight = 30;
        jPanel4.add(jScrollPane1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 20;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 38;
        gridBagConstraints.gridheight = 14;
        jPanel1.add(jPanel4, gridBagConstraints);

        jbGuardar.setText("Guardar");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 47;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.gridwidth = 5;
        jPanel1.add(jbGuardar, gridBagConstraints);

        jbCancelar.setText("Cancelar");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 53;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.gridwidth = 5;
        jPanel1.add(jbCancelar, gridBagConstraints);

        jPanel5.setBackground(new java.awt.Color(142, 180, 227));
        jPanel5.setToolTipText("Agrega el Veh");
        net.java.dev.koalalayout.KoalaLayout koalaLayout9 = new net.java.dev.koalalayout.KoalaLayout();
        koalaLayout9.setGridheight(30);
        koalaLayout9.setGridwidth(15);
        jPanel5.setLayout(koalaLayout9);

        jLabel8.setText("Motorista:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 2;
        jPanel5.add(jLabel8, gridBagConstraints);

        jbAnyadirMotorista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/add.png"))); // NOI18N
        jbAnyadirMotorista.setToolTipText("Agrega el motorista encargado de la ruta");
        jbAnyadirMotorista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAnyadirMotoristaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 3;
        jPanel5.add(jbAnyadirMotorista, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.gridheight = 3;
        jPanel5.add(jtfMotorista, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.gridheight = 3;
        jPanel5.add(jtfVehiculo, gridBagConstraints);

        jbAnyadirVeh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/add.png"))); // NOI18N
        jbAnyadirVeh.setToolTipText("Agrega el Vehículo utilizado en la ruta");
        jbAnyadirVeh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAnyadirVehActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 3;
        jPanel5.add(jbAnyadirVeh, gridBagConstraints);

        jLabel9.setText("Vehículo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        jPanel5.add(jLabel9, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.gridheight = 3;
        jPanel5.add(jtfMedico, gridBagConstraints);

        jbAnyadirMedico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/add.png"))); // NOI18N
        jbAnyadirMedico.setToolTipText("Agrega el médico que acompaño la ruta");
        jbAnyadirMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAnyadirMedicoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 3;
        jPanel5.add(jbAnyadirMedico, gridBagConstraints);

        jLabel10.setText("Médico:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        jPanel5.add(jLabel10, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 20;
        gridBagConstraints.gridheight = 12;
        jPanel1.add(jPanel5, gridBagConstraints);

        jbAgregarTrayectoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/add.png"))); // NOI18N
        jbAgregarTrayectoria.setToolTipText("Agrega un nuevo trayecto en la ruta");
        jbAgregarTrayectoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarTrayectoriaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 20;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        jPanel1.add(jbAgregarTrayectoria, gridBagConstraints);

        jbModificar.setText("Modificar");
        jbModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 20;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.gridwidth = 5;
        jPanel1.add(jbModificar, gridBagConstraints);

        jbEliminar.setText("Eliminar");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 26;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.gridwidth = 5;
        jPanel1.add(jbEliminar, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 934, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-950)/2, (screenSize.height-539)/2, 950, 539);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        comoSalir2();
    }//GEN-LAST:event_formWindowClosed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        comoSalir2();
    }//GEN-LAST:event_jbCancelarActionPerformed

private void jbAnyadirMotoristaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAnyadirMotoristaActionPerformed
    String id = jlIndiceOc.getText();
    new InstanceOfGeneralidades().admMotoristas.setVisible(true);
    AdministrarMotoristas.jlIndiceOculto.setText("2");
    AdministrarMotoristas.jlIndiceOculto1.setText(id);
    this.setVisible(false);
}//GEN-LAST:event_jbAnyadirMotoristaActionPerformed

private void jbAnyadirVehActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAnyadirVehActionPerformed
    String id = jlIndiceOc.getText();
    new InstanceOfGeneralidades().admVehiculos.setVisible(true);
    AdministrarVehiculos.jlIndiceOculto.setText("2");
    AdministrarVehiculos.jlIndiceOculto1.setText(id);
    this.setVisible(false);

}//GEN-LAST:event_jbAnyadirVehActionPerformed

private void jbAnyadirMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAnyadirMedicoActionPerformed

    try {
        String id = jlIndiceOc.getText();
        new AdministrarMedic().setVisible(true);
        AdministrarMedic.jlIndiceOculto.setText("3");
        AdministrarMedic.jlIndiceOculto1.setText(id);
        this.setVisible(false);
    } catch (Exception e) {
    }
}//GEN-LAST:event_jbAnyadirMedicoActionPerformed

    public void comoSalir() {
        try {
            int var = Integer.parseInt(jlIndiceOc.getText());
            String ind = RutaRecDomiciliar.jlIndiceOc.getText();

            switch (var) {
                case 1:
                    this.setVisible(false);
                    new InstanceOfTransport().transporte.setVisible(true);
                    RecoleccionDomiciliar.jlIndiceOculto.setText(ind);
                    RecoleccionDomiciliar.jbAnyadir.setEnabled(true);
                    break;
                case 2:
                    this.setVisible(false);
                    new InstanceOfTransport().transporte.setVisible(true);
                    RecoleccionDomiciliar.jlIndiceOculto.setText(ind);
                    RecoleccionDomiciliar.jbAnyadir.setEnabled(false);
                    break;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Error: " + e.getMessage());
        }
    }

    public void comoSalir2() {
        try {
            int var = Integer.parseInt(jlIndiceOc.getText());
            String ind = RutaRecDomiciliar.jlIndiceOc.getText();

            switch (var) {
                case 1:
                    new InstanceOfTransport().transporte.setVisible(true);
                    RecoleccionDomiciliar.jlIndiceOculto.setText(ind);
                    RecoleccionDomiciliar.jbAnyadir.setEnabled(true);
                    motorista = "";
                    vehiculo = "";
                    medico = "";
                    this.setVisible(false);
                    break;
                case 2:
                    new InstanceOfTransport().transporte.setVisible(true);
                    RecoleccionDomiciliar.jlIndiceOculto.setText(ind);
                    RecoleccionDomiciliar.jbAnyadir.setEnabled(false);
                    motorista = "";
                    vehiculo = "";
                    medico = "";
                    this.setVisible(false);
                    break;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Error: " + e.getMessage());
        }
    }
    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        try {
            DefaultTableModel trayectos = (DefaultTableModel) jtTrayectos.getModel();

            if (jtTrayectos.getRowCount() > 1
                    && !jtTrayectos.getValueAt(jtTrayectos.getSelectedRow(), 0).equals("")
                    && !jtTrayectos.getValueAt(jtTrayectos.getSelectedRow(), 1).equals("") && !jtfMedico.getText().equals("")
                    && !jtfMotorista.getText().equals("")
                    && !jtfVehiculo.getText().equals("") && !jtTrayectos.getValueAt(jtTrayectos.getSelectedRow(), 2).equals("")
                    && !jtTrayectos.getValueAt(jtTrayectos.getSelectedRow(), 3).equals("")
                    && !jtTrayectos.getValueAt(jtTrayectos.getSelectedRow(), 4).equals("")) {
                op.almacenarRuta(nuevaVisita(), trayectos);
                limpiarGUI();
                comoSalir();
            } else {
                JOptionPane.showMessageDialog(rootPane, "¡Por favor, ingrese al menos 2 rutas \ny complete los campos!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "¡Por favor, complete los campos!");
        }
    }//GEN-LAST:event_jbGuardarActionPerformed

private void jbAgregarTrayectoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarTrayectoriaActionPerformed
    try {
        DefaultTableModel model = (DefaultTableModel) jtTrayectos.getModel();
        Object fila[] = {"", "", "", "", ""};
        model.addRow(fila);
        jbAgregarTrayectoria.setEnabled(false);
        jbGuardar.setEnabled(false);
    } catch (Exception e) {
    }
}//GEN-LAST:event_jbAgregarTrayectoriaActionPerformed

private void jtTrayectosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtTrayectosKeyPressed
    filaAnterior = jtTrayectos.getSelectedRow();

}//GEN-LAST:event_jtTrayectosKeyPressed

private void jtTrayectosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtTrayectosKeyReleased
    int key = evt.getKeyChar();

    if (key == KeyEvent.VK_TAB && !jtTrayectos.getValueAt(filaAnterior, 0).equals("") && !jtTrayectos.getValueAt(filaAnterior, 1).equals("") && !jtTrayectos.getValueAt(filaAnterior, 2).equals("") && !jtTrayectos.getValueAt(filaAnterior, 3).equals("") && !jtTrayectos.getValueAt(filaAnterior, 4).equals("")) {
        this.jbAgregarTrayectoria.setEnabled(true);
        this.jbGuardar.setEnabled(true);
    }
}//GEN-LAST:event_jtTrayectosKeyReleased

private void jtTrayectosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtTrayectosMouseClicked
    filaAnterior = jtTrayectos.getSelectedRow();

}//GEN-LAST:event_jtTrayectosMouseClicked

private void jtTrayectosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtTrayectosFocusLost
    if (!jtTrayectos.getValueAt(filaAnterior, 0).equals("") && !jtTrayectos.getValueAt(filaAnterior, 1).equals("") && !jtTrayectos.getValueAt(filaAnterior, 2).equals("") && !jtTrayectos.getValueAt(filaAnterior, 3).equals("") && !jtTrayectos.getValueAt(filaAnterior, 4).equals("")) {
        this.jbAgregarTrayectoria.setEnabled(true);
        this.jbGuardar.setEnabled(true);
    }
}//GEN-LAST:event_jtTrayectosFocusLost

    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
        // TODO add your handling code here:
        try {
            op.modificarRutas(jtTrayectos);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jbModificarActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        // TODO add your handling code here:
        try {
            DefaultTableModel model = (DefaultTableModel) jtTrayectos.getModel();
            if (jtTrayectos.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(rootPane, "¡Seleccione la ruta a eliminar!");
            } else {
                int msj = JOptionPane.showConfirmDialog(null, "¿En verdad desea eliminar la ruta?", "Confirmación", JOptionPane.YES_NO_OPTION);
                if (msj == 0) {
                    op.eliminarRuta(Integer.parseInt(jtTrayectos.getValueAt(jtTrayectos.getSelectedRow(), 0).toString()));
                    model.removeRow(jtTrayectos.getSelectedRow());
                }
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jbEliminarActionPerformed

    public VisitaDonacion nuevaVisita() {
        VisitaDonacion visita = null;
        try {
            Date fecha = new Date(fechaDos.getDate().getTime());
            visita = new VisitaDonacion(fecha, jtfMedico.getText(), jtfVehiculo.getText(), jtfMotorista.getText());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Error: " + e.getMessage());
        }
        return visita;
    }

    public void limpiarGUI() {
        jtfMedico.setText("");
        jtfMotorista.setText("");
        jtfVehiculo.setText("");
        motorista = "";
        medico = "";
        vehiculo = "";
    }

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
            java.util.logging.Logger.getLogger(RutaRecDomiciliar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RutaRecDomiciliar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RutaRecDomiciliar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RutaRecDomiciliar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new RutaRecDomiciliar().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static org.freixas.jcalendar.JCalendarCombo fechaDos;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JButton jbAgregarTrayectoria;
    public static javax.swing.JButton jbAnyadirMedico;
    public static javax.swing.JButton jbAnyadirMotorista;
    public static javax.swing.JButton jbAnyadirVeh;
    private javax.swing.JButton jbCancelar;
    public static javax.swing.JButton jbEliminar;
    public static javax.swing.JButton jbGuardar;
    public static javax.swing.JButton jbModificar;
    public static javax.swing.JLabel jlIndiceOc;
    public static javax.swing.JTable jtTrayectos;
    public static javax.swing.JTextField jtfMedico;
    public static javax.swing.JTextField jtfMotorista;
    public static javax.swing.JTextField jtfVehiculo;
    // End of variables declaration//GEN-END:variables
}
