/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.*;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
//import java.util.Map.Entry;

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
        File archivo = new File(System.getProperty("user.dir") + "\\src\\version.txt");
        FileReader fileR = new FileReader(archivo);
        BufferedReader bufferR = new BufferedReader(fileR);
        versTXT = bufferR.readLine();
        System.out.println(bufferR.readLine());
        return versTXT;

    }

    /*CARGAR VERSIONES*/
    public void cargarVersiones(String ruta, JTable tablaV) {
        //AUN FALTA RELACIONARLA CON EL REPOSITORIO VIRTUAL
        DefaultTableModel modelo = new DefaultTableModel() {

                @Override
                public boolean isCellEditable(int row, int column) {
                    //Only the third column
                    return false;
                }
            };
        
        modelo.addColumn("Versiones");
        File archivos[] = new File(ruta).listFiles();
        ArrayList<String> vers = new ArrayList<String>(archivos.length);
        String version = "";
        for (int i = 0; i < archivos.length; i++) {
            if (archivos[i].isDirectory()) {
                version = archivos[i].toString();
                version = version.substring(version.length() - 3, version.length());
                vers.add(version);
                System.out.println(version);
            }
        }
        int cont = 0;
        for (int i = vers.size(); i > 0; i--) {
            modelo.addRow(new Object[]{});
            modelo.setValueAt(vers.get(i - 1), cont, 0);
            cont++;
        }
        
        tablaV.setModel(modelo);
        TableColumn columnita = tablaV.getColumn("Versiones");
        columnita.setPreferredWidth(295);
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
