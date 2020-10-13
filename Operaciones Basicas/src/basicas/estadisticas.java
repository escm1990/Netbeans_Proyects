/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package basicas;

/**
 *
 * @author USUARIO
 */
public class estadisticas extends basicas {

    public double promedio(double a, double b) {
        return sumar(a, b) / 2;
    }

    String mayor(double a, double b){
        if(a>=b)
            return "El mayor es: " + a;
        else
            return "El mayor es: " + b;
    }

    String menor(double a, double b){
        if(a<=b)
            return "El menor es: " + a;
        else
            return "El menor es: " + b;
    }

}
