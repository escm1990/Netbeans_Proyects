/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package parcial4;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
/**
 *
 * @author Fam Olmedo
 */
public class PruebaJSpinner {
/** El JTextField */
private JTextField tf;
/** El JSpinner */
private JSpinner spinner;
/** La ventana */
private JFrame v;
/**
* Crea una instancia de esta clase.
* @param args
*/
public static void main(String[] args) {
new PruebaJSpinner();
}
/**
* Crea la ventana con el JSpinner y el JTextField. La visualiza.
*/
public PruebaJSpinner()
{
// Creacion del JTextField
tf = new JTextField(20);
// Creacion del JSpinner y valor incial.
spinner = new JSpinner();
spinner.setValue(30);
// Nos suscribimos a cambios en el JSpinner
spinner.addChangeListener(new ChangeListener() {
@Override
public void stateChanged(ChangeEvent e) {
// Ponemos el valor del JSpinner en el

        tf.setText(spinner.getValue().toString());
}
});
// Creacion de la ventana con los componentes
v = new JFrame();
v.getContentPane().setLayout(new FlowLayout());
v.getContentPane().add(spinner);
v.getContentPane().add(tf);
v.pack();
v.setVisible(true);
v.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
}
}

