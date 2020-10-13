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

    private String Nombre;
    private String URL;
    private Date Fecha;
    private int TotalArchivos;
    private Double Tamano;

//    public Version() {
//        
//    }

    public Version(String name, String url, Date fecha, int totArchivos, Double tam) {
        Nombre = name;
        URL = url;
        Fecha = fecha;
        TotalArchivos = totArchivos;
        Tamano = tam;
    }

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return the URL
     */
    public String getURL() {
        return URL;
    }

    /**
     * @param URL the URL to set
     */
    public void setURL(String URL) {
        this.URL = URL;
    }

    /**
     * @return the Fecha
     */
    public Date getFecha() {
        return Fecha;
    }

    /**
     * @param Fecha the Fecha to set
     */
    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    /**
     * @return the TotalArchivos
     */
    public int getTotalArchivos() {
        return TotalArchivos;
    }

    /**
     * @param TotalArchivos the TotalArchivos to set
     */
    public void setTotalArchivos(int TotalArchivos) {
        this.TotalArchivos = TotalArchivos;
    }

    /**
     * @return the Tamano
     */
    public Double getTamano() {
        return Tamano;
    }

    /**
     * @param Tamano the Tamano to set
     */
    public void setTamano(Double Tamano) {
        this.Tamano = Tamano;
    }

}
