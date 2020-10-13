/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apagarmáquina;
import javax.swing.*;
/**
 *
 * @author Chavez Vigil
 */
public class ApagarMáquina {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        Comando com = new Comando();
        String tiempo;
        int time = 0;
        String msj = "";

        try{
         tiempo = JOptionPane.showInputDialog("Ingrese el tiempo en segundos!"); 
         time = Integer.parseInt(tiempo);
         msj = "shutdown -s -t "+time;
        }catch(Exception e){
            System.out.println("ERROR");
        }
        System.out.println(msj);
        com.exec(msj); 
    }
}
