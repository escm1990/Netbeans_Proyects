package principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
1) Realizar un programa de consola que permita realizar las siguientes operaciones
a) Realizar una clase que permita capturar el nombre, apellido, genero, edad, 
estas propiedades deberán ser definidas mediante el modificador de acceso Privado y 
permitir que la instancia del objeto creada pueda realizarse directamente mediante la utilización de un método constructor.
b) Realizar un método que permita Capturar y retornar el nombre y el género de 5 personas capturadas por teclado.
c) Realizar un método que permita retornar el promedio de las edades capturadas.
d) Realizar un método que permita retornar la cantidad de personas con género Masculino.
e) Realizar un método que permita retornar la cantidad de personas con género Femenino.
*/

public class Main {

    public static void main(String[] args) {
        
        int cantidadPersonas = 5;
        List<Persona> personas = new ArrayList<>();
        
        for (int i = 0; i < cantidadPersonas; i++) {
            Scanner lectura = new Scanner (System.in);        
            System.out.println("Ingrese los datos de la persona "+(i+1)+":");
            System.out.println("Nombre: ");
            String nombre = lectura.next();
            System.out.println("Apellido: ");
            String apellido = lectura.next(); 
            System.out.println("Genero (M/F): ");
            String genero = lectura.next().toUpperCase();
            System.out.println("Edad: ");
            int edad = lectura.nextInt();
            System.out.println("\n");
            
            Persona personaIngresada = new Persona(nombre,apellido,genero,edad);
            personas.add(personaIngresada);
        }
        
        retornarNombreGenero(personas);
        retornarPromedioEdades(personas);
        retornarPersonasMasculinas(personas);
        retornarPersonasFemeninas(personas);
        
    }
  
    public static void retornarNombreGenero(List<Persona> personas) {
        for (int i = 0; i < personas.size(); i++) {
            System.out.println("Persona "+(i+1)+" --> Nombre: "+personas.get(i).getNombre()+" "+personas.get(i).getApellido()+", Género:"+personas.get(i).getGenero());
        }
    }
    
    public static void retornarPromedioEdades(List<Persona> personas){
        
        double sumaEdades = 0.0;
        for (int i = 0; i < personas.size(); i++) {
            sumaEdades = sumaEdades + (double) personas.get(i).getEdad();
        }
        
        double promedio =  sumaEdades / personas.size();
        System.out.println("El promedio de las edades es: "+promedio);
    }
    
    public static void retornarPersonasMasculinas(List<Persona> personas){
        int cantidadMasculino = 0;
        for (int i = 0; i < personas.size(); i++) {
            if(personas.get(i).getGenero().equals("M")){
            cantidadMasculino = cantidadMasculino + 1;
            }
        }
        
        System.out.println("La cantidad de personas masculinas es: "+cantidadMasculino);
    }
    
    public static void retornarPersonasFemeninas(List<Persona> personas){
        int cantidadFemenino = 0;
        for (int i = 0; i < personas.size(); i++) {
            if(personas.get(i).getGenero().equals("F")){
            cantidadFemenino = cantidadFemenino + 1;
            }
        }
        
        System.out.println("La cantidad de personas femeninas es: "+cantidadFemenino);
    }
}
