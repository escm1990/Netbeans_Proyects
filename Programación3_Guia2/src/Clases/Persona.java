/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;//Instrucción que indica que la clase estará dentro del paquete clases

import java.util.*;
import java.sql.Date;

/**
 *
 * @author USUARIO
 */
public class Persona {

    public String nombres, apellidos, dui;
    public Date fecha_nac;

    public void mostrar_datos() {
        System.out.println("Nombre completo: " + nombres + " " + apellidos);
        System.out.println("Fecha de Nacimiento: " + fecha_nac);
        System.out.println("Numero de DUI: " + dui);
    }
}
