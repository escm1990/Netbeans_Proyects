/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author Usuario
 */
public class Medico {

    private int jvpm;
    private String nombre;
    private String apellido;
    private String especialidad;

    public Medico() {
        jvpm = 0;
        nombre = "";
        apellido = "";
        especialidad = "";
    }

    public Medico(int jvpm, String nombre, String apellido, String especialidad) {
        this.jvpm = jvpm;
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
    }

    /**
     * @return the jvpm
     */
    public int getJvpm() {
        return jvpm;
    }

    /**
     * @param jvpm the jvpm to set
     */
    public void setJvpm(int jvpm) {
        this.jvpm = jvpm;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
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
     * @return the especialidad
     */
    public String getEspecialidad() {
        return especialidad;
    }

    /**
     * @param especialidad the especialidad to set
     */
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    
}
