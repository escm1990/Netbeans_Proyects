package test;

public class Clase {
    
    public static int recursiveT(int x){
            System.out.println("x - "+x);
            if(x<=1){
                return 1;
            }
            else{
                int salida =  x*recursiveT(x-1);
                System.out.println("salida - "+salida);
                return salida;
            }    
    }
        
    public static void main(String[] args) {
        int resultado = recursiveT(5);
        System.out.println(resultado);
    }

}
