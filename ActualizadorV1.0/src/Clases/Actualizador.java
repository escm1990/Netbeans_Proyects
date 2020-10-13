/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import com.dropbox.client2.exception.DropboxException;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
//import java.util.Map.Entry;
import com.dropbox.client2.*;
import com.dropbox.client2.DropboxAPI.DropboxInputStream;
import com.dropbox.client2.DropboxAPI.Entry;
import com.dropbox.client2.session.*;
import com.dropbox.client2.session.Session.AccessType;
import com.dropbox.*;
import java.util.List;
import org.apache.commons.logging.Log;

/**
 *
 * @author luis
 */
public class Actualizador {

    private String versionActual;
    private Version versiones[];
    private String repositorio;
    private String carpetaTemporal;
    public static String versTXT = "";
    private static final String APP_KEY = "3i68ponran99de8";
    private static final String APP_SECRET = "d0uuxr4cpbb5mho";
    private static final AccessType ACCESS_TYPE = AccessType.DROPBOX;
    private static DropboxAPI<WebAuthSession> mDBApi;
    public static String key_token;
    public static String secret_token;
    DropboxAuth DropboxAuth = new DropboxAuth();

    public Actualizador() {
        versionActual = "1.0";
//        versiones[0] = null;
        repositorio = "";
        carpetaTemporal = "";
    }

    public Actualizador(String versionActual, Version versiones[], String repositorio, String carpetaTemporal) {
        this.versionActual = versionActual;
        this.versiones = versiones;
        this.repositorio = repositorio;
        this.carpetaTemporal = carpetaTemporal;
    }

    /*LEER VERSION ACTUAL*/
    public String leerVersion() throws FileNotFoundException, IOException {
        File archivo = new File("C:\\Users\\Usuario\\Dropbox\\DisenoSistema\\Actualizador1.0\\src\\version.txt");
        FileReader fileR = new FileReader(archivo);
        BufferedReader bufferR = new BufferedReader(fileR);
        versTXT = bufferR.readLine();
        System.out.println(bufferR.readLine());
        return versTXT;

    }

    /*CARGAR VERSIONES*/
    public void cargarVersiones(String ruta, JTable tablaV) {
        try {
            DefaultTableModel modelo = new DefaultTableModel() {

                @Override
                public boolean isCellEditable(int row, int column) {
                    //Only the third column
                    return false;
                }
            };
            AppKeyPair appKeys = new AppKeyPair(APP_KEY, APP_SECRET);
            WebAuthSession session = new WebAuthSession(appKeys, ACCESS_TYPE);
            AccessTokenPair accessToken = new AccessTokenPair("zhif5vmnxqheta4", "3en1regaaam49cz");
            session.setAccessTokenPair(accessToken);

            mDBApi = new DropboxAPI<WebAuthSession>(session);// App key/secret, Access key/secret가 필요한 이유
            DropboxAPI.Account account = mDBApi.accountInfo();
            System.out.println("User Name: " + account.displayName);// 계정 사용자 이름


            Entry dropboxDir = mDBApi.metadata("/Reppo/", 0, null, true, null);
            System.out.println(dropboxDir.size);

            if (dropboxDir.isDir) {

                modelo.addColumn("Versiones");
                ArrayList<Entry> contents = (ArrayList<Entry>) dropboxDir.contents;
                System.out.println("entroo");
                if (contents != null) {
                    ArrayList<String> vers = new ArrayList<String>(contents.size());
                    String version = "";
                    for (int i = 0; i < contents.size(); i++) {
                        Entry e = contents.get(i);
                        String a = e.fileName();
                        version = a;
                        vers.add(version);
//                        System.out.println(version);
                    }
                    int cont = 0;
                    for (int i = vers.size(); i > 0; i--) {
                        modelo.addRow(new Object[]{});
                        modelo.setValueAt(vers.get(i - 1), cont, 0);
                        cont++;
                    }
                }
                tablaV.setModel(modelo);
                TableColumn columnita = tablaV.getColumn("Versiones");
                columnita.setPreferredWidth(295);
            } else {
                System.out.println("parent " + dropboxDir.parentPath());
                System.out.println("parent " + dropboxDir.path);
                System.out.println("parent " + dropboxDir.mimeType);
            }
        } catch (Exception ex) {
            Logger.getLogger(Actualizador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @return the versionActual
     */
    public String getVersionActual() {
        return versionActual;
    }

    /**
     * @param versionActual the versionActual to set
     */
    public void setVersionActual(String versionActual) {
        this.versionActual = versionActual;
    }

    /**
     * @return the versiones
     */
    public Version[] getVersiones() {
        return versiones;
    }

    /**
     * @param versiones the versiones to set
     */
    public void setVersiones(Version[] versiones) {
        this.setVersiones(versiones);
    }

    /**
     * @return the repositorio
     */
    public String getRepositorio() {
        return repositorio;
    }

    /**
     * @param repositorio the repositorio to set
     */
    public void setRepositorio(String repositorio) {
        this.repositorio = repositorio;
    }

    /**
     * @param versiones the versiones to set
     */
    /**
     * @return the carpetaTemporal
     */
    public String getCarpetaTemporal() {
        return carpetaTemporal;
    }

    /**
     * @param carpetaTemporal the carpetaTemporal to set
     */
    public void setCarpetaTemporal(String carpetaTemporal) {
        this.carpetaTemporal = carpetaTemporal;
    }
}
