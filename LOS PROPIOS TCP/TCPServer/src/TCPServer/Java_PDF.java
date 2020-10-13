/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TCPServer;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

//Importacion de manejo de archivos

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

//Librerias ajenas a itext

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import sun.applet.Main;

/**
 *
 * @author ESCM1990
 */
public class Java_PDF {

    private File ruta_destino = null;

    /*Método que hace uso de la clase itext para manipular archivos PDF*/
    public void crearPDF(String titulo, String contenido) throws FileNotFoundException {
        //Abre la ventana de Dialogo "Guardar"
        colocarDestino();
        //Si destino es diferente de Null, entonces...
        if (this.ruta_destino != null) {
            try {
                //Se crea la instancia del documento
                Document miPDF = new Document();
                //Se establece una instancia a un documento PDF
                PdfWriter.getInstance(miPDF, new FileOutputStream(ruta_destino + ".pdf"));
                miPDF.open();//Se abre el Documento
                miPDF.addTitle(titulo);//Se añade el Titulo del Documento
                miPDF.add(new Paragraph(contenido));//Se añade el contenido del Documento
                miPDF.close();//Se cierra el Documento
                JOptionPane.showMessageDialog(null, "Documento PDF creado");
            } catch (DocumentException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    //Abre la ventana de Dialogo "Guardar"
    public void colocarDestino() {
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo PDF", "pdf", "PDF");
        JFileChooser filechooser = new JFileChooser();
        filechooser.setFileFilter(filter);
        int result = filechooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            this.ruta_destino = filechooser.getSelectedFile().getAbsoluteFile();
        }
    }
}
