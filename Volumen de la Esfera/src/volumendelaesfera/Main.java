package volumendelaesfera;
import javax.swing.JOptionPane;
public class Main
{
public static void main(String[] args)
{
JOptionPane.showMessageDialog(null, "Este programa permitirá determinar\nel volumen de una esfera.\n\nEl usuario solamente deberá ingresar\nel valor del radio de la misma.");
String dato="";
double radio=0, volumen=0;
dato=JOptionPane.showInputDialog("Ingrese cuanto mide el radio de la esfera");
radio=Double.parseDouble(dato);
volumen=4/3*(Math.PI)*(Math.pow(radio,3));
JOptionPane.showMessageDialog(null, "El volumen de la esfera es:\n\n"+volumen);
}
}
