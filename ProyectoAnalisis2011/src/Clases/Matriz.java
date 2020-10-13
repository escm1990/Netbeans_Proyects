/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.ArrayList;

/**
 *
 * @author Edwin
 */
public class Matriz {

    private int filas;
    private int columnas;
    private ArrayList<ArrayList<Fraccion>> matriz;

    public Matriz() {
        matriz = new ArrayList<ArrayList<Fraccion>>();
    }

    public Matriz(int filas, int columnas) {
        matriz = new ArrayList<ArrayList<Fraccion>>();
        this.filas = filas;
        this.columnas = columnas;
        ArrayList<Fraccion> fila = new ArrayList<Fraccion>();
        for (int i = 0; i < columnas; i++) {
            fila.add(new Fraccion());
        }
        for (int i = 0; i < filas; i++) {
            matriz.add((ArrayList<Fraccion>) fila.clone());
        }
    }

    public void setValor(int fila, int columna, Fraccion fraccion) {
        matriz.get(fila).set(columna, fraccion);
    }

    public Fraccion getValor(int fila, int columna) {
        return matriz.get(fila).get(columna).clone();
    }

    public void setValor(int fila, int columna, long fraccion) {
        matriz.get(fila).set(columna, Fraccion.parseFraccion(fraccion));
    }

    public static Matriz sumar(Matriz a, Matriz b) throws MatrizNoOperableException {

            Matriz resultado = new Matriz(a.getFilas(), a.getColumnas());
            if (a.getFilas() == b.getFilas() && a.getColumnas() == b.getColumnas()) {
                for (int i = 0; i < a.getFilas(); i++) {
                    for (int j = 0; j < a.getColumnas(); j++) {
                        Fraccion suma = Fraccion.sumar(a.getValor(i, j), b.getValor(i, j));
                        resultado.setValor(i, j, suma);
                    }
                }
            } else {
                throw new MatrizNoOperableException("Error de Dimensión");
            }
            return resultado;


    }
     public static Matriz MultiplicarK(Matriz a, Matriz b) throws MatrizNoOperableException {

            Matriz resultado = new Matriz(a.getFilas(), a.getColumnas());
            if (a.getFilas() == b.getFilas() && a.getColumnas() == b.getColumnas()) {
                for (int i = 0; i < a.getFilas(); i++) {
                    for (int j = 0; j < a.getColumnas(); j++) {
                        Fraccion multiplicar = Fraccion.multiplicar(a.getValor(i, j), b.getValor(i, j));
                        resultado.setValor(i, j, multiplicar);
                    }
                }
            } else {
                throw new MatrizNoOperableException("Error de Dimensión");
            }
            return resultado;


    }

    /**
     *
     * @param a
     * @param b
     * @return
     * @throws MatrizNoOperableException
     */
    public static Matriz restar(Matriz a, Matriz b) throws MatrizNoOperableException {

            Matriz resultado = new Matriz(a.getFilas(), a.getColumnas());
            if (a.getFilas() == b.getFilas() && a.getColumnas() == b.getColumnas()) {
                for (int i = 0; i < a.getFilas(); i++) {
                    for (int j = 0; j < a.getColumnas(); j++) {
                        Fraccion resta = Fraccion.restar(a.getValor(i, j), b.getValor(i, j));
                        resultado.setValor(i, j, resta);
                    }
                }
            } else {
                throw new MatrizNoOperableException("Error de Dimensión");
            }
            return resultado;

    }

    public static Matriz multiplicar(Matriz a, Matriz b) throws MatrizNoOperableException {
        Matriz res = null;
        if (a.getFilas() == b.getColumnas()) {
            int filasA = a.getFilas();
            int columnasA = a.getColumnas();
            int columnasB = b.getColumnas();
            res = new Matriz(filasA, columnasB);
            for (int f = 0; f < filasA; f++) //Recorre las filas de la matriz resultado
            {
                for (int c = 0; c < columnasB; c++) //Recorre cada elemento de la fila actual en res
                {
                    for (int i = 0; i < columnasA; i++) {
                        Fraccion valorActual = res.getValor(f, c);
                        Fraccion productoPosActuales = Fraccion.multiplicar(a.getValor(f, i), b.getValor(i, c));
                        valorActual = Fraccion.sumar(valorActual, productoPosActuales);
                        res.setValor(f, c, valorActual);
                    }
                }
            }
        } else {
            throw new MatrizNoOperableException("Error al operar la matriz");
        }
        return res;
    }

    public static Matriz transponer(Matriz a) throws MatrizNoOperableException {
//        int filasT = a.getFilas();
//        int columnasT = a.getColumnas();
//        if (filasT == a.getFilas() && columnasT == a.getColumnas()) {
//            Matriz res = new Matriz(columnasT, filasT);
//            for (int i = 0; i < filasT; i++) {
//                for (int j = 0; j < columnasT; j++) {
//                    res.setValor(j, i, a.getValor(i, j));
//                }
//            }
//            return res;
//        } else {
//            throw new MatrizNoOperableException("Error al operar la matriz");
//        }
        int filasT = a.getFilas();
        int columnasT = a.getColumnas();
        if (filasT == a.getFilas() && columnasT == a.getColumnas()) {
            Matriz res = new Matriz(columnasT, filasT);
            for (int i = 0; i < filasT; i++) {
                for (int j = 0; j < columnasT; j++) {
                    res.setValor(j, i, a.getValor(i, j));
                }
            }
            return res;
        } else {
            throw new MatrizNoOperableException("Error al operar la matriz");
        }
    }

    public static Matriz invertir(Matriz a) throws MatrizNoOperableException {
//        //Usando el metodo visto en clases
//        Matriz res = a.clone();
//        Matriz identidad = Matriz.obtenerIdentidad(res);
//
//        int filas = a.getFilas();
//        int columnas = a.getColumnas();
//        //Creando triangular superior
//        int pivote = 0;
//        for (int i = pivote; i < columnas; i++)//Recorre las columnas
//        {
//            Fraccion valorPivote = res.getValor(pivote, pivote);
//
//            for (int k = pivote + 1; k < filas; k++)//Recorre cada valor en la fila debajo del pivote
//            {
//                if (valorPivote.equals(new Fraccion(0, 1))) {
//                    //TODO lanzar excepcion
//                } else {
//                    Fraccion valorActual = res.getValor(k, i);
//                    //Fraccion valorActualI=identidad.getValor(k, i);
//                    Fraccion valorAMultiplicar = Fraccion.getInversa(valorPivote);
//
//                    ArrayList<Fraccion> filaARestar = Matriz.multiplicarFila((ArrayList<Fraccion>) res.getFila(pivote).clone(), valorAMultiplicar);//Vuelve el pivote 1
//                    ArrayList<Fraccion> filaARestarI = Matriz.multiplicarFila((ArrayList<Fraccion>) identidad.getFila(pivote).clone(), valorAMultiplicar);//Vuelve el pivote 1
//
//                    filaARestarI = Matriz.multiplicarFila(filaARestarI, valorActual);
//                    filaARestar = Matriz.multiplicarFila(filaARestar, valorActual);//El pivote que ahora es uno por el valor al que le vamos a restar el mismo
//
//                    ArrayList<Fraccion> nuevaFila = Matriz.restarFilas(res.getFila(k), filaARestar);
//                    ArrayList<Fraccion> nuevaFilaI = Matriz.restarFilas(identidad.getFila(k), filaARestarI);
//                    res.setFila(k, nuevaFila);
//                    identidad.setFila(k, nuevaFilaI);
//                }
//            }
//            pivote++;
//        }
//
//        //Creando triangular inferior
//        pivote = columnas - 1;
//        for (int i = pivote; i >= 0; i--)//Recorre las columnas (desde atras)
//        {
//            Fraccion valorPivote = res.getValor(pivote, pivote);
//            for (int k = pivote - 1; k >= 0; k--)//Recorre cada valor en la fila arriba del pivote
//            {
//                if (valorPivote.equals(new Fraccion(0, 1))) {
//                    //TODO lanzar excepcion
//                } else {
//                    Fraccion valorActual = res.getValor(k, i);
//                    //Fraccion valorActualI=identidad.getValor(k, i);
//
//                    Fraccion valorAMultiplicar = Fraccion.getInversa(valorPivote);
//
//                    ArrayList<Fraccion> filaARestar = Matriz.multiplicarFila((ArrayList<Fraccion>) res.getFila(pivote).clone(), valorAMultiplicar);//Vuelve el pivote 1
//                    ArrayList<Fraccion> filaARestarI = Matriz.multiplicarFila((ArrayList<Fraccion>) identidad.getFila(pivote).clone(), valorAMultiplicar);//Vuelve el pivote 1
//
//                    filaARestarI = Matriz.multiplicarFila(filaARestarI, valorActual);
//                    filaARestar = Matriz.multiplicarFila(filaARestar, valorActual);//El pivote que ahora es uno por el valor al que le vamos a restar el mismo
//
//                    ArrayList<Fraccion> nuevaFila = Matriz.restarFilas(res.getFila(k), filaARestar);
//                    ArrayList<Fraccion> nuevaFilaI = Matriz.restarFilas(identidad.getFila(k), filaARestarI);
//                    res.setFila(k, nuevaFila);
//                    identidad.setFila(k, nuevaFilaI);
//                }
//            }
//            pivote--;
//        }
//
//        //Convirtiendo diagonal en unos
//        for (int i = 0; i < columnas; i++)//Recorre las columnas
//        {
//            Fraccion valorPivote = res.getValor(i, i); //i=pivote
//
//            ArrayList<Fraccion> nuevaFila = Matriz.multiplicarFila(res.getFila(i), Fraccion.getInversa(valorPivote));
//            ArrayList<Fraccion> nuevaFilaI = Matriz.multiplicarFila(identidad.getFila(i), Fraccion.getInversa(valorPivote));
//            res.setFila(i, nuevaFila);
//            identidad.setFila(i, nuevaFilaI);
//        }
//        //System.out.println(identidad.toString());
//        return identidad;
                //Usando el metodo visto en clases
        Matriz res = a.clone();
        Matriz identidad = Matriz.obtenerIdentidad(res);

        int filas = a.getFilas();
        int columnas = a.getColumnas();
        //Creando triangular superior
        int pivote = 0;
        for (int i = pivote; i < columnas; i++)//Recorre las columnas
        {
            Fraccion valorPivote = res.getValor(pivote, pivote);

            for (int k = pivote + 1; k < filas; k++)//Recorre cada valor en la fila debajo del pivote
            {
                if (valorPivote.equals(new Fraccion(0, 1))) {
                    //TODO lanzar excepcion
                } else {
                    Fraccion valorActual = res.getValor(k, i);
                    //Fraccion valorActualI=identidad.getValor(k, i);
                    Fraccion valorAMultiplicar = Fraccion.getInversa(valorPivote);

                    ArrayList<Fraccion> filaARestar = Matriz.multiplicarFila((ArrayList<Fraccion>) res.getFila(pivote).clone(), valorAMultiplicar);//Vuelve el pivote 1
                    ArrayList<Fraccion> filaARestarI = Matriz.multiplicarFila((ArrayList<Fraccion>) identidad.getFila(pivote).clone(), valorAMultiplicar);//Vuelve el pivote 1

                    filaARestarI = Matriz.multiplicarFila(filaARestarI, valorActual);
                    filaARestar = Matriz.multiplicarFila(filaARestar, valorActual);//El pivote que ahora es uno por el valor al que le vamos a restar el mismo

                    ArrayList<Fraccion> nuevaFila = Matriz.restarFilas(res.getFila(k), filaARestar);
                    ArrayList<Fraccion> nuevaFilaI = Matriz.restarFilas(identidad.getFila(k), filaARestarI);
                    res.setFila(k, nuevaFila);
                    identidad.setFila(k, nuevaFilaI);
                }
            }
            pivote++;
        }

        //Creando triangular inferior
        pivote = columnas - 1;
        for (int i = pivote; i >= 0; i--)//Recorre las columnas (desde atras)
        {
            Fraccion valorPivote = res.getValor(pivote, pivote);
            for (int k = pivote - 1; k >= 0; k--)//Recorre cada valor en la fila arriba del pivote
            {
                if (valorPivote.equals(new Fraccion(0, 1))) {
                    //TODO lanzar excepcion
                } else {
                    Fraccion valorActual = res.getValor(k, i);
                    //Fraccion valorActualI=identidad.getValor(k, i);

                    Fraccion valorAMultiplicar = Fraccion.getInversa(valorPivote);

                    ArrayList<Fraccion> filaARestar = Matriz.multiplicarFila((ArrayList<Fraccion>) res.getFila(pivote).clone(), valorAMultiplicar);//Vuelve el pivote 1
                    ArrayList<Fraccion> filaARestarI = Matriz.multiplicarFila((ArrayList<Fraccion>) identidad.getFila(pivote).clone(), valorAMultiplicar);//Vuelve el pivote 1

                    filaARestarI = Matriz.multiplicarFila(filaARestarI, valorActual);
                    filaARestar = Matriz.multiplicarFila(filaARestar, valorActual);//El pivote que ahora es uno por el valor al que le vamos a restar el mismo

                    ArrayList<Fraccion> nuevaFila = Matriz.restarFilas(res.getFila(k), filaARestar);
                    ArrayList<Fraccion> nuevaFilaI = Matriz.restarFilas(identidad.getFila(k), filaARestarI);
                    res.setFila(k, nuevaFila);
                    identidad.setFila(k, nuevaFilaI);
                }
            }
            pivote--;
        }

        //Convirtiendo diagonal en unos
        for (int i = 0; i < columnas; i++)//Recorre las columnas
        {
            Fraccion valorPivote = res.getValor(i, i); //i=pivote

            ArrayList<Fraccion> nuevaFila = Matriz.multiplicarFila(res.getFila(i), Fraccion.getInversa(valorPivote));
            ArrayList<Fraccion> nuevaFilaI = Matriz.multiplicarFila(identidad.getFila(i), Fraccion.getInversa(valorPivote));
            res.setFila(i, nuevaFila);
            identidad.setFila(i, nuevaFilaI);
        }
        //System.out.println(identidad.toString());
        return identidad;
    }

    private void setFila(int posicion, ArrayList<Fraccion> fila) {
        matriz.set(posicion, fila);
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public ArrayList<Fraccion> getFila(int fila) {
        return matriz.get(fila);
    }

    public ArrayList<Fraccion> getColumna(int columna) {
        throw new UnsupportedOperationException("no soportado aún");
    }

    @Override
    public String toString() {
        String res = "";
        for (ArrayList<Fraccion> fila : matriz) {
            for (int i = 0; i < fila.size(); i++) {
                Fraccion fraccion = fila.get(i);
                res = res + (i == 0 ? "| " : "") + fraccion.toString() + " | ";
            }
            res = res + "\n";
        }
        return res;
    }

    @Override
    public Matriz clone() {
        Matriz res = new Matriz(this.getFilas(), this.getColumnas());
        for (int i = 0; i < res.getFilas(); i++) {
            for (int k = 0; k < res.getColumnas(); k++) {
                res.setValor(i, k, this.getValor(i, k).clone());
            }
        }
        return res;
    }

    public static ArrayList<Fraccion> multiplicarFila(ArrayList<Fraccion> fila, Fraccion fraccion) {
        ArrayList<Fraccion> res = new ArrayList<Fraccion>();
        for (Fraccion fraccionOriginal : fila) {
            res.add(Fraccion.multiplicar(fraccionOriginal, fraccion));
        }
        return res;
    }

    public static ArrayList<Fraccion> restarFilas(ArrayList<Fraccion> a, ArrayList<Fraccion> b) {
        ArrayList<Fraccion> res = new ArrayList<Fraccion>();
        for (int i = 0; i < a.size(); i++) {
            res.add(Fraccion.restar(a.get(i), b.get(i)));
        }
        return res;
    }

    public static Matriz obtenerIdentidad(Matriz a) throws MatrizNoOperableException {
        Matriz res = new Matriz(a.getFilas(), a.getColumnas());
        if (a.getColumnas() == a.getFilas()) {
            for (int i = 0; i < a.getColumnas(); i++) {
                res.setValor(i, i, 1);
            }
        } else {
            throw new MatrizNoOperableException("Error al operar la matriz");
        }
        return res;
    }
}
