/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FormMatrices.java
 *
 * Created on 03-may-2011, 19:32:41
 */
package Formularios;

import Clases.Fraccion;
import Clases.FraccionFormatException;
import Clases.Matriz;
import Clases.MatrizNoOperableException;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author USUARIO
 */
public class FormMatrices extends javax.swing.JFrame {

    /**
     * VARIABLES GLOBALES
     */
    private int FILAS;
    private int COLUMNAS;
    /**
     * VARIABLES PARA LA SUMA Y RESTA
     */
    private JTextField jtA[][];
    private JTextField jtB[][];
    private JTextField jtRES[][];
    public Matriz matrizA;
    public Matriz matrizB;
    public Matriz matrizRES;

    /** Creates new form FormMatrices */
    public FormMatrices() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.jbLimipiarSuma.setVisible(false);
        this.jbCalcularSuma.setVisible(false);
        this.jbLimipiarResta.setVisible(false);
        this.jbCalcularResta.setVisible(false);
        this.jbCalcularMultiplicacion.setVisible(false);
        this.jbLimpiarMultiplicacion.setVisible(false);
        this.jbCalcularMultK.setVisible(false);
        this.jbLimipiarMultK.setVisible(false);
        this.jtfK.setEnabled(false);
        this.jbCalcularTrans.setVisible(false);
        this.jbLimipiarTrans.setVisible(false);
        this.jbCalcularInv.setVisible(false);
        this.jbLimipiarInv.setVisible(false);
    }

    public void obtenerDimension(int fil, int col) {
        FILAS = fil;
        COLUMNAS = col;
    }

    /**
     * PORCION DE CODIGO PARA LA SUMA
     * @param f 
     * @param c
     */
    public void redimSuma(int f, int c) {
        if (f > 0 && c > 0) {
            nuevoSuma();
            matrizA = new Matriz(f, c);
            matrizB = new Matriz(f, c);
            jtA = new JTextField[f][c];
            jtB = new JTextField[f][c];
            jpSumaA.setLayout(new GridLayout(f, c));
            jpSumaB.setLayout(new GridLayout(f, c));
            for (int fila = 0; fila < f; fila++) {
                for (int columna = 0; columna < c; columna++) {
                    llenarPanelesSuma(fila, columna);
                }
            }
            mostrarPanelSuma();
            jbCalcularSuma.setVisible(true);
            jbLimipiarSuma.setVisible(true);
        } else {
            if (f == 0 || c == 0) {
                nuevoSuma();
                jbCalcularSuma.setVisible(false);
                jbLimipiarSuma.setVisible(false);
            }
        }
    }

    public void llenarPanelesSuma(int fila, int columna) {
        jtA[fila][columna] = new JTextField();
        jtA[fila][columna].setEditable(true);
        jpSumaA.add(jtA[fila][columna]);
        jtA[fila][columna].setHorizontalAlignment(JTextField.CENTER);
        jtA[fila][columna].setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jtA[fila][columna].addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();
                if (((caracter < '0') || (caracter > '9')) && ((caracter != KeyEvent.VK_BACK_SPACE) && (caracter != '-') && (caracter != '/'))) {
                    e.consume();
                }
            }
        });
        jtB[fila][columna] = new JTextField();
        jtB[fila][columna].setEditable(true);
        jpSumaB.add(jtB[fila][columna]);
        jtB[fila][columna].setHorizontalAlignment(JTextField.CENTER);
        jtB[fila][columna].setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtB[fila][columna].addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();
                if (((caracter < '0') || (caracter > '9')) && ((caracter != KeyEvent.VK_BACK_SPACE) && (caracter != '-') && (caracter != '/'))) {
                    e.consume();
                }
            }
        });
    }

    public void crearPanelResultadoSuma(int fila, int columna) {
        jtRES[fila][columna] = new JTextField();
        jpSumaC.add(jtRES[fila][columna]);
        jtRES[fila][columna].setHorizontalAlignment(JTextField.CENTER);
        jtRES[fila][columna].setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtRES[fila][columna].setEditable(false);
    }

    public void llenarMatricesSuma(int f, int c) throws FraccionFormatException, MatrizNoOperableException {
        for (int fila = 0; fila < f; fila++) {
            for (int colum = 0; colum < c; colum++) {
                if (jtA[fila][colum].getText().trim().length() == 0) {//Agregamos 0 a espacios vacios
                    matrizA.setValor(fila, colum, Fraccion.parseFraccion("0"));
                } else {
                    matrizA.setValor(fila, colum, Fraccion.parseFraccion(String.valueOf(jtA[fila][colum].getText())));
                }
                if (jtB[fila][colum].getText().trim().length() == 0) {//Agregamos 0 a espacios vacios
                    matrizB.setValor(fila, colum, Fraccion.parseFraccion("0"));
                } else {
                    matrizB.setValor(fila, colum, Fraccion.parseFraccion(String.valueOf(jtB[fila][colum].getText())));
                }
            }
        }
        matrizRES = new Matriz(f, c);
        jtRES = new JTextField[f][c];
        jpSumaC.setLayout(new GridLayout(f, c));
        matrizRES = Matriz.sumar(matrizA, matrizB);
        for (int fila = 0; fila < f; fila++) {
            for (int columna = 0; columna < c; columna++) {
                crearPanelResultadoSuma(fila, columna);
                jtRES[fila][columna].setText(String.valueOf(matrizRES.getValor(fila, columna)));
            }
        }
    }

    public void nuevoSuma() {
        jpSumaA.removeAll();
        jpSumaB.removeAll();
        jpSumaA.setVisible(false);
        jpSumaB.setVisible(false);
        jpSumaA.setVisible(true);
        jpSumaB.setVisible(true);
    }

    public void limpiarResSuma() {
        jpSumaC.removeAll();
        jpSumaC.setVisible(false);
        jpSumaC.setVisible(true);
    }

    public void mostrarPanelSuma() {
        jpSumaA.setVisible(false);
        jpSumaB.setVisible(false);
        jpSumaA.setVisible(true);
        jpSumaB.setVisible(true);
    }

    /**
     * PORCION DE CODIGO PARA LA RESTA
     * @param f 
     * @param c
     */
    public void redimResta(int f, int c) {
        if (f > 0 && c > 0) {
            nuevoResta();
            matrizA = new Matriz(f, c);
            matrizB = new Matriz(f, c);
            jtA = new JTextField[f][c];
            jtB = new JTextField[f][c];
            jpRestaA.setLayout(new GridLayout(f, c));
            jpRestaB.setLayout(new GridLayout(f, c));
            for (int fila = 0; fila < f; fila++) {
                for (int columna = 0; columna < c; columna++) {
                    llenarPanelesResta(fila, columna);
                }
            }
            mostrarPanelResta();
            jbCalcularResta.setVisible(true);
            jbLimipiarResta.setVisible(true);
        } else {
            if (f == 0 || c == 0) {
                nuevoResta();
                jbCalcularResta.setVisible(false);
                jbLimipiarResta.setVisible(false);
            }
        }
    }

    public void llenarPanelesResta(int fila, int columna) {
        jtA[fila][columna] = new JTextField();
        jtA[fila][columna].setEditable(true);
        jpRestaA.add(jtA[fila][columna]);
        jtA[fila][columna].setHorizontalAlignment(JTextField.CENTER);
        jtA[fila][columna].setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtA[fila][columna].addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();
                if (((caracter < '0') || (caracter > '9')) && ((caracter != KeyEvent.VK_BACK_SPACE) && (caracter != '-') && (caracter != '/'))) {
                    e.consume();
                }
            }
        });
        jtB[fila][columna] = new JTextField();
        jtB[fila][columna].setEditable(true);
        jpRestaB.add(jtB[fila][columna]);
        jtB[fila][columna].setHorizontalAlignment(JTextField.CENTER);
        jtB[fila][columna].setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtB[fila][columna].addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();
                if (((caracter < '0') || (caracter > '9')) && ((caracter != KeyEvent.VK_BACK_SPACE) && (caracter != '-') && (caracter != '/'))) {
                    e.consume();
                }
            }
        });
    }

    public void crearPanelResultadoResta(int fila, int columna) {
        jtRES[fila][columna] = new JTextField();
        jpRestaC.add(jtRES[fila][columna]);
        jtRES[fila][columna].setHorizontalAlignment(JTextField.CENTER);
        jtRES[fila][columna].setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtRES[fila][columna].setEditable(false);
    }

    public void llenarMatricesResta(int f, int c) throws FraccionFormatException, MatrizNoOperableException {
        for (int fila = 0; fila < f; fila++) {
            for (int colum = 0; colum < c; colum++) {
                if (jtA[fila][colum].getText().trim().length() == 0) {//Agregamos 0 a espacios vacios
                    matrizA.setValor(fila, colum, Fraccion.parseFraccion("0"));
                } else {
                    matrizA.setValor(fila, colum, Fraccion.parseFraccion(String.valueOf(jtA[fila][colum].getText())));
                }
                if (jtB[fila][colum].getText().trim().length() == 0) {//Agregamos 0 a espacios vacios
                    matrizB.setValor(fila, colum, Fraccion.parseFraccion("0"));
                } else {
                    matrizB.setValor(fila, colum, Fraccion.parseFraccion(String.valueOf(jtB[fila][colum].getText())));
                }
            }
        }
        matrizRES = new Matriz(f, c);
        jtRES = new JTextField[f][c];
        jpRestaC.setLayout(new GridLayout(f, c));
        matrizRES = Matriz.restar(matrizA, matrizB);
        for (int fila = 0; fila < f; fila++) {
            for (int columna = 0; columna < c; columna++) {
                crearPanelResultadoResta(fila, columna);
                jtRES[fila][columna].setText(String.valueOf(matrizRES.getValor(fila, columna)));
            }
        }
    }

    public void nuevoResta() {
        jpRestaA.removeAll();
        jpRestaB.removeAll();
        jpRestaA.setVisible(false);
        jpRestaB.setVisible(false);
        jpRestaA.setVisible(true);
        jpRestaB.setVisible(true);
    }

    public void limpiarResResta() {
        jpRestaC.removeAll();
        jpRestaC.setVisible(false);
        jpRestaC.setVisible(true);
    }

    public void mostrarPanelResta() {
        jpRestaA.setVisible(false);
        jpRestaB.setVisible(false);
        jpRestaA.setVisible(true);
        jpRestaB.setVisible(true);
    }
    /**
     * CODIGO PARA LA MULTIPLICACION DE MATRICES
     */
    int FILAS_A, FILAS_B, COLUMNAS_A, COLUMNAS_B;

    public void obtenerDimensionA(int fil, int col) {
        FILAS_A = fil;
        COLUMNAS_A = col;
    }

    public void obtenerDimensionB(int fil, int col) {
        FILAS_B = fil;
        COLUMNAS_B = col;
    }

    public void redimMultA(int f, int c) {
        if (f > 0 && c > 0) {
            nuevoMultA();
            matrizA = new Matriz(f, c);
            jtA = new JTextField[f][c];
            jpMultA.setLayout(new GridLayout(f, c));
            for (int fila = 0; fila < f; fila++) {
                for (int columna = 0; columna < c; columna++) {
                    llenarPanelesMultA(fila, columna);
                }
            }
            mostrarPanelMultA();
            jbCalcularMultiplicacion.setVisible(true);
            jbLimpiarMultiplicacion.setVisible(true);
        } else {
            if (f == 0 || c == 0) {
                nuevoMultA();
                jbCalcularMultiplicacion.setVisible(false);
                jbLimpiarMultiplicacion.setVisible(false);
            }
        }
    }

    public void redimMultB(int f, int c) {
        if (f > 0 && c > 0) {
            nuevoMultB();
            matrizB = new Matriz(f, c);
            jtB = new JTextField[f][c];
            jpMultB.setLayout(new GridLayout(f, c));
            for (int fila = 0; fila < f; fila++) {
                for (int columna = 0; columna < c; columna++) {
                    llenarPanelesMultB(fila, columna);
                }
            }
            mostrarPanelMultB();
            jbCalcularMultiplicacion.setVisible(true);
            jbLimpiarMultiplicacion.setVisible(true);
        } else {
            if (f == 0 || c == 0) {
                nuevoMultB();
                jbCalcularMultiplicacion.setVisible(false);
                jbLimpiarMultiplicacion.setVisible(false);
            }
        }
    }

    public void llenarPanelesMultA(int fila, int columna) {
        jtA[fila][columna] = new JTextField();
        jtA[fila][columna].setEditable(true);
        jpMultA.add(jtA[fila][columna]);
        jtA[fila][columna].setHorizontalAlignment(JTextField.CENTER);
        jtA[fila][columna].setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtA[fila][columna].addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();
                if (((caracter < '0') || (caracter > '9')) && ((caracter != KeyEvent.VK_BACK_SPACE) && (caracter != '-') && (caracter != '/'))) {
                    e.consume();
                }
            }
        });
    }

    public void llenarPanelesMultB(int fila, int columna) {
        jtB[fila][columna] = new JTextField();
        jtB[fila][columna].setEditable(true);
        jpMultB.add(jtB[fila][columna]);
        jtB[fila][columna].setHorizontalAlignment(JTextField.CENTER);
        jtB[fila][columna].setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtB[fila][columna].addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();
                if (((caracter < '0') || (caracter > '9')) && ((caracter != KeyEvent.VK_BACK_SPACE) && (caracter != '-') && (caracter != '/'))) {
                    e.consume();
                }
            }
        });
    }

    public void crearPanelResultadoMult(int fila, int columna) {
        jtRES[fila][columna] = new JTextField();
        jpMultC.add(jtRES[fila][columna]);
        jtRES[fila][columna].setHorizontalAlignment(JTextField.CENTER);
        jtRES[fila][columna].setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtRES[fila][columna].setEditable(false);
    }

    public void llenarMatricesMultiplicacionA(int f, int c) throws FraccionFormatException, MatrizNoOperableException {
        for (int fila = 0; fila < f; fila++) {
            for (int colum = 0; colum < c; colum++) {
                if (jtA[fila][colum].getText().trim().length() == 0) {//Agregamos 0 a espacios vacios
                    matrizA.setValor(fila, colum, Fraccion.parseFraccion("0"));
                } else {
                    matrizA.setValor(fila, colum, Fraccion.parseFraccion(String.valueOf(jtA[fila][colum].getText())));
                }
            }
        }
    }

    public void llenarMatricesMultiplicacionB(int f, int c) throws FraccionFormatException, MatrizNoOperableException {
        for (int fila = 0; fila < f; fila++) {
            for (int colum = 0; colum < c; colum++) {
                if (jtB[fila][colum].getText().trim().length() == 0) {//Agregamos 0 a espacios vacios
                    matrizB.setValor(fila, colum, Fraccion.parseFraccion("0"));
                } else {
                    matrizB.setValor(fila, colum, Fraccion.parseFraccion(String.valueOf(jtB[fila][colum].getText())));
                }
            }
        }
    }

    public void llenarMatrizResultadoMult(int f, int c) throws MatrizNoOperableException {
        matrizRES = new Matriz(f, c);
        jtRES = new JTextField[f][c];
        jpMultC.setLayout(new GridLayout(f, c));
        matrizRES = Matriz.multiplicar(matrizA, matrizB);
        for (int fila = 0; fila < f; fila++) {
            for (int columna = 0; columna < c; columna++) {
                crearPanelResultadoMult(fila, columna);
                jtRES[fila][columna].setText(String.valueOf(matrizRES.getValor(fila, columna)));
            }
        }
    }

    public void nuevoMultA() {
        jpMultA.removeAll();
        jpMultA.setVisible(false);
        jpMultA.setVisible(true);
    }

    public void nuevoMultB() {
        jpMultB.removeAll();
        jpMultB.setVisible(false);
        jpMultB.setVisible(true);
    }

    public void limpiarResMult() {
        jpMultC.removeAll();
        jpMultC.setVisible(false);
        jpMultC.setVisible(true);
    }

    public void mostrarPanelMultA() {
        jpMultA.setVisible(false);
        jpMultA.setVisible(true);
    }

    public void mostrarPanelMultB() {
        jpMultB.setVisible(false);
        jpMultB.setVisible(true);
    }

    /**
     * PORCION DE CODIGO PARA LA MULTIPLICACION DE UNA MATRIZ POR UNA CONSTANTE
     * @param f
     * @param c 
     */
    public void redim_multK(int f, int c) {
        if (f > 0 && c > 0) {
            nuevoMultK();
            matrizA = new Matriz(f, c);
            matrizB = new Matriz(f, c);
            jtA = new JTextField[f][c];
            jtB = new JTextField[f][c];
            jpMultK.setLayout(new GridLayout(f, c));
            jpMultKRES.setLayout(new GridLayout(f, c));
            for (int fila = 0; fila < f; fila++) {
                for (int columna = 0; columna < c; columna++) {
                    llenarPanelMultK(fila, columna);
                }
            }
            mostrarPanelMultK();
            jbCalcularMultK.setVisible(true);
            jbLimipiarMultK.setVisible(true);
        } else {
            if (f == 0 || c == 0) {
                nuevoMultK();
                jbCalcularMultK.setVisible(false);
                jbLimipiarMultK.setVisible(false);
            }
        }
    }

    public void llenarPanelMultK(int fila, int columna) {
        jtA[fila][columna] = new JTextField();
        jtA[fila][columna].setEditable(true);
        jpMultK.add(jtA[fila][columna]);
        jtA[fila][columna].setHorizontalAlignment(JTextField.CENTER);
        jtA[fila][columna].setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtA[fila][columna].addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();
                if (((caracter < '0') || (caracter > '9')) && ((caracter != KeyEvent.VK_BACK_SPACE) && (caracter != '-') && (caracter != '/'))) {
                    e.consume();
                }
            }
        });
    }

    public void crearPanelResultadoMultK(int fila, int columna) {
        jtRES[fila][columna] = new JTextField();
        jtRES[fila][columna].setHorizontalAlignment(JTextField.CENTER);
        jtA[fila][columna].setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtRES[fila][columna].setEditable(false);
        jpMultKRES.add(jtRES[fila][columna]);
    }

    public void llenarMatricesMultK(int f, int c) throws FraccionFormatException, MatrizNoOperableException {
        for (int fila = 0; fila < f; fila++) {
            for (int colum = 0; colum < c; colum++) {
                if (jtA[fila][colum].getText().trim().length() == 0) {//Agregamos 0 a espacios vacios
                    matrizA.setValor(fila, colum, Fraccion.parseFraccion("0"));
                } else {
                    matrizA.setValor(fila, colum, Fraccion.parseFraccion(String.valueOf(jtA[fila][colum].getText())));
                }
                matrizB.setValor(fila, colum, Fraccion.parseFraccion(this.jtfK.getText()));
            }
        }
    }

    public void mostrarPanelResK(int f, int c, Matriz A, Matriz B) throws MatrizNoOperableException {
        matrizRES = new Matriz(f, c);
        jtRES = new JTextField[f][c];
        jpMultKRES.setLayout(new GridLayout(f, c));
        matrizRES = Matriz.MultiplicarK(A, B);
        for (int fila = 0; fila < f; fila++) {
            for (int columna = 0; columna < c; columna++) {
                crearPanelResultadoMultK(fila, columna);
                jtRES[fila][columna].setText(String.valueOf(matrizRES.getValor(fila, columna)));

            }
        }
    }

    public void limpiarResMultK() {
        jpMultKRES.removeAll();
        jpMultKRES.setVisible(false);
        jpMultKRES.setVisible(true);
    }

    public void nuevoMultK() {
        jpMultK.removeAll();
        jpMultK.setVisible(false);
        jpMultK.setVisible(true);
    }

    public void mostrarPanelMultK() {
        jpMultK.setVisible(false);
        jpMultKRES.setVisible(false);
        jpMultK.setVisible(true);
        jpMultKRES.setVisible(true);
    }

    /**
     * PORCION DE CODIGO PARA LA TRANSPUESTA DE UNA MATRIZ
     * @param f
     * @param c
     */
    public void redim_Trans(int f, int c) {
        if (f > 0 && c > 0) {
            nuevoTrans();
            matrizA = new Matriz(f, c);
            matrizB = new Matriz(f, c);
            jtA = new JTextField[f][c];
            jtB = new JTextField[f][c];
            jpTransA.setLayout(new GridLayout(f, c));
            jpTransRES.setLayout(new GridLayout(f, c));
            for (int fila = 0; fila < f; fila++) {
                for (int columna = 0; columna < c; columna++) {
                    llenarPanelTrans(fila, columna);
                }
            }
            mostrarPanelTrans();
            jbCalcularTrans.setVisible(true);
            jbLimipiarTrans.setVisible(true);
        } else {
            if (f == 0 || c == 0) {
                nuevoTrans();
                jbCalcularTrans.setVisible(false);
                jbLimipiarTrans.setVisible(false);
            }
        }
    }

    public void llenarPanelTrans(int fila, int columna) {
        jtA[fila][columna] = new JTextField();
        jtA[fila][columna].setEditable(true);
        jpTransA.add(jtA[fila][columna]);
        jtA[fila][columna].setHorizontalAlignment(JTextField.CENTER);
        jtA[fila][columna].setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtA[fila][columna].addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();
                if (((caracter < '0') || (caracter > '9')) && ((caracter != KeyEvent.VK_BACK_SPACE) && (caracter != '-') && (caracter != '/'))) {
                    e.consume();
                }
            }
        });
    }

    public void crearPanelResultadoTrans(int fila, int columna) {
        jtRES[fila][columna] = new JTextField();
        jtRES[fila][columna].setHorizontalAlignment(JTextField.CENTER);
        jtRES[fila][columna].setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtRES[fila][columna].setEditable(false);
        jpTransRES.add(jtRES[fila][columna]);
    }

    public void llenarMatricesTrans(int f, int c) throws FraccionFormatException, MatrizNoOperableException {
        for (int fila = 0; fila < f; fila++) {
            for (int colum = 0; colum < c; colum++) {
                if (jtA[fila][colum].getText().trim().length() == 0) {//Agregamos 0 a espacios vacios
                    matrizA.setValor(fila, colum, Fraccion.parseFraccion("0"));
                } else {
                    matrizA.setValor(fila, colum, Fraccion.parseFraccion(String.valueOf(jtA[fila][colum].getText())));
                }
            }
        }
    }

    public void mostrarPanelTrans(int f, int c, Matriz A) throws MatrizNoOperableException {
        matrizRES = new Matriz(c, f);
        jtRES = new JTextField[c][f];
        jpTransRES.setLayout(new GridLayout(c, f));
        matrizRES = Matriz.transponer(A);
        for (int fila = 0; fila < f; fila++) {
            for (int columna = 0; columna < c; columna++) {
                crearPanelResultadoTrans(fila, columna);
                jtRES[columna][fila].setText(String.valueOf(matrizRES.getValor(columna, fila)));

            }
        }
    }

    public void limpiarResTrans() {
        jpTransRES.removeAll();
        jpTransRES.setVisible(false);
        jpTransRES.setVisible(true);
    }

    public void nuevoTrans() {
        jpTransA.removeAll();
        jpTransA.setVisible(false);
        jpTransA.setVisible(true);
    }

    public void mostrarPanelTrans() {
        jpTransA.setVisible(false);
        jpTransRES.setVisible(false);
        jpTransA.setVisible(true);
        jpTransRES.setVisible(true);
    }

    /**
     * PORCION DE CODIGO PARA LA INVERSA DE UNA MATRIZ
     * @param f
     * @param c
     */
    public void redim_Inv(int f, int c) {
        if (f > 0 && c > 0) {
            nuevoTrans();
            matrizA = new Matriz(f, c);
            jtA = new JTextField[f][c];
            jpInversaA.setLayout(new GridLayout(f, c));
            jpInversaRES.setLayout(new GridLayout(f, c));
            for (int fila = 0; fila < f; fila++) {
                for (int columna = 0; columna < c; columna++) {
                    llenarPanelInv(fila, columna);
                }
            }
            mostrarPanelInv();
            jbCalcularInv.setVisible(true);
            jbLimipiarInv.setVisible(true);
        } else {
            if (f == 0 || c == 0) {
                nuevoTrans();
                jbCalcularInv.setVisible(false);
                jbLimipiarInv.setVisible(false);
            }
        }
    }

    public void llenarPanelInv(int fila, int columna) {
        jtA[fila][columna] = new JTextField();
        jtA[fila][columna].setEditable(true);
        jpInversaA.add(jtA[fila][columna]);
        jtA[fila][columna].setHorizontalAlignment(JTextField.CENTER);
        jtA[fila][columna].setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtA[fila][columna].addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();
                if (((caracter < '0') || (caracter > '9')) && ((caracter != KeyEvent.VK_BACK_SPACE) && (caracter != '-') && (caracter != '/'))) {
                    e.consume();
                }
            }
        });
    }

    public void crearPanelResultadoInv(int fila, int columna) {
        jtRES[fila][columna] = new JTextField();
        jtRES[fila][columna].setHorizontalAlignment(JTextField.CENTER);
        jtRES[fila][columna].setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtRES[fila][columna].setEditable(false);
        jpInversaRES.add(jtRES[fila][columna]);
    }

    public void llenarMatricesInv(int f, int c) throws FraccionFormatException, MatrizNoOperableException {
        for (int fila = 0; fila < f; fila++) {
            for (int colum = 0; colum < c; colum++) {
                if (jtA[fila][colum].getText().trim().length() == 0) {//Agregamos 0 a espacios vacios
                    matrizA.setValor(fila, colum, Fraccion.parseFraccion("0"));
                } else {
                    matrizA.setValor(fila, colum, Fraccion.parseFraccion(String.valueOf(jtA[fila][colum].getText())));
                }
            }
        }
    }

    public void mostrarPanelInv(int f, int c, Matriz A) throws MatrizNoOperableException {
        matrizRES = new Matriz(f, c);
        jtRES = new JTextField[f][c];
        jpInversaRES.setLayout(new GridLayout(f, c));
        matrizRES = Matriz.invertir(A);
        for (int fila = 0; fila < f; fila++) {
            for (int columna = 0; columna < c; columna++) {
                crearPanelResultadoInv(fila, columna);
                jtRES[fila][columna].setText(String.valueOf(matrizRES.getValor(fila, columna)));
            }
        }
    }

    public void limpiarResInv() {
        jpInversaRES.removeAll();
        jpInversaRES.setVisible(false);
        jpInversaRES.setVisible(true);
    }

    public void nuevoInv() {
        jpInversaA.removeAll();
        jpInversaA.setVisible(false);
        jpInversaA.setVisible(true);
    }

    public void mostrarPanelInv() {
        jpInversaA.setVisible(false);
        jpInversaRES.setVisible(false);
        jpInversaA.setVisible(true);
        jpInversaRES.setVisible(true);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jtfmSuma = new javax.swing.JTextField();
        jtfnSuma = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jpSumaA = new javax.swing.JPanel();
        jpSumaB = new javax.swing.JPanel();
        jbDimensionarSuma = new javax.swing.JButton();
        jbCalcularSuma = new javax.swing.JButton();
        jbLimipiarSuma = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jpSumaC = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jtfmResta = new javax.swing.JTextField();
        jtfnResta = new javax.swing.JTextField();
        jbDimensionarResta = new javax.swing.JButton();
        jbCalcularResta = new javax.swing.JButton();
        jbLimipiarResta = new javax.swing.JButton();
        jpRestaA = new javax.swing.JPanel();
        jpRestaC = new javax.swing.JPanel();
        jpRestaB = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jtfmMultA = new javax.swing.JTextField();
        jtfnMultA = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtfmMultB = new javax.swing.JTextField();
        jtfnMultB = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jbDimensionarMultiplicacionA = new javax.swing.JButton();
        jbDimensionarMultiplicacionB = new javax.swing.JButton();
        jbCalcularMultiplicacion = new javax.swing.JButton();
        jpMultB = new javax.swing.JPanel();
        jpMultA = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jpMultC = new javax.swing.JPanel();
        jbLimpiarMultiplicacion = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jtfmMultK = new javax.swing.JTextField();
        jtfnMultK = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jtfK = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jbDimensionarMultK = new javax.swing.JButton();
        jbCalcularMultK = new javax.swing.JButton();
        jbLimipiarMultK = new javax.swing.JButton();
        jpMultK = new javax.swing.JPanel();
        jpMultKRES = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jtfmTrans = new javax.swing.JTextField();
        jtfnTrans = new javax.swing.JTextField();
        jpTransA = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jpTransRES = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jbDimensionarTrans = new javax.swing.JButton();
        jbCalcularTrans = new javax.swing.JButton();
        jbLimipiarTrans = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jpInversaRES = new javax.swing.JPanel();
        jpInversaA = new javax.swing.JPanel();
        jbDimensionarInv = new javax.swing.JButton();
        jbCalcularInv = new javax.swing.JButton();
        jbLimipiarInv = new javax.swing.JButton();
        jtfnInv = new javax.swing.JTextField();
        jtfmInv = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(831, 422));
        setResizable(false);

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 18));

        jPanel1.setLayout(null);

        jtfmSuma.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.add(jtfmSuma);
        jtfmSuma.setBounds(190, 30, 68, 20);

        jtfnSuma.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.add(jtfnSuma);
        jtfnSuma.setBounds(190, 60, 68, 20);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel1.setText("m (filas)");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(70, 30, 90, 17);

        jpSumaA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        javax.swing.GroupLayout jpSumaALayout = new javax.swing.GroupLayout(jpSumaA);
        jpSumaA.setLayout(jpSumaALayout);
        jpSumaALayout.setHorizontalGroup(
            jpSumaALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 197, Short.MAX_VALUE)
        );
        jpSumaALayout.setVerticalGroup(
            jpSumaALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 203, Short.MAX_VALUE)
        );

        jPanel1.add(jpSumaA);
        jpSumaA.setBounds(70, 110, 203, 209);

        jpSumaB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        javax.swing.GroupLayout jpSumaBLayout = new javax.swing.GroupLayout(jpSumaB);
        jpSumaB.setLayout(jpSumaBLayout);
        jpSumaBLayout.setHorizontalGroup(
            jpSumaBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 198, Short.MAX_VALUE)
        );
        jpSumaBLayout.setVerticalGroup(
            jpSumaBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 203, Short.MAX_VALUE)
        );

        jPanel1.add(jpSumaB);
        jpSumaB.setBounds(300, 110, 204, 209);

        jbDimensionarSuma.setFont(new java.awt.Font("Tahoma", 1, 14));
        jbDimensionarSuma.setText("Dimensionar");
        jbDimensionarSuma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDimensionarSumaActionPerformed(evt);
            }
        });
        jPanel1.add(jbDimensionarSuma);
        jbDimensionarSuma.setBounds(300, 40, 140, 40);

        jbCalcularSuma.setFont(new java.awt.Font("Tahoma", 1, 14));
        jbCalcularSuma.setText("Calcular");
        jbCalcularSuma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCalcularSumaActionPerformed(evt);
            }
        });
        jPanel1.add(jbCalcularSuma);
        jbCalcularSuma.setBounds(450, 40, 130, 40);

        jbLimipiarSuma.setFont(new java.awt.Font("Tahoma", 1, 14));
        jbLimipiarSuma.setText("Limpiar");
        jbLimipiarSuma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimipiarSumaActionPerformed(evt);
            }
        });
        jPanel1.add(jbLimipiarSuma);
        jbLimipiarSuma.setBounds(590, 40, 140, 40);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel16.setText("n (columnas)");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(70, 60, 110, 17);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("MATRIZ A");
        jPanel1.add(jLabel17);
        jLabel17.setBounds(130, 90, 90, 17);

        jpSumaC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        javax.swing.GroupLayout jpSumaCLayout = new javax.swing.GroupLayout(jpSumaC);
        jpSumaC.setLayout(jpSumaCLayout);
        jpSumaCLayout.setHorizontalGroup(
            jpSumaCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 194, Short.MAX_VALUE)
        );
        jpSumaCLayout.setVerticalGroup(
            jpSumaCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 202, Short.MAX_VALUE)
        );

        jPanel1.add(jpSumaC);
        jpSumaC.setBounds(530, 110, 200, 208);

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("MATRIZ RESULTADO");
        jPanel1.add(jLabel22);
        jLabel22.setBounds(550, 90, 170, 17);

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("MATRIZ B");
        jPanel1.add(jLabel23);
        jLabel23.setBounds(360, 90, 90, 17);

        jTabbedPane1.addTab("Suma", jPanel1);

        jPanel2.setLayout(null);

        jtfmResta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel2.add(jtfmResta);
        jtfmResta.setBounds(190, 30, 68, 20);

        jtfnResta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel2.add(jtfnResta);
        jtfnResta.setBounds(190, 60, 68, 20);

        jbDimensionarResta.setFont(new java.awt.Font("Tahoma", 1, 14));
        jbDimensionarResta.setText("Dimensionar");
        jbDimensionarResta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDimensionarRestaActionPerformed(evt);
            }
        });
        jPanel2.add(jbDimensionarResta);
        jbDimensionarResta.setBounds(300, 40, 140, 40);

        jbCalcularResta.setFont(new java.awt.Font("Tahoma", 1, 14));
        jbCalcularResta.setText("Calcular");
        jbCalcularResta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCalcularRestaActionPerformed(evt);
            }
        });
        jPanel2.add(jbCalcularResta);
        jbCalcularResta.setBounds(450, 40, 130, 40);

        jbLimipiarResta.setFont(new java.awt.Font("Tahoma", 1, 14));
        jbLimipiarResta.setText("Limpiar");
        jbLimipiarResta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimipiarRestaActionPerformed(evt);
            }
        });
        jPanel2.add(jbLimipiarResta);
        jbLimipiarResta.setBounds(590, 40, 140, 40);

        jpRestaA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        javax.swing.GroupLayout jpRestaALayout = new javax.swing.GroupLayout(jpRestaA);
        jpRestaA.setLayout(jpRestaALayout);
        jpRestaALayout.setHorizontalGroup(
            jpRestaALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 197, Short.MAX_VALUE)
        );
        jpRestaALayout.setVerticalGroup(
            jpRestaALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 203, Short.MAX_VALUE)
        );

        jPanel2.add(jpRestaA);
        jpRestaA.setBounds(70, 110, 203, 209);

        jpRestaC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        javax.swing.GroupLayout jpRestaCLayout = new javax.swing.GroupLayout(jpRestaC);
        jpRestaC.setLayout(jpRestaCLayout);
        jpRestaCLayout.setHorizontalGroup(
            jpRestaCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 196, Short.MAX_VALUE)
        );
        jpRestaCLayout.setVerticalGroup(
            jpRestaCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 204, Short.MAX_VALUE)
        );

        jPanel2.add(jpRestaC);
        jpRestaC.setBounds(530, 110, 202, 210);

        jpRestaB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        javax.swing.GroupLayout jpRestaBLayout = new javax.swing.GroupLayout(jpRestaB);
        jpRestaB.setLayout(jpRestaBLayout);
        jpRestaBLayout.setHorizontalGroup(
            jpRestaBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 194, Short.MAX_VALUE)
        );
        jpRestaBLayout.setVerticalGroup(
            jpRestaBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 204, Short.MAX_VALUE)
        );

        jPanel2.add(jpRestaB);
        jpRestaB.setBounds(300, 110, 200, 210);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel2.setText("m (filas)");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(70, 30, 90, 17);

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel20.setText("n (columnas)");
        jPanel2.add(jLabel20);
        jLabel20.setBounds(70, 60, 110, 17);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("MATRIZ A");
        jPanel2.add(jLabel21);
        jLabel21.setBounds(130, 90, 90, 17);

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("MATRIZ B");
        jPanel2.add(jLabel25);
        jLabel25.setBounds(360, 90, 90, 17);

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("MATRIZ RESULTADO");
        jPanel2.add(jLabel26);
        jLabel26.setBounds(540, 90, 180, 17);

        jTabbedPane1.addTab("Resta", jPanel2);

        jPanel3.setLayout(null);

        jtfmMultA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel3.add(jtfmMultA);
        jtfmMultA.setBounds(130, 50, 68, 20);

        jtfnMultA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel3.add(jtfnMultA);
        jtfnMultA.setBounds(130, 80, 68, 20);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel5.setText("n (columnas)");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(10, 80, 110, 17);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel6.setText("m (filas)");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(10, 50, 60, 17);

        jtfmMultB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel3.add(jtfmMultB);
        jtfmMultB.setBounds(370, 50, 68, 20);

        jtfnMultB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel3.add(jtfnMultB);
        jtfnMultB.setBounds(370, 80, 68, 20);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel7.setText("n (columnas)");
        jPanel3.add(jLabel7);
        jLabel7.setBounds(250, 80, 110, 17);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel8.setText("m (filas)");
        jPanel3.add(jLabel8);
        jLabel8.setBounds(250, 50, 70, 17);

        jbDimensionarMultiplicacionA.setFont(new java.awt.Font("Tahoma", 1, 14));
        jbDimensionarMultiplicacionA.setText("Dimensionar A");
        jbDimensionarMultiplicacionA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDimensionarMultiplicacionAActionPerformed(evt);
            }
        });
        jPanel3.add(jbDimensionarMultiplicacionA);
        jbDimensionarMultiplicacionA.setBounds(470, 10, 150, 40);

        jbDimensionarMultiplicacionB.setFont(new java.awt.Font("Tahoma", 1, 14));
        jbDimensionarMultiplicacionB.setText("Dimensionar B");
        jbDimensionarMultiplicacionB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDimensionarMultiplicacionBActionPerformed(evt);
            }
        });
        jPanel3.add(jbDimensionarMultiplicacionB);
        jbDimensionarMultiplicacionB.setBounds(640, 10, 150, 40);

        jbCalcularMultiplicacion.setFont(new java.awt.Font("Tahoma", 1, 14));
        jbCalcularMultiplicacion.setText("Calcular");
        jbCalcularMultiplicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCalcularMultiplicacionActionPerformed(evt);
            }
        });
        jPanel3.add(jbCalcularMultiplicacion);
        jbCalcularMultiplicacion.setBounds(470, 60, 150, 40);

        jpMultB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        javax.swing.GroupLayout jpMultBLayout = new javax.swing.GroupLayout(jpMultB);
        jpMultB.setLayout(jpMultBLayout);
        jpMultBLayout.setHorizontalGroup(
            jpMultBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 199, Short.MAX_VALUE)
        );
        jpMultBLayout.setVerticalGroup(
            jpMultBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 204, Short.MAX_VALUE)
        );

        jPanel3.add(jpMultB);
        jpMultB.setBounds(290, 140, 205, 210);

        jpMultA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        javax.swing.GroupLayout jpMultALayout = new javax.swing.GroupLayout(jpMultA);
        jpMultA.setLayout(jpMultALayout);
        jpMultALayout.setHorizontalGroup(
            jpMultALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 197, Short.MAX_VALUE)
        );
        jpMultALayout.setVerticalGroup(
            jpMultALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 203, Short.MAX_VALUE)
        );

        jPanel3.add(jpMultA);
        jpMultA.setBounds(60, 140, 203, 209);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("MATRIZ B");
        jPanel3.add(jLabel18);
        jLabel18.setBounds(350, 120, 90, 14);

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("MATRIZ RESULTADO");
        jPanel3.add(jLabel19);
        jLabel19.setBounds(540, 120, 160, 14);

        jpMultC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        javax.swing.GroupLayout jpMultCLayout = new javax.swing.GroupLayout(jpMultC);
        jpMultC.setLayout(jpMultCLayout);
        jpMultCLayout.setHorizontalGroup(
            jpMultCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 195, Short.MAX_VALUE)
        );
        jpMultCLayout.setVerticalGroup(
            jpMultCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 204, Short.MAX_VALUE)
        );

        jPanel3.add(jpMultC);
        jpMultC.setBounds(520, 140, 201, 210);

        jbLimpiarMultiplicacion.setFont(new java.awt.Font("Tahoma", 1, 14));
        jbLimpiarMultiplicacion.setText("Limpiar");
        jbLimpiarMultiplicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimpiarMultiplicacionActionPerformed(evt);
            }
        });
        jPanel3.add(jbLimpiarMultiplicacion);
        jbLimpiarMultiplicacion.setBounds(640, 60, 150, 40);

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("MATRIZ A");
        jPanel3.add(jLabel24);
        jLabel24.setBounds(120, 120, 90, 14);

        jTabbedPane1.addTab("Multipilcacion", jPanel3);

        jPanel4.setLayout(null);

        jtfmMultK.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel4.add(jtfmMultK);
        jtfmMultK.setBounds(130, 10, 68, 20);

        jtfnMultK.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel4.add(jtfnMultK);
        jtfnMultK.setBounds(130, 40, 68, 20);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel9.setText("n (columnas)");
        jPanel4.add(jLabel9);
        jLabel9.setBounds(10, 40, 110, 17);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("MATRIZ RESULTADO");
        jPanel4.add(jLabel10);
        jLabel10.setBounds(420, 110, 180, 17);

        jtfK.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel4.add(jtfK);
        jtfK.setBounds(130, 70, 68, 20);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel15.setText("K");
        jPanel4.add(jLabel15);
        jLabel15.setBounds(10, 70, 60, 10);

        jbDimensionarMultK.setFont(new java.awt.Font("Tahoma", 1, 14));
        jbDimensionarMultK.setText("Dimensionar");
        jbDimensionarMultK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDimensionarMultKActionPerformed(evt);
            }
        });
        jPanel4.add(jbDimensionarMultK);
        jbDimensionarMultK.setBounds(250, 30, 140, 40);

        jbCalcularMultK.setFont(new java.awt.Font("Tahoma", 1, 14));
        jbCalcularMultK.setText("Calcular");
        jbCalcularMultK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCalcularMultKActionPerformed(evt);
            }
        });
        jPanel4.add(jbCalcularMultK);
        jbCalcularMultK.setBounds(410, 30, 140, 40);

        jbLimipiarMultK.setFont(new java.awt.Font("Tahoma", 1, 14));
        jbLimipiarMultK.setText("Limpiar");
        jbLimipiarMultK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimipiarMultKActionPerformed(evt);
            }
        });
        jPanel4.add(jbLimipiarMultK);
        jbLimipiarMultK.setBounds(570, 30, 140, 40);

        jpMultK.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        javax.swing.GroupLayout jpMultKLayout = new javax.swing.GroupLayout(jpMultK);
        jpMultK.setLayout(jpMultKLayout);
        jpMultKLayout.setHorizontalGroup(
            jpMultKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 199, Short.MAX_VALUE)
        );
        jpMultKLayout.setVerticalGroup(
            jpMultKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 205, Short.MAX_VALUE)
        );

        jPanel4.add(jpMultK);
        jpMultK.setBounds(120, 130, 205, 211);

        jpMultKRES.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        javax.swing.GroupLayout jpMultKRESLayout = new javax.swing.GroupLayout(jpMultKRES);
        jpMultKRES.setLayout(jpMultKRESLayout);
        jpMultKRESLayout.setHorizontalGroup(
            jpMultKRESLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 197, Short.MAX_VALUE)
        );
        jpMultKRESLayout.setVerticalGroup(
            jpMultKRESLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 204, Short.MAX_VALUE)
        );

        jPanel4.add(jpMultKRES);
        jpMultKRES.setBounds(410, 130, 203, 210);

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel27.setText("m (filas)");
        jPanel4.add(jLabel27);
        jLabel27.setBounds(10, 14, 90, 17);

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("MATRIZ A");
        jPanel4.add(jLabel28);
        jLabel28.setBounds(170, 110, 90, 17);

        jTabbedPane1.addTab("MUL K", jPanel4);

        jPanel5.setLayout(null);

        jtfmTrans.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel5.add(jtfmTrans);
        jtfmTrans.setBounds(130, 10, 68, 20);

        jtfnTrans.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel5.add(jtfnTrans);
        jtfnTrans.setBounds(130, 40, 68, 20);

        jpTransA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        javax.swing.GroupLayout jpTransALayout = new javax.swing.GroupLayout(jpTransA);
        jpTransA.setLayout(jpTransALayout);
        jpTransALayout.setHorizontalGroup(
            jpTransALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 199, Short.MAX_VALUE)
        );
        jpTransALayout.setVerticalGroup(
            jpTransALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 205, Short.MAX_VALUE)
        );

        jPanel5.add(jpTransA);
        jpTransA.setBounds(120, 130, 205, 211);

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("MATRIZ A");
        jPanel5.add(jLabel29);
        jLabel29.setBounds(170, 110, 90, 17);

        jpTransRES.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        javax.swing.GroupLayout jpTransRESLayout = new javax.swing.GroupLayout(jpTransRES);
        jpTransRES.setLayout(jpTransRESLayout);
        jpTransRESLayout.setHorizontalGroup(
            jpTransRESLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 197, Short.MAX_VALUE)
        );
        jpTransRESLayout.setVerticalGroup(
            jpTransRESLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 204, Short.MAX_VALUE)
        );

        jPanel5.add(jpTransRES);
        jpTransRES.setBounds(410, 130, 203, 210);

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("MATRIZ RESULTADO");
        jPanel5.add(jLabel30);
        jLabel30.setBounds(420, 110, 180, 17);

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel31.setText("m (filas)");
        jPanel5.add(jLabel31);
        jLabel31.setBounds(10, 14, 90, 17);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel11.setText("n (columnas)");
        jPanel5.add(jLabel11);
        jLabel11.setBounds(10, 40, 110, 17);

        jbDimensionarTrans.setFont(new java.awt.Font("Tahoma", 1, 14));
        jbDimensionarTrans.setText("Dimensionar");
        jbDimensionarTrans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDimensionarTransActionPerformed(evt);
            }
        });
        jPanel5.add(jbDimensionarTrans);
        jbDimensionarTrans.setBounds(250, 30, 140, 40);

        jbCalcularTrans.setFont(new java.awt.Font("Tahoma", 1, 14));
        jbCalcularTrans.setText("Calcular");
        jbCalcularTrans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCalcularTransActionPerformed(evt);
            }
        });
        jPanel5.add(jbCalcularTrans);
        jbCalcularTrans.setBounds(410, 30, 140, 40);

        jbLimipiarTrans.setFont(new java.awt.Font("Tahoma", 1, 14));
        jbLimipiarTrans.setText("Limpiar");
        jbLimipiarTrans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimipiarTransActionPerformed(evt);
            }
        });
        jPanel5.add(jbLimipiarTrans);
        jbLimipiarTrans.setBounds(570, 30, 140, 40);

        jTabbedPane1.addTab("Transpuesta", jPanel5);

        jPanel6.setLayout(null);

        jpInversaRES.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        javax.swing.GroupLayout jpInversaRESLayout = new javax.swing.GroupLayout(jpInversaRES);
        jpInversaRES.setLayout(jpInversaRESLayout);
        jpInversaRESLayout.setHorizontalGroup(
            jpInversaRESLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 197, Short.MAX_VALUE)
        );
        jpInversaRESLayout.setVerticalGroup(
            jpInversaRESLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 204, Short.MAX_VALUE)
        );

        jPanel6.add(jpInversaRES);
        jpInversaRES.setBounds(410, 130, 203, 210);

        jpInversaA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        javax.swing.GroupLayout jpInversaALayout = new javax.swing.GroupLayout(jpInversaA);
        jpInversaA.setLayout(jpInversaALayout);
        jpInversaALayout.setHorizontalGroup(
            jpInversaALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 199, Short.MAX_VALUE)
        );
        jpInversaALayout.setVerticalGroup(
            jpInversaALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 205, Short.MAX_VALUE)
        );

        jPanel6.add(jpInversaA);
        jpInversaA.setBounds(120, 130, 205, 211);

        jbDimensionarInv.setFont(new java.awt.Font("Tahoma", 1, 14));
        jbDimensionarInv.setText("Dimensionar");
        jbDimensionarInv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDimensionarInvActionPerformed(evt);
            }
        });
        jPanel6.add(jbDimensionarInv);
        jbDimensionarInv.setBounds(250, 30, 140, 40);

        jbCalcularInv.setFont(new java.awt.Font("Tahoma", 1, 14));
        jbCalcularInv.setText("Calcular");
        jbCalcularInv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCalcularInvActionPerformed(evt);
            }
        });
        jPanel6.add(jbCalcularInv);
        jbCalcularInv.setBounds(410, 30, 140, 40);

        jbLimipiarInv.setFont(new java.awt.Font("Tahoma", 1, 14));
        jbLimipiarInv.setText("Limpiar");
        jbLimipiarInv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimipiarInvActionPerformed(evt);
            }
        });
        jPanel6.add(jbLimipiarInv);
        jbLimipiarInv.setBounds(570, 30, 140, 40);

        jtfnInv.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel6.add(jtfnInv);
        jtfnInv.setBounds(130, 40, 68, 20);

        jtfmInv.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel6.add(jtfmInv);
        jtfmInv.setBounds(130, 10, 68, 20);

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel32.setText("m (filas)");
        jPanel6.add(jLabel32);
        jLabel32.setBounds(10, 14, 90, 17);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel12.setText("n (columnas)");
        jPanel6.add(jLabel12);
        jLabel12.setBounds(10, 40, 110, 17);

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("MATRIZ A");
        jPanel6.add(jLabel33);
        jLabel33.setBounds(170, 110, 90, 17);

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("MATRIZ RESULTADO");
        jPanel6.add(jLabel34);
        jLabel34.setBounds(420, 110, 180, 17);

        jTabbedPane1.addTab("Inversa", jPanel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 811, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbDimensionarSumaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDimensionarSumaActionPerformed
        if (jtfmSuma.getText().trim().length() == 0 || jtfnSuma.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "INGRESE CORRECTAMENTE LAS DIMENSIONES", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {
            int col = Integer.parseInt(jtfnSuma.getText());
            int fil = Integer.parseInt(jtfmSuma.getText());
            obtenerDimension(fil, col);
            redimSuma(fil, col);
        }
    }//GEN-LAST:event_jbDimensionarSumaActionPerformed

        private void jbCalcularSumaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCalcularSumaActionPerformed
            try {
                limpiarResSuma();
                llenarMatricesSuma(FILAS, COLUMNAS);
            } catch (FraccionFormatException ex) {
                Logger.getLogger(FormMatrices.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MatrizNoOperableException ex) {
                Logger.getLogger(FormMatrices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }//GEN-LAST:event_jbCalcularSumaActionPerformed

        private void jbLimipiarSumaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimipiarSumaActionPerformed
            nuevoSuma();
            limpiarResSuma();
            this.jtfmSuma.setText("");
            this.jtfnSuma.setText("");
        }//GEN-LAST:event_jbLimipiarSumaActionPerformed

        private void jbDimensionarRestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDimensionarRestaActionPerformed
            if (jtfmResta.getText().trim().length() == 0 || jtfnResta.getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(this, "INGRESE CORRECTAMENTE LAS DIMENSIONES", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else {
                int col = Integer.parseInt(jtfnResta.getText());
                int fil = Integer.parseInt(jtfmResta.getText());
                obtenerDimension(fil, col);
                redimResta(fil, col);
            }
        }//GEN-LAST:event_jbDimensionarRestaActionPerformed

        private void jbCalcularRestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCalcularRestaActionPerformed
            try {
                limpiarResResta();
                llenarMatricesResta(FILAS, COLUMNAS);
            } catch (FraccionFormatException ex) {
                Logger.getLogger(FormMatrices.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MatrizNoOperableException ex) {
                Logger.getLogger(FormMatrices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }//GEN-LAST:event_jbCalcularRestaActionPerformed

        private void jbLimipiarRestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimipiarRestaActionPerformed
            nuevoResta();
            limpiarResResta();
            this.jtfmResta.setText("");
            this.jtfnResta.setText("");
        }//GEN-LAST:event_jbLimipiarRestaActionPerformed

        private void jbDimensionarMultiplicacionAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDimensionarMultiplicacionAActionPerformed
            if (jtfmMultA.getText().trim().length() == 0 || jtfnMultA.getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(this, "INGRESE CORRECTAMENTE LAS DIMENSIONES", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else {
                int col = Integer.parseInt(jtfnMultA.getText());
                int fil = Integer.parseInt(jtfmMultA.getText());
                obtenerDimensionA(fil, col);
                redimMultA(fil, col);
            }
        }//GEN-LAST:event_jbDimensionarMultiplicacionAActionPerformed

        private void jbDimensionarMultiplicacionBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDimensionarMultiplicacionBActionPerformed
            if (jtfmMultB.getText().trim().length() == 0 || jtfnMultB.getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(this, "INGRESE CORRECTAMENTE LAS DIMENSIONES", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else {
                int col = Integer.parseInt(jtfnMultB.getText());
                int fil = Integer.parseInt(jtfmMultB.getText());
                obtenerDimensionB(fil, col);
                redimMultB(fil, col);
            }
        }//GEN-LAST:event_jbDimensionarMultiplicacionBActionPerformed

        private void jbCalcularMultiplicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCalcularMultiplicacionActionPerformed
            if (FILAS_A == COLUMNAS_B) {
                try {
                    limpiarResMult();
                    llenarMatricesMultiplicacionA(FILAS_A, COLUMNAS_A);
                    llenarMatricesMultiplicacionB(FILAS_B, COLUMNAS_B);
                    llenarMatrizResultadoMult(FILAS_A, COLUMNAS_B);
                } catch (FraccionFormatException ex) {
                    Logger.getLogger(FormMatrices.class.getName()).log(Level.SEVERE, null, ex);
                } catch (MatrizNoOperableException ex) {
                    Logger.getLogger(FormMatrices.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(this, "INGRESE CORRECTAMENTE LAS DIMENSIONES", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        }//GEN-LAST:event_jbCalcularMultiplicacionActionPerformed

        private void jbLimpiarMultiplicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimpiarMultiplicacionActionPerformed
            nuevoMultA();
            nuevoMultB();
            limpiarResMult();
            this.jtfmMultA.setText("");
            this.jtfnMultA.setText("");
            this.jtfmMultB.setText("");
            this.jtfnMultB.setText("");
        }//GEN-LAST:event_jbLimpiarMultiplicacionActionPerformed

        private void jbDimensionarMultKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDimensionarMultKActionPerformed
            // TODO add your handling code here:
            if (jtfmMultK.getText().trim().length() == 0 || jtfnMultK.getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(this, "INGRESE CORRECTAMENTE LAS DIMENSIONES", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else {
                int col = Integer.parseInt(jtfnMultK.getText());
                int fil = Integer.parseInt(jtfmMultK.getText());
                this.jtfK.setEnabled(true);
                obtenerDimension(fil, col);
                redim_multK(fil, col);
            }
        }//GEN-LAST:event_jbDimensionarMultKActionPerformed

        private void jbCalcularMultKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCalcularMultKActionPerformed
            // TODO add your handling code here:
            try {
                limpiarResMultK();
                llenarMatricesMultK(FILAS, COLUMNAS);
                mostrarPanelResK(FILAS, COLUMNAS, matrizA, matrizB);

            } catch (FraccionFormatException ex) {
                Logger.getLogger(FormMatrices.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MatrizNoOperableException ex) {
                Logger.getLogger(FormMatrices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }//GEN-LAST:event_jbCalcularMultKActionPerformed

        private void jbLimipiarMultKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimipiarMultKActionPerformed
            // TODO add your handling code here:
            nuevoMultK();
            limpiarResMultK();
            this.jtfmMultK.setText("");
            this.jtfnMultK.setText("");
            this.jtfK.setEnabled(false);
            this.jtfK.setText("");
        }//GEN-LAST:event_jbLimipiarMultKActionPerformed

        private void jbDimensionarTransActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDimensionarTransActionPerformed
            // TODO add your handling code here:            
            if (jtfmTrans.getText().trim().length() == 0 || jtfnTrans.getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(this, "INGRESE CORRECTAMENTE LAS DIMENSIONES", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else {
                int col = Integer.parseInt(jtfnTrans.getText());
                int fil = Integer.parseInt(jtfmTrans.getText());
                obtenerDimension(fil, col);
                redim_Trans(fil, col);
            }
        }//GEN-LAST:event_jbDimensionarTransActionPerformed

        private void jbCalcularTransActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCalcularTransActionPerformed
            // TODO add your handling code here:
            if (jtfmTrans.getText().equals(jtfnTrans.getText())) {
                try {
                limpiarResTrans();
                llenarMatricesTrans(FILAS, COLUMNAS);
                mostrarPanelTrans(FILAS, COLUMNAS, matrizA);
            } catch (FraccionFormatException ex) {
                Logger.getLogger(FormMatrices.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MatrizNoOperableException ex) {
                Logger.getLogger(FormMatrices.class.getName()).log(Level.SEVERE, null, ex);
            }
            } else {
                JOptionPane.showMessageDialog(this, "LA MATRIZ DEBE SER CUADRADA", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        }//GEN-LAST:event_jbCalcularTransActionPerformed

        private void jbLimipiarTransActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimipiarTransActionPerformed
            // TODO add your handling code here:
            nuevoTrans();
            limpiarResTrans();
            this.jtfmTrans.setText("");
            this.jtfnTrans.setText("");
        }//GEN-LAST:event_jbLimipiarTransActionPerformed

        private void jbDimensionarInvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDimensionarInvActionPerformed
            // TODO add your handling code here:
            if (jtfmInv.getText().trim().length() == 0 || jtfnInv.getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(this, "INGRESE CORRECTAMENTE LAS DIMENSIONES", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else {
                int col = Integer.parseInt(jtfnInv.getText());
                int fil = Integer.parseInt(jtfmInv.getText());
                obtenerDimension(fil, col);
                redim_Inv(fil, col);
            }
        }//GEN-LAST:event_jbDimensionarInvActionPerformed

        private void jbCalcularInvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCalcularInvActionPerformed
            // TODO add your handling code here:
            try {
                limpiarResInv();
                llenarMatricesInv(FILAS, COLUMNAS);
                mostrarPanelInv(FILAS, COLUMNAS, matrizA);
            } catch (FraccionFormatException ex) {
                Logger.getLogger(FormMatrices.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MatrizNoOperableException ex) {
                Logger.getLogger(FormMatrices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }//GEN-LAST:event_jbCalcularInvActionPerformed

        private void jbLimipiarInvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimipiarInvActionPerformed
            // TODO add your handling code here:
            nuevoInv();
            limpiarResInv();
            this.jtfmInv.setText("");
            this.jtfnInv.setText("");
        }//GEN-LAST:event_jbLimipiarInvActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FormMatrices().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton jbCalcularInv;
    private javax.swing.JButton jbCalcularMultK;
    private javax.swing.JButton jbCalcularMultiplicacion;
    private javax.swing.JButton jbCalcularResta;
    private javax.swing.JButton jbCalcularSuma;
    private javax.swing.JButton jbCalcularTrans;
    private javax.swing.JButton jbDimensionarInv;
    private javax.swing.JButton jbDimensionarMultK;
    private javax.swing.JButton jbDimensionarMultiplicacionA;
    private javax.swing.JButton jbDimensionarMultiplicacionB;
    private javax.swing.JButton jbDimensionarResta;
    private javax.swing.JButton jbDimensionarSuma;
    private javax.swing.JButton jbDimensionarTrans;
    private javax.swing.JButton jbLimipiarInv;
    private javax.swing.JButton jbLimipiarMultK;
    private javax.swing.JButton jbLimipiarResta;
    private javax.swing.JButton jbLimipiarSuma;
    private javax.swing.JButton jbLimipiarTrans;
    private javax.swing.JButton jbLimpiarMultiplicacion;
    private javax.swing.JPanel jpInversaA;
    private javax.swing.JPanel jpInversaRES;
    private javax.swing.JPanel jpMultA;
    private javax.swing.JPanel jpMultB;
    private javax.swing.JPanel jpMultC;
    private javax.swing.JPanel jpMultK;
    private javax.swing.JPanel jpMultKRES;
    private javax.swing.JPanel jpRestaA;
    private javax.swing.JPanel jpRestaB;
    private javax.swing.JPanel jpRestaC;
    private javax.swing.JPanel jpSumaA;
    private javax.swing.JPanel jpSumaB;
    private javax.swing.JPanel jpSumaC;
    private javax.swing.JPanel jpTransA;
    private javax.swing.JPanel jpTransRES;
    private javax.swing.JTextField jtfK;
    private javax.swing.JTextField jtfmInv;
    private javax.swing.JTextField jtfmMultA;
    private javax.swing.JTextField jtfmMultB;
    private javax.swing.JTextField jtfmMultK;
    private javax.swing.JTextField jtfmResta;
    private javax.swing.JTextField jtfmSuma;
    private javax.swing.JTextField jtfmTrans;
    private javax.swing.JTextField jtfnInv;
    private javax.swing.JTextField jtfnMultA;
    private javax.swing.JTextField jtfnMultB;
    private javax.swing.JTextField jtfnMultK;
    private javax.swing.JTextField jtfnResta;
    private javax.swing.JTextField jtfnSuma;
    private javax.swing.JTextField jtfnTrans;
    // End of variables declaration//GEN-END:variables
}
