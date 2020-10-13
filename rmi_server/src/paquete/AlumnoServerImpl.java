/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package paquete;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;

/**
 *
 * @author USUARIO
 */
public class AlumnoServerImpl extends UnicastRemoteObject implements AlumnoServer {

    public AlumnoServerImpl() throws RemoteException
    {
        super();
    }
    
    private Conexion con = new Conexion();

    public boolean DetallesAlumno(String carnet, String nombres, String apellidos) throws RemoteException {
        boolean res = false;
        try {
            int rows_updated = 0;
            PreparedStatement stmt1 = con.conectar().prepareStatement("INSERT INTO alumno (Carnet,Nombres,Apellidos) VALUES (?,?,?)");
            stmt1.setString(1, carnet);
            stmt1.setString(2, nombres);
            stmt1.setString(3, apellidos);
            rows_updated = stmt1.executeUpdate();
            if(rows_updated !=1){
                System.out.println("Error. Reintente.");
            }else{
                res = true;
                System.out.println("Alumno registrado satisfactoriamente");
            }
            con.desconectar();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return res;
    }

    public static void main(String[] args) {
        try {
            AlumnoServerImpl obj = new AlumnoServerImpl();
            Registry registro = LocateRegistry.createRegistry(1234);
            registro.rebind("AlumnoServer", obj);
            System.out.println("Server Registrado!!!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
