/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Contiene gran parte de las sentencias utilizadas
 * para insersión de datos en la base de datos.
 * @author USUARIO
 */
public class Operaciones {

    public String cod_parcial;
    public String rep1, rep2, rep3, rep4, rep5;
    public String numero, pregun, respues;
    public String nompar, fec, mat, grup, dep, doc;
    private Conexion con = new Conexion();
    public int verificar;

    /**
     * Método que se utiliza para agregar los datos
     * del encabezado del examen a crear.
     * @param nombrepar
     * @param fecha
     * @param materia
     * @param grupo
     * @param departamento
     * @param nombredoc
     * @param tipo
     * @throws SQLException
     */
    public void agregarEncabezado(String nombrepar, String fecha, String materia, String grupo, String departamento, String nombredoc, String tipo) throws SQLException {
        try {
            int row_update = 0;
            PreparedStatement stmt1 = con.conectar().prepareStatement("INSERT INTO parcial(nombre_parcial,fecha_parcial,materia,grupo_teorico,departamento, nombre_docente, tipo_parcial) VALUES(?,?,?,?,?,?,?)");
            stmt1.setString(1, nombrepar);
            stmt1.setString(2, fecha);
            stmt1.setString(3, materia);
            stmt1.setString(4, grupo);
            stmt1.setString(5, departamento);
            stmt1.setString(6, nombredoc);
            stmt1.setString(7, tipo);
            row_update = stmt1.executeUpdate();
            if (row_update == 1) {
                JOptionPane.showMessageDialog(null, "Encabezado creado correctamente");
                verificar = row_update;
            } else {
                JOptionPane.showMessageDialog(null, "Error al agregar el encabezado");
                verificar = row_update;
            }
            con.desconectar();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error " + ex.getMessage());
        }
    }

    /**
     * Método que se utiliza para agregar los datos
     * del parcial de tipo Complementar.
     * @param pregunta
     * @param num
     * @throws SQLException
     */
    public void agregarComplementar(String pregunta, String num) throws SQLException {
        try {
            int row_update = 0;
            PreparedStatement stmt1 = con.conectar().prepareStatement("INSERT INTO preguntas(cod_parcial,pregunta,num_pregunta) VALUES((SELECT MAX(cod_parcial) FROM parcial),?,?) ");
            stmt1.setString(1, pregunta);
            stmt1.setString(2, num);
            row_update = stmt1.executeUpdate();
            if (row_update == 1) {
                JOptionPane.showMessageDialog(null, "Pregunta agregada correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Error al agregar la pregunta");
            }
            con.desconectar();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error " + ex.getMessage());
        }
    }

    /**
     * Metodo que se utiliza para agregar los datos
     * del parcial tipo Falso-Verdadero.
     * @param preguntaV
     * @param num
     * @throws SQLException
     */
    public void agregarFalsoOVerdadero(String preguntaV, String num) throws SQLException {
        try {
            int row_update = 0;
            PreparedStatement stmt1 = con.conectar().prepareStatement("INSERT INTO preguntas(cod_parcial,pregunta,num_pregunta) VALUES((SELECT MAX(cod_parcial) FROM parcial),?,?) ");
            stmt1.setString(1, preguntaV);
            stmt1.setString(2, num);
            row_update = stmt1.executeUpdate();
            if (row_update == 1) {
                JOptionPane.showMessageDialog(null, "Pregunta agregada correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Error al agregar la pregunta");
            }
            con.desconectar();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error " + ex.getMessage());
        }
    }

    /**
     * Metodo que se utiliza para agregar los datos
     * de los parciales tipo Parentesis y Apareamiento.
     * @param pregunta
     * @param respuesta
     * @param num
     * @throws SQLException
     */
    public void agregarParentesis(String pregunta, String respuesta, String num) throws SQLException {
        try {
            int row_update = 0;
            PreparedStatement stmt1 = con.conectar().prepareStatement("INSERT INTO preguntas(cod_parcial,pregunta,respuesta,num_pregunta) VALUES((SELECT MAX(cod_parcial) FROM parcial),?,?,?)");
            stmt1.setString(1, pregunta);
            stmt1.setString(2, respuesta);
            stmt1.setString(3, num);
            row_update = stmt1.executeUpdate();
            if (row_update == 1) {
                JOptionPane.showMessageDialog(null, "Pregunta agregada correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Error al agregar la pregunta");
            }
            con.desconectar();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error " + ex.getMessage());
        }
    }

    /**
     * Método que se utiliza para agregar los datos
     * del parcial tipo Opción Múltiple.
     * @param pre
     * @param res
     * @param res1
     * @param res2
     * @param res3
     * @param res4
     * @param num
     * @throws SQLException
     */
    public void agregarOpcionMulti(String pre, String res, String res1, String res2, String res3, String res4, String num) throws SQLException {
        try {
            int update_rows = 0;
            PreparedStatement stmt1 = con.conectar().prepareStatement("INSERT INTO opcion_multiple (cod_parcial, preguntaO, respuesta1, respuesta2, respuesta3, respuesta4, respuesta5, numPregunta )values((SELECT MAX(cod_parcial) FROM parcial),?,?,?,?,?,?,?)");
            stmt1.setString(1, pre);
            stmt1.setString(2, res);
            stmt1.setString(3, res1);
            stmt1.setString(4, res2);
            stmt1.setString(5, res3);
            stmt1.setString(6, res4);
            stmt1.setString(7, num);
            update_rows = stmt1.executeUpdate();
            if (update_rows == 1) {
                JOptionPane.showMessageDialog(null, "Pregunta agregada correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Error al agregar la pregunta");
            }
            con.desconectar();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error " + ex.getMessage());
        }
    }

    /**
     * Método que busca una pregunta
     * en base a su número asignado.
     * @param valor
     * @throws SQLException
     */
    public void enlazar(String valor) throws SQLException {
        try {
            Statement sentencia = null;
            ResultSet resultado = null;
            sentencia = con.conectar().createStatement();
            resultado = sentencia.executeQuery("SELECT * FROM preguntas WHERE num_pregunta='" + valor + "'");
            while (resultado.next()) {
                numero = (resultado.getString("num_pregunta"));
                pregun = (resultado.getString("pregunta"));
                respues = (resultado.getString("respuesta"));
            }
            resultado.last();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    /**
     * Actualiza los datos en la
     * base de datos.
     * @param numero
     * @param respuesta
     * @param pregunta
     * @throws SQLException
     */
    public void actualizar(String numero, String respuesta, String pregunta) throws SQLException {
        PreparedStatement stmt1 = con.conectar().prepareStatement("update preguntas"
                + " set pregunta = ? ,"
                + " respuesta = ? "
                + " where num_pregunta = ?");
        stmt1.setString(1, pregunta);
        stmt1.setString(2, respuesta);
        stmt1.setString(3, numero);
        stmt1.execute();
        stmt1.close();
        con.desconectar();
    }

    /**
     * Metodo que selecciona las preguntas y respuestas
     * del parcial de tipo Opción Múltiple.
     * @param valor
     */
    public void actualizarOpcnionMult(String valor) {
        try {
            Statement sentencia = null;
            ResultSet resultado = null;
            sentencia = con.conectar().createStatement();
            resultado = sentencia.executeQuery("SELECT * FROM opcion_multiple WHERE numPregunta='" + valor + "'");
            while (resultado.next()) {
                numero = (resultado.getString("numPregunta"));
                pregun = (resultado.getString("preguntaO"));
                rep1 = (resultado.getString("respuesta1"));
                rep2 = (resultado.getString("respuesta2"));
                rep3 = (resultado.getString("respuesta3"));
                rep4 = (resultado.getString("respuesta4"));
                rep5 = (resultado.getString("respuesta5"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        con.desconectar();
    }

    /**
     * Metodo que actualiza las preguntas y respuestas del
     * parcial de tipo Opción Múltiple.
     * @param num
     * @param pre
     * @param resp1
     * @param resp2
     * @param resp3
     * @param resp4
     * @param resp5
     * @throws SQLException
     */
    public void actualizarOpcionMultiple(String num, String pre, String resp1, String resp2, String resp3, String resp4, String resp5) throws SQLException {
        boolean rows_update = false;
        PreparedStatement stmt1 = con.conectar().prepareStatement("update opcion_multiple "
                + "set preguntaO = ? ,"
                + "respuesta1 = ? ,"
                + "respuesta2 = ? ,"
                + "respuesta3 = ? ,"
                + "respuesta4 = ? ,"
                + "respuesta5 = ?  "
                + "where numPregunta = ? ");
        stmt1.setString(1, pre);
        stmt1.setString(2, resp1);
        stmt1.setString(3, resp2);
        stmt1.setString(4, resp3);
        stmt1.setString(5, resp4);
        stmt1.setString(6, resp5);
        stmt1.setString(7, num);
        rows_update = stmt1.execute();
    }

    /**
     * Metodo que busca el maximo codigo de parcial, denotando
     * así el parcial con el que esta trabajando.
     * @param valor
     * @throws SQLException
     */
    public void BuscarPrimary(String valor) throws SQLException {
        ResultSet resultado = null;
        Statement stmt1 = null;
        stmt1 = con.conectar().createStatement();
        resultado = stmt1.executeQuery("SELECT MAX(cod_parcial) FROM parcial WHERE materia = '" + valor + "'");
        while (resultado.next()) {
            cod_parcial = String.valueOf(resultado.getInt("MAX(cod_parcial)"));
        }
    }

    /**
     * Modelo de la Tabla en el que se muestran
     * todos los datos del parcial seleccionado.
     * @param tipo
     * @param valor
     * @return
     */
    public DefaultTableModel buscar_parciales(String tipo, String valor) {
        DefaultTableModel res = new DefaultTableModel();
        res.addColumn("cod_parcial");
        res.addColumn("nombre_parcial");
        res.addColumn("fecha_parcial");
        res.addColumn("materia");
        res.addColumn("grupo_teorico");
        res.addColumn("departamento");
        res.addColumn("nombre_docente");
        res.addColumn("tipo_parcial");
        try {
            Statement sentencia = null;
            ResultSet resultado = null;
            sentencia = con.conectar().createStatement();
            resultado = sentencia.executeQuery("SELECT * FROM parcial WHERE tipo_parcial = '" + tipo + "' AND materia LIKE '" + valor + "%'");
            int x = 0;
            resultado.last();
            if (resultado.getRow() > 0) {
                resultado.beforeFirst();
                while (resultado.next()) {
                    res.addRow(new Object[]{});
                    res.setValueAt(resultado.getString("cod_parcial"), x, 0);
                    res.setValueAt(resultado.getString("nombre_parcial"), x, 1);
                    res.setValueAt(resultado.getString("fecha_parcial"), x, 2);
                    res.setValueAt(resultado.getString("materia"), x, 3);
                    res.setValueAt(resultado.getString("grupo_teorico"), x, 4);
                    res.setValueAt(resultado.getString("departamento"), x, 5);
                    res.setValueAt(resultado.getString("nombre_docente"), x, 6);
                    res.setValueAt(resultado.getString("tipo_parcial"), x, 7);
                    x++;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        con.desconectar();
        return res;
    }

    /**
     * Metodo que se encarga de eliminar
     * un parcial seleccionado.
     * @param cod
     */
    public void eliminar(int cod) {
        try {
            int rows_updated = 0;
            PreparedStatement stmt1 = con.conectar().prepareStatement("DELETE FROM parcial WHERE cod_parcial = '" + cod + "'");
            rows_updated = stmt1.executeUpdate();
            if (rows_updated == 1) {
                JOptionPane.showMessageDialog(null, "Parcial eliminado");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar");
            }
            con.desconectar();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error " + ex.getMessage());
        }
    }

    /**
     * Selecciona todos los datos de la tabla "preguntas"
     * en base al código del parcial y el número de pregunta
     * para todos los parciales, a excepción del Opción Múltiple.
     * @param valor
     * @param cod
     * @throws SQLException
     */
    public void enlazarParciales(String valor, int cod) throws SQLException {
        try {
            Statement sentencia = null;
            ResultSet resultado = null;
            sentencia = con.conectar().createStatement();
            resultado = sentencia.executeQuery("SELECT * FROM preguntas  WHERE cod_parcial = '" + cod + "' AND num_pregunta = '" + valor + "'");
            while (resultado.next()) {
                pregun = (resultado.getString("pregunta"));
                respues = (resultado.getString("respuesta"));
            }
            resultado.last();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    /**
     * Selecciona todos los datos de la tabla "preguntas"
     * en base al código del parcial y el número de pregunta
     * para el parcial de tipo Opción Múltiple.
     * @param valor
     * @param cod
     */
    public void enlazarOpcnionMult(String valor, int cod) {
        try {
            Statement sentencia = null;
            ResultSet resultado = null;
            sentencia = con.conectar().createStatement();
            resultado = sentencia.executeQuery("SELECT * FROM opcion_multiple WHERE cod_parcial = '" + cod + "' AND numPregunta='" + valor + "'");
            while (resultado.next()) {
                numero = (resultado.getString("numPregunta"));
                pregun = (resultado.getString("preguntaO"));
                rep1 = (resultado.getString("respuesta1"));
                rep2 = (resultado.getString("respuesta2"));
                rep3 = (resultado.getString("respuesta3"));
                rep4 = (resultado.getString("respuesta4"));
                rep5 = (resultado.getString("respuesta5"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        con.desconectar();
    }

    /**
     * Modifica y Actualiza los datos del encabezado
     * de un parcial en específico.
     * @param cod
     * @param nom
     * @param fec
     * @param mat
     * @param grup
     * @param dep
     * @param doc
     * @throws SQLException
     */
    public void actualizarEncabezado(int cod, String nom, String fec, String mat, String grup, String dep, String doc) throws SQLException {
        boolean rows_update = false;
        PreparedStatement stmt1 = con.conectar().prepareStatement("update parcial "
                + "set nombre_parcial = ? ,"
                + "fecha_parcial = ? ,"
                + "materia = ? ,"
                + "grupo_teorico = ? ,"
                + "departamento = ? , "
                + "nombre_docente = ? "
                + "where cod_parcial = ? ");
        stmt1.setString(1, nom);
        stmt1.setString(2, fec);
        stmt1.setString(3, mat);
        stmt1.setString(4, grup);
        stmt1.setString(5, dep);
        stmt1.setString(6, doc);
        stmt1.setInt(7, cod);
        rows_update = stmt1.execute();
        if (rows_update == true) {
            JOptionPane.showMessageDialog(null, "Modificacion Correcta");
        }
    }

    /**
     * metodo que permite ingresarse en el sistema
     * para poder acceder como usuario registrado
     * @param usuario
     * @param clave
     * @throws SQLException
     */
    public void Resgistrarse(String usuario, String clave) throws SQLException {
        try {
            int row_update = 0;
            PreparedStatement stmt1 = con.conectar().prepareStatement("INSERT INTO Login(usuario,clave) VALUES(?,?) ");
            stmt1.setString(1, usuario);
            stmt1.setString(2, clave);
            row_update = stmt1.executeUpdate();
            if (row_update == 1) {
                JOptionPane.showMessageDialog(null, "Registro Satisfactorio");
            } else {
                JOptionPane.showMessageDialog(null, "Error al intentar registrarse");
            }
            con.desconectar();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error " + ex.getMessage());
        }
    }
}
