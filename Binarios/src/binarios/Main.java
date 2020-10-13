package binarios;
import javax.swing.JOptionPane;
public class Main
{
public static void main(String[] args)
{
JOptionPane.showMessageDialog(null, "Este programa permitirá convertir cualquier\n\nnúmero decimal entero en su equivalente en binario");
String valor="", convertido="", binario="";
int dato=0, residuo=0;
valor=JOptionPane.showInputDialog("Ingrese el decimal que desea convertir a binario");
dato=Integer.parseInt(valor);
while(dato>1)
{
residuo=dato%2;
dato=dato/2;
convertido=Integer.toString(residuo);
binario=convertido+binario;
}
JOptionPane.showMessageDialog(null, valor+" en binario es "+dato+binario);
}
}
