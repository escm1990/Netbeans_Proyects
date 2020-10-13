package metodosIterativos;


import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author pc04
 */
public class Newton {

    double tol;
    int n;
    double x0;
    DefaultTableModel modeloTabla;

    public Newton(double tol, int n, double x0) {
        this.tol = tol;
        this.n = n;
        this.x0 = x0;
    }

    public void setModelo(DefaultTableModel modeloTabla) {
        this.modeloTabla = modeloTabla;
    }

    public double f(double x) {
        return (3 * x + Math.sin(x) - Math.exp(x));
    }

    public double df(double x) {
        return (3 + Math.cos(x) - Math.exp(x));
    }

    public double calcularRaiz() throws Exception{
        
        int numIteracion = 1;
        double era = 1, x1ant = 0, x1act = 0;
        ArrayList<Object> filaAgregada;
        modeloTabla.setRowCount(0);

        while (numIteracion <= n & era > tol) {
            filaAgregada = new ArrayList<Object>();
            filaAgregada.add(numIteracion);
            filaAgregada.add(String.format("%.6f", x0));
            filaAgregada.add(String.format("%.6f", f(x0)));
            filaAgregada.add(String.format("%.6f", df(x0)));
            x1act = x0 - f(x0) / df(x0);
            filaAgregada.add(String.format("%.6f", x1act));
            era = Math.abs((x1act - x1ant) / x1act);
            filaAgregada.add(String.format("%.6f", era));
            filaAgregada.add(era < tol ? "Verdadero" : "Falso");
            modeloTabla.addRow(filaAgregada.toArray());
            x0 = x1act;
            x1ant = x1act;
            numIteracion++;
        }
         if (era > tol) {
            throw new Exception("No se ha encontrado la raiz");
        }
        return x1act;
    }
}
