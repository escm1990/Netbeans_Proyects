/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author luis
 */
public class CarpetaTemporal {
    private String carpetaTemporal;
    private String carpetaRespaldo;
    
    public CarpetaTemporal(){
        carpetaTemporal = "";
        carpetaRespaldo = "";
     }
    public CarpetaTemporal(String carTemporal, String carRespaldo){
        this.carpetaTemporal = carTemporal;
        this.carpetaRespaldo = carRespaldo;
    }

    /**
     * @return the carpetaTemporal
     */
    public String getCarpetaTemporal() {
        return carpetaTemporal;
    }

    /**
     * @param carpetaTemporal the carpetaTemporal to set
     */
    public void setCarpetaTemporal(String carpetaTemporal) {
        this.carpetaTemporal = carpetaTemporal;
    }

    /**
     * @return the carpetaRespaldo
     */
    public String getCarpetaRespaldo() {
        return carpetaRespaldo;
    }

    /**
     * @param carpetaRespaldo the carpetaRespaldo to set
     */
    public void setCarpetaRespaldo(String carpetaRespaldo) {
        this.carpetaRespaldo = carpetaRespaldo;
    }
    
    
}
