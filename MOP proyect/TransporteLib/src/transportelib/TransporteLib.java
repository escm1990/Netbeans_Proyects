/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package transportelib;

import jairosoft.mop.transporte.ModeloTransporte;
import jairosoft.mop.transporte.ModeloTransporteOptimizado;
import jairosoft.mop.transporte.TablaInicial;
import jairosoft.mop.transporte.TablaInicialCostoMinimo;
import jairosoft.mop.transporte.TablaInicialENO;
import jairosoft.mop.transporte.TablaInicialVogel;
import jairosoft.mop.transporte.util.ArrayUtils;
import java.util.ArrayList;

/**
 *
 * @author Edwin
 */
public class TransporteLib {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<ArrayList<Double>> costos=new ArrayList<ArrayList<Double>>();
        ArrayList<Double> fabrica1=new ArrayList<Double>();
        ArrayList<Double> fabrica2=new ArrayList<Double>();
        ArrayList<Double> fabrica3=new ArrayList<Double>();
        fabrica1.add(new Double(8));
        fabrica1.add(new Double(3));
        fabrica1.add(new Double(4));
        fabrica1.add(new Double(5));
        fabrica2.add(new Double(7));
        fabrica2.add(new Double(6));
        fabrica2.add(new Double(5));
        fabrica2.add(new Double(2));
        fabrica3.add(new Double(2));
        fabrica3.add(new Double(4));
        fabrica3.add(new Double(3));
        fabrica3.add(new Double(3));
        costos.add(fabrica1);
        costos.add(fabrica2);
        costos.add(fabrica3);
        
        ArrayList<Double> ofertas=new ArrayList<Double>();
        ArrayList<Double> demandas=new ArrayList<Double>();
        ofertas.add(new Double(550));
        ofertas.add(new Double(300));
        ofertas.add(new Double(260));
        demandas.add(new Double(250));
        demandas.add(new Double(300));
        demandas.add(new Double(200));
        demandas.add(new Double(160));
        
        
        ModeloTransporte modeloTransporte = new ModeloTransporte(costos,demandas, ofertas);
        modeloTransporte.equilibrar();
        System.out.println(modeloTransporte.toString());
        //TablaInicialVogel tablaInicial = new TablaInicialVogel(modeloTransporte);
        //System.out.println(tablaInicial.toString());
        //TablaInicialENO tablaInicial=new TablaInicialENO(modeloTransporte);
        TablaInicial tablaInicial=new  TablaInicialCostoMinimo(modeloTransporte);
        ModeloTransporteOptimizado modeloFinal=new ModeloTransporteOptimizado(tablaInicial);
        System.out.println( modeloFinal.toString());

        
    }
}
