/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author luis
 */
public class Actualizador {
    private Repositorio repositorios[];
    private Repositorio repositorioActual;
    
    public Actualizador(){
        repositorios = null;
        repositorioActual = null;
  
         
    }
    public Actualizador(Repositorio repos [], Repositorio repActual){
        this.repositorios = repos;
        this.repositorioActual = repActual;
        
    }

    /**
     * @return the repositorios
     */
    public Repositorio[] getRepositorios() {
        return repositorios;
    }

    /**
     * @param repositorios the repositorios to set
     */
    public void setRepositorios(Repositorio[] repositorios) {
        this.repositorios = repositorios;
    }

    /**
     * @return the repositorioActual
     */
    public Repositorio getRepositorioActual() {
        return repositorioActual;
    }

    /**
     * @param repositorioActual the repositorioActual to set
     */
    public void setRepositorioActual(Repositorio repositorioActual) {
        this.repositorioActual = repositorioActual;
    }

    /**
     * @return the carpetaTemporal
     */
    
}
