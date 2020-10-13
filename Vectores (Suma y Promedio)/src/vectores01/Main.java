package vectores01;
import javax.swing.JOptionPane;
public class Main
{
public static void main(String[] args)
{
JOptionPane.showMessageDialog(null, "Este programa permirita crear y llenar\ndos vectores, A y B; y al final en un vector C\nse mostrará la suma de cada una de las\nposiciones de los vectores A y B en el vector C\ny ademas calcula los prmedios de los \nvalores de los vectores A, B y C");
int [] VectorA;
int [] VectorB;
int [] VectorC;
String valores="", VR="";
int VVA=0, VVB=0, VVC=0, pos=0;
VectorA= new int[5];
VectorB= new int[5];
VectorC= new int[5];
for (int i=0;i<=4;i++)
{
pos=i+1;
valores=JOptionPane.showInputDialog("Ingrese el valor para la posición "+pos+" del vector A");
VVA=Integer.parseInt(valores);
VectorA[i]= VVA;
}
for (int i=0;i<=4;i++)
{
pos=i+1;
valores=JOptionPane.showInputDialog("Ingrese el valor para la posición "+pos+" del vecdtor B");
VVB=Integer.parseInt(valores);
VectorB[i] = VVB;
}
for (int i=0;i<=4;i++)
{
VectorC[i]= VectorA[i] + VectorB[i];
VR = VR +" "+ VectorC[i];
}
JOptionPane.showMessageDialog(null, "El vector C resultante es: "+VR);
int sumaA=0, sumaB=0, sumaC=0;
for (int i=0;i<=4;i++)
{
sumaA = sumaA + VectorA[i];
sumaB = sumaB + VectorB[i];
sumaC = sumaC + VectorC[i];
}
double promA=0, promB=0, promC=0;
promA= sumaA/5;
promB= sumaB/5;
promC= sumaC/5;
String msjA="", msjB="", msjC="";
msjA= "Promedio del Vector A = "+promA+"\n";
msjB= "Promedio del Vector B = "+promB+"\n";
msjC= "Promedio del Vector C ="+promC+"\n";
JOptionPane.showMessageDialog(null, msjA+"\n"+msjB+"\n"+msjC);
}
}