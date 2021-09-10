package mx.com.gm.test.ciclovida;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mx.com.gm.domain.Contacto;

public class Estado4EliminarObjeto {
 
    public static void main(String[] args) {
        //Usar EMF
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
        // Crear objeto EntityManager
        EntityManager em = emf.createEntityManager();
        
        //declarar objeto
        Contacto contacto = new Contacto();
          
        //recuperar un objeto de la bd
        //1- transitivo
        contacto = em.find(Contacto.class, 3);
        
        em.getTransaction().begin();  
        
        //2. remove
        em.remove(em.merge(contacto));
        
        em.getTransaction().commit();
        
        //3. transitivo
        System.out.println("Contacto eliminado = "+ contacto);
        
    }
    
}
