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
public class TablaInicialENO extends TablaInicial {

    

    public TablaInicialENO(ModeloTransporte modelo) {
        super(modelo);
        ofertaRestante = (ArrayList<Double>) ofertas.clone();
        demandaRestante = (ArrayList<Double>) demandas.clone();
        asignarValores();
    }


    private void asignarValores() {
        for (int i = 0; i < getNumeroFilas(); i++) {
            
            for (int j = 0; j < getNumeroColumnas(); j++) {
                if(asignaciones.get(i).get(j).isHabilitado()&&!asignaciones.get(i).get(j).isVariableBasica())
                {
                    int[] pos={i,j};
                    asignar(pos);
                    System.out.println(toString());
                }
                
            }
            
        }

    }
    
    
}
