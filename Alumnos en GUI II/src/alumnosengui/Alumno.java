package alumnosengui;

import javax.swing.*;

public class Alumno {

//----------------------------
//    VARIABLES DE CONDICION            
//----------------------------
    private String[] Alumnos;
    private String apellido, nombre, carnet;
    private double parcial1, parcial2, parcial3, parcial4, parcial5;
  
//-------------------------------------
//    VARIABLES DE CLASE - CONDICIONES   
//-------------------------------------
    public static final String REPROBADO = "REPROBADO";
    public static final String APROBADO = "APROBADO";
    
//----------------------------
//    CONSTRUCTORES                     
//----------------------------
    public Alumno() {
        apellido = "";
        nombre = "";
        carnet = "";
        parcial1 = 0.0;
        parcial2 = 0.0;
        parcial3 = 0.0;
        parcial4 = 0.0;
        parcial5 = 0.0;
        Alumnos = new String[0];

    }

    public Alumno(String car, String nom, String ape, double par1, double par2, double par3, double par4, double par5) {

        this.nombre = nom;
        this.apellido = ape;
        this.carnet = car;
        setParcial1(par1);
        setParcial2(par2);
        setParcial3(par3);
        setParcial4(par4);
        setParcial5(par5);
        
    }

//------------------------------
//    METODOS GET Y SET                  
//------------------------------
    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public double getParcial1() {
        return parcial1;
    }

    public void setParcial1(double parcial1) {
        if (parcial1 >= 0.0 && parcial1 <= 10.0) {
            this.parcial1 = parcial1;
        } else {
            this.parcial1 = 0.0;
            JOptionPane.showMessageDialog(null, " ERROR EN LA PRIMERA NOTA " + " POR FAVOR CAMBIARLA ", "ERROR CRITICO", JOptionPane.ERROR_MESSAGE);
        }
    }

    public double getParcial2() {
        return parcial2;
    }

    public void setParcial2(double parcial2) {
        if (parcial2 >= 0.0 && parcial2 <= 10.0) {
            this.parcial2 = parcial2;
        } else {
            JOptionPane.showMessageDialog(null, "ERROR EN LA SEGUNDA NOTA" + " POR FAVOR CAMBIARLA ", " ERROR CRITICO ", JOptionPane.ERROR_MESSAGE);
            this.parcial2 = 0.0;
        }
    }

    public double getParcial3() {
        return parcial3;
    }

    public void setParcial3(double parcial3) {
        if (parcial3 >= 0.0 && parcial3 <= 10.0) {
            this.parcial3 = parcial3;
        } else {
            JOptionPane.showMessageDialog(null, "ERROR EN LA TERCERA NOTA" + " POR FAVOR CAMBIARLA ", " ERROR CRITICO ", JOptionPane.ERROR_MESSAGE);
            this.parcial3 = 0.0;
        }
    }

    public double getParcial4() {
        return parcial4;
    }

    public void setParcial4(double parcial4) {
        if (parcial4 >= 0.0 && parcial4 <= 10.0) {
            this.parcial4 = parcial4;
        } else {
            JOptionPane.showMessageDialog(null, "ERROR EN LA CUARTA NOTA" + " POR FAVOR CAMBIARLA ", " ERROR CRITICO ", JOptionPane.ERROR_MESSAGE);
            this.parcial4 = 0.0;
        }
    }

    public double getParcial5() {
        return parcial5;
    }

    public void setParcial5(double parcial5) {
        if (parcial5 >= 0.0 && parcial5 <= 10.0) {
            this.parcial5 = parcial5;
        } else {
            JOptionPane.showMessageDialog(null, "ERROR EN LA QUINTA NOTA " + " POR FAVOR CAMBIARLA ", " ERROR CRITICO ", JOptionPane.ERROR_MESSAGE);
            this.parcial5 = 0.0;
        }
    }
//---------------------------------------|
//    METODOS DE CLASE                   |
//---------------------------------------|
    public double CalcularPromedio() {
        return ((parcial1 * 0.20) + (parcial2 * 0.20) + (parcial3 * 0.20) + (parcial4 * 0.20) + (parcial5 * 0.20));
    }

    public String EstatusDeAlumno() {
        if (CalcularPromedio() >= 6.0) {
            return APROBADO;

        } else {
            return REPROBADO;
        }
    }

    public void agregarAlumno(String Alumno) {
        String[] nuevaLista = new String[Alumnos.length + 1];
        System.arraycopy(Alumnos, 0, nuevaLista, 0, Alumnos.length);
//        nuevaLista[nuevaLista.length - 1] = Alumno;
    }

//    @Override
//    public String toString() {
//        return " Nota1: " + Parcial1 + " -- " + " Nota2: " + Parcial2 + " -- " + " Nota3: " + Parcial3
//                + " -- " + " Nota4: " + Parcial4 + " -- " + " Nota5: " + Parcial5 + " = " + " Promedio: "
//                + CalcularPromedio() + " - " + " Estatus: " + EstatusDeAlumno();
//    }

    

   
}
