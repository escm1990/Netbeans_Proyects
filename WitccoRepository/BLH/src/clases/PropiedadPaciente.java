/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.Date;

/**
 *
 * @author Chavez Vigil
 */
public class PropiedadPaciente {

    private Date FechaIncorporacion;
    private double pesoNacer;
    private double pesoIncorporarse;
    private double estaturaNacer;
    private double estaturaIncorporarse;
    private double pCefalicoNacer;
    private double pCefalicoIncorporarse;
    
    public PropiedadPaciente(){
        this.FechaIncorporacion = null;
        this.pesoNacer = 0.0;
        this.pesoIncorporarse = 0.0;
        this.estaturaNacer = 0.0;
        this.estaturaIncorporarse = 0.0;
        this.pCefalicoNacer = 0.0;
        this.pCefalicoIncorporarse = 0.0;
    }
    public PropiedadPaciente(Date fecha, double pesoNac, double pesoInc, double estNac, double estInc, double pCefNac, double pCefInc){
        this.FechaIncorporacion = fecha;
        this.pesoNacer = pesoNac;
        this.pesoIncorporarse = pesoInc;
        this.estaturaNacer = estNac;
        this.estaturaIncorporarse = estInc;
        this.pCefalicoNacer = pCefNac;
        this.pCefalicoIncorporarse = pCefInc;
    }

    /**
     * @return the FechaIncorporacion
     */
    public Date getFechaIncorporacion() {
        return FechaIncorporacion;
    }

    /**
     * @param FechaIncorporacion the FechaIncorporacion to set
     */
    public void setFechaIncorporacion(Date FechaIncorporacion) {
        this.FechaIncorporacion = FechaIncorporacion;
    }

    /**
     * @return the pesoNacer
     */
    public double getPesoNacer() {
        return pesoNacer;
    }

    /**
     * @param pesoNacer the pesoNacer to set
     */
    public void setPesoNacer(double pesoNacer) {
        this.pesoNacer = pesoNacer;
    }

    /**
     * @return the pesoIncorporarse
     */
    public double getPesoIncorporarse() {
        return pesoIncorporarse;
    }

    /**
     * @param pesoIncorporarse the pesoIncorporarse to set
     */
    public void setPesoIncorporarse(double pesoIncorporarse) {
        this.pesoIncorporarse = pesoIncorporarse;
    }

    /**
     * @return the estaturaNacer
     */
    public double getEstaturaNacer() {
        return estaturaNacer;
    }

    /**
     * @param estaturaNacer the estaturaNacer to set
     */
    public void setEstaturaNacer(double estaturaNacer) {
        this.estaturaNacer = estaturaNacer;
    }

    /**
     * @return the estaturaIncorporarse
     */
    public double getEstaturaIncorporarse() {
        return estaturaIncorporarse;
    }

    /**
     * @param estaturaIncorporarse the estaturaIncorporarse to set
     */
    public void setEstaturaIncorporarse(double estaturaIncorporarse) {
        this.estaturaIncorporarse = estaturaIncorporarse;
    }

    /**
     * @return the pCefalicoNacer
     */
    public double getpCefalicoNacer() {
        return pCefalicoNacer;
    }

    /**
     * @param pCefalicoNacer the pCefalicoNacer to set
     */
    public void setpCefalicoNacer(double pCefalicoNacer) {
        this.pCefalicoNacer = pCefalicoNacer;
    }

    /**
     * @return the pCefalicoIncorporarse
     */
    public double getpCefalicoIncorporarse() {
        return pCefalicoIncorporarse;
    }

    /**
     * @param pCefalicoIncorporarse the pCefalicoIncorporarse to set
     */
    public void setpCefalicoIncorporarse(double pCefalicoIncorporarse) {
        this.pCefalicoIncorporarse = pCefalicoIncorporarse;
    }
    
}
