/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author Usuario
 */
public class Control {
    
    private String fechaHora;
    private Double estatura;
    private Double peso;
    private Double perCefalico;
    
    public Control(){
        fechaHora = "";
        estatura=0.0;
        peso=0.0;
        perCefalico=0.0;
    }
    
    public Control(String fechHora, Double estatura, Double peso, Double perCefalico){
        this.fechaHora=fechHora;
        this.estatura=estatura;
        this.peso=peso;
        this.perCefalico=perCefalico;
    }

    /**
     * @return the fechaHora
     */
    public String getFechaHora() {
        return fechaHora;
    }

    /**
     * @param fechaHora the fechaHora to set
     */
    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    /**
     * @return the estatura
     */
    public Double getEstatura() {
        return estatura;
    }

    /**
     * @param estatura the estatura to set
     */
    public void setEstatura(Double estatura) {
        this.estatura = estatura;
    }

    /**
     * @return the peso
     */
    public Double getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(Double peso) {
        this.peso = peso;
    }

    /**
     * @return the perCefalico
     */
    public Double getPerCefalico() {
        return perCefalico;
    }

    /**
     * @param perCefalico the perCefalico to set
     */
    public void setPerCefalico(Double perCefalico) {
        this.perCefalico = perCefalico;
    }
    
    
}
