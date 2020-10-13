package ejemplo;
import javax.swing.JOptionPane;
public class primera
{
int a=Integer.parseInt(JOptionPane.showInputDialog(("Ingrese el primer valor")));
int b=Integer.parseInt(JOptionPane.showInputDialog(("Ingrese el segundo valor")));
int c=0;
public void sumar()
{
c=a+b;
}
}
