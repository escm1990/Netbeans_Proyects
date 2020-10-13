package ejemplo;

// Una clase JPanel personalizada.
import java.awt.*;
import javax.swing.*;

public class PanelOvalo extends JPanel {
   private int diametro = 20;

   // dibujar un �valo del di�metro especificado
    @Override
   public void paintComponent( Graphics g )
   {
      super.paintComponent( g );

      g.fillOval( 20, 20, diametro, diametro );
   }

   // validar y establecer el di�metro, despu�s repintar 
   public void establecerDiametro( int nuevoDiametro )
   {
      // si el di�metro es inv�lido, usar valor predeterminado de 10
      diametro = ( nuevoDiametro >= 0 ? nuevoDiametro : 10 );
      repaint();
   }

   // utilizado por el administrador de esquemas para determinar el tama�o preferido
    @Override
   public Dimension getPreferredSize()
   {
      return new Dimension( 200, 200 );
   }

   // utilizado por el administrador de esquemas para determinar el tama�o m�nimo
    @Override
   public Dimension getMinimumSize()
   {
      return getPreferredSize();
   }

} // fin de la clase PanelOvalo