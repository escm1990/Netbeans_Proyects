package vectoresmáximosyminimos;
import javax.swing.JOptionPane;
public class Main
{
public static void main(String[] args)
{
JOptionPane.showMessageDialog(null,"El siguiente programa premitirá determinar\nlos valores máximos y mínimos\ningresados en un vector en el cual\nel ususario definirá el tamaño");
String val="";
int tam=0, esp=0, pos=0;
val=JOptionPane.showInputDialog("¿Cuántas posiciones poseerá el vector?");
tam=Integer.parseInt(val);
double valvec=0;
double[]vector;
vector=new double[tam];
esp=vector.length;
JOptionPane.showMessageDialog(null, "El vector posee "+esp+" posiciones");
for(int i=0;i<=esp-1;i++)
{
pos=i+1;
val=JOptionPane.showInputDialog("Ingrese el valor para la posición "+pos);
valvec=Double.parseDouble(val);
vector[i]=valvec;
}
double max=0;
double min=vector[0];
for(int i=0;i<=esp-1;i++)
{
if(max < vector[i])
    max = vector[i];
if(min > vector[i])
    min = vector[i];
}
JOptionPane.showMessageDialog(null, "El valor mayor del vector es "+max+"\nEl valor menor del vector es "+min);
}
}