/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ratios;

/**
 *
 * @author USUARIO
 */
public class RazonesGerencia {

    public double diasInventarios(double inventario, double ventas) {
        double diasInv = 0.00;
        diasInv = (inventario * 360) / ventas;
        return diasInv;
    }

    public double rotacionInventarios(double ventas, double inventarios) {
        double rotInv = 0.00;
        rotInv = ventas / inventarios;
        return rotInv;
    }

    public double diasCxC(double CxC, double ventas) {
        double diascxc = 0.00;
        diascxc = (CxC * 360) / ventas;
        return diascxc;
    }

    public double rotacionCxC(double ventas, double Cxc) {
        double rotcxc = 0.00;
        rotcxc = ventas / Cxc;
        return rotcxc;
    }
    
        public double diasCxP(double CxP, double compras) {
        double diascxp = 0.00;
        diascxp = (CxP * 360) / compras;
        return diascxp;
    }

    public double rotacionCxp(double compras, double Cxp) {
        double rotcxp = 0.00;
        rotcxp = compras / Cxp;
        return rotcxp;
    }
    
            public double activoFijo(double ventas, double actFijo) {
        double act_fijo = 0.00;
        act_fijo = ventas/actFijo;
        return act_fijo;
    }

    public double rotacionActivoTotal(double ventas, double activoTotal) {
        double rotAcT = 0.00;
        rotAcT = ventas/activoTotal;
        return rotAcT;
    }
}
