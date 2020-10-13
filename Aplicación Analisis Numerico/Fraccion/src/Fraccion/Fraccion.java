/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Fraccion;

/**
 *Clase en la que se crearán las funciones
 * a utilizar al momento de usar fracciones
 * @author USUARIO
 */
public class Fraccion {

    private long num;
    private long den;

    /**
     * Constructor de la
     * Clase Fraccion
     */
    public Fraccion() {
        num = 0;
        den = 1;
    }

    /**
     * Constructor que recibe 2 parámetros tipo long
     * x y que representan el numerador y el denominador
     * @param x
     * @param y
     */
    public Fraccion(long x, long y) {
        num = x;
        den = y;
    }

    /**
     * Función que representa la
     * suma de 2 fracciones
     * @param a
     * @param b
     * @return res
     */
    public static Fraccion sumar(Fraccion a, Fraccion b) {
        Fraccion res = new Fraccion();
        res.num = a.num * b.den + a.den * b.num;
        res.den = a.den * b.den;
        return simplificar(res);
    }

    /**
     * Función que representa la
     * resta de 2 fracciones
     * @param a
     * @param b
     * @return
     */
    public static Fraccion restar(Fraccion a, Fraccion b) {
        Fraccion res = new Fraccion();
        res.num = a.num * b.den - a.den * b.num;
        res.den = a.den * b.den;
        return simplificar(res);
    }

    /**
     * Función que representa la
     * multiplicación de 2 fracciones
     * @param a
     * @param b
     * @return
     */
    public static Fraccion multiplicar(Fraccion a, Fraccion b) {
        Fraccion res = new Fraccion();
        res.num = a.num * b.num;
        res.den = a.den * b.den;
        return simplificar(res);
    }

    /**
     * Función que representa la
     * división de 2 fracciones
     * @param a
     * @param b
     * @return
     */
    public static Fraccion dividir(Fraccion a, Fraccion b) {
        Fraccion res = new Fraccion();
        res.num = a.num * b.den;
        res.den = a.den * b.num;
        return simplificar(res);
    }

    /**
     * Función que simplifica
     * la fracción
     * @param frac
     * @return
     */
    public static Fraccion simplificar(Fraccion frac) {
        long dividir = mcd(frac);
        frac.num /= dividir;
        frac.den /= dividir;
        return frac;
    }

    /**Método para obtener el MCD
     *del numerador y el denominador
     * @param frac
     * @return
     */
    private static long mcd(Fraccion frac) {
        long num = Math.abs(frac.num);
        long den = Math.abs(frac.den);
        if (den == 0) {
            return num;
        }
        long res;
        while (den != 0) {
            res = num % den;
            num = den;
            den = res;
        }
        return num;
    }

    /**
     * Función que muestra la fracción inversa a la que recibe.
     * Ej. si recibe 2/3 lo que devolverá la función será 3/2
     * @param frac
     * @return
     */
    public static Fraccion getInversa(Fraccion frac) {
        Fraccion res = new Fraccion();
        res.num = frac.den;
        res.den = frac.num;
        return res;
    }

    /**
     * Función que convierte en número uan fracción
     * que se ingrese como cadena de texto
     *
     * - Con Long.parseLong se convierte en long la cadena de texto que recibe.
     * - El método substring recibe 2 parámetros. Devuelve los caracteres de la cadena
     *   que se encuentran después del índice establecido como inicio y los que están
     *   antes del que establece como final.
     * @param cadenaFraccion
     * @return
     */
    public static Fraccion parseFraccion(String a) throws FractionFormatException {
        String f[] = a.split("/");
        try {
            Fraccion resultado;
            if (f.length == 2) {
                if (!f[1].equals("0")) {
                    resultado = new Fraccion(Long.parseLong(f[0]), Long.parseLong(f[1]));
                    return resultado;
                } else {
                    throw new FractionFormatException("Denominador igual a Cero");
                }
            } else if (f.length == 1) {
                resultado = new Fraccion(Long.parseLong(f[0]), 1);
                return resultado;
            } else {
                throw new FractionFormatException("Formato de fraccion incorrecto");
            }
        } catch (NumberFormatException ex) {
            throw new FractionFormatException("Formato de fraccion incorrecto");
        }
    }
    
    /**
     * Función que devolverá la fracción
     * @param fraccion
     * @return
     */
    public static Fraccion
    parseFraccion(long fraccion) {
        Fraccion frac = new Fraccion();
        return frac;
    }

    @Override
    public String toString() {
        return num + "/" + den;
    }
}
