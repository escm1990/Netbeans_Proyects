/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author Chavez Vigil
 */
public class Usuario {
    
    private String usuario;
    private String password;
    private boolean admin;
    
    public Usuario(){
        this.usuario = "root";
        this.password = "admin";
        this.admin = true;
    }
    
    public Usuario(String name, String pass, boolean admin){
        this.usuario = name;
        this.password = pass;
        this.admin = admin;
    }

    /**
     * @return the Usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param Usuario the Usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the admin
     */
    public boolean isAdmin() {
        return admin;
    }

    /**
     * @param admin the admin to set
     */
    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
    
    
}
