/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ratios;

import javax.swing.JOptionPane;

/**
 *
 * @author USUARIO
 */
public class RazonesLiquidez {

    public double capitalTrabajo(double activoCirculante, double pasivoCirculante) {
        double capitalTrabajo = 0.00;
        capitalTrabajo = activoCirculante - pasivoCirculante;
        return capitalTrabajo;
    }

    public double razonCirculante(double activoCirculante, double pasivoCirculante) {
        double razonCir = 0.00;
        razonCir = activoCirculante / pasivoCirculante;
        return razonCir;
    }

    public double razonAcida(double activoCirculante, double pasivoCirculante, double inventarios) {
        double pAcida = 0.00;
        pAcida = (activoCirculante - inventarios) / pasivoCirculante;
        return pAcida;
    }

    public double superAcida(double efec_equi, double CxC, double pasivoCirculante) {
        double supAcida = 0.00;
        supAcida = (efec_equi + CxC) / pasivoCirculante;
        return supAcida;
    }

    public double fondoManiobra(double actCirculante,double pasivoCirculante,double totActivo){
        double fonMani = 0.00;
        fonMani = (actCirculante - pasivoCirculante)/totActivo;
        return fonMani;
    }
}
