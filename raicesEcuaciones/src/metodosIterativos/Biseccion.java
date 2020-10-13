/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metodosIterativos;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pc07
 */
public class Biseccion {

    /**
     * Atributos Globales
     */
    double a; //limite inferior
    double b; //limite superior
    double tol; //error permitido
    int n; //numero maximo de iteraciones
    DefaultTableModel modeloTabla;

    public Biseccion(double a1, double b1, double tol1, int ni1) {
        a = a1;
        b = b1;
        tol = tol1;
        n = ni1;
    }

    public void setModelo(DefaultTableModel modeloTabla) {
        this.modeloTabla = modeloTabla;
    }

    private double f(double x) {
        return ((3 * x) + Math.sin(x) - Math.exp(x));
//        return (Math.pow(x, 3)-x-1);
//        return (Math.pow(x, 3)-4*Math.pow(x, 2)+x+3);
    }

    public double calcularRaiz() throws Exception {
        double raiz = a;
        int numIteracion = 1;
        double era = 1;
        ArrayList<Object> filaAgregada;
        modeloTabla.setRowCount(0);

        while (f(raiz) != 0 & numIteracion <= n & era > tol) {
            filaAgregada = new ArrayList<Object>();
            filaAgregada.add(numIteracion);
            filaAgregada.add(String.format("%.6f", a));
            filaAgregada.add(String.format("%.6f", b));
            double pm = raiz;
            raiz = (a + b) / 2;
            filaAgregada.add(String.format("%.6f", raiz));
            filaAgregada.add(String.format("%.6f", f(a))); //trabajamos con 6 decimales después del punto
            filaAgregada.add(String.format("%.6f", f(raiz))); //trabajamos con 6 decimales después del punto
            if (f(raiz) * f(a) > 0) {
                a = raiz;
            } else if (f(raiz) * f(b) > 0) {
                b = raiz;
            }
            numIteracion = numIteracion + 1;
            era = Math.abs(raiz - pm) / raiz;
            filaAgregada.add(String.format("%.6f", era)); //trabajamos con 6 decimales después del punto
            filaAgregada.add(era < tol ? "Verdadero" : "Falso"); //evaluación de Convergencia
            modeloTabla.addRow(filaAgregada.toArray());
        }
        if (era > tol) {
            throw new Exception("No se ha encontrado la raiz");
        }
        return raiz;
    }
}
