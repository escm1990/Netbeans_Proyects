package Clases;

import javax.swing.JOptionPane;

public class Clase {

    private int vec1[], vec2[], tam, valores, temp, nuevo;
    private String vecori, vecor, vecnue;

    public Clase(){
        tam=0;
        valores=0;
        vecor="";
        vecnue="";
        vecori="";
        temp=0;
        nuevo=0;
    }

    public void Declarar_Tamaño(String datoTamaño){
        setTam(Integer.parseInt(datoTamaño));
    }

    public void Ingresar_Datos(String datos){
        for(int i=0;i<=getTam()-1;i++){
            setValores(Integer.parseInt(datos));
            if(i==getTam()){
                JOptionPane.showMessageDialog(null, "El vector esta lleno");
            }
        }
    }

    public void Llenar_Vector(int Valores){
        for(int i=0;i<=getTam()-1;i++){
            getVec1()[i]=getValores();
            setVecori(getVecori() + " " + getVec1()[i]);
        }
    }

    public void Ordenar_Vector(int tam, int vec1[]){
        for(int i=0;i<=tam-1;i++){
            for(int j=0;j<=tam-2;j++){
                if(vec1[j]>vec1[j+1]){
                    setTemp(vec1[j]);
                    vec1[j]=vec1[j+1];
                    vec1[j+1]=getTemp();
                }
            }
        }
    }

    public void Mostrar_Vec1_Ordenado(int tam, int vec1[], String vecor){
        for(int i=0; i<=tam-1; i++){
            vecor=vecor+" "+vec1[i];
        }
    }

    public void Pedir_Nuevo_Valor(String ND){
        setNuevo(Integer.parseInt(ND));
    }

    public void Ingresar_Nuevo_Valor(int tam, int nuevo, int valores){
        for(int i=0;i<=tam;i++){
            if(i==tam-1){
                getVec2()[i]=valores;
            }
            else{
                getVec2()[i]=nuevo;
            }
        }
    }

    public void Ordenar_Nuevo_Vector(int vec2[]){
        for(int i=0;i<=getTam()-1;i++){
            for(int j=0;j<=getTam()-2;j++){
                if(vec2[j]>vec2[j+1]){
                    setTemp(vec2[j]);
                    vec2[j]=vec2[j+1];
                    vec2[j+1]=getTemp();
                }
            }
        }
    }

    public void Mostrar_Nuevo_Vector(int tam, int vec2[], String vecnue){
        for(int i=0; i<=tam-1; i++){
            vecnue=vecnue+" "+vec2[i];
        }
    }

    public String toString(String vecori){
        return vecori;
    }

    public String toString1(String vecor) {
        return vecor ;
    }

    public String toString2(String vecnue){
        return vecnue;
    }

    /**
     * @return the vec1
     */
    public int[] getVec1() {
        return vec1;
    }

    /**
     * @param vec1 the vec1 to set
     */
    public void setVec1(int[] vec1) {
        this.vec1 = vec1;
    }

    /**
     * @return the vec2
     */
    public int[] getVec2() {
        return vec2;
    }

    /**
     * @param vec2 the vec2 to set
     */
    public void setVec2(int[] vec2) {
        this.vec2 = vec2;
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
        this.tam = tam;
    }

    /**
     * @return the valores
     */
    public int getValores() {
        return valores;
    }

    /**
     * @param valores the valores to set
     */
    public void setValores(int valores) {
        this.valores = valores;
    }

    /**
     * @return the temp
     */
    public int getTemp() {
        return temp;
    }

    /**
     * @param temp the temp to set
     */
    public void setTemp(int temp) {
        this.temp = temp;
    }

    /**
     * @return the nuevo
     */
    public int getNuevo() {
        return nuevo;
    }

    /**
     * @param nuevo the nuevo to set
     */
    public void setNuevo(int nuevo) {
        this.nuevo = nuevo;
    }

    /**
     * @return the vecori
     */
    public String getVecori() {
        return vecori;
    }

    /**
     * @param vecori the vecori to set
     */
    public void setVecori(String vecori) {
        this.vecori = vecori;
    }

    /**
     * @return the vecor
     */
    public String getVecor() {
        return vecor;
    }

    /**
     * @param vecor the vecor to set
     */
    public void setVecor(String vecor) {
        this.vecor = vecor;
    }

    /**
     * @return the vecnue
     */
    public String getVecnue() {
        return vecnue;
    }

    /**
     * @param vecnue the vecnue to set
     */
    public void setVecnue(String vecnue) {
        this.vecnue = vecnue;
    }
}