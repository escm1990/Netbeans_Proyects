package test;

import datos.UsuarioDAO;
import domain.Usuario;
import java.util.List;

public class TestManejoUsuario {
    public static void main(String[] args) {
         //creando una nueva persona
        Usuario usuarioIns = new Usuario("usuario1","password1");
        
        //Creando el objeto PersonaDAO que tiene el acceso a datos
        UsuarioDAO usuarioDao = new UsuarioDAO();
        usuarioDao.insertar(usuarioIns);
        
        List<Usuario> usuarios = usuarioDao.seleccionar();
        
        for(Usuario usuarioF: usuarios){
            System.out.println("usuario "+usuarioF);
        }
        
        System.out.println("--");
        
        //creando datos de la nueva persona para actualizar
        Usuario usuarioUp = new Usuario("usuario2","password2");        
        usuarioDao.actualizar(usuarioUp);
        
        usuarios = usuarioDao.seleccionar();
        for(Usuario usuarioF: usuarios){
            System.out.println("usuario "+usuarioF);
        }

        System.out.println("--");

        //creando una nueva persona
        Usuario usuarioIns2 = new Usuario("usuario3","password3");
        usuarioDao.insertar(usuarioIns2);
        
        usuarios = usuarioDao.seleccionar();
        for(Usuario usuarioF: usuarios){
            System.out.println("usuario "+usuarioF);
        }
        
        System.out.println("--");

        usuarioDao.eliminar(3);
        
        usuarios = usuarioDao.seleccionar();
        for(Usuario usuarioF: usuarios){
            System.out.println("usuario "+usuarioF);
        }
        
        
    }
   
}
