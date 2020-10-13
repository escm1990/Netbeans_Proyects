/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Matriz;

import Fraccion.Fraccion;

/**
 *Clase que permite trbajar con matrices
 * @author USUARIO
 */
public class Matriz {

    /**
     * Declaracion de Variables
     */
    private int filas;
    private int columnas;
    private Fraccion[][] matrix;

    /**
     * Constructor de la
     * clase Matriz
     * @param filas
     * @param columnas
     */
    public Matriz(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        matrix = new Fraccion[filas][columnas];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = new Fraccion();
            }
        }
    }

    /**
     * Metodo que define la posicion
     * de los elementos de la matriz
     * @param a
     * @param i
     * @param j
     */
    public void setPos(Fraccion a, int i, int j) {
        matrix[i][j] = a;
    }

    /**
     *Metodo que obtiene la posicion
     * de los elementos de la matriz
     * @param i
     * @param j
     * @return
     */
    public Fraccion getPos(int i, int j) {
        return matrix[i][j];
    }

    /**
     * Metodo que permite sumar
     * las matrices
     * @param a
     * @param b
     * @return
     */
    public static Matriz sumar(Matriz a, Matriz b) {
        Matriz resultado = new Matriz(a.getFilas(), a.getColumnas());
        for (int i = 0; i < a.getFilas(); i++) {
            for (int j = 0; j < a.getColumnas(); j++) {
                resultado.setPos(Fraccion.sumar(a.getPos(i, j), b.getPos(i, j)), i, j);
            }
        }
        return resultado;
    }

    /**
     * Metodo que permite restar
     * las matrices
     * @param a
     * @param b
     * @return
     */
    public static Matriz restar(Matriz a, Matriz b) {
        Matriz resultado = new Matriz(a.getFilas(), a.getColumnas());
        for (int i = 0; i < a.getFilas(); i++) {
            for (int j = 0; j < a.getColumnas(); j++) {
                resultado.setPos(Fraccion.restar(a.getPos(i, j), b.getPos(i, j)), i, j);
            }
        }
        return resultado;
    }

    /**
     * Metodo que permite multiplicar
     * las matrices
     * @param a
     * @param b
     * @return
     */
    public static Matriz multiplicar(Matriz a, Matriz b) {
        Matriz resultado = new Matriz(a.getFilas(), a.getColumnas());
        for (int i = 0; i < a.getFilas(); i++) {
            for (int j = 0; j < a.getColumnas(); j++) {
                resultado.setPos(Fraccion.multiplicar(a.getPos(i, j), b.getPos(i, j)), i, j);
            }
        }
        return resultado;
    }

    /**
     * @return the filas
     */
    public int getFilas() {
        return filas;
    }

    /**
     * @return the columnas
     */
    public int getColumnas() {
        return columnas;
    }

    /**
     * os_gru@hotmail.com
     * ANS-GUIA2-NOMBRE
     */
}
