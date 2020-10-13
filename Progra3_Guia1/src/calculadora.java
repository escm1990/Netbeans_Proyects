/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luis Antonio
 */
import java.util.*; //espacio de nombres donde esta la clase scanner
public class calculadora
{
 final double pi=3.141592; //aplicacion de una constante
 public static double valor1 = 0,valor2 = 0;//variables donde se almacenaran los valores a operar
 private static int operacion = 0; //variable donde se almacenara el numero de la operacion que se desea realizar
/**
 *
 * Procedimiento encargado de leer y asignar los datos a valor1 y valor2.
 */
 public void leer(){
     Scanner lector = new Scanner(System.in);//objeto que permite leer desde consola
     System.out.println("Introduzca el primer valor:");
     valor1=lector.nextDouble();
     System.out.println("Introduzca el segundo valor:");
     valor2=lector.nextDouble();
 }
 /**
  *
  * Procedimiento encargado de mostrar las operaciones que se pueden realizar.
  */
 public void mostrar_operaciones(){
     System.out.println("Operaciones:");
     System.out.println("1-Sumar");
     System.out.println("2-Restar");
     System.out.println("3-Multiplicar");
     System.out.println("4-Dividir");
     System.out.println("5-Factorial del primer dato");
     System.out.println("6-Raiz cuadrada del primer dato");
     System.out.println("7-Area de un circulo con radio igual al valor 1");
     System.out.println("8-Numeros primos entre 1 y "+valor1);
     System.out.println("Introduzca el numero de la operacion que desea realizar");
     Scanner lector = new Scanner (System.in);
     operacion =lector.nextInt();
 }
 /**
  *
  * Funcion que "SUMA" los valores introducidos
  */
 public void sumar(){
     double res = valor1 + valor2;
     System.out.println(valor1+" + "+valor2+ "= "+res);
 }
 /**
  *
  * Funcion que "RESTA" los valores introducidos
  */
 public void restar(){
     double res = valor1 - valor2;
     System.out.println(valor1+" - "+valor2+ "= "+res);
 }
 /**
  *
  * Funcion que "MULTIPLICA" los valores introducidos
  */
 public void multiplicar(){
     double res = valor1 * valor2;
     System.out.println(valor1+" * "+valor2+ "= "+res);
 }
 /**
  *
  * Funcion que "DIVIDE" los valores introducidos
  */
 public void dividir(){
 //Se evalua en el if por si el valor 2 es igual a 0
     if (valor2 == 0){
         System.out.println("No se permite divicion entre cero");
     }
     else{
     double res= valor1 / valor2;
     System.out.println(valor1+" / "+valor2+ "= "+res);
     }
 }
 /**
  *
  * Funcion para encontrar el factorial del valor 1
  */
 public void factorial(){
//Se hace un casting por si tiene valores decimales
     int nuevo_valor_1 =(int)valor1;
     //Se evalua si el valor 1 es 0 para darle respuesta inmediata
     if(valor1 == 0){
         int res = 1;
      System.out.println("El factoria de: "+nuevo_valor_1+" ="+res );
     }
     else{
     int res = 1;
     for(int n=1; n<=nuevo_valor_1;n++){
         res=n*res;
     }
      System.out.println("El factoria de: "+nuevo_valor_1+" ="+res );
     }
 }
 /**
  *
  * Funcion para sacar la raiz cuadrada del valor 1
  */
 public void raiz(){
     double res = Math.sqrt(valor1);
        System.out.println("La raiz cuadrada de: "+valor1+" ="+res);
 }
 /**
  * 
  * Numeros primos entre el 1 y el valor 1
  */
 public void primos(){
     String num="1,";
     int nuevo_valor_1 =(int)valor1;
     if(nuevo_valor_1<=0){
      System.out.println("El dato ingresado no tiene numeros primos o es negativo");
     }else{
         if(nuevo_valor_1 == 1 ){
             System.out.println("Solamente 1 es primo");
         }else{
             for(int n=1;n<=nuevo_valor_1;n++){
                 int contador=0;
                 for(int t=1;t<=n;t++){
                   if(n%t==0){
                     contador++;
                     
                     }
                 }
                    if(contador == 2){
                         num = num+n+",";
             }
         }
             System.out.println("Los primos entre 1 y "+nuevo_valor_1+" son: "+num);
     }
     }
}
 /**
  * Utilizacion de la constante
  */
 public void area(){
     double res=Math.pow(valor1, 2)*pi;
     System.out.println("El area de un circulo con radio: "+valor1+" es: "+res);
 }
public void elegir_operacion(int op)
{
    switch(op)
    {
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
            raiz();
            break;
        case 7:
            area();
            break;
        case 8:
            primos();
            break;
        default:
            System.out.println("Error el elegir la operacion!!!");
            break;
    }
}
/**
 *
 * @Autor: Luis Antonio Moran Monzon
 */
public static void main(String args[]){
    calculadora cl=new calculadora();
    cl.leer();
    cl.mostrar_operaciones();
    cl.elegir_operacion(operacion);
}
}
