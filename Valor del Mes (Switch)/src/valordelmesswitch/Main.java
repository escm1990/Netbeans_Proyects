/*
El siguiente ejemplo declara una variable llamada mes que representa el número de
mes del año. El programa muestra el nombre del mes, basado en el valor de mes.
*/

package valordelmesswitch;

import javax.swing.JOptionPane;

public class Main
{
public static void main(String[] args)
{
int mes=Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numero del 1 al 12"));
switch (mes)
{
    case 1: JOptionPane.showMessageDialog(null, "Enero"); break;
    case 2: JOptionPane.showMessageDialog(null, "Febrero"); break;
    case 3: JOptionPane.showMessageDialog(null, "Marzo"); break;
    case 4: JOptionPane.showMessageDialog(null, "Abril"); break;
    case 5: JOptionPane.showMessageDialog(null, "Mayo"); break;
    case 6: JOptionPane.showMessageDialog(null, "Junio"); break;
    case 7: JOptionPane.showMessageDialog(null, "Julio"); break;
    case 8: JOptionPane.showMessageDialog(null, "Agosto"); break;
    case 9: JOptionPane.showMessageDialog(null, "Septiembre"); break;
    case 10: JOptionPane.showMessageDialog(null, "Octubre"); break;
    case 11: JOptionPane.showMessageDialog(null, "Noviembre"); break;
    case 12: JOptionPane.showMessageDialog(null, "Diciembre"); break;
    default: JOptionPane.showMessageDialog(null, "No existe el mes "+mes); break;
}
}
}
