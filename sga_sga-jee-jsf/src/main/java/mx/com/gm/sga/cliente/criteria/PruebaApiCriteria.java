package mx.com.gm.sga.cliente.criteria;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PruebaApiCriteria {
    
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        
        CriteriaBuilder cb = null;
        CriteriaQuery<Persona> criteriaQuery = null;
        Root<Persona> fromPersona = null;
        TypedQuery<Persona> query = null;
        Persona persona = null;
        List<Persona> personas = null;
        
        //1. Consulta de todas las personas
        //log.debug("\n1. Consulta de todas las personas");
        //paso 1 - El objeto EntityManager crea una instancia de CriteriaBuilder
        cb = em.getCriteriaBuilder();
        //paso 2 - Se crea un objeto CriteriaQuery
        criteriaQuery = cb.createQuery(Persona.class);
        //paso 3 - Creamos el objeto raíz del query
        fromPersona = criteriaQuery.from(Persona.class);
        //paso 4 - Seleccionamos lo necesario del from
        criteriaQuery.select(fromPersona);
        //paso 5 - Creamos el tipo de query typeSafe
        query = em.createQuery(criteriaQuery);
        //paso 6 - Ejecutar la consulta
        personas = query.getResultList();
        //mostrarPersonas(personas);
        
        //2a - Consulta de la persona con id=3
        //log.debug("\n2a - Consulta de la persona con id=3");
        cb = em.getCriteriaBuilder();
        criteriaQuery = cb.createQuery(Persona.class);
        fromPersona = criteriaQuery.from(Persona.class);
        criteriaQuery.select(fromPersona).where(cb.equal(fromPersona.get("idPersona"), 3));
        query = em.createQuery(criteriaQuery);
        persona =  query.getSingleResult();
        //log.debug(persona);
        
        //2b - Consulta de la persona con id=3 con predicados
        log.debug("\n2b - Consulta de la persona con id=3 con predicados");
        cb = em.getCriteriaBuilder();
        criteriaQuery = cb.createQuery(Persona.class);
        fromPersona = criteriaQuery.from(Persona.class);
        criteriaQuery.select(fromPersona);
        //La clase Predicate permite agregar varios criterios dinámicamente
        List<Predicate> criterios = new ArrayList<Predicate>();
        //Verificamos si tenemos criterios que agregar
        Integer idPersonaParam = 3;
        ParameterExpression<Integer> parametro = cb.parameter(Integer.class,"idPersona");
        criterios.add(cb.equal(fromPersona.get("idPersona"), parametro));
        //Se agregan los criterios
        if(criterios.isEmpty()){
            throw new RuntimeException("Sin criterios");
        }else if(criterios.size() == 1){
            criteriaQuery.where(criterios.get(0));
        } else {
            criteriaQuery.where(cb.and(criterios.toArray(new Predicate[0]))); //definiendo si tenemos varios criterios
        }
        query = em.createQuery(criteriaQuery);
        query.setParameter("idPersona", idPersonaParam);
        persona =  query.getSingleResult();
        log.debug(persona);
    }
    
    private static void mostrarPersonas(List<Persona> personas){
        for(Persona p : personas){
            log.debug(p);
        }
    }
    
}
