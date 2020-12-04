package mx.com.gm.sga.cliente.jpql;

import java.util.Iterator;
import java.util.List;
import javax.persistence.*;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.domain.Usuario;
import org.apache.logging.log4j.*;

public class PruebaJPQL {
    
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        String jpql = null;
        Query q = null;
        List<Persona> personas = null;
        Persona persona = null;
        Iterator iter = null; //iterar los elementos de una colección
        Object[] tupla = null;
        List<String> nombres = null;
        List<Usuario> usuarios = null;
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        
        //1. Consulta de todos los objetos de tipo Persona
        log.debug("\n1. Consulta de todas las Personas");
        jpql = "select p from Persona p";
        personas = em.createQuery(jpql).getResultList();
        //mostrarPersonas( personas );
        
        //2. Consula de la Persona con id = 1
        log.debug("\n2. consulta de la Persona con id = 1");
        jpql = "select p from Persona p where p.idPersona = 1";
        persona = (Persona) em.createQuery(jpql).getSingleResult();
        //log.debug(persona);
        
        //3. Consulta de la Persona por nombre
        jpql = "select p from Persona p where p.nombre = 'Karla'";
        personas = em.createQuery(jpql).getResultList();
        mostrarPersonas(personas);
        
        //4. Consulta de datos individuales, se crea una tupla (arreglo) de tipo object de 3 columnas
        log.debug("\n4.Consulta de datos individuales, se crea un arreglo (tupla) de tipo object de 3 columnas");
        jpql = "select p.nombre as Nombre, p.apellido as Apellido, p.email as Email from Persona p";
        iter = em.createQuery(jpql).getResultList().iterator();
        while(iter.hasNext()){
            tupla = (Object[]) iter.next();
            String nombre = (String) tupla[0];
            String apellido = (String) tupla[1];
            String email = (String) tupla[2];
            //log.debug("Nombres: "+nombre+", Apellidos: "+apellido+", Email: "+email);
        }
        
        //5. Obtiene el objeto Persona y el id, se crea un arreglo de tipo Object con 2 columnas
        log.debug("\n5. Obtiene el objeto Persona y el id, se crea un arreglo de tipo Object con 2 columnas");
        jpql = "select p, p.idPersona from Persona p";
        iter = em.createQuery(jpql).getResultList().iterator();
        while(iter.hasNext()){
            tupla = (Object[]) iter.next();
            persona = (Persona) tupla[0];
            int idPersona = (int) tupla[1];
            //log.debug("Objeto Persona: "+persona);
            //log.debug("ID Persona: "+idPersona);
        }
        
        //6. Consultar todas las personas
        log.debug("\n6. Consultar todas las personas");
        jpql = "select new mx.com.gm.sga.domain.Persona(p.idPersona) from Persona p"; //creando un objeto con jpql
        personas = em.createQuery(jpql).getResultList();
        //mostrarPersonas(personas);
    
        //7. Regresa el valor minimo y maximo de idPersona (scaler Return)
        log.debug("\n7. Regresa el valor minimo y maximo de idPersona (scaler Return)");
        jpql = "select min(p.idPersona) as MinId, max(p.idPersona) as MaxId, count(p.idPersona) as Contador from Persona p";
        iter = em.createQuery(jpql).getResultList().iterator();
        while(iter.hasNext()){
            tupla = (Object[]) iter.next();
            int idMin = (int) tupla[0];
            int idMax = (int) tupla[1];
            long count = (long) tupla[2];
            //log.debug("idMin: "+idMin+" idMax: "+idMax+" count: "+count);
        }
        
        //8. Cuenta los nombres de las personas que son distintos
        log.debug("\n8. Cuenta los nombres de las personas que son distintos");
        jpql = "select count(distinct p.nombre) from Persona p";
        Long contador = (Long) em.createQuery(jpql).getSingleResult();
        //log.debug("Numero de personas con nombre distinto: "+contador);
        
        //9. Concatenar y convertir a mayusculas el nombre y apellido
        log.debug("\n9. Concatenar y convertir a mayusculas el nombre y apellido");
        jpql = "select UPPER(CONCAT(p.nombre,' ',p.apellido)) as Nombre from Persona p";
        nombres = em.createQuery(jpql).getResultList();
        for(String nombreCompleto : nombres){
            //log.debug(nombreCompleto);
        }
        
        //10. Obtiene el objeto Persona con id igual al parámetro proporcionado
        log.debug("\n10. Obtiene el objeto Persona con id igual al parámetro proporcionado");
        int idPersona = 1;
        jpql = "select p from Persona p where p.idPersona = :id";
        q = em.createQuery(jpql);
        q.setParameter("id", idPersona);
        persona = (Persona) q.getSingleResult();
        //log.debug(persona);
        
        //11. Obtener las personas que contengan una letra "k" en el nombre
        log.debug("\n11. Obtener las personas que contengan una letra 'k' en el nombre");
        jpql = "select p from Persona p where upper(p.nombre) like upper(:parametro)";
        String parametro = "%k%";
        q = em.createQuery(jpql);
        q.setParameter("parametro", parametro);
        personas = q.getResultList();
        //mostrarPersonas(personas);

        //12. Uso de Between
        log.debug("\n12. Uso de Between");
        jpql = "select p from Persona p where p.idPersona between 1 and 5";
        personas = em.createQuery(jpql).getResultList();
        //mostrarPersonas(personas);
        
        //13. Uso del ordenamiento
        log.debug("\n13. Uso del ordenamiento");
        jpql = "select p from Persona p where p.idPersona > 3 order by p.nombre desc, p.apellido desc";
        personas = em.createQuery(jpql).getResultList();
        //mostrarPersonas(personas);
        
        //14. Uso de subqueries
        log.debug("\n14. Uso de subqueries");
        jpql = "select p from Persona p where p.idPersona in (select min(x.idPersona) from Persona x)";
        personas = em.createQuery(jpql).getResultList();
        //mostrarPersonas(personas);
        
        //15. Uso de join con lazy loading
        log.debug("\n15. Uso de join con lazy loading");
        jpql = "select u from Usuario u join u.persona p";
        usuarios = em.createQuery(jpql).getResultList();
        //mostrarUsuarios(usuarios);
        
        //16. Uso de left join con eager loading
        log.debug("\n16. Uso de left join con eager loading");
        jpql = "select u from Usuario u left join fetch u.persona";
        usuarios = em.createQuery(jpql).getResultList();
        mostrarUsuarios(usuarios);
    }
    
    private static void mostrarPersonas(List<Persona> personas) {
        for(Persona p: personas){ 
            log.debug(p);
        }
    }
    
    private static void mostrarUsuarios(List<Usuario> usuarios) {
        for(Usuario u: usuarios){ 
            log.debug(u);
        }
    }
}
