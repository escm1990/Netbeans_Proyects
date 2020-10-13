/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ClienteChat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.media.*;
import javax.media.cdm.CaptureDeviceManager;
import java.io.*;
import java.awt.*;
import javax.media.MediaLocator;
import javax.swing.JOptionPane;

/**
 *
 * @author greg
 */
public class jmfVideo {

     //Controlador universal de windows
    private String dispositivo = "vfw:Microsoft WDM Image Capture (Win32):0";
    private Player player = null;

    public Component Componente(){
    Component componente_video;
        try {
            // Se obtiene el dispositivo
            CaptureDeviceInfo device = CaptureDeviceManager.getDevice(dispositivo);
            //se obtiene la fuente de datos de captura
//            MediaLocator localizador = device.getLocator();
            MediaLocator localizador = new MediaLocator("vfw:Microsoft WDM Image Capture (Win32):0");
            //El localizador es del tipo "vfw://0" video para windows
            //se crea el PLAYER y se ejecuta
            player = Manager.createRealizedPlayer(localizador);
            player.start();
        } catch (IOException ex) {
            System.out.println("Error en la entrada: " + ex.getMessage());
        } catch (NoPlayerException ex1) {
            System.out.println("Error al ejecutar player: " + ex1.getMessage());
        } catch (CannotRealizeException ex2) {
            System.out.println("Error al realizarlo: " + ex2.getMessage());
        }
        //Si se pudo crear el PLAYER, se obtiene el componente de video
        if ((componente_video = player.getVisualComponent()) != null) {
                //se da un tamaño al componente
                componente_video.setSize(176, 144);
                return componente_video;
            } else {
                JOptionPane.showMessageDialog(null,"No se pudo crear el video...");
                return null;
            }
    }
}
