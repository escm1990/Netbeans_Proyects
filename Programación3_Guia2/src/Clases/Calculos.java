/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.*;
import java.sql.Date;

/**
 *
 * @author USUARIO
 */
public class Calculos {

    public double sueldo_bruto, renta, isss, sueldo_liquido, sueldo_horas_normal, sueldo_horas_extra;
    Empleado emp;

    public void Agregar_Empleado() {
        Scanner lector = new Scanner(System.in);
        String nom, ape, cargo, dui;
        int horasn, horase;
        Date fn;
        System.out.println("Datos personales del empleado");
        System.out.println("Ingrese los nombres del empleado");
        nom = lector.nextLine();
        System.out.println("Ingrese los apellidos del empleado");
        ape = lector.nextLine();
        System.out.println("Ingrese la fecha de nacimiento del empleado en el siguiente formato:");
        System.out.println("YYYY-MM-DD");
        fn = Date.valueOf(lector.nextLine());
        System.out.println("Ingrese el cargo del empleado");
        cargo = lector.nextLine();
        System.out.println("Ingrese el DUI del empleado");
        dui = lector.nextLine();
        System.out.println("Ingrese el numero de horas trabajadas en tiempo normal del empleado");
        horasn = lector.nextInt();
        System.out.println("Ingrese el numero de horas extra trabajadas");
        horase = lector.nextInt();
        emp = new Empleado(nom, ape, dui, fn, cargo, horasn, horase);
    }

    public void Calcular(Empleado e){
        if(e.cargo.equalsIgnoreCase("Administrativo")){
            sueldo_horas_normal=20;
            sueldo_horas_extra=40;
        }
        else{
            sueldo_horas_normal=10;
            sueldo_horas_extra=20;
        }
        sueldo_bruto=(emp.horas_trabajadas*sueldo_horas_normal)+(emp.horas_extras*sueldo_horas_extra);
        renta=sueldo_bruto*0.25;
        isss=sueldo_bruto*0.07;
        sueldo_liquido=sueldo_bruto-renta-isss;
        System.out.println("Nombre del empleado : "+ e.nombres + e.apellidos);
        System.out.println("Sueldo bruto : $" + sueldo_bruto);
        System.out.println("Descuentos: ");
        System.out.println("Renta: $" + renta);
        System.out.println("ISSS: $" + isss);
        System.out.println("Sueldo líquido: $" + sueldo_liquido);
    }

    public static void main(String args[]){
        Calculos cl = new Calculos();
        cl.Agregar_Empleado();
        cl.Calcular(cl.emp);
    }
}
