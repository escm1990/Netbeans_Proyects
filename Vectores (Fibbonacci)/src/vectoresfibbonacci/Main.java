package vectoresfibbonacci;
import javax.swing.JOptionPane;
public class Main
{
public static void main(String[] args)
{
JOptionPane.showMessageDialog(null, "Este programa mostrará la serie\nde los números Fibbonacci que\nel usuario desee conocer");
int []vecfibbo;
String fibbonacci="";
int tam, esp, pos;
tam=Integer.parseInt(JOptionPane.showInputDialog("¿Cuántos Fibbonacci poseera la serie a mostrar?"));
vecfibbo=new int[tam];
esp=vecfibbo.length;
JOptionPane.showMessageDialog(null, "El vector posee "+esp+" espacios");
vecfibbo[0]=0;
vecfibbo[1]=1;
for(int i=2;i<=esp-1;i++)
{
vecfibbo[i]=vecfibbo[i-1]+vecfibbo[i-2];
fibbonacci=fibbonacci+" "+vecfibbo[i];
}
JOptionPane.showMessageDialog(null, "La serie Fibbonacci que el usuario desea conocer es la siguiente:\n"+vecfibbo[0]+" "+vecfibbo[1]+" "+fibbonacci);
JOptionPane.showMessageDialog(null, "\b\b\b\bGracias por usar mi programa\b\b\b\b");
}
}