/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metodosIterativos;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USUARIO
 */
public class Secante {

    double X0, X1, Tol;
    private DefaultTableModel modeloTabla;
    private int n;

    public Secante(double x0, double x1, double tol, int N) {
        X0 = x0;
        X1 = x1;
        Tol = tol;
        n = N;
    }

    public void setModelo(DefaultTableModel modeloTabla) {
        this.modeloTabla = modeloTabla;
    }

    private double f(double x) {
        return ((3 * x) + Math.sin(x) - Math.exp(x));
    }

    public double calcularRaiz() throws Exception {
        double raiz = X0;
        int numIteracion = 1;
        double era = 1;

        ArrayList<Object> filaAgregada;
        modeloTabla.setRowCount(0);

        while (f(raiz) != 0 & numIteracion <= n & era > Tol) {
            filaAgregada = new ArrayList<Object>();
            filaAgregada.add(numIteracion);
            filaAgregada.add(String.format("%.6f", X0));
            filaAgregada.add(String.format("%.6f", X1));

            double y0, y1, y2;
            y0 = f(X0);
            y1 = f(X1);

            filaAgregada.add(String.format("%.6f", f(y0)));
            filaAgregada.add(String.format("%.6f", f(y1)));

            y2=raiz;
            raiz = X0 - ((f(X0) * (X1 - X0)) / (f(X1) - f(X0)));

            filaAgregada.add(String.format("%.6f", raiz));
            filaAgregada.add(String.format("%.6f", f(raiz)));

            numIteracion = numIteracion + 1;
            era = Math.abs(raiz - y2) / raiz;
            filaAgregada.add(String.format("%.6f", era)); //trabajamos con 6 decimales después del punto
            filaAgregada.add(era < Tol ? "Verdadero" : "Falso"); //evaluación de Convergencia
            modeloTabla.addRow(filaAgregada.toArray());

            if (f(raiz)==0) {
                break;
            } else {
                X0 = X1;
                X1 = raiz;
            }
        }
        if (era > Tol) {
            throw new Exception("No se ha encontrado la raiz");
        }
        return raiz;
    }
}
