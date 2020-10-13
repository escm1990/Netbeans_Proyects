/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mediaaritmetica;

import javax.swing.JOptionPane;

/**
 *
 * @author escm1990
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
    String numero;
    double n1=0,n2=0,n3=0,n4=0,n5=0,r=0;
    numero=JOptionPane.showInputDialog("Ingrese el primer numero");
    n1=Double.parseDouble(numero);
    numero=JOptionPane.showInputDialog("Ingrese el segundo numero");
    n2=Double.parseDouble(numero);
    numero=JOptionPane.showInputDialog("Ingrese el tercer numero");
    n3=Double.parseDouble(numero);
    numero=JOptionPane.showInputDialog("Ingrese el cuarto numero");
    n4=Double.parseDouble(numero);
    numero=JOptionPane.showInputDialog("Ingrese el quinto numero");
    n5=Double.parseDouble(numero);
    r=(n1+n2+n3+n4+n5)/5;
    JOptionPane.showMessageDialog(null,"La media aritmetica es: "+r);
    }

}
