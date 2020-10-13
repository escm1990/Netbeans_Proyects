package minimocomunmultiplo;
import javax.swing.JOptionPane;
public class Main {
    public static void main(String[] args)
    {
    JOptionPane.showMessageDialog(null, "Este programa permitira mostrar el MCM\nde cualquier numero y mostrarlo en pantalla.");
    String numero,multi="";
    int n=0,m=2;
    numero=JOptionPane.showInputDialog("Ingrese un numero");
    n=Integer.parseInt(numero);
    while(n>1)
    {
        if(n%m==0)
        {
            multi=multi+","+m;
            n=n/m;
        }
        else
            m++;
    }
    JOptionPane.showMessageDialog(null,"El MCM de "+n+" es: "+multi);
    }
}
