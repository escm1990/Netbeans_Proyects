/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author USUARIO
 */
public class Motorista {

    private String nombre;
    private String apellido;
    private String dui;

    public Motorista() {
        nombre = "";
        apellido = "";
        dui = "";
    }

    public Motorista(String nom, String ape, String d) {
        this.nombre = nom;
        this.apellido = ape;
        this.dui = d;
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
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the gastos
     */
    public String getDui() {
        return dui;
    }

    /**
     * @param gastos the gastos to set
     */
    public void setDui(String dui) {
        this.dui = dui;
    }
}
