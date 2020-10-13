/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package video;

import java.awt.*;
import javax.media.*;
/**
 *
 * @author USUARIO
 */
public class Video extends Frame {

 // Reproductor de Video
  public static Player player = null;

 // Dispositivo de Captura
  public CaptureDeviceInfo Device = null;
  public MediaLocator Media_local = null;

// Constructor ...
public Video ()  {

    // Definimos el Acomodo en el Frame
    setLayout(new BorderLayout());

    System.out.println("Cargando .....");

    // Seleccion del dispositivo de Captura
    String Webcam = "vfw:Microsoft WDM Image Capture (Win32):0";

    Device = CaptureDeviceManager.getDevice(Webcam);
        // devolvemos el dispositivo antes obtenido
        Media_local = Device.getLocator();


    try  {

      // Iniciamos el Reproductor
      player = Manager.createRealizedPlayer(Media_local);
      player.start();

      // Almacenamos el reproductor en el componente
      Component comp = player.getVisualComponent();

      // Agregamos el componente al Frame
      add("Center",comp);

    } catch (Exception e)  {
      e.printStackTrace();
    }


  } // fin del constructor
}
