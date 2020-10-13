package Receptor;

import javax.swing.JOptionPane;

public class Datos_Empleado {

    private String nombre, edad, sexo, direccion, telefono, DUI, email, cargo;
    private double sueldoneto, sueldoliquido;

    public Datos_Empleado(){
        nombre = JOptionPane.showInputDialog("Ingrese el nombre del empleado");
        edad = JOptionPane.showInputDialog("Ingrese la edad del empleado");
        sexo = JOptionPane.showInputDialog("Ingrese el sexo del empleado");
        direccion = JOptionPane.showInputDialog("Ingrese la dirección del empleado");
        telefono = JOptionPane.showInputDialog("Ingrese el teléfono del empleado");
        DUI = JOptionPane.showInputDialog("Ingrese el DUI del empleado");
        email = JOptionPane.showInputDialog("Ingrese el email del empleado");
        cargo = JOptionPane.showInputDialog("Ingrese el cargo del empleado");
        sueldoneto = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el sueldo neto del empleado"));
        sueldoliquido=sueldoneto-(sueldoneto*(0.0625)+sueldoneto*(0.03)+sueldoneto*(0.07));
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
     * @return the edad
     */
    public String getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(String edad) {
        this.edad = edad;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the DUI
     */
    public String getDUI() {
        return DUI;
    }

    /**
     * @param DUI the DUI to set
     */
    public void setDUI(String DUI) {
        this.DUI = DUI;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the sueldoneto
     */
    public double getSueldoneto() {
        return sueldoneto;
    }

    /**
     * @param sueldoneto the sueldoneto to set
     */
    public void setSueldoneto(double sueldoneto) {
        this.sueldoneto = sueldoneto;
    }

    /**
     * @return the sueldoliquido
     */
    public double getSueldoliquido() {
        return sueldoliquido;
    }

    /**
     * @param sueldoliquido the sueldoliquido to set
     */
    public void setSueldoliquido(double sueldoliquido) {
        this.sueldoliquido = sueldoliquido;
    }

    /**
     * @return the cargo
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
