/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package andrea;

/**
 *
 * @author USUARIO
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /** Frase a analizar */
        String frase = "No nos atrevemos a muchas cosas porque son difíciles, pero son difíciles porque no nos atrevemos a hacerlas.";

        /**
         * Declaramos e iniciamos las variables
         * para contar las vocales
         */
        int a, e, i, o, u;
        a = e = i = o = u = 0;

        /**
         * Obtenemos la longitud de la cadena
         */
        int longitud = frase.length();

        /**
         * Declaramos e iniciamos el indice
         * que recorrerá la cadena
         */
        int indice = 0;

        /**
         * Al obtener la letra la almacenamos en
         * la variable letra para compararla.
         */
        char letra;

        do {
            letra = frase.charAt(indice);

            switch (letra) {
                case 'a':
                case 'á':
                    a++;
                    break;
                case 'e':
                case 'é':
                    e++;
                    break;
                case 'i':
                case 'í':
                    i++;
                    break;
                case 'o':
                case 'ó':
                    o++;
                    break;
                case 'u':
                case 'ú':
                    u++;
                    break;
                default:
                    break;
            }

            indice++;
        } while (indice < longitud);

        System.out.println("Cantidad de letras 'a' en la frase: " + a);
        System.out.println("Cantidad de letras 'e' en la frase: " + e);
        System.out.println("Cantidad de letras 'i' en la frase: " + i);
        System.out.println("Cantidad de letras 'o' en la frase: " + o);
        System.out.println("Cantidad de letras 'u' en la frase: " + u);
    }
}


