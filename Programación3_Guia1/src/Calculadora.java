/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USUARIO
 */
import java.util.*; //Espacio de Nombres donde se encuentra Scanner

public class Calculadora {

    final double pi = 3.141592; //Aplicación de una Constante
    public static double valor1 = 0, valor2 = 0; // Variables donde se almacenaran los valores a operar
    private static int operacion = 0; //Variable donde se almacenara el numero de la operacion que se desea realizar

    /**
     *
     * Procedimiento encargado de leer y asignar los datos a valor1 y valor2
     */
    public void leer() {
        Scanner lector = new Scanner(System.in);//Objeto que permite leer desde consola
        System.out.println("Introduzca el primer valor");
        valor1 = lector.nextDouble();
        System.out.println("Introduzca el segundo valor");
        valor2 = lector.nextDouble();
    }

    /**
     *
     * Procedimiento encargado de mostrar las operaciones que se pueden realizar
     */
    public void mostrar_operaciones() {
        System.out.println("Operaciones");
        System.out.println("1- Sumar");
        System.out.println("2- Restar");
        System.out.println("3- Multiplicar");
        System.out.println("4- Dividir");
        System.out.println("5- Factorial del Primer dato");
        System.out.println("6- Raíz Cuadrada del primer dato");
        System.out.println("7- Área de un circulo con radio igual a valor1");
        System.out.println("8- Numeros primos entre 1 y " + valor1);
        System.out.println("Introduzca el número de la operación que desea realizar");
        Scanner lector = new Scanner(System.in);
        operacion = lector.nextInt();
    }

    /**
     *
     * Función que SUMA los valores ingresados
     */
    public void sumar() {
        double res = valor1 + valor2;
        System.out.println(valor1 + " + " + valor2 + " = " + res);
    }

    /**
     *
     * Función que RESTA los valores ingresados
     */
    public void restar() {
        double res = valor1 - valor2;
        System.out.println(valor1 + " - " + valor2 + " = " + res);
    }

    /**
     *
     * Función que MULTIPLICA los valores ingresados
     */
    public void multiplicar() {
        double res = valor1 * valor2;
        System.out.println(valor1 + " * " + valor2 + " = " + res);
    }

    /**
     *
     * Función que DIVIDE los valores ingresados, evaluando si valor2 es diferente de cero
     */
    public void dividir() {
        if (valor2 == 0) {
            System.out.println("Imposible efectuar división entre cero.");
        } else {
            double res = valor1 / valor2;
            System.out.println(valor1 + " / " + valor2 + " = " + res);
        }
    }

    /**
     *
     * Función que encuentra el FACTORIAL de valor1
     */
    public void factorial() {
        int fac = 1;
        valor1 = Math.rint(valor1);//Redondeamos al próximo entero mayor en caso de ser un decimal
        for (int i = 1; i <= valor1; i++) {
            fac = fac * i;
        }
        System.out.println("El factorial de " + valor1 + " es: " + fac);
    }

    /**
     *
     * Función que devuelve la RAIZ CUADRADA de valor1, evaluando si este no es negativo
     */
    public void raiz_cuadrada() {
        if (valor1 >= 0) {
            double res = Math.sqrt(valor1);
            System.out.println("La raíz cuadrada de " + valor1 + " es: " + res);
        } else {
            System.out.println("Imposible efectuar la raíz cuadrada de números negativos");
        }
    }

    /**
     *
     * Función que encuentra el AREA de un círculo de radio valor1
     */
    public void area() {
        double res = Math.pow(valor1, 2) * pi;//Para una mayor exactitud, se puede automáticamente multiplicar Math.pow(valor1, 2)*Math.PI;
        System.out.println("El área del círculo con radio " + valor1 + " es: " + res);
    }

    /**
     *
     * Función que muestra todos los NUMEROS PRIMOS desde 1 hasta valor1
     */
    public void primos() {
        String sal = "1,"; //Variable en la cual se concatenarán la rspuesta final
        int valor1_entero = (int) valor1; //Conversión de valor1 de double a entero
        if (valor1_entero <= 0) {
            System.out.println("Imposible encontrar los primos de " + valor1_entero + " pues es cero o negativo");
        } else {
            if (valor1_entero == 1) {
                System.out.println("1 es Primo");
            } else {
                for (int i = 1; i <= valor1_entero; i++) {
                    int cont = 0;
                    for (int j = 1; j <= i; j++) {
                        if (i % j == 0) {
                            cont++;
                        }
                    }
                    if (cont == 2) { //Si el contador es 2, significa que el número evaluado SI es primo
                        sal = sal + i + ",";//Almacenamiento de la respuesta final en una sola variable String
                    }
                }
                System.out.println("Los primos comprendidos entre 1 y " + valor1_entero + " son: " + sal);
            }
        }
    }

    /**
     * 
     * Procedimiento encargado e ejecutar la operación que se ha seleecionado
     * @param op es el número de la operación que se desea realizar
     */
    public void elegir_operación(int op) {
        switch (op) {
            case 1:
                sumar();
                break;
            case 2:
                restar();
                break;
            case 3:
                multiplicar();
                break;
            case 4:
                dividir();
                break;
            case 5:
                factorial();
                break;
            case 6:
                raiz_cuadrada();
                break;
            case 7:
                area();
                break;
            case 8:
                primos();
                break;
            default:
                System.out.println("Error al elegir operación");
                break;
        }
    }

    public static void main(String args[]) {
        Calculadora calc = new Calculadora();
        calc.leer();
        calc.mostrar_operaciones();
        calc.elegir_operación(operacion);
    }
}
