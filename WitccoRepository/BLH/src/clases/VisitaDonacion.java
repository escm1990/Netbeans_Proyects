/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.Date;

/**
 *
 * @author Chavez Vigil
 */
public class VisitaDonacion {

    private Date fecha;
    private String hora;
    private String kilometraje;
    private String LugarSalida;
    private String LugarLlegada;
    private String distancia;
    private String galones;
    private String jvpm;
    private String IdVehiculo;
    private String DuiMotorista;

    public VisitaDonacion() {
        this.IdVehiculo = "";
        this.jvpm = "";
        this.fecha = null;
        this.distancia = "";
        this.DuiMotorista = "";
        this.hora = "";
        this.kilometraje = "";
        this.LugarSalida = "";
        this.LugarLlegada = "";
        this.galones = "";

    }

    public VisitaDonacion(String dist, String LSalida, String Lllegada, String km, Date fecha, String hora, String gal, String jvpm, String idVehiculo, String duiMot) {
        this.IdVehiculo = idVehiculo;
        this.jvpm = jvpm;
        this.fecha = fecha;
        this.distancia = dist;
        this.DuiMotorista = duiMot;
        this.hora = hora;
        this.kilometraje = km;
        this.LugarSalida = LSalida;
        this.LugarLlegada = Lllegada;
        this.galones = gal;
    }

    public VisitaDonacion(Date fecha, String jvpm, String idVehiculo, String duiMoto) {
        this.IdVehiculo = idVehiculo;
        this.jvpm = jvpm;
        this.fecha = fecha;
        this.DuiMotorista = duiMoto;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the hora
     */
    public String getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(String hora) {
        this.hora = hora;
    }

    /**
     * @return the kilometraje
     */
    public String getKilometraje() {
        return kilometraje;
    }

    /**
     * @param kilometraje the kilometraje to set
     */
    public void setKilometraje(String kilometraje) {
        this.kilometraje = kilometraje;
    }

    /**
     * @return the LugarSalida
     */
    public String getLugarSalida() {
        return LugarSalida;
    }

    /**
     * @param LugarSalida the LugarSalida to set
     */
    public void setLugarSalida(String LugarSalida) {
        this.LugarSalida = LugarSalida;
    }

    /**
     * @return the LugarLlegada
     */
    public String getLugarLlegada() {
        return LugarLlegada;
    }

    /**
     * @param LugarLlegada the LugarLlegada to set
     */
    public void setLugarLlegada(String LugarLlegada) {
        this.LugarLlegada = LugarLlegada;
    }

    /**
     * @return the distancia
     */
    public String getDistancia() {
        return distancia;
    }

    /**
     * @param distancia the distancia to set
     */
    public void setDistancia(String distancia) {
        this.distancia = distancia;
    }

    /**
     * @return the galones
     */
    public String getGalones() {
        return galones;
    }

    /**
     * @param galones the galones to set
     */
    public void setGalones(String galones) {
        this.galones = galones;
    }

    /**
     * @return the jvpm
     */
    public String getJvpm() {
        return jvpm;
    }

    /**
     * @param jvpm the jvpm to set
     */
    public void setJvpm(String jvpm) {
        this.jvpm = jvpm;
    }

    /**
     * @return the IdVehiculo
     */
    public String getIdVehiculo() {
        return IdVehiculo;
    }

    /**
     * @param IdVehiculo the IdVehiculo to set
     */
    public void setIdVehiculo(String IdVehiculo) {
        this.IdVehiculo = IdVehiculo;
    }

    /**
     * @return the DuiMotorista
     */
    public String getDuiMotorista() {
        return DuiMotorista;
    }

    /**
     * @param DuiMotorista the DuiMotorista to set
     */
    public void setDuiMotorista(String DuiMotorista) {
        this.DuiMotorista = DuiMotorista;
    }
}
