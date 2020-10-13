package beans.model;

import java.util.Date;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//anotaciones para que se convertido en managedBean
@Named
@RequestScoped
public class Candidato {
    private String nombre;
    private String apellido;
    private int salarioDeseado;
    private Date fechaNacimiento;

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Logger getLog() {
        return log;
    }

    public void setLog(Logger log) {
        this.log = log;
    }

    Logger log = LogManager.getRootLogger();
    
    public Candidato() {
        log.info("Creando el objeto candidato");
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
        log.info("Modificando la propiedad de apellido "+this.apellido);
    }

    public int getSalarioDeseado() {
        return salarioDeseado;
    }

    public void setSalarioDeseado(int salarioDeseado) {
        this.salarioDeseado = salarioDeseado;
        log.info("Modificando la propiedad de salarioDeseado "+this.salarioDeseado);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
        log.info("Modificando la propiedad de nombre "+this.nombre);
    }
    
    
}
