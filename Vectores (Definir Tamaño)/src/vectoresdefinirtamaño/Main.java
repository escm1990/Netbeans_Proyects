package vectoresdefinirtamaño;
import javax.swing.JOptionPane;
public class Main
{
public static void main(String[] args)
{
JOptionPane.showMessageDialog(null, "El siguiente programa permitirá:\n\n1)Crear un vector en el que el usuario\ningresará el tamaño del mismo\n\n2)Llenar el vector con datos enteros o decimales\n\n3)Mostrar en pantalla el vector generado");
double [] Vector;
double valvec=0;
String valor="", vecres="";
int tam=0, esp=0;
valor=JOptionPane.showInputDialog("¿Cuantas posiciones poseerá el vector?");
tam=Integer.parseInt(valor);
Vector=new double[tam];
esp=Vector.length;
JOptionPane.showMessageDialog(null, "El vector posee "+esp+" posiciones");
for (int i=0;i<=esp-1;i++)
{
valor=JOptionPane.showInputDialog("Escriba el valor para la posicion "+i);
valvec=Double.parseDouble(valor);
Vector[i]=valvec;
vecres= vecres+" "+Vector[i];
}
JOptionPane.showMessageDialog(null, "El vector generado es: "+vecres);
}
}