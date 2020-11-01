/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Interfaz.java
 *
 * Created on 10-24-2010, 10:26:20 PM
 */
package correoejemplo;

import org.jvnet.substance.SubstanceLookAndFeel;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ESCM1990
 */
public class Interfaz extends javax.swing.JFrame {

    String asunto, serverSalida, serverEntrada, de, para, mensaje, pass, puerto, rutaAdjunto;
    String vectorpara[], receptorCorreos;

    /** Creates new form Interfaz */
    public Interfaz() {
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jbSALIR = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jtfDE = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        jtfPUERTOSALIDA = new javax.swing.JTextField();
        jlPuertodeSalida = new javax.swing.JLabel();
        jlCOMENTARIO = new javax.swing.JLabel();
        jlPuertodeEntrada = new javax.swing.JLabel();
        jtfPUERTOENTRADA = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaNOTA_ACLARATORIA = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtfPARA = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaMENSAJE = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jtfASUNTO = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jbENVIAR = new javax.swing.JButton();
        jbNUEVOCORREO = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jbRECIBIR = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtTABLABANDEJAENTRADA = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jlLISTAMENSAJES = new javax.swing.JList();
        jlACLARACIONBANDEJA = new javax.swing.JLabel();
        jbDISEÑADOR = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(718, 431));
        setResizable(false);

        jbSALIR.setText("Salir");
        jbSALIR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSALIRActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24));
        jLabel8.setText("APLICACION JAVAMAIL v1.0");

        jLabel5.setText("Servidor");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setLabel("GMAIL");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setLabel("YAHOO");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setLabel("HOTMAIL");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        jLabel4.setText("Usuario:");

        jtfDE.setFont(new java.awt.Font("Tahoma", 0, 14));

        jLabel7.setText("Password:");

        jtfPUERTOSALIDA.setFont(new java.awt.Font("Tahoma", 0, 14));
        jtfPUERTOSALIDA.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jtfPUERTOSALIDA.setEnabled(false);

        jlPuertodeSalida.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jlCOMENTARIO.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jlCOMENTARIO.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jlPuertodeEntrada.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jtfPUERTOENTRADA.setFont(new java.awt.Font("Tahoma", 0, 14));
        jtfPUERTOENTRADA.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jtfPUERTOENTRADA.setEnabled(false);

        jtaNOTA_ACLARATORIA.setBackground(new java.awt.Color(204, 255, 255));
        jtaNOTA_ACLARATORIA.setColumns(20);
        jtaNOTA_ACLARATORIA.setFont(new java.awt.Font("Monospaced", 1, 14));
        jtaNOTA_ACLARATORIA.setRows(5);
        jtaNOTA_ACLARATORIA.setText("Esta es una aplicación que implementa el uso de JavaMail. Para el correcto funcionamiento de este \nsoftware se recomienda lo siguiente:\n\n::::::::::::::::::::::::PARA ENVIAR UN CORREO (Gmail, Hotmail y Yahoo!):::::::::::::::::::::::::::::\n\n1. Seleccione el Servidor del cual enviará el correo haciendo clic en su respectivo RadioButton. \n   Ud. notará que automáticamente se determinan los puertos de entrada y de salida de cada servidor \n   en específico.\n\n2. Escriba su correo y su contraseña. Luego acceda a la pestaña \"Enviar\".\n\n3. All momento de ingresar un más de un correo en el destinartario, separelo del siguiente por\n   \"; \" (punto y coma seguido de un espacio). El último NO debe llevar \";\".\n\n4. Edite el Asunto y el Mensaje (puede añadir URL en el mensaje escribiéndolas directamente).\n\n5. Con el botón \"Adjuntar Archivo\" Ud. podrá añadir un archivo a su correo y enviarlo junto al\n   mensaje.\n\n6. Haga clic en el botón \"Enviar\", y si todo resultó satisfactoriamente Ud. recibirá en pantalla un \n   mensaje como \"Correo Enviado\", denotando que todo ha sido realizado con éxito.\n\n7. Presionando el botón \"Nuevo Correo\" Ud. Podrá ingresar nuevas direcciones, asunto y mensaje nuevos\n   para ser enviados (OJO: NO DEBE SALIR DEL CORREO DEL CUAL ESTA CONECTADO).\n\n:::::::::::::::::::::PARA LEER BANDEJA DE ENTRADA (Gmail, Hotmail y Yahoo!):::::::::::::::::::::\n\n1. Entre a la pestaña \"Bandeja de Entrada\".\n\n2. Presione el botón \"Leer Bandeja de Entrada\" y le aparecerán sus últimos 10 correos recibidos en \n   la tabla y la lista que se encuentran en la ficha \"Bandeja de Entrada\".\n\n--------------------------------------------------------------------------------------------------\n\nEspero que esta aplicación sea del agrado del Usuario.\n\nPara contactarme presione el botón \"Hecho Por:\"\n\n¡Gracias por utilizar mi aplicación de JavaMail!");
        jtaNOTA_ACLARATORIA.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Estimado Usuario:", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 18))); // NOI18N
        jtaNOTA_ACLARATORIA.setEnabled(false);
        jScrollPane2.setViewportView(jtaNOTA_ACLARATORIA);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPasswordField1, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                                .addGap(15, 15, 15))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jtfDE, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jlPuertodeEntrada, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                            .addComponent(jlPuertodeSalida, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfPUERTOSALIDA, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfPUERTOENTRADA, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton3)
                            .addComponent(jRadioButton2)
                            .addComponent(jRadioButton1)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 849, Short.MAX_VALUE)
                    .addComponent(jlCOMENTARIO, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 849, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jRadioButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfDE, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jtfPUERTOSALIDA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlPuertodeSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfPUERTOENTRADA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jlPuertodeEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)))
                .addGap(18, 18, 18)
                .addComponent(jlCOMENTARIO, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Iniciar Sesión", jPanel1);

        jLabel1.setText("Para:");

        jtfPARA.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jtaMENSAJE.setColumns(20);
        jtaMENSAJE.setFont(new java.awt.Font("Tahoma", 0, 14));
        jtaMENSAJE.setRows(5);
        jScrollPane1.setViewportView(jtaMENSAJE);

        jLabel3.setText("Mensaje:");

        jtfASUNTO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel2.setText("Asunto:");

        jbENVIAR.setText("Enviar Correo");
        jbENVIAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbENVIARActionPerformed(evt);
            }
        });

        jbNUEVOCORREO.setText("Nuevo Correo");
        jbNUEVOCORREO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNUEVOCORREOActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfPARA, javax.swing.GroupLayout.DEFAULT_SIZE, 797, Short.MAX_VALUE)
                            .addComponent(jtfASUNTO, javax.swing.GroupLayout.DEFAULT_SIZE, 797, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jbENVIAR)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbNUEVOCORREO))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 798, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtfPARA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfASUNTO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbENVIAR)
                    .addComponent(jbNUEVOCORREO))
                .addContainerGap())
        );

        jTabbedPane2.addTab("Enviar", jPanel2);

        jbRECIBIR.setText("Abrir Bandeja de Entrada");
        jbRECIBIR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRECIBIRActionPerformed(evt);
            }
        });

        jtTABLABANDEJAENTRADA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(jtTABLABANDEJAENTRADA);

        jScrollPane4.setViewportView(jlLISTAMENSAJES);

        jlACLARACIONBANDEJA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 849, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 849, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jbRECIBIR)
                        .addGap(18, 18, 18)
                        .addComponent(jlACLARACIONBANDEJA, javax.swing.GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbRECIBIR)
                    .addComponent(jlACLARACIONBANDEJA, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Bandeja de Entrada", jPanel3);

        jbDISEÑADOR.setText("Hecho por:");
        jbDISEÑADOR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDISEÑADORActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 874, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(272, 272, 272)
                .addComponent(jLabel8)
                .addContainerGap(290, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(716, Short.MAX_VALUE)
                .addComponent(jbDISEÑADOR)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbSALIR, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbSALIR)
                    .addComponent(jbDISEÑADOR))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSALIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSALIRActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jbSALIRActionPerformed

    private void jbENVIARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbENVIARActionPerformed
        // TODO add your handling code here:

        asunto = jtfASUNTO.getText();
        de = jtfDE.getText();
        para = jtfPARA.getText();
        mensaje = jtaMENSAJE.getText();
        pass = jPasswordField1.getText();
        puerto = jtfPUERTOSALIDA.getText();

        Properties objetoPropiedad = new Properties();
        //se configura el servidor a conectar
        objetoPropiedad.setProperty("mail.smtp.host", serverSalida);
        //se configura conexion segura ssl
        objetoPropiedad.setProperty("mail.smtp.starttls.enable", "true");
        //se configura el puerto
        objetoPropiedad.setProperty("mail.smtp.port", puerto);
        //El usuario a utilizar el servicio de sesion
        objetoPropiedad.setProperty("mail.smtp.user", de);
        //configura si vamos a necesitar autenticacion
        objetoPropiedad.setProperty("mail.smtp.auth", "true");
        //creamos la sesion
        Session objetoMailSession = Session.getDefaultInstance(objetoPropiedad);
        //depuramos el envio del correo
        objetoMailSession.setDebug(true);
        //creamos el mensaje a enviar
        MimeMessage objetoMimeMessage = new MimeMessage(objetoMailSession);
        try {
            //introducimos el correo de envio
            objetoMimeMessage.setFrom(new InternetAddress(de));
            //Agregar varios destinartaros
            receptorCorreos = this.jtfPARA.getText();
            vectorpara = receptorCorreos.split("; ");
            for (String palabra : vectorpara) {
                para = palabra;
                objetoMimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(para));
            }
            //agregamos el asunto
            objetoMimeMessage.setSubject(asunto);
            //agregamos el mensaje
            objetoMimeMessage.setText(mensaje);
            //manejo del protocolo de conexion del envio
            Transport objTransporte = objetoMailSession.getTransport("smtp");
            //conexion usando el usuario y password
            objTransporte.connect(de, pass);
            //envio del mensaje
            objTransporte.sendMessage(objetoMimeMessage, objetoMimeMessage.getAllRecipients());
            //cierre de la conexion
            objTransporte.close();
            //mensaje de envio satisfactorio
            JOptionPane.showMessageDialog(null, "¡Correo enviado exitosamente!");

        } catch (MessagingException ex) {
            Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.toString());
        }

}//GEN-LAST:event_jbENVIARActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // servidor smtp para hotmail
        serverSalida = "smtp.live.com";
        serverEntrada = "pop3.live.com";
        this.jtfPUERTOSALIDA.setText("25");
        this.jlPuertodeSalida.setText("Puerto de envío de Hotmail");
        this.jtfPUERTOENTRADA.setText("995");
        this.jlPuertodeEntrada.setText("Puerto de recepción de Hotmail");
        this.jlCOMENTARIO.setText("Nos conectaremos a través de una cuenta Hotmail para enviar y recibir correos electrónicos");
}//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // servidor smtp para yahoo
        serverSalida = "smtp.mail.yahoo.com";
        serverEntrada = "pop.mail.yahoo.com";
        this.jtfPUERTOSALIDA.setText("587");
        this.jlPuertodeSalida.setText("Puerto de envío de Yahoo!");
        this.jtfPUERTOENTRADA.setText("995");
        this.jlPuertodeEntrada.setText("Puerto de recepción de Yahoo!");
        this.jlCOMENTARIO.setText("Nos conectaremos a través de una cuenta Yahoo! para enviar y recibir correos electrónicos");
}//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // servidor smtp para gmail
        serverSalida = "smtp.gmail.com";
        serverEntrada = "pop.gmail.com";
        this.jtfPUERTOSALIDA.setText("587");
        this.jlPuertodeSalida.setText("Puerto de envío de Gmail");
        this.jtfPUERTOENTRADA.setText("995");
        this.jlPuertodeEntrada.setText("Puerto de recepción de Gmail");
        this.jlCOMENTARIO.setText("Nos conectaremos a través de una cuenta Gmail para enviar y recibir correos electrónicos");
}//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jbRECIBIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRECIBIRActionPerformed

        de = this.jtfDE.getText();
        pass = this.jPasswordField1.getText();
        puerto = this.jtfPUERTOENTRADA.getText();
        this.jlACLARACIONBANDEJA.setText("Se mostrarán los 10 últimos correos recibidos.");

//Declaración del objeto Properties
        Properties prop = new Properties();

// Deshabilitamos TLS
        prop.setProperty("mail.pop3.starttls.enable", "false");

// Hay que usar SSL
        prop.setProperty("mail.pop3.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        prop.setProperty("mail.pop3.socketFactory.fallback", "false");

// Puerto 995 para conectarse.
        prop.setProperty("mail.pop3.port", puerto);
        prop.setProperty("mail.pop3.socketFactory.port", puerto);

        Session sesion = Session.getInstance(prop);
        sesion.setDebug(true);
        try {
            DefaultTableModel modeloTabla = new DefaultTableModel();
            DefaultListModel modeloLista = new DefaultListModel();
            modeloTabla.addColumn("De:");
            modeloTabla.addColumn("Asunto:");

            Store store = sesion.getStore("pop3");
            store.connect(serverEntrada, de, pass);
            Folder folder = store.getFolder("INBOX");
            folder.open(Folder.READ_ONLY);

            Message[] mensajes = folder.getMessages();

            for (int i = 0; i < 10; i++) {
                String a = mensajes[i].getFrom()[0].toString();
                String b = mensajes[i].getSubject();
                modeloTabla.addRow(new Object[]{});
                modeloTabla.setValueAt(a, i, 0);
                modeloTabla.setValueAt(b, i, 1);
                modeloLista.addElement(mensajes[i].getContent());

            }
            this.jtTABLABANDEJAENTRADA.setModel(modeloTabla);
            this.jlLISTAMENSAJES.setModel(modeloLista);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Imposible leer su bandeja de entrada", "Error", 0);
        }
    }//GEN-LAST:event_jbRECIBIRActionPerformed

    private void jbNUEVOCORREOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNUEVOCORREOActionPerformed
        // TODO add your handling code here:
        this.jtfPARA.setText("");
        this.jtfASUNTO.setText("");
        this.jtaMENSAJE.setText("");
    }//GEN-LAST:event_jbNUEVOCORREOActionPerformed

    private void jbDISEÑADORActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDISEÑADORActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Erick Stanley Cruz Martínez\n\nescm.1990@gmail.com\n\nCM09047  UESOCC  2010\n", "Diseñado por:", 1);
    }//GEN-LAST:event_jbDISEÑADORActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Interfaz.setDefaultLookAndFeelDecorated(true);
        SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.BusinessBlueSteelSkin");
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                Interfaz obj = new Interfaz();
                obj.setLocationRelativeTo(null);
                obj.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JButton jbDISEÑADOR;
    private javax.swing.JButton jbENVIAR;
    private javax.swing.JButton jbNUEVOCORREO;
    private javax.swing.JButton jbRECIBIR;
    private javax.swing.JButton jbSALIR;
    private javax.swing.JLabel jlACLARACIONBANDEJA;
    private javax.swing.JLabel jlCOMENTARIO;
    private javax.swing.JList jlLISTAMENSAJES;
    private javax.swing.JLabel jlPuertodeEntrada;
    private javax.swing.JLabel jlPuertodeSalida;
    private javax.swing.JTable jtTABLABANDEJAENTRADA;
    private javax.swing.JTextArea jtaMENSAJE;
    private javax.swing.JTextArea jtaNOTA_ACLARATORIA;
    private javax.swing.JTextField jtfASUNTO;
    private javax.swing.JTextField jtfDE;
    private javax.swing.JTextField jtfPARA;
    private javax.swing.JTextField jtfPUERTOENTRADA;
    private javax.swing.JTextField jtfPUERTOSALIDA;
    // End of variables declaration//GEN-END:variables
}