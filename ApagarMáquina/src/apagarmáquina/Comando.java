/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apagarmáquina;

import java.io.IOException;

/**
 *
 * @author Chavez Vigil
 */
public class Comando {
     public void exec(String cmd) { 
        try { 
            Runtime.getRuntime().exec(cmd); 
        }  
        catch (IOException e) { 
            System.out.println("Failed");         
        } 
}
}
