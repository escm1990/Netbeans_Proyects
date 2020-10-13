/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.Date;

/**
 *
 * @author luis
 */
public class Version {
 
    private String nombre;
    private String url;
    private Date fecha;
    private int totalArchivos;
    private double tamaño;
    
    
    public Version(){
        nombre = "";
        url = "";
        fecha = null;
        totalArchivos = 0;
        tamaño = 0.0;
                 
    }
    public Version(String name, String url, Date fecha, int totalArchivos, double tamaño){
        this.nombre = name;
        this.url = url;
        this.fecha = fecha;
        this.totalArchivos = totalArchivos;
        this.tamaño = tamaño;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    
    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the totalArchivos
     */
    public int getTotalArchivos() {
        return totalArchivos;
    }

    /**
     * @param totalArchivos the totalArchivos to set
     */
    public void setTotalArchivos(int totalArchivos) {
        this.totalArchivos = totalArchivos;
    }

    /**
     * @return the tamaño
     */
    public double getTamaño() {
        return tamaño;
    }

    /**
     * @param tamaño the tamaño to set
     */
    public void setTamaño(double tamaño) {
        this.tamaño = tamaño;
    }
        
}
