/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.Date;

/**
 *
 * @author Usuario
 */
public class Donante {

    private String documento;
    private String nombre;
    private String apellido;
    private Date fechaNac;
    private String direccion;
    private String peso;
    private String estatura;
    private String tel;
    private String semGest;
    private Date fechaParto;
    private String VDRL;
    private String HbsAg;
    private String HIV;
    private String transSangui;
    private String tabaquismo;
    private String etilismo;
    private String aptaDonar;
    private Date fechaObtencion;

    public Donante() {
        documento = "";
        nombre = "";
        apellido = "";
        fechaNac = null;
        direccion = "";
        peso = "";
        estatura = "";
        tel = "";
        semGest = "";
        fechaParto = null;
        VDRL = "";
        HbsAg = "";
        HIV = "";
        transSangui = "";
        tabaquismo = "";
        etilismo = "";
        aptaDonar = "";
        fechaObtencion = null;
    }

    public Donante(String documento, String nombre, String apellido, Date fechaNac, String direccion, String peso, String estatura, String tel, String semGest, Date fechaParto, String vdrl, String hbsag, String hiv, String transSan, String tabaq, String etil, String apta, Date fechaObt) {
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
        this.direccion = direccion;
        this.peso = peso;
        this.estatura = estatura;
        this.tel = tel;
        this.semGest = semGest;
        this.fechaParto = fechaParto;
        this.VDRL = vdrl;
        this.HbsAg = hbsag;
        this.HIV = hiv;
        this.transSangui = transSan;
        this.tabaquismo = tabaq;
        this.etilismo = etil;
        this.aptaDonar = apta;
        this.fechaObtencion = fechaObt;
    }

    /**
     * @return the documento
     */
    public String getDocumento() {
        return documento;
    }

    /**
     * @param documento the documento to set
     */
    public void setDocumento(String documento) {
        this.documento = documento;
    }

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.nombre = Nombre;
    }

    /**
     * @return the FechaNac
     */
    public Date getFechaNac() {
        return fechaNac;
    }

    /**
     * @param FechaNac the FechaNac to set
     */
    public void setFechaNac(Date FechaNac) {
        this.fechaNac = FechaNac;
    }

    /**
     * @return the Direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param Direccion the Direccion to set
     */
    public void setDireccion(String Direccion) {
        this.direccion = Direccion;
    }

    /**
     * @return the Peso
     */
    public String getPeso() {
        return peso;
    }

    /**
     * @param Peso the Peso to set
     */
    public void setPeso(String Peso) {
        this.peso = Peso;
    }

    /**
     * @return the Estatura
     */
    public String getEstatura() {
        return estatura;
    }

    /**
     * @param Estatura the Estatura to set
     */
    public void setEstatura(String Estatura) {
        this.estatura = Estatura;
    }

    /**
     * @return the Tel
     */
    public String getTel() {
        return tel;
    }

    /**
     * @param Tel the Tel to set
     */
    public void setTel(String Tel) {
        this.tel = Tel;
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
     * @return the semGest
     */
    public String getSemGest() {
        return semGest;
    }

    /**
     * @param semGest the semGest to set
     */
    public void setSemGest(String semGest) {
        this.semGest = semGest;
    }

    /**
     * @return the fechaParto
     */
    public Date getFechaParto() {
        return fechaParto;
    }

    /**
     * @param fechaParto the fechaParto to set
     */
    public void setFechaParto(Date fechaParto) {
        this.fechaParto = fechaParto;
    }

    /**
     * @return the VDRL
     */
    public String getVDRL() {
        return VDRL;
    }

    /**
     * @param VDRL the VDRL to set
     */
    public void setVDRL(String VDRL) {
        this.VDRL = VDRL;
    }

    /**
     * @return the HbsAg
     */
    public String getHbsAg() {
        return HbsAg;
    }

    /**
     * @param HbsAg the HbsAg to set
     */
    public void setHbsAg(String HbsAg) {
        this.HbsAg = HbsAg;
    }

    /**
     * @return the HIV
     */
    public String getHIV() {
        return HIV;
    }

    /**
     * @param HIV the HIV to set
     */
    public void setHIV(String HIV) {
        this.HIV = HIV;
    }

    /**
     * @return the transSangui
     */
    public String getTransSangui() {
        return transSangui;
    }

    /**
     * @param transSangui the transSangui to set
     */
    public void setTransSangui(String transSangui) {
        this.transSangui = transSangui;
    }

    /**
     * @return the tabaquismo
     */
    public String getTabaquismo() {
        return tabaquismo;
    }

    /**
     * @param tabaquismo the tabaquismo to set
     */
    public void setTabaquismo(String tabaquismo) {
        this.tabaquismo = tabaquismo;
    }

    /**
     * @return the etilismo
     */
    public String getEtilismo() {
        return etilismo;
    }

    /**
     * @param etilismo the etilismo to set
     */
    public void setEtilismo(String etilismo) {
        this.etilismo = etilismo;
    }

    /**
     * @return the aptaDonar
     */
    public String getAptaDonar() {
        return aptaDonar;
    }

    /**
     * @param aptaDonar the aptaDonar to set
     */
    public void setAptaDonar(String aptaDonar) {
        this.aptaDonar = aptaDonar;
    }

    /**
     * @return the fechaObtencion
     */
    public Date getFechaObtencion() {
        return fechaObtencion;
    }

    /**
     * @param fechaObtencion the fechaObtencion to set
     */
    public void setFechaObtencion(Date fechaObtencion) {
        this.fechaObtencion = fechaObtencion;
    }
}
