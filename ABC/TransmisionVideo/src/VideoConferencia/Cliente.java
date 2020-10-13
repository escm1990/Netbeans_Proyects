/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/*
 * Acceder2Frames.java
 *
 * Created on 30/06/2010, 10:15:01 PM
 */

package VideoConferencia;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.media.Buffer;
import javax.media.CannotRealizeException;
import javax.media.CaptureDeviceInfo;
import javax.media.CaptureDeviceManager;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.NoPlayerException;
import javax.media.Player;
import javax.media.Processor;
import javax.media.control.FrameGrabbingControl;
import javax.media.format.VideoFormat;
import javax.media.util.BufferToImage;
import javax.sound.sampled.AudioFormat;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Rolando
 */
public class Cliente extends javax.swing.JFrame {

    //Atributos necesarios para acceder a una cámara web
    private static Player player = null;
    private MediaLocator localizador = null;
    private Processor p;
    private CaptureDeviceInfo dispositivo = null;
    private static String source = "vfw:Microsoft WDM Image Capture (Win32):0";

    private Timer timer;
    private Buffer buffer;
    private BufferToImage buffer_image = null;
    private AudioFormat format;

    /** Creates new form Acceder2Frames
     * @param host
     */
    public Cliente(String host) throws IOException {
        try {
            initComponents();
            servidorChat = host;
            MediaLocator localizado = new MediaLocator(source);
            player = Manager.createRealizedPlayer(localizado);
            player.start();
            if (player.getVisualComponent() != null) {
                panelVideo.add(player.getVisualComponent(), BorderLayout.CENTER);
                panelVideo.updateUI();
            }

            timer = new Timer(1, new ActionListener() {

                //Cada 1 milisegundo capturará el frame de video
                public void actionPerformed(ActionEvent e) {
                     do{
                    FrameGrabbingControl fgc = (FrameGrabbingControl) player.getControl("javax.media.control.FrameGrabbingControl");
                    buffer = fgc.grabFrame();
                    // Convert it to an image
                    buffer_image = new BufferToImage((VideoFormat)buffer.getFormat());
                    Image bufferedImage = buffer_image.createImage(buffer);
//                    BufferedImage bufferedImage = (BufferedImage) buffer_image.createImage(buffer);
                    ByteArrayOutputStream salidaImagen = new ByteArrayOutputStream();
                    try {
                        ImageIO.write((RenderedImage) bufferedImage, "jpg", salidaImagen);
//                        ImageIO.write(bufferedImage, "jpg", salidaImagen);
                        byte[] bytesImagen = salidaImagen.toByteArray();
                        salida.writeObject(bytesImagen);
                        salida.flush();
//                                        panelCaptura.setImage(img);
                    } catch (Exception excepcionEOF) {
                        System.err.println("El cliente termino la conexión" + excepcionEOF.getMessage() + bufferedImage);
                    }
                    }while(player.getVisualComponent() != null);
                }

            });

            setLocationRelativeTo(null);
            setVisible(true);
        } catch (NoPlayerException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CannotRealizeException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


//    public void RepruducirVideo() throws IOException{
//        try{
////        servidorChat = host;
//            MediaLocator localizado = new MediaLocator(source);
//            player = Manager.createRealizedPlayer(localizado);
//            player.start();
//            if (player.getVisualComponent() != null) {
//                panelVideo.add(player.getVisualComponent(), BorderLayout.CENTER);
//                panelVideo.updateUI();
//            }
//
//            timer = new Timer(1, new ActionListener() {
//
//                //Cada 1 milisegundo capturará el frame de video
//                public void actionPerformed(ActionEvent e) {
//                     do{
//                    FrameGrabbingControl fgc = (FrameGrabbingControl) player.getControl("javax.media.control.FrameGrabbingControl");
//                    buffer = fgc.grabFrame();
//                    // Convert it to an image
//                    buffer_image = new BufferToImage((VideoFormat)buffer.getFormat());
//                    Image bufferedImage = buffer_image.createImage(buffer);
////                    BufferedImage bufferedImage = (BufferedImage) buffer_image.createImage(buffer);
//                    ByteArrayOutputStream salidaImagen = new ByteArrayOutputStream();
//                    try {
//                        ImageIO.write((RenderedImage) bufferedImage, "jpg", salidaImagen);
////                        ImageIO.write(bufferedImage, "jpg", salidaImagen);
//                        byte[] bytesImagen = salidaImagen.toByteArray();
//                        salida.writeObject(bytesImagen);
//                        salida.flush();
////                                        panelCaptura.setImage(img);
//                    } catch (Exception excepcionEOF) {
//                        System.err.println("El cliente termino la conexión" + excepcionEOF.getMessage() + bufferedImage);
//                    }
//                    }while(player.getVisualComponent() != null);
//                }
//
//            });
//
//            setLocationRelativeTo(null);
//            setVisible(true);
//        } catch (NoPlayerException ex) {
//            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (CannotRealizeException ex) {
//            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }

    public void IniciarTimer() {
        timer.start();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelVideo = new javax.swing.JPanel();
        panelOpciones = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Captura de Video - Transmisor de video");

        panelVideo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray));
        panelVideo.setLayout(new java.awt.BorderLayout());

        panelOpciones.setBackground(new java.awt.Color(204, 204, 204));

        jButton1.setText("Encender");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panelOpciones.add(jButton1);

        botonSalir.setText("Cerrar");
        botonSalir.setOpaque(false);
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });
        panelOpciones.add(botonSalir);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelVideo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
                    .addComponent(panelOpciones, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelVideo, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        // TODO add your handling code here:
        if(player != null) {
            player.close();
            player.deallocate();
        }
        timer.stop();
        cerrarConexion();
        System.exit(0);
    }//GEN-LAST:event_botonSalirActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//        try {
//            this.IniciarTimer();
//            this.RepruducirVideo();
//        } catch (IOException ex) {
//            System.out.println("Error al iniciar webcam: " + ex.getMessage());
//        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ejecutarCliente() {
        try {
            conectarAServidor(); // Paso 1: crear un socket para realizar la conexión
            salida = new ObjectOutputStream( cliente.getOutputStream() );
            salida.flush(); // vacíar búfer de salida para enviar información de encabezado
            IniciarTimer();
        } catch ( EOFException excepcionEOF ) {
            System.err.println( "El cliente termino la conexión" );
        } catch ( IOException excepcionES ) {
            excepcionES.printStackTrace();
        }
    } // fin del método ejecutarCliente

    // conectarse al servidor
    private void conectarAServidor() throws IOException {
        cliente = new Socket( InetAddress.getByName( servidorChat ), 12345 );
    }

    private void cerrarConexion() {
        System.out.println( "\nCerrando conexión" );
        try {
            salida.close();
            cliente.close();
        } catch( IOException excepcionES ) {
            excepcionES.printStackTrace();
        }
    }

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        try {
            setDefaultLookAndFeelDecorated(true);
            String host = JOptionPane.showInputDialog("Ingrese Direccion de host: ", "localhost");

            Cliente ventana = new Cliente(host);
            ventana.ejecutarCliente();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private ObjectOutputStream salida;
    private String servidorChat;
    private Socket cliente;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonSalir;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel panelOpciones;
    private javax.swing.JPanel panelVideo;
    // End of variables declaration//GEN-END:variables

}
