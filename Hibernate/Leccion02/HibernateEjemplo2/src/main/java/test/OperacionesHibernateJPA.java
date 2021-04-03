package test;

import mx.com.gm.dao.PersonaDAO;
import mx.com.gm.domain.Persona;

public class OperacionesHibernateJPA {
    public static void main(String[] args) {
        PersonaDAO personaDAO = new PersonaDAO();
        personaDAO.listar();
        
        Persona persona = new Persona();
        persona.setId_persona(19);
        persona = personaDAO.buscarPersonaPorId(persona);
        System.out.println("personaEncontrada: "+persona);
        //personaDAO.insertar(persona);
        //persona.setApellido("Lirios");
        //persona.setNombre("Carlos");
        //personaDAO.modificar(persona);
        //personaDAO.eliminar(persona);
        //personaDAO.listar();
    }
}
