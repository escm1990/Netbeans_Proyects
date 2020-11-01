/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Acceder2Frames.java
 *
 * Created on 30/06/2010, 10:15:01 PM
 */

package com.blogspot.rolandopalermo.sockets;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.media.Buffer;
import javax.media.CannotRealizeException;
import javax.media.CaptureDeviceInfo;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.NoPlayerException;
import javax.media.Player;
import javax.media.Processor;
import javax.media.control.FrameGrabbingControl;
import javax.media.format.VideoFormat;
import javax.media.util.BufferToImage;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import org.jvnet.substance.SubstanceLookAndFeel;

/**
 *
 * @author Rolando
 */
public class Acceder2Frames extends javax.swing.JFrame {

    //Atributos necesarios para acceder a una cámara web
    private static Player player = null;
    private MediaLocator localizador = null;
    private Processor p;
    private CaptureDeviceInfo dispositivo = null;
    private static String source = "vfw:Microsoft WDM Image Capture (Win32):0";
    private Timer timer;
    private Buffer buffer;
    private BufferToImage buffer_image = null;
    private ObjectInputStream entrada;

    /** Creates new form Acceder2Frames */
    public Acceder2Frames(String host) throws IOException {
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
            Logger.getLogger(Acceder2Frames.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CannotRealizeException ex) {
            Logger.getLogger(Acceder2Frames.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    private void iniciarCaptura() {
//        try {
//            player = Manager.createRealizedPlayer(localizador);
//            player.start();
//            if (player.getVisualComponent() != null) {
//                panelVideo.add(player.getVisualComponent(), BorderLayout.CENTER);
//                panelVideo.updateUI();
//            }
//        } catch (Exception e) {
//            System.err.println(e.toString());
//        }
//    }

    public void acceso2Frames() {
        timer.start();
    }

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
        botonSalir = new javax.swing.JButton();
        lienzo2 = new com.blogspot.rolandopalermo.sockets.Lienzo();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Captura de Video - Transmisor de video");

        panelVideo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray));
        panelVideo.setLayout(new java.awt.BorderLayout());

        panelOpciones.setBackground(new java.awt.Color(204, 204, 204));

        botonSalir.setText("Cerrar");
        botonSalir.setOpaque(false);
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });
        panelOpciones.add(botonSalir);

        javax.swing.GroupLayout lienzo2Layout = new javax.swing.GroupLayout(lienzo2);
        lienzo2.setLayout(lienzo2Layout);
        lienzo2Layout.setHorizontalGroup(
            lienzo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 305, Short.MAX_VALUE)
        );
        lienzo2Layout.setVerticalGroup(
            lienzo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 278, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelVideo, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lienzo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelOpciones, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelVideo, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                    .addComponent(lienzo2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void ejecutarCliente() {
        try {
            // Paso 1: crear un socket para realizar la conexión
            cliente = new Socket(servidorChat, 12345);
//            cliente = new Socket( InetAddress.getByName( servidorChat ), 12345 );
            salida = new ObjectOutputStream( cliente.getOutputStream() );
            salida.flush(); // vacíar búfer de salida para enviar información de encabezado
            acceso2Frames();
            while ( true ) {
                try {
//                    esperarConexion();
                    entrada = new ObjectInputStream( cliente.getInputStream() );
                    System.out.println( "\nSe recibieron los flujos de entrada\n" );
                    procesarConexion();
                } catch ( EOFException excepcionEOF ) {
                    System.err.println( "El servidor terminó la conexión" );
                    excepcionEOF.printStackTrace();
                } finally {
                    cerrarConexion();   // Paso 5: cerrar la conexión.
                }
            } // fin de instrucción while
        } catch ( EOFException excepcionEOF ) {
            System.err.println( "El cliente termino la conexión" );
        } catch ( IOException excepcionES ) {
            excepcionES.printStackTrace();
        }
    } // fin del método ejecutarCliente

    // conectarse al servidor
//    private void conectarAServidor() throws IOException {
//
//    }

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

        Acceder2Frames.setDefaultLookAndFeelDecorated(true);
        SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.DustCoffeeSkin");
        try{
         String host =(JOptionPane.showInputDialog("Ingrese direccion del host: " , "localhost"));
        Acceder2Frames ventana = new Acceder2Frames(host);
//        ventana.iniciarCaptura();
        ventana.ejecutarCliente();
        }catch(IOException ex){
            ex.getStackTrace();
        }
    }

    private ObjectOutputStream salida;
    private String servidorChat;
    private Socket cliente;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonSalir;
    private com.blogspot.rolandopalermo.sockets.Lienzo lienzo2;
    private javax.swing.JPanel panelOpciones;
    private javax.swing.JPanel panelVideo;
    // End of variables declaration//GEN-END:variables

}