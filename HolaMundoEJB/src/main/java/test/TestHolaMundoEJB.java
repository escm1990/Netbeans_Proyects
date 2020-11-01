package test;

import beans.HolaMundoEjbRemote;
import javax.naming.*;

public class TestHolaMundoEJB {
    public static void main(String[] args) {
        System.out.println("Iniciando llamada al EJB desde el cliente\n");
        try {
            //ubicar el componente del lado del servidor para que el cliente lo tenta disponible
            Context jndi = new InitialContext();
            HolaMundoEjbRemote holaMundoEjbRemote = (HolaMundoEjbRemote) jndi.lookup("java:global/HolaMundoEJB/HolaMundoEjbImplementation!beans.HolaMundoEjbRemote");
            int resultado = holaMundoEjbRemote.sumar(5, 3);
            System.out.println("Suma: "+resultado);
        } catch (NamingException e) {
            e.printStackTrace(System.out);
        }
    }
}
