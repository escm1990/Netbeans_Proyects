/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Matriz;

import Fraccion.Fraccion;
import Fraccion.FractionFormatException;

/**
 *
 * @author home
 */
public class PruebaMatriz {

    public static void main(String[] args) throws FractionFormatException {
        //creamos ambas matrices
        Matriz a = new Matriz(3, 3);
        Matriz b = new Matriz(3, 3);
//        Matriz c = new Matriz(3, 3);

        //llenado de las matrices todas las pociciones con el mismo valor

        for (int i = 0; i < a.getFilas(); i++) {
            for (int j = 0; j < a.getColumnas(); j++) {

                //llenando las matrices; como se utiliza la fraccion, ingresamos los valores de los numeradores y los denominadores//
                a.setPos(new Fraccion(5, 13), i, j);
                b.setPos(new Fraccion(7, 19), i, j);
//                c.setPos(new Fraccion(1, 1), i, j);
            }
        }

        System.out.println("a:");
        mostrarMatriz(a);
        System.out.println("\nb:");
        mostrarMatriz(b);
        System.out.println("");
//        mostrarMatriz(Matriz.identidad(c));
        System.out.println("");
        mostrarMatriz(Matriz.inversa(a));
    }

    //metodo para imprimir la matriz en consola
    private static void mostrarMatriz(Matriz a) {
        for (int i = 0; i < a.getFilas(); i++) {
            for (int j = 0; j < a.getColumnas(); j++) {
                System.out.print(a.getPos(i, j) + "\t");
            }
            System.out.println("");
        }
    }
}


