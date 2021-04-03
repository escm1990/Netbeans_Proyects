package mx.com.gm.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import mx.com.gm.domain.Persona;

public class PersonaDAO {
    
    //Declarando una variable EMF y el EM
    private EntityManagerFactory emf;
    private EntityManager em;
    
    public PersonaDAO(){
        emf = Persistence.createEntityManagerFactory("HibernatePU");
        em = emf.createEntityManager();
    }
    
    //Recuperando objetos por medio de HQL
    public void listar(){
        String hql = "SELECT p FROM Persona p";
        Query query = em.createQuery(hql);
        List<Persona> personas = query.getResultList();
        for(Persona p: personas){
            System.out.println("Persona: "+p);
        }
    }
    
    //realizando inserción (manejando transaccionalidad manual, pues NO se va a ejecutar la aplicación en un servidor empresarial)
    public void insertar(Persona persona){
        try {
            em.getTransaction().begin();
        em.persist(persona);
        em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            em.getTransaction().rollback();
        }
        /*finally{
            if(em != null){
                em.close();
            }
        } */       
    }
    
    //Modificar
    public void modificar(Persona persona){        
        try {
            em.getTransaction().begin();
            em.merge(persona);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            em.getTransaction().rollback();
        }
        /*finally{
            if(em != null){
                em.close();
            }
        } */       
    }
    
    //Eliminar
    //Modificar
    public void eliminar(Persona persona){        
        try {
            em.getTransaction().begin();
            em.remove(em.merge(persona));//para eliminar primero deben estar sincronizada la información de BD con merge
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            em.getTransaction().rollback();
        }
        /*finally{
            if(em != null){
                em.close();
            }
        } */       
    }
    
    public Persona buscarPersonaPorId(Persona p){
        return em.find(Persona.class, p.getId_persona());
    }
}
