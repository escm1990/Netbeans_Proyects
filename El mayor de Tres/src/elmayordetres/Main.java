package elmayordetres;

import java.util.Iterator;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
      int limite = Integer.parseInt(JOptionPane.showInputDialog("Limite"));

        for (int i = 0; i<=limite; i++) {
            int valor = Integer.parseInt(JOptionPane.showInputDialog("valor "+(i+1)));

        }

        String numero = "";
        double a = 0, b = 0, c = 0, z = 0;
        numero = JOptionPane.showInputDialog("Ingrese el primer numero");
        a = Double.parseDouble(numero);
        numero = JOptionPane.showInputDialog("Ingrese el segundo numero");
        b = Double.parseDouble(numero);
        numero = JOptionPane.showInputDialog("Ingrese el tercer numero");
        c = Double.parseDouble(numero);
        if (a < b) {
            z = a;
        } else {
            z = b;
        }
        if (z < c) {
            JOptionPane.showMessageDialog(null, "El numero menor es: " + z);
        } else {
            JOptionPane.showMessageDialog(null, "El numero menor es: " + c);
        }
    }
}
