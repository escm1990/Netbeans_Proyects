/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * jfIndicaciones.java
 *
 * Created on 17-sep-2010, 20:29:32
 */

package calculadora2010jframe;

import javax.swing.JOptionPane;

/**
 *
 * @author USUARIO
 */
public class jfIndicaciones extends javax.swing.JFrame {

    /** Creates new form jfIndicaciones */
    public jfIndicaciones() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jsPasos = new javax.swing.JSpinner();
        jbMostrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaIndicacion = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Indicaciones");
        setMinimumSize(new java.awt.Dimension(416, 151));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel1.setForeground(new java.awt.Color(51, 0, 204));
        jLabel1.setText("Use el JSpinner para seleccionar el paso a seguir:");

        jsPasos.setToolTipText("Manipule el JSpinner a la opción que desea mostrar");

        jbMostrar.setText("Mostrar");
        jbMostrar.setToolTipText("Presione mostrar tras seleccionar una opción válida.");
        jbMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMostrarActionPerformed(evt);
            }
        });

        jtaIndicacion.setColumns(20);
        jtaIndicacion.setEditable(false);
        jtaIndicacion.setRows(5);
        jtaIndicacion.setToolTipText("Acá se mostrarán la opción seleccionada.");
        jtaIndicacion.setBorder(new javax.swing.border.MatteBorder(null));
        jtaIndicacion.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane1.setViewportView(jtaIndicacion);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel2.setText("Opciones del 1 - 8");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbMostrar, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jsPasos, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jsPasos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbMostrar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMostrarActionPerformed
        // TODO add your handling code here:
         Integer Opcion = (Integer) this.jsPasos.getValue();
            if(Opcion<=0){
            JOptionPane.showMessageDialog(null, "Seleccione una opción válida por favor", "Error", 2);
            }else
            if(Opcion==1){
            this.jtaIndicacion.setText("Con el mouse ud. seleccionara\nlos numeros, las operaciones\ny demas componentes de la calculadora");
            }else
            if (Opcion==2){
            this.jtaIndicacion.setText("Haga clic en los números y/o el punto decimal\n(Notara que tras haber dado un clic\nsobre el, este se desactivara, evitando\nasí que se ingrese más de un punto.)");
            }else
            if (Opcion==3){
            this.jtaIndicacion.setText("Haga clic en la operación que desea realizar\n(+,-,*,/) y luego ingrese el segundo numero\nque desee introducir");
            }else
            if (Opcion==4){
            this.jtaIndicacion.setText("Presione el botón IGUAL y obtendrá el resultado\nen pantalla (para ingresar otra operación\ndebe presionar el botón 'C', el cual\nlimpiara la pantalla de la calculadora)");
            }else
            if (Opcion==5){
            this.jtaIndicacion.setText("Del mismo modo intente usar los botones\nRaiz, Mas/Menos y conversión a Dolar");
            }else
            if (Opcion==6){
            this.jtaIndicacion.setText("Como podrá notar, si la pantalla está vacía\nlos botones de las operaciones matematicas\nmostrarán un mensaje de advertencia\nimpidiendo al usuario realizar una acción ilegal.");
            }else
            if (Opcion==7){
            this.jtaIndicacion.setText("Importante: Preste atención a los toolTipText\nde cada uno de los botones");
            }else
            if (Opcion==8){
            this.jtaIndicacion.setText("La calculadora esta equipada con un\nsencillo botón que cambia el color\ndel display (donde se visualizan los numeros)");
            }else
            if (Opcion>8){
            JOptionPane.showMessageDialog(null, "No hay mas opciones", "Información", 2);
            }
    }//GEN-LAST:event_jbMostrarActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                jfIndicaciones obj = new jfIndicaciones();
                obj.setLocationRelativeTo(null);
                obj.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbMostrar;
    private javax.swing.JSpinner jsPasos;
    private javax.swing.JTextArea jtaIndicacion;
    // End of variables declaration//GEN-END:variables

}