/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * cliente.java
 *
 * Created on 04-05-2011, 09:15:24 AM
 */
/**
 *
 * @author alexander
 */
import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
//import org.jvnet.substance.SubstanceLookAndFeel;

public class cliente extends javax.swing.JFrame {

    static DatagramSocket socket;
    static DatagramPacket paquete2;
    static DatagramPacket paquetenvio;
    static InetAddress direccionServidor;
    int puerto = 1234;
    static byte[] buffer, buffer2;
    public String nombre;
    Java_PDF miPDF = new Java_PDF();
String ip;
    public void setApodo() {
        nombre = JOptionPane.showInputDialog(rootPane, "Ingrese el apodo a mostrar");
    }
 public void sethost() {
        ip = JOptionPane.showInputDialog(rootPane, "Ingrese la ip del servidor");
    }
    public void ejecutarcliente() throws UnknownHostException {
        try {

            direccionServidor = InetAddress.getByName(ip);
            socket = new DatagramSocket(puerto);

        } catch (SocketException e) {
            System.out.println("error");

        }
        mostrarMensaje("iniciando cliente \n");
        this.conectar();
        recibirdatos();




    }

    public void recibirdatos() {
        while (true) {

            //creamos e inicializamos el paquete
            buffer = new byte[100];
            paquete2 = new DatagramPacket(buffer, buffer.length);
            try {

                socket.receive(paquete2);

                String datos = new String(paquete2.getData());

                mostrarMensaje(datos + "\n");


            } catch (IOException ex) {
                System.out.println("error");
            }
        }
    }

    public void enviar(String msj) {
        String str = "<< " + nombre + " >> " + msj;
        mostrarMensaje(str + "\n");
        buffer = str.getBytes();

        paquetenvio = new DatagramPacket(buffer, buffer.length, direccionServidor, puerto);
        try {
            //envia el datagram packet
            socket.send(paquetenvio);


        } catch (IOException ex) {
            System.out.println("error" + ex);
        }

    }

    public void conectar() {
        String str = nombre + " se ha conectado exitosamente \n";
        mostrarMensaje(str + "\n");
        buffer = str.getBytes();

        paquetenvio = new DatagramPacket(buffer, buffer.length, direccionServidor, puerto);
        try {
            //envia el datagram packet
            socket.send(paquetenvio);

        } catch (IOException ex) {
            System.out.println("error" + ex);
        }

    }

    private void cerrarConexion() {
        mostrarMensaje("\nFinalizando la conexión.\n");
        try {

            socket.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void mostrarMensaje(final String mensaje) {
        SwingUtilities.invokeLater(
                new Runnable() {

                    public void run() {
                        txt_visor.append(mensaje);
                    }
                });
    }

    /** Creates new form cliente */
    public cliente() {
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

        txt_escritura = new javax.swing.JTextField();
        btn_enviar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_visor = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CLIENTE UDP");
        setMinimumSize(new java.awt.Dimension(432, 300));
        setResizable(false);

        txt_escritura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_escrituraKeyPressed(evt);
            }
        });

        btn_enviar.setText("Enviar");
        btn_enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_enviarActionPerformed(evt);
            }
        });

        txt_visor.setColumns(20);
        txt_visor.setEditable(false);
        txt_visor.setRows(5);
        jScrollPane1.setViewportView(txt_visor);

        jMenu1.setText("Menu");

        jMenuItem3.setText("Cambiar Apodo");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setText("Guardar como PDF");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem2.setText("Cerrar Conexion");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txt_escritura, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_enviar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_escritura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_enviar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_enviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_enviarActionPerformed
        // TODO add your handling code here:
        enviar(txt_escritura.getText());
        txt_escritura.setText("");
    }//GEN-LAST:event_btn_enviarActionPerformed

    private void txt_escrituraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_escrituraKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == 10) {
            enviar(txt_escritura.getText());
            txt_escritura.setText("");
        }
    }//GEN-LAST:event_txt_escrituraKeyPressed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        cerrarConexion();
        System.exit(0);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(rootPane, "Erick Stanley Cruz Martínez\nAlexander Enrique Gonzalez Valencia");
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        setApodo();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        try {
            String titulo = JOptionPane.showInputDialog(rootPane, "Nombre del PDF:");
            miPDF.crearPDF(titulo, txt_visor.getText());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No se puede crear PDF");
        }

    }//GEN-LAST:event_jMenuItem4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
//       JFrame.setDefaultLookAndFeelDecorated(true);
//       SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.RavenSkin");
        cliente op = new cliente();
        op.setLocationRelativeTo(null);
        op.setVisible(true);
        try {
            op.sethost();
            op.setApodo();
            op.ejecutarcliente();

        } catch (UnknownHostException ex) {
            Logger.getLogger(cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_enviar;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txt_escritura;
    private javax.swing.JTextArea txt_visor;
    // End of variables declaration//GEN-END:variables
}