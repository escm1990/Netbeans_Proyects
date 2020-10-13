/*
El siguiente ejemplo solicita un número y suma todos los números anteriores a él
empezando desde el número 1.
 */

package sumadeanterioresdowhile;

import javax.swing.JOptionPane;

public class Main
{
public static void main(String[] args)
{
int numero=0, cont=1, sumatoria=0;
numero=Integer.parseInt(JOptionPane.showInputDialog("Ingrese un valor numerico entero"));
do
{
sumatoria += cont;
++cont;
}
while(cont <= numero);
JOptionPane.showMessageDialog(null, "La suma de 1 a "+numero+" es "+sumatoria);
}
}
