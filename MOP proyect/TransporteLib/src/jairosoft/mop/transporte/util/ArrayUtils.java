/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jairosoft.mop.transporte.util;

import java.util.ArrayList;

/**
 *
 * @author Edwin
 */
public class ArrayUtils {

    public static int NO_ENCONTRADO=-3;
    public static Double sumatoria(ArrayList<Double> array) {
        Double res = 0.0;
        for (Double d : array) {
            res = res + d;
        }
        return res;
    }

    public static ArrayList<Double> nuevoArrayList(int tam) {
        ArrayList<Double> res = new ArrayList<Double>();
        for (int i = 0; i < tam; i++) {
            res.add(new Double(0));
        }
        return res;
    }

    public static int posicionMenorValor(ArrayList<Double> array) {
        return posicionMenorValor(array, -1);
    }
    public static int posicionMenorValor(ArrayList<Double> array, Integer posicionExcepcion) {
        ArrayList<Integer> e=new ArrayList<Integer>();
        e.add(posicionExcepcion);
        return posicionMenorValor(array,e);
    }
    public static int posicionMenorValor(ArrayList<Double> array, ArrayList<Integer> posicionesExcepcion) {
        int posicionMenor = NO_ENCONTRADO;
        
        for (int i = 0; i < array.size(); i++) {
            if(!pertenece(i,posicionesExcepcion))
            {
                posicionMenor=i;
                break;
            }
            
        }
        
        if (posicionMenor < array.size()&&posicionMenor>=0) {
            for (int i = 0; i < array.size() ; i++) {
                if (array.get(posicionMenor) > array.get(i) && !pertenece(i,posicionesExcepcion)) {
                    posicionMenor = i;
                }
            }
        }
        return posicionMenor;
    }
 
    public static int posicionMayorValor(ArrayList<Double> array) {
        ArrayList<Integer> e=new ArrayList<Integer>();
        e.add(-1);
        return posicionMayorValor(array, e);
    }
    public static int posicionMayorValor(ArrayList<Double> array, ArrayList<Integer> posicionesExcepcion) {
        int posicionMenor = NO_ENCONTRADO;
        
        for (int i = 0; i < array.size(); i++) {
            if(!pertenece(i,posicionesExcepcion)&&array.get(i).doubleValue() !=-1&&!array.get(i).equals(Double.NaN))
            {
                posicionMenor=i;
                break;
            }
            
        }
        
        if (posicionMenor < array.size()&&posicionMenor>=0) {
            for (int i = 0; i < array.size() ; i++) {
                if (array.get(posicionMenor) < array.get(i) && !pertenece(i,posicionesExcepcion)&&array.get(posicionMenor).doubleValue()!=-1&&!array.get(i).equals(Double.NaN)) {
                    posicionMenor = i;
                }
            }
        }
        return posicionMenor;
    }
    private static boolean pertenece(int valor, ArrayList<Integer> arreglo)
    {
        boolean res=false;
        for (int i = 0; i < arreglo.size(); i++) {
            res=res||valor==arreglo.get(i);
        }
        return res;
    }
}
