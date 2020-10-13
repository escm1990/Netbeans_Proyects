/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Erick Cruz
 */
public class Repositorio {

    String Nombre;
    String Direccion;
    Boolean Activo;
    Boolean Autenticacion;
    String Usuario;
    String Clave;
    Version[] Versiones;
    Version VersionActual;
    Version VersionRecomendada;
    String versionTXT;

    public Version[] obtenerVersiones() {
        //    ruta = extraerRepositorio(System.getProperty("user.dir") + "\\src\\archivo.xml");
//     ruta = extraerRepositorio("C:\\Users\\Usuario\\Dropbox\\DisenoSistema\\Actualizador1.0\\src\\archivo.xml");
//    System.out.println("ruta: " + ruta);


//        cargarVersiones(ruta, this.jtbVersiones);
//        jlFlecha.setVisible(true);
//        jtbVersiones.setRowSelectionInterval(0, 0);

        return Versiones;
    }

//    public String extraerRepositorio(String filePath) {
//        String ruta = "";
//
////List<Student> items = new ArrayList<Student>();
//        try {
//            // First create a new XMLInputFactory
//            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
//            // Setup a new eventReader
//            InputStream in = new FileInputStream(filePath);
//            XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
//            // Read the XML document
//
//            while (eventReader.hasNext()) {
//
//                XMLEvent event = eventReader.nextEvent();
//                if (event.isStartElement()) {
//                    StartElement startElement = event.asStartElement();
//
//                    if (event.asStartElement().getName().getLocalPart().equals("ruta")) {
//                        event = eventReader.nextEvent();
//                        ruta = event.asCharacters().getData();
//                        continue;
//                    }
//
//                }
//
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (XMLStreamException e) {
//            e.printStackTrace();
//        }
//        return ruta;
//
//
//    }

//    public void cargarVersiones(String ruta, JTable tablaV) {
//        DefaultTableModel modelo = new DefaultTableModel() {
//
//            @Override
//            public boolean isCellEditable(int row, int column) {
//                //Only the third column
//                return false;
//            }
//        };
//
//        modelo.addColumn("Versiones");
//        File archivos[] = new File(ruta).listFiles();
//        ArrayList<String> vers = new ArrayList<String>(archivos.length);
//        String version = "";
//        for (int i = 0; i < archivos.length; i++) {
//            if (archivos[i].isDirectory()) {
//                version = archivos[i].toString();
//                version = version.substring(version.length() - 3, version.length());
//                vers.add(version);
//                System.out.println(version);
//            }
//        }
//        int cont = 0;
//        for (int i = vers.size(); i > 0; i--) {
//            modelo.addRow(new Object[]{});
//            modelo.setValueAt(vers.get(i - 1), cont, 0);
//            cont++;
//        }
//
//        tablaV.setModel(modelo);
//        TableColumn columnita = tablaV.getColumn("Versiones");
//        columnita.setPreferredWidth(295);
//    }

    public String leerVersionActual() throws FileNotFoundException, IOException {
        File archivo = new File("C:\\Users\\Usuario\\Dropbox\\DisenoSistema\\ActualizadorV1.0\\src\\version.txt");
        FileReader fileR = new FileReader(archivo);
        BufferedReader bufferR = new BufferedReader(fileR);
        versionTXT = bufferR.readLine();
        System.out.println(bufferR.readLine());
        return versionTXT;

    }
//VerificarRepositorio(): Boolean
//
}
