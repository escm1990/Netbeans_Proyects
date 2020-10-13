/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Date;
import javax.swing.JLabel;

/**
 *
 * @author USUARIO
 */
public class Hilo implements Runnable {

    Thread cronometro;
    Date horaSistema = new Date();
    public int minutos = horaSistema.getMinutes(), segundos = horaSistema.getSeconds(), horas = horaSistema.getHours();
    public String tiempo = "";

    public JLabel lb_local;
    public Hilo(JLabel lb) {
        cronometro = new Thread(this);
        cronometro.start();
        lb_local = lb;
    }

    public void run() {
        try {
            for (;;) {
                if (segundos == 59) {
                    segundos = 0;
                    minutos++;
                }
                if (minutos == 59) {
                    minutos = 0;
                    horas++;
                }
                segundos++;
                tiempo = horas + " : " + minutos + " : " + segundos;
//                System.out.println(tiempo);
                lb_local.setText(tiempo);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
