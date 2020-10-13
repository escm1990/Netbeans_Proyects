/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jairosoft.mop.transporte;

import java.util.ArrayList;

/**
 *
 * @author Edwin
 */
public class Asignacion {
    private double valor;
    private boolean habilitado;
    private int teta;
    private boolean variableBasica;
    public Asignacion()
    {
        this(0);
        
    }
    public Asignacion(double val)
    {
        valor=val;
        habilitado=true;
        teta=0;
        variableBasica=false;
    }
    public static ArrayList<Asignacion> arrayListAsignaciones(int tam)
    {
        ArrayList<Asignacion> res=new ArrayList<Asignacion>();
        for(int i=0;i<tam;i++)
        {
            res.add(new Asignacion());
        }
        return res; 
    }
    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * @return the habilitado
     */
    public boolean isHabilitado() {
        return habilitado;
    }

    /**
     * @param habilitado the habilitado to set
     */
    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    /**
     * @return the teta
     */
    public int getTeta() {
        return teta;
    }

    /**
     * @param teta the teta to set
     */
    public void setTeta(int teta) {
        this.teta = teta;
    }

    /**
     * @return the variableBasica
     */
    public boolean isVariableBasica() {
        return variableBasica;
    }

    /**
     * @param variableBasica the variableBasica to set
     */
    public void setVariableBasica(boolean variableBasica) {
        this.variableBasica = variableBasica;
    }

}
