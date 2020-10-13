/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author luis
 */
public class Version {

    private String nombre;
    private String url;
    private boolean esActual;

    public Version() {
        nombre = "";
        url = "";
        esActual = true;
    }

    public Version(String name, String url, boolean esActual) {
        this.nombre = name;
        this.url = url;
        this.esActual = esActual;
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
     * @return the esActual
     */
    public boolean isEsActual() {
        return esActual;
    }

    /**
     * @param esActual the esActual to set
     */
    public void setEsActual(boolean esActual) {
        this.esActual = esActual;
    }

    public String toString() {
        return this.getNombre();
    }
}
