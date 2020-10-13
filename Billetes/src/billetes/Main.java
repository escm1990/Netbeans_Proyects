package billetes;
import javax.swing.JOptionPane;
public class Main
{
public static void main(String[] args)
{
JOptionPane.showMessageDialog(null, "Este programa permitirá determinar el numero\n\nMENOR de billetes que puede tener 'X' cantidad");
String dinero="";
int b100=0, b50=0, b20=0, b10=0, b5=0, b1=0, nb=0;
dinero=JOptionPane.showInputDialog("¿Cuántos dólares tienes?");
nb=Integer.parseInt(dinero);
while(nb>=100)
{
b100=nb/100;
nb=nb-(b100*100);
}
while(nb>=50)
{
b50=nb/50;
nb=nb-(b50*50);
}
while(nb>=20)
{
b20=nb/20;
nb=nb-(b20*20);
}
while(nb>=10)
{
b10=nb/10;
nb=nb-(b10*10);
}
while(nb>=5)
{
b5=nb/5;
nb=nb-(b5*5);
}
while(nb>=1)
{
b1=nb/1;
nb=nb-(b1*1);
}
JOptionPane.showMessageDialog(null, "Tienes "+b100+" billetes de $100\nTienes "+b50+" billetes de $50\nTienes "+b20+" billetes de $20\nTienes "+b10+" billetes de $10\nTienes "+b5+" billetes de $5\nTienes "+b1+" billetes de $1");
JOptionPane.showMessageDialog(null, "Gracias por utilizar este programa.");
}
}