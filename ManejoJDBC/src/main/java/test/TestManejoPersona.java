package test;

import datos.PersonaDAO;
import domain.Persona;
import java.util.List;

public class TestManejoPersona {
    
    public static void main(String[] args) {
        
        //creando una nueva persona
        Persona personaIns = new Persona("Carlos", "Esparza", "cesparza@gmail.com", "5544667788");
        
        //Creando el objeto PersonaDAO que tiene el acceso a datos
        PersonaDAO personaDao = new PersonaDAO();
        //personaDao.insertar(personaIns);
        
        List<Persona> personas = personaDao.seleccionar();
        
        for(Persona persona: personas){
            System.out.println("persona "+persona);
        }
        
        /* Con notaciones lambda
            personas.forEach(persona -> {
                System.out.println("persona "+persona);
            });
        */
        
        System.out.println("--");
        
        //creando datos de la nueva persona para actualizar
        Persona personaUp = new Persona(3,"Ramon", "Valdez", "rvaldez@gmail.com", "999999999");        
        personaDao.actualizar(personaUp);
        
        personas = personaDao.seleccionar();
        personas.forEach(persona -> {
                System.out.println("persona "+persona);
        });

        System.out.println("--");

        //creando una nueva persona
        Persona personaIns2 = new Persona("Maria", "Magana", "mamagana@gmail.com", "6699552211");
        personaDao.insertar(personaIns2);
        
        personas = personaDao.seleccionar();
        personas.forEach(persona -> {
                System.out.println("persona "+persona);
        });
        
        System.out.println("--");

        personaDao.eliminar(5);
        
        personas = personaDao.seleccionar();    
        personas.forEach(persona -> {
                System.out.println("persona "+persona);
        });
        
        
    }
    
}
