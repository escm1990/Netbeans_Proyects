/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.Date;

/**
 *
 * @author Chavez Vigil
 */
public class Consulta {
 
    private Date fecha;
    private String diagnostico;
    private double racionAsignada;
    private int JVPM;
    private String carnet;
    private double peso;
    private double estatura;
    private String perimetroCefalico;
    private String  condicionSalud;
    
    public Consulta(){
        this.fecha = null;
        this.carnet = "";
        this.diagnostico = "";
        this.estatura = 0.0;
        this.JVPM = 0;
        this.perimetroCefalico = "";    
        this.peso = 0.0;
        this.racionAsignada = 0.0;
        this.condicionSalud = "";
    }
    
    public Consulta(Date fecha, String Carnet, double peso, double estatura, String perCefalico, int jpvm, String condicionSalud,double racionAsignada, String Diagnostico){
        this.fecha = fecha;
        this.carnet = Carnet;
        this.peso = peso;
        this.estatura = estatura;
        this.perimetroCefalico = perCefalico;
        this.JVPM = jpvm;
        this.condicionSalud = condicionSalud;
        this.racionAsignada = racionAsignada;
        this.diagnostico = Diagnostico;
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
     * @return the diagnostico
     */
    public String getDiagnostico() {
        return diagnostico;
    }

    /**
     * @param diagnostico the diagnostico to set
     */
    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    /**
     * @return the racionAsignada
     */
    public double getRacionAsignada() {
        return racionAsignada;
    }

    /**
     * @param racionAsignada the racionAsignada to set
     */
    public void setRacionAsignada(double racionAsignada) {
        this.racionAsignada = racionAsignada;
    }

    /**
     * @return the JVPM
     */
    public int getJVPM() {
        return JVPM;
    }

    /**
     * @param JVPM the JVPM to set
     */
    public void setJVPM(int JVPM) {
        this.JVPM = JVPM;
    }

    /**
     * @return the carnet
     */
    public String getCarnet() {
        return carnet;
    }

    /**
     * @param carnet the carnet to set
     */
    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    /**
     * @return the peso
     */
    public double getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
     * @return the estatura
     */
    public double getEstatura() {
        return estatura;
    }

    /**
     * @param estatura the estatura to set
     */
    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    /**
     * @return the perimetroCefalico
     */
    public String getPerimetroCefalico() {
        return perimetroCefalico;
    }

    /**
     * @param perimetroCefalico the perimetroCefalico to set
     */
    public void setPerimetroCefalico(String perimetroCefalico) {
        this.perimetroCefalico = perimetroCefalico;
    }

    /**
     * @return the condicionSalud
     */
    public String getCondicionSalud() {
        return condicionSalud;
    }

    /**
     * @param condicionSalud the condicionSalud to set
     */
    public void setCondicionSalud(String condicionSalud) {
        this.condicionSalud = condicionSalud;
    }
    
    
    
}
