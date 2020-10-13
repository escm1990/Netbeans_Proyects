package Software_Swing;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

public class jifVisordeImagenes extends javax.swing.JInternalFrame {

    /** Creates new form jifVisordeImagenes */
    public jifVisordeImagenes() {
        initComponents();
    }

    jifVisordeImagenes(FramePrincipal framePrincipal, boolean b) {
           jifVisordeImagenes obj = new jifVisordeImagenes(new FramePrincipal(), true);
           obj.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaRuta = new javax.swing.JTextArea();
        jbSeleccionar = new javax.swing.JButton();
        jbCargar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jlMostrador = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("                         JInternalFrame ::::::::::::: Visor de Imágenes                      ");
        setFocusable(false);
        setMinimumSize(new java.awt.Dimension(410, 311));
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        setVisible(true);

        jLabel1.setText("Ruta:");

        jtaRuta.setColumns(20);
        jtaRuta.setRows(5);
        jScrollPane1.setViewportView(jtaRuta);

        jbSeleccionar.setText("Seleccionar");
        jbSeleccionar.setToolTipText("Seleeciona un archivo a ejecutar (imagen, video...)");
        jbSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSeleccionarActionPerformed(evt);
            }
        });

        jbCargar.setText("Cargar");
        jbCargar.setToolTipText("Para ver la imagen ve a la pestaña \"Mostrar Imagen\" tras haber dado clic");
        jbCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCargarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbSeleccionar)
                        .addGap(22, 22, 22)
                        .addComponent(jbCargar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCargar)
                    .addComponent(jbSeleccionar))
                .addContainerGap(160, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Selecionar Imagen", jPanel1);

        jPanel2.setMinimumSize(new java.awt.Dimension(408, 305));

        jlMostrador.setBorder(new javax.swing.border.MatteBorder(null));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlMostrador, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlMostrador, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Mostrar Imagen", jPanel2);

        jLabel2.setText("1. Este JIF es parecido al JFileChooser de ejemplo");

        jLabel3.setText("2. Puedes cerrarlo haciendo clic en la X superior derecha del JIF");

        jLabel4.setText("3. Debes estar seguro en que lugar se visualizará el JIF");

        jLabel5.setText("4. Si tienes duda, consulta el código");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addContainerGap(146, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Datos Generales", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 407, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCargarActionPerformed
        // TODO add your handling code here:
        jlMostrador.setIcon(new ImageIcon(this.jtaRuta.getText()));
    }//GEN-LAST:event_jbCargarActionPerformed

    private void jbSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSeleccionarActionPerformed
        // TODO add your handling code here:
        JFileChooser objeto = new JFileChooser();
        objeto.showOpenDialog(null);
        jtaRuta.setText(objeto.getSelectedFile().getPath());
}//GEN-LAST:event_jbSeleccionarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton jbCargar;
    private javax.swing.JButton jbSeleccionar;
    private javax.swing.JLabel jlMostrador;
    private javax.swing.JTextArea jtaRuta;
    // End of variables declaration//GEN-END:variables

}
