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
        this.jbLimipiarSuma.setEnabled(false);
        this.jbCalcularSuma.setEnabled(false);
        this.jbLimipiarResta.setEnabled(false);
        this.jbCalcularResta.setEnabled(false);
        this.jbCalcularMultiplicacion.setEnabled(false);
        this.jbLimpiarMultiplicacion.setEnabled(false);
        this.jbCalcularMultK.setEnabled(false);
        this.jbLimipiarMultK.setEnabled(false);
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
            jbCalcularSuma.setEnabled(true);
            jbLimipiarSuma.setEnabled(true);
        } else {
            if (f == 0 || c == 0) {
                nuevoSuma();
                jbCalcularSuma.setEnabled(false);
                jbLimipiarSuma.setEnabled(false);
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
            jbCalcularResta.setEnabled(true);
            jbLimipiarResta.setEnabled(true);
        } else {
            if (f == 0 || c == 0) {
                nuevoResta();
                jbCalcularResta.setEnabled(false);
                jbLimipiarResta.setEnabled(false);
            }
        }
    }

    public void llenarPanelesResta(int fila, int columna) {
        jtA[fila][columna] = new JTextField();
        jtA[fila][columna].setEditable(true);
        jpRestaA.add(jtA[fila][columna]);
        jtA[fila][columna].setHorizontalAlignment(JTextField.CENTER);
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
            jbCalcularMultiplicacion.setEnabled(true);
            jbLimpiarMultiplicacion.setEnabled(true);
        } else {
            if (f == 0 || c == 0) {
                nuevoMultA();
                jbCalcularMultiplicacion.setEnabled(false);
                jbLimpiarMultiplicacion.setEnabled(false);
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
            jbCalcularMultiplicacion.setEnabled(true);
            jbLimpiarMultiplicacion.setEnabled(true);
        } else {
            if (f == 0 || c == 0) {
                nuevoMultB();
                jbCalcularMultiplicacion.setEnabled(false);
                jbLimpiarMultiplicacion.setEnabled(false);
            }
        }
    }

    public void llenarPanelesMultA(int fila, int columna) {
        jtA[fila][columna] = new JTextField();
        jtA[fila][columna].setEditable(true);
        jpMultA.add(jtA[fila][columna]);
        jtA[fila][columna].setHorizontalAlignment(JTextField.CENTER);
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
            jbCalcularMultK.setEnabled(true);
            jbLimipiarMultK.setEnabled(true);
        } else {
            if (f == 0 || c == 0) {
                nuevoMultK();
                jbCalcularMultK.setEnabled(false);
                jbLimipiarMultK.setEnabled(false);
            }
        }
    }

    public void llenarPanelMultK(int fila, int columna) {
        jtA[fila][columna] = new JTextField();
        jtA[fila][columna].setEditable(true);
        jpMultK.add(jtA[fila][columna]);
        jtA[fila][columna].setHorizontalAlignment(JTextField.CENTER);
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

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDSuma = new javax.swing.JDialog();
        jPanel7 = new javax.swing.JPanel();
        jpSumaC = new javax.swing.JPanel();
        jDResta = new javax.swing.JDialog();
        jpRestaC = new javax.swing.JPanel();
        jDMult = new javax.swing.JDialog();
        jpMultC = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jtfmSuma = new javax.swing.JTextField();
        jtfnSuma = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jpSumaA = new javax.swing.JPanel();
        jpSumaB = new javax.swing.JPanel();
        jbDimensionarSuma = new javax.swing.JButton();
        jbCalcularSuma = new javax.swing.JButton();
        jbLimipiarSuma = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jtfmResta = new javax.swing.JTextField();
        jtfnResta = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jbDimensionarResta = new javax.swing.JButton();
        jbCalcularResta = new javax.swing.JButton();
        jbLimipiarResta = new javax.swing.JButton();
        jpRestaB = new javax.swing.JPanel();
        jpRestaA = new javax.swing.JPanel();
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
        jbLimpiarMultiplicacion = new javax.swing.JButton();
        jpMultB = new javax.swing.JPanel();
        jpMultA = new javax.swing.JPanel();
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
        jPanel5 = new javax.swing.JPanel();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jTextField13 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        jDSuma.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDSuma.setMinimumSize(new java.awt.Dimension(341, 318));
        jDSuma.setModal(true);
        jDSuma.setResizable(false);

        jPanel7.setLayout(null);

        jpSumaC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        javax.swing.GroupLayout jpSumaCLayout = new javax.swing.GroupLayout(jpSumaC);
        jpSumaC.setLayout(jpSumaCLayout);
        jpSumaCLayout.setHorizontalGroup(
            jpSumaCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 234, Short.MAX_VALUE)
        );
        jpSumaCLayout.setVerticalGroup(
            jpSumaCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 234, Short.MAX_VALUE)
        );

        jPanel7.add(jpSumaC);
        jpSumaC.setBounds(50, 20, 240, 240);

        javax.swing.GroupLayout jDSumaLayout = new javax.swing.GroupLayout(jDSuma.getContentPane());
        jDSuma.getContentPane().setLayout(jDSumaLayout);
        jDSumaLayout.setHorizontalGroup(
            jDSumaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jDSumaLayout.setVerticalGroup(
            jDSumaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDSumaLayout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jDResta.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDResta.setMinimumSize(new java.awt.Dimension(341, 318));
        jDResta.setModal(true);
        jDResta.setResizable(false);
        jDResta.getContentPane().setLayout(null);

        jpRestaC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        javax.swing.GroupLayout jpRestaCLayout = new javax.swing.GroupLayout(jpRestaC);
        jpRestaC.setLayout(jpRestaCLayout);
        jpRestaCLayout.setHorizontalGroup(
            jpRestaCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 247, Short.MAX_VALUE)
        );
        jpRestaCLayout.setVerticalGroup(
            jpRestaCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 232, Short.MAX_VALUE)
        );

        jDResta.getContentPane().add(jpRestaC);
        jpRestaC.setBounds(40, 30, 0, 0);

        jDMult.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDMult.setMinimumSize(new java.awt.Dimension(336, 300));
        jDMult.setModal(true);
        jDMult.setResizable(false);
        jDMult.getContentPane().setLayout(null);

        jpMultC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        javax.swing.GroupLayout jpMultCLayout = new javax.swing.GroupLayout(jpMultC);
        jpMultC.setLayout(jpMultCLayout);
        jpMultCLayout.setHorizontalGroup(
            jpMultCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 264, Short.MAX_VALUE)
        );
        jpMultCLayout.setVerticalGroup(
            jpMultCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
        );

        jDMult.getContentPane().add(jpMultC);
        jpMultC.setBounds(30, 23, 0, 0);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(485, 336));
        setResizable(false);

        jPanel1.setLayout(null);
        jPanel1.add(jtfmSuma);
        jtfmSuma.setBounds(83, 12, 68, 20);
        jPanel1.add(jtfnSuma);
        jtfnSuma.setBounds(83, 40, 68, 20);

        jLabel1.setText("m (filas)");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 15, 38, 14);

        jLabel2.setText("n (columnas)");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(10, 43, 61, 14);

        jpSumaA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jpSumaALayout = new javax.swing.GroupLayout(jpSumaA);
        jpSumaA.setLayout(jpSumaALayout);
        jpSumaALayout.setHorizontalGroup(
            jpSumaALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 201, Short.MAX_VALUE)
        );
        jpSumaALayout.setVerticalGroup(
            jpSumaALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 207, Short.MAX_VALUE)
        );

        jPanel1.add(jpSumaA);
        jpSumaA.setBounds(10, 66, 203, 209);

        jpSumaB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jpSumaBLayout = new javax.swing.GroupLayout(jpSumaB);
        jpSumaB.setLayout(jpSumaBLayout);
        jpSumaBLayout.setHorizontalGroup(
            jpSumaBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 202, Short.MAX_VALUE)
        );
        jpSumaBLayout.setVerticalGroup(
            jpSumaBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 207, Short.MAX_VALUE)
        );

        jPanel1.add(jpSumaB);
        jpSumaB.setBounds(250, 70, 204, 209);

        jbDimensionarSuma.setText("Dimensionar");
        jbDimensionarSuma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDimensionarSumaActionPerformed(evt);
            }
        });
        jPanel1.add(jbDimensionarSuma);
        jbDimensionarSuma.setBounds(189, 11, 91, 23);

        jbCalcularSuma.setText("Calcular");
        jbCalcularSuma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCalcularSumaActionPerformed(evt);
            }
        });
        jPanel1.add(jbCalcularSuma);
        jbCalcularSuma.setBounds(286, 11, 71, 23);

        jbLimipiarSuma.setText("Limpiar");
        jbLimipiarSuma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimipiarSumaActionPerformed(evt);
            }
        });
        jPanel1.add(jbLimipiarSuma);
        jbLimipiarSuma.setBounds(363, 11, 65, 23);

        jTabbedPane1.addTab("Suma", jPanel1);

        jPanel2.setLayout(null);
        jPanel2.add(jtfmResta);
        jtfmResta.setBounds(83, 11, 68, 20);
        jPanel2.add(jtfnResta);
        jtfnResta.setBounds(83, 37, 68, 20);

        jLabel3.setText("n (columnas)");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(10, 40, 61, 14);

        jLabel4.setText("m (filas)");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(10, 14, 38, 14);

        jbDimensionarResta.setText("Dimensionar");
        jbDimensionarResta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDimensionarRestaActionPerformed(evt);
            }
        });
        jPanel2.add(jbDimensionarResta);
        jbDimensionarResta.setBounds(189, 11, 91, 23);

        jbCalcularResta.setText("Calcular");
        jbCalcularResta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCalcularRestaActionPerformed(evt);
            }
        });
        jPanel2.add(jbCalcularResta);
        jbCalcularResta.setBounds(286, 11, 71, 23);

        jbLimipiarResta.setText("Limpiar");
        jbLimipiarResta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimipiarRestaActionPerformed(evt);
            }
        });
        jPanel2.add(jbLimipiarResta);
        jbLimipiarResta.setBounds(363, 11, 65, 23);

        jpRestaB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jpRestaBLayout = new javax.swing.GroupLayout(jpRestaB);
        jpRestaB.setLayout(jpRestaBLayout);
        jpRestaBLayout.setHorizontalGroup(
            jpRestaBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 202, Short.MAX_VALUE)
        );
        jpRestaBLayout.setVerticalGroup(
            jpRestaBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 207, Short.MAX_VALUE)
        );

        jPanel2.add(jpRestaB);
        jpRestaB.setBounds(240, 70, 204, 209);

        jpRestaA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jpRestaALayout = new javax.swing.GroupLayout(jpRestaA);
        jpRestaA.setLayout(jpRestaALayout);
        jpRestaALayout.setHorizontalGroup(
            jpRestaALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 201, Short.MAX_VALUE)
        );
        jpRestaALayout.setVerticalGroup(
            jpRestaALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 207, Short.MAX_VALUE)
        );

        jPanel2.add(jpRestaA);
        jpRestaA.setBounds(10, 66, 203, 209);

        jTabbedPane1.addTab("Resta", jPanel2);

        jPanel3.setLayout(null);
        jPanel3.add(jtfmMultA);
        jtfmMultA.setBounds(83, 17, 68, 20);
        jPanel3.add(jtfnMultA);
        jtfnMultA.setBounds(83, 43, 68, 20);

        jLabel5.setText("n (columnas)");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(10, 46, 61, 14);

        jLabel6.setText("m (filas)");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(10, 20, 38, 14);
        jPanel3.add(jtfmMultB);
        jtfmMultB.setBounds(256, 12, 68, 20);
        jPanel3.add(jtfnMultB);
        jtfnMultB.setBounds(256, 41, 68, 20);

        jLabel7.setText("n (columnas)");
        jPanel3.add(jLabel7);
        jLabel7.setBounds(183, 44, 61, 14);

        jLabel8.setText("m (filas)");
        jPanel3.add(jLabel8);
        jLabel8.setBounds(183, 15, 38, 14);

        jbDimensionarMultiplicacionA.setText("Dimensionar A");
        jbDimensionarMultiplicacionA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDimensionarMultiplicacionAActionPerformed(evt);
            }
        });
        jPanel3.add(jbDimensionarMultiplicacionA);
        jbDimensionarMultiplicacionA.setBounds(356, 11, 101, 23);

        jbDimensionarMultiplicacionB.setText("Dimensionar B");
        jbDimensionarMultiplicacionB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDimensionarMultiplicacionBActionPerformed(evt);
            }
        });
        jPanel3.add(jbDimensionarMultiplicacionB);
        jbDimensionarMultiplicacionB.setBounds(467, 11, 99, 23);

        jbCalcularMultiplicacion.setText("Calcular");
        jbCalcularMultiplicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCalcularMultiplicacionActionPerformed(evt);
            }
        });
        jPanel3.add(jbCalcularMultiplicacion);
        jbCalcularMultiplicacion.setBounds(360, 40, 71, 23);

        jbLimpiarMultiplicacion.setText("Limpiar");
        jbLimpiarMultiplicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimpiarMultiplicacionActionPerformed(evt);
            }
        });
        jPanel3.add(jbLimpiarMultiplicacion);
        jbLimpiarMultiplicacion.setBounds(467, 40, 65, 23);

        jpMultB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jpMultBLayout = new javax.swing.GroupLayout(jpMultB);
        jpMultB.setLayout(jpMultBLayout);
        jpMultBLayout.setHorizontalGroup(
            jpMultBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 203, Short.MAX_VALUE)
        );
        jpMultBLayout.setVerticalGroup(
            jpMultBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 209, Short.MAX_VALUE)
        );

        jPanel3.add(jpMultB);
        jpMultB.setBounds(260, 80, 205, 211);

        jpMultA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jpMultALayout = new javax.swing.GroupLayout(jpMultA);
        jpMultA.setLayout(jpMultALayout);
        jpMultALayout.setHorizontalGroup(
            jpMultALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 201, Short.MAX_VALUE)
        );
        jpMultALayout.setVerticalGroup(
            jpMultALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 207, Short.MAX_VALUE)
        );

        jPanel3.add(jpMultA);
        jpMultA.setBounds(20, 80, 203, 209);

        jTabbedPane1.addTab("Multipilcacion", jPanel3);

        jPanel4.setLayout(null);
        jPanel4.add(jtfmMultK);
        jtfmMultK.setBounds(95, 11, 68, 20);
        jPanel4.add(jtfnMultK);
        jtfnMultK.setBounds(95, 37, 68, 20);

        jLabel9.setText("n (columnas)");
        jPanel4.add(jLabel9);
        jLabel9.setBounds(10, 40, 61, 14);

        jLabel10.setText("m (filas)");
        jPanel4.add(jLabel10);
        jLabel10.setBounds(10, 14, 38, 14);
        jPanel4.add(jtfK);
        jtfK.setBounds(95, 68, 68, 20);

        jLabel15.setText("K");
        jPanel4.add(jLabel15);
        jLabel15.setBounds(10, 71, 6, 14);

        jbDimensionarMultK.setText("Dimensionar");
        jbDimensionarMultK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDimensionarMultKActionPerformed(evt);
            }
        });
        jPanel4.add(jbDimensionarMultK);
        jbDimensionarMultK.setBounds(192, 11, 91, 23);

        jbCalcularMultK.setText("Calcular");
        jbCalcularMultK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCalcularMultKActionPerformed(evt);
            }
        });
        jPanel4.add(jbCalcularMultK);
        jbCalcularMultK.setBounds(289, 11, 71, 23);

        jbLimipiarMultK.setText("Limpiar");
        jbLimipiarMultK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimipiarMultKActionPerformed(evt);
            }
        });
        jPanel4.add(jbLimipiarMultK);
        jbLimipiarMultK.setBounds(366, 11, 65, 23);

        jpMultK.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jpMultKLayout = new javax.swing.GroupLayout(jpMultK);
        jpMultK.setLayout(jpMultKLayout);
        jpMultKLayout.setHorizontalGroup(
            jpMultKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 203, Short.MAX_VALUE)
        );
        jpMultKLayout.setVerticalGroup(
            jpMultKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 209, Short.MAX_VALUE)
        );

        jPanel4.add(jpMultK);
        jpMultK.setBounds(10, 94, 205, 211);

        jpMultKRES.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jpMultKRESLayout = new javax.swing.GroupLayout(jpMultKRES);
        jpMultKRES.setLayout(jpMultKRESLayout);
        jpMultKRESLayout.setHorizontalGroup(
            jpMultKRESLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 201, Short.MAX_VALUE)
        );
        jpMultKRESLayout.setVerticalGroup(
            jpMultKRESLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 207, Short.MAX_VALUE)
        );

        jPanel4.add(jpMultKRES);
        jpMultKRES.setBounds(257, 96, 203, 209);

        jTabbedPane1.addTab("MUL K", jPanel4);

        jLabel11.setText("n (columnas)");

        jLabel12.setText("m (filas)");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(35, 35, 35))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(12, 12, 12)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField12)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(422, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addContainerGap(259, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Transpuesta", jPanel5);

        jLabel13.setText("n (columnas)");

        jLabel14.setText("m (filas)");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(35, 35, 35))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(12, 12, 12)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField14)
                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(422, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addContainerGap(259, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Inversa", jPanel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
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
                jDSuma.setLocationRelativeTo(null);
                jDSuma.setVisible(true);
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
                jDResta.setLocationRelativeTo(null);
                jDResta.setVisible(true);
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
                    jDMult.setLocationRelativeTo(null);
                    jDMult.setVisible(true);
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
            this.jtfK.setText("");
        }//GEN-LAST:event_jbLimipiarMultKActionPerformed

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
    private javax.swing.JDialog jDMult;
    private javax.swing.JDialog jDResta;
    private javax.swing.JDialog jDSuma;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
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
    private javax.swing.JPanel jPanel7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JButton jbCalcularMultK;
    private javax.swing.JButton jbCalcularMultiplicacion;
    private javax.swing.JButton jbCalcularResta;
    private javax.swing.JButton jbCalcularSuma;
    private javax.swing.JButton jbDimensionarMultK;
    private javax.swing.JButton jbDimensionarMultiplicacionA;
    private javax.swing.JButton jbDimensionarMultiplicacionB;
    private javax.swing.JButton jbDimensionarResta;
    private javax.swing.JButton jbDimensionarSuma;
    private javax.swing.JButton jbLimipiarMultK;
    private javax.swing.JButton jbLimipiarResta;
    private javax.swing.JButton jbLimipiarSuma;
    private javax.swing.JButton jbLimpiarMultiplicacion;
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
    private javax.swing.JTextField jtfK;
    private javax.swing.JTextField jtfmMultA;
    private javax.swing.JTextField jtfmMultB;
    private javax.swing.JTextField jtfmMultK;
    private javax.swing.JTextField jtfmResta;
    private javax.swing.JTextField jtfmSuma;
    private javax.swing.JTextField jtfnMultA;
    private javax.swing.JTextField jtfnMultB;
    private javax.swing.JTextField jtfnMultK;
    private javax.swing.JTextField jtfnResta;
    private javax.swing.JTextField jtfnSuma;
    // End of variables declaration//GEN-END:variables
}
