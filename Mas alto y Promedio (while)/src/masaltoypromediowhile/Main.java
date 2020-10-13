/*
El siguiente ejemplo solicita una determinada cantidad de números y calcula el valor
más alto de ellos y su promedio.
*/

package masaltoypromediowhile;

import javax.swing.JOptionPane;

public class Main
{
public static void main(String[] args)
{
double valor=0, maximo=0, sumatoria=0;
int cont=1, datos=0;
datos=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero a calcular"));
while (cont <= datos)
{
valor=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor "+cont+" :"));
if (valor > maximo)
maximo = valor;
else
sumatoria += cont;
cont++;
}
JOptionPane.showMessageDialog(null, "El valor máximo es "+maximo+ " y el promedio es "+sumatoria /datos);
}
}