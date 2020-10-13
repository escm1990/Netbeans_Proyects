/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package areaCirculo;

/**
 *
 * @author USUARIO
 */
public class demoCirculo {

    public static void main(String[] args) {
        circulo miCirculo = new circulo();
        miCirculo.radio = 2.5;
        System.out.println("El área del circulo de radio " + miCirculo.radio + " es: " + miCirculo.calcularArea());
    }
}
