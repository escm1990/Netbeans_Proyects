package mx.com.gm.test.ciclovida;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mx.com.gm.domain.Contacto;

public class Estado1Persistido {
    public static void main(String[] args) {
        //Usar EMF
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
        // Crear objeto EntityManager
        EntityManager em = emf.createEntityManager();
        
        //1. Estado transitivo (no tiene representación en la BD)
        Contacto contacto = new Contacto();
        contacto.setEmail("clara");
        contacto.setTelefono("11223344");
        
        //2. Pasar a estado persistente
        //Iniciar transaccion
        em.getTransaction().begin();
        em.persist(contacto);
        //em.flush();
        em.getTransaction().commit();
        
        //3. detached (sin relacion con la BD)
        System.out.println("contacto = "+contacto);
    }
}
