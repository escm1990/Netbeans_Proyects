package vistas;

import accesoDatos.OperacionesUsuarios;
import clases.Usuario;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class Logueo extends javax.swing.JFrame {

    Usuario usuario = new Usuario();
    OperacionesUsuarios op = new OperacionesUsuarios();
    SeleccionActividad act = new SeleccionActividad();
//    String pass = op.password();
//    String user = op.usuario();
    static String us;

    public Logueo() {
        initComponents();
        op.verificar();

    }

      @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/iconBLH.png"));
        return retValue;
    }
      
    public void ingresarDatos(String user, String pass) {
//        char passArray[] = jpfContraseña.getPassword();
//        String Password = new String(passArray);

        if (op.isLogged(user, pass)) {
            act.setVisible(true);
            op.setEstado(jtfUsuario.getText(), "up");
//            op.setEstado(user, pass);
            this.setVisible(false);
        } 
//        else if (jtfUsuario.getText().equals(user) && Password != pass) {
//            jlErrorLogeo.setText("Error en la Contraseña");
//            jpfContraseña.setText("");
//        } else if (jtfUsuario.getText() != user && Password == pass) {
//            jlErrorLogeo.setText("Error en el Usuario");
//            jtfUsuario.setText("");
//        } else if (jtfUsuario.getText() != user && Password != pass) {
//            jlErrorLogeo.setText("Error en el Usuario, Error en la Contraseña");
//            jtfUsuario.setText("");
//            jpfContraseña.setText("");
//        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jPanelLogin = new javax.swing.JPanel();
        jbAceptar = new javax.swing.JButton();
        jPanelDatos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfUsuario = new javax.swing.JTextField();
        jpfContraseña = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jlErrorLogeo = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Logueo - Witcco BLH");
        setIconImage(getIconImage());
        setResizable(false);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(250, 108, 6));
        net.java.dev.koalalayout.KoalaLayout koalaLayout1 = new net.java.dev.koalalayout.KoalaLayout();
        koalaLayout1.setGridheight(15);
        koalaLayout1.setGridwidth(15);
        jPanel1.setLayout(koalaLayout1);

        jPanelLogin.setBackground(new java.awt.Color(255, 255, 255));
        jPanelLogin.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jbAceptar.setFont(new java.awt.Font("Tahoma", 1, 14));
        jbAceptar.setText("Entrar");
        jbAceptar.setToolTipText("Aceptar");
        jbAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAceptarActionPerformed(evt);
            }
        });
        jbAceptar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbAceptarKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanelLoginLayout = new javax.swing.GroupLayout(jPanelLogin);
        jPanelLogin.setLayout(jPanelLoginLayout);
        jPanelLoginLayout.setHorizontalGroup(
            jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLoginLayout.createSequentialGroup()
                .addContainerGap(323, Short.MAX_VALUE)
                .addComponent(jbAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanelLoginLayout.setVerticalGroup(
            jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLoginLayout.createSequentialGroup()
                .addComponent(jbAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 26;
        jPanel1.add(jPanelLogin, gridBagConstraints);

        jPanelDatos.setBackground(new java.awt.Color(255, 255, 255));
        jPanelDatos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Introduzca sus datos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(51, 51, 51))); // NOI18N
        net.java.dev.koalalayout.KoalaLayout koalaLayout2 = new net.java.dev.koalalayout.KoalaLayout();
        koalaLayout2.setGridheight(15);
        koalaLayout2.setGridwidth(15);
        jPanelDatos.setLayout(koalaLayout2);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel1.setText("Usuario:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        jPanelDatos.add(jLabel1, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel2.setText("Contraseña:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 4;
        jPanelDatos.add(jLabel2, gridBagConstraints);

        jtfUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfUsuarioFocusLost(evt);
            }
        });
        jtfUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfUsuarioKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.gridheight = 3;
        jPanelDatos.add(jtfUsuario, gridBagConstraints);

        jpfContraseña.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jpfContraseñaFocusLost(evt);
            }
        });
        jpfContraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jpfContraseñaKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.gridheight = 3;
        jPanelDatos.add(jpfContraseña, gridBagConstraints);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Usuario Tarjeta.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 6;
        jPanelDatos.add(jLabel3, gridBagConstraints);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ContraseÃ±a Sin Sombra.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 7;
        jPanelDatos.add(jLabel4, gridBagConstraints);

        jlErrorLogeo.setForeground(new java.awt.Color(255, 0, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 12;
        gridBagConstraints.gridheight = 2;
        jPanelDatos.add(jlErrorLogeo, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 26;
        gridBagConstraints.gridheight = 6;
        jPanel1.add(jPanelDatos, gridBagConstraints);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondos/logueo.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 20;
        gridBagConstraints.gridheight = 7;
        jPanel1.add(jLabel5, gridBagConstraints);

        jLabel6.setFont(new java.awt.Font("Latha", 1, 36));
        jLabel6.setForeground(new java.awt.Color(255, 102, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondos/cerrar.png"))); // NOI18N
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 23;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        jPanel1.add(jLabel6, gridBagConstraints);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondos/fondo.png"))); // NOI18N
        jLabel7.setText("jLabel7");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 26;
        gridBagConstraints.gridheight = 15;
        jPanel1.add(jLabel7, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 445, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 524, Short.MAX_VALUE)
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-445)/2, (screenSize.height-524)/2, 445, 524);
    }// </editor-fold>//GEN-END:initComponents

private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
    System.exit(0);
}//GEN-LAST:event_jLabel6MouseClicked

private void jpfContraseñaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jpfContraseñaKeyPressed
    int key = evt.getKeyChar();
    if (key == KeyEvent.VK_ENTER) {
        ingresarDatos(jtfUsuario.getText(), jpfContraseña.getText());
    }
}//GEN-LAST:event_jpfContraseñaKeyPressed

private void jpfContraseñaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jpfContraseñaFocusLost
    // TODO add your handling code here:
//    if (jpfContraseña.getText().equals(pass)) {
//        usuario.setPassword(jpfContraseña.getText());
//    }
}//GEN-LAST:event_jpfContraseñaFocusLost

private void jtfUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfUsuarioKeyPressed
    int key = evt.getKeyChar();
    if (key == KeyEvent.VK_ENTER) {
        ingresarDatos(jtfUsuario.getText(), jpfContraseña.getText());
    }
}//GEN-LAST:event_jtfUsuarioKeyPressed

private void jtfUsuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfUsuarioFocusLost
    // TODO add your handling code here:
//    if (jtfUsuario.getText().equals(user)) {
//        usuario.setUsuario(jtfUsuario.getText());
//    }
}//GEN-LAST:event_jtfUsuarioFocusLost

private void jbAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAceptarActionPerformed
    ingresarDatos(jtfUsuario.getText(), jpfContraseña.getText());
}//GEN-LAST:event_jbAceptarActionPerformed

private void jbAceptarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbAceptarKeyPressed
    int key = evt.getKeyChar();
    if (key == KeyEvent.VK_ENTER) {
        ingresarDatos(jtfUsuario.getText(), jpfContraseña.getText());
    }
}//GEN-LAST:event_jbAceptarKeyPressed

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
            java.util.logging.Logger.getLogger(Logueo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Logueo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Logueo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Logueo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Logueo().setVisible(true);
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelDatos;
    private javax.swing.JPanel jPanelLogin;
    private javax.swing.JButton jbAceptar;
    public static javax.swing.JLabel jlErrorLogeo;
    public static javax.swing.JPasswordField jpfContraseña;
    public static javax.swing.JTextField jtfUsuario;
    // End of variables declaration//GEN-END:variables
}
