/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Chavez Vigil
 */
public class Encargado {

    private String nombres;
    private String apellido;
    private String fechaNac;
    private String tel;

    public Encargado() {
        nombres = "";
        apellido = "";
        fechaNac = "";
        tel = "";
    }
    
    public Encargado(String name, String ape, String fecha, String tel){
        this.nombres = name;
        this.apellido = ape;
        this.fechaNac = fecha;
        this.tel = tel;
    }
    

    /**
     * @return the nombres
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * @param nombres the nombres to set
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the fechaNac
     */
    public String getFechaNac() {
        return fechaNac;
    }

    /**
     * @param fechaNac the fechaNac to set
     */
    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    /**
     * @return the tel
     */
    public String getTel() {
        return tel;
    }

    /**
     * @param tel the tel to set
     */
    public void setTel(String tel) {
        this.tel = tel;
    }
    
}
