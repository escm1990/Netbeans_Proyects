/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author Usuario
 */
public class Informe {

    private String fecha;
    private int muestrasA;
    private int preN;
    private double prePor;
    private int ausN;
    private double ausPor;

    public Informe() {
        fecha="";
        muestrasA=0;
        preN=0;
        prePor=0;
        ausN=0;
        ausPor=0;
    }

    public Informe(String fecha, int muestrasA, int preN, double prePor, int ausN, double ausPor) {
        this.fecha=fecha;
        this.muestrasA=muestrasA;
        this.preN=preN;
        this.prePor=prePor;
        this.ausN=ausN;
        this.ausPor=ausPor;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the muestrasA
     */
    public int getMuestrasA() {
        return muestrasA;
    }

    /**
     * @param muestrasA the muestrasA to set
     */
    public void setMuestrasA(int muestrasA) {
        this.muestrasA = muestrasA;
    }

    /**
     * @return the preN
     */
    public int getPreN() {
        return preN;
    }

    /**
     * @param preN the preN to set
     */
    public void setPreN(int preN) {
        this.preN = preN;
    }

    /**
     * @return the prePor
     */
    public double getPrePor() {
        return prePor;
    }

    /**
     * @param prePor the prePor to set
     */
    public void setPrePor(double prePor) {
        this.prePor = prePor;
    }

    /**
     * @return the ausN
     */
    public int getAusN() {
        return ausN;
    }

    /**
     * @param ausN the ausN to set
     */
    public void setAusN(int ausN) {
        this.ausN = ausN;
    }

    /**
     * @return the ausPor
     */
    public double getAusPor() {
        return ausPor;
    }

    /**
     * @param ausPor the ausPor to set
     */
    public void setAusPor(double ausPor) {
        this.ausPor = ausPor;
    }

}
