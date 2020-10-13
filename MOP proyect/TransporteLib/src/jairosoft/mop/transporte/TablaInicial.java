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
public abstract class TablaInicial extends ModeloTransporte {

    protected ArrayList<ArrayList<Asignacion>> asignaciones;
    protected ArrayList<Double> ofertaRestante;
    protected ArrayList<Double> demandaRestante;
    protected double costoTotalInicial;

    public TablaInicial(ModeloTransporte modelo) {
        this(modelo,null);
        
        
    }
    public TablaInicial(ModeloTransporte modelo, ArrayList<ArrayList<Asignacion>> asignaciones)
    {
        super(modelo.costos, modelo.demandas, modelo.ofertas);
        ofertaRestante = (ArrayList<Double>) ofertas.clone();
        demandaRestante = (ArrayList<Double>) demandas.clone();
        if(asignaciones==null)
        {
            this.asignaciones = new ArrayList<ArrayList<Asignacion>>();
            for (Double o : ofertas)//por cada oferta
            {
                //agrega una fila
                this.asignaciones.add(Asignacion.arrayListAsignaciones(demandas.size()));
            }
        }
        else
        {
            this.asignaciones=asignaciones;
        }
    }
    

    protected ArrayList<Asignacion> getAsignacionDemanda(int columna) {
        ArrayList<Asignacion> res = new ArrayList<Asignacion>();
        for (int i = 0; i < asignaciones.size(); i++) {
            res.add(asignaciones.get(i).get(columna));

        }
        return res;
    }

    protected ArrayList<Asignacion> getAsignacionOferta(int fila) {
        return asignaciones.get(fila);
    }

    public Asignacion getAsignacion(int fila, int columna) {
        return asignaciones.get(fila).get(columna);
    }

    public void setAsignacion(int fila, int columna, Asignacion valor) {
        asignaciones.get(fila).set(columna, valor);

    }

    public void setAsignacion(int fila, int columna, double valor) {
        asignaciones.get(fila).get(columna).setValor(valor);

    }

    protected ArrayList<Integer> obtenerExcepcionesOferta(int fila) {
        return obtenerExcepciones(getAsignacionOferta(fila));
    }

    protected ArrayList<Integer> obtenerExcepcionesDemanda(int columna) {
        return obtenerExcepciones(getAsignacionDemanda(columna));
    }

    private ArrayList<Integer> obtenerExcepciones(ArrayList<Asignacion> asignaciones) {
        ArrayList<Integer> excepciones = new ArrayList<Integer>();
        for (int j = 0; j < asignaciones.size(); j++) {
            Asignacion asignacion = asignaciones.get(j);
            if (asignacion.getValor() != 0 || !asignacion.isHabilitado()||asignacion.isVariableBasica()) {
                excepciones.add(j);
            }
        }
        return excepciones;
    }

    protected ArrayList<int[]> obtenerTetas()
    {
        ArrayList<int[]> res=new ArrayList<int[]>();
        for (int i = 0; i < getNumeroFilas(); i++) {
            for (int j = 0; j < getNumeroColumnas(); j++) {
                int[] pos=new int[2];
                pos[0]=i;
                pos[1]=j;
                if(asignaciones.get(i).get(j).getTeta()!=0)
                {
                    res.add(pos);
                }
                
            }
        }
        return res;
    }
    protected void asignar(int[] posicionCostoObjetivo) {

        //Verificamos si hay mas oferta que demanda o mas demanda que oferta para asignar el maximo
        Double ofertaDisponible = ofertaRestante.get(posicionCostoObjetivo[0]);
        Double demandaDisponible = demandaRestante.get(posicionCostoObjetivo[1]);


        if (demandaDisponible < ofertaDisponible) {
            setAsignacion(posicionCostoObjetivo[0], posicionCostoObjetivo[1], demandaDisponible);
            demandaRestante.set(posicionCostoObjetivo[1], new Double(0));
            ofertaRestante.set(posicionCostoObjetivo[0], ofertaDisponible - demandaDisponible);
            //deshabilitando toda la columna que se ha dejado a cero
            int size = getCostosDemanda(posicionCostoObjetivo[1]).size();
            for (int i = 0; i < size; i++) {
                if (i != posicionCostoObjetivo[0] && !asignaciones.get(i).get(posicionCostoObjetivo[1]).isVariableBasica()) {
                    asignaciones.get(i).get(posicionCostoObjetivo[1]).setHabilitado(false);
                }

            }
        } else {
            setAsignacion(posicionCostoObjetivo[0], posicionCostoObjetivo[1], ofertaDisponible);

            ofertaRestante.set(posicionCostoObjetivo[0], new Double(0));
            demandaRestante.set(posicionCostoObjetivo[1], demandaDisponible - ofertaDisponible);
            //deshabilitando toda la fila que se ha dejado a cero
            int size = getCostosOferta(posicionCostoObjetivo[0]).size();
            for (int i = 0; i < size; i++) {
                if (i != posicionCostoObjetivo[1] && !asignaciones.get(posicionCostoObjetivo[0]).get(i).isVariableBasica()) {
                    asignaciones.get(posicionCostoObjetivo[0]).get(i).setHabilitado(false);
                }

            }
        }
        asignaciones.get(posicionCostoObjetivo[0]).get(posicionCostoObjetivo[1]).setVariableBasica(true);
    }

    public double getCostoTotal() {
        double res = 0;
        ArrayList<int[]> variablesBasicas = getVariablesBasicas();
        for (int[] pos : variablesBasicas) {
            res = res + asignaciones.get(pos[0]).get(pos[1]).getValor() * costos.get(pos[0]).get(pos[1]);
        }
        return res;
    }

    public ArrayList<int[]> getVariablesBasicas() {
        ArrayList<int[]> res = new ArrayList<int[]>();
        for (int i = 0; i < getNumeroFilas(); i++) {
            for (int j = 0; j < getNumeroColumnas(); j++) {
                Asignacion asignacionActual = asignaciones.get(i).get(j);
                if (asignacionActual.isVariableBasica()) {
                    int[] pos = new int[2];
                    pos[0] = i;
                    pos[1] = j;
                    res.add(pos);
                }
            }

        }
        return res;
    }

    public ArrayList<int[]> getVariablesNoBasicas() {
        ArrayList<int[]> res = new ArrayList<int[]>();
        for (int i = 0; i < getNumeroFilas(); i++) {
            for (int j = 0; j < getNumeroColumnas(); j++) {
                Asignacion asignacionActual = asignaciones.get(i).get(j);
                if (!asignacionActual.isVariableBasica()) {
                    int[] pos = new int[2];
                    pos[0] = i;
                    pos[1] = j;
                    res.add(pos);
                }
            }

        }
        return res;
    }
    
    @Override
    public String toString() {
        String res = super.toString();
        res = res + "\n" + "Asignaciones:" + "\n";

        for (int i = 0; i < asignaciones.size(); i++) {
            ArrayList<Asignacion> fila = asignaciones.get(i);
            for (int j = 0; j < fila.size(); j++) {
                Asignacion val = fila.get(j);
                res = res + "| " + (val.isHabilitado() ? val.getValor() : "X ") + (val.getTeta() == 1 ? "+o" : (val.getTeta() == -1 ? "-o" : ""));
            }
            res = res + "|" + ofertas.get(i) + "|\n";
        }
        for (Double demanda : demandas) {
            res = res + "|" + demanda;
        }
        res = res + "|" + (ArrayUtils.sumatoria(ofertas)) + " |";
        res = res + "\n\nz=" + getCostoTotal();
        return res;
    }
}
