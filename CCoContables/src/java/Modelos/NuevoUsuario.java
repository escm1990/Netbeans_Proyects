/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author p-rico
 */
public class NuevoUsuario {

    private String Usuario, Pass;
    
    public NuevoUsuario(){
        Usuario = "";
        Pass = "";
    }

    public NuevoUsuario(String usua, String pas) {
        Usuario = usua;
        Pass = pas;
    }

    /**
     * @return the Usuario
     */
    public String getUsuario() {
        return Usuario;
    }

    /**
     * @param Usuario the Usuario to set
     */
    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    /**
     * @return the Pass
     */
    public String getPass() {
        return Pass;
    }

    /**
     * @param Pass the Pass to set
     */
    public void setPass(String Pass) {
        this.Pass = Pass;
    }
    
}
