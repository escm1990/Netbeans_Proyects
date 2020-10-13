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

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.imageio.ImageIO;

/**
 *
 * @author Rolando
 */
public class Server extends javax.swing.JFrame {

    /** Creates new form Server */
    public Server() {
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private ObjectInputStream entrada;
    private ServerSocket servidor;
    private Socket conexion;

    public void ejecutarServidor() {
        try {
            servidor = new ServerSocket(12345, 100);
            while (true) {
                try {
                    esperarConexion();
                    entrada = new ObjectInputStream(conexion.getInputStream());
                    System.out.println("\nSe recibieron los flujos de entrada\n");
                    procesarConexion();
                } catch (EOFException excepcionEOF) {
                    System.err.println("El servidor terminó la conexión");
                    excepcionEOF.printStackTrace();
                } finally {
                    cerrarConexion();   // Paso 5: cerrar la conexión.
                }
            } // fin de instrucción while
        } // fin del bloque try
        catch (IOException excepcionES) {
            excepcionES.printStackTrace();
        }

    } // fin del método ejecutarServidor
    // esperar que la conexión llegue, después mostrar información de la conexión

    private void esperarConexion() throws IOException {
        System.out.println("Esperando una conexión\n");
        conexion = servidor.accept(); // permitir al servidor aceptar la conexión
        System.out.println("Conexión recibida de: " + conexion.getInetAddress().getHostName());
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
//                lienzo.setIcon((Icon) bufferedImage);
            } // atrapar problemas que pueden ocurrir al tratar de leer del cliente
            catch (ClassNotFoundException excepcionClaseNoEncontrada) {
                System.out.println("\nSe recibió un tipo de objeto desconocido");
            }

        } while (true);

    } // fin del método procesarConexion
    // cerrar flujos y socket

    private void cerrarConexion() {
        System.out.println("\nFinalizando la conexión\n");
        try {
            entrada.close();
            conexion.close();
        } catch (IOException excepcionES) {
            excepcionES.printStackTrace();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        //setDefaultLookAndFeelDecorated(true);
        Server s = new Server();
        s.ejecutarServidor();
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
        lienzo = new javax.swing.JLabel();

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lienzo2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(lienzo, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lienzo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
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
    private javax.swing.JLabel lienzo;
    private com.blogspot.rolandopalermo.sockets.Lienzo lienzo2;
    // End of variables declaration//GEN-END:variables
}
