/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * servidor.java
 *
 * Created on 04-04-2011, 08:10:34 PM
 */


import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.Player;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.*;
import javax.sound.sampled.TargetDataLine;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;


/**
 *
 * @author alexander
 */
public class servidor extends javax.swing.JFrame {

    static DatagramSocket socket;
    static DatagramPacket paquet;
    InetAddress direccion;
    int puerto = 1234;
    static byte[] buffer;
    public String nombre;
//    Java_PDF miPDF = new Java_PDF();

    public void setApodo() {
        nombre = JOptionPane.showInputDialog(rootPane, "¿Que apodo desea mostrar?");
    }

    public void ejecutarservidor() throws UnknownHostException {
        try {
            socket = new DatagramSocket(puerto);
        } catch (SocketException e) {
            System.out.println("error");

        }
        mostrarMensaje("iniciando servidor \n");
        recibirdatos();

    }

    public void recibirdatos() {
        while (true) {

            //creamos e inicializamos el paquete
            buffer = new byte[1024];
            paquet = new DatagramPacket(buffer, buffer.length);
            try {
                socket.receive(paquet);
                if (paquet == null) {
                    break;
                } else {
                    direccion = paquet.getAddress();
                    buffer = paquet.getData();
                    this.reivirareglo();
//                    String datos = new String(paquet.getData());

//                    mostrarMensaje(datos + "\n");
                }
            } catch (IOException ex) {
                System.out.println("error");
            }
        }
    }

    public void reivirareglo(){
        try {
            final InputStream audio = new ByteArrayInputStream(buffer);
            float ft = 8000;
            final AudioFormat format = new AudioFormat(ft, 8, 1, true, true);
            AudioInputStream sonido = new AudioInputStream(audio, format, buffer.length / format.getFrameSize());
            DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
            final SourceDataLine tg = (SourceDataLine) AudioSystem.getLine(info);
            tg.open();
            tg.start();

            Runnable run = new Runnable() {

                private MediaLocator ml = new MediaLocator("javasound://44100");
                private Player player;
                
                int buffersize = (int) format.getSampleRate() * format.getFrameSize();
                byte bufer[] = new byte[buffersize];
                public void run() {

                    try {
                        int count;
                        while((count = audio.read(bufer, 0, bufer.length)) != 1){
                              if(count > 0){
                                  tg.write(bufer, 0, count);
                              }
                        }
                        tg.drain();
                        tg.close();
                    } catch (IOException e) {
                    }
                }
            };
            Thread play = new Thread(run);
            play.start();

        } catch (LineUnavailableException ex) {
            Logger.getLogger(servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void enviar(String msj) {
        DatagramPacket paquete2;
        String str = "<< " + nombre + " >>" + msj;
        buffer = str.getBytes();
        mostrarMensaje(str + "\n");
        paquete2 = new DatagramPacket(buffer, buffer.length, direccion, puerto);
        try {
            //envia el datagram packet
            socket.send(paquete2);
        } catch (IOException ex) {
            System.out.println("error");
        }

    }

    private void cerrarConexion() {
        mostrarMensaje("\n Finalizando la conexión.\n");
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

    /** Creates new form servidor */
    public servidor() {
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

        btn_enviar = new javax.swing.JButton();
        txt_escritura = new javax.swing.JTextField();
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
        setTitle("SERVIDOR UDP");
        setMinimumSize(new java.awt.Dimension(432, 300));
        setResizable(false);

        btn_enviar.setText("Enviar");
        btn_enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_enviarActionPerformed(evt);
            }
        });

        txt_escritura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_escrituraKeyPressed(evt);
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
                        .addComponent(txt_escritura, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_enviar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_enviar)
                    .addComponent(txt_escritura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_enviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_enviarActionPerformed
        // TODO add your handling code here:
        this.enviar(txt_escritura.getText());
        this.txt_escritura.setText("");
}//GEN-LAST:event_btn_enviarActionPerformed

    private void txt_escrituraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_escrituraKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == 10) {
            enviar(txt_escritura.getText());
            txt_escritura.setText("");
        }
}//GEN-LAST:event_txt_escrituraKeyPressed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(rootPane, "Erick Stanley Cruz Martínez\nAlexander Enrique Gonzalez Valencia");
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        cerrarConexion();
        System.exit(0);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        setApodo();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        try {
            String titulo = JOptionPane.showInputDialog(rootPane, "Nombre del PDF:");
//            miPDF.crearPDF(titulo, txt_visor.getText());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No se puede crear PDF");
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    /**
     * @param args the command line arguments
     * @throws UnknownHostException
     */
    public static void main(String args[]) throws UnknownHostException {

        servidor ap = new servidor();
        ap.setLocationRelativeTo(null);
        ap.setVisible(true);
        ap.setApodo();
        ap.ejecutarservidor();
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