/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoDatos;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import java.util.GregorianCalendar;
import vistas.AdminPassword;
import vistas.Logueo;

/**
 *
 * @author Chavez Vigil
 */
public class OperacionesUsuarios {

    Conexion con = new Conexion();

    public void ActualizarUsuarios(String newUser, String pass, String viejoUs, String viejoPass) {
        try {
            int updateRows = 0;
            Statement senten = con.conectar().createStatement();
            ResultSet resul  = senten.executeQuery("SELECT IdUsuario FROM Usuario WHERE Username ='"+viejoUs+"' AND Password ='"+viejoPass+"'");
            resul.next();
            int id = resul.getInt("IdUsuario");
            PreparedStatement sentencia = con.conectar().prepareStatement("UPDATE Usuario SET Username ='" + newUser + "', Password ='" + pass + "' WHERE IdUsuario ='"+id+"'");

            updateRows = sentencia.executeUpdate();

            if (updateRows == 1) {
                JOptionPane.showMessageDialog(null, "Ha cambiado su Usuario y Contraseña");
            } else {
                JOptionPane.showMessageDialog(null, "Error Critico: ¡¡¡Verificar Datos!!!");
            }

            con.desconectar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }

    }

    public Boolean isLogged(String user, String pass) {
        try {
            Statement sentencia = null;
            ResultSet resultado = null;

            sentencia = con.conectar().createStatement();
            resultado = sentencia.executeQuery("SELECT Username,Password FROM Usuario WHERE Username = '" + user + "'");

            resultado.next();
            if (resultado.getRow() <= 0) {
                Logueo.jtfUsuario.selectAll();
                Logueo.jlErrorLogeo.setText("Error en usuario");
                return false;
            } else {
                String usuar = resultado.getString("Username");
                String password = resultado.getString("Password");
                if ((usuar.equals(user)) && (password.equals(pass))) {
                    System.out.println("Verdadero");
                    return true;
                } else if ((usuar.equals(user))) {
                    Logueo.jlErrorLogeo.setText("Error en contraseña");
                    Logueo.jpfContraseña.selectAll();
                    return false;
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return false;
    }

    public Boolean isSaved(String user, String pass) {
        try {
            Statement sentencia = null;
            ResultSet resultado = null;

            sentencia = con.conectar().createStatement();
            resultado = sentencia.executeQuery("SELECT Username,Password FROM Usuario WHERE Username = '" + user + "'");

            resultado.next();
            if (resultado.getRow() <= 0) {
                AdminPassword.jlErrorLogin.setText("Error en usuario");
                AdminPassword.jtfUsuario.selectAll();
                JOptionPane.showMessageDialog(null, "Error en usuario");

                return false;
            } else {
                String usuar = resultado.getString("Username");
                String password = resultado.getString("Password");
                if ((usuar.equals(user)) && (password.equals(pass))) {
                    System.out.println("Verdadero");
                    return true;
                } else if ((usuar.equals(user))) {
                    AdminPassword.jlErrorLogin.setText("Error en contraseña");
                    AdminPassword.jpfContraseña.selectAll();
                    JOptionPane.showMessageDialog(null, "Error en contraseña");
                    return false;
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return false;
    }
//    public String usuario() {
//        String usuario = new String();
//        try {
//
//            Statement sentencia = null;
//            ResultSet resultado = null;
//
//            sentencia = con.conectar().createStatement();
////            resultado = sentencia.executeQuery("SELECT Username,Password FROM Usuario WHERE Username = '"+user+"'");
//            while (resultado.next()) {
//                usuario = resultado.getString("Username");
//            }
////            resultado = sentencia.executeQuery("select email, password from usuarios WHERE email='" + usu.getUsuario() + "'");
//            resultado.last();
//            if (resultado.getRow() <= 0) {
//            } else {
//                String usuar = resultado.getString("email");
//                String pass = resultado.getString("password");
//                if ((usuar.equals(usu.getUsuario())) && (pass.equals(usu.getPass()))) {
//                    res = true;
//                }
//
//            }
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, ex.getMessage());
//        }
//        con.desconectar();
//        return usuario;
//    }
//    public String password() {
//        String pass = new String();
//        try {
//
//            Statement sentencia = null;
//            ResultSet resultado = null;
//
//            sentencia = con.conectar().createStatement();
//            resultado = sentencia.executeQuery("SELECT Password FROM Usuario WHERE IdUsuario = 1 ");
//            while (resultado.next()) {
//                pass = resultado.getString("Password");
//
//            }
//
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, ex.getMessage());
//        }
//        con.desconectar();
//        return pass;
//    }

    public void eliminarUsuario(String Id) {
        try {
            PreparedStatement sentencia = con.conectar().prepareStatement("DELETE FROM Usuario WHERE IdUsuario='" + Id + "'");
            sentencia.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente");
            con.desconectar();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage());
        }
    }

    public void listarUsuarios(JTable tabla) {
        try {

            Statement sentencia = null;
            ResultSet resultado = null;

            sentencia = con.conectar().createStatement();
            resultado = sentencia.executeQuery("SELECT IdUsuario,Username FROM Usuario ORDER BY IdUsuario asc");
            DefaultTableModel modelo = new DefaultTableModel();

            modelo.addColumn("Id Usuario");
            modelo.addColumn("Nombre Usuario");
            int valor = 0;
            while (resultado.next()) {
                modelo.addRow(new Object[]{});
                modelo.setValueAt(resultado.getString("IdUsuario"), valor, 0);
                modelo.setValueAt(resultado.getString("Username"), valor, 1);
                valor = valor + 1;
            }
            tabla.setModel(modelo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        con.desconectar();
    }

    public void nuevoUsuario(String username, String password, Boolean isAdm) {

        try {
            PreparedStatement sent1 = con.conectar().prepareStatement("INSERT INTO Usuario (Username,Password,administrador) VALUES ('" + username + "','" + password + "','" + isAdm + "')");
            sent1.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuario agregado exitosamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void verificar() {

        try {
            Statement sentencia1 = con.conectar().createStatement();
            ResultSet resultado1 = sentencia1.executeQuery("SELECT Username,Password FROM Usuario WHERE Username ='root'");
//            resultado1.next();
            if (!resultado1.next()) {
                PreparedStatement sent1 = con.conectar().prepareStatement("INSERT INTO Usuario (Username,Password,administrador) VALUES ('root','admin','true')");
                sent1.executeUpdate();
            }
            Statement sentencia = con.conectar().createStatement();
            ResultSet resultado = sentencia.executeQuery("SELECT IdVisitaDonacion FROM VisitaDonacion WHERE LugarSalida ='salvavidas'");
//            resultado.next();

//            int id = resultado.getInt("IdMotorista");
//            System.out.println(id);
//            System.out.println(visita.getIdVehiculo());
//            Statement sente = con.conectar().createStatement();
//            ResultSet resul = sente.executeQuery("SELECT IdUnidad FROM UnidadTransporte WHERE IdVehiculo ='" + visita.getIdVehiculo() + "' AND idMotorista = '" + id + "'");
//            PreparedStatement se = con.conectar().prepareStatement("SELECT IdUnidad FROM UnidadTransporte WHERE IdVehiculo ='" + visita.getIdVehiculo() + "' AND idMotorista = '" + id + "'");
//            Statement se = con.conectar().createStatement();
//            ResultSet resu = se.executeQuery("SELECT IdUnidad FROM UnidadTransporte WHERE IdVehiculo ='" + visita.getIdVehiculo() + "' AND idMotorista = '" + id + "'");
            //            se.execute();
//            System.out.println(se.execute());
            if (resultado.next()) {
//                JOptionPane.showMessageDialog(null, "Salvavidas existente");
            } else {
                PreparedStatement sent1 = con.conectar().prepareStatement("INSERT INTO Motorista (Nombre) VALUES ('salvavidas')");
                sent1.executeUpdate();
                PreparedStatement sent2 = con.conectar().prepareStatement("INSERT INTO Vehiculo (IdVehiculo,Tipo) VALUES ('1','salvavidas')");
                sent2.executeUpdate();
                PreparedStatement sent3 = con.conectar().prepareStatement("INSERT INTO Medico (JVPM,Nombre) VALUES ('1','salvavidas')");
                sent3.executeUpdate();
                PreparedStatement sent4 = con.conectar().prepareStatement("INSERT INTO UnidadTransporte (IdVehiculo,idMotorista) VALUES ('1','1')");
                sent4.executeUpdate();
                PreparedStatement sent5 = con.conectar().prepareStatement("INSERT INTO VisitaDonacion (LugarSalida,JVPM,IdUnidad) VALUES ('salvavidas','1','1')");
                sent5.executeUpdate();
                PreparedStatement sent6 = con.conectar().prepareStatement("INSERT INTO Ruta (Descripcion) VALUES ('salvavidas')");
                sent6.executeUpdate();
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void setEstado(String usuario, String estado) {
        String fActual, horaAct;
        int hora, minutos, segundos;
        try {


            Date fecha = new Date();
            SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
            fActual = formatoDelTexto.format(fecha);

            Calendar calendario = new GregorianCalendar();
            hora = calendario.get(Calendar.HOUR_OF_DAY);
            minutos = calendario.get(Calendar.MINUTE);
            segundos = calendario.get(Calendar.SECOND);
            horaAct = hora + ":" + minutos + ":" + segundos;
            PreparedStatement sent1 = con.conectar().prepareStatement("INSERT INTO Actividades (Fecha,Hora,Usuario,Actividad) VALUES ('" + fActual + "','" + horaAct + "','" + usuario + "','" + estado + "')");
            sent1.executeUpdate();
            System.out.println("Up");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public String usuarioUp() {
        String usuario = "";
        try {
            Statement sentencia = null;
            ResultSet resultado = null;

            sentencia = con.conectar().createStatement();
            resultado = sentencia.executeQuery("select TOP 1 Usuario from Actividades where Actividad = 'up' order by IdActividades desc");
            resultado.next();
            usuario = resultado.getString("Usuario");
            return usuario;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        con.desconectar();
        return usuario;
    }

    public Boolean isAdmin() {
        Boolean res = false;
        String usuario;
        try {
            Statement sentencia = null;
            ResultSet resultado = null;

            sentencia = con.conectar().createStatement();
            resultado = sentencia.executeQuery("select TOP 1 Usuario from Actividades where Actividad = 'up' order by IdActividades desc");
            resultado.next();
            usuario = resultado.getString("Usuario");
            
            Statement sentencia1 = con.conectar().createStatement();
            ResultSet resultado1 = sentencia1.executeQuery("select administrador from Usuario where Username = '" + usuario + "'");
            resultado1.next();
            res = resultado1.getBoolean("administrador");
            return res;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        con.desconectar();
        return res;
    }

    public void registrarActividad() {
    }
}
