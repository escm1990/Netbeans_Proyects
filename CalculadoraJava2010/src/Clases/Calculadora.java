/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import javax.swing.JOptionPane;

/**
 *
 * @author USUARIO
 */
public class Calculadora implements ICalculadora {

    public Estado edo;
    public Operaciones op;
    public double v1, v2, res;
    public int operacion;

    public Calculadora() {
        edo = Estado.espera;
        op = Operaciones.espera;
        res = 0;
        v1 = 0;
        v2 = 0;
    }

    public void sumar() {
        res = v1 + v2;
        redondear();
    }

    public void restar() {
        res = v1 - v2;
        redondear();
    }

    public void multiplicar() {
        res = v1 * v2;
        redondear();
    }

    public void dividir() throws Exception {
        if (v2 == 0) {
            res = 0;
            throw new Exception("No se puede resolver la division entre cero");
        } else {
            res = v1 / v2;
        }
        redondear();
    }

    public void raiz() throws Exception {
        evaluarOperacion();
        if(v2 == 0){
            res=v1;
        }
        if (res < 0) {
            throw new Exception("Imposible efectuar la raiz cuadrada de un numero negativo");
        } else {
            res = Math.sqrt(res);
        }
        redondear();
    }

    public void masmenos() {
        evaluarOperacion();
        if (res > 0) {
            res = res * -1;
        } else if (res < 0) {
            res = res * -1;
        }
    }

    public void dolar() throws Exception {
         if (res < 0) {
            throw new Exception("No es correcto convertir valores negativos");
        } else {
            res = res * 8.75;
        }
        redondear();
    }

    public void Captura(double x) {
        switch (edo) {
            case espera:
                edo = Estado.operando;
                v1 = x;
                break;
            case operando:
                v2 = x;
                operar();
                v1 = res;
                break;
            case resultado:
                v2 = x;
                operar();
                edo = Estado.operando;
                break;
        }
    }

    public void operar() {
        switch (op) {
            case suma:
                sumar();
                break;
            case resta:
                restar();
                break;
            case multiplicacion:
                multiplicar();
                break;
            case division:
                try {
                    dividir();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
                break;
            case raiz:
                try {
                    raiz();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
                break;
            case masmenos:
                masmenos();
                break;
            case dolar:
                try {
                    dolar();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
                break;
        }
        v1 = res;
    }

    private void evaluarOperacion() {
        switch (op) {
            case suma:
                sumar();
                break;
            case resta:
                restar();
                break;
            case multiplicacion:
                multiplicar();
                break;
            case division:
                try {
                    dividir();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
                break;
        }
        v1 = res;
    }

    private void redondear() {
        int dec;
        dec = (int) Math.pow(10, 9);
        res = res * dec;
        res = Math.rint(res);
        res = res / dec;
    }
}
