package vectorbuscarvalor;
import javax.swing.JOptionPane;
public class Main {
public static void main(String[] args) {
int vector[],temp=0, cont=0,Pos=0, tam=0, esp=0, posi;
String dato="",Posicion="";
tam=Integer.parseInt(JOptionPane.showInputDialog("¿Cuántos espacios poseerá el vector a generar?"));
vector=new int[tam];
esp=vector.length;
JOptionPane.showMessageDialog(null, "El vector posee "+esp+" posiciones");
for(int i=0;i<esp;i++)
{
posi=i+1;
int valor=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor de la posicion "+posi));
vector[i]=valor;
}
for(int i=0; i<esp;i++)
{
for(int a=0; a<esp-1;a++)
{
if(vector[a]>vector[a+1])
{
temp=vector[a];
vector[a]=vector[a+1];
vector [a+1]=temp;
}
}
}
int numero=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero a buscar en el vector"));
for(int i=0; i<esp; i++)
if(numero == vector[i])
{
cont++;
Pos=i+1;
Posicion=Posicion+Pos+", ";        
}
if(cont>0)
{
if(cont==1)
JOptionPane.showMessageDialog(null,"El numero si se encuentra en el vector\nEn la posicion "+Posicion+"\n y se repite "+cont+" veces");
else
JOptionPane.showMessageDialog(null,"El numero si se encuentra en el vector\nEn las posiciones "+Posicion+"\n y se repite "+cont+" veces");
}
else
{
JOptionPane.showMessageDialog(null,"El numero no se encuentra en el vector");
}
dato = "El vector Ordenado de Mayor a Menor\n";
int c= 9;
while(c>=0)
{
dato=(dato+"posicion "+(c+1)+" = "+vector[c]+"\n");
c--;
}
JOptionPane.showMessageDialog(null,dato);
}
}