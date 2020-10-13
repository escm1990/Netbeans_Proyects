/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ratios;

/** 
 *
 * @author USUARIO
 */
public class RazonesRentabilidad {
    
    public double marUtilidadBruta(double ventas, double costoVentas){
        double marUtiBruta = 0.00;
        marUtiBruta = (ventas - costoVentas)/ventas;
        return marUtiBruta;
    }
    
    public double marUtilidadOperaciones(double utiOpe, double ventas){
        double marUtiOpe = 0.00;
        marUtiOpe = utiOpe/ventas;
        return marUtiOpe;
    }
    
    public double marAntesImp(double utiAntImp, double ventas){
        double marAntImp = 0.00;
        marAntImp = utiAntImp/ventas;
        return marAntImp;
    }
    
    public double marUtilidadNeta(double utiNeta, double  ventas){
        double marUtiNeta = 0.00;
        marUtiNeta = utiNeta/ventas;
        return marUtiNeta;
    }
    
    public double rendSobActivos(double utiNeta, double totActivos){
        double RSA = 0.00;
        RSA = utiNeta/totActivos;
        return RSA;
    }
    
    public double rendSobPatrimonio(double utiNeta, double patrimonio){
        double ROE = 0.00;
        ROE = utiNeta/patrimonio;
        return ROE;
    }
    
    public double rendSobCapEmpleado(double utiNeta, double patrimonio, double DxPalp){
        double ROCE = 0.00;
        ROCE = utiNeta/(patrimonio+DxPalp);
        return ROCE;
    }
    
    public double renSobCapTrabajo(double actCirculante, double pasCirculante, double utiNeta){
        double RSCT = 0.00;
        RSCT = utiNeta/(actCirculante-pasCirculante);
        return RSCT;
    }
}
