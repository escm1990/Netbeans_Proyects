package Software_Swing;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class FramePrincipal extends javax.swing.JFrame {

    public FramePrincipal() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jbSalida = new javax.swing.JButton();
        jbJDialog = new javax.swing.JButton();
        jbColorChooser = new javax.swing.JButton();
        jbFileChooser = new javax.swing.JButton();
        jbMostrarImagenes = new javax.swing.JButton();
        jtfDireccion = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jsEdad = new javax.swing.JSpinner();
        jLabel12 = new javax.swing.JLabel();
        jbOK = new javax.swing.JButton();
        jpPanelInternal = new javax.swing.JPanel();
        jbJInternalFrame = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Software Instructivo Swing");
        setMinimumSize(new java.awt.Dimension(283, 223));
        setResizable(false);

        jTabbedPane1.setMinimumSize(new java.awt.Dimension(270, 231));

        jLabel2.setText("Este software permitira aprender a usar:");

        jLabel3.setText("- JDialog");

        jLabel4.setText("- JSpinner");

        jLabel5.setText("- JFileChooser");

        jLabel6.setText("- JTabbedPane");

        jLabel7.setText("- JInternalFrame");

        jLabel8.setText("- JSlider");

        jLabel9.setText("- JTextArea");

        jLabel11.setText("Hecho por: escm.1990");

        jLabel10.setText("- JColorChooser");

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Software_Swing/Imagen2.jpg"))); // NOI18N
        jLabel14.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(140, 20, 20)));

        jLabel15.setForeground(new java.awt.Color(255, 51, 51));
        jLabel15.setText("escm.1990@gmail.com");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel16.setForeground(new java.awt.Color(0, 153, 0));
        jLabel16.setText("\"Para arreglar al mundo se necesita arreglar al hombre\"");

        jLabel17.setForeground(new java.awt.Color(255, 0, 51));
        jLabel17.setText("Visita mis sitios web:");

        jLabel18.setForeground(new java.awt.Color(0, 0, 255));
        jLabel18.setText("http://www.mmmsantaana.es.tl");

        jLabel19.setForeground(new java.awt.Color(0, 0, 255));
        jLabel19.setText("http://mensajesyestudiosmmm.blogspot.com");

        jLabel20.setForeground(new java.awt.Color(0, 0, 255));
        jLabel20.setText("http://las-buenasnuevas.blogspot.com");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel10)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8))
                        .addGap(40, 40, 40)
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel11)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel16))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18)
                            .addComponent(jLabel20))))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel11)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel15))
                        .addComponent(jLabel14)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel16)
                .addGap(11, 11, 11)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addGap(7, 7, 7)
                .addComponent(jLabel19)
                .addGap(34, 34, 34))
        );

        jTabbedPane1.addTab("Principal", jPanel1);

        jPanel3.setMinimumSize(new java.awt.Dimension(270, 231));

        jbSalida.setText("Salida");
        jbSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalidaActionPerformed(evt);
            }
        });

        jbJDialog.setText("JDialog");
        jbJDialog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbJDialogActionPerformed(evt);
            }
        });

        jbColorChooser.setText("JColorChooser");
        jbColorChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbColorChooserActionPerformed(evt);
            }
        });

        jbFileChooser.setText("JFileChooser");
        jbFileChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFileChooserActionPerformed(evt);
            }
        });

        jLabel1.setText("Ubicación:");

        jLabel12.setText("Edad");

        jbOK.setText("OK");
        jbOK.setToolTipText("Presiona aquí luego de definir tu edad");
        jbOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbOKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jbJDialog)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jbFileChooser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jbColorChooser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel12)
                                    .addGap(7, 7, 7)
                                    .addComponent(jsEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jbOK)))
                            .addGap(18, 18, 18)
                            .addComponent(jbMostrarImagenes, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jtfDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jbSalida))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jbJDialog, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(jbColorChooser)
                        .addGap(18, 18, 18)
                        .addComponent(jbFileChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jsEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbOK)))
                    .addComponent(jbMostrarImagenes, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jbSalida)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Componentes", jPanel3);

        jbJInternalFrame.setText("JInternalFrame");
        jbJInternalFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbJInternalFrameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpPanelInternalLayout = new javax.swing.GroupLayout(jpPanelInternal);
        jpPanelInternal.setLayout(jpPanelInternalLayout);
        jpPanelInternalLayout.setHorizontalGroup(
            jpPanelInternalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPanelInternalLayout.createSequentialGroup()
                .addContainerGap(172, Short.MAX_VALUE)
                .addComponent(jbJInternalFrame)
                .addGap(165, 165, 165))
        );
        jpPanelInternalLayout.setVerticalGroup(
            jpPanelInternalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPanelInternalLayout.createSequentialGroup()
                .addContainerGap(341, Short.MAX_VALUE)
                .addComponent(jbJInternalFrame))
        );

        jTabbedPane1.addTab("Panel del Internal", jpPanelInternal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalidaActionPerformed
        // TODO add your handling code here:
        System.exit(0);
}//GEN-LAST:event_jbSalidaActionPerformed

    private void jbJDialogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbJDialogActionPerformed
        // TODO add your handling code here:
        jdInformacion obj = new jdInformacion(new FramePrincipal(), true);
        obj.setLocationRelativeTo(null);
        obj.setVisible(true);
    }//GEN-LAST:event_jbJDialogActionPerformed

    private void jbColorChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbColorChooserActionPerformed
        // TODO add your handling code here:
        Color objeto = JColorChooser.showDialog(null, "Cambie el color de Fondo", jPanel3.getBackground());
        this.jPanel3.setBackground(objeto);
        this.jpPanelInternal.setBackground(objeto);
        this.jPanel1.setBackground(objeto);
    }//GEN-LAST:event_jbColorChooserActionPerformed

    private void jbFileChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFileChooserActionPerformed
        // TODO add your handling code here:
        JFileChooser objeto = new JFileChooser();
        objeto.showOpenDialog(null);
        this.jtfDireccion.setText(objeto.getSelectedFile().getPath());
        this.jbMostrarImagenes.setIcon(new ImageIcon(this.jtfDireccion.getText()));
    }//GEN-LAST:event_jbFileChooserActionPerformed

    private void jbOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbOKActionPerformed
        // TODO add your handling code here:
        Integer Edad = (Integer) this.jsEdad.getValue();
            if(Edad<=0){
            JOptionPane.showMessageDialog(null, "¡No mientas! ¿Acaso aún no has nacido?");
            }else
            if(Edad>0 && Edad<=5){
            JOptionPane.showMessageDialog(null, "Aún eres muy pequeño para programar.\nVete a tu cuna a dormir");
            }else
            if (Edad>=6 && Edad<=10){
            JOptionPane.showMessageDialog(null, "¡Cómo has crecido!\nEn unos años más podras programar ");
            }else
            if (Edad>=11 && Edad<=15){
            JOptionPane.showMessageDialog(null, "Unos añitos más y podrás programar.\nAhora vete a jugar Nintendo");
            }else
            if (Edad>=16 && Edad<=24){
            JOptionPane.showMessageDialog(null, "¡Al fín ha llegado la hora de aprender a programar!");
            }else
            if (Edad>=25){
            JOptionPane.showMessageDialog(null, "¡Qué vergüenza!\n¿Tan viejo y aún no sabes programar?");
            }
    }//GEN-LAST:event_jbOKActionPerformed

    private void jbJInternalFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbJInternalFrameActionPerformed
        // TODO add your handling code here:
           jifVisordeImagenes cargar = new jifVisordeImagenes();
           jpPanelInternal.add(cargar);
           cargar.setVisible(true);
            
    }//GEN-LAST:event_jbJInternalFrameActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                FramePrincipal obj = new FramePrincipal();
                obj.setLocationRelativeTo(null);
                obj.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton jbColorChooser;
    private javax.swing.JButton jbFileChooser;
    private javax.swing.JButton jbJDialog;
    private javax.swing.JButton jbJInternalFrame;
    private javax.swing.JButton jbMostrarImagenes;
    private javax.swing.JButton jbOK;
    private javax.swing.JButton jbSalida;
    private javax.swing.JPanel jpPanelInternal;
    private javax.swing.JSpinner jsEdad;
    private javax.swing.JTextField jtfDireccion;
    // End of variables declaration//GEN-END:variables

}
