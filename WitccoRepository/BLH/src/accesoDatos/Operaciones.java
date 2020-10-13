/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoDatos;

import clases.Encargado;
import clases.Medico;
import clases.Motorista;
import clases.Paciente;
import clases.Vehiculo;
import clases.VisitaDonacion;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.freixas.jcalendar.JCalendar;
import org.freixas.jcalendar.JCalendarCombo;

/**
 *
 * @author Chavez Vigil
 */
public class Operaciones {

    Conexion con = new Conexion();

    public void almacenarPaciente(Paciente pte) {
        try {
        } catch (Exception e) {
        }
    }

    public void almacenarMedico(Medico doc) {
        try {
            PreparedStatement sen = con.conectar().prepareStatement("UPDATE Medico SET Nombre ='" + doc.getNombre() + "', Apellido ='" + doc.getApellido() + "', Especialidad ='" + doc.getEspecialidad() + "' WHERE JVPM ='" + doc.getJvpm() + "'");
            if (sen.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "¡Datos Modificados!");
            } else {
                PreparedStatement sentencia = con.conectar().prepareStatement("INSERT INTO Medico (JVPM,Nombre,Apellido,Especialidad) VALUES ('" + doc.getJvpm() + "','" + doc.getNombre() + "','" + doc.getApellido() + "','" + doc.getEspecialidad() + "')");
                sentencia.executeUpdate();
                con.desconectar();
                JOptionPane.showMessageDialog(null, "¡Datos Almacenados!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public void eliminarMedico(Medico doc) {
        try {
            PreparedStatement sentencia = con.conectar().prepareStatement("DELETE FROM Medico WHERE JVPM = '" + doc.getJvpm() + "'");
            if (sentencia.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "¡Eliminado Correctamente!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "¡Actualmente en uso!");
        }
    }

    public void listarMedicos(JTable tabla) {
        try {

            Statement sentencia = null;
            ResultSet resultado = null;

            sentencia = con.conectar().createStatement();
            resultado = sentencia.executeQuery("SELECT * FROM Medico ORDER BY Nombre asc");
            DefaultTableModel modelo = new DefaultTableModel();

            modelo.addColumn("JVPM");
            modelo.addColumn("Nombre");
            modelo.addColumn("Apellido");
            modelo.addColumn("Especialidad");
            int valor = 0;
            while (resultado.next()) {
                if (!resultado.getString("Nombre").equals("salvavidas")) {
                    modelo.addRow(new Object[]{});
                    modelo.setValueAt(resultado.getInt("JVPM"), valor, 0);
                    modelo.setValueAt(resultado.getString("Nombre"), valor, 1);
                    modelo.setValueAt(resultado.getString("Apellido"), valor, 2);
                    modelo.setValueAt(resultado.getString("Especialidad"), valor, 3);
                    valor = valor + 1;
                }
            }
            tabla.setModel(modelo);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        con.desconectar();

    }

    public void almacenarMotorista(Motorista moto) {
        try {
            PreparedStatement sen = con.conectar().prepareStatement("UPDATE Motorista SET Nombre ='" + moto.getNombre() + "', Apellidos ='" + moto.getApellido() + "' WHERE DUI ='" + moto.getDui() + "'");
            if (sen.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "¡Datos Modificados!");
            } else {
                PreparedStatement sentencia = con.conectar().prepareStatement("INSERT INTO Motorista (Nombre,Apellidos,DUI) VALUES ('" + moto.getNombre() + "','" + moto.getApellido() + "','" + moto.getDui() + "')");
                sentencia.executeUpdate();
                con.desconectar();
                JOptionPane.showMessageDialog(null, "¡Datos Almacenados!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public void eliminarMotorista(Motorista moto) {
        try {
            PreparedStatement sentencia = con.conectar().prepareStatement("DELETE FROM Motorista WHERE DUI = '" + moto.getDui() + "'");
            if (sentencia.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "¡Eliminado Correctamente!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "¡Actualmente en uso!");
        }
    }

    public void listarMotoristas(JTable tabla) {
        try {
            Statement sentencia = null;
            ResultSet resultado = null;

            sentencia = con.conectar().createStatement();
            resultado = sentencia.executeQuery("SELECT * FROM Motorista ORDER BY Apellidos asc");
            DefaultTableModel modelo = new DefaultTableModel();

            modelo.addColumn("Nombre");
            modelo.addColumn("Apellido");
            modelo.addColumn("Licencia");
            int valor = 0;
            while (resultado.next()) {
                if (!resultado.getString("Nombre").equals("salvavidas")) {
                    modelo.addRow(new Object[]{});
                    modelo.setValueAt(resultado.getString("Nombre"), valor, 0);
                    modelo.setValueAt(resultado.getString("Apellidos"), valor, 1);
                    modelo.setValueAt(resultado.getString("DUI"), valor, 2);
                    valor = valor + 1;
                }
            }
            tabla.setModel(modelo);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        con.desconectar();
    }

    public void almacenarVehiculo(Vehiculo veh) {
        try {
            PreparedStatement sen = con.conectar().prepareStatement("UPDATE Vehiculo SET Tipo ='" + veh.getTipo() + "' WHERE IdVehiculo ='" + veh.getPlaca() + "'");
            if (sen.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "¡Datos Modificados!");
            } else {
                PreparedStatement sentencia = con.conectar().prepareStatement("INSERT INTO Vehiculo (IdVehiculo,Tipo) VALUES ('" + veh.getPlaca() + "','" + veh.getTipo() + "')");
                sentencia.executeUpdate();
                con.desconectar();
                JOptionPane.showMessageDialog(null, "¡Datos Almacenados!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public void eliminarVehiculo(Vehiculo veh) {
        try {
            PreparedStatement sentencia = con.conectar().prepareStatement("DELETE FROM Vehiculo WHERE IdVehiculo = '" + veh.getPlaca() + "'");
            if (sentencia.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "¡Eliminado Correctamente!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "¡Actualmente en uso!");
        }
    }

    public void listarVehiculo(JTable tabla) {
        try {
            Statement sentencia = null;
            ResultSet resultado = null;

            sentencia = con.conectar().createStatement();
            resultado = sentencia.executeQuery("SELECT * FROM Vehiculo ORDER BY IdVehiculo asc");
            DefaultTableModel modelo = new DefaultTableModel();

            modelo.addColumn("Placa");
            modelo.addColumn("Tipo");
            int valor = 0;
            while (resultado.next()) {
                if (!resultado.getString("Tipo").equals("salvavidas")) {
                    modelo.addRow(new Object[]{});
                    modelo.setValueAt(resultado.getString("IdVehiculo"), valor, 0);
                    modelo.setValueAt(resultado.getString("Tipo"), valor, 1);
                    valor = valor + 1;
                }
            }
            tabla.setModel(modelo);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        con.desconectar();
    }

    public void almacenarRuta(VisitaDonacion visita, DefaultTableModel trayectos) {
        try {
            Statement sentencia = con.conectar().createStatement();
            ResultSet resultado = sentencia.executeQuery("SELECT IdMotorista FROM Motorista WHERE DUI ='" + visita.getDuiMotorista() + "'");
            resultado.next();
            int idMoto = resultado.getInt("IdMotorista");

            Statement se = con.conectar().createStatement();
            ResultSet resu = se.executeQuery("SELECT IdUnidad FROM UnidadTransporte WHERE IdVehiculo ='" + visita.getIdVehiculo() + "' AND idMotorista = '" + idMoto + "'");

            if (resu.next() == true) {
                Statement sentec = con.conectar().createStatement();
                ResultSet result = sentec.executeQuery("SELECT IdUnidad FROM UnidadTransporte WHERE IdVehiculo ='" + visita.getIdVehiculo() + "' AND idMotorista = '" + idMoto + "'");
                result.next();
                int idUnidad = result.getInt("IdUnidad");
                PreparedStatement sec = con.conectar().prepareStatement("INSERT INTO Ruta (Descripcion) VALUES ('" + "" + "')");
                sec.executeUpdate();
                for (int i = 0; i < trayectos.getRowCount(); i++) {
                    PreparedStatement sen = con.conectar().prepareStatement("INSERT INTO VisitaDonacion (Fecha,Hora,Kilometraje,LugarSalida,LugarLlegada,Distancia,Galones,JVPM,IdUnidad) VALUES ('" + visita.getFecha() + "','" + trayectos.getValueAt(i, 0) + "','" + trayectos.getValueAt(i, 1) + "','" + trayectos.getValueAt(i, 2) + "','" + trayectos.getValueAt(i, 3) + "','" + trayectos.getValueAt(i, 4) + "','" + "" + "','" + visita.getJvpm() + "','" + idUnidad + "')");
                    sen.executeUpdate();
                }

                int ids[] = new int[trayectos.getRowCount()];
                for (int i = 0; i < trayectos.getRowCount(); i++) {
                    Statement id = con.conectar().createStatement();
                    ResultSet r = id.executeQuery("SELECT IdVisitaDonacion FROM VisitaDonacion WHERE Fecha = '" + visita.getFecha() + "' AND Hora = '" + trayectos.getValueAt(i, 0) + "' AND Kilometraje = '" + trayectos.getValueAt(i, 1) + "' AND LugarSalida = '" + trayectos.getValueAt(i, 2) + "' AND LugarLlegada = '" + trayectos.getValueAt(i, 3) + "' AND Distancia = '" + trayectos.getValueAt(i, 4) + "'AND JVPM = '" + visita.getJvpm() + "' AND IdUnidad = '" + idUnidad + "'");
                    r.next();
                    ids[i] = r.getInt("IdVisitaDonacion");
                }

                Statement ruta = con.conectar().createStatement();
                ResultSet idRuta = ruta.executeQuery("SELECT TOP 1 idRuta FROM Ruta ORDER BY idRuta desc ");
                idRuta.next();
                int iRuta = idRuta.getInt("idRuta");

                for (int i = 0; i < ids.length; i++) {
                    PreparedStatement sen = con.conectar().prepareStatement("INSERT INTO RutaVisita (idVisitaDonacion,idRuta,Descripcion) VALUES ('" + ids[i] + "','" + iRuta + "','" + "" + "')");
                    sen.executeUpdate();
                }

            } else {


                PreparedStatement sent = con.conectar().prepareStatement("INSERT INTO UnidadTransporte (IdVehiculo,idMotorista) VALUES ('" + visita.getIdVehiculo() + "','" + idMoto + "')");
                sent.executeUpdate();

                Statement sentec = con.conectar().createStatement();
                ResultSet result = sentec.executeQuery("SELECT IdUnidad FROM UnidadTransporte WHERE IdVehiculo ='" + visita.getIdVehiculo() + "' AND idMotorista = '" + idMoto + "'");
                result.next();
                int idUnidad = result.getInt("IdUnidad");
                PreparedStatement sec = con.conectar().prepareStatement("INSERT INTO Ruta (Descripcion) VALUES ('" + "" + "')");
                sec.executeUpdate();
                for (int i = 0; i < trayectos.getRowCount(); i++) {
                    PreparedStatement sen = con.conectar().prepareStatement("INSERT INTO VisitaDonacion (Fecha,Hora,Kilometraje,LugarSalida,LugarLlegada,Distancia,Galones,JVPM,IdUnidad) VALUES ('" + visita.getFecha() + "','" + trayectos.getValueAt(i, 0) + "','" + trayectos.getValueAt(i, 1) + "','" + trayectos.getValueAt(i, 2) + "','" + trayectos.getValueAt(i, 3) + "','" + trayectos.getValueAt(i, 4) + "','" + "" + "','" + visita.getJvpm() + "','" + idUnidad + "')");
                    sen.executeUpdate();
                }

                int ids[] = new int[trayectos.getRowCount()];
                for (int i = 0; i < trayectos.getRowCount(); i++) {
                    Statement id = con.conectar().createStatement();
                    ResultSet r = id.executeQuery("SELECT IdVisitaDonacion FROM VisitaDonacion WHERE Fecha = '" + visita.getFecha() + "' AND Hora = '" + trayectos.getValueAt(i, 0) + "' AND Kilometraje = '" + trayectos.getValueAt(i, 1) + "' AND LugarSalida = '" + trayectos.getValueAt(i, 2) + "' AND LugarLlegada = '" + trayectos.getValueAt(i, 3) + "' AND Distancia = '" + trayectos.getValueAt(i, 4) + "'AND JVPM = '" + visita.getJvpm() + "' AND IdUnidad = '" + idUnidad + "'");
                    r.next();
                    ids[i] = r.getInt("IdVisitaDonacion");
                }

                Statement ruta = con.conectar().createStatement();
                ResultSet idRuta = ruta.executeQuery("SELECT TOP 1 idRuta FROM Ruta ORDER BY idRuta desc ");
                idRuta.next();
                int iRuta = idRuta.getInt("idRuta");

                for (int i = 0; i < ids.length; i++) {
                    PreparedStatement sen = con.conectar().prepareStatement("INSERT INTO RutaVisita (idVisitaDonacion,idRuta,Descripcion) VALUES ('" + ids[i] + "','" + iRuta + "','" + "" + "')");
                    sen.executeUpdate();
                }
            }
            JOptionPane.showMessageDialog(null, "¡Datos almacenados correctamente!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void listarRutas(JTable table) {
        try {
            Statement sentencia = null;
            ResultSet resultado = null;
            TableColumn numero = null;

            sentencia = con.conectar().createStatement();
            resultado = sentencia.executeQuery("SELECT * FROM VisitaDonacion ORDER BY IdVisitaDonacion asc");

            Statement senten = con.conectar().createStatement();
            ResultSet resulta = senten.executeQuery("SELECT COUNT(IdUnidad) FROM VisitaDonacion");
            resulta.next();
            int tamano = resulta.getInt("");
            String motorista[] = new String[tamano];
            String vehiculo[] = new String[tamano];
            for (int i = 0; i < tamano; i++) {
                resultado.next();
                Statement sentenc = con.conectar().createStatement();
                ResultSet resultad = sentenc.executeQuery("SELECT idMotorista, IdVehiculo FROM UnidadTransporte where IdUnidad = '" + resultado.getInt("IdUnidad") + "'");
                resultad.next();
                Statement sen1 = con.conectar().createStatement();
                ResultSet res1 = sen1.executeQuery("SELECT Nombre,Apellidos FROM Motorista WHERE IdMotorista ='" + resultad.getInt("idMotorista") + "'");
                res1.next();
                motorista[i] = res1.getString("Nombre") + " " + res1.getString("Apellidos");
                vehiculo[i] = resultad.getString("IdVehiculo");
            }

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("#");
            modelo.addColumn("Fecha");
            modelo.addColumn("Hora");
            modelo.addColumn("Lugar Salida");
            modelo.addColumn("Lugar Llegada");
            modelo.addColumn("Distancia");
            modelo.addColumn("Motorista");
            modelo.addColumn("Vehículo");
            modelo.addColumn("(JVPM)");
            int valor = 0;
            int dato = 1;
            Statement s = con.conectar().createStatement();
            ResultSet r = s.executeQuery("SELECT * FROM VisitaDonacion ORDER BY IdVisitaDonacion asc");


            while (r.next()) {
                if (r.getInt("IdVisitaDonacion") != 1) {
                    modelo.addRow(new Object[]{});
                    Statement t = con.conectar().createStatement();
                    ResultSet y = t.executeQuery("SELECT idRuta FROM RutaVisita WHERE idVisitaDonacion = '" + r.getInt("IdVisitaDonacion") + "'");
                    y.next();
                    modelo.setValueAt(y.getInt("idRuta"), valor, 0);
                    modelo.setValueAt(r.getDate("Fecha"), valor, 1);
                    modelo.setValueAt(r.getString("Hora"), valor, 2);
                    modelo.setValueAt(r.getString("LugarSalida"), valor, 3);
                    modelo.setValueAt(r.getString("LugarLlegada"), valor, 4);
                    modelo.setValueAt(r.getFloat("Distancia"), valor, 5);
                    modelo.setValueAt(motorista[dato], valor, 6);
                    modelo.setValueAt(vehiculo[dato], valor, 7);
                    modelo.setValueAt(r.getInt("JVPM"), valor, 8);
                    valor = valor + 1;
                    dato = dato + 1;
                }
            }
            table.setModel(modelo);
            numero = table.getColumnModel().getColumn(0);
            numero.setPreferredWidth(25);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        con.desconectar();

    }

    public void almacenarEncargado(Encargado encargado) {
        try {
            PreparedStatement sen = con.conectar().prepareStatement("UPDATE EncargadoPaciente SET Nombres ='" + encargado.getNombre() + "', Apeliidos ='" + encargado.getApellido() + "',DUI = '" + encargado.getDui() + "', Direccion = '" + encargado.getDireccion() + "', Parentesco = '" + encargado.getParentesco() + "', Telefono = '" + encargado.getTelefono() + "' WHERE Nit ='" + encargado.getNit() + "'");
            if (sen.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "¡Datos Modificados!");
            } else {
                PreparedStatement sentencia = con.conectar().prepareStatement("INSERT INTO EncargadoPaciente (Nit,Nombres,Apeliidos,DUI,Direccion,Parentesco,Telefono) VALUES ('" + encargado.getNit() + "','" + encargado.getNombre() + "','" + encargado.getApellido() + "','" + encargado.getDui() + "','" + encargado.getDireccion() + "','" + encargado.getParentesco() + "','" + encargado.getTelefono() + "')");
                sentencia.executeUpdate();
                JOptionPane.showMessageDialog(null, "¡Datos Almacenados!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        con.desconectar();
    }

    public void listarEncargados(JTable tabla) {
        try {

            TableColumn numero = null;
            Statement sentencia = null;
            ResultSet resultado = null;

            sentencia = con.conectar().createStatement();
            resultado = sentencia.executeQuery("SELECT Nit,Nombres,Apeliidos,DUI,Direccion,Parentesco,Telefono FROM EncargadoPaciente ORDER BY Apeliidos asc");
            DefaultTableModel modelo = new DefaultTableModel();

            modelo.addColumn("NIT");
            modelo.addColumn("DUI");
            modelo.addColumn("Nombres");
            modelo.addColumn("Apellidos");
            modelo.addColumn("Parentesco");
            modelo.addColumn("Dirección");
            modelo.addColumn("Teléfono");
            int valor = 0;
            while (resultado.next()) {
                modelo.addRow(new Object[]{});
                modelo.setValueAt(resultado.getString("Nit"), valor, 0);
                modelo.setValueAt(resultado.getString("DUI"), valor, 1);
                modelo.setValueAt(resultado.getString("Nombres"), valor, 2);
                modelo.setValueAt(resultado.getString("Apeliidos"), valor, 3);
                modelo.setValueAt(resultado.getString("Parentesco"), valor, 4);
                modelo.setValueAt(resultado.getString("Direccion"), valor, 5);
                modelo.setValueAt(resultado.getString("Telefono"), valor, 6);
                valor = valor + 1;
            }
            tabla.setModel(modelo);
            numero = tabla.getColumnModel().getColumn(0);
            numero.setPreferredWidth(105);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        con.desconectar();

    }

    public void eliminarEncargado(Encargado encargado) {
        try {
            PreparedStatement sentencia = con.conectar().prepareStatement("DELETE FROM EncargadoPaciente WHERE Nit = '" + encargado.getNit() + "'");
            if (sentencia.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "¡Eliminado Correctamente!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "¡El encargado tiene pacientes asignados actualmente,\nelimine el paciente primero para luego eliminar el encargado!");
        }
    }

    public void listarPacientesFiltrados(JTable tabla, String campo, String value) {
        try {

            Statement sentencia = null;
            ResultSet resultado = null;

            sentencia = con.conectar().createStatement();
            resultado = sentencia.executeQuery("SELECT * FROM Paciente WHERE " + campo + " ='" + value + "'");
            DefaultTableModel modelo = new DefaultTableModel();

            modelo.addColumn("Carnet");
            modelo.addColumn("Nombres");
            modelo.addColumn("Apellidos");
            modelo.addColumn("FechaNac");
            modelo.addColumn("SemanasGestacion");
            modelo.addColumn("Sexo");
            modelo.addColumn("Nit");
            modelo.addColumn("Notas");
            modelo.addColumn("Departamento");
            modelo.addColumn("Municipio");
            modelo.addColumn("Parto");
            modelo.addColumn("EdadMaterna");
            modelo.addColumn("Gravidez");
            modelo.addColumn("Patologia");
            modelo.addColumn("Tipo");

            int valor = 0;
            while (resultado.next()) {
                modelo.addRow(new Object[]{});
                modelo.setValueAt(resultado.getString("Carnet"), valor, 0);
                modelo.setValueAt(resultado.getString("Nombres"), valor, 1);
                modelo.setValueAt(resultado.getString("Apellidos"), valor, 2);
                modelo.setValueAt(resultado.getDate("FechaNac"), valor, 3);
                modelo.setValueAt(resultado.getDouble("SemanasGestacion"), valor, 4);
                modelo.setValueAt(resultado.getString("Sexo"), valor, 5);
                modelo.setValueAt(resultado.getString("Nit"), valor, 6);
                modelo.setValueAt(resultado.getString("Notas"), valor, 7);
                modelo.setValueAt(resultado.getString("Departamento"), valor, 8);
                modelo.setValueAt(resultado.getString("Municipio"), valor, 9);
                modelo.setValueAt(resultado.getString("Parto"), valor, 10);
                modelo.setValueAt(resultado.getString("EdadMaterna"), valor, 11);
                modelo.setValueAt(resultado.getString("Gravidez"), valor, 12);
                modelo.setValueAt(resultado.getString("Patologia"), valor, 13);
                modelo.setValueAt(resultado.getString("Tipo"), valor, 14);
                valor = valor + 1;
            }
            tabla.setModel(modelo);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        con.desconectar();
    }

    public void eliminarRuta(int id) {
        try {
            PreparedStatement sente = con.conectar().prepareStatement("DELETE FROM RutaVisita WHERE idVisitaDonacion ='" + id + "'");
            PreparedStatement sentencia = con.conectar().prepareStatement("DELETE FROM VisitaDonacion WHERE IdVisitaDonacion ='" + id + "'");
            if (sente.executeUpdate() == 1 && sentencia.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "¡Eliminado Correctamente!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "¡Ruta actualmente en uso!");
        }
    }

    public void modificarRuta(int idRuta, JTable tabla, JTextField medico, JTextField motorista, JTextField vehiculo, JCalendarCombo calendar) {
        try {
            TableColumn numero = null;
            Statement sent = con.conectar().createStatement();
            ResultSet resul = sent.executeQuery("SELECT COUNT(idVisitaDonacion) FROM RutaVisita WHERE idRuta = '" + idRuta + "'");
            resul.next();
            int tama = resul.getInt("");
            int ids[] = new int[tama];
            int valor = 0;
            Statement sentencia = con.conectar().createStatement();
            ResultSet resultado = sentencia.executeQuery("SELECT idVisitaDonacion FROM RutaVisita WHERE idRuta = '" + idRuta + "'");
            while (resultado.next()) {
                ids[valor] = resultado.getInt("idVisitaDonacion");
                valor = valor + 1;
            }

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("#");
            modelo.addColumn("Hora");
            modelo.addColumn("Kilometraje");
            modelo.addColumn("Lugar Salida");
            modelo.addColumn("Lugar Llegada");
            modelo.addColumn("Distancia (km)");
            int jvpm = 0;
            int idUnidad = 0;
            String Placa = "";
            String dui = "";
            Date fecha = null;

            for (int i = 0; i < tama; i++) {
                Statement sen = con.conectar().createStatement();
                ResultSet res = sen.executeQuery("SELECT * FROM VisitaDonacion WHERE IdVisitaDonacion = '" + ids[i] + "'");
                res.next();
                modelo.addRow(new Object[]{});
                jvpm = res.getInt("JVPM");
                idUnidad = res.getInt("IdUnidad");
                fecha = res.getDate("Fecha");
                modelo.setValueAt(res.getInt("IdVisitaDonacion"), i, 0);
                modelo.setValueAt(res.getString("Hora"), i, 1);
                modelo.setValueAt(res.getDouble("Kilometraje"), i, 2);
                modelo.setValueAt(res.getString("LugarSalida"), i, 3);
                modelo.setValueAt(res.getString("LugarLlegada"), i, 4);
                modelo.setValueAt(res.getString("Distancia"), i, 5);
            }

            Statement g = con.conectar().createStatement();
            ResultSet r = g.executeQuery("SELECT * FROM UnidadTransporte WHERE IdUnidad = '" + idUnidad + "'");
            r.next();
            Placa = r.getString("IdVehiculo");
            int idMoto = r.getInt("IdMotorista");
            Statement k = con.conectar().createStatement();
            ResultSet l = k.executeQuery("SELECT DUI FROM Motorista WHERE IdMotorista = '" + idMoto + "'");
            l.next();
            dui = l.getString("DUI");
            tabla.setModel(modelo);
            numero = tabla.getColumnModel().getColumn(0);
            numero.setPreferredWidth(20);
            medico.setText("" + jvpm);
            motorista.setText(dui);
            vehiculo.setText(Placa);
            medico.setEditable(false);
            motorista.setEditable(false);
            vehiculo.setEditable(false);
            calendar.setDate(fecha);
            calendar.setEnabled(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void modificarRutas(JTable tabla) {
        try {
            int msj = 0;
            for (int i = 0; i < tabla.getRowCount(); i++) {
                PreparedStatement mod = con.conectar().prepareStatement("UPDATE VisitaDonacion SET Hora ='" + tabla.getValueAt(i, 1).toString() + "', Kilometraje ='" + Double.parseDouble(tabla.getValueAt(i, 2).toString()) + "',LugarSalida = '" + tabla.getValueAt(i, 3).toString() + "', LugarLlegada = '" + tabla.getValueAt(i, 4).toString() + "', Distancia = '" + tabla.getValueAt(i, 5).toString() + "' WHERE IdVisitaDonacion ='" + Integer.parseInt(tabla.getValueAt(i, 0).toString()) + "'");
                msj = mod.executeUpdate();
            }
            if (msj == 1) {
                JOptionPane.showMessageDialog(null, "¡Datos Modificados!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al Modificar: " + e.getMessage());
        }
    }

    public void eliminarRutas(int id) {
        try {

            Statement s = con.conectar().createStatement();
            ResultSet r = s.executeQuery("SELECT * FROM RutaVisita WHERE idRuta ='" + id + "'");

            Statement t = con.conectar().createStatement();
            ResultSet v = t.executeQuery("SELECT COUNT(idVisitaDonacion) FROM RutaVisita WHERE idRuta = '" + id + "'");
            v.next();
            int tama = v.getInt("");
            int valor = 0;
            int idVisitas[] = new int[tama];
            while (r.next()) {
                idVisitas[valor] = r.getInt("idVisitaDonacion");
                valor = valor + 1;
            }
            PreparedStatement sente = con.conectar().prepareStatement("DELETE FROM RutaVisita WHERE IdRuta ='" + id + "'");
            int dato = sente.executeUpdate();
            for (int i = 0; i < idVisitas.length; i++) {
                PreparedStatement sentencia = con.conectar().prepareStatement("DELETE FROM VisitaDonacion WHERE IdVisitaDonacion ='" + idVisitas[i] + "'");
                sentencia.executeUpdate();
            }
            PreparedStatement sen = con.conectar().prepareStatement("DELETE FROM Ruta WHERE IdRuta ='" + id + "'");

            if (dato == 1 || sen.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "¡Eliminado Correctamente!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "¡Ruta actualmente en uso!");
        }

    }
    
    public void BuscarRutas(JTable table, String campo, String value) {
        try {
            Statement sentencia = null;
            ResultSet resultado = null;
            TableColumn numero = null;

            sentencia = con.conectar().createStatement();
            resultado = sentencia.executeQuery("SELECT * FROM VisitaDonacion ORDER BY IdVisitaDonacion asc");

            Statement senten = con.conectar().createStatement();
            ResultSet resulta = senten.executeQuery("SELECT COUNT(IdUnidad) FROM VisitaDonacion");
            resulta.next();
            int tamano = resulta.getInt("");
            String motorista[] = new String[tamano];
            String vehiculo[] = new String[tamano];
            for (int i = 0; i < tamano; i++) {
                resultado.next();
                Statement sentenc = con.conectar().createStatement();
                ResultSet resultad = sentenc.executeQuery("SELECT idMotorista, IdVehiculo FROM UnidadTransporte where IdUnidad = '" + resultado.getInt("IdUnidad") + "'");
                resultad.next();
                Statement sen1 = con.conectar().createStatement();
                ResultSet res1 = sen1.executeQuery("SELECT Nombre,Apellidos FROM Motorista WHERE IdMotorista ='" + resultad.getInt("idMotorista") + "'");
                res1.next();
                motorista[i] = res1.getString("Nombre") + " " + res1.getString("Apellidos");
                vehiculo[i] = resultad.getString("IdVehiculo");
            }

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("#");
            modelo.addColumn("Fecha");
            modelo.addColumn("Hora");
            modelo.addColumn("Lugar Salida");
            modelo.addColumn("Lugar Llegada");
            modelo.addColumn("Distancia");
            modelo.addColumn("Motorista");
            modelo.addColumn("Vehículo");
            modelo.addColumn("(JVPM)");
            int valor = 0;
            int dato = 1;
            Statement s = con.conectar().createStatement();
            ResultSet r = s.executeQuery("SELECT * FROM VisitaDonacion WHERE "+campo+" ='"+value+"' ORDER BY IdVisitaDonacion asc");


            while (r.next()) {
                if (r.getInt("IdVisitaDonacion") != 1) {
                    modelo.addRow(new Object[]{});
                    Statement t = con.conectar().createStatement();
                    ResultSet y = t.executeQuery("SELECT idRuta FROM RutaVisita WHERE idVisitaDonacion = '" + r.getInt("IdVisitaDonacion") + "'");
                    y.next();
                    modelo.setValueAt(y.getInt("idRuta"), valor, 0);
                    modelo.setValueAt(r.getDate("Fecha"), valor, 1);
                    modelo.setValueAt(r.getString("Hora"), valor, 2);
                    modelo.setValueAt(r.getString("LugarSalida"), valor, 3);
                    modelo.setValueAt(r.getString("LugarLlegada"), valor, 4);
                    modelo.setValueAt(r.getFloat("Distancia"), valor, 5);
                    modelo.setValueAt(motorista[dato], valor, 6);
                    modelo.setValueAt(vehiculo[dato], valor, 7);
                    modelo.setValueAt(r.getInt("JVPM"), valor, 8);
                    valor = valor + 1;
                    dato = dato + 1;
                }
            }
            table.setModel(modelo);
            numero = table.getColumnModel().getColumn(0);
            numero.setPreferredWidth(25);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        con.desconectar();

    }
}
