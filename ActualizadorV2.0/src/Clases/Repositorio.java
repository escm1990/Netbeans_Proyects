/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author luis
 */
public class Repositorio {

    private String nombre;
    private String direccion;
    private boolean activo;
    private boolean autenticacion;
    private String usuario;
    private String clave;
    private Version versiones[];
    private Version versionActual;
    private Version versionRecomendada;

    public Repositorio() {
        this.activo = true;
        this.autenticacion = true;
        this.clave = "";
        this.direccion = "";
        this.nombre = "";
        this.usuario = "";
        this.versionActual = null;
        this.versionRecomendada = null;
        this.versiones = null;
    }

    public Repositorio(String name, String direccion, boolean activo, boolean autenticacion, String usuario, String clave, Version versiones[], Version versionActual, Version versionRecomendada) {
        this.nombre = name;
        this.direccion = direccion;
        this.activo = activo;
        this.autenticacion = autenticacion;
        this.usuario = usuario;
        this.clave = clave;
        this.versiones = versiones;
        this.versionActual = versionActual;
        this.versionRecomendada = versionRecomendada;
    }

    public void obtenerVersiones(Version version[]){
        
    }
    
    public String leerVersionActual(){
        String ver="";
        return ver;
    }
    
    public boolean verificarRepositorio(){
        boolean ver=true;
        return ver;
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
     * @return the activo
     */
    public boolean isActivo() {
        return activo;
    }

    /**
     * @param activo the activo to set
     */
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    /**
     * @return the autenticacion
     */
    public boolean isAutenticacion() {
        return autenticacion;
    }

    /**
     * @param autenticacion the autenticacion to set
     */
    public void setAutenticacion(boolean autenticacion) {
        this.autenticacion = autenticacion;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * @param clave the clave to set
     */
    public void setClave(String clave) {
        this.clave = clave;
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
        this.versiones = versiones;
    }

    /**
     * @return the versionActual
     */
    public Version getVersionActual() {
        return versionActual;
    }

    /**
     * @param versionActual the versionActual to set
     */
    public void setVersionActual(Version versionActual) {
        this.versionActual = versionActual;
    }

    /**
     * @return the versionRecomendada
     */
    public Version getVersionRecomendada() {
        return versionRecomendada;
    }

    /**
     * @param versionRecomendada the versionRecomendada to set
     */
    public void setVersionRecomendada(Version versionRecomendada) {
        this.versionRecomendada = versionRecomendada;
    }
}
