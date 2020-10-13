package jireh;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.sql.*;
import java.awt.Image;
import java.util.Iterator;
import javax.swing.JOptionPane;

/**
 * @web http://jc-mouse.blogspot.com/
 * @author Mouse
 */
public class SQL {

    ConexionAccess con;
    private Image data;

    public SQL() {
        con = new ConexionAccess();
    }

    /* Guarda la los datos de un alumno junto con una
    imagen JPG en el campo OLE de Access */
    public boolean agregarAlumno(String id, String foto, String nom, String ape, String dir, String fec, String pme, String tel, String obs) {
        boolean ok = false;
        FileInputStream fis = null;
        try {
            int row_update = 0;
            File file = new File(foto);
            fis = new FileInputStream(file);
            PreparedStatement pstm = con.getConnection().prepareStatement("insert into Alumno(Id, Foto, Nombres, Apellidos, Direccion, Fecha, PME, Telefono, Observaciones) values(?,?,?,?,?,?,?,?,?);");
            pstm.setString(1, id);
            pstm.setBinaryStream(2, fis, (int) file.length());
            pstm.setString(3, nom);
            pstm.setString(4, ape);
            pstm.setString(5, dir);
            pstm.setString(6, fec);
            pstm.setString(7, pme);
            pstm.setString(8, tel);
            pstm.setString(9, obs);
            pstm.execute();
            pstm.close();
            row_update = pstm.executeUpdate();
            if (row_update == 1) {
                JOptionPane.showMessageDialog(null, "SI");
            } else {
                JOptionPane.showMessageDialog(null, "NO");
            }
            ok = true;
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
        return ok;
    }
    //metodo que dada una cadena de bytes la convierte en una imagen con extension jpeg
    private Image ConvertirImagen(byte[] bytes) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        Iterator readers = ImageIO.getImageReadersByFormatName("jpeg");
        ImageReader reader = (ImageReader) readers.next();
        Object source = bis;
        ImageInputStream iis = ImageIO.createImageInputStream(source);
        reader.setInput(iis, true);
        ImageReadParam param = reader.getDefaultReadParam();
        return reader.read(0, param);
    }


    //metodo  que dado un parametro "id" realiza una consulta y devuelve como resultado
// una imagen
    public Image getfoto(String id) {
        try {
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT "
                    + " Foto "
                    + " FROM tImagenes "
                    + " where id = ? ");
            pstm.setString(1, id);
            ResultSet res = pstm.executeQuery();
            int i = 0;
            while (res.next()) {
                //se lee la cadena de bytes de la base de datos
                byte[] b = res.getBytes("Foto");
                // esta cadena de bytes sera convertida en una imagen
                data = ConvertirImagen(b);
                i++;
            }
            res.close();
        } catch (IOException ex) {
            System.out.println(ex);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return data;
    }
}
