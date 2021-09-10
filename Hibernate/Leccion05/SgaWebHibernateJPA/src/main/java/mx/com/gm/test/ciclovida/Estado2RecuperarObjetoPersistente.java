package mx.com.gm.test.ciclovida;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mx.com.gm.domain.Contacto;

public class Estado2RecuperarObjetoPersistente {
    
    public static void main(String[] args) {
        //Usar EMF
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
        // Crear objeto EntityManager
        EntityManager em = emf.createEntityManager();
        
        //declarar objeto
        Contacto contacto = new Contacto();
        
        //recuperar un objeto de la bd
        contacto = em.find(Contacto.class, 3);
        
        //detached
        System.out.println("Contacto recuperado = "+ contacto);
        
    }
}
