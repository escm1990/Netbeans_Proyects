package estudioparaelparcial;
import javax.swing.JOptionPane;
public class Main {
public static void main(String[] args)
{
JOptionPane.showMessageDialog(null, "Este programa permitirá encontrar los numeros Fibbonacci\nque el usuario desee, desde el Cero hasta N Fibbonacci");
String texto="", res="";
int n=0, a=0, b=1, c=0;
texto=JOptionPane.showInputDialog("Ingrese el numero de Fibbonacci que desea conocer desde el cero hasta N");
n=Integer.parseInt(texto);
for(int x=3;x<=n;x++)
{
    c=a+b;
    a=b;
    b=c;
    res=res+" , "+c;
}
JOptionPane.showMessageDialog(null,"0 , 1"+res);
}
}