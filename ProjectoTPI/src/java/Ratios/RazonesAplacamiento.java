/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ratios;

/**
 *
 * @author USUARIO
 */
public class RazonesAplacamiento {
    
    public double endeudamiento(double totPasivo, double totActivo){
        double deuda = 0.00;
        deuda = totPasivo/totActivo;
        return deuda;
    }
    
    public double endeudamientoCorto(double pasCir, double totActivo){
        double deudaCorto = 0.00;
        deudaCorto = pasCir/totActivo;
        return deudaCorto;
    }
    
    public double endeudamientoLargo(double pasLargo, double totActivo){
        double deudaLargo = 0.00;
        deudaLargo = pasLargo/totActivo;
        return deudaLargo;
    }
     
    public double autonomia(double patrimonio, double totActivo){
        double auto = 0.00;
        auto = patrimonio/totActivo;
        return auto;
    }
    
    public double apalancamientoExterno(double totPasivo, double patrimonio){
        double apaExt= 0.00;
        apaExt = totPasivo/patrimonio;
        return apaExt;
    }
    
    public double apalancamientoInterno(double patrimonio, double totPasivo){
        double apaInt = 0.00;
        apaInt = patrimonio/totPasivo;
        return apaInt;
    }
    
    public double capitalizacionExterna(double DxPalp, double patrimonio){
        double capExt = 0.00;
        capExt = DxPalp / (patrimonio+DxPalp);
        return capExt;
    }
    
    public double capitalizacionInterna(double DxPalp, double patrimonio){
        double capInt = 0.00;
        capInt = patrimonio / (patrimonio + DxPalp);
        return capInt;
    }
}
