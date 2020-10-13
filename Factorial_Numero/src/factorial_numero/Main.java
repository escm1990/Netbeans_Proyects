/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package factorial_numero;

import javax.swing.JOptionPane;


/**
 *
 * @author escm1990
 */
public class Main {

private static String dato = JOptionPane.showInputDialog("Ingrese un valor");
private static int nuevo=Integer.parseInt(dato);

    public static void main(String[] args) {
        Tarea Obj=new Tarea();
        nuevo=8;
        Obj.setValor(nuevo);
        Obj.chepito();
      
    }

}
