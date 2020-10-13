/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jairosoft.mop.transporte;

import java.util.ArrayList;
import mop.transporte.OptimizadorTransporte;

/**
 *
 * @author edwin
 */
public class ModeloTransporteOptimizado extends TablaInicial {

    ArrayList<Double> u; //Multiplicador U
    ArrayList<Double> v; //Multiplicador V
    int[] posicionMayorPuntaje;
    ArrayList<Double> puntajes; // U + V - C= X
    private int tetaActual = 1;
    private int totalEnCircuito = 0;
    final int ARRIBA = 0;
    final int ABAJO = 1;
    final int DERECHA = 2;
    final int IZQUIERDA = 3;
    boolean[][] verficadas;
    String resumen;

    public ModeloTransporteOptimizado(TablaInicial tablaInicial) {
        super(tablaInicial);
        asignaciones = tablaInicial.asignaciones;
        System.out.println(toString());
        optimizar(true);

    }
    public String salidaOptimizadorTransporte()
    {
        String res="Fuentes ";
        res+=(numeroFilas)+"\n";
        //Agregando Ofertas
        res+="Suministros ";
        for (Double oferta:ofertas) {
            res+=oferta+" ";
        }
        res+="\n";
        res+="Destinos "+(numeroColumnas)+"\n";
        //Agregando Demandas
        res+="Demandas ";
        for(Double demanda:demandas)
        {
            res+=demanda+" ";
        }
        res+="\n";
        //Agregando Costos
        res+="Costos";
        
        for (int i = 0; i < costos.size(); i++) {
            res+="\n      ";
            for (int j = 0; j < costos.get(i).size(); j++) {
                res+=costos.get(i).get(j)+" ";
            }
            
        }
        return res;
        
    }
    private void optimizar(boolean metodoAlternativo) {
        if (metodoAlternativo) {
            OptimizadorTransporte optimizadorTransporte = new OptimizadorTransporte();
            optimizadorTransporte.resolver(this);
            //System.out.println(salidaOptimizadorTransporte());
        } else {
            calcularMultiplicadores();
            boolean positivoEncontrado = calcularMayorPuntaje();
            boolean degenerado = false;
            while (positivoEncontrado && !degenerado) {
                degenerado = crearCircuito();
                if (!degenerado) {
                    calcularNuevaTabla();
                }
                calcularMultiplicadores();
                positivoEncontrado = calcularMayorPuntaje();
            }
        }
    }

    private void calcularMultiplicadores() {
        u = new ArrayList<Double>();
        v = new ArrayList<Double>();
        //Llenando los arreglos
        for (int i = 0; i < getNumeroFilas(); i++) {
            u.add(Double.NaN);
        }
        u.set(0, new Double(0));
        for (int i = 0; i < getNumeroColumnas(); i++) {
            v.add(Double.NaN);
        }
        ArrayList<int[]> variablesBasicas = getVariablesBasicas();
        for (int i = 0; i < variablesBasicas.size(); i++) {
            int[] pos = variablesBasicas.get(i);
            if (u.get(pos[0]).equals(Double.NaN) && v.get(pos[1]).equals(Double.NaN)) {
                //TODO: Arrreglar problema de un posible bucle infinito si no se encuentra solucion
                variablesBasicas.add(i + 2, pos);
            } else if (u.get(pos[0]).equals(Double.NaN)) {
                u.set(pos[0], costos.get(pos[0]).get(pos[1]) - v.get(pos[1]));
            } else //Significa que v(i) es Double.NaN
            {
                v.set(pos[1], costos.get(pos[0]).get(pos[1]) - u.get(pos[0]));
            }
        }
    }

    private boolean calcularMayorPuntaje() {
        ArrayList<int[]> variablesNoBasicas = getVariablesNoBasicas();
        puntajes = new ArrayList<Double>();
        int[] res = new int[2];
        Double max = Double.NaN;
        //TODO: Solucionar posible NaN en los multiplicadores, validar mutiplicadores plgp
        for (int[] pos : variablesNoBasicas) {
            Double costoPosicion = costos.get(pos[0]).get(pos[1]);
            Double sumMultiplicadores = u.get(pos[0]) + v.get(pos[1]);
            Double puntaje = sumMultiplicadores - costoPosicion;
            if (max.equals(Double.NaN) || max < puntaje) {
                max = puntaje;
                posicionMayorPuntaje = pos;
            }
            puntajes.add(puntaje);
            //positivoEncontrado=positivoEncontrado||puntaje<0;
        }
        return max > 0;
    }

    private boolean crearCircuito() {
        verficadas = new boolean[getNumeroFilas()][getNumeroColumnas()];
        asignaciones.get(posicionMayorPuntaje[0]).get(posicionMayorPuntaje[1]).setTeta(asignarTeta());
        return !verificarAsignacion(verficadas, posicionMayorPuntaje, -1);
    }

    private boolean verificarAsignacion(boolean[][] tablaVerificadas, int[] posicion, int origen) {

        if (tablaVerificadas[posicion[0]][posicion[1]]) {
            if (coordenadasIguales(posicion, posicionMayorPuntaje) && totalEnCircuito > 2 && totalEnCircuito % 2 == 0) {
                return true;
            } else {
                return false;

            }
        } else {
            tablaVerificadas[posicion[0]][posicion[1]] = true;
            //Verificando si hay posibles caminos
            //Abajo
            if (origen != ABAJO) {
                for (int i = posicion[0] + 1; i < getNumeroFilas(); i++) {
                    int pos[] = new int[2];
                    pos[0] = i;
                    pos[1] = posicion[1];
                    if (asignaciones.get(pos[0]).get(pos[1]).isVariableBasica() || coordenadasIguales(pos, posicionMayorPuntaje)) {
                        totalEnCircuito++;
                        boolean circutoCerrado = verificarAsignacion(tablaVerificadas, pos, ARRIBA);
                        if (circutoCerrado) {
                            //JOptionPane.showMessageDialog(null, (posicion[0]+1)+", "+(posicion[1]+1)+"\n"+ "en circuito: "+totalEnCircuito);
                            asignaciones.get(posicion[0]).get(posicion[1]).setTeta(asignarTeta());
                            return circutoCerrado;
                        }
                        totalEnCircuito--;

                    }
                }
            }
            //Derecha
            if (origen != DERECHA) {
                for (int i = posicion[1] + 1; i < getNumeroColumnas(); i++) {
                    int pos[] = new int[2];
                    pos[0] = posicion[0];
                    pos[1] = i;
                    if (asignaciones.get(pos[0]).get(pos[1]).isVariableBasica() || coordenadasIguales(pos, posicionMayorPuntaje)) {
                        totalEnCircuito++;
                        boolean circutoCerrado = verificarAsignacion(tablaVerificadas, pos, IZQUIERDA);

                        if (circutoCerrado) {
                            //JOptionPane.showMessageDialog(null, (posicion[0]+1)+", "+(posicion[1]+1)+"\n"+ "en circuito: "+totalEnCircuito);
                            asignaciones.get(posicion[0]).get(posicion[1]).setTeta(asignarTeta());
                            return circutoCerrado;
                        }
                        totalEnCircuito--;
                    }

                }
            }
            //Arriba
            if (origen != ARRIBA) {
                for (int i = posicion[0] - 1; i >= 0; i--) {
                    int pos[] = new int[2];
                    pos[0] = i;
                    pos[1] = posicion[1];
                    if (asignaciones.get(pos[0]).get(pos[1]).isVariableBasica() || coordenadasIguales(pos, posicionMayorPuntaje)) {
                        totalEnCircuito++;
                        boolean circutoCerrado = verificarAsignacion(tablaVerificadas, pos, ABAJO);
                        if (circutoCerrado) {
                            //JOptionPane.showMessageDialog(null, (posicion[0]+1)+", "+(posicion[1]+1)+"\n"+ "en circuito: "+totalEnCircuito);
                            asignaciones.get(posicion[0]).get(posicion[1]).setTeta(asignarTeta());
                            return circutoCerrado;
                        }
                        totalEnCircuito--;

                    }
                }
            }
            //Izquierda
            if (origen != IZQUIERDA) {
                for (int i = posicion[1] - 1; i >= 0; i--) {
                    int pos[] = new int[2];
                    pos[0] = posicion[0];
                    pos[1] = i;
                    if (asignaciones.get(pos[0]).get(pos[1]).isVariableBasica() || coordenadasIguales(pos, posicionMayorPuntaje)) {
                        totalEnCircuito++;
                        boolean circutoCerrado = verificarAsignacion(tablaVerificadas, pos, DERECHA);
                        if (circutoCerrado) {
                            //JOptionPane.showMessageDialog(null, (posicion[0]+1)+", "+(posicion[1]+1)+"\n"+ "en circuito: "+totalEnCircuito);
                            asignaciones.get(posicion[0]).get(posicion[1]).setTeta(asignarTeta());
                            return circutoCerrado;
                        }
                        totalEnCircuito--;
                    }

                }
            }

            return false;

        }
    }

    private int asignarTeta() {
        tetaActual = tetaActual * -1;
        //JOptionPane.showMessageDialog(null, toString());
        //JOptionPane.showMessageDialog(null, "Asignado: " + tetaActual * -1);
        return tetaActual * -1;
    }

    private boolean coordenadasIguales(int[] co1, int[] co2) {
        return (co1[0] == co2[0] && co1[1] == co2[1]);
    }

    private void calcularNuevaTabla() {
        ArrayList<int[]> tetas = obtenerTetas();
        double mayorPosible = mayorValorPosibleTeta();
        boolean variableBasicaRemovida = false;
        for (int[] pos : tetas) {
            Asignacion asignacion = asignaciones.get(pos[0]).get(pos[1]);
            double nuevoValor = asignacion.getValor() + mayorPosible * asignacion.getTeta();
            asignacion.setValor(nuevoValor);
            asignacion.setTeta(0);
            if (nuevoValor == 0 && !variableBasicaRemovida) {
                asignacion.setVariableBasica(false);
                asignacion.setHabilitado(false);
                variableBasicaRemovida = true;
            }
            if (!asignacion.isVariableBasica()) {
                asignacion.setHabilitado(true);
                asignacion.setVariableBasica(true);
            }
        }
    }

    private double mayorValorPosibleTeta() {
        ArrayList<int[]> tetas = obtenerTetas();
        double max = 0;
        for (int[] pos : tetas) {
            Asignacion asignacion = asignaciones.get(pos[0]).get(pos[1]);
            if (asignacion.getTeta() == -1 && (max > asignacion.getValor() || max == 0)) {
                max = asignacion.getValor();
            }
        }
        return max;
    }
    public void setResumen(String res)
    {
        resumen=res;
    }

    public String getResumen() {
        return resumen;
    }
}
