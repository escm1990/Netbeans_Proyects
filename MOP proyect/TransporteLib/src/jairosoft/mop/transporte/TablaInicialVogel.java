/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jairosoft.mop.transporte;

import jairosoft.mop.transporte.util.ArrayUtils;
import java.util.ArrayList;

/**
 *
 * @author Edwin
 */
public class TablaInicialVogel extends TablaInicial {

    ArrayList<Double> penalizacionesOferta;
    ArrayList<Double> penalizacionesDemanda;
    ArrayList<Integer> menorCostoDisponibleOferta;
    ArrayList<Integer> menorCostoDisponibleDemanda;
    
    public TablaInicialVogel(ModeloTransporte modelo) {
        super(modelo);
        equilibrar();
        penalizacionesOferta = new ArrayList<Double>();
        penalizacionesDemanda = new ArrayList<Double>();
        asignarValores();
    }
    private void asignarValores()
    {
        
        while(ArrayUtils.sumatoria(demandaRestante)+ArrayUtils.sumatoria(ofertaRestante)>0)
        {
            obtenerPenalizacionesOferta();
            obtenerPenalizacionesDemanda();
            asignar(evaluarObjetivo());
            System.out.println(toString());
        }
    }
    public int[] evaluarObjetivo()
    {
        int posicionMayorValorPenalizacionOferta=ArrayUtils.posicionMayorValor(penalizacionesOferta);
        int posicionMayorValorPenalizacionDemanda=ArrayUtils.posicionMayorValor(penalizacionesDemanda);
        Double mayorPenalizacionOferta=penalizacionesOferta.get(posicionMayorValorPenalizacionOferta);
        Double mayorPenalizacionDemanda=penalizacionesDemanda.get(posicionMayorValorPenalizacionDemanda);
        int[] posicionCostoObjetivo=new int[2];
        if(mayorPenalizacionDemanda>mayorPenalizacionOferta)
        {
            posicionCostoObjetivo[1]=posicionMayorValorPenalizacionDemanda;
            posicionCostoObjetivo[0]=menorCostoDisponibleDemanda.get(posicionMayorValorPenalizacionDemanda);
        }
        else
        {
            posicionCostoObjetivo[0]=posicionMayorValorPenalizacionOferta;
            posicionCostoObjetivo[1]=menorCostoDisponibleOferta.get(posicionMayorValorPenalizacionOferta);
        }
        return posicionCostoObjetivo;
    }
    
    
    
    private void obtenerPenalizacionesOferta() {
            penalizacionesOferta=new ArrayList<Double>();
            menorCostoDisponibleOferta=new ArrayList<Integer>();
        for (int i = 0; i < ofertaRestante.size(); i++) {
            if(ofertaRestante.get(i)>0)
            {
                ArrayList<Integer> excepciones=obtenerExcepcionesOferta(i);
                ArrayList<Double> costosOferta = this.getCostosOferta(i);

                //Obtenemos la posicion del menor costo de los habilitados
                int posicionMenor = ArrayUtils.posicionMenorValor(costosOferta, excepciones);
                //Almacenado por si esta resulta la mayor penalizacion se asigna a este
                menorCostoDisponibleOferta.add(posicionMenor);
                //Agregamos la posicionMenor a las excepciones para obtener la segunda menor habilitada
                excepciones.add(posicionMenor);
                //Obtenemos la posicion del segundo menor costo de los habilitados
                int segundaPosicionMenor= ArrayUtils.posicionMenorValor(costosOferta, excepciones);
                //Obtenemos la penalizacion por diferencia
                Double penalizacion=null;
                if(segundaPosicionMenor>0)
                {
                    penalizacion=costosOferta.get(segundaPosicionMenor)-costosOferta.get(posicionMenor);
                }
                else
                {
                    penalizacion=costosOferta.get(posicionMenor);
                }
                    if(penalizacion.equals(Double.NaN))
                        penalizacion=0.0;
                penalizacionesOferta.add(penalizacion);
            }
            else
            {
                menorCostoDisponibleOferta.add(-1);
                penalizacionesOferta.add(new Double(-1));
            }
            
        }
    }

    private  void obtenerPenalizacionesDemanda() {
        penalizacionesDemanda=new ArrayList<Double>();
        menorCostoDisponibleDemanda=new ArrayList<Integer>();
        for (int i = 0; i < demandaRestante.size(); i++) {
            if(demandaRestante.get(i)>0)
            {
                ArrayList<Integer> excepciones=obtenerExcepcionesDemanda(i);
                ArrayList<Double> costosDemanda = this.getCostosDemanda(i);

                //Obtenemos la posicion del menor costo de los habilitados
                int posicionMenor = ArrayUtils.posicionMenorValor(costosDemanda, excepciones);
                //Almacenado por si esta resulta la mayor penalizacion se asigna a este
                menorCostoDisponibleDemanda.add(posicionMenor);
                //Agregamos la posicionMenor a las excepciones para obtener la segunda menor habilitada
                excepciones.add(posicionMenor);
                //Obtenemos la posicion del segundo menor costo de los habilitados
                int segundaPosicionMenor= ArrayUtils.posicionMenorValor(costosDemanda, excepciones);
                //Obtenemos la penalizacion por diferencia
                Double penalizacion=null;
                if(segundaPosicionMenor>0)
                {
                    penalizacion=costosDemanda.get(segundaPosicionMenor)-costosDemanda.get(posicionMenor);
                }
                else
                {
                    penalizacion=costosDemanda.get(posicionMenor);
                }
                    
                penalizacionesDemanda.add(penalizacion);
            }
            else
            {
                menorCostoDisponibleDemanda.add(-1);
                penalizacionesDemanda.add(Double.NaN);
            }
            
        }
    }
    
    /*@Override
    public String toString() {
        String res = "";//super.toString();
        res = res + "\n" + "Asignaciones:" + "\n";

        for (int i = 0; i < asignaciones.size(); i++) {
            ArrayList<Asignacion> fila = asignaciones.get(i);
            for (int j = 0; j < fila.size(); j++) {
                Asignacion val = fila.get(j);
                res = res + "| " + (val.isHabilitado() ? val.getValor() : "X ") + (val.getTeta() == 1 ? "+o" : val.getTeta() == -1 ? "-o" : "");
            }
            res = res + "|" + ofertaRestante.get(i) + "|\n";
        }
        for (Double demanda : demandaRestante) {
            res = res + "|" + demanda;
        }
        res = res + "|" + (ArrayUtils.sumatoria(ofertaRestante)) + " |";
        return res;
    }*/

    
}
