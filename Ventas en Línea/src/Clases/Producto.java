package Clases;

public class Producto {

    private String codigo, nombre, condicion;
    private double valorUnitario;
    public static final String USADO = "USADO", NUEVO = "NUEVO";

    public void Producto() {
        setCodigo("");
        setNombre("");
        setValorUnitario(0.0);
        setCondicion(Producto.NUEVO);
    }

    public Producto(String code, String name, double value, String condition) {
        this.codigo = code;
        this.nombre = name;
        this.valorUnitario = value;
        this.condicion = condition;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
     * @return the condicion
     */
    public String getCondicion() {
        return condicion;
    }

    /**
     * @param condicion the condicion to set
     */
    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    /**
     * @return the valorUnitario
     */
    public double getValorUnitario() {
        return valorUnitario;
    }

    /**
     * @param valorUnitario the valorUnitario to set
     */
    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public String toString(){
        return codigo+"\t"+nombre+"\t"+valorUnitario+"\t"+condicion.toString();
    }
}