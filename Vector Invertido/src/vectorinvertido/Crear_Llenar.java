package vectorinvertido;

import javax.swing.JOptionPane;

public class Crear_Llenar {

    int[] vector;
    int valor, tam, temp;
    String ori = "", sal = "";

    public void crear() {
        tam = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño del vector"));
        vector = new int[tam];
    }

    public void llenar() {
    for(int i=0; i<tam; i++){
        valor=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor para la posición "+(i+1)));
        vector[i]=valor;
        ori=ori+valor;
    }
    }
}
