package busquedabinaria;
import javax.swing.JOptionPane;
public class Main
{
public static void main(String[] args)
{
int[]vector;
String dato="", msj="";
int tam=0, esp=0, pos=0, valor=0, temp=0, num=0, ini=0, fin=0, posbb=0, cont=0;
boolean Lo_Encontramos;
dato=JOptionPane.showInputDialog("¿Cuánto espacios desea asignarle al vector?");
tam=Integer.parseInt(dato);
vector=new int[tam];
esp=vector.length;
JOptionPane.showMessageDialog(null, "El vector generado posee "+esp+" posiciones");
for(int i=0;i<=esp-1;i++)
{
pos=i+1;
dato=JOptionPane.showInputDialog("Ingrese el valor para la posición "+pos);
valor=Integer.parseInt(dato);
vector[i]=valor;
}
for(int i=0;i<esp;i++)
{
for(int j=0;j<esp-1;j++)
{
if(vector[j]>vector[j+1])
{
temp=vector[j];
vector[j]=vector[j+1];
vector[j+1]=temp;
}
}
}
for(int i=0;i<esp;i++)
{
msj=msj+"\nPosición["+i+"] . . . . . "+vector[i];
}
JOptionPane.showMessageDialog(null, msj);
dato=JOptionPane.showInputDialog("¿Qué dato desea buscar?");
num=Integer.parseInt(dato);
ini=0;
fin=esp-1;
posbb=0;
Lo_Encontramos=false;
while(ini<=fin)
{
posbb=(ini+fin)/2;
if(vector[posbb]==num)
{
Lo_Encontramos=true;
break;
}
else
if(vector[posbb]<num)
ini=posbb+1;
else
fin=posbb-1;
}
if(Lo_Encontramos)
JOptionPane.showMessageDialog(null, "El valor "+num+" fue encontrado en la posición "+(posbb+1));
else
JOptionPane.showMessageDialog(null, "El valor "+num+" no fue encrontado en el vector ninguna vez");
}
}