/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.Date;

/**
 *
 * @author USUARIO
 */
public class Empleado extends Clases.Persona {

    //public double sueldo
    public int horas_trabajadas, horas_extras;
    public String cargo;

    public Empleado(String nombres, String apellidos, String dui, Date fecha_n, String car, int hrs_tra, int hrs_ext) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dui = dui;
        this.fecha_nac = fecha_n;
        cargo = car;
        horas_trabajadas = hrs_tra;
        horas_extras = hrs_ext;
    }
}
