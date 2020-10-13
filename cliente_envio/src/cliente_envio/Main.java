/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente_envio;

/**
 *
 * @author
 */
import java.net.*;
import java.io.*;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Main {


    /**
     * @param args the command line arguments
     * @throws UnknownHostException
     * @throws IOException
     */
    public static void main(String[] args) throws UnknownHostException, IOException {
        BufferedInputStream bis;
        BufferedOutputStream bos;
        int in;
        byte[] byteArray;
        int yes;
        int cont=1;

        Socket client = new Socket("localhost", 1234);
        
        do {
            final String filename;
            JFileChooser objeto = new JFileChooser();
            objeto.showOpenDialog(null);
            filename = objeto.getSelectedFile().getPath();
            System.out.println(filename);
            cont++;
            yes = JOptionPane.showConfirmDialog(null, "¿Desea enviar otro archivo?");
            try {
                final File localFile = new File(filename);
                bis = new BufferedInputStream(new FileInputStream(localFile));
                bos = new BufferedOutputStream(client.getOutputStream());
                DataOutputStream dos = new DataOutputStream(client.getOutputStream());
                dos.writeUTF(localFile.getName());
                byteArray = new byte[8192];
                while ((in = bis.read(byteArray)) != -1) {
                    bos.write(byteArray, 0, in);
                }
                bis.close();
                bos.close();


            } catch (Exception e) {
                System.err.println(e);
            }

        } while (yes==cont);
    }
}
