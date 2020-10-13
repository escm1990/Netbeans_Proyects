/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TCPCliente.java
 *
 * Created on 05-abr-2011, 0:04:15
 */
package TCPCliente;

import java.io.*;
import java.net.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import org.jvnet.substance.SubstanceLookAndFeel;

/**
 *
 * @author USUARIO
 */
public class TCPCliente extends javax.swing.JFrame {

    //Declaracion de variables
    private ObjectInputStream datos_entrada;
    private ObjectOutputStream datos_salida;
    private Socket socketCliente;
    public String mensaje = "", ip_servidor = "192.168.0.2", nickname = "" ;
    Java_PDF miPDF = new Java_PDF();

        /**
     * Metodo que cambia el Apodo del usuario
     * al momento de mostar en el chat
     */
    public void setNickname() {
        nickname = JOptionPane.showInputDialog(rootPane, "¿Qué Nickname desea mostrar?");
        this.setTitle("CHAT HDP 2011 - Cliente: " + nickname);
    }

    /** Creates new form TCPCliente */
    public TCPCliente() {
        initComponents();
    }

    /**
     * Metodo que se encarga de realizar la conexion, prepara
     * los componente de E/S y cierra la conexion
     */
    public void ejecutarCliente() {
        try {
            conectaraSevidor();
            obtenerFlujos();
            procesarConexion();
        } catch (EOFException ex) {
            JOptionPane.showMessageDialog(rootPane, "Finalizando la conexión");
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }

    /**
     * Metodo que conecta al servidor
     * @throws IOException
     */
    public void conectaraSevidor() throws IOException {
        mostrarMensaje("Intentando conexion... \n\n");
        socketCliente = new Socket(ip_servidor, 1234);
        mostrarMensaje("Conectando a: " + socketCliente.getInetAddress().getHostName());
    }

    /*Obteniendo datos E/S*/
    private void obtenerFlujos() throws IOException {
        datos_salida = new ObjectOutputStream(socketCliente.getOutputStream());
        datos_salida.flush();
        datos_entrada = new ObjectInputStream(socketCliente.getInputStream());
        mostrarMensaje("\nSe recibieron los flujos E/S \n");
    }

    /*
     * Metodo que procesa la conexion
     */
    private void procesarConexion() throws IOException {
        mensaje = "Conexion realizada exitosamente con " + nickname;
        enviarDatos(mensaje);
        do {
            try {
                mensaje = (String) datos_entrada.readObject();
                mostrarMensaje("\n" + mensaje);
            } catch (ClassNotFoundException ex) {
                mostrarMensaje("Se recibió un objeto de tipo desconocido \n");
            }
        } while (!mensaje.contains(": desconectar"));
        try {
            this.cerrarConexion();
        } catch (Exception ex) {
            this.mostrarMensaje(ex.getMessage());
        }
    }

    /*
     * Metodo que cierra la conexion
     */
    private void cerrarConexion() {
        mostrarMensaje("\nCerrando...");
        try {
            datos_salida.close();
            datos_entrada.close();
            socketCliente.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /*
     * Enviando datos al servidor
     */
    private void enviarDatos(String mens) {
        try {
            datos_salida.writeObject(nickname + " dice: " + mens);
            datos_salida.flush();
            mostrarMensaje("\nYo digo: " + mens);
        } catch (IOException ex) {
            this.jtaVisor.append("\nError al escribir objeto");
        }
    }

    /*
     *Metodo que esta ingresando el texto en el
     * JTextArea Visor
     */
    private void mostrarMensaje(final String mens) {
        SwingUtilities.invokeLater(
                new Runnable() {

                    public void run() {
                        jtaVisor.append(mens);
                    }
                });
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtaVisor = new javax.swing.JTextArea();
        jtfMensaje = new javax.swing.JTextField();
        jbEnviar = new javax.swing.JButton();
        jbNick = new javax.swing.JButton();
        jbCloseConection = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CLIENTE");
        setMinimumSize(new java.awt.Dimension(473, 353));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jtaVisor.setColumns(20);
        jtaVisor.setEditable(false);
        jtaVisor.setRows(5);
        jScrollPane1.setViewportView(jtaVisor);

        jtfMensaje.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfMensajeKeyPressed(evt);
            }
        });

        jbEnviar.setText("Enviar");
        jbEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEnviarActionPerformed(evt);
            }
        });

        jbNick.setText("Nick");
        jbNick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNickActionPerformed(evt);
            }
        });

        jbCloseConection.setText("Close");
        jbCloseConection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCloseConectionActionPerformed(evt);
            }
        });

        jMenu1.setText("Conexion");

        jMenuItem2.setText("Cambiar Apodo");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem4.setText("Guardar como PDF");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem3.setText("Cerrar Sesion");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Acerca de");

        jMenuItem1.setText("Hecho por:");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jtfMensaje, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbEnviar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbNick, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbCloseConection, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbEnviar)
                    .addComponent(jbNick)
                    .addComponent(jbCloseConection))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEnviarActionPerformed
        // TODO add your handling code here:
        this.enviarDatos(this.jtfMensaje.getText());
        this.jtfMensaje.setText("");
    }//GEN-LAST:event_jbEnviarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        try {
            this.cerrarConexion();
        } catch (Exception ex) {
            this.mostrarMensaje(ex.getMessage());
        }
    }//GEN-LAST:event_formWindowClosing

    private void jbNickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNickActionPerformed
        // TODO add your handling code here:
        this.setNickname();
        this.jtaVisor.append("\nSu nuevo nickname es: " + nickname);
        this.enviarDatos(nickname + " ha cambiado su nickname");
    }//GEN-LAST:event_jbNickActionPerformed

    private void jbCloseConectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCloseConectionActionPerformed
        // TODO add your handling code here:
        try {
            this.cerrarConexion();
        } catch (Exception ex) {
            this.mostrarMensaje(ex.getMessage());
        }
        System.exit(0);
    }//GEN-LAST:event_jbCloseConectionActionPerformed

    private void jtfMensajeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfMensajeKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == 10) {
            this.enviarDatos(this.jtfMensaje.getText());
            this.jtfMensaje.setText("");
        }
    }//GEN-LAST:event_jtfMensajeKeyPressed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(rootPane, "Erick Stanley Cruz Martínez\nAlexander Enrique Gonzalez Valencia");
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        this.setNickname();
        this.jtaVisor.append("\nSu nuevo nickname es: " + nickname);
        this.enviarDatos(nickname + " ha cambiado su nickname");
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        this.cerrarConexion();
        System.exit(0);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        try {
            String titulo = JOptionPane.showInputDialog(rootPane, "Nombre del PDF:");
            miPDF.crearPDF(titulo, jtaVisor.getText());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No se puede crear PDF");
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        JFrame.setDefaultLookAndFeelDecorated(true); //que nos permite dejar a Substance la decoracion ( por asi decirlo)
        SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.NebulaSkin"); // Setencia que aplica el skin Creme de Substance
        TCPCliente ap = new TCPCliente();
        ap.setLocationRelativeTo(null);
        ap.setVisible(true);
        ap.setNickname();
        ap.ejecutarCliente();

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbCloseConection;
    private javax.swing.JButton jbEnviar;
    private javax.swing.JButton jbNick;
    private javax.swing.JTextArea jtaVisor;
    private javax.swing.JTextField jtfMensaje;
    // End of variables declaration//GEN-END:variables
}
