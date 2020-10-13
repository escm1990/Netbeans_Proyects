package palindromo;
import javax.swing.JOptionPane;
public class Main
{
public static void main(String[] args)
{
JOptionPane.showMessageDialog(null, "Este programa permite determinar\nsi un numero de tres cifras es\no no un palindromo.");
String dato="";
int valor=0, valor1=0, residuo=0, residuo1=0;
dato=JOptionPane.showInputDialog("Introduzca un número de tres cifras");
valor=Integer.parseInt(dato);
residuo=valor%10;
valor=valor/10;
residuo1=valor%10;
valor1=valor/10;
if(residuo==valor1)
JOptionPane.showMessageDialog(null, dato+" Si es un palíndromo");
else
JOptionPane.showMessageDialog(null, dato+" No es un palíndromo");

JOptionPane.showMessageDialog(null, "Hola Leon");
}
}