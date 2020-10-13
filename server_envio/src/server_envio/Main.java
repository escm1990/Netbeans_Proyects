/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server_envio;

/**
 *
 * @author 
 */
import java.net.*;
import java.io.*;
import java.util.StringTokenizer;
import javax.swing.JFileChooser;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServerSocket server;
        Socket connection;
        BufferedInputStream bis = null;
        BufferedOutputStream bos;
        byte[] receivedData = null;
        int in;
        String file;
        try {
            server = new ServerSocket(1234);
            while (true) {
                connection = server.accept();
                System.out.println("Corriendo!!!!!!!");
                receivedData = new byte[1024];
                bis = new BufferedInputStream(connection.getInputStream());
                DataInputStream dis = new DataInputStream(connection.getInputStream());
                file = dis.readUTF();
                file = file.substring(file.indexOf('/') + 1, file.length());

                JFileChooser objeto = new JFileChooser();
                objeto.showSaveDialog(null);

                String cadena = null;
                StringTokenizer ruta = new StringTokenizer(objeto.getCurrentDirectory().getPath(), "\\");

                while (ruta.hasMoreTokens()) {
                    cadena += ruta.nextToken() + "/";
                }

                String newcadena = null;
                newcadena = cadena.replace("null", "");
                System.out.println(newcadena + file);
                bos = new BufferedOutputStream(new FileOutputStream(newcadena + file));
                while ((in = bis.read(receivedData)) != -1) {
                    bos.write(receivedData, 0, in);
                }
                bos.close();
                dis.close();
                System.out.println("hecho!!!!!!!!!");
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
