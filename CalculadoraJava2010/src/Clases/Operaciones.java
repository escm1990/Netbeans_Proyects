/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases;

/**
 *
 * @author USUARIO
 */
public enum Operaciones {
    suma("0"), resta("1"), multiplicacion("2"), division("3"), raiz("7"), masmenos("5"), dolar("6"), espera("4");
    private String abreviatura;

       private Operaciones (String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

}
