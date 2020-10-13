package excelexporter;

import java.io.*;
import javax.swing.*;
import jxl.write.*;
import jxl.*;

public class ExcelTableExporter {

    private File file;
    private JTable table;
    private String nombreTab;

    public ExcelTableExporter(JTable table, File file, String nombreTab) {
        this.file = file;
        this.table = table;
        this.nombreTab = nombreTab;
    }

    public boolean export() {
        try {
            DataOutputStream out = new DataOutputStream(new FileOutputStream(file));

            WritableWorkbook w = Workbook.createWorkbook(out);

            WritableSheet s = w.createSheet(nombreTab, 0);

            for (int i = 0; i < table.getColumnCount(); i++) {
                for (int j = 0; j < table.getRowCount(); j++) {
                    Object objeto = table.getValueAt(i, j);
                    s.addCell(new Label(i, j, String.valueOf(objeto)));
                }
            }
            w.write();
            w.close();
            out.close();

            return true;

        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (WriteException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}