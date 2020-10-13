/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author Usuario
 */
public class Encargado {

    private String nit;
    private String dui;
    private String nombre;
    private String apellido;
    private String parentesco;
    private String direccion;
    private String telefono;

    public Encargado() {
        nit = "";
        dui = "";
        nombre = "";
        apellido = "";
        parentesco = "";
        direccion = "";
        telefono = "";
    }

    public Encargado(String nit, String dui, String nombre, String apellido, String parentesco, String direccion, String tel) {
        this.nit = nit;
        this.dui = dui;
        this.nombre = nombre;
        this.apellido = apellido;
        this.parentesco = parentesco;
        this.direccion = direccion;
        this.telefono = tel;
    }

    /**
     * @return the nit
     */
    public String getNit() {
        return nit;
    }

    /**
     * @param nit the nit to set
     */
    public void setNit(String nit) {
        this.nit = nit;
    }

    /**
     * @return the dui
     */
    public String getDui() {
        return dui;
    }

    /**
     * @param dui the dui to set
     */
    public void setDui(String dui) {
        this.dui = dui;
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
     * @return the parentesco
     */
    public String getParentesco() {
        return parentesco;
    }

    /**
     * @param parentesco the parentesco to set
     */
    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
