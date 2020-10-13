/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Chavez Vigil
 */
public class Empresa{ 

    private String name;
    private String email;
    private String pass;
    private String passRepit;
    private String dir;

    public Empresa(){
        name = null;
        email = null;
        pass = null;
        dir = null;
        passRepit = null;
               
    }
    
    public Empresa(String name, String email, String pass, String passRe, String dir){
        this.name = name;
        this.email = email;
        this.pass = pass;
        this.passRepit = passRe;
        this.dir = dir;
                
    }
    

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * @return the dir
     */
    public String getDir() {
        return dir;
    }

    /**
     * @param dir the dir to set
     */
    public void setDir(String dir) {
        this.dir = dir;
    }

    /**
     * @return the passRepit
     */
    public String getPassRepit() {
        return passRepit;
    }

    /**
     * @param passRepit the passRepit to set
     */
    public void setPassRepit(String passRepit) {
        this.passRepit = passRepit;
    }
            
}
