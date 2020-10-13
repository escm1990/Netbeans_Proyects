package burbuja;
import javax.swing.JOptionPane;
public class Main
{
public static void main(String[] args)
{
JOptionPane.showMessageDialog(null, "Este programa es el famoso\nMetodo de la Burbuja");
int [] Vector;
int ValorVector=0, tam=0, esp=0, temp=0, pos=0;
String Valores="", vecres="";
Valores=JOptionPane.showInputDialog("¿Cuantos espacios desea\nasignarle al vector?");
tam=Integer.parseInt(Valores);
Vector=new int[tam];
esp=Vector.length;
JOptionPane.showMessageDialog(null, "EL vector posee "+esp+" espacios");
for(int i=0;i<=esp-1;i++)
{
pos=i+1;
Valores=JOptionPane.showInputDialog("Ingrese el valor de la posición "+pos);
ValorVector=Integer.parseInt(Valores);
Vector[i]=ValorVector;
}
for(int i=0;i<=esp-1;i++)
{
for(int j=0;j<=esp-2;j++)
{
if(Vector[j]>Vector[j+1])
{
temp=Vector[j];
Vector[j]=Vector[j+1];
Vector[j+1]=temp;
}
}
}
for(int i=0;i<=esp-1;i++)
{
vecres=vecres+" "+Vector[i];
}
JOptionPane.showMessageDialog(null, "El vector ordenado es: "+vecres);
}
}