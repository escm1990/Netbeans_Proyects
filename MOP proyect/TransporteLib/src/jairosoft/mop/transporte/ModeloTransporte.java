/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jairosoft.mop.transporte;

import jairosoft.mop.transporte.util.ArrayUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Edwin
 */
public class ModeloTransporte {
    protected ArrayList<ArrayList<Double>> costos;
    
    protected ArrayList<Double> demandas;
    protected ArrayList<Double> ofertas;
    protected int numeroColumnas;
    protected int numeroFilas;

    public ModeloTransporte(ArrayList<ArrayList<Double>> costos,ArrayList<Double> demandas,ArrayList<Double> ofertas)
    {
        this.costos=costos;
        this.demandas=demandas;
        this.ofertas=ofertas;
        numeroColumnas=demandas.size();
        numeroFilas=ofertas.size();
    }
    public void equilibrar()
    {
        double totalDemanda=ArrayUtils.sumatoria(demandas);
        double totalOferta=ArrayUtils.sumatoria(ofertas);
        if(totalDemanda<totalOferta)
        {
            demandas.add(new Double(totalOferta-totalDemanda));
            for(int i=0;i<ofertas.size();i++)
            {
                costos.get(i).add(new Double(0));
            }
        }
        else if(totalOferta<totalDemanda)
        {
            ofertas.add(new Double(totalDemanda-totalOferta));
            costos.add(ArrayUtils.nuevoArrayList(demandas.size()));
        }
        numeroColumnas=demandas.size();
        numeroFilas=ofertas.size();
    }
    public double getTotalDemanda()
    {
        return ArrayUtils.sumatoria(demandas);
    }
    public boolean isEquilibrado()
    {
        double totalDemanda=ArrayUtils.sumatoria(demandas);
        double totalOferta=ArrayUtils.sumatoria(ofertas);
        return totalDemanda==totalOferta;
    }
    public Double getOferta(int fila)
    {
        return ofertas.get(fila);
    }
    public void setOferta(int fila,Double valor)
    {
        ofertas.set(fila, valor);
    }
    public Double getDemanda(int columna)
    {
        return demandas.get(columna);
    }
    public void setDemanda(int columna,Double valor)
    {
        demandas.set(columna, valor);
    }
    public Double getCosto(int fila,int columna)
    {
        return costos.get(fila).get(columna);
    }
    public void setCosto(int fila, int columna, Double valor)
    {
        costos.get(fila).set(columna, valor);
    }
    public ArrayList<Double> getCostosOferta(int fila)
    {
        return costos.get(fila);
    }
    public ArrayList<Double> getCostosDemanda(int columna)
    {
        ArrayList<Double> res=new ArrayList<Double>();
        for (int i = 0; i < costos.size(); i++) {
            res.add(costos.get(i).get(columna));

        }
        return res;
    }
    
    @Override
    public String toString()
    {
        String res="Costos:\n";
        for(ArrayList<Double> fila:costos)
        {
            for(Double dato:fila)
            {
                res=res+" | "+dato;
            }
            res=res+" |\n";
        }
        
        
        return res;
    }

    /**
     * @return the numeroColumnas
     */
    public int getNumeroColumnas() {
        return numeroColumnas;
    }

    /**
     * @return the numeroFilas
     */
    public int getNumeroFilas() {
        return numeroFilas;
    }
}
