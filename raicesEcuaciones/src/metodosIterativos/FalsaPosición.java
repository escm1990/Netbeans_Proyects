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
public class FalsaPosición {

    double a, b, tol;
    int n;
    DefaultTableModel modeloTabla;

    public FalsaPosición(double a, double b, double tol, int n) {
        this.a = a;
        this.b = b;
        this.tol = tol;
        this.n = n;
    }

    private double f(double x) {
        return ((3 * x) + Math.sin(x) - Math.exp(x));
  //      return (Math.exp(x) + Math.pow(x, 3) + 2 * Math.pow(x, 2) + 10 * x - 20);
    }

    public void setModelo(DefaultTableModel modeloTabla) {
        this.modeloTabla = modeloTabla;
    }

    public double calcularRaiz() throws Exception {
        double era = tol + 1;
        int cont = 0;
        double cAct, cAnt = 0;
        double raiz = 1;
        int numIteracion = 1;
        ArrayList<Object> filaAgregada;
        modeloTabla.setRowCount(0);

        while (cont < n) {
            filaAgregada = new ArrayList<Object>();
            filaAgregada.add(numIteracion);
            filaAgregada.add(String.format("%.6f", a));
            filaAgregada.add(String.format("%.6f", b));
            filaAgregada.add(String.format("%.6f", f(a)));
            filaAgregada.add(String.format("%.6f", f(b)));

            cAct = (a * f(b) - b * f(a)) / (f(b) - f(a));
            if (f(cAct) == 0) {
                raiz = cAct;
                break;
            }

            filaAgregada.add(String.format("%.6f", cAct));
            filaAgregada.add(String.format("%.6f", f(cAct)));

            era = Math.abs((cAct - cAnt) / cAct);

            filaAgregada.add(String.format("%.6f", era));
            filaAgregada.add(era < tol ? "Verdadero" : "Falso"); //evaluación de Convergencia
            modeloTabla.addRow(filaAgregada.toArray());

            if (cont != 0) {
                if (era < tol) {
                    raiz = cAct;
                    break;
                }
            }

            if ((f(a) * f(cAct)) < 0) {
                b = cAct;
            } else {
                a = cAct;
            }

            cAnt = cAct;
            cont++;
            numIteracion++;
        }
        return raiz;
    }
}
