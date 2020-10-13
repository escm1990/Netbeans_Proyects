/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package paquete;
import java.rmi.*;
/**
 *
 * @author USUARIO
 */
public interface AlumnoServer extends Remote {
    boolean DetallesAlumno(String carnet, String nombres, String apellidos) throws RemoteException;
}
