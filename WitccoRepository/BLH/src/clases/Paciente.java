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
public class Paciente {

    private String carnet;
    private String nombre;
    private String apellido;
    private Date fechaNac;
    private String sexo;
    private String semGest;
    private String notas;
    private String tipo;

    public Paciente() {
        carnet = "";
        nombre = "";
        apellido = "";
        fechaNac = null;
        sexo = "";
        semGest = "";
        notas = "";
        tipo = "";
    }
    
    public Paciente(String carnet, String nombre, String apellido, Date fechaNac, String sexo, String semGest, String notas, String tipo){
        this.carnet=carnet;
        this.nombre=nombre;
        this.apellido=apellido;
        this.fechaNac=fechaNac;
        this.sexo = sexo;
        this.semGest=semGest;
        this.notas = notas;
        this.tipo = tipo;
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
     * @return the fechaNac
     */
    public Date getFechaNac() {
        return fechaNac;
    }

    /**
     * @param fechaNac the fechaNac to set
     */
    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
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
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the notas
     */
    public String getNotas() {
        return notas;
    }

    /**
     * @param notas the notas to set
     */
    public void setNotas(String notas) {
        this.notas = notas;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}
