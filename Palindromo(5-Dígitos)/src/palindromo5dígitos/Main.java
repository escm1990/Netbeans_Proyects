package palindromo5dígitos;
import javax.swing.JOptionPane;
public class Main {
public static void main(String[] args) {
int dato = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un decimal de cinco dígitos"));
int r1=0, r2=0, r3=0, r4=0, r5=0, sal=dato;
r1=dato%10;
dato=dato/10;
r2=dato%10;
dato=dato/10;
r3=dato%10;
dato=dato/10;
r4=dato%10;
dato=dato/10;
r5=dato%10;
if(r1==r5 & r2==r4)
JOptionPane.showMessageDialog(null, "El decimal "+sal+" si es Palindromo");
else
JOptionPane.showMessageDialog(null, "El decimal "+sal+" no es Palindromo");
}
}

