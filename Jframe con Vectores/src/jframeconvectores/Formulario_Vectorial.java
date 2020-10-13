package jframeconvectores;
import Clases.Clase;
import java.*;
import javax.swing.*;
import javax.swing.JOptionPane;
public class Formulario_Vectorial extends javax.swing.JFrame {
private Clase objeto;

public Formulario_Vectorial() {
        initComponents();
        objeto = new Clase();
        Actualizar_Interfaz();
}

private void Actualizar_Interfaz(){
    jtTamaño.setText("");
    jtValores.setText("");
    jtNuevo_valor.setText("");
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtValores = new javax.swing.JTextField();
        jbIngresarTamaño = new javax.swing.JButton();
        jbIngresarValor = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlVectores01 = new javax.swing.JList();
        jLabel3 = new javax.swing.JLabel();
        jtNuevo_valor = new javax.swing.JTextField();
        jbIngresarNuevoValor = new javax.swing.JButton();
        jbOrdenarVector = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jlVectores02 = new javax.swing.JList();
        jbOrdenarNuevoVector = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jbSalir = new javax.swing.JButton();
        jtTamaño = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Vectores");
        setMinimumSize(new java.awt.Dimension(305, 245));
        setResizable(false);

        jLabel1.setText("Tamaño del Vector");

        jLabel2.setText("Valores del Vector");

        jtValores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtValoresMouseClicked(evt);
            }
        });

        jbIngresarTamaño.setText("Ingresar Tamaño");
        jbIngresarTamaño.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbIngresarTamañoActionPerformed(evt);
            }
        });

        jbIngresarValor.setText("Ingresar el Valor ");
        jbIngresarValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbIngresarValorActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jlVectores01);

        jLabel3.setText("Nuevo Valor a Ingresar");

        jbIngresarNuevoValor.setText("Ingresar al Vector");

        jbOrdenarVector.setText("Ordenar el Vector");

        jScrollPane2.setViewportView(jlVectores02);

        jbOrdenarNuevoVector.setText("Ordenar el Vector");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel4.setText("Licenced by escm1990");

        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        jtTamaño.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtTamañoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addComponent(jtNuevo_valor, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, 0, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jtValores)
                            .addComponent(jtTamaño, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)))
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jbIngresarTamaño, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbIngresarValor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbIngresarNuevoValor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbOrdenarVector, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jbSalir, javax.swing.GroupLayout.Alignment.TRAILING, 0, 0, Short.MAX_VALUE)
                        .addComponent(jbOrdenarNuevoVector, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jbIngresarTamaño)
                            .addComponent(jtTamaño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtValores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbIngresarValor)))
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbOrdenarVector))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jbIngresarNuevoValor)
                    .addComponent(jtNuevo_valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, 0, 0, Short.MAX_VALUE)
                    .addComponent(jbOrdenarNuevoVector))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbSalir)
                    .addComponent(jLabel4))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jbIngresarTamañoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbIngresarTamañoActionPerformed
        // TODO add your handling code here:
        objeto.Declarar_Tamaño(jtTamaño.getText());
    }//GEN-LAST:event_jbIngresarTamañoActionPerformed

    private void jbIngresarValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbIngresarValorActionPerformed
        // TODO add your handling code here:
        if(objeto.getTam()>0){
        objeto.Ingresar_Datos(jtValores.getText());
        objeto.Llenar_Vector(Integer.parseInt(jtValores.getText()));
//        for(int i=0; i<=objeto.getTam()-1;i++){
//            if(i==objeto.getTam()){
//                JOptionPane.showMessageDialog(null, "Ya no mas datos");
//            }
//        }
      }
    }//GEN-LAST:event_jbIngresarValorActionPerformed

    private void jtTamañoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtTamañoMouseClicked
        // TODO add your handling code here:
        jtTamaño.setText("");
    }//GEN-LAST:event_jtTamañoMouseClicked

    private void jtValoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtValoresMouseClicked
        // TODO add your handling code here:
        jtValores.setText("");
    }//GEN-LAST:event_jtValoresMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Formulario_Vectorial centrado = new Formulario_Vectorial();
                centrado.setLocationRelativeTo(null);
                centrado.setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbIngresarNuevoValor;
    private javax.swing.JButton jbIngresarTamaño;
    private javax.swing.JButton jbIngresarValor;
    private javax.swing.JButton jbOrdenarNuevoVector;
    private javax.swing.JButton jbOrdenarVector;
    private javax.swing.JButton jbSalir;
    private javax.swing.JList jlVectores01;
    private javax.swing.JList jlVectores02;
    private javax.swing.JTextField jtNuevo_valor;
    private javax.swing.JTextField jtTamaño;
    private javax.swing.JTextField jtValores;
    // End of variables declaration//GEN-END:variables

}
