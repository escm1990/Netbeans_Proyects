/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package video;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author USUARIO
 */
public class Main extends Frame{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

// Creamos Ventana llamando al contructor de la clase
     Video Ventana = new  Video();


// Propiedades del Frame ...

    Ventana.setSize(new Dimension(500,400));
    Ventana.setVisible(true);
    Ventana.setTitle("Video WebCam");

    // Para cerrar la ventana
    Ventana.addWindowListener(
        new WindowAdapter() {
            @Override
          public void windowClosing(WindowEvent e) {
      System.exit(0);}});

    } // fin del metodo


   

}
