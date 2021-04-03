
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        
        System.out.println("Digite una de las siguentes opciones para calcular el área de la figura:\n"
                + "1 - Circulo\n"
                + "2 - Cuadrado\n"
                + "3 - Rectángulo\n"
                + "4 - Triángulo\n");
        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();
        calcularArea(opcion);
    }

    //creando método
    public static void calcularArea(int opcion) {
       
        switch(opcion){
            case 1: areaCirculo(); break;
            case 2: areaCuadrado(); break;
            case 3: areaRectangulo(); break;
            case 4: areaTriangulo(); break;
            default: System.out.println("Opción no válida"); break;
        }
        
    }

    private static void areaCirculo() {
        System.out.println("Ha elegido el área del círculo");
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el radio del círculo:");
        double radio = sc.nextDouble();
        double area = Math.PI*Math.pow(radio, 2);
        System.out.println("El área del círculo es: "+ area);
    }

    private static void areaCuadrado() {
        System.out.println("Ha elegido el área del cuadrado");
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el valor del lado:");
        double lado = sc.nextDouble();
        double area = lado*lado;
        System.out.println("El área del cuadrado es: "+ area);
    }

    private static void areaRectangulo() {
        System.out.println("Ha elegido el área del regtángulo");
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el valor de la base:");
        double base = sc.nextDouble();
        System.out.println("Ingrese el valor de la altura:");
        double altura = sc.nextDouble();
        double area = base*altura;
        System.out.println("El área del rectángulo es: "+ area);
    }

    private static void areaTriangulo() {
        System.out.println("Ha elegido el área del triángulo");
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el valor de la base:");
        double base = sc.nextDouble();
        System.out.println("Ingrese el valor de la altura:");
        double altura = sc.nextDouble();
        double area = (base*altura)/2;
        System.out.println("El área del triángulo es: "+ area);    
    }    

   
}
