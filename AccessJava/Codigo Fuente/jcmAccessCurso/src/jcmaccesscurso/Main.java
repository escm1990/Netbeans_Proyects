package jcmaccesscurso;
/**
*  @web http://jc-mouse.blogspot.com/
 * @author Mouse
 */

import java.awt.EventQueue;
import javax.swing.JFrame;
import org.jvnet.substance.SubstanceLookAndFeel;

public class Main {

    public static void main(String[] args) {
       
        /* Si no se tiene instalado la libreria Substance */
        //new principal().show();
       
       
        /* si la libreria substance esta instalada y configurada */               
        EventQueue.invokeLater(new Runnable(){
        public void run(){
            try{
                JFrame.setDefaultLookAndFeelDecorated(true);                                
                SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.BusinessBlackSteelSkin");                
            }              
            catch(Exception e){
            }               
            new principal().setVisible(true);
        }
        });          
    }

}
