package beans;

import javax.ejb.Stateless;

@Stateless 
public class HolaMundoEjbImplementation implements HolaMundoEjbRemote{

    @Override
    public int sumar(int a, int b) {
        System.out.println("Ejecutando metodos sumar en el servidor");
        return a+b;
    }
    
}
