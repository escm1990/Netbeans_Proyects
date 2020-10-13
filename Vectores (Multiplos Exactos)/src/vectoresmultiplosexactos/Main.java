package vectoresmultiplosexactos;

import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        int[] vector;
        int valor, dato, tam, temp;
        String sal = " ", mul = " ";
        tam = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño del vector"));
        vector = new int[tam];

        for (int i = 0; i < tam; i++) {
            valor = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor para la posición " + (i + 1)));
            vector[i] = valor;
            sal = sal + " " + valor;
        }
        temp = vector[0];
        for (int a = 0; a < tam; a++) {
            if (temp <= vector[a]) {
                temp = vector[a];
            }
        }
        dato = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el dato del cual se \nbuscaran sus multiplos en el vector"));
        for (int a = 1; a <= temp; a++) {
            for (int b = 0; b < tam; b++) {
                if (vector[b] % dato == 0) {
                    mul = mul + " " + vector[b];
                    a = temp++;
                }
            }
            break;
        }
        JOptionPane.showMessageDialog(null, "Los multiplos de " + dato + " que aparecen\nen el vector" + sal + "\nson" + mul);
    }
}