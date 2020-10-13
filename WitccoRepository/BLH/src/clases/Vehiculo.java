/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author USUARIO
 */
public class Vehiculo {

    private String placa;
    private String tipo;
    

    public Vehiculo() {
        this.placa = "";
        this.tipo = "";

    }

    public Vehiculo(String pl, String tp) {
        this.placa = pl;
        this.tipo = tp;

    }

    /**
     * @return the placa
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * @param placa the placa to set
     */
    public void setPlaca(String placa) {
        this.placa = placa;
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

    /**
     * @return the kilometraje
     */
   
}
