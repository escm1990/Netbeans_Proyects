package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ClienteEntidadPersona {
   
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        //el nombre de la unidad de persisntencia está definido en el persistence.xml
        EntityManagerFactory emf =  Persistence.createEntityManagerFactory("PersonaPU");
        
        //Instancia del objeto EntityManager
        EntityManager em = emf.createEntityManager();
        
        //Creando una transaccion para comenzar a trabajar con la base de datos
        EntityTransaction tx = em.getTransaction();
        
        //iniciando la transaccion
        tx.begin();
        
        //insertando un nuevo registro en la BD
        Persona persona = new Persona("Juanito", "Jones", "jjones@algo.com", "55221122");
        log.debug("Objeto a persistir: "+persona.toString());
        
        //persistir el objeto en la BD
        em.persist(persona);
        
        //terminar la transaccion y guardando los cambios en la BD   
        tx.commit();
        log.debug("Objeto persistido: "+persona.toString());
        
        //cerrando el EntityManager
        em.close();
        
    }
}
