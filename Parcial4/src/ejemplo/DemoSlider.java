package ejemplo;

// Uso de objetos JSlider para ajustar el tama�o de un �valo.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class DemoSlider extends JFrame {
   private JSlider sliderDiametro;
   private PanelOvalo miPanel;

   // configurar GUI
   public DemoSlider() 
   {
      super( "Demostraci�n de JSlider" );

      // establecer PanelOvalo
      miPanel = new PanelOvalo();
      miPanel.setBackground( Color.YELLOW );

      // establecer objeto JSlider para controlar el valor del di�metro
      sliderDiametro = 
         new JSlider( SwingConstants.HORIZONTAL, 0, 200, 10 );
      sliderDiametro.setMajorTickSpacing( 10 );
      sliderDiametro.setPaintTicks( true );

      // registrar componente de escucha de eventos de JSlider
      sliderDiametro.addChangeListener(

         new ChangeListener() {  // clase interna an�nima

            // manejar cambio en el valor del control deslizable
            public void stateChanged( ChangeEvent e )
            {
               miPanel.establecerDiametro( sliderDiametro.getValue() );
            }

         } // fin de la clase interna an�nima

      ); // fin de la llamada a addChangeListener

      // adjuntar componentes al panel de contenido
      Container contenedor = getContentPane();
      contenedor.add( sliderDiametro, BorderLayout.SOUTH );
      contenedor.add( miPanel, BorderLayout.CENTER );

      setSize( 220, 270 );
      setVisible( true );

   } // fin del constructor de DemoSlider

   public static void main( String args[] )
   {
      DemoSlider aplicacion = new DemoSlider();
      aplicacion.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
   }

} // fin de la clase DemoSlider