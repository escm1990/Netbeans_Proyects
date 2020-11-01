package jcmaccesscurso;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
/**
 * @web http://jc-mouse.blogspot.com/
 * @author Mouse
 */
public class jcm_asignatura extends javax.swing.JInternalFrame {
    SQL sql = new SQL();
    jcm_mensajes msg = new jcm_mensajes();
    //variables
    private String codigo;
    private String nombre;
    
    /** Creates new form asignatura */
    public jcm_asignatura() {
        initComponents();
        this.setTitle("Registro Asignaturas - by Mouse");
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jcMousePanel1 = new jcMousePanel.jcMousePanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JFormattedTextField();
        cmdBuscar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        cmdAgregar = new javax.swing.JButton();
        cmdActualizar = new javax.swing.JButton();
        cmdNuevo = new javax.swing.JButton();
        cmdEliminar = new javax.swing.JButton();
        cmdCerrar = new javax.swing.JButton();

        getContentPane().setLayout(new java.awt.GridBagLayout());

        jcMousePanel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/screen2.jpg"))); // NOI18N
        jcMousePanel1.setPreferredSize(new java.awt.Dimension(600, 180));

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Codigo Asignatura:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
        jPanel1.add(jLabel1, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
        jPanel1.add(jLabel2, gridBagConstraints);

        txtNombre.setPreferredSize(new java.awt.Dimension(330, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(txtNombre, gridBagConstraints);

        try {
            txtCodigo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("UUUU-##-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCodigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCodigo.setPreferredSize(new java.awt.Dimension(200, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
        jPanel1.add(txtCodigo, gridBagConstraints);

        cmdBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/find.png"))); // NOI18N
        cmdBuscar.setText("Buscar");
        cmdBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdBuscarActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new java.awt.GridBagLayout());

        cmdAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add.png"))); // NOI18N
        cmdAgregar.setText("Agregar");
        cmdAgregar.setToolTipText("Agregar");
        cmdAgregar.setPreferredSize(new java.awt.Dimension(120, 25));
        cmdAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAgregarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
        jPanel3.add(cmdAgregar, gridBagConstraints);

        cmdActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/edit.png"))); // NOI18N
        cmdActualizar.setText("Actualizar");
        cmdActualizar.setToolTipText("Editar");
        cmdActualizar.setPreferredSize(new java.awt.Dimension(120, 25));
        cmdActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdActualizarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
        jPanel3.add(cmdActualizar, gridBagConstraints);

        cmdNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/new.png"))); // NOI18N
        cmdNuevo.setText("Nuevo");
        cmdNuevo.setToolTipText("Nuevo");
        cmdNuevo.setPreferredSize(new java.awt.Dimension(120, 25));
        cmdNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdNuevoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
        jPanel3.add(cmdNuevo, gridBagConstraints);

        cmdEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/del.png"))); // NOI18N
        cmdEliminar.setText("Eliminar");
        cmdEliminar.setToolTipText("Eliminar");
        cmdEliminar.setPreferredSize(new java.awt.Dimension(120, 25));
        cmdEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdEliminarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(cmdEliminar, gridBagConstraints);

        cmdCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/door.png"))); // NOI18N
        cmdCerrar.setText("Cerrar");
        cmdCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jcMousePanel1Layout = new javax.swing.GroupLayout(jcMousePanel1);
        jcMousePanel1.setLayout(jcMousePanel1Layout);
        jcMousePanel1Layout.setHorizontalGroup(
            jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jcMousePanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jcMousePanel1Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmdBuscar))
                    .addComponent(cmdCerrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jcMousePanel1Layout.setVerticalGroup(
            jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jcMousePanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmdBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
                .addGap(11, 11, 11)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmdCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jcMousePanel1, new java.awt.GridBagConstraints());

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCerrarActionPerformed
        sql.Cerrar_Access();
        dispose();
    }//GEN-LAST:event_cmdCerrarActionPerformed

    private void cmdAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAgregarActionPerformed
        //inicia datos
        setDatos();
        //los datos y el orden de inserccion
        String[] datos = { codigo, nombre };
        if(sql.Nueva_Asignatura(datos)){
            JOptionPane.showMessageDialog(this,msg.getNuevoRegistro());
        }else{
            JOptionPane.showMessageDialog(this,msg.getError());
        }
    }//GEN-LAST:event_cmdAgregarActionPerformed

    private void cmdActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdActualizarActionPerformed
        //inicia datos
        setDatos();
        //los datos y el orden de inserccion
        String[] datos = { nombre };
        if(sql.Actualizar_Asignatura(datos, codigo)){
            JOptionPane.showMessageDialog(this,msg.getActualizacion());
        }else{
            JOptionPane.showMessageDialog(this,msg.getError());
        }
    }//GEN-LAST:event_cmdActualizarActionPerformed

    private void cmdNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdNuevoActionPerformed
        limpiar_controles();
    }//GEN-LAST:event_cmdNuevoActionPerformed

    private void cmdEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdEliminarActionPerformed
        if(sql.eliminar_Asignatura(getText(txtCodigo,12))){
            JOptionPane.showMessageDialog(this,msg.getEliminado());
            limpiar_controles();
        }
    }//GEN-LAST:event_cmdEliminarActionPerformed

    private void cmdBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdBuscarActionPerformed
        if(sql.existe("asignatura", "as_id", getText(txtCodigo,12))){         
            String data[] = sql.getDatosAsignatura(getText(txtCodigo,12));
            //se colocan los datos en los objetos
            txtNombre.setText(data[1]);            
            txtCodigo.setEnabled(false);
        }else{
            JOptionPane.showMessageDialog(this,msg.getNoExiste());
        }
}//GEN-LAST:event_cmdBuscarActionPerformed
    
 private void setDatos(){
        codigo = getText(txtCodigo,12);
        nombre = getText(txtNombre,40);        
 }         
     
 private String getText(JTextField textField, int maxLength) {
     String text = textField.getText();
        if (text.length() > maxLength) 
            text = text.substring(0, maxLength);                             
     return text;
}
  private void limpiar_controles(){
        txtCodigo.setText("");
        txtNombre.setText("");    
        txtCodigo.setEnabled(true);
    }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdActualizar;
    private javax.swing.JButton cmdAgregar;
    private javax.swing.JButton cmdBuscar;
    private javax.swing.JButton cmdCerrar;
    private javax.swing.JButton cmdEliminar;
    private javax.swing.JButton cmdNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private jcMousePanel.jcMousePanel jcMousePanel1;
    private javax.swing.JFormattedTextField txtCodigo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
    
}