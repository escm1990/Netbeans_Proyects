/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jairosoft.mop.transporte;

import jairosoft.mop.transporte.util.ArrayUtils;
import java.util.ArrayList;


/**
 *
 * @author edwin
 */
public class TablaInicialCostoMinimo extends TablaInicial {
   
    public TablaInicialCostoMinimo(ModeloTransporte modelo)
    {
        super(modelo);
        asignarValores();
    }
    private void asignarValores()
    {
        while(ArrayUtils.sumatoria(demandaRestante)+ArrayUtils.sumatoria(ofertaRestante)>0)
        {
            asignar(evaluarMenorCosto());
        }
    }
    private int[] evaluarMenorCosto()
    {
        ArrayList<int[]> menoresPosicionesFila=new ArrayList<int[]>();
        ArrayList<Double> menoresValoresFila=new ArrayList<Double>();
        //Obtenemos los valores menores por fila
        for (int i = 0; i < costos.size(); i++) {
            int[] coord=new int[2];
            int posicionMenorValor = ArrayUtils.posicionMenorValor(costos.get(i), obtenerExcepcionesOferta(i));
            if(posicionMenorValor!=ArrayUtils.NO_ENCONTRADO)
            {
                coord[0]=i;
                coord[1]=posicionMenorValor;
                menoresPosicionesFila.add(coord);
                menoresValoresFila.add(costos.get(coord[0]).get(coord[1]));
            }
        }
        //comparamos los valores menores de cada fila para obtener el valor menor
        int posicionMenorEnArreglo=ArrayUtils.posicionMenorValor(menoresValoresFila);
        return menoresPosicionesFila.get(posicionMenorEnArreglo);
        
    }
    
}
