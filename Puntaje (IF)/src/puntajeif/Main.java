/*El siguiente ejemplo asigna una letra basado en valor obtenido en un examen: Una A
para un puntaje de 9 o más, una B para un puntaje de 8 o superior, una C para un
puntaje de 7 o superior, una D para un puntaje de 6 o superior y una F para cualquier
puntaje menor que 6.*/

package puntajeif;

import javax.swing.JOptionPane;

public class Main
{
public static void main(String[] args)
{
double puntaje;
char grado;
puntaje=Double.parseDouble(JOptionPane.showInputDialog("Ingrese su puntaje"));
if(puntaje >= 9)
{
grado = 'A';
}
else if (puntaje >= 8)
{
grado = 'B';
}
else if (puntaje >= 7)
{
grado = 'C';
}
else if (puntaje >= 6)
{
grado = 'D';
}
else if (puntaje >= 5)
{
grado = 'E';
}
else grado = 'F';
JOptionPane.showMessageDialog(null, "Su puntaje es "+grado);
}
}