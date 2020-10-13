package vistas;

import Instancia.InstanceOf;
import accesoDatos.OperacionesUsuarios;
import clases.Usuario;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

public class AdminPassword extends javax.swing.JFrame {

    /** Creates new form AdminPassword */
    OperacionesUsuarios op = new OperacionesUsuarios();
//    String pass = op.password();
//    String user = op.usuario();
    String usuario;
    String Contraseña;
    boolean admin = true;

    public AdminPassword() {
        initComponents();
    }
    
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/iconBLH.png"));
        return retValue;
    }

    public void limpiarGUI() {
        jtfUsuario.setText("");
        jtfNuevoUsuario.setText("");
        jpfContraseña.setText("");
        jpfNuevaContraseña.setText("");
        jpfRepitaContraseña.setText("");
        jlErrorLogin.setText("");
        jlErrorNuevoUsuario.setText("");
    }

    public boolean verificarDatos() {
        boolean res = false;
        if (jtfUsuario.getText() != ""
                && jpfContraseña.getText() != ""
                && jtfNuevoUsuario.getText() != ""
                && jpfNuevaContraseña.getText() != ""
                && jpfRepitaContraseña.getText() != "") {
            res = true;
        } else {
            res = false;
        }
        return res;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtfUsuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jpfContraseña = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jlErrorLogin = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jtfNuevoUsuario = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jpfNuevaContraseña = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        jpfRepitaContraseña = new javax.swing.JPasswordField();
        jlErrorNuevoUsuario = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jbAceptar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jbSalir = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jbLimpiar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Administradores y Contraseñas - Banco de Leche Humana");
        setIconImage(getIconImage());
        setMinimumSize(new java.awt.Dimension(542, 411));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(142, 180, 227));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ingresar Datos Actuales", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        net.java.dev.koalalayout.KoalaLayout koalaLayout1 = new net.java.dev.koalalayout.KoalaLayout();
        koalaLayout1.setGridheight(15);
        koalaLayout1.setGridwidth(15);
        jPanel1.setLayout(koalaLayout1);

        jLabel1.setText("Usuario: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        jPanel1.add(jLabel1, gridBagConstraints);

        jtfUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfUsuarioFocusLost(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.gridheight = 3;
        jPanel1.add(jtfUsuario, gridBagConstraints);

        jLabel2.setText("Contraseña: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 5;
        jPanel1.add(jLabel2, gridBagConstraints);

        jpfContraseña.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jpfContraseñaFocusLost(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.gridheight = 3;
        jPanel1.add(jpfContraseña, gridBagConstraints);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Usuario Tarjeta.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.gridheight = 6;
        jPanel1.add(jLabel3, gridBagConstraints);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Contraseña Sin Sombra.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 7;
        jPanel1.add(jLabel4, gridBagConstraints);

        jlErrorLogin.setForeground(new java.awt.Color(255, 0, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 10;
        jPanel1.add(jlErrorLogin, gridBagConstraints);

        jPanel2.setBackground(new java.awt.Color(142, 180, 227));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nuevos Datos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        net.java.dev.koalalayout.KoalaLayout koalaLayout2 = new net.java.dev.koalalayout.KoalaLayout();
        koalaLayout2.setGridheight(15);
        koalaLayout2.setGridwidth(15);
        jPanel2.setLayout(koalaLayout2);

        jLabel5.setText("Nuevo Usuario:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        jPanel2.add(jLabel5, gridBagConstraints);

        jtfNuevoUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfNuevoUsuarioFocusLost(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.gridheight = 3;
        jPanel2.add(jtfNuevoUsuario, gridBagConstraints);

        jLabel6.setText("Contraseña:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 5;
        jPanel2.add(jLabel6, gridBagConstraints);

        jpfNuevaContraseña.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jpfNuevaContraseñaFocusLost(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.gridheight = 3;
        jPanel2.add(jpfNuevaContraseña, gridBagConstraints);

        jLabel7.setText("Repita Contraseña:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 5;
        jPanel2.add(jLabel7, gridBagConstraints);

        jpfRepitaContraseña.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jpfRepitaContraseñaFocusLost(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.gridheight = 3;
        jPanel2.add(jpfRepitaContraseña, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 9;
        jPanel2.add(jlErrorNuevoUsuario, gridBagConstraints);

        jPanel3.setBackground(new java.awt.Color(142, 180, 227));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Seleccionar Cambios", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jPanel4.setBackground(new java.awt.Color(142, 180, 227));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Aceptar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        net.java.dev.koalalayout.KoalaLayout koalaLayout3 = new net.java.dev.koalalayout.KoalaLayout();
        koalaLayout3.setGridheight(4);
        koalaLayout3.setGridwidth(4);
        jPanel4.setLayout(koalaLayout3);

        jbAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Login.png"))); // NOI18N
        jbAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAceptarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 4;
        jPanel4.add(jbAceptar, gridBagConstraints);

        jPanel5.setBackground(new java.awt.Color(142, 180, 227));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Salir", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        net.java.dev.koalalayout.KoalaLayout koalaLayout4 = new net.java.dev.koalalayout.KoalaLayout();
        koalaLayout4.setGridheight(4);
        koalaLayout4.setGridwidth(4);
        jPanel5.setLayout(koalaLayout4);

        jbSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Cancelar.png"))); // NOI18N
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 4;
        jPanel5.add(jbSalir, gridBagConstraints);

        jPanel6.setBackground(new java.awt.Color(142, 180, 227));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Limpiar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        net.java.dev.koalalayout.KoalaLayout koalaLayout5 = new net.java.dev.koalalayout.KoalaLayout();
        koalaLayout5.setGridheight(4);
        koalaLayout5.setGridwidth(4);
        jPanel6.setLayout(koalaLayout5);

        jbLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondos/edit-clear.png"))); // NOI18N
        jbLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimpiarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 4;
        jPanel6.add(jbLimpiar, gridBagConstraints);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu1.setText("Archivo");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Editar");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-558)/2, (screenSize.height-449)/2, 558, 449);
    }// </editor-fold>//GEN-END:initComponents

    private void jtfUsuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfUsuarioFocusLost
        // TODO add your handling code here:
//        if (jtfUsuario.getText().equals(user)) {
//            jlErrorLogin.setText("El Usuario Coincide");
//            jlErrorLogin.setForeground(Color.GREEN);
//        } else {
//            jlErrorLogin.setText("El Usuario no Coincide");
//            jlErrorLogin.setForeground(Color.RED);
//            jtfUsuario.setText("");
//        }
    }//GEN-LAST:event_jtfUsuarioFocusLost

    private void jpfContraseñaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jpfContraseñaFocusLost
        // TODO add your handling code here:
//        char password [] = jpfContraseña.getPassword();
//        String passwordU = new String(password);
//        if (passwordU.equals(pass)) {
//            jlErrorLogin.setText("La Contraseña Coincide");
//            jlErrorLogin.setForeground(Color.GREEN);
//        } else {
//            jlErrorLogin.setText("La Contraseña no Coincide");
//            jlErrorLogin.setForeground(Color.RED);
//            jpfContraseña.setText("");
//        }
    }//GEN-LAST:event_jpfContraseñaFocusLost

    private void jpfRepitaContraseñaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jpfRepitaContraseñaFocusLost
        // TODO add your handling code here:

        char repitContr[] = jpfRepitaContraseña.getPassword();
        char password[] = jpfNuevaContraseña.getPassword();
        String passwordU = new String(password);
        String repitPass = new String(repitContr);

        if (passwordU.equals(repitPass)) {
            jlErrorNuevoUsuario.setText("Las Contraseñas Coinciden");
            jlErrorNuevoUsuario.setForeground(Color.GREEN);
        } else {
            jlErrorNuevoUsuario.setText("Las Contraseñas no Coinciden");
            jlErrorNuevoUsuario.setForeground(Color.RED);
            jpfRepitaContraseña.setText("");
        }
    }//GEN-LAST:event_jpfRepitaContraseñaFocusLost

    private void jbLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimpiarActionPerformed
        // TODO add your handling code here:
        limpiarGUI();
    }//GEN-LAST:event_jbLimpiarActionPerformed

    private void jtfNuevoUsuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfNuevoUsuarioFocusLost
        // TODO add your handling code here:
//        char password [] = jpfContraseña.getPassword();
//        String passwordU = new String(password);
//        if (jtfUsuario.getText().equals(user) && passwordU.equals(pass)) {
//            usuario = jtfNuevoUsuario.getText();
//        } else {
//            jlErrorNuevoUsuario.setText("Ingrese Datos Actuales Correctos");
//            jlErrorNuevoUsuario.setForeground(Color.RED);
//            jtfNuevoUsuario.setText("");
//        }
    }//GEN-LAST:event_jtfNuevoUsuarioFocusLost

    private void jpfNuevaContraseñaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jpfNuevaContraseñaFocusLost
        // TODO add your handling code here:
//        char nuevoPass [] = jpfContraseña.getPassword();
//        char nuevoPas [] = jpfNuevaContraseña.getPassword();
//        String contra = new String(nuevoPass);
//        String contr = new String(nuevoPas);
//        if (jtfNuevoUsuario.getText().equals(usuario) && contra.equals(pass)) {
//            Contraseña = contr;
//        } else {
//            jlErrorNuevoUsuario.setText("Ingrese Datos Actuales Correctos");
//            jlErrorNuevoUsuario.setForeground(Color.RED);
//            jpfNuevaContraseña.setText("");
//        }
    }//GEN-LAST:event_jpfNuevaContraseñaFocusLost

    private void jbAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAceptarActionPerformed
        // TODO add your handling code here:
        try {
            usuario = jtfUsuario.getText();
            Contraseña = jpfContraseña.getText();
            if (op.isSaved(usuario, Contraseña)) {
                if (jtfUsuario.getText().equals("") != true
                        && jpfContraseña.getText().equals("") != true
                        && jtfNuevoUsuario.getText().equals("") != true
                        && jpfNuevaContraseña.getText().equals("") != true
                        && jpfRepitaContraseña.getText().equals("") != true) {

                    op.ActualizarUsuarios(jtfNuevoUsuario.getText(), jpfNuevaContraseña.getText(), usuario, Contraseña);
                    String usu = op.usuarioUp();
                    op.setEstado(usu, "Modifico usuario " + usuario + " por " + jtfNuevoUsuario.getText());
                    limpiarGUI();
                    this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor! complete los campos");
                }
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jbAceptarActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        // TODO add your handling code here:   
        this.setVisible(false);
    }//GEN-LAST:event_jbSalirActionPerformed

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
            java.util.logging.Logger.getLogger(AdminPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new AdminPassword().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JButton jbAceptar;
    private javax.swing.JButton jbLimpiar;
    private javax.swing.JButton jbSalir;
    public static javax.swing.JLabel jlErrorLogin;
    private javax.swing.JLabel jlErrorNuevoUsuario;
    public static javax.swing.JPasswordField jpfContraseña;
    private javax.swing.JPasswordField jpfNuevaContraseña;
    private javax.swing.JPasswordField jpfRepitaContraseña;
    private javax.swing.JTextField jtfNuevoUsuario;
    public static javax.swing.JTextField jtfUsuario;
    // End of variables declaration//GEN-END:variables
}
