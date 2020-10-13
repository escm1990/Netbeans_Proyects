/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import com.dropbox.client2.DropboxAPI;
import com.dropbox.client2.DropboxAPI.DropboxFileInfo;
import com.dropbox.client2.DropboxAPI.DropboxInputStream;
import com.dropbox.client2.exception.DropboxException;
import com.dropbox.client2.session.AccessTokenPair;
import com.dropbox.client2.session.AppKeyPair;
import com.dropbox.client2.session.Session.AccessType;
import com.dropbox.client2.session.WebAuthSession;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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

    private static final int BUFFER = 1024;
    public boolean borrar = false;
    private static final String APP_KEY = "3i68ponran99de8";
    private static final String APP_SECRET = "d0uuxr4cpbb5mho";
    private static final AccessType ACCESS_TYPE = AccessType.APP_FOLDER;
    private static DropboxAPI<WebAuthSession> mDBApi;
    AppKeyPair appKeys = new AppKeyPair(APP_KEY, APP_SECRET);
    WebAuthSession session = new WebAuthSession(appKeys, ACCESS_TYPE);
    AccessTokenPair accessToken = new AccessTokenPair("zhif5vmnxqheta4", "3en1regaaam49cz");

//    public void restaurarOldPrincipal() {
//    }
//
//    public void escribirVersionActual(Version version) {
//    }
//
//    public Boolean validarActuaizacion() {
//    }
//
//    public void copiarActualizacion() {
//    }
//
//    public void aplicarActualizacion(Repositorio repo, Version version) {
//    }
//
//    public void vaciarOldPrincipal(CarpetasTemporales) {
//    }
//
//    public Boolean validarRespaldo(CarpetasTemporales) {
//    }
    public void validar() {
        try {
            session.setAccessTokenPair(accessToken);
            mDBApi = new DropboxAPI<WebAuthSession>(session);// App key/secret, Access key/secret가 필요한 이유
            DropboxAPI.Account account = mDBApi.accountInfo();
            System.out.println("User Name: " + account.displayName);
        } catch (DropboxException ex) {
            Logger.getLogger(ControladorActualizador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void descargar() {
    }

    public void DescargarEnTemporal(String ver, CarpetasTemporales carpeta) {
        validar();
        borrar = false;
//        String dirOrigen = ruta;
        String dirDestino = carpeta.getCarpetaTemporal() + "\\";
        FileOutputStream outputStream = null;
        try {
            String origen = "/Reppo/"+ver+"/";
            File file[] = new File(dirDestino).listFiles();
            DropboxFileInfo info = mDBApi.getFile(origen, null, outputStream, null);
        } catch (Exception e) {
            System.out.println("Something went wrong: " + e);
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                }
            }
        }
//        DropboxInputStream din = mDBApi.getFileStream("/Reppo/");
//
//        br = new BufferedInputStream(din);
//        bw = new BufferedOutputStream(new FileOutputStream(localFile));
//
//        byte[] buf = new byte[1024];
//        int read = 0;
//        while ((read = br.read(buf, 0, buf.length)) != -1) {
//            bw.write(buf, 0, read);
//        }
//        br.close();
//        bw.close();
//        File archivos[] = new File(dirOrigen).listFiles();
//
//        for (int i = 0; i < archivos.length; i++) {
//            try {
//                CopiarDirectorio(archivos[i], new File(dirDestino + archivos[i].getName()));
//                //            move(archivos[i], new File(dirDestino + archivos[i].getName()));
//            } catch (Exception ex) {
//                Logger.getLogger(ControladorActualizador.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
        System.out.println("COPIADO DE REPOSITORIO A PRINCIPAL");
    }

//    public Boolean validarDescarga(Repositorios repo, Versiones version) {
//    }
    public void Respaldar() {
    }

    public void modificarRepositorio(Repositorio repo) {
    }

    public void agregarRepositorio(Repositorio repo) {
    }

    public void CopiarDirectorio(File dirOrigen, File dirDestino) throws Exception {
        try {
            if (dirOrigen.isDirectory()) {
                if (!dirDestino.exists()) {
                    dirDestino.mkdir();
                }

                String[] hijos = dirOrigen.list();
                for (int i = 0; i < hijos.length; i++) {
                    CopiarDirectorio(new File(dirOrigen, hijos[i]),
                            new File(dirDestino, hijos[i]));
                    if (borrar) {
                        boolean delete = dirOrigen.delete();
                        if (delete) {
                            System.out.println("BORRADO!!");
                        }
                    }
                } // end for
            } else {
                Copiar(dirOrigen, dirDestino);
                if (borrar) {
                    boolean delete = dirOrigen.delete();
                    if (delete) {
                        System.out.println("BORRADO!!");
                    }
                }
            } // end if
        } catch (Exception e) {
            throw e;
        } // end try
    } // end CopiarDirectorio

    public void Copiar(File dirOrigen, File dirDestino) throws Exception {

        InputStream in = new FileInputStream(dirOrigen);
        OutputStream out = new FileOutputStream(dirDestino);

        byte[] buffer = new byte[1024];
        int len;

        try {
            // recorrer el array de bytes y recomponerlo
            while ((len = in.read(buffer)) > 0) {
                out.write(buffer, 0, len);
            } // end while
            out.flush();
        } catch (Exception e) {
            throw e;
        } finally {
            in.close();
            out.close();
        } // end ty
    } // end Copiar

    public void Copiar(String dirOrigen, String dirDestino) throws Exception {
        InputStream in = new FileInputStream(dirOrigen);
        OutputStream out = new FileOutputStream(dirDestino);

        byte[] buffer = new byte[1024];
        int len;

        try {
            // recorrer el array de bytes y recomponerlo
            while ((len = in.read(buffer)) > 0) {
                out.write(buffer, 0, len);
            } // end while
            out.flush();
        } catch (Exception e) {
            throw e;
        } finally {
            in.close();
            out.close();
        } // end ty
    } // end Copiar

//    public void move(File origen, File destino) {
//        try {
//            copy(origen, destino);
//            if (borrar) {
//                boolean delete = origen.delete();
//                if (delete) {
//                    System.out.println("BORRADO!!");
//                }
//            }
//        } catch (IOException ex) {
//            Logger.getLogger(ControladorActualizador.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    public void copy(File origen, File destino) throws IOException {
//        byte buf[] = new byte[BUFFER];
//        int cant;
//        FileInputStream in = new FileInputStream(origen);
//        FileOutputStream out = new FileOutputStream(destino);
//
//        while ((cant = in.read(buf, 0, BUFFER)) != -1) {
//            out.write(buf, 0, cant);
//        }
//        out.close();
//        in.close();
//    }
    public void moverPrincipal(String verAct, CarpetasTemporales carpetas) throws IOException {

        borrar = true;
        String dirOrigen = carpetas.getPrincipal();
        String dirDestino = carpetas.getCarpetaTemporal() + "\\";
        File archivos[] = new File(dirOrigen).listFiles();

        for (int i = 0; i < archivos.length; i++) {
            try {
                CopiarDirectorio(archivos[i], new File(dirDestino + archivos[i].getName()));
                //            move(archivos[i], new File(dirDestino + archivos[i].getName()));
            } catch (Exception ex) {
                Logger.getLogger(ControladorActualizador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("MOVIDO DE PRINCIPAL A TEMPORAL");
    }

    public void vaciarTemporal(CarpetasTemporales carpetas) {

        String dirOrigen = carpetas.getCarpetaTemporal();
        File archivos[] = new File(dirOrigen).listFiles();

        for (int i = 0; i < archivos.length; i++) {
            try {
                borrarDirectorio(archivos[i]);
            } catch (Exception ex) {
                Logger.getLogger(ControladorActualizador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("TEMPORAL VACIADO");

    }

    public void borrarDirectorio(File dirOrigen) throws Exception {
        try {
            if (dirOrigen.isDirectory()) {
//                if (!dirDestino.exists()) {
//                    dirDestino.mkdir();
//                }

                String[] hijos = dirOrigen.list();
                for (int i = 0; i < hijos.length; i++) {
                    borrarDirectorio(new File(dirOrigen, hijos[i]));

                    boolean delete = dirOrigen.delete();
                    if (delete) {
                        System.out.println("BORRADO1!!");
                    }

                } // end for
            } else {
//                Copiar(dirOrigen, dirDestino);

                boolean delete = dirOrigen.delete();
                if (delete) {
                    System.out.println("BORRADO2!!");
                }

            } // end if
        } catch (Exception e) {
            throw e;
        } // end try
    }

    public void escribirVersionTXT(String version) {

        byte buf[] = new byte[BUFFER];
        buf = version.getBytes();
        try {
            File archivo = new File("C:\\Users\\Usuario\\Dropbox\\DisenoSistema\\Actualizador1.0\\src\\version.txt");

            FileOutputStream out = new FileOutputStream(archivo);
            out.write(buf, 0, version.length());
            out.close();
            System.out.println("VERSION ESCRITA EN TXT");

        } catch (IOException ex) {
            Logger.getLogger(ControladorActualizador.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        }
    }

    public void aplicarActualizacion(Version version) {
    }
}
