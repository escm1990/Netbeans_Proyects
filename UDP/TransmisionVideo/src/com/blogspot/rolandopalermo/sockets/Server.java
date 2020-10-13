/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Server.java
 *
 * Created on 24/08/2010, 12:10:27 AM
 */

package com.blogspot.rolandopalermo.sockets;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.RenderedImage;
import java.io.ByteArrayOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.media.Buffer;
import javax.media.CannotRealizeException;
import javax.media.Manager;
import javax.media.NoPlayerException;
import javax.media.control.FrameGrabbingControl;
import javax.media.format.VideoFormat;
import javax.media.util.BufferToImage;
import javax.swing.Timer;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.imageio.ImageIO;
import javax.media.MediaLocator;
import javax.media.Player;
import org.jvnet.substance.SubstanceLookAndFeel;

/**
 *
 * @author Rolando
 */
public class Server extends javax.swing.JFrame {

    private static Player player = null;
    //private MediaLocator localizador = null;
    //private Processor p;
    //private CaptureDeviceInfo dispositivo = null;
    private static String source = "vfw:Microsoft WDM Image Capture (Win32):0";
    private Timer timer;
    private Buffer buffer;
    private BufferToImage buffer_image = null;
    private ObjectInputStream entrada;
    private ObjectOutputStream salida;
    private ServerSocket servidor;
    private Socket conexion;

    /** Creates new form Server
     * @throws IOException
     */
    public Server() throws IOException {
        try{
        initComponents();
//        servidorChat = host;
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
            Logger.getLogger(Acceder2Frames.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CannotRealizeException ex) {
            Logger.getLogger(Acceder2Frames.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void acceso2Frames() {
        timer.start();
    }

     public void ejecutarServidor() {
        try {
            servidor = new ServerSocket( 12345, 100 );
            salida = new ObjectOutputStream( conexion.getOutputStream() );
            salida.flush(); // vacíar búfer de salida para enviar información de encabezado
            acceso2Frames();
            while ( true ) {
                try {
                    esperarConexion();
                    entrada = new ObjectInputStream( conexion.getInputStream() );
                    System.out.println( "\nSe recibieron los flujos de entrada\n" );
                    procesarConexion();
                } catch ( EOFException excepcionEOF ) {
                    System.err.println( "El servidor terminó la conexión" );
                    excepcionEOF.printStackTrace();
                } finally {
                    cerrarConexion();   // Paso 5: cerrar la conexión.
                }
            } // fin de instrucción while
        } // fin del bloque try
        catch ( IOException excepcionES ) {
            excepcionES.printStackTrace();
        }

    } // fin del método ejecutarServidor
    // esperar que la conexión llegue, después mostrar información de la conexión
    private void esperarConexion() throws IOException {
        System.out.println( "Esperando una conexión\n" );
        conexion = servidor.accept(); // permitir al servidor aceptar la conexión
        System.out.println( "Conexión recibida de: " + conexion.getInetAddress().getHostName() );
    }
    // procesar la conexión con el cliente
    private void procesarConexion() throws IOException {
        do { // procesar los mensajes enviados por el cliente
            // leer el mensaje y mostrarlo en pantalla
            try {
                byte[] bytesImagen = (byte[]) entrada.readObject();
                ByteArrayInputStream entradaImagen = new ByteArrayInputStream(bytesImagen);
                BufferedImage bufferedImage = ImageIO.read(entradaImagen);
                lienzo2.setImage(bufferedImage);
            }

            // atrapar problemas que pueden ocurrir al tratar de leer del cliente
            catch ( ClassNotFoundException excepcionClaseNoEncontrada ) {
                System.out.println( "\nSe recibió un tipo de objeto desconocido" );
            }

        } while ( true );

    } // fin del método procesarConexion
    // cerrar flujos y socket
    private void cerrarConexion() {
        System.out.println( "\nFinalizando la conexión\n" );
        try {
            entrada.close();
            conexion.close();
        } catch( IOException excepcionES ) {
            excepcionES.printStackTrace();
        }
    }

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        try {
            Server.setDefaultLookAndFeelDecorated(true);
            SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.BusinessBlackSteelSkin");
            Server s = new Server();
            s.ejecutarServidor();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lienzo2 = new com.blogspot.rolandopalermo.sockets.Lienzo();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        panelVideo = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Servidor - Receptor de video");

        javax.swing.GroupLayout lienzo2Layout = new javax.swing.GroupLayout(lienzo2);
        lienzo2.setLayout(lienzo2Layout);
        lienzo2Layout.setHorizontalGroup(
            lienzo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 305, Short.MAX_VALUE)
        );
        lienzo2Layout.setVerticalGroup(
            lienzo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 282, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jButton1.setText("Cerrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);

        panelVideo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray));
        panelVideo.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lienzo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelVideo, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelVideo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                    .addComponent(lienzo2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents



    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        cerrarConexion();
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private com.blogspot.rolandopalermo.sockets.Lienzo lienzo2;
    private javax.swing.JPanel panelVideo;
    // End of variables declaration//GEN-END:variables

}
