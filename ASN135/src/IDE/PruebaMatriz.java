/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package IDE;

import java.util.Random;

/**
 *
 * @author ESCM
 */
public class PruebaMatriz {

    /**
     * @param args the command line arguments
     * @throws MatrizNoOperableException
     */
    public static void main(String[] args) throws MatrizNoOperableException {
        /*Matriz a=llenarMatriz(new Matriz(4,5));
        System.out.println(a.toString());
        System.out.println(Matriz.transponer(a).toString());
        System.out.println(Matriz.invertir(a).toString());*/
}

    public static Matriz llenarMatriz(Matriz a)
    {
        Random r=new Random();
        int columnas=a.getNumeroColumnas();
        int filas=a.getNumeroFilas();
        for(int i=0;i<filas;i++)
        {
            for(int j=0;j<columnas;j++)
            {
                a.setValor(i, j,""+(r.nextInt(34)+1)+"/"+(r.nextInt(34)+1));
            }
        }
        return a;
    }
}
