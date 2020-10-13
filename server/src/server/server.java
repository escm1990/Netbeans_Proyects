/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * server.java
 *
 * Created on 20-mar-2011, 20:38:53
 */
package server;

import java.io.*; //libreria para lectura y escritura de streams
import java.net.*; //librería para el envío y recepción de streams a través de la red
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import org.jvnet.substance.SubstanceLookAndFeel;

/**
 *Programa Servidor del Chat
 * @author USUARIO
 */
public class server extends javax.swing.JFrame {

    private ObjectInputStream entrada; //elemento que contiene el mensaje hacia el server
    private ObjectOutputStream salida; //elemento que contiene el mensaje hacia el client
    private ServerSocket socketServidor;//socket servidor
    private Socket socketConexion; //conexion
    byte[] arrayData;
    private int contador = 1; //nos permite llevar la cuenta de las conexiones y de los datos que recibe
    private String mensaje = "";
    public String nickname = "", file = "";

    /** Creates new form server */
    public server() {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/images/Linux.png")).getImage());
    }

    public void setNickname() {
        nickname = JOptionPane.showInputDialog(rootPane, "¿Qué Nickname desea mostrar?");
        this.setTitle("CHAT HDP 2011 - Servidor: " + nickname);
    }

    public void ejecutarServidor() {
        try {
            socketServidor = new ServerSocket(1234, 50); //Puerto y Backlog
            while (true) {
                try {
                    esperarConexion();
                    obtenerFlujos();
                    procesarConexion();
                } catch (EOFException ex) {
                    JOptionPane.showMessageDialog(rootPane, "Finalizando la conexión");
                } finally {
                    cerrarConexion();
                    ++contador;
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void esperarConexion() throws IOException {
        mostrarMensaje("Esperando una conexión\n");
        socketConexion = socketServidor.accept(); //aceptando la conexion con el servidor
        mostrarMensaje("Conexion " + contador + " recibida de: " + socketConexion.getInetAddress().getHostName());
    }

    private void obtenerFlujos() throws IOException {
        salida = new ObjectOutputStream(socketConexion.getOutputStream());
        salida.flush();
        entrada = new ObjectInputStream(socketConexion.getInputStream());
        mostrarMensaje("\nSe recibieron los flujos E/S\n");
    }

    private void procesarConexion() throws IOException {
        int acceptCleinte = JOptionPane.showConfirmDialog(rootPane, "Un cliente intenta establecer conexión.\n¿Desea establecer conexion con el?");
        if (JOptionPane.YES_NO_OPTION == acceptCleinte) {
            mensaje = "Conexion realizada exitosamente con " + nickname;
            enviarDatos(mensaje);
            do {
                try {
                    mensaje = (String) entrada.readObject();
                    mostrarMensaje("\n" + mensaje);
                } catch (ClassNotFoundException ex) {
                    mostrarMensaje("\nSe recibio un tipo de objeto desconocido\n");
                }
            } while (!mensaje.contains(": Enviando Archivo..."));
            try {
                this.recibirArchivo();
            } catch (Exception ex) {
                this.mostrarMensaje(ex.getMessage());
            }
        } else {
            try {
                salida.close();
                entrada.close();
                socketConexion.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void enviarArchivo() throws FileNotFoundException, IOException {
        enviarDatos("Enviando Archivo...");
        BufferedInputStream bis;
        BufferedOutputStream bos;
        int in;
        byte[] byteArray;
        final String filename;
        JFileChooser chooserObj = new JFileChooser();
        chooserObj.setDialogTitle("Seleccione el archivo a enviar");
        chooserObj.showOpenDialog(null);
        filename = chooserObj.getSelectedFile().getPath();
        System.out.println(filename);
        try {
            final File localFile = new File(filename);
            bis = new BufferedInputStream(new FileInputStream(localFile));
            bos = new BufferedOutputStream(socketConexion.getOutputStream());
            DataOutputStream dos = new DataOutputStream(socketConexion.getOutputStream());
            dos.writeUTF(localFile.getName());
            byteArray = new byte[8192];
            while ((in = bis.read(byteArray)) != -1) {
                bos.write(byteArray, 0, in);
            }
            bis.close();
            bos.close();
            JOptionPane.showMessageDialog(rootPane, "El archivo se envió correctamente.", "Resultado de transferencia.", 1);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    private void recibirArchivo() {
        BufferedInputStream bis;
        BufferedOutputStream bos;
        byte[] receivedData;
        int in;
        String archivo;
        try {
            JFileChooser chooserObj = new JFileChooser();
            chooserObj.setDialogTitle("Guardar archivo en:");
            chooserObj.showSaveDialog(null);
            while (true) {
                receivedData = new byte[8192];
                bis = new BufferedInputStream(socketConexion.getInputStream());
                DataInputStream dis = new DataInputStream(socketConexion.getInputStream());
                archivo = dis.readUTF();
                archivo = archivo.substring(archivo.indexOf('/') + 1, archivo.length());
                String cadena = null;
                StringTokenizer ruta = new StringTokenizer(chooserObj.getCurrentDirectory().getPath(), "\\");
                while (ruta.hasMoreTokens()) {
                    cadena += ruta.nextToken() + "/";
                }
                String newcadena = null;
                newcadena = cadena.replace("null", "");
                System.out.println(newcadena + archivo);
                bos = new BufferedOutputStream(new FileOutputStream(newcadena + archivo));
                while ((in = bis.read(receivedData)) != -1) {
                    bos.write(receivedData, 0, in);
                }
                bos.close();
                dis.close();
                JOptionPane.showMessageDialog(rootPane, "El archivo se guardó correctamente.", "Resultado de transferencia.", 1);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    private void cerrarConexion() {
        mostrarMensaje("\nFinalizando la conexión.\n");
        try {
            salida.close();
            entrada.close();
            socketConexion.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void enviarDatos(String mens) {
        try {
            salida.writeObject(nickname + " dice: " + mens);
            salida.flush();
            mostrarMensaje("\nYo digo: " + mens);
        } catch (IOException ex) {
            this.txt_visor.append("\nError al escribir objeto");
        }
    }

    private void mostrarMensaje(final String mens) {
        SwingUtilities.invokeLater(
                new Runnable() {

                    public void run() {
                        txt_visor.append(mens);
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

        jpBackground = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_visor = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        txt_mns = new javax.swing.JTextField();
        btn_enviar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CHAT HDP 2011 - Servidor");
        setMinimumSize(new java.awt.Dimension(409, 392));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jpBackground.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Visor del Chat:", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N
        jpBackground.setPreferredSize(new java.awt.Dimension(409, 393));

        txt_visor.setColumns(20);
        txt_visor.setEditable(false);
        txt_visor.setRows(5);
        jScrollPane1.setViewportView(txt_visor);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel3.setText("Mensaje:");

        txt_mns.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_mnsKeyPressed(evt);
            }
        });

        btn_enviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Update.png"))); // NOI18N
        btn_enviar.setText("Enviar");
        btn_enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_enviarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpBackgroundLayout = new javax.swing.GroupLayout(jpBackground);
        jpBackground.setLayout(jpBackgroundLayout);
        jpBackgroundLayout.setHorizontalGroup(
            jpBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                    .addGroup(jpBackgroundLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_mns, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_enviar)))
                .addContainerGap())
        );
        jpBackgroundLayout.setVerticalGroup(
            jpBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBackgroundLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jpBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_mns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_enviar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu1.setText("Menú");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Modify.png"))); // NOI18N
        jMenuItem1.setText("Cambiar Nickname");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Load.png"))); // NOI18N
        jMenuItem3.setText("Enviar Archivo Unico");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Display 16x16.png"))); // NOI18N
        jMenuItem5.setText("Cambiar Tema");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Turn off.png"))); // NOI18N
        jMenuItem2.setText("Cerrar Sesión");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Acerca de");

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Boss.png"))); // NOI18N
        jMenuItem4.setText("Hecho por");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpBackground, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_enviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_enviarActionPerformed
        // TODO add your handling code here:
        this.enviarDatos(this.txt_mns.getText());
        this.txt_mns.setText("");
    }//GEN-LAST:event_btn_enviarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        try {
            this.cerrarConexion();
        } catch (Exception ex) {
            this.mostrarMensaje(ex.getMessage());
        }
    }//GEN-LAST:event_formWindowClosing

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        try {
            this.cerrarConexion();
        } catch (Exception ex) {
            this.mostrarMensaje(ex.getMessage());
        }
        JOptionPane.showMessageDialog(rootPane, "Gracias por utlizar esta aplicación Java.");
        System.exit(0);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        this.setNickname();
        this.txt_visor.append("\nSu nuevo nickname es: " + nickname);
        this.enviarDatos(nickname + " ha cambiado su nickname");
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(rootPane, "Erick Stanley Cruz Martínez\nAlexander Enrique González Valencia");
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void txt_mnsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_mnsKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == 10) {
            this.enviarDatos(this.txt_mns.getText());
            this.txt_mns.setText("");
        }
    }//GEN-LAST:event_txt_mnsKeyPressed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here
        JOptionPane.showMessageDialog(rootPane, "1. Hacer clic en el Icono de Thux (pingüino) superior izquierdo.\n2. Seleccionar entre las opciones que aparecen en el menú.");
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        try {
            // TODO add your handling code here:
            enviarArchivo();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    /**
     * @param args the command line arguments
     * @throws IOException
     */
    public static void main(String args[]) throws IOException {
        JFrame.setDefaultLookAndFeelDecorated(true); //que nos permite dejar a Substance la decoracion ( por asi decirlo)
        SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.NebulaSkin"); // Setencia que aplica el skin Creme de Substance
        server ap = new server();
        ap.setLocationRelativeTo(null);
        ap.setVisible(true);
        ap.setNickname();
        ap.ejecutarServidor();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_enviar;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpBackground;
    private javax.swing.JTextField txt_mns;
    private javax.swing.JTextArea txt_visor;
    // End of variables declaration//GEN-END:variables
}
