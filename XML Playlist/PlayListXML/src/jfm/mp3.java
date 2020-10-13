package jfm;
import java.io.IOException;
import java.net.URL;
import javax.media.CannotRealizeException;
import javax.media.Manager;
import javax.media.NoPlayerException;
import javax.media.Player;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * @web http://jc-mouse.blogspot.com/
 * @author Mouse
 */
public class mp3 {

private Player mediaPlayer;

    public mp3(){System.out.println("by Mouse");}

    /* controles de reproduccion */
   public boolean play(String f){
       boolean ok=false;
       File file = new File(f);     
       if(existe(file)){
        try {            
            mediaPlayer = Manager.createRealizedPlayer(file.toURL()); 
            mediaPlayer.start();       
            ok=true;
        } catch (IOException ex) {
            Logger.getLogger(mp3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoPlayerException ex) {
            Logger.getLogger(mp3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CannotRealizeException ex) {
            Logger.getLogger(mp3.class.getName()).log(Level.SEVERE, null, ex);
        }
       }else{
        JOptionPane.showMessageDialog(null,"El archivo MP3 al que hace referencia NO EXISTE!!!!");
       }     
       return ok;
   }

   public void stop(){
     mediaPlayer.stop();    
    }
  
   //para determinar si un archivo existe
   private boolean existe(File  file){
       boolean ok=false;
       if(file.exists()){ok=true;}
       return ok;
   }
   
}
