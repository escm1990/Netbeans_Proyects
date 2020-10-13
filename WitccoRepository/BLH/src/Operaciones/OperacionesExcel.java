/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Operaciones;

import accesoDatos.Conexion;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import jxl.write.Label;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.write.WritableCellFormat;

/**
 *
 * @author Erick Cruz
 */
public class OperacionesExcel {

    Conexion con = new Conexion();

    public void crearExcel(String ruta) throws IOException, WriteException {
        try {

            WritableWorkbook workbook = Workbook.createWorkbook(new File(ruta));
            WritableSheet sheet = workbook.createSheet("Datos donantes", 0);
            WritableCellFormat formatito = new WritableCellFormat();
            formatito.setWrap(true);
            formatito.setBorder(Border.ALL, BorderLineStyle.THIN, Colour.BLACK);
            
            Label label0 = new Label(0, 0, "Documento");
            Label label15 = new Label(1, 0, "Fecha Obt. Datos");
            Label label16 = new Label(2, 0, "Direccion");
            Label label1 = new Label(3, 0, "Nombres");
            Label label2 = new Label(4, 0, "Apellidos");
            Label label3 = new Label(5, 0, "Fecha Nacimiento");
            Label label4 = new Label(6, 0, "Peso");
            Label label5 = new Label(7, 0, "Estatura");
            Label label6 = new Label(8, 0, "Semanas Gestación");
            Label label7 = new Label(9, 0, "Fecha Parto");
            Label label8 = new Label(10, 0, "VDRL");
            Label label9 = new Label(11, 0, "HbsAg");
            Label label10 = new Label(12, 0, "HIV");
            Label label11 = new Label(13, 0, "Transf. Sanguínea (ult. 5 años)");
            Label label12 = new Label(14, 0, "Tabaquismo");
            Label label13 = new Label(15, 0, "Etilismo");
            Label label14 = new Label(16, 0, "Apta Donar");
            Label label17 = new Label(17, 0, "Raciones Aceptadas");
            Label label18 = new Label(18, 0, "Raciones Descartadas");
            Label label19 = new Label(19, 0, "Fecha Ultima Donacion");
            sheet.addCell(label0);
            sheet.addCell(label1);
            sheet.addCell(label2);
            sheet.addCell(label3);
            sheet.addCell(label4);
            sheet.addCell(label5);
            sheet.addCell(label6);
            sheet.addCell(label7);
            sheet.addCell(label8);
            sheet.addCell(label9);
            sheet.addCell(label10);
            sheet.addCell(label11);
            sheet.addCell(label12);
            sheet.addCell(label13);
            sheet.addCell(label14);
            sheet.addCell(label15);
            sheet.addCell(label16);
            sheet.addCell(label17);
            sheet.addCell(label18);
            sheet.addCell(label19);

            Statement sentencia = null;
            ResultSet resultado = null;
            sentencia = con.conectar().createStatement();
            resultado = sentencia.executeQuery("SELECT * FROM Persona ORDER BY Documento asc");

            int valor = 0;
            while (resultado.next()) {
//                for (int i = 0; i < 10; i++) {
                Label label20 = new Label(0, valor + 1, resultado.getString("Documento"), formatito);
                Label label21 = new Label(1, valor + 1, resultado.getString("FechaObtDatos"), formatito);
                Label label22 = new Label(2, valor + 1, resultado.getString("Direccion"), formatito);
                Label label23 = new Label(3, valor + 1, resultado.getString("Nombres"), formatito);
                Label label24 = new Label(4, valor + 1, resultado.getString("Apellidos"), formatito);
                Label label25 = new Label(5, valor + 1, resultado.getString("FechaNac"), formatito);
                Label label26 = new Label(6, valor + 1, resultado.getString("Peso"), formatito);
                Label label27 = new Label(7, valor + 1, resultado.getString("Estatura"), formatito);
                Label label28 = new Label(8, valor + 1, resultado.getString("SemGesta"), formatito);
                Label label29 = new Label(9, valor + 1, resultado.getString("FechaParto"), formatito);
                Label label30 = new Label(10, valor + 1, resultado.getString("vdrl"), formatito);
                Label label31 = new Label(11, valor + 1, resultado.getString("hbsag"), formatito);
                Label label32 = new Label(12, valor + 1, resultado.getString("hiv"), formatito);
                Label label33 = new Label(13, valor + 1, resultado.getString("TransSangui"), formatito);
                Label label34 = new Label(14, valor + 1, resultado.getString("Tabaquismo"), formatito);
                Label label35 = new Label(15, valor + 1, resultado.getString("Etilismo"), formatito);
                Label label36 = new Label(16, valor + 1, resultado.getString("AptaDonar"), formatito);

                sheet.addCell(label20);
                sheet.addCell(label21);
                sheet.addCell(label22);
                sheet.addCell(label23);
                sheet.addCell(label24);
                sheet.addCell(label25);
                sheet.addCell(label26);
                sheet.addCell(label27);
                sheet.addCell(label28);
                sheet.addCell(label29);
                sheet.addCell(label30);
                sheet.addCell(label31);
                sheet.addCell(label32);
                sheet.addCell(label33);
                sheet.addCell(label34);
                sheet.addCell(label35);
                sheet.addCell(label36);
                valor = valor + 1;
            }
            con.desconectar();

            workbook.write();
            workbook.close();

            Process p = Runtime.getRuntime().exec("rundll32 SHELL32.DLL,ShellExec_RunDLL " + ruta);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }

    public String obtenerRutaExcel() {
        String rutaE = null;
        try {
            JFileChooser jfc = new JFileChooser();
            jfc.showSaveDialog(null);
            rutaE = jfc.getSelectedFile().getPath() + ".xls";
            System.out.println(rutaE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede exportar a Excel");
        }
        return rutaE;
    }
    
       public void exportarExcelLab(String ruta, JTable tablita) throws IOException, WriteException {
        try {
            
            //Exportación a Excel
            WritableWorkbook workbook = Workbook.createWorkbook(new File(ruta));
            WritableSheet sheet = workbook.createSheet("Informe Laboratorista", 0);
            
            WritableCellFormat formatito = new WritableCellFormat();
            formatito.setWrap(true);
            formatito.setBorder(Border.ALL, BorderLineStyle.THIN, Colour.BLACK);
            
            WritableCellFormat formatitoT = new WritableCellFormat();
            formatitoT.setBorder(Border.ALL, BorderLineStyle.THIN, Colour.BLACK);
            
            //Encabezados de los datos del paciente
            Label label0 = new Label(1, 0, "FORMULARIO PARA REGISTRO DIARIO DE RESULTADOS", formatitoT);
            Label label1 = new Label(1, 1, "INVESTIGACION DE COLIFORMES TOTALES", formatitoT);
            Label label3_1 = new Label(3, 3, "PRESENCIA", formatitoT);
            Label label4_1 = new Label(5, 3, "AUSENCIA", formatitoT);
            Label label2 = new Label(1, 4, "Fecha", formatitoT);
            Label label3 = new Label(2, 4, "Muestras Analizadas", formatitoT);
            Label label4 = new Label(3, 4, "N", formatitoT);
            Label label5 = new Label(4, 4, "%", formatitoT);
            Label label6 = new Label(5, 4, "N", formatitoT);
            Label label7 = new Label(6, 4, "%", formatitoT);

            //Agregando datos en las celdas           
            sheet.addCell(label0);
            sheet.addCell(label1);
            sheet.addCell(label2);
            sheet.addCell(label3);
            sheet.addCell(label3_1);
            sheet.addCell(label4_1);
            sheet.addCell(label4);
            sheet.addCell(label5);
            sheet.addCell(label6);
            sheet.addCell(label7);

            //Llenando las fechas
            for (int i = 0; i < tablita.getRowCount(); i++) {
                Object object = tablita.getValueAt(i, 0);
                sheet.addCell(new Label(1, 5+i, String.valueOf(object), formatito));                
            }
            
            //Llenando las muestras analizadas
            for (int i = 0; i < tablita.getRowCount(); i++) {
                Object object = tablita.getValueAt(i, 1);
                sheet.addCell(new Label(2, 5+i, String.valueOf(object), formatito));                
            }
            
            //Llenando Presencia N
            for (int i = 0; i < tablita.getRowCount(); i++) {
                Object object = tablita.getValueAt(i, 2);
                sheet.addCell(new Label(3, 5+i, String.valueOf(object), formatito));                
            }
            
            //Llenando PresenciaPor
            for (int i = 0; i < tablita.getRowCount(); i++) {
                Object object = tablita.getValueAt(i, 3);
                sheet.addCell(new Label(4, 5+i, String.valueOf(object), formatito));                
            }
            
            //Llenando Ausencia N
            for (int i = 0; i < tablita.getRowCount(); i++) {
                Object object = tablita.getValueAt(i, 4);
                sheet.addCell(new Label(5, 5+i, String.valueOf(object), formatito));                
            }
            
            //Llenando PresenciaPor
            for (int i = 0; i < tablita.getRowCount(); i++) {
                Object object = tablita.getValueAt(i, 5);
                sheet.addCell(new Label(6, 5+i, String.valueOf(object), formatito));                
            }
            
            //Escribiendo y cerrando el libro
            workbook.write();
            workbook.close();
            
            Process p = Runtime.getRuntime().exec("rundll32 SHELL32.DLL,ShellExec_RunDLL " + ruta);

        } catch (Exception e) {
            System.out.println("ERROR EN EXCEL: " + e);
        }
    }

        public void exportarExcelProd(String ruta, JTable tablita) throws IOException, WriteException {
        try {

            //Exportación a Excel
            WritableWorkbook workbook = Workbook.createWorkbook(new File(ruta));
            WritableSheet sheet = workbook.createSheet("Informe de Produccion", 0);
            WritableCellFormat formatito = new WritableCellFormat();
            formatito.setWrap(true);
            formatito.setBorder(Border.ALL, BorderLineStyle.THIN, Colour.BLACK);
            
            Label label0 = new Label(0, 1, "Actividades Asistenciales");
            Label label0x = new Label(0, 1, "Fecha", formatito);
            Label label1 = new Label(1, 1, "Atendimiento Individual", formatito);
            Label label2 = new Label(2, 1, "Atendimiento Grupal", formatito);
            Label label3 = new Label(3, 1, "Visita Domiciliar", formatito);
            Label label4 = new Label(4, 1, "Total de Atendimientos", formatito);
            
            Label label5 = new Label(6, 0, "Recolección y Distribucion de LHO");          
            Label label6 = new Label(5, 1, "Recolectado (lt)", formatito);
            Label label7 = new Label(6, 1, "Distribuido (lt)", formatito);
            Label label8 = new Label(7, 1, "Donantes en el periodo", formatito);
            Label label9 = new Label(8, 1, "Receptores en el periodo", formatito);
            
            Label label10 = new Label(10, 0, "Control de Calidad (Analisis)");
            Label label11 = new Label(9, 1, "Microbiológicos", formatito);
            Label label12 = new Label(10, 1, "Fisico-Químico", formatito);
            Label label13 = new Label(11, 1, "-Crematocito", formatito);
            Label label14 = new Label(12, 1, "-AcidezDornic", formatito);
            Label label15 = new Label(13, 1, "-Total de Analisis Fisico-Quimicos", formatito);
            Label label16 = new Label(14, 1, "-Total General de Analisis", formatito);

            sheet.addCell(label0);
            sheet.addCell(label0x);
            sheet.addCell(label1);
            sheet.addCell(label2);
            sheet.addCell(label3);
            sheet.addCell(label4);
            sheet.addCell(label5);
            sheet.addCell(label6);
            sheet.addCell(label7);
            sheet.addCell(label8);
            sheet.addCell(label9);
            sheet.addCell(label10);
            sheet.addCell(label11);
            sheet.addCell(label12);
            sheet.addCell(label13);
            sheet.addCell(label14);
            sheet.addCell(label15);
            sheet.addCell(label16);
                        
            //Llenando ID
            for (int i = 0; i < tablita.getRowCount(); i++) {
                Object object = tablita.getValueAt(i, 0);
                sheet.addCell(new Label(0, 2+i, String.valueOf(object), formatito));                
            }
            
            //Llenando Atendimiento Individual
            for (int i = 0; i < tablita.getRowCount(); i++) {
                Object object = tablita.getValueAt(i, 1);
                sheet.addCell(new Label(1, 2+i, String.valueOf(object), formatito));                
            }
            
            //Llenando Atendimiento Grupal
            for (int i = 0; i < tablita.getRowCount(); i++) {
                Object object = tablita.getValueAt(i, 2);
                sheet.addCell(new Label(2, 2+i, String.valueOf(object), formatito));                
            }
            
            //Llenando Visita Domiciliar
            for (int i = 0; i < tablita.getRowCount(); i++) {
                Object object = tablita.getValueAt(i, 3);
                sheet.addCell(new Label(3, 2+i, String.valueOf(object), formatito));                
            }
            
            //Llenando Total Atendimientos
            for (int i = 0; i < tablita.getRowCount(); i++) {
                Object object = tablita.getValueAt(i, 4);
                sheet.addCell(new Label(4, 2+i, String.valueOf(object), formatito));                
            }
            
            //Llenando Recolectado (lt)
            for (int i = 0; i < tablita.getRowCount(); i++) {
                Object object = tablita.getValueAt(i, 5);
                sheet.addCell(new Label(5, 2+i, String.valueOf(object), formatito));                
            }
            
            //Llenando Distribuido (lt)
            for (int i = 0; i < tablita.getRowCount(); i++) {
                Object object = tablita.getValueAt(i, 6);
                sheet.addCell(new Label(6, 2+i, String.valueOf(object), formatito));                
            }
            
            //Llenando Donantes de Periodo
            for (int i = 0; i < tablita.getRowCount(); i++) {
                Object object = tablita.getValueAt(i, 7);
                sheet.addCell(new Label(7, 2+i, String.valueOf(object), formatito));                
            }
            
            //Llenando Receptores de Periodo
            for (int i = 0; i < tablita.getRowCount(); i++) {
                Object object = tablita.getValueAt(i, 8);
                sheet.addCell(new Label(8, 2+i, String.valueOf(object), formatito));                
            }
            
            //Llenando Microbiologia
            for (int i = 0; i < tablita.getRowCount(); i++) {
                Object object = tablita.getValueAt(i, 9);
                sheet.addCell(new Label(9, 2+i, String.valueOf(object), formatito));                
            }
            
            //Llenando Fisico Quimico
            for (int i = 0; i < tablita.getRowCount(); i++) {
                Object object = tablita.getValueAt(i, 10);
                sheet.addCell(new Label(10, 2+i, String.valueOf(object), formatito));                
            }
            
            //Llenando Crematocrito
            for (int i = 0; i < tablita.getRowCount(); i++) {
                Object object = tablita.getValueAt(i, 11);
                sheet.addCell(new Label(11, 2+i, String.valueOf(object), formatito));                
            }
            
            //Llenando AcidezDornic
            for (int i = 0; i < tablita.getRowCount(); i++) {
                Object object = tablita.getValueAt(i, 12);
                sheet.addCell(new Label(12, 2+i, String.valueOf(object), formatito));                
            }
            
            //Llenando Total Analizadas FQ
            for (int i = 0; i < tablita.getRowCount(); i++) {
                Object object = tablita.getValueAt(i, 13);
                sheet.addCell(new Label(13, 2+i, String.valueOf(object), formatito));                
            }
            
            //Llenando Total General
            for (int i = 0; i < tablita.getRowCount(); i++) {
                Object object = tablita.getValueAt(i, 14);
                sheet.addCell(new Label(14, 2+i, String.valueOf(object), formatito));                
            }
            
            //Escribiendo y cerrando el libro
            workbook.write();
            workbook.close();

            Process p = Runtime.getRuntime().exec("rundll32 SHELL32.DLL,ShellExec_RunDLL " + ruta);

        } catch (Exception e) {
            System.out.println("ERROR EN EXCEL: " + e);
        }
    
}

    public void exportarExcelCons(String ruta, JTable tablita) {
                try {
            
            //Exportación a Excel
            WritableWorkbook workbook = Workbook.createWorkbook(new File(ruta));
            WritableSheet sheet = workbook.createSheet("Datos Consulta", 0);
            
            WritableCellFormat formatito = new WritableCellFormat();
            formatito.setWrap(true);
            formatito.setBorder(Border.ALL, BorderLineStyle.THIN, Colour.BLACK);
            WritableCellFormat formatitoB = new WritableCellFormat();
            formatitoB.setBorder(Border.ALL, BorderLineStyle.THIN, Colour.BLACK);
            
            //Encabezados de los datos del paciente
            Label labelT = new Label(3,0,"Datos del paciente");            
            //Label label0 = new Label(0, 2, "N°",formatitoB);
            Label label1 = new Label(8,2,"Diagnostico",formatitoB);
            Label label2 = new Label(0,2,"Fecha",formatitoB);
            Label label3 = new Label(6,2,"RacionA",formatitoB);
            Label label4 = new Label(2,2,"JVPM",formatitoB);
            Label label5 = new Label(1,2,"Carnet",formatitoB);
            Label label6 = new Label(3,2,"Peso",formatitoB);
            Label label7 = new Label(4,2,"Estatura",formatitoB);
            Label label8 = new Label(5,2,"Per. Cef.",formatitoB);
            Label label9 = new Label(7,2,"Condicion",formatitoB);
            
            sheet.addCell(labelT);
            //sheet.addCell(label0);
            sheet.addCell(label1);
            sheet.addCell(label2);
            sheet.addCell(label3);
            sheet.addCell(label4);
            sheet.addCell(label5);
            sheet.addCell(label6);
            sheet.addCell(label7);
            sheet.addCell(label8);
            sheet.addCell(label9);
//            
//            //Llenando Id
//            for (int i = 0; i < tablita.getRowCount(); i++) {
//                Object object = tablita.getValueAt(i, 0);
//                sheet.addCell(new Label(0, 3+i, String.valueOf(object), formatito));                
//            }
            
            //Llenando Diagnostico
            for (int i = 0; i < tablita.getRowCount(); i++) {
                Object object = tablita.getValueAt(i, 8);
                sheet.addCell(new Label(8, 3+i, String.valueOf(object), formatito));                
            }
            
            //Llenando Fecha
            for (int i = 0; i < tablita.getRowCount(); i++) {
                Object object = tablita.getValueAt(i, 0);
                sheet.addCell(new Label(0, 3+i, String.valueOf(object), formatito));                
            }
            
            //Llenando RacionAsignada
            for (int i = 0; i < tablita.getRowCount(); i++) {
                Object object = tablita.getValueAt(i, 6);
                sheet.addCell(new Label(6, 3+i, String.valueOf(object), formatito));                
            }
            
            //Llenando JVPM
            for (int i = 0; i < tablita.getRowCount(); i++) {
                Object object = tablita.getValueAt(i, 2);
                sheet.addCell(new Label(2, 3+i, String.valueOf(object), formatito));                
            }
            
            //Llenando Carnet
            for (int i = 0; i < tablita.getRowCount(); i++) {
                Object object = tablita.getValueAt(i, 1);
                sheet.addCell(new Label(1, 3+i, String.valueOf(object), formatito));                
            }
            
            //Llenando Peso
            for (int i = 0; i < tablita.getRowCount(); i++) {
                Object object = tablita.getValueAt(i, 3);
                sheet.addCell(new Label(3, 3+i, String.valueOf(object), formatito));                
            }
            
            //Llenando Estatura
            for (int i = 0; i < tablita.getRowCount(); i++) {
                Object object = tablita.getValueAt(i, 4);
                sheet.addCell(new Label(4, 3+i, String.valueOf(object), formatito));                
            }
            
            //Llenando PerimetroCefalico
            for (int i = 0; i < tablita.getRowCount(); i++) {
                Object object = tablita.getValueAt(i, 5);
                sheet.addCell(new Label(5, 3+i, String.valueOf(object), formatito));                
            }
            
            //Llenando Condicion Salud
            for (int i = 0; i < tablita.getRowCount(); i++) {
                Object object = tablita.getValueAt(i, 7);
                sheet.addCell(new Label(7, 3+i, String.valueOf(object), formatito));                
            }
                              
            //Escribiendo y cerrando el libro
            workbook.write();
            workbook.close();
            
            Process p = Runtime.getRuntime().exec("rundll32 SHELL32.DLL,ShellExec_RunDLL " + ruta);

        } catch (Exception e) {
            System.out.println("ERROR EN EXCEL: " + e);
        }

    }
}
