package testClienteWS;

import clientews.servicio.ServicioSumarImplementacionService;
import clientews.servicio.ServicioSumarWS;

public class TestServicioSumarWS {

    public static void main(String[] args) {
        
        //crear una instancia del servicio web
        ServicioSumarWS servicioSumar = new ServicioSumarImplementacionService().getServicioSumarImplementacionPort();
        
        //llamando al servicio web
        System.out.println("Ejecutando ServicioSumarWS");
        int val1 = 2;
        int val2 = 3;
        int resultado = servicioSumar.sumar(val1, val2);
        System.out.println("El resultado es: "+resultado);
        System.out.println("Fin ServicioSumarWS");
        
    }
    
}
