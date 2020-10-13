/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Fraccion;

import javax.swing.JOptionPane;

/**
 *Esta clase nos permitirá hacer una prueba de las funciones
 * creadas en la clase Función, con valores predefinidos,
 * tanto para el numerador como para el denominador y los
 * resultados se mostrarán en consola.
 * @author USUARIO
 */
public class Prueba_Funciones {

    public static void main(String[] args) {
        try {
            String a = JOptionPane.showInputDialog("Ingrese la fraccion de la forma num/den");
            JOptionPane.showMessageDialog(null, "La fraccion ingresada es: " + Fraccion.parseFraccion(a));
        } catch (FractionFormatException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
//        Fraccion a= new Fraccion(10,25);
//        Fraccion b= new Fraccion(40,65);
//        System.out.println("La suma de las fracciones es: " + Fraccion.sumar(a, b));
//        System.out.println("La resta de las fracciones es: " + Fraccion.restar(a, b));
//        System.out.println("La multiplicación de las fracciones es: " + Fraccion.multiplicar(a, b));
//        System.out.println("La división de las fracciones es: " + Fraccion.dividir(a, b));
    }
}
