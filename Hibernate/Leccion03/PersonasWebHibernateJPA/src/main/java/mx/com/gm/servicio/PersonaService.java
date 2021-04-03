package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.dao.PersonaDAO;
import mx.com.gm.domain.Persona;

public class PersonaService {
 
    private PersonaDAO personaDAO;
    
    public PersonaService(){
        this.personaDAO = new PersonaDAO();
    }
    
    public List<Persona> listarPersonas(){
        return personaDAO.listar();
    }
    
}
