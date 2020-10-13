/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author Chavez Vigil
 */
public class PropiedadesPaciente {
    
    private String parto;
    private String edadMaterna;
    private String gravidez;
    private String patologia;
    private String municipio;
    private String departamento;
    
    public PropiedadesPaciente(){
        this.parto = "";
        this.edadMaterna = "";
        this.gravidez = "";
        this.patologia = "";
        this.municipio = "";
        this.departamento = "";
    }
    
    public  PropiedadesPaciente(String parto, String edad, String gravidez, String patologia, String municipio, String departament){
        this.parto = parto;
        this.edadMaterna = edad;
        this.gravidez = gravidez;
        this.patologia = patologia;
        this.municipio = municipio;
        this.departamento = departament;
    }

    /**
     * @return the parto
     */
    public String getParto() {
        return parto;
    }

    /**
     * @param parto the parto to set
     */
    public void setParto(String parto) {
        this.parto = parto;
    }

    /**
     * @return the edadMaterna
     */
    public String getEdadMaterna() {
        return edadMaterna;
    }

    /**
     * @param edadMaterna the edadMaterna to set
     */
    public void setEdadMaterna(String edadMaterna) {
        this.edadMaterna = edadMaterna;
    }

    /**
     * @return the gravidez
     */
    public String getGravidez() {
        return gravidez;
    }

    /**
     * @param gravidez the gravidez to set
     */
    public void setGravidez(String gravidez) {
        this.gravidez = gravidez;
    }

    /**
     * @return the patologia
     */
    public String getPatologia() {
        return patologia;
    }

    /**
     * @param patologia the patologia to set
     */
    public void setPatologia(String patologia) {
        this.patologia = patologia;
    }

    /**
     * @return the municipio
     */
    public String getMunicipio() {
        return municipio;
    }

    /**
     * @param municipio the municipio to set
     */
    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    /**
     * @return the departamento
     */
    public String getDepartamento() {
        return departamento;
    }

    /**
     * @param departamento the departamento to set
     */
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    
    
    
}
