/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Erick Cruz
 */
public class ControladorActualizador {

//    public static String ruta = "";
    private static final int BUFFER = 1024;
    public boolean borrar = false;

    public void move(File origen, File destino) {
        try {
            copy(origen, destino);
            if (borrar) {
                boolean delete = origen.delete();
                if (delete) {
                    System.out.println("BORRADO!!");
                }
            }

        } catch (IOException ex) {
            Logger.getLogger(ControladorActualizador.class.getName()).log(Level.SEVERE, null, ex);
        }




    }

    public void copy(File origen, File destino) throws IOException {

        byte buf[] = new byte[BUFFER];
        int cant;
        FileInputStream in = new FileInputStream(origen);
        FileOutputStream out = new FileOutputStream(destino);

        while ((cant = in.read(buf, 0, BUFFER)) != -1) {
            out.write(buf, 0, cant);
        }
        out.close();
        in.close();
    }

    public void moverPrincipal(String verAct) throws IOException {
        borrar = true;
        String dirOrigen = System.getProperty("user.dir") + "\\src\\Actualizador\\Principal";
        String dirDestino = System.getProperty("user.dir") + "\\src\\Actualizador\\Temporal\\";
        File archivos[] = new File(dirOrigen).listFiles();

//        FileUtils util = new FileUtils();

//        File files[] = util.getFilesPattern(dirOrigen, ".doc");
        for (int i = 0; i < archivos.length; i++) {

            move(archivos[i], new File(dirDestino + archivos[i].getName()));
        }
        System.out.println("MOVIDO DE PRINCIPAL A TEMPORAL");
    }

    public void copiarAPrincipal(String ruta) {
        borrar = false;
        String dirOrigen = ruta;
        String dirDestino = System.getProperty("user.dir") + "\\src\\Actualizador\\Principal\\";
        File archivos[] = new File(dirOrigen).listFiles();

//        FileUtils util = new FileUtils();

//        File files[] = util.getFilesPattern(dirOrigen, ".doc");
//        System.out.println("RUTAAA " + ruta);
        for (int i = 0; i < archivos.length; i++) {

            move(archivos[i], new File(dirDestino + archivos[i].getName()));
        }
        System.out.println("COPIADO DE REPOSITORIO A PRINCIPAL");
    }

    public void vaciarTemporal() {
        String dirOrigen = System.getProperty("user.dir") + "\\src\\Actualizador\\Temporal";
        File archivos[] = new File(dirOrigen).listFiles();

//        FileUtils util = new FileUtils();

//        File files[] = util.getFilesPattern(dirOrigen, ".doc");
//        System.out.println("RUTAAA " + ruta);
        for (int i = 0; i < archivos.length; i++) {
            archivos[i].delete();
        }
        System.out.println("TEMPORAL VACIADO");

    }

    public void escribirVersionTXT(String version) {
        FileWriter fileW = null;
        byte buf[] = new byte[BUFFER];
        buf = version.getBytes();
        try {
            File archivo = new File(System.getProperty("user.dir") + "\\src\\version.txt");
//            fileW = new FileWriter(archivo);
//            //        FileReader fileR = new FileReader(archivo);
//            BufferedWriter bufferW = new BufferedWriter(fileW);
//            System.out.println(version);
//            bufferW.write(version, 0, version.length());
            FileOutputStream out = new FileOutputStream(archivo);
            out.write(buf, 0, version.length());
            out.close();
            System.out.println("VERSION ESCRITA EN TXT");
//            System.out.println(bufferR.readLine());
        } catch (IOException ex) {
            Logger.getLogger(ControladorActualizador.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
//            try {
//                fileW.close();
//            } catch (IOException ex) {
//                Logger.getLogger(ControladorActualizador.class.getName()).log(Level.SEVERE, null, ex);
//            }
        }
    }

    public void aplicarActualizacion(Version version) {
    }
}
