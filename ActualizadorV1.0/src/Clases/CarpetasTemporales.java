/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Erick Cruz
 */
public class CarpetasTemporales {

    private String CarpetaTemporal;
    private String CarpetaRespaldo;
    private String Principal;

    public CarpetasTemporales() {
        Principal = "C:\\Users\\Erick Cruz\\Dropbox\\DisenoSistema\\ejemploFuncional\\dist";
        CarpetaTemporal = "C:\\Users\\Erick Cruz\\Dropbox\\DisenoSistema\\ejemploFuncional\\dist\\Actualizador\\Temporal";
        CarpetaRespaldo = "C:\\Users\\Erick Cruz\\Dropbox\\DisenoSistema\\ejemploFuncional\\dist\\Actualizador\\Respaldo";
    }

    public CarpetasTemporales(String prin, String temporal, String respaldo) {
        Principal = prin;
        CarpetaTemporal = temporal;
        CarpetaRespaldo = respaldo;
    }

    /**
     * @return the CarpetaTemporal
     */
    public String getCarpetaTemporal() {
        return CarpetaTemporal;
    }

    /**
     * @param CarpetaTemporal the CarpetaTemporal to set
     */
    public void setCarpetaTemporal(String CarpetaTemporal) {
        this.CarpetaTemporal = CarpetaTemporal;
    }

    /**
     * @return the CarpetaRespaldo
     */
    public String getCarpetaRespaldo() {
        return CarpetaRespaldo;
    }

    /**
     * @param CarpetaRespaldo the CarpetaRespaldo to set
     */
    public void setCarpetaRespaldo(String CarpetaRespaldo) {
        this.CarpetaRespaldo = CarpetaRespaldo;
    }

    /**
     * @return the Principal
     */
    public String getPrincipal() {
        return Principal;
    }

    /**
     * @param Principal the Principal to set
     */
    public void setPrincipal(String Principal) {
        this.Principal = Principal;
    }
}
