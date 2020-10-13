package vistas;

import Instancia.InstanceOf;
import Instancia.InstanceOfTransport;
import accesoDatos.OperacionesDonacion;
import clases.Donacion;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class NuevaDonacion extends javax.swing.JFrame {

    OperacionesDonacion opD = new OperacionesDonacion();
    String fechaDon = "";
    String racAceptada = "";
    String racDescartada = "";
    String tipoDon = "";
    String idRuta = "";
    String peso = "";
    String estatura = "";
    String telefono = "";
    String direccion = "";
    String documento = "";

    /** Creates new form NuevaDonacion */
    public NuevaDonacion() {
        initComponents();
        documento = jlDocumento.getText();
        fecha();
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

        bgTipoDonacion = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jsPeso = new javax.swing.JSpinner();
        jsEstatura = new javax.swing.JSpinner();
        jtfRacionAceptada = new javax.swing.JTextField();
        jtfRacionDescartada = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jlDocumento = new javax.swing.JLabel();
        jrbLocal = new javax.swing.JRadioButton();
        jrbDomiciliar = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jlIdRuta = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jcFechaDonacion = new org.freixas.jcalendar.JCalendarCombo();
        jbIdRuta = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jbAceptar = new javax.swing.JButton();
        jbCancelar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Donación - Banco de Leche Humana");
        setIconImage(getIconImage());
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(142, 180, 227));
        net.java.dev.koalalayout.KoalaLayout koalaLayout1 = new net.java.dev.koalalayout.KoalaLayout();
        koalaLayout1.setGridheight(30);
        koalaLayout1.setGridwidth(40);
        jPanel1.setLayout(koalaLayout1);

        jPanel5.setBackground(new java.awt.Color(142, 180, 227));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        net.java.dev.koalalayout.KoalaLayout koalaLayout2 = new net.java.dev.koalalayout.KoalaLayout();
        koalaLayout2.setGridheight(30);
        koalaLayout2.setGridwidth(30);
        jPanel5.setLayout(koalaLayout2);

        jLabel16.setText("Estatura (cm):");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.gridheight = 3;
        jPanel5.add(jLabel16, gridBagConstraints);

        jLabel6.setText("Peso (Km):");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.gridheight = 3;
        jPanel5.add(jLabel6, gridBagConstraints);

        jsPeso.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                jsPesoMouseWheelMoved(evt);
            }
        });
        jsPeso.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jsPesoStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 15;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.gridheight = 3;
        jPanel5.add(jsPeso, gridBagConstraints);

        jsEstatura.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                jsEstaturaMouseWheelMoved(evt);
            }
        });
        jsEstatura.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jsEstaturaStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 15;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.gridheight = 3;
        jPanel5.add(jsEstatura, gridBagConstraints);

        jtfRacionAceptada.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfRacionAceptadaFocusLost(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 15;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.gridheight = 3;
        jPanel5.add(jtfRacionAceptada, gridBagConstraints);

        jtfRacionDescartada.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfRacionDescartadaFocusLost(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 15;
        gridBagConstraints.gridy = 20;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.gridheight = 3;
        jPanel5.add(jtfRacionDescartada, gridBagConstraints);

        jLabel11.setText("Ración Descartada (ml):");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 20;
        gridBagConstraints.gridwidth = 14;
        gridBagConstraints.gridheight = 3;
        jPanel5.add(jLabel11, gridBagConstraints);

        jLabel12.setText("Ración Aceptada (ml):");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 14;
        gridBagConstraints.gridheight = 3;
        jPanel5.add(jLabel12, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 20;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 20;
        gridBagConstraints.gridheight = 25;
        jPanel1.add(jPanel5, gridBagConstraints);

        jPanel7.setBackground(new java.awt.Color(142, 180, 227));
        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        net.java.dev.koalalayout.KoalaLayout koalaLayout3 = new net.java.dev.koalalayout.KoalaLayout();
        koalaLayout3.setGridheight(30);
        koalaLayout3.setGridwidth(30);
        jPanel7.setLayout(koalaLayout3);

        jlDocumento.setFont(new java.awt.Font("Tahoma", 1, 12));
        jlDocumento.setText("-----");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 20;
        gridBagConstraints.gridheight = 3;
        jPanel7.add(jlDocumento, gridBagConstraints);

        jrbLocal.setBackground(new java.awt.Color(142, 180, 227));
        bgTipoDonacion.add(jrbLocal);
        jrbLocal.setFont(new java.awt.Font("Tahoma", 0, 12));
        jrbLocal.setText("Local");
        jrbLocal.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jrbLocalItemStateChanged(evt);
            }
        });
        jrbLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbLocalActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 19;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.gridheight = 2;
        jPanel7.add(jrbLocal, gridBagConstraints);

        jrbDomiciliar.setBackground(new java.awt.Color(142, 180, 227));
        bgTipoDonacion.add(jrbDomiciliar);
        jrbDomiciliar.setFont(new java.awt.Font("Tahoma", 0, 12));
        jrbDomiciliar.setText("Domiciliar");
        jrbDomiciliar.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jrbDomiciliarItemStateChanged(evt);
            }
        });
        jrbDomiciliar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbDomiciliarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 23;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.gridheight = 2;
        jPanel7.add(jrbDomiciliar, gridBagConstraints);

        jLabel5.setText("IdRuta:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 17;
        gridBagConstraints.gridy = 27;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.gridheight = 2;
        jPanel7.add(jLabel5, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 22;
        gridBagConstraints.gridy = 27;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.gridheight = 2;
        jPanel7.add(jlIdRuta, gridBagConstraints);

        jLabel18.setText("Fecha de donación:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 11;
        gridBagConstraints.gridheight = 3;
        jPanel7.add(jLabel18, gridBagConstraints);

        jcFechaDonacion.addDateListener(new org.freixas.jcalendar.DateListener() {
            public void dateChanged(org.freixas.jcalendar.DateEvent evt) {
                jcFechaDonacionDateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 27;
        gridBagConstraints.gridheight = 4;
        jPanel7.add(jcFechaDonacion, gridBagConstraints);

        jbIdRuta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/add.png"))); // NOI18N
        jbIdRuta.setToolTipText("Selecciona ruta en que fue hecha la doncacion");
        jbIdRuta.setEnabled(false);
        jbIdRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbIdRutaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 19;
        gridBagConstraints.gridy = 23;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 3;
        jPanel7.add(jbIdRuta, gridBagConstraints);

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel19.setText("Tipo de donación:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.gridwidth = 11;
        gridBagConstraints.gridheight = 3;
        jPanel7.add(jLabel19, gridBagConstraints);

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel20.setText("Documento:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.gridheight = 3;
        jPanel7.add(jLabel20, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 20;
        gridBagConstraints.gridheight = 25;
        jPanel1.add(jPanel7, gridBagConstraints);

        jbAceptar.setText("Aceptar");
        jbAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAceptarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 28;
        gridBagConstraints.gridy = 26;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.gridheight = 3;
        jPanel1.add(jbAceptar, gridBagConstraints);

        jbCancelar1.setText("Cancelar");
        jbCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelar1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 34;
        gridBagConstraints.gridy = 26;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.gridheight = 3;
        jPanel1.add(jbCancelar1, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-681)/2, (screenSize.height-383)/2, 681, 383);
    }// </editor-fold>//GEN-END:initComponents

    public void fecha() {
        Date fechaNa = jcFechaDonacion.getDate();
//        fecha = fechaNa.toString();
//        calcularEdad(fechaNa);
        java.util.Date date = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        fechaDon = sdf.format(fechaNa);
    }
    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        this.setVisible(false);
    }//GEN-LAST:event_formWindowClosed

    private void jbIdRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbIdRutaActionPerformed
        new InstanceOfTransport().transporte.setVisible(true);
        RecoleccionDomiciliar.jlIndiceOculto.setText("1");
        RecoleccionDomiciliar.jbAnyadir.setEnabled(true);
//        this.setVisible(false);
    }//GEN-LAST:event_jbIdRutaActionPerformed

private void jsPesoMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_jsPesoMouseWheelMoved
    jsPeso.setValue(new Integer(((Integer) jsPeso.getValue()).intValue() - evt.getWheelRotation()));
}//GEN-LAST:event_jsPesoMouseWheelMoved

private void jsPesoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jsPesoStateChanged
    peso = jsPeso.getValue().toString();
}//GEN-LAST:event_jsPesoStateChanged

private void jsEstaturaMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_jsEstaturaMouseWheelMoved
    jsEstatura.setValue(new Integer(((Integer) jsEstatura.getValue()).intValue() - evt.getWheelRotation()));
}//GEN-LAST:event_jsEstaturaMouseWheelMoved

private void jsEstaturaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jsEstaturaStateChanged
    estatura = jsEstatura.getValue().toString();
}//GEN-LAST:event_jsEstaturaStateChanged

private void jbCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelar1ActionPerformed
//    new InstanceOf().donante.setVisible(true);
    this.setVisible(false);
}//GEN-LAST:event_jbCancelar1ActionPerformed

private void jbAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAceptarActionPerformed
    if (bgTipoDonacion.isSelected(null) || jtfRacionAceptada.getText().equals("") || jtfRacionDescartada.getText().equals("")) {
        JOptionPane.showMessageDialog(null, "¡Por favor, complete los datos del paciente!");
    } else {
        documento = jlDocumento.getText();
        Donacion don = new Donacion(fechaDon, tipoDon, racAceptada, racDescartada, documento, estatura, peso);
        if (jrbLocal.isSelected()) {
            idRuta = "1";
            opD.almacenarDonacion(don, idRuta);
        } else if (jrbDomiciliar.isSelected()) {
            idRuta = jlIdRuta.getText();
            opD.almacenarDonacion(don, idRuta);

        }
        opD.listarDonanciones(RecoleccionLeche.jtDonaciones, documento);
        this.setVisible(false);
    }


}//GEN-LAST:event_jbAceptarActionPerformed

private void jtfRacionAceptadaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfRacionAceptadaFocusLost
    racAceptada = jtfRacionAceptada.getText();
}//GEN-LAST:event_jtfRacionAceptadaFocusLost

private void jcFechaDonacionDateChanged(org.freixas.jcalendar.DateEvent evt) {//GEN-FIRST:event_jcFechaDonacionDateChanged
    fecha();
}//GEN-LAST:event_jcFechaDonacionDateChanged

private void jrbLocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbLocalActionPerformed
        tipoDon = "Local";
}//GEN-LAST:event_jrbLocalActionPerformed

private void jrbDomiciliarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbDomiciliarActionPerformed
    tipoDon = "Domiciliar";
}//GEN-LAST:event_jrbDomiciliarActionPerformed

private void jtfRacionDescartadaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfRacionDescartadaFocusLost
    racDescartada = jtfRacionDescartada.getText();
}//GEN-LAST:event_jtfRacionDescartadaFocusLost

private void jrbDomiciliarItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jrbDomiciliarItemStateChanged
    jbIdRuta.setEnabled(true);
}//GEN-LAST:event_jrbDomiciliarItemStateChanged

private void jrbLocalItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jrbLocalItemStateChanged
    jbIdRuta.setEnabled(false);
}//GEN-LAST:event_jrbLocalItemStateChanged

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
            java.util.logging.Logger.getLogger(NuevaDonacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuevaDonacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuevaDonacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevaDonacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new NuevaDonacion().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgTipoDonacion;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JButton jbAceptar;
    private javax.swing.JButton jbCancelar1;
    private javax.swing.JButton jbIdRuta;
    public static org.freixas.jcalendar.JCalendarCombo jcFechaDonacion;
    public static javax.swing.JLabel jlDocumento;
    public static javax.swing.JLabel jlIdRuta;
    public static javax.swing.JRadioButton jrbDomiciliar;
    public static javax.swing.JRadioButton jrbLocal;
    public static javax.swing.JSpinner jsEstatura;
    public static javax.swing.JSpinner jsPeso;
    public static javax.swing.JTextField jtfRacionAceptada;
    public static javax.swing.JTextField jtfRacionDescartada;
    // End of variables declaration//GEN-END:variables
}
