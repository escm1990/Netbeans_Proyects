/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gradosCelcius;

import java.text.DecimalFormat;

/**
 *
 * @author USUARIO
 */
public class grados {

    DecimalFormat f = new DecimalFormat("###,##0.00");

    String con_cel_a_fah(double cel) {
        double fah = cel * 9 / 5 + 32;
        return f.format(fah);
    }

    String con_cel_a_kel(double cel){
        double kel= cel+237.15;
        return f.format(kel);
    }
}
