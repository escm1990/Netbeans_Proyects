/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import com.dropbox.client2.DropboxAPI;
import com.dropbox.client2.DropboxAPI.DropboxInputStream;
import com.dropbox.client2.DropboxAPI.Entry;
import com.dropbox.client2.exception.DropboxException;
import com.dropbox.client2.session.AccessTokenPair;
import com.dropbox.client2.session.AppKeyPair;
import com.dropbox.client2.session.Session.AccessType;
import com.dropbox.client2.session.WebAuthSession;
import java.io.*;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Erick Cruz
 */
public class AccesoDropbox {

    private static final String APP_KEY = "aoit0vyh6as7waq";
    private static final String APP_SECRET = "q7eqdi67v2sbr2p";
    private static final AccessType ACCESS_TYPE = AccessType.APP_FOLDER;
    private static DropboxAPI<WebAuthSession> mDBApi;

    public AccesoDropbox() throws DropboxException {
        try {
            AppKeyPair appKeys = new AppKeyPair(APP_KEY, APP_SECRET);
            WebAuthSession session = new WebAuthSession(appKeys, ACCESS_TYPE);

            AccessTokenPair accessToken = new AccessTokenPair("xcbsracka7sdm6v", "hgymxz2eccck2oj");
            session.setAccessTokenPair(accessToken);

            mDBApi = new DropboxAPI<WebAuthSession>(session);

            DropboxAPI.Account account = mDBApi.accountInfo();
            System.out.println("User Name: " + account.displayName);
        } catch (Exception e) {
        }


    }

    public void listarVersiones(JTable versiones) throws DropboxException {
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Versiones");
            int cont = 0;
            String dir = "";
            Entry entries = mDBApi.metadata("/", 100, null, true, null);
            ArrayList<String> vers = new ArrayList<String>(entries.contents.size());
            for (Entry e : entries.contents) {
                if (!e.isDeleted) {
                    if (e.isDir) {
                        dir = e.path;
                        dir = dir.substring(1, dir.length());
                        vers.add(dir);
                    }
                }
            }
            cont = 0;
            for (int i = vers.size(); i > 0; i--) {
                modelo.addRow(new Object[]{});
                modelo.setValueAt(vers.get(i - 1), cont, 0);
                cont++;
            }

            versiones.setModel(modelo);
            TableColumn columnita = versiones.getColumn("Versiones");
            columnita.setPreferredWidth(295);
        } catch (Exception e) {
        }

    }

    public void recorrer(Version version) throws DropboxException {
        try {
//            DefaultTableModel modelo = new DefaultTableModel();
//            modelo.addColumn("Versiones");
//            int cont = 0;
//            String dir = "";
            Entry entries = mDBApi.metadata("/" + version.getNombre(), 100, null, true, null);
            String valor = "";
//            ArrayList<String> vers = new ArrayList<String>(entries.contents.size());
            for (Entry e : entries.contents) {
                if (!e.isDeleted) {
                    
                    valor = e.path;
                    valor = valor.substring(5, valor.length());
                    if (e.isDir) {
                        System.out.println("Directorio>>>" + valor + "\n");
                       
                    } else {
                        System.out.println("Archivo>>>" + valor + "\n");

                    }
                }
            }
//            cont = 0;
//            for (int i = vers.size(); i > 0; i--) {
//                modelo.addRow(new Object[]{});
//                modelo.setValueAt(vers.get(i - 1), cont, 0);
//                cont++;
//            }

//            versiones.setModel(modelo);
//            TableColumn columnita = versiones.getColumn("Versiones");
//            columnita.setPreferredWidth(295);
        } catch (Exception e) {
        }

    }

    public void descargarVersion(Version version) throws DropboxException, IOException {
        BufferedInputStream br = null;
        BufferedOutputStream bw = null;
        
        File localFile = new File("C:\\Users\\Erick Cruz\\Desktop\\"+version.getNombre());
        if (!localFile.exists()) {
            localFile.createNewFile(); //otherwise dropbox client will fail silently
        }

        System.out.println("/"+version.getNombre());
        //DropboxInputStream din = mDBApi.getFileStream("dropbox", "/testing.txt");     //error
        DropboxInputStream din = mDBApi.getFileStream("/"+version.getNombre(), null);		// working
        
        br = new BufferedInputStream(din);
        bw = new BufferedOutputStream(new FileOutputStream(localFile));

        byte[] buf = new byte[1024];
        int read = 0;
        while ((read = br.read(buf, 0, buf.length)) != -1) {
            bw.write(buf, 0, read);
        }
        br.close();
        bw.close();
        System.out.println("DESCARGADO");

    }
}
