package test;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import mx.com.gm.domain.Persona;

public class HolaMundoHibernate {
    public static void main(String[] args) {
        //Sentencia en HQL -- p=alias, Persona=nombre clase entidad (no de tabla)
        String hql = "SELECT p FROM Persona p";
        //Creando el EntityManagerFactory utilizando la unidad de persistencia
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("HibernateEjemplo1");
        //Creando el EM
        EntityManager em = fabrica.createEntityManager();
        
        //Esto retornará objetos java del tipo de la entidad proporcionada
        Query query = em.createQuery(hql);
        List<Persona> personas = query.getResultList();
        for(Persona p: personas){
            System.out.println("Persona: "+p);
        }
        
    }
}
