package Modelos;

import Clases.Empresa;
import Clases.Encargado;
import conexion.conexion;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Operaciones {

    conexion con = new conexion();

    public void logueo(String mail, String pass) {
        try {
            int updateRows = 0;
            PreparedStatement sentencia = con.conectar().prepareStatement("INSERT INTO usuarios (email, password) VALUES (?,?)");

            sentencia.setString(2, mail);
            sentencia.setString(3, pass);

            updateRows = sentencia.executeUpdate();

            if (updateRows == 1) {
                JOptionPane.showMessageDialog(null, "Logueo exitoso");
            } else {
                JOptionPane.showMessageDialog(null, "Error Critico: ¡¡¡Verificar Datos!!!");
            }

            con.desconectar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public void agregarEmpresa(String name, String email, String dir, int emPad, int idEncargado) {
        try {
            int updateRows = 0;
            PreparedStatement sentencia = con.conectar().prepareStatement("INSERT INTO empresa (nombre, email, direccion, empresaPadre, encargado_idencargado) VALUES (?,?,?,?,?)");

            sentencia.setString(2, name);
            sentencia.setString(3, email);
            sentencia.setString(4, dir);
            sentencia.setInt(5, emPad);
            sentencia.setInt(6, idEncargado);

            updateRows = sentencia.executeUpdate();

            if (updateRows == 1) {
                JOptionPane.showMessageDialog(null, "Empresa agregada exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "Error Critico: ¡¡¡Verificar Datos!!!");
            }

            con.desconectar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public void listarCuentas(JTable tablita, int idCuentaPadre) {

        try {
            Statement sentencia = null;
            ResultSet resultado = null;

            sentencia = con.conectar().createStatement();
            resultado = sentencia.executeQuery("SELECT * FROM cuenta WHERE (padreCuenta = '" + idCuentaPadre + "') ORDER BY idcuenta asc");
            DefaultTableModel modelo = new DefaultTableModel();

            modelo.addColumn("Id Cuenta");
            modelo.addColumn("Nombre");
            modelo.addColumn("Valor");

            int valor = 0;
            while (resultado.next()) {
                modelo.addRow(new Object[]{});
                modelo.setValueAt(resultado.getString("idcuenta"), valor, 0);
                modelo.setValueAt(resultado.getString("nombre"), valor, 1);
                modelo.setValueAt(resultado.getString("valor"), valor, 2);
                valor = valor + 1;
            }
            tablita.setModel(modelo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        con.desconectar();
    }

    public void almacenarCuenta(int idCuenta, String nombre, int padreCuenta, double valor) {
        try {
            int updateRows = 0;
            PreparedStatement sentencia = con.conectar().prepareStatement("INSERT INTO cuenta (idcuenta, nombre, padreCuenta, valor) VALUES (?,?,?,?)");
            sentencia.setInt(1, idCuenta);
            sentencia.setString(2, nombre);
            sentencia.setInt(3, padreCuenta);
            sentencia.setDouble(4, valor);

            updateRows = sentencia.executeUpdate();

            if (updateRows == 1) {
                JOptionPane.showMessageDialog(null, "Cuenta agregada exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "Error Critico: ¡¡¡Verificar Datos!!!");
            }
            con.desconectar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public void listarCatalogo(JTable tablita) {

        try {
            Statement sentencia = null;
            ResultSet resultado = null;

            sentencia = con.conectar().createStatement();
            resultado = sentencia.executeQuery("SELECT * FROM cuenta ORDER BY idcuenta asc");
            DefaultTableModel modelo = new DefaultTableModel();

            modelo.addColumn("Id Cuenta");
            modelo.addColumn("Nombre");
            modelo.addColumn("Valor");

            int valor = 0;
            while (resultado.next()) {
                modelo.addRow(new Object[]{});
                modelo.setValueAt(resultado.getString("idcuenta"), valor, 0);
                modelo.setValueAt(resultado.getString("nombre"), valor, 1);
                modelo.setValueAt(resultado.getString("valor"), valor, 2);
                valor = valor + 1;
            }
            tablita.setModel(modelo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        con.desconectar();
    }

    public double sumarCuenta(int idpadre) {
        double monto = 0.0;
        try {
            Statement sentencia = null;
            ResultSet resultado = null;

            sentencia = con.conectar().createStatement();
            resultado = sentencia.executeQuery("SELECT SUM(valor) FROM cuenta WHERE (padreCuenta = '" + idpadre + "')");

            while (resultado.next()) {
                monto = monto + Double.parseDouble(resultado.getString("valor"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        con.desconectar();
        return monto;
    }

    public boolean agregar(NuevoUsuario usu) {
        boolean res = false;
        try {
            Statement sentencia = null;
            ResultSet resultado = null;
            sentencia = con.conectar().createStatement();

            resultado = sentencia.executeQuery("select email, password from usuarios WHERE email='" + usu.getUsuario() + "'");
            resultado.last();
            if (resultado.getRow() <= 0) {
            } else {
                String usuar = resultado.getString("email");
                String pass = resultado.getString("password");
                if ((usuar.equals(usu.getUsuario())) && (pass.equals(usu.getPass()))) {
                    res = true;
                }

            }
            con.desconectar();
        } catch (SQLException ex) {
            String error = ex.getMessage();
        }
        return res;
    }

    public void agregarEmpresaUsuario(Empresa empresa, Encargado encargado) {
         try {
            int updateRows = 0;
            int updateeRows2 = 0;
            
            PreparedStatement sentencia = con.conectar().prepareStatement("INSERT INTO empresa (nombre, email, direccion, empresaPadre, encargado_idencargado) VALUES (?,?,?,?,?)");
            PreparedStatement sentencia2 = con.conectar().prepareStatement("INSERT INTO encargado (nombre, apellidos, fechaNac, encargadoPadre, telefono_numero) VALUES (?,?,?,?,?)");
            Statement sentencia3 = con.conectar().createStatement();             
            
                
            sentencia2.setString(2, encargado.getNombres());
            sentencia2.setString(3, encargado.getApellido());
            sentencia2.setString(4, encargado.getFechaNac());
            sentencia2.setString(5, "0");
            sentencia2.setString(6, encargado.getTel());
            
            updateeRows2 = sentencia2.executeUpdate();
            
            sentencia.setString(2,empresa.getName());
            sentencia.setString(3, empresa.getEmail());
            sentencia.setString(4, empresa.getDir());
            sentencia.setInt(5, 0);

            ResultSet resul = sentencia3.executeQuery("SELECT idencargado FROM encargado WHERE nombre = '"+encargado.getNombres()+"'");
            int encarg = resul.getInt("idencargado"); 
            sentencia.setInt(6, encarg);
           
            updateRows = sentencia.executeUpdate();
            

            if (updateRows == 1) {
                if(updateeRows2 == 1){
                JOptionPane.showMessageDialog(null, "Empresa agregada exitosamente");
                }else{               
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error Critico: ¡¡¡Verificar Datos!!!");
            }

            con.desconectar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        
    }
    
//        public void nuevaEmpresa(int idCuenta, String nombre, int padreCuenta, double valor) {
//        try {
//            int updateRows = 0;
//            PreparedStatement sentencia = con.conectar().prepareStatement("INSERT INTO cuenta (idcuenta, nombre, padreCuenta, valor) VALUES (?,?,?,?)");
//            sentencia.setInt(1, idCuenta);
//            sentencia.setString(2, nombre);
//            sentencia.setInt(3, padreCuenta);
//            sentencia.setDouble(4, valor);
//
//            updateRows = sentencia.executeUpdate();
//
//            if (updateRows == 1) {
//                JOptionPane.showMessageDialog(null, "Cuenta agregada exitosamente");
//            } else {
//                JOptionPane.showMessageDialog(null, "Error Critico: ¡¡¡Verificar Datos!!!");
//            }
//            con.desconectar();
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
//        }
//    }
}
