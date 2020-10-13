package clasesymétodosejemploconvectores;
import javax.swing.JOptionPane;
public class agregar
{
int[]vector;
String concateneo="";
int esp, temp, pos, valor, valorvector, dato;
public void tamaño()
{
valor=Integer.parseInt(JOptionPane.showInputDialog("Introduzca el tamaño que poseerá el vector"));
esp=valor;
JOptionPane.showMessageDialog(null,"El tamaño del vector generado es "+esp);
vector=new int[valor+1];
JOptionPane.showMessageDialog(null,"El nuevo tamaño del vector es "+(valor+1));
}
public void llenaryordenar()
{
for(int i=0; i<=esp-1; i++)
{
valorvector=Integer.parseInt(JOptionPane.showInputDialog("Introduzca el valor para la posición "+(i+1)));
vector[i]=valorvector;
}
for(int i=0; i<=esp-1; i++)
{
for(int j=0; j<=esp-2; j++)
{
if(vector[j]>vector[j+1])
temp=vector[j];
vector[j]=vector[j+1];
vector[j+1]=temp;
}
}
}
public void datonuevo()
{
dato=Integer.parseInt(JOptionPane.showInputDialog("Ingrese un dato adicional\n(que sea menor al dato mayor\ningresado en la llenada del vector)"));
}
public void mostrar()
{
for(int a=0; a<=esp-1;a++)
{
concateneo=concateneo+" "+vector[a];
}
JOptionPane.showMessageDialog(null,"El nuevo vector es: "+concateneo);
}
}