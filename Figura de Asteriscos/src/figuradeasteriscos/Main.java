package figuradeasteriscos;

import javax.swing.JOptionPane;

public class Main
{
public static void main(String[] args)
{
String sal="", ast="*";
int n=Integer.parseInt(JOptionPane.showInputDialog("Ingrese un valor"));
for (int i=1; i<=n; i++)
{
sal=sal+ast+"\n";
ast=ast+"*";
}
System.out.println("\n"+sal);
}
}
