/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Matriz;

import Fraccion.Fraccion;
import Fraccion.FractionFormatException;

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
     * @throws FractionFormatException
     */
    public static Matriz sumar(Matriz a, Matriz b) throws FractionFormatException {
        try {
            Matriz resultado = new Matriz(a.getFilas(), a.getColumnas());
            if (a.getFilas() == b.getColumnas() && a.getColumnas() == b.getFilas()) {
                for (int i = 0; i < a.getFilas(); i++) {
                    for (int j = 0; j < a.getColumnas(); j++) {
                        resultado.setPos(Fraccion.sumar(a.getPos(i, j), b.getPos(i, j)), i, j);
                    }
                }
            } else {
                throw new FractionFormatException("Error de Dimensión");
            }
            return resultado;
        } catch (NumberFormatException ex) {
            throw new FractionFormatException("Error de Dimensión");
        }
    }

    /**
     * Metodo que permite restar
     * las matrices
     * @param a
     * @param b
     * @return
     * @throws FractionFormatException 
     */
    public static Matriz restar(Matriz a, Matriz b) throws FractionFormatException {
        try {
            Matriz resultado = new Matriz(a.getFilas(), a.getColumnas());
            if (a.getFilas() == b.getColumnas() && a.getColumnas() == b.getFilas()) {
                for (int i = 0; i < a.getFilas(); i++) {
                    for (int j = 0; j < a.getColumnas(); j++) {
                        resultado.setPos(Fraccion.restar(a.getPos(i, j), b.getPos(i, j)), i, j);
                    }
                }
            } else {
                throw new FractionFormatException("Error de Dimensión");
            }
            return resultado;
        } catch (NumberFormatException ex) {
            throw new FractionFormatException("Error de Dimensión");
        }
    }

    /**
     * Metodo que permite multiplicar
     * las matrices
     * @param a 
     * @param b 
     * @return
     * @throws FractionFormatException
     */
    public static Matriz multiplicar(Matriz a, Matriz b) throws FractionFormatException {
        try {
            if (a.getFilas() == b.getColumnas() && a.getColumnas() == b.getFilas()) {
                int c = a.getFilas();
                int d = a.getColumnas();
                int e = b.getFilas();
                Matriz resultado = new Matriz(c, e);//c = flias mat1, d = col mat1, e = fils mat2
                for (int i = 0; i < c; i++) {
                    for (int j = 0; j < e; j++) {
                        Fraccion res = new Fraccion(0, 1);
                        for (int k = 0; k < d; k++) {
                            res = Fraccion.sumar(res, Fraccion.multiplicar(a.getPos(i, k), b.getPos(k, j)));
                            resultado.setPos(res, i, j);
                        }
                    }
                }
                return resultado;
            } else {
                throw new FractionFormatException("Error de Dimensión");
            }
        } catch (NumberFormatException ex) {
            throw new FractionFormatException("Error de Dimensión");
        }
    }

    public static Matriz inversa(Matriz a) throws FractionFormatException {
        if (a.getFilas() == a.getColumnas()) {
            for (int m = 1; m <= a.getColumnas(); m++) {
                a.setPos(a.getPos(m, a.getColumnas()), m, m);
                for (int k = 2; k < a.getFilas(); k++) {
//                    a.setPos(a.getPos(a.getColumnas(), k) - a.getPos(k, k) * a.getPos(m, k), k, k);
                }
            }
        }
        Matriz resultado = new Matriz(a.getFilas(), a.getColumnas());
        return resultado;
    }

    public static Matriz identidad(Matriz c) throws FractionFormatException {
        Matriz resultado = new Matriz(c.getFilas(), c.getColumnas());
        if (c.getFilas() == c.getColumnas()) {
            for (int i = 0; i < c.getFilas(); i++) {
                for (int j = 0; j < c.getColumnas(); j++) {
                    if (i == j) {
                        resultado.setPos(c.getPos(i, j), i, j);
                    }
                }
            }
        }
        return resultado;
    }

    public static Matriz transponer(Matriz a) {
        Matriz resultado = new Matriz(a.getFilas(), a.getColumnas());
        for (int i = 0; i < a.getFilas(); i++) {
            for (int j = 0; j < a.getColumnas(); j++) {
                resultado.setPos(a.getPos(j, i), i, j);
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
