package vectoreshistogramahorizontal;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
public class Main
{
public static void main(String[] args)
{
 int vec[];
        int tamaño;
        String captura,salida;
        salida= "elemento\tvalor\thistograma\n";
        captura=JOptionPane.showInputDialog(null,"tamaño del vector");
        tamaño=Integer.parseInt(captura);
        vec = new int [tamaño];

int valor=0;
        for(int contador=0 ; contador<vec.length;contador++){
           captura= JOptionPane.showInputDialog("datos para vec["+contador+"]");
            valor=Integer.parseInt(captura);
            vec[contador]=valor;
         salida += "\n" + contador + "\t" + vec[ contador ] + "\t";

         // imprimir barra de asteriscos
         for ( int estrellas = 0; estrellas < vec[ contador ]; estrellas++ )
            salida += "*";

      } // fin de instrucción for externa

      JTextArea areaSalida = new JTextArea();
      areaSalida.setText( salida );

      JOptionPane.showMessageDialog( null, areaSalida,
         "Programa para imprimir histogramas", JOptionPane.INFORMATION_MESSAGE );

      System.exit( 0 );
}
}