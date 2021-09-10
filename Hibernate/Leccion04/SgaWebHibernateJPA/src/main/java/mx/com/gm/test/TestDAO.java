package mx.com.gm.test;

import java.util.List;
import mx.com.gm.dao.*;

public class TestDAO {
    
    public static void main(String[] args) {
    
        AlumnoDAO alumnoDAO = new AlumnoDAO();
        System.out.println("Alumnos: ");
        imprimir(alumnoDAO.listar());
        
        AsignacionDAO asignacionDAO = new AsignacionDAO();
        System.out.println("Asignacion: ");
        imprimir(asignacionDAO.listar());
        
        ContactoDAO contactoDAO = new ContactoDAO();
        System.out.println("Contactos: ");
        imprimir(contactoDAO.listar());
        
        CursoDAO cursoDAO = new CursoDAO();
        System.out.println("Cursos: ");
        imprimir(cursoDAO.listar());
        
        DomicilioDAO domicilioDAO = new DomicilioDAO();
        System.out.println("Domicilios: ");
        imprimir(domicilioDAO.listar());
    }
    
    private static void imprimir(List coleccion){
        for(Object o: coleccion){
            System.out.println("Valor: "+o);
        }
    }
}
