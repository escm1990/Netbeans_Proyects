/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author USUARIO
 */
public enum Estado {

    espera("0"), operando("1"), resultado("2");
    private String abreviatura;

    private Estado(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public String getAbreviatura() {
        return abreviatura;
    }
}
