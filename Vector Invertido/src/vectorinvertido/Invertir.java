package vectorinvertido;

import javax.swing.JOptionPane;

public class Invertir extends Crear_Llenar {

    public void invertir() {
        for (int a = 0, b = 1; a < tam; a++, b++) {
            temp = vector[a];
            vector[a] = vector[tam - b];
            vector[tam - b] = temp;
        }
        for (int i = 0; i < tam; i++) {
            sal = vector[i] + sal;
        }
        JOptionPane.showMessageDialog(null, "El vector original es: " + ori + "\nEl vector invertido es: " + sal);
    }
}