/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Utilizadas;
import javax.swing.JOptionPane;

/**
 *
 * @author USUARIO
 */
public class Codigo {

    private int Vec01[], Vec02[];
    private int tam, datos, nuevo_dato, equis;
    private String vecsal, vecord, vecordnue;

    public Codigo() {
        this.setTam(tam);
        this.setDatos(datos);
        this.setNuevo_dato(nuevo_dato);
        this.setVecsal(vecsal);
        this.setVecord(vecord);
        this.setVecordnue(vecordnue);
    }

    /**
     * @return the Vec01
     */
    public int[] getVec01() {
        return Vec01;
    }

    /**
     * @param Vec01 the Vec01 to set
     */
    public void setVec01(int[] Vec01) {
        this.Vec01 = Vec01;
    }

    /**
     * @return the Vec02
     */
    public int[] getVec02() {
        return Vec02;
    }

    /**
     * @param Vec02 the Vec02 to set
     */
    public void setVec02(int[] Vec02) {
        this.Vec02 = Vec02;
    }

    /**
     * @return the tam
     */
    public int getTam() {
        return tam;
    }

    /**
     * @param tam the tam to set
     */
    public void setTam(int tam) {
        this.tam = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño del Vector"));
    }

    /**
     * @return the datos
     */
    public int getDatos() {
        return datos;
    }

    /**
     * @param datos the datos to set
     */
    public void setDatos(int datos) {
        this.datos = datos;
    }

    /**
     * @return the nuevo_dato
     */
    public int getNuevo_dato() {
        return nuevo_dato;
    }

    /**
     * @param nuevo_dato the nuevo_dato to set
     */
    public void setNuevo_dato(int nuevo_dato) {
        this.nuevo_dato = nuevo_dato;
    }

    /**
     * @return the vecsal
     */
    public String getVecsal() {
        return vecsal;
    }

    /**
     * @param vecsal the vecsal to set
     */
    public void setVecsal(String vecsal) {
        this.vecsal = vecsal;
    }

    /**
     * @return the vecord
     */
    public String getVecord() {
        return vecord;
    }

    /**
     * @param vecord the vecord to set
     */
    public void setVecord(String vecord) {
        this.vecord = vecord;
    }

    /**
     * @return the vecordnue
     */
    public String getVecordnue() {
        return vecordnue;
    }

    /**
     * @param vecordnue the vecordnue to set
     */
    public void setVecordnue(String vecordnue) {
        this.vecordnue = vecordnue;
    }

}
