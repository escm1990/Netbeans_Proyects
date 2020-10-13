/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;


import conexion.conexion;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Chavez Vigil
 */
public class operacionesRatios {

    conexion con = new conexion();

    public double totalValor(int idCuenta, int idPadre) {
        double valor = 0.0;
        try {
            Statement sentencia = null;
            ResultSet resultado = null;
            sentencia = con.conectar().createStatement();

            resultado = sentencia.executeQuery("select valor from  cuenta where idcuenta = '"+idCuenta+"' and padreCuenta = '"+idPadre+"'");
            boolean res = resultado.last();
            if (res == true){
                valor = resultado.getDouble("valor");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return valor;

    }
}
