/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author USUARIO
 */
public class cuadratica {

    private double A;
    private double B;
    private double C;

    public cuadratica() {
        this.A = 0;
        this.B = 0;
        this.C = 0;
    }

    public cuadratica(double a, double b, double c) {
        this.A = a;
        this.B = b;
        this.C = c;
    }

    public double calcularX1() {
        double X;
        cuadratica CR1 = new cuadratica(this.A,this.B,this.C);
        X = (-CR1.getB() + (Math.sqrt((Math.pow(CR1.getB(), 2)) - (4) * (CR1.getA()) * (CR1.getC())))) / ((2) * (CR1.getA()));
        return X;
    }

     public double calcularX2() {
        double X;
        cuadratica CR2 = new cuadratica(this.A,this.B,this.C);
        X = (-CR2.getB() - (Math.sqrt((Math.pow(CR2.getB(), 2)) - (4) * (CR2.getA()) * (CR2.getC())))) / ((2) * (CR2.getA()));
        return X;
    }
    
     
     public double borrarX(){
         double X = 0.0;
         return X;
     }
    /**
     * @return the A
     */
    public double getA() {
        return A;
    }

    /**
     * @param A the A to set
     */
    public void setA(double A) {
        this.A = A;
    }

    /**
     * @return the B
     */
    public double getB() {
        return B;
    }

    /**
     * @param B the B to set
     */
    public void setB(double B) {
        this.B = B;
    }

    /**
     * @return the C
     */
    public double getC() {
        return C;
    }

    /**
     * @param C the C to set
     */
    public void setC(double C) {
        this.C = C;
    }
}
