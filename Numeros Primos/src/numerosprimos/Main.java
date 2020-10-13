package numerosprimos;
import javax.swing.JOptionPane;
public class Main {
public static void main(String[] args)
    {
    JOptionPane.showMessageDialog(null, "Este programa permitira evaluar si un \nnumero cualquiera ingresado por el usuario\nes o no primo y mostrarlo en pantalla.");
    String numero;
    int n=0, c=0,d=1;
    numero=JOptionPane.showInputDialog("Ingrese un Numero");
    n=Integer.parseInt(numero);
    while(d<=n)
    {
        if(n%d==0)
        {  
            c++;
            d++;
        }
        else
            d++;        
    }
    if(c==2)
    JOptionPane.showMessageDialog(null,"El numero "+n+" si es primo");
    else
    JOptionPane.showMessageDialog(null,"El numero "+n+" no es primo");
    }
    }