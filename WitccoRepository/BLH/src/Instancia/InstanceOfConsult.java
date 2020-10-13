/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Instancia;

import vistas.AdministrarEncargado;
import vistas.AdministrarMedic;
import vistas.BuscarNino;
import vistas.Consult;
import vistas.ControlPaciente;
import vistas.RecoleccionLeche;

/**
 *
 * @author Chavez Vigil
 */
public class InstanceOfConsult {

    public ControlPaciente pte = new ControlPaciente();
    public Consult consulta = new Consult();
    public BuscarNino buscar = new BuscarNino();
    public RecoleccionLeche recL = new RecoleccionLeche();
    public AdministrarMedic Admed = new AdministrarMedic();
    public AdministrarEncargado encargado = new AdministrarEncargado();
}
