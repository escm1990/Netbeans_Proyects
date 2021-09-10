package mx.com.gm.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class GenericDAO {
    
    private static EntityManagerFactory emf;
    protected static EntityManager em;
    private static final String PU = "HibernateJpaPU";
    
    public GenericDAO(){
        if(emf == null){
            emf = Persistence.createEntityManagerFactory(PU);
        }
    }
    
    protected EntityManager getEntityManager(){
        if(em == null){
            em = emf.createEntityManager();
        }
        return em;
    }
    
}
