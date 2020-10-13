/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cuadradodeasteriscos;
import java.util.Scanner;
/**
 *
 * @author USUARIO
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n;
        Scanner input = new Scanner(System.in);
        System.out.print("ingrese la base");
        n = input.nextInt();
        int contador = 1;
        while (contador <= n) {
            int contador2 = 1;
            while (contador2 <= n) {
                System.out.print("*");
                contador2++;
            }
            System.out.println();
            contador++;
        }
    }
}
