package factorial;
import javax.swing.JOptionPane;
public class Main
{
public static void main(String[] args)
{
JOptionPane.showMessageDialog(null, "Este programa permite encontrar\n\nel factorial de un número\n\ningresado por el usuario.");
String texto="";
int valor=0;
double fac=1;
texto=JOptionPane.showInputDialog("Ingrese el valor del que desea conocer el factorial");
valor=Integer.parseInt(texto);
for(int i=1;i<=valor;i++)
{
fac=fac*i;
}
JOptionPane.showMessageDialog(null, "El factorial de "+texto+" es: "+fac);
}
}